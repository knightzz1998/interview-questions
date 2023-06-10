package cn.knightzz.threadpool.example_03;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author 王天赐
 * @title: Example01
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-06 09:18
 */
@Slf4j
public class Example01 {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10,
                1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(6));

        for (int i = 0 ; i < 10 ; i++) {
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 100; i1++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        log.info("{}" , Thread.currentThread().getName());
                    }
                }
            };
            threadPool.execute(runnable);
        }

        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(
                1,
                createThreadFactory()
                );
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            log.info("=========================");
            log.info("ThreadPool Size: [{}]", threadPool.getPoolSize());
            log.info("Active Threads: {}", threadPool.getActiveCount());
            log.info("Number of Tasks : {}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
            log.info("=========================");
        }, 0, 1, TimeUnit.SECONDS);

    }

    private static ThreadFactory createThreadFactory() {
        return new ThreadFactory() {
            private int counter = 1;

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("MyThread-" + counter++);
                return thread;
            }
        };
    }
}
