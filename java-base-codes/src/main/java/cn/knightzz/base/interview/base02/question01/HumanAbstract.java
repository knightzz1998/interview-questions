package cn.knightzz.base.interview.base02.question01;

/**
 * @author 王天赐
 * @title: HumanAbstract
 * @projectName interview-questions
 * @description: 人类抽象类
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-16 19:43
 */
public abstract class HumanAbstract {


    public void say() {
        System.out.println("HumanAbstract say ....");
    }

    /**
     * 抽象方法不能有方法体, 子类继承后需要实现抽象方法
     * 接口是用来约束类的行为, 而抽象方法主要是为了方法复用
     */
    public abstract void run();
}
