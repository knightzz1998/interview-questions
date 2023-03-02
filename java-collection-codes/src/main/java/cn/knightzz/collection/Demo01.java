package cn.knightzz.collection;

import java.util.ArrayList;

/**
 * @author 王天赐
 * @title: Demo01
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-03-02 09:58
 */
public class Demo01 {

    public static void main(String[] args) {

        //ArrayList<String> list = new ArrayList<>();
        //list.add("one");
        //list.add("two");
        //list.add("three");
        //list.add("four");
        //list.add("give");
        //
        //System.out.println("原始对象 : " + list);
        //
        //ArrayList clonedLis = (ArrayList) list.clone();
        //
        //System.out.println("拷贝对象 : " + clonedLis);

        System.out.println("=====================================");

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(18, "fun"));
        list.add(new Student(20, "tester"));
        ArrayList<Student> clonedList = (ArrayList) list.clone();
        Student student = clonedList.get(1);
        student.name = "FunTester";
        System.out.println("原始对象 : " + clonedList);
        System.out.println("拷贝对象 : " + list);
    }

    static class Student{
        int age;
        String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
