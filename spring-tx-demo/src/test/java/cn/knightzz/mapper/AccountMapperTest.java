package cn.knightzz.mapper;

import cn.knightzz.entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 王天赐
 * @title: AccountMapperTest
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-29 19:34
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AccountMapperTest {

    @Autowired
    AccountMapper accountMapper;

    @Test
    public void testInsertAccount() {
        Account account = new Account();
        account.setName("方源");
        account.setBalance(339.2);

        accountMapper.insertAccount(account);

        System.out.println(account);
    }

    @Test
    public void testFindAccountById() {
        Account account = accountMapper.findAccountById(1);
        System.out.println(account);
    }
}