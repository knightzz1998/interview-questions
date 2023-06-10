package cn.knightzz.aqs.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 王天赐
 * @title: ThreadLocalTest
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-09 16:44
 */
@SuppressWarnings("all")
@Slf4j
public class ErrorThreadLocalTest {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        // 不能用线程池, 因为线程池中的线程会复用
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        for (int i = 0; i < 30; i++) {

            int cur = i + 1;
            executorService.execute(() -> {
                log.info("current {} , thread : {}", cur, Thread.currentThread().getName());
                threadLocal.set("thread-" + cur);
            });
        }

        for (int i = 0; i < 30; i++) {
            int cur = i + 1;
            executorService.execute(() -> {
                log.error("current : {} , local : {}", cur, threadLocal.get());
            });
        }

        executorService.shutdown();
    }
}
