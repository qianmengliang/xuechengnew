package throwable;

/**
 * @author zsy
 * @version 1.0
 * @date 2020/5/13 0013 下午 3:03
 */
public class ThrowMain {
    public static void main(String[] args) {
        try {
            System.out.println(tax(2000, 0.1));
            System.out.println(tax(-200, 0.1));
            System.out.println(tax(2000, -0.1));
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    static double tax(int salary, double rate) {
        // TODO: 如果传入的参数为负，则抛出IllegalArgumentException
        if(rate<0){
            throw new IllegalArgumentException("不能为负数");
        }
        return salary * rate;
    }
}
