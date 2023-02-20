package cn.knightzz.base.interview.base02.question04;

/**
 * @author 王天赐
 * @title: TypeCache
 * @projectName interview-questions
 * @description: 包装类型的缓存机制
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-20 11:48
 */
@SuppressWarnings("all")
public class TypeCache {

    // 参考 Java中的为什么要使用包装类，以及包装类与基本数据类型的异同

    // == 操作符
    // 基本数据类型：比较的是他们的值是否相同。
    // 引用数据类型：比较的是他们的内存地址是否同一地址。

    // equals :
    // 默认是继承了 Object 的, 默认是 ==
    // 如果重写了, 就是根据重写后的方法

    public static void main(String[] args) {

        Byte b01 = 12;
        Byte b02 = 12;

        // 这个结果永远都是 true
        System.out.println(b01.equals(b02));

        Integer b03 = 7777;
        Integer b04 = 7777;
        System.out.println(b03 == b04);
    }

}
