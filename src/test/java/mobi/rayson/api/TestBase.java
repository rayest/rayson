package mobi.rayson.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import mobi.rayson.api.foundation.DBInterceptor;
import mobi.rayson.api.foundation.DBPreparation;
import mobi.rayson.api.foundation.SequenceNumber;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;
import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by xubt on 5/14/16.
 */
@ActiveProfiles("local-test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestBase {

    @LocalServerPort
    protected int port;

    @Autowired
    protected DataSource dataSource;

    @Autowired
    protected DBPreparation dbPreparation;
    protected JdbcTemplate jdbcTemplate;
    protected SequenceNumber sequenceNumber = Mockito.mock(SequenceNumber.class);
    protected RequestSpecification requestSpecification;

    @Resource
    private DBInterceptor dbInterceptor;

    @Before
    public void setUp() throws Exception {
        requestSpecification = new RequestSpecBuilder()
                .addHeader("identification", "no")
                .addHeader("authentication", "no")
                .setPort(port)
                .build();
        RestAssured.requestSpecification = requestSpecification;
        when(sequenceNumber.generate()).thenReturn("fooId");
        ReflectionTestUtils.setField(dbInterceptor, "sequenceNumber", sequenceNumber);
        jdbcTemplate = new JdbcTemplate(dataSource);
        dbPreparation.setJDBCTemplate(jdbcTemplate);
    }

    @After
    public void resetDB() {

        jdbcTemplate.execute("TRUNCATE TABLE kb_page");
        jdbcTemplate.execute("TRUNCATE TABLE rayson_user");
    }

    @Test
    public void test() {
        assertEquals(1,1);
    }
}
