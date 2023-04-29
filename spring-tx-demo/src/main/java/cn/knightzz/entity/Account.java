package cn.knightzz.entity;

import lombok.*;

/**
 * @author 王天赐
 * @title: Account
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-29 19:29
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    Long id;
    String name;
    Double balance;

}
