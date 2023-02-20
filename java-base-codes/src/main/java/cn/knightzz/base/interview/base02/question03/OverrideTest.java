package cn.knightzz.base.interview.base02.question03;

/**
 * @author 王天赐
 * @title: OverrideTest
 * @projectName interview-questions
 * @description: 测试重写
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-20 11:14
 */
@SuppressWarnings("all")
public class OverrideTest {

    // 重载就是同一个类中多个同名方法根据不同的传参来执行不同的逻辑处理

    public int add(int a) {
        return a;
    }

    public int add(int a, int b){
        return a+b;
    }

    // 参数一致, 返回不一致不构成重载, 编译器查找方法是根据 方法名和参数类型查找的
    //public long add(int a, int b){
    //    return 1;
    //}

    //类型一致, 参数名不同, 不构成重载
    //public int add(int b, int a){
    //    return a+b;
    //}

    public int add(int a, long b){
        return (int) (a+b);
    }

    public int add(long b, int a){
        return (int) (a+b);
    }

    // ================================================


    public void say() {

    }

}
