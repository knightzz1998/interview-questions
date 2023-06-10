package cn.knightzz.aqs.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author 王天赐
 * @title: Demo02
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-09 10:17
 */
@SuppressWarnings("all")
@Slf4j
public class Demo02 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        AtomicIntegerArray array = new AtomicIntegerArray(nums);
        int temvalue = array.getAndSet(0, 2);

        System.out.println("temvalue:" + temvalue + ";  i:" + array);
        temvalue = array.getAndIncrement(0);
        System.out.println("temvalue:" + temvalue + ";  i:" + array);
        temvalue = array.getAndAdd(0, 5);
        System.out.println("temvalue:" + temvalue + ";  i:" + array);
    }
}
