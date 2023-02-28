package cn.knightzz.base.interview.base03.exception;

/**
 * @author 王天赐
 * @title: Demo02
 * @projectName interview-questions
 * @description: Throwable 类常用方法有哪些？
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-28 09:59
 */
public class Demo02 {

    public static void test() {

        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            String localizedMessage = e.getLocalizedMessage();
            System.out.println("localizedMessage = " + localizedMessage);
            System.out.println(e.toString());
        } finally {
        }
    }

    public static void main(String[] args) {

        test();

    }
}
