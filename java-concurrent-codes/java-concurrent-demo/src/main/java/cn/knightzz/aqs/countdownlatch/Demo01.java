package cn.knightzz.aqs.countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 王天赐
 * @title: Demo01
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-08 16:08
 */
@SuppressWarnings("all")
@Slf4j
public class Demo01 {

    public static ConcurrentHashMap<String, Integer> hashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(21);
        CountDownLatch latch = new CountDownLatch(20);

        // 计数器和线程数一样, 等到所有线程执行完成以后, 然后再执行

        threadPool.execute(() -> {
            // 等待计数器为0
            try {
                latch.await();
                log.info("执行完成...");
                hashMap.forEach((k, v) -> {
                    log.info("thread name is {} , count : {} " , k , v);
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        for (int i = 0; i < 5; i++) {
            int cur = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep(1000);
                    log.info("thread running ... ");
                    hashMap.put(Thread.currentThread().getName(), cur);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    // 计数器减一
                    latch.countDown();
                }
            });
        }

        threadPool.shutdown();
        while (!threadPool.isTerminated()) {
        }

        log.info("finish ... ");
    }

}
