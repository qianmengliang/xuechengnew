package fileTest;

import java.io.File;

/**
 * @author zsy
 * @version 1.0
 * @date 2020/5/18 0018 上午 9:57
 */
public class IoFileMain {
    public static void main(String[] args) {
        File file = new File("C://path");
        getFiles(file);
    }

    static void  getFiles(File file){
        File[] files = file.listFiles();
        if(files!=null){
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
                getFiles(files[i]);
            }
        }
    }
}
