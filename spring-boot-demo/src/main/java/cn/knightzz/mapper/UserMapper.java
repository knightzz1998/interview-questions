package cn.knightzz.mapper;

import cn.knightzz.entity.User;

import java.util.List;

/**
 * @author 王天赐
 * @title: UserMapper
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-30 20:38
 */
public interface UserMapper {
    /**
     * 查询所有的用户
     * @return 所有用户列表
     */
    List<User> findAllUsers();
}
