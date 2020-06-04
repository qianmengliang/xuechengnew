package thread;

/**
 * @author zsy
 * @version 1.0
 * @date 2020/5/7 0007 下午 3:59
 */
public class ThreadInterrupt {
    /**
     * main线程通过调用t.interrupt()从而通知t线程中断，而此时t线程正位于hello.join()的等待中，此方法会立刻结束等待
     * 并抛出InterruptedException。由于我们在t线程中捕获了InterruptedException，因此，就可以准备结束该线程。
     * 在t线程结束前，对hello线程也进行了interrupt()调用通知其中断。如果去掉这一行代码，可以发现hello线程仍然会继续运行，
     * 且JVM不会退出。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Mythread();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
        System.out.println("end");
    }
}

class Mythread extends Thread{
    public void run(){
        Thread hello = new HelloThread();
        hello.start();
        try {
            hello.join();
        } catch (InterruptedException e) {
            System.out.println("被interrupt");
        }
        hello.interrupt();
    }
}

class HelloThread extends Thread{
    public void run(){
        int n = 0;
        while (!isInterrupted()){
            n++;
            System.out.println(n+"hello");
           try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
