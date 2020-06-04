package thread;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zsy
 * @version 1.0
 * @date 2020/5/8 0008 下午 4:14
 */
public class ThreadReadWriteLock {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock rlock = readWriteLock.readLock();
    private final Lock wlock = readWriteLock.writeLock();
    private int[] count = new int[10];
    private final Lock lock = new ReentrantLock();

    public void inc(int index){
        wlock.lock();
        try {
            count[index]+=1;
        }finally {
            wlock.unlock();
        }
    }

    public int[] get(){
        rlock.lock();
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Arrays.copyOf(count,count.length);
        }finally {
            rlock.unlock();
        }
    }

    public static void main(String[] args) {
        ThreadReadWriteLock tt = new ThreadReadWriteLock();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(){
                public void run(){
                    System.out.println(tt.get().toString());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

    }
}
