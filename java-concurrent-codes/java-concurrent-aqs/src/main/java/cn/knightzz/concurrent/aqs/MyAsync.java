package cn.knightzz.concurrent.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author 王天赐
 * @title: MyAsync
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-27 16:40
 */
public class MyAsync extends AbstractQueuedSynchronizer {

    /**
     * 尝试独占锁
     * @param arg 获取参数。该值始终是传递给获取方法的值，或者是进入条件等待时保存的值
     * @return 是否成功获取锁
     */
    @Override
    protected boolean tryAcquire(int arg) {
        // 判断当前 state 是否 == 0 , 如果 等于0, 说明锁还没被别的线程占用
        // 如果不等于0. 说明已经被其他线程占用
        if (compareAndSetState(0, 1)) {
            // 设置当前线程为锁拥有线层, 设置 state = 1
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        // 设置拥有锁的线程为null, 表示没有线程占用锁
        setExclusiveOwnerThread(null);
        // 设置state=0
        setState(0);
        return true;
    }

    public void lock() {
        // 以独占模式获取锁
        acquire(1);
    }

    public void unlock() {
        // 释放锁
        release(1);
    }
}
