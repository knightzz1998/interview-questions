package cn.knightzz.mode.action.example01;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author 王天赐
 * @title: SaveMoneyHandler
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-08 10:45
 */
@Slf4j
public class SaveMoneyHandler extends AbstractBusinessHandler {

    private Random random = new Random();

    @Override
    public void handle() {
        log.info("存入 {}元!", random.nextInt(2000));
    }
}
