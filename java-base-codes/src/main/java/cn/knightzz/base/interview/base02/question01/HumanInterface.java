package cn.knightzz.base.interview.base02.question01;

/**
 * @author 王天赐
 * @title: HumanInerface
 * @projectName interview-questions
 * @description: 人类接口
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-16 19:46
 */
public interface HumanInterface {

    /**
     * 接口中的成员变量只能是 public static final 类型的，不能被修改且必须有初始值
     */
    public static final String name = null;

    /**
     * 接口主要是用来约束
     */
    void write();

    /**
     * 阅读的默认方法
     */
    default void read() {
        System.out.println("HumanInterface default read ... ");
    }
}
