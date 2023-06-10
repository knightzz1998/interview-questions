package cn.knightzz.threadpool.example_02;

import java.util.concurrent.Callable;

/**
 * @author 王天赐
 * @title: MyCallable
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-05 06:33
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {

        System.out.println("Callable ===> " + Thread.currentThread().getName());
        return Thread.currentThread().getName();
    }
}
