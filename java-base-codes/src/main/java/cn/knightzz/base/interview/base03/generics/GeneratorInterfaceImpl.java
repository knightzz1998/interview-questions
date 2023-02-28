package cn.knightzz.base.interview.base03.generics;

/**
 * @author 王天赐
 * @title: GeneratorInterfaceImpl
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-28 11:10
 */
public class GeneratorInterfaceImpl implements GeneratorInterface<String>{

    @Override
    public String method() {
        return "hello";
    }
}
