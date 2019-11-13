package mobi.rayson.sourcecode.spring.beanfactorypostprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("自定义 Bean factory post processor");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("student");
        beanDefinition.getPropertyValues().add("name", "lee");
    }
}
