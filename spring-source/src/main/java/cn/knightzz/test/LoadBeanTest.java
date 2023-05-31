package cn.knightzz.test;

import cn.knightzz.entity.User;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author 王天赐
 * @title: LoadBeanTest
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-05-23 14:45
 */
public class LoadBeanTest {

    @Test
    public void test01() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring-application.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
    }
}
