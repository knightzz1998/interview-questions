package cn.knightzz.base.interview.base03.generics;

/**
 * @author 王天赐
 * @title: GenericClass
 * @projectName interview-questions
 * @description: 泛型类
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-28 11:03
 */
public class GenericClass<T> {

    private T key;

    public GenericClass(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}
