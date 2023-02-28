package cn.knightzz.base.interview.base02.question05;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author 王天赐
 * @title: BigDecimalTest
 * @projectName interview-questions
 * @description: 如何解决浮点数运算的精度丢失问题？
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-24 11:17
 */
public class BigDecimalTest {

    // BigDecimal 可以实现对浮点数的运算，不会造成精度丢失。通常情况下，
    // 大部分需要浮点数精确运算结果的业务场景（比如涉及到钱的场景）都是通过 BigDecimal 来做的。
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        // a - b
        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);

        System.out.println(x);
        System.out.println(y);
        System.out.println(Objects.equals(x, y));
    }


}


