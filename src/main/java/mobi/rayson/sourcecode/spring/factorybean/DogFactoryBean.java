package mobi.rayson.sourcecode.spring.factorybean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component()
public class DogFactoryBean implements FactoryBean<Dog> {

    private Dog dog;

    @Override
    public Dog getObject() throws Exception {
        return dog;
    }

    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
