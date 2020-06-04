package fileTest;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Reader
 * @author zsy
 * @version 1.0
 * @date 2020/5/19 0019 下午 3:20
 */
public class ReaderMain {
    public static void main(String[] args) throws IOException {
        try(Reader reader = new InputStreamReader(new FileInputStream("C:\\path\\1\\11\\111.txt"), StandardCharsets.UTF_8)) {
            char[] chas = new char[1000];
            int n;
            while ((n=reader.read(chas))!=-1){
                System.out.println(chas);
            }

        }
    }
}
