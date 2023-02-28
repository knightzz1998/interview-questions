package cn.knightzz.base.interview.base02.question07;

/**
 * @author 王天赐
 * @title: Test
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-24 14:59
 */
public class Test extends AbstractClass implements InterfaceClass {

    public static void main(String[] args) {
        // 1. 接口和抽象类都不可以被实例化

        Test test = new Test();

        test.abs01();

    }

    @Override
    public int abs01() {
        return super.abs01();
    }

    @Override
    public void test01() {

    }

    @Override
    public int test02() {
        return InterfaceClass.super.test02();
    }

    @Override
    public int abs02() {
        return 0;
    }
}
