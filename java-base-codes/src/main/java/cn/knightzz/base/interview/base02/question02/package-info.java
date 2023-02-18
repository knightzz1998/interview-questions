/**
 * @title: package-info
 * @projectName interview-questions
 * @description: 深拷贝和浅拷贝区别了解吗？什么是引用拷贝？
 * @author 王天赐
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-16 19:58
 */
package cn.knightzz.base.interview.base02.question02;

/**
 * 浅拷贝：浅拷贝会在堆上创建一个新的对象（区别于引用拷贝的一点），
 * 不过，如果原对象内部的属性是引用类型的话，浅拷贝会直接复制内部对象的引用地址，也就是说拷贝对象和原对象共用同一个内部对象。
 * 深拷贝 ：深拷贝会完全复制整个对象，包括这个对象所包含的内部对象。
 *
 */