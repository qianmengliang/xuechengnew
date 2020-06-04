/**
 * 写一个函数，输入n，求斐波那契（Fibonacci) 数列的第n项
 */
public class test09 {
    public static long getFibonacci(int n){
        if(n<=1){
            return n;
        }
        if(n==2){
            return 1;
        }
        //设置f(n-1)的初始值
        long pre = 1;
        ////设置f(n-2)的初始值
        long after = 1;
        //设置f(n-1)+f(n-2)的初始值
        long addNumber = 2;

        for (int i = 3; i <= n; i++) {
            addNumber = pre+after;
            after = pre;
            pre = addNumber;
        }
        return addNumber;
    }


    public static void main(String[] args) {
        System.out.println(getFibonacci(0));
        System.out.println(getFibonacci(1));
        System.out.println(getFibonacci(2));
        System.out.println(getFibonacci(3));
        System.out.println(getFibonacci(4));
        System.out.println(getFibonacci(5));
        System.out.println(getFibonacci(6));
        System.out.println(getFibonacci(1111117));
    }

}
