package fileTest;

import java.io.*;

/**
 * 序列化和反序列化
 * 可序列化的Java对象必须实现java.io.Serializable接口，类似Serializable这样的空接口被称为“标记接口”（Marker Interface）；
 *
 * 反序列化时不调用构造方法，可设置serialVersionUID作为版本号（非必需）；
 *
 * Java的序列化机制仅适用于Java，如果需要与其它语言交换数据，必须使用通用的序列化方法，例如JSON。
 * @author zsy
 * @version 1.0
 * @date 2020/5/19 0019 下午 2:51
 */
public class XuliehuaMain {
    public static void main(String[] args) throws IOException {
        //字节流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try(ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            //ObjectOutputStream既可以写入基本类型，如int，boolean，也可以写入String（以UTF-8编码），还可以写入实现了Serializable接口的Object
            outputStream.writeInt(123);
            outputStream.writeUTF("zsy");
            outputStream.writeDouble(123.456);
            outputStream.writeInt(789);
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try(ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream)) {
            int n = inputStream.readInt();
            String str = inputStream.readUTF();
            double n1 = inputStream.readDouble();
            System.out.println(n+str+n1);
        }
    }
}
