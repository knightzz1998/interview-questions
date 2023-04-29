package cn.knightzz.mapper;

import cn.knightzz.entity.Account;
import org.apache.ibatis.annotations.Param;

/**
 * @author 王天赐
 * @title: AccountMapper
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-29 19:25
 */
public interface AccountMapper {

    /**
     * 插入账户
     *
     */
    void insertAccount(Account account);

    /**
     * 根据id查询账户数据
     * @param id
     * @return
     */
    Account findAccountById(long id);

    /**
     * 转账
     * @param name
     * @param money
     * @return
     */
    int transferMoney(@Param("name") String name, @Param("money") double money);

    int updateBalance(@Param("name") String name, @Param("balance") double balance);
}
