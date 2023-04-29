package cn.knightzz.concurrent.aqs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王天赐
 * @title: Test
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-03-10 22:05
 */
@SuppressWarnings("all")
public class Test {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(() -> {
                List<String> list = new ArrayList<>();
                list.add("item1");
                Example example = new Example(list, 2000);
                System.out.println("t1 : " + example.getList());
            }, "t1");
            t1.start();
            Thread t2 = new Thread(() -> {
                List<String> list = new ArrayList<>();
                list.add("item2");
                Example example = new Example(list, 0);
                System.out.println("t2 : " + example.getList());
            }, "t2");
            t2.start();
        }

    }

}

