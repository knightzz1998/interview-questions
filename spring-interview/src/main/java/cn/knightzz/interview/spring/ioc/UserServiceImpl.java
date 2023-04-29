package cn.knightzz.interview.spring.ioc;

import org.springframework.stereotype.Service;

/**
 * @author 王天赐
 * @title: UserServiceImpl
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-29 14:47
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void save(User user) {
        System.out.println("Save user: " + user.getName() + ", age: " + user.getAge());
    }
}
