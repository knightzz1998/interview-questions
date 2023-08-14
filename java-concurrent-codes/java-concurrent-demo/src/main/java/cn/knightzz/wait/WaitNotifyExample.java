package cn.knightzz.wait;

import java.util.HashMap;

/**
 * @author 王天赐
 * @title: WaitNotifyExample
 * @description: WaitNotify 代码示例
 * @create: 2023-08-10 10:06
 */
public class WaitNotifyExample {
    public static void main(String[] args) {
        final Object lock = new Object(); // 共享对象作为锁

        // 线程A
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread A is running and waiting...");
                try {
                    lock.wait(); // 线程A等待，释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread A is now resuming.");
            }
        });

        // 线程B
        Thread threadB = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread B is running.");
                try {
                    Thread.sleep(2000); // 模拟一些操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify(); // 通知等待的线程A
                System.out.println("Thread B has notified.");
            }
        });

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is done.");

        HashMap<Integer, Integer> cacheMap = new HashMap<>();

    }
}
