package cn.knightzz.base.interview.base02.question05;

import java.math.BigInteger;

/**
 * @author 王天赐
 * @title: BigIntegerTest
 * @projectName interview-questions
 * @description: 超过 long 整型的数据应该如何表示？
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-24 11:24
 */
@SuppressWarnings("all")
public class BigIntegerTest {

    public static void main(String[] args) {

        long l = Long.MAX_VALUE;
        System.out.println(l + 1); // -9223372036854775808
        System.out.println(l + 1 == Long.MIN_VALUE); // true

        // BigInteger 内部使用 int[] 数组来存储任意大小的整形数据。
        // 相对于常规整数类型的运算来说，BigInteger 运算的效率会相对较低

        BigInteger a = new BigInteger(String.valueOf(Long.MAX_VALUE));
        BigInteger b = new BigInteger(String.valueOf(Long.MAX_VALUE));
        System.out.println(a.add(b)); // 18446744073709551614
    }
}
