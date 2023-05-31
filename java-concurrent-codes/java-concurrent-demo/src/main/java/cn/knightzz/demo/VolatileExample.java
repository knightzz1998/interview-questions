package cn.knightzz.demo;

/**
 * @author 王天赐
 * @title: VolatileExample
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-05-31 15:14
 */
@SuppressWarnings("all")
public class VolatileExample {
    int x = 0;
    volatile boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v == true) {
            // 这里x会是多少呢？
            System.out.println(x);
        }
    }

    public static void main(String[] args) {

        VolatileExample example = new VolatileExample();

        Thread t1 = new Thread(() -> {
            example.writer();
        }, "t1");

        Thread t2 = new Thread(() -> {
            example.reader();
        }, "t2");

        t1.start();
        t2.start();


    }
}
