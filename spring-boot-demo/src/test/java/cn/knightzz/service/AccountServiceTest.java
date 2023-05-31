package cn.knightzz.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 王天赐
 * @title: AccountServiceTest
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-05-31 11:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Resource
    AccountService accountService;

    @Test
    public void test() {

        System.out.println(accountService.classLoader);
        System.out.println(accountService.beanName);
        System.out.println(accountService.beanFactory);

    }

}