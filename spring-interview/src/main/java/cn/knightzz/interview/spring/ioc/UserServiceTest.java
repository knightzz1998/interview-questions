package cn.knightzz.interview.spring.ioc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 王天赐
 * @title: UserControllerTest
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-29 14:49
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-application.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveTest() {
        User user = new User("moke", 20);
        userService.save(user);
    }

}
