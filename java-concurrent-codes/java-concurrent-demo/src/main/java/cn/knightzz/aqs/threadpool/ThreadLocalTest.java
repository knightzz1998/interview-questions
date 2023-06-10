package cn.knightzz.aqs.threadpool;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 王天赐
 * @title: ThreadLocalTest
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-09 19:02
 */
@SuppressWarnings("all")
@Slf4j
public class ThreadLocalTest {


    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {

            int cur = i + 1;
            new Thread(() -> {
                log.info("current {} , thread : {}", cur, Thread.currentThread().getName());
                threadLocal.set("thread-" + cur);
                log.error("current : {} , local : {}", cur, threadLocal.get());
            }, "t" + cur).start();
        }
    }
}
