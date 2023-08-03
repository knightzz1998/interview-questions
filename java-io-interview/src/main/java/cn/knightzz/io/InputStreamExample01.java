package cn.knightzz.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample01 {

    public static void main(String[] args) {

        String path = InputStreamExample01.class.getClassLoader().getResource("a.txt").getPath();

        try (InputStream fis = new FileInputStream(path)) {
            System.out.println("Number of remaining bytes:" + fis.available());

            int content;
            // skip(long n)：忽略输入流中的 n 个字节 ,返回实际忽略的字节数。
            long skip = fis.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");

            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
