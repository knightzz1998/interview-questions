package cn.knightzz.aqs.cyclicbarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 王天赐
 * @title: Example
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-08 17:09
 */
@SuppressWarnings("all")
@Slf4j
public class Example01 {

    // 需要同步的线程数量
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new BarrierAction());

    private static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                try {
                    log.info("执行任务 ... ");
                    Thread.sleep(2000);
                    // 拦住线程, 当拦住的线程达到parties个后才会放行
                    count.incrementAndGet();
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        threadPool.shutdown();

        while (!threadPool.isTerminated()) {
        }
        log.info("system exit !");
    }

    /**
     * 所有拦截的线程放开后执行的方法
     */
    static class BarrierAction implements Runnable {
        @Override
        public void run() {
            log.info("当前任务数 {} , 所有任务全部执行完毕...", count.intValue());
        }
    }
}
