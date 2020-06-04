package collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zsy
 * @version 1.0
 * @date 2020/5/19 0019 下午 4:37
 */
public class ListMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zsy");
        list.add("奥特曼");
        list.add("孙悟空");
        //使用Iterator遍历list
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        /*只要实现了Iterable接口的集合类都可以直接用for
         each循环来遍历，Java编译器本身并不知道如何遍历集合
         对象，但它会自动把for each循环变成Iterator的调用，原因就在于I
         terable接口定义了一个Iterator<E> iterator()方法，强迫集合类必须返回一个Iterator实例。*/
        for (String s:list
             ) {
            System.out.println(s);
        }


    }
}
