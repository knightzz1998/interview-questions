package cn.knightzz.entity;

import lombok.*;

/**
 * @author 王天赐
 * @title: User
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-29 16:03
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    int id;
    String name;
    int age;
}
