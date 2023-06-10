package cn.knightzz.mode.action.example01;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author 王天赐
 * @title: AbstractBusinessHandler
 * @projectName interview-questions
 * @description: 模板方法
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-08 10:41
 */
@Slf4j
public abstract class AbstractBusinessHandler {

    private Random random = new Random();

    public void execute() {
        getNumber();
        handle();
        judge();
    }


    /**
     * 取号
     * @return
     */
    private void getNumber() {
        log.info("取到号牌 : number-00-{}" , random.nextInt());
    }

    /**
     * 办理业务
     */
    public abstract void handle(); //抽象的办理业务方法，由子类实现

    /**
     * 评价
     */
    private void judge() {
        log.info("给与评价 !");
    }
}
