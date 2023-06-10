package cn.knightzz.guava;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author 王天赐
 * @title: Demo01
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-06 11:54
 */
@Slf4j
public class Demo01 {


    public static void main(String[] args) {

        String threadNamePrefix = "Task";
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat(threadNamePrefix + "-%d")
                .setDaemon(true).build();
        ExecutorService threadPool = new ThreadPoolExecutor(5, 10, 1L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
                threadFactory);

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("....");
                log.info("{}", Thread.currentThread().getName());
            });
        }
        threadPool.shutdown();
        while (!threadPool.isTerminated()) {
        }
        log.info("Thread Pool finished ... ");
    }

    public synchronized void m1() {
        m2();
    }

    public synchronized void m2() {
    }
}
