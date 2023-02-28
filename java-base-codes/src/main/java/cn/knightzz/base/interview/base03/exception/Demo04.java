package cn.knightzz.base.interview.base03.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author 王天赐
 * @title: Demo04
 * @projectName interview-questions
 * @description: 如何使用 try-with-resources 代替try-catch-finally？
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-28 10:41
 */
public class Demo04 {

    public static void test01() {
        //. Java 中类似于InputStream、OutputStream 、Scanner 、PrintWriter等的资源都需要我们调用close()方法来手动关闭，
        // 一般情况下我们都是通过try-catch-finally语句来实现这个需求，如下：
        //读取文本文件的内容
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("java-base-codes/src/main/resources/read.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 这里需要在 final中关闭
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void test02() {
        // 使用 Java 7 之后的 try-with-resources 语句改造上面的代码:
        try (Scanner scanner = new Scanner(new File("java-base-codes/src/main/resources/read.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    public static void main(String[] args) {

        test01();

        test02();

    }
}
