package cn.knightzz.threadpool.example_02;

import cn.knightzz.threadpool.example_01.MyRunnable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 王天赐
 * @title: Example01
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-05 07:22
 */
@SuppressWarnings("all")
public class Example01 {

    public static void main(String[] args) {

        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                // 空闲线程的最大存活时间
                1L, TimeUnit.SECONDS,
                // 阻塞队列
                new ArrayBlockingQueue(100),
                // 拒绝策划略
                new ThreadPoolExecutor.CallerRunsPolicy());

        MyRunnable runnable = new MyRunnable("aaa");

        executor.execute(runnable);

        MyCallable callable = new MyCallable();
        executor.submit(callable);

        executor.shutdown();

        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
