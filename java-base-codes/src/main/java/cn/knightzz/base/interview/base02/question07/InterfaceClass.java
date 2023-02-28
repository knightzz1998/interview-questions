package cn.knightzz.base.interview.base02.question07;

/**
 * @author 王天赐
 * @title: InterfaceClass
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-24 14:59
 */
public interface InterfaceClass {

    abstract void test01();

    default int test02() {
        return 1;
    }


}
