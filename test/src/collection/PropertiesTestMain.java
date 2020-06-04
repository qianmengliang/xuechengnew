package collection;

import java.io.IOException;
import java.util.Properties;

/**
 * 创建Properties实例；
 * 调用load()读取文件；
 * 调用getProperty()获取配置。
 * @author zsy
 * @version 1.0
 * @date 2020/5/20 0020 下午 4:28
 */
public class PropertiesTestMain {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(PropertiesTestMain.class.getResourceAsStream("/default.properties"));
        String url = properties.getProperty("url");
        System.out.println(url);
    }
}
