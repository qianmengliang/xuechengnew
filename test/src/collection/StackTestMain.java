package collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 利用Stack把一个给定的整数转换为十六进制
 * @author zsy
 * @version 1.0
 * @date 2020/5/21 0021 下午 2:07
 */
public class StackTestMain {
    public static void main(String[] args) {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        Deque stack = new LinkedList();
        int remain = 0;
        while (n!=0){
            remain = n%16;
            stack.push(Integer.toHexString(remain));
            n = n/16;
        }
        String hex = "";
        while (!stack.isEmpty()){
            hex  += stack.pop();
        }
        return hex;
    }
}
