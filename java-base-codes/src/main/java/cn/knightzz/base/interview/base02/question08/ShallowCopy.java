package cn.knightzz.base.interview.base02.question08;

/**
 * @author 王天赐
 * @title: ShallowCopy
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-24 15:26
 */
public class ShallowCopy {

    public static void main(String[] args) {

        Person person1 = new Person(new Address("武汉"));
        Person person1Copy = person1.clone();
        System.out.println(person1.getAddress() == person1Copy.getAddress());

    }

}

