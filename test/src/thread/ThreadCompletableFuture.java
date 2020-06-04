package thread;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture的用法
 * @author zsy
 * @version 1.0
 * @date 2020/5/9 0009 上午 11:04
 */
public class ThreadCompletableFuture {
    public static void main(String[] args) {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(ThreadCompletableFuture::get);
        cf.thenAccept((result)->{
            System.out.println("price："+result);
        });
        cf.exceptionally((result)->{
            System.out.println("报错了");
            return null;
        });
    }

    static Integer get(){
        if(Math.random()<0.3){
            throw new RuntimeException("11");
        }
        return 123;
    }
}
