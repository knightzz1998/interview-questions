package cn.knightzz.test.jmm;

/**
 * @author 王天赐
 * @title: JMM01
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-05-25 10:44
 */
@SuppressWarnings("all")
public class JMM01 {

    public static void main(String[] args) {

        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("aaa");


    }
}
