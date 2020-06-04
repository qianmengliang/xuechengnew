/**
 * @author zsy
 * @version 1.0
 * @date 2020/4/13 0013 下午 4:38
 */
public class test12 {
/**
 * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
 */
    public static void printAll(int n){
        if(n<=0){
            throw new RuntimeException("不小于0");
        }
        //创建一个数据用来存放数值
        int[] arr = new int[n];
        printNumber(0,arr);
    }

    private static void printNumber(int n, int[] arr) {
         if(n>=arr.length){
            printArray(arr);
         }else{
             for (int i = 0; i <= 9; i++) {
                 arr[n] = i;
                 printNumber(n+1,arr);
             }
         }
    }

    public static void printArray(int arr[]){
        int index = 0;
        while (index < arr.length && arr[index]==0){
            index++;
        }
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printAll(2);
    }
}
