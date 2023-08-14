package cn.knightzz.current.threadlocal.example;

/**
 * @author 王天赐
 * @title: Demo01
 * @description:
 * @create: 2023-08-13 15:33
 */
public class Demo01 {

    public static void main(String[] args) throws InterruptedException {

        Node node01 = new Node("aaa");
        Node node02 = new Node("bbb");


        Thread t1 = new Thread(node01);
        Thread t2 = new Thread(node02);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("end ... ");
    }



}

class Node implements Runnable {

    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private String msg;

    public Node(String msg) {
        this.msg = msg;
        threadLocal.set(msg);
    }

    @Override
    public void run() {
        String message = threadLocal.get();
        System.out.println(message);
    }
}