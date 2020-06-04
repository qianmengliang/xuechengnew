package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zsy
 * @version 1.0
 * @date 2020/4/27 0027 下午 4:12
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(6);
// 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < 6; i++) {
            Callable c = new Callable() {
                @Override
                public Object call() throws Exception {
                    return "Callable方法返回值";
                }
            };
// 执行任务并获取 Future 对象
            Future f = pool.submit(c);
            list.add(f);
        }
// 关闭线程池
        pool.shutdown();
// 获取所有并发任务的运行结果
        for (Future f : list) {
// 从 Future 对象上获取任务的返回值，并输出到控制台
            System.out.println("res：" + f.get().toString());
        }
    }
}
