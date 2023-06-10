package cn.knightzz.current.threadlocal.demo;

import cn.knightzz.current.threadlocal.apply.RpcContext;

/**
 * @author 王天赐
 * @title: Demo01
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-28 16:25
 */
@SuppressWarnings("all")
public class Demo01 {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            RpcContext.setRpcFuture("t1");
            String rpcFuture = RpcContext.getRpcFuture();
            System.out.println("t1 => " + rpcFuture);

        }, "t1");

        Thread t2 = new Thread(() -> {
            RpcContext.setRpcFuture("t2");
            String rpcFuture = RpcContext.getRpcFuture();
            System.out.println("t2 => " + rpcFuture);

            Thread children = new Thread(() -> {
                String childrenFuture = RpcContext.getRpcFuture();
                //继承父类的数据
                System.out.println("t2.children => " + rpcFuture); // t2.children => t2:t2
            }, "t2.children");

            children.start();

        }, "t2");

        Thread t3 = new Thread(() -> {
            String rpcFuture = RpcContext.getRpcFuture();
            System.out.println("t3 => " + rpcFuture); // null

        }, "t3");

        t1.start();
        t2.start();
        t3.start();
    }

}
