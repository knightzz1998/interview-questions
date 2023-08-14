package cn.knightzz.concurrent.reentrant.lock.impl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author 王天赐
 * @title: MyReentrantLock
 * @description:
 * @create: 2023-08-14 11:52
 */
public class MyReentrantLock implements Lock {

    private static class Sync extends AbstractQueuedLongSynchronizer {

        @Override
        protected boolean tryAcquire(long arg) {

            // 获取当前线程
            Thread t = Thread.currentThread();

            // 获取当前同步状态
            long state = getState();

            // 判断锁是否已经被获取
            if (state == 0) {
                if (compareAndSetState(0, arg)) {
                    // 设置当前线程为锁出有着
                    setExclusiveOwnerThread(t);
                }
            } else {
                // 判断当前线程是否持有锁
                if (t == getExclusiveOwnerThread()) {
                    // 重入锁
                    setState(state + arg);
                    return true;
                }
            }
            return false;
        }

        /**
         * 释放锁不存在并发问题, 所以不需要考虑.. 获取锁时是存在并发的
         * @param arg the release argument. This value is always the one
         *        passed to a release method, or the current state value upon
         *        entry to a condition wait.  The value is otherwise
         *        uninterpreted and can represent anything you like.
         * @return
         */
        @Override
        protected boolean tryRelease(long arg) {

            long state = getState() - arg;

            Thread t = Thread.currentThread();
            // 判断当前线程是否持有锁
            if (t != getExclusiveOwnerThread()) {
                throw new IllegalMonitorStateException("Not owner");
            }

            // 释放锁
            boolean free = false;
            if (state == 0) {
                // 说明已经释放成功
                setExclusiveOwnerThread(null);
                free = true;
            }
            setState(state);
            return free;
        }
    }

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        // AQS 维护了一个 state 的信号量
        // 获取锁 = 让 state + 1
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
