package fileTest;

import java.io.*;

/**
 * 使用inputStream和outputStream复制一份文件
 * @author zsy
 * @version 1.0
 * @date 2020/5/18 0018 下午 3:11
 */
public class CopyFileMain {
    public static void main(String[] args) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try{
            input = new FileInputStream("C:\\path\\1\\11\\111.txt");
            output = new FileOutputStream("C:\\path\\1\\11\\222.txt");
            byte[] bytes = new byte[1024];
            int n;
            while ((n=input.read(bytes))!=-1){
                output.write(bytes);
            }
            System.out.println("OK");
        }finally {
            input.close();
            output.close();
        }
    }
}
