package cn.knightzz.aqs.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 王天赐
 * @title: Demo03
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-09 10:32
 */
@SuppressWarnings("all")
@Slf4j
public class Demo03 {

    public static void main(String[] args) {

        AtomicReference<Person> reference = new AtomicReference<Person>();
        Person person = new Person("SnailClimb", 22);
        reference.set(person);

        // 修改新的类的值
        Person updatePerson = new Person("Daisy", 20);
        reference.compareAndSet(person, updatePerson);
        log.info("nane : {}" , reference.get().getName());
        log.info("age : {}" , reference.get().getAge());
    }
}


