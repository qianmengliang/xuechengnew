package thread;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**使用ThreadLocal
 * 实际上，可以把ThreadLocal看成一个全局Map<Thread, Object>：每个线程获取ThreadLocal变量时，总是使用Thread自身作为key
 * 为了保证能释放ThreadLocal关联的实例，
 * 我们可以通过AutoCloseable接口配合try (resource) {...}结构，让编译器自动为我们关闭。
 * 例如，一个保存了当前用户名的ThreadLocal可以封装为一个UserContext对象
 * @author zsy
 * @version 1.0
 * @date 2020/5/12 0012 下午 5:18
 */
public class ThreadLocalThread1 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        String[] users = new String[]{"1","2","3","4","5"};
        for (int i = 0; i < users.length; i++) {
            es.submit(new RunTask(users[i]));

        }
        es.shutdown();
    }

}
class RunTask implements Runnable {
    private String user;
    public RunTask(String user){
        this.user = user;
    }

    @Override
    public void run() {
        try(UserContext1 userContext1 = new UserContext1(this.user)) {
            Method process = RunTask1.class.getMethod("process", String.class);
            process.invoke(new RunTask1(),this.user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class RunTask1{

    public void process(String user){
        System.out.println("当前user:"+user+"，正在执行");
    }
}


class UserContext1 implements AutoCloseable{
    static final ThreadLocal<String> THREAD_LOCAL= new ThreadLocal<>();

    public UserContext1(String user){
        THREAD_LOCAL.set(user);
    }

    public static String getUser(){
        return THREAD_LOCAL.get();
    }

    @Override
    public void close() throws Exception {
        System.out.println(THREAD_LOCAL.get()+"正在remove");
        THREAD_LOCAL.remove();
    }
}
