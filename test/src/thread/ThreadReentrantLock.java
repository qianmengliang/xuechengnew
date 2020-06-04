package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zsy
 * @version 1.0
 * @date 2020/5/8 0008 下午 2:58
 */
public class ThreadReentrantLock {
    public static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            public void run(){
                lock.lock();
                try {
                    for (int i = 0; i < 1000000; i++) {
                        Count.count++;
                    }
                } finally {
                    lock.unlock();
                }

            }
        };
        Thread t1 = new Thread(){
            public void run(){
                lock.lock();
                try {
                    for (int i = 0; i < 1000000; i++) {
                        Count.count--;
                    }
                }finally {
                    lock.unlock();
                }

            }
        };
        t.start();
        t1.start();
        t.join();
        t1.join();
        System.out.println(Count.count);
    }
}

class Count{
    public static int count = 0;
}