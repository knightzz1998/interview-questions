package cn.knightzz.base.interview.base03.exception;

/**
 * @author 王天赐
 * @title: Demo03
 * @projectName interview-questions
 * @description: finally 中的代码一定会执行吗
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-28 10:35
 */
public class Demo03 {

    public static void main(String[] args) {

        try {
            System.out.println("Try to do something");
            throw new RuntimeException("RuntimeException");
        } catch (Exception e) {
            System.out.println("Catch Exception -> " + e.getMessage());
            // 终止当前正在运行的Java虚拟机
            System.exit(1);
        } finally {
            System.out.println("Finally");
        }

    }
}
