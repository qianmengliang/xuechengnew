/**
 * @author zsy
 * @version 1.0
 * @date 2020/4/17 0017 上午 11:03
 */

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
 */
public class Test14 {
    //给定两个指针，一个从开头开始跑，一个从末尾开始移动
    public static void sortNumber(int arr[]){
        if(arr == null || arr.length<2){
            return;
        }
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            while(start<end && arr[start]%2!=0){
                start++;
            }
            while(start<end && arr[end]%2==0){
                end--;
            }
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }
    public static void printNumber(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        sortNumber(array);
        printNumber(array);
    }
}
