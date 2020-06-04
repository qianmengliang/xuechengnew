package genericity;

/**
 * 带泛型的数组实际上是编译器的类型擦除
 * @author zsy
 * @version 1.0
 * @date 2020/5/14 0014 下午 3:54
 */
public class GenericityRefilectMain1 {
    public static void main(String[] args) {
        Pair[] arr = new Pair[2];
        Pair<String>[] ps = (Pair<String>[]) new Pair[2];

        System.out.println(ps.getClass()==Pair[].class);

        String s1 = (String) arr[0].getFirst();
        String s2 = ps[0].getFirst();
    }
}

