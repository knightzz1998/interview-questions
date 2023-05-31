package cn.knightzz.service;

/**
 * @author 王天赐
 * @title: UserService
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-05-31 09:57
 */
public class UserService {

    ThreadLocal<String> name = new InheritableThreadLocal<>();

    public void sayHello() {
        System.out.println("hello");
    }

    public String getName() {
        return name.get();
    }

    public void setName(String newName) {
        name.set(newName);
    }
}
