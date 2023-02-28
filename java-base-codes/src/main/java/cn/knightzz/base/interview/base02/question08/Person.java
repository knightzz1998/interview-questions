package cn.knightzz.base.interview.base02.question08;

/**
 * @author 王天赐
 * @title: Person
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-24 15:27
 */
public class Person implements Cloneable {
    private Address address;
    // 省略构造函数、Getter&Setter方法


    public Person() {
    }

    public Person(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Person clone() {
        try {
            Person person = (Person) super.clone();
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
