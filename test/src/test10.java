/**
 * 请实现一个函数， 输入一个整数，输出该数二进制表示中1的个数。
 * 例如把9表示成二进制是1001 ，有2位是1. 因此如果输入9，该出2。
 */
public class test10 {
    public static int getSum(int n){
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += (n&1);
            n>>>=1;
        }
        return result;
    }
    public static int getSum2(int n){
        int result = 0;
        while(n!=0){
            result++;
            n = (n-1)&n;
        }

        return result;
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        getSum(0B01111111_11111111_11111111_11111111);
        long endTime = System.currentTimeMillis();
        float time = (float)(endTime-startTime)/1000;
        System.out.println(time);
        startTime = System.currentTimeMillis();
        getSum2(0B01111111_11111111_11111111_11111111);
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
