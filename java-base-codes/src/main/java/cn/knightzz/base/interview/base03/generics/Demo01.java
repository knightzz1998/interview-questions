package cn.knightzz.base.interview.base03.generics;

/**
 * @author 王天赐
 * @title: Demo01
 * @projectName interview-questions
 * @description: 什么是泛型？有什么作用？
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-28 10:57
 */
public class Demo01 {


    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }


    public static void main(String[] args) {

        // 泛型类
        GenericClass<Integer> genericInteger = new GenericClass<Integer>(123456);
        System.out.println(genericInteger.getKey());

        // 泛型接口
        GeneratorInterfaceImpl generatorInterface = new GeneratorInterfaceImpl();
        System.out.println(generatorInterface.method());

        String[] arr = {"a", "b"};
        printArray(arr);

    }
}
