package cn.knightzz.aqs.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 王天赐
 * @title: Demo01
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-09 09:57
 */
@SuppressWarnings("all")
@Slf4j
public class Demo01 {

    static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100000000; i++) {
            threadPool.execute(() -> {
                log.info("当前count : {}", count.getAndIncrement());
            });
        }

        // 等待所有任务执行完毕后关闭
        threadPool.shutdown();
        while (!threadPool.isTerminated()) {
        }

        log.info("执行结束, count : {}", count);
    }
}
