package org.rayson.integration;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.rayson.integration.foundation.DBInterceptor;
import org.rayson.integration.foundation.DBPreparation;
import org.rayson.integration.foundation.SequenceNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;
import javax.sql.DataSource;

import static org.mockito.Mockito.when;

/**
 * Created by xubt on 5/14/16.
 */
@ActiveProfiles("local-test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBase {
    @Value("${server.port}")
    protected int port;

    @Value("${server.servlet.path}")
    protected String contextPath;

    protected String userName = "someone";

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
                .setBasePath("/rayson-service")
                .setPort(9120)
                .build();
        RestAssured.requestSpecification = requestSpecification;
        when(sequenceNumber.generate()).thenReturn("fooId");
        ReflectionTestUtils.setField(dbInterceptor, "sequenceNumber", sequenceNumber);
        jdbcTemplate = new JdbcTemplate(dataSource);
        dbPreparation.setJDBCTemplate(jdbcTemplate);
    }

    @After
    public void resetDB() {
        jdbcTemplate.execute("TRUNCATE TABLE kb_board");
        jdbcTemplate.execute("TRUNCATE TABLE kb_stage");
        jdbcTemplate.execute("TRUNCATE TABLE kb_card");
        jdbcTemplate.execute("TRUNCATE TABLE kb_project");
        jdbcTemplate.execute("TRUNCATE TABLE kb_user_profile");
        jdbcTemplate.execute("TRUNCATE TABLE kb_user_registration");
        jdbcTemplate.execute("TRUNCATE TABLE kb_card_assignment");
        jdbcTemplate.execute("TRUNCATE TABLE kb_members");
        jdbcTemplate.execute("TRUNCATE TABLE kb_password_retrieval");
        jdbcTemplate.execute("TRUNCATE TABLE kb_password_reset");
        jdbcTemplate.execute("TRUNCATE TABLE kb_project_member_invitation");
        jdbcTemplate.execute("TRUNCATE TABLE kb_notification");
        jdbcTemplate.execute("TRUNCATE TABLE kb_acceptance_criterias");
        jdbcTemplate.execute("TRUNCATE TABLE kb_comment");
        jdbcTemplate.execute("TRUNCATE TABLE kb_tag");
        jdbcTemplate.execute("TRUNCATE TABLE kb_cards_tags");
        jdbcTemplate.execute("TRUNCATE TABLE kb_activity");
        jdbcTemplate.execute("TRUNCATE TABLE kb_sprint");
        jdbcTemplate.execute("TRUNCATE TABLE kb_page");
    }
}
