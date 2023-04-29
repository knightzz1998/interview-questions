package cn.knightzz.service;

import cn.knightzz.mapper.AccountMapper;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 王天赐
 * @title: AccountServiceTest
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-29 20:30
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AccountServiceTest extends TestCase {

    @Autowired
    AccountService service;

    @Autowired
    AccountMapper accountMapper;

    @Test
    public void reset() {
        accountMapper.updateBalance("小明", 5000);
        accountMapper.updateBalance("小红", 5000);
    }

    @Test
    public void testTransfer() {

        service.transfer("小红", "小明", 100);

    }
}