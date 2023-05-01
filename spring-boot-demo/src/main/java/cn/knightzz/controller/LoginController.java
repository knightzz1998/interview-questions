package cn.knightzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 王天赐
 * @title: LoginController
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-30 20:34
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/html/login", method = RequestMethod.GET)
    public String getLogin() {
        return "site/login";
    }

}
