package cn.knightzz.threadpool.example_02;

import java.util.concurrent.*;

/**
 * @author 王天赐
 * @title: CallableTest
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-05 06:32
 */
@SuppressWarnings("all")
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

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

        for (int i = 0; i < 5; i++) {
            MyCallable callable = new MyCallable();
            Future<String> future = executor.submit(callable);
            String s = future.get();
            System.out.println(s);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
