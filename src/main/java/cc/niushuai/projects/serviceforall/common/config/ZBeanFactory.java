package cc.niushuai.projects.serviceforall.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * 容器内bean名称打印组件
 *
 * @author niushuai
 * @date: 2022/4/1 11:51
 */
@Slf4j
@Configuration
public class ZBeanFactory implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.trace("Initializing Spring Bean >>> '" + beanName + "' Succeed");
        return bean;
    }
}