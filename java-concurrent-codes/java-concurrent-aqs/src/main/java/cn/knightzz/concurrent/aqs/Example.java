package cn.knightzz.concurrent.aqs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王天赐
 * @title: Example
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-03-10 22:06
 */
public class Example {
    private List<String> list;

    public Example(List<String> list, int sleep) {
        // list = 0xab12f => 0xca32a
        // 其他线程是无法修改 list 这个局部变量的

        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // t1 : 线程 已经 copy 完 elementData 了
        // t2 : 向 list 添加元素
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
