package cn.knightzz.current.threadlocal.hash;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 王天赐
 * @title: ThreadLocalHashDemo
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-10 11:01
 */
@SuppressWarnings("all")
@Slf4j
public class ThreadLocalHashDemo {

    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {

        int hashCode = 0;
        for (int i = 0; i < 16; i++) {
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            int bucket = hashCode & 15;
            log.info("元素 {} 在桶中的位置 {}", i, bucket);
        }

        for (int i = 0; i < 100; i++) {
            log.info("测试 : {} & 15 ==> {}", i, (i & 15));
        }

        // 3 => 0011 , 15 => 1111
        // 0011 & 1111 => 0011
        // 比15大的数, 和15计算事, 因为15前面的位都是0, 所以实际上只有后面的参与计算, 结果自然就是 0~15
    }

}
