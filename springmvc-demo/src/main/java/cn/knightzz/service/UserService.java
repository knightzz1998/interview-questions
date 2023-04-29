package cn.knightzz.service;

import cn.knightzz.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author 王天赐
 * @title: UserService
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-29 16:02
 */
@Service
public class UserService {

    public User getUserById(Integer id) {
        return new User(id, "张三", 18);
    }
}
