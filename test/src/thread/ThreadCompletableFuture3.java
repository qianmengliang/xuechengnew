package thread;

import javax.naming.Name;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * CompletableFuture并行执行
 * @author zsy
 * @version 1.0
 * @date 2020/5/9 0009 下午 2:22
 */
public class ThreadCompletableFuture3 {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return getS("zsy","111");
            }
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return getX("zzsy","2222");
            }
        });
        CompletableFuture<Object> cfGetS = CompletableFuture.anyOf(cf1,cf2);

        CompletableFuture<Integer> cf3 = cfGetS.thenApplyAsync(new Function<Object, Integer>() {
            @Override
            public Integer apply(Object o) {
                return getN((String) o);
            }
        });

        cf3.thenAccept(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        Thread.sleep(2000);
    }

    static String getS(String name,String url){
        System.out.println(name+"from:"+url);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name;
    }

    static String getX(String name,String url){
        System.out.println(name+"from:"+url+"getX");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name;
    }

    static Integer getN(String name){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if("zsy".equals(name)){
            return 0;
        }else{
            return 1;
        }
    }
}
