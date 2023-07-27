package cn.knightzz.collection.map;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author 王天赐
 * @title: HashMapDemo
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-07-04 20:16
 */
public class HashMapDemo {

    public static void main(String[] args) {

        TreeMap<String, Integer> data = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            data.put(String.valueOf(i), i);
        }


        HashMap<String, Integer> map = new HashMap<>();
        map.putAll(data);

    }
}
