package cn.knightzz.utils.col.example;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author 王天赐
 * @title: JolExample01
 * @description:
 * @create: 2023-08-14 10:57
 */
public class JolExample01 {

    public static void main(String[] args) throws InterruptedException {

        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        // -XX:+UseBiasedLocking : 默认是 true 启用偏向锁
        // JVM 默认在启动4s 以后的对象设置偏向锁, 因为JVM启动时会加载很多对象, 如果都加偏向锁, 就会损耗性能, 所以做了一个优化 4s 以后加载的类是默认设置偏向锁
        // -XX:BiasedLockingStartupDelay : 该参数指定偏向锁延迟启动的时间，单位是毫秒。默认情况下，偏向锁会在JVM启动后的4秒后才开始生效。可以通过设置该参数来调整延迟的时间。
        Thread.sleep(5000);

        Object o2 = new Object();

        System.out.println(ClassLayout.parseInstance(o2).toPrintable());

//        synchronized (o) {
//            System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        }
    }
}
