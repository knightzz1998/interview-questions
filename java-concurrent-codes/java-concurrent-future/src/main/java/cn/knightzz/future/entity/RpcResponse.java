package cn.knightzz.future.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author 王天赐
 * @title: RpcResponse
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-11 11:51
 */
@Data
@ToString
public class RpcResponse<T> {

    private T data;
    private String msg;
    private String code;
}
