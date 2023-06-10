package cn.knightzz.aqs.semaphore;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * @author 王天赐
 * @title: Demo01
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-08 11:05
 */
@SuppressWarnings("all")
@Slf4j
public class Demo01 {

    public static void main(String[] args) throws InterruptedException {

        // 初始共享资源数量
        final Semaphore semaphore = new Semaphore(5);
        for (int i = 1; i < 100; i++) {
            new Thread(() -> {
                // 获取1个许可
                try {
                    semaphore.acquire();
                    log.info("当前剩余凭证数 : {}" , semaphore.availablePermits());
                    if(semaphore.availablePermits() == 0) {
                        Thread.sleep(5000);
                        log.info("\n ===============================================================");
                    }else {
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    // 释放1个许可
                    semaphore.release();
                }

            }, "t-" + i).start();
        }
        while (semaphore.getQueueLength() != 0) {
        }
    }

}
