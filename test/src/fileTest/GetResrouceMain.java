package fileTest;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * 读取classpath中的资源
 * @author zsy
 * @version 1.0
 * @date 2020/5/19 0019 下午 2:04
 */
public class GetResrouceMain {
    public static void main(String[] args) throws IOException {
        try(InputStream inputStream = GetResrouceMain.class.getResourceAsStream("/default.properties")) {
            if(inputStream!=null){
                byte[] bytes = new byte[1024];
                int n;
                StringBuffer stringBuffer = new StringBuffer();
                while ((n=inputStream.read(bytes))!=-1){
                    System.out.println(stringBuffer.append(new String(bytes, "utf-8")).toString());
                }
            }
        }
    }
}
