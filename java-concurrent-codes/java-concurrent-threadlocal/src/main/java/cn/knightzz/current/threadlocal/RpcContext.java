package cn.knightzz.current.threadlocal;

/**
 * @author 王天赐
 * @title: RpcContext
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-28 16:25
 */
public class RpcContext {

    public static final InheritableThreadLocal<String> RPC_FUTURE_INHERITABLE_THREAD_LOCAL = new InheritableThreadLocal<>();

    public static void setRpcFuture(String future) {
        RPC_FUTURE_INHERITABLE_THREAD_LOCAL.set(future + ":" + Thread.currentThread().getName());
    }

    public static String getRpcFuture() {
        Thread thread = Thread.currentThread();

        System.out.println(thread.getName() + " ----> " + thread);
        return RPC_FUTURE_INHERITABLE_THREAD_LOCAL.get();
    }
}
