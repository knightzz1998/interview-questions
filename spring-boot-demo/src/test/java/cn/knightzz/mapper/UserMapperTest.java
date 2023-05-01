package cn.knightzz.mapper;


import cn.knightzz.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王天赐
 * @title: UserMapperTest
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-30 20:57
 */
@SpringBootTest
public class UserMapperTest{

    @Resource
    UserMapper userMapper;

    @Test
    void testFindAllUsers() {
        List<User> users = userMapper.findAllUsers();
        System.out.println(users);
    }
}