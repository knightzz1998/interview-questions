package cn.knightzz.base.interview.base03.generics;

/**
 * @author 王天赐
 * @title: GeneratorInterface
 * @projectName interview-questions
 * @description: 泛型接口
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-28 11:05
 */
public interface GeneratorInterface<T> {

    // 泛型是为了规范类的行为
    public T method();
}

