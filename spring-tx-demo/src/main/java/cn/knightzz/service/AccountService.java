package cn.knightzz.service;

import cn.knightzz.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 王天赐
 * @title: AccountService
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-29 20:17
 */
@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Transactional
    public void transfer(String source, String target, double money) {
        accountMapper.transferMoney(source, -money);
        int i = 1 / 0;
        accountMapper.transferMoney(target, money);
    }
}
