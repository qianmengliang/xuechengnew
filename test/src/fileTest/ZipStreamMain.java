package fileTest;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author zsy
 * @version 1.0
 * @date 2020/5/18 0018 下午 5:08
 */
public class ZipStreamMain {
    public static void main(String[] args) throws IOException {
        /*InputStream inputStream = new FileInputStream(new File("C:\\path\\1\\11\\222.rar"));
        System.out.println(inputStream.toString());
        try(ZipInputStream zipInputStream = new ZipInputStream(inputStream)){
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            System.out.println(nextEntry.getName());
            while((nextEntry)!=null){
                int n;
                if(!nextEntry.isDirectory()){
                    while ((n=zipInputStream.read())!=-1){
                        System.out.println(n);
                    }
                }
                nextEntry = zipInputStream.getNextEntry();
            }
        };*/

        try (ZipInputStream zip = new ZipInputStream(new FileInputStream("C:\\path\\1\\11\\111.zip"))) {
            ZipEntry entry = null;
            while ((entry = zip.getNextEntry()) != null) {
                String name = entry.getName();
                System.out.println(name);
                if (!entry.isDirectory()) {
                    int n;
                    while ((n = zip.read()) != -1) {
                    }
                }
            }
        }

    }
}
