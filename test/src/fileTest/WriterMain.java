package fileTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Write
 * @author zsy
 * @version 1.0
 * @date 2020/5/19 0019 下午 3:47
 */
public class WriterMain {
    public static void main(String[] args) throws IOException {
        try(Writer writer = new OutputStreamWriter(new FileOutputStream("C:\\path\\1\\11\\222.txt"))) {
            writer.write("456");
        }
    }
}
