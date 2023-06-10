package cn.knightzz.current.threadlocal.demo;

import java.lang.reflect.Field;

/**
 * @author 王天赐
 * @title: ThreadLocalDemo
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-09 19:37
 */
@SuppressWarnings("all")
public class ThreadLocalDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        Thread t = new Thread(() -> test("abc", false));
        t.start();
        t.join();
        System.out.println("--gc后--");
        Thread t2 = new Thread(() -> test("def", true));
        t2.start();
        t2.join();
    }

    private static void test(String s, boolean isGC) {
        try {
            // 创建一个匿名ThreadLocal对象并设置值为s , 注意 这里的 ThreadLocal 是没有任何对象引用的, 垃圾回收时会被回收的
            // new ThreadLocal<>().set(s);
            ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
            objectThreadLocal.set(s);

            if (isGC) {
                // 手动GC
                System.gc();
            }

            // 获取当前线程的引用
            Thread t = Thread.currentThread();

            // 获取当前线程的Class对象
            Class<? extends Thread> clz = t.getClass();

            // 通过反射获取Thread类中名为threadLocals的字段
            // Thread => ThreadLocal.ThreadLocalMap threadLocals = null;
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);

            // 获取当前线程的线程局部变量表 ThreadLocalMap
            Object ThreadLocalMap = field.get(t);

            // 获取线程局部变量表的Class对象
            Class<?> tlmClass = ThreadLocalMap.getClass();

            // 获取线程局部变量表中名为table的字段
            // static class Entry extends WeakReference<ThreadLocal<?>> {}
            // ThreadLocal.ThreadLocalMap ==> private Entry[] table;
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);

            // 获取线程局部变量表中的条目数组
            // 获取给定对象中该字段的值
            // obj参数是包含该字段的对象实例
            Object[] arr = (Object[]) tableField.get(ThreadLocalMap);

            // 遍历线程局部变量表中的条目
            // arr 就是 table 中存储的Entry类型的数据
            // Entry(ThreadLocal<?> k, Object v) {
            //    super(k);
            //    value = v;
            // }
            for (Object o : arr) {
                // 检查条目是否为空
                if (o != null) {
                    // 获取条目的Class对象
                    Class<?> entryClass = o.getClass();

                    // 获取条目中名为value的字段
                    Field valueField = entryClass.getDeclaredField("value");

                    // 获取条目中超类的超类中名为referent的字段
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");

                    // 设置字段可访问
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);

                    // 输出弱引用的key和值
                    System.out.println(String.format("弱引用key:%s, 值:%s", referenceField.get(o), valueField.get(o)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
