package cn.knightzz.concurrent.hashmap.example;

import java.util.HashMap;

/**
 * @author 王天赐
 * @title: Demo01
 * @description:
 * @create: 2023-08-13 14:42
 */
public class Demo01 {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        Integer aaa = map.get("aaa");
        System.out.println(aaa);

    }
}
