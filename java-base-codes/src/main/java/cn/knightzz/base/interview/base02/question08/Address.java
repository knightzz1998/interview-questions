package cn.knightzz.base.interview.base02.question08;

/**
 * @author 王天赐
 * @title: Address
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-24 15:27
 */
public class Address implements Cloneable {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address(String name) {
        this.name = name;
    }

    // 省略构造函数、Getter&Setter方法
    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
