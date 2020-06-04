/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 */
public class test011 {
    public static double power(double base, int exponet){
        if(base == 0 && exponet==0){
            throw new RuntimeException("invalid input. base and exponent both are zero");
        }
        if(base == 0){
            return 0;
        }
        if(exponet == 0){
            return 1;
        }
        if(base == 1 || exponet ==1){
            return base;
        }
        long exp = exponet;
        //取绝对值
        if(exponet < 0 ){
            exp = -exp;
        }
        double result = getNumber(base,exp);

        if(exponet <0){
            result = 1/result;
        }
        return result;
    }

    public static double getNumber(double base,long exp){
        if(exp == 1){
            return base;
        }
        double result = getNumber(base,exp>>1);
        result *= result;
        if(exp%2!=0){
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2,2));
        System.out.println(power(22222,2));
        System.out.println(power(-2,3));
    }
}
