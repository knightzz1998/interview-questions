package cn.knightzz.base.interview.base03.annotation;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * @author 王天赐
 * @title: ScanMyAnnotation
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-02-28 11:50
 */
public class ScanMyAnnotation {

    public static void main(String[] args) throws IOException {

        String packageName = "cn.knightzz.base.interview.base03.annotation";
        String packageDirName = packageName.replace(".", "/");
        Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(packageDirName);

        ArrayList<String> classNameList = new ArrayList<>();

        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(url);
            File dir = new File(url.getPath());
            // 获取当前目录下所有文件
            System.out.println("当前包下所有的class文件 ======> ");
            File[] files = dir.listFiles(new FileFilter() {

                @Override
                public boolean accept(File pathname) {

                    if (pathname.getName().endsWith(".class")) {

                        String className = pathname.getName().substring(0, pathname.getName().length() - 6);
                        classNameList.add(packageName + "." + className);
                        System.out.println(packageName + "." + className);
                        return true;
                    }
                    return false;
                }
            });
            System.out.println("带有MyAnnotation注解的类 : ====> ");
            classNameList.forEach((className) -> {

                try {
                    Class<?> classz = Class.forName(className);

                    // 判断当前类是否被 MyAnnotation注解
                    MyAnnotation annotation = classz.getAnnotation(MyAnnotation.class);
                    if (annotation != null) {
                        System.out.println(packageName);
                    }

                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }


            });


        }


    }

}
