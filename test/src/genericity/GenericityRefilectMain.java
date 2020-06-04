package genericity;

/**
 * 泛型和反射
 * @author zsy
 * @version 1.0
 * @date 2020/5/14 0014 下午 3:35
 */
public class GenericityRefilectMain {
    public static void main(String[] args) {
        //会报错
       /* Pair[] arr = new Pair[2];
        Pair<String>[] ps = (Pair<String>[]) arr;

        ps[0] = new Pair<>("123","456");
        arr[1] = new Pair<Integer>(1,2);

        Pair<String> p = ps[1];
        String pp = p.getFirst();
        System.out.println(pp);*/

        Pair[] arr = new Pair[2];
        Pair<String>[] ps = (Pair<String>[]) new Pair[2];

        ps[0] = new Pair<>("123","456");
        arr[1] = new Pair<Integer>(1,2);

        Pair<String> p = ps[0];
        String pp = p.getFirst();
        System.out.println(pp);

    }


}

class Pair<T>{
    private T first;
    private T last;


    Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }
}