package cn.knightzz.controller;

import cn.knightzz.entity.User;
import cn.knightzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 王天赐
 * @title: ExceptionController
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-29 16:00
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/{id}")
    public ModelAndView getUser(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("user");
        return mv;
    }
}
