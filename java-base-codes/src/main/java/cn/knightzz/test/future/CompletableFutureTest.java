package cn.knightzz.test.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * @author 王天赐
 * @title: CompletableFutureTest
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-05-29 14:45
 */
@Slf4j
public class CompletableFutureTest {

    public static void main(String[] args) {

        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                log.info("任务一启动 ...............");
                Thread.sleep(2000);
                log.info("任务一执行完毕 ...............");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "任务一";
        });

        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                log.info("任务二启动 ...............");
                Thread.sleep(3000);
                log.info("任务二执行完毕 ...............");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "任务二";
        });

        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> {
            try {
                log.info("任务二启动 ...............");
                Thread.sleep(1000);
                log.info("任务二执行完毕 ...............");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "任务二";
        });

        CompletableFuture<Void> headerFuture = CompletableFuture.allOf(task1, task2, task3);

        headerFuture.join();
        System.out.println("all done. ");

    }
}
