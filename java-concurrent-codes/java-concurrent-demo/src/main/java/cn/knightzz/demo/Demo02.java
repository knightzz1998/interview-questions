package cn.knightzz.demo;

/**
 * @author 王天赐
 * @title: Demo02
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-04 16:08
 */
@SuppressWarnings("all")
public class Demo02 {


    public static void main(String[] args) {

        Object lock = new Object();

        Thread t1 = new Thread(() -> {

            synchronized (lock) {
                int i = 0;
                i++;
            }
        }, "t1");

        t1.start();

    }
}
