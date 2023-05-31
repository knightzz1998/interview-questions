package cn.knightzz.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

/**
 * @author 王天赐
 * @title: AccountService
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-05-31 10:49
 */
@Slf4j
@Component
public class AccountService implements BeanFactoryAware, BeanNameAware, BeanClassLoaderAware, InitializingBean, DisposableBean {

    ClassLoader classLoader;

    BeanFactory beanFactory;

    String beanName;

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("执行 setBeanClassLoader .........");
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("执行 setBeanFactory .........");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        log.info("执行 setBeanName .........");
        this.beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("执行 afterPropertiesSet .........");
    }

    @Override
    public void destroy() throws Exception {
        log.info("执行 destroy .........");
    }
}
