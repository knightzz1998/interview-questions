package cn.knightzz.base.interview.question;

import org.junit.Test;

/**
 * @author 王天赐
 * @title: operator
 * @projectName interview-questions
 * @description: 运算符
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-16 09:15
 */
public class OperatorTest {

    /**
     * 如果移位的位数超过数值所占有的位数会怎样？
     */
    @Test
    public void test01() {
        int i = -1;
        System.out.println("初始数据： " + i);
        System.out.println("初始数据对应的二进制字符串： " + Integer.toBinaryString(i));
        i <<= 10;
        System.out.println("左移 10 位后的数据 " + i);
        System.out.println("左移 10 位后的数据对应的二进制字符 " + Integer.toBinaryString(i));



    }

    /**
     * 由于左移位数大于等于 32 位操作时，会先求余（%）后再进行左移操作，
     * 所以下面的代码左移 42 位相当于左移 10 位（42%32=10），输出结果和前面的代码一样。
     */
    @Test
    public void test02() {

        System.out.println("当 int 类型左移/右移位数大于等于 32 位操作时，会先求余（%）后再进行左移/右移操作 : ");

        int i = -1;
        System.out.println("初始数据： " + i);
        System.out.println("初始数据对应的二进制字符串： " + Integer.toBinaryString(i));
        i <<= 42;
        System.out.println("左移 10 位后的数据 " + i);
        System.out.println("左移 10 位后的数据对应的二进制字符 " + Integer.toBinaryString(i));

    }
}
