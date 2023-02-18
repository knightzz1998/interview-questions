package cn.knightzz.base.interview.base02.question01;

/**
 * @author 王天赐
 * @title: Demo01
 * @projectName interview-questions
 * @description: 测试抽象类和接口
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-16 19:42
 */
public class Question01 extends HumanAbstract implements HumanInterface{
    @Override
    public void run() {
        System.out.println("Question01 run ... ");
    }

    @Override
    public void write() {
        System.out.println("Question01 write ... ");
    }
}
