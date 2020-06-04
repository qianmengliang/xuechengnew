package fileTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 读流
 * @author zsy
 * @version 1.0
 * @date 2020/5/18 0018 下午 2:04
 */
public class ReadIOMain {
    public static void main(String[] args) throws IOException {
        InputStream input = null;
        try {
            input = new FileInputStream("C:\\path\\1\\11\\111.txt");
            byte[] bytes = new byte[100];
            int n;
            while((n=input.read(bytes))!=-1){
                System.out.println(n);
            }
        }finally {
            input.close();
        }

    }
}
