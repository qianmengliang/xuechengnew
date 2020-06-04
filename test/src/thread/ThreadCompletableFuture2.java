package thread;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 串行调用CompletableFuture
 * @author zsy
 * @version 1.0
 * @date 2020/5/9 0009 下午 2:06
 */
public class ThreadCompletableFuture2 {
    public static void main(String[] args) throws InterruptedException {
        //第一个任务
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return getCode("111");
            }
        });
        //第二个任务
        CompletableFuture<Integer> cfNumber = cfQuery.thenApplyAsync(new Function<String, Integer>() {
            @Override
            public Integer apply(String Code) {
                return getNumber(Code);
            }
        });
        //cfNumber成功打印后的结果
        cfNumber.thenAccept(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Number:"+integer);
            }
        });
        //Thread.sleep(2000);
    }




    static String getCode(String name){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "111";
    }

    static int getNumber(String code){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 123;
    }
}
