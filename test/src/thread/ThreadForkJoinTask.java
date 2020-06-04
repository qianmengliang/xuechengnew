package thread;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author zsy
 * @version 1.0
 * @date 2020/5/9 0009 下午 3:16
 */
public class ThreadForkJoinTask {
    public static void main(String[] args) {
        // 创建2000个随机数组成的数组:
        long[] array = new long[2000];
        long expectedSum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random();
            expectedSum += array[i];
        }
        System.out.println("Expected sum: " + expectedSum);
        // fork/join:
        ForkJoinTask<Long> task = new SumTask(0, array.length,array);
        long startTime = System.currentTimeMillis();
        Long result = ForkJoinPool.commonPool().invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }

    static Random random = new Random(0);

    static long random() {
        return random.nextInt(10000);
    }

}

class SumTask extends RecursiveTask{
    static final int MINNUMBER = 500;
    private int start;
    private int end;
    private long[] array;

    SumTask(int start,int end,long[] array){
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    protected Long compute() {
        if(end-start<500){
            //任务够小，直接计算
            long sum = 0;
            for (int i = start; i < end-start; i++) {
                sum+=this.array[i];
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return sum;
        }
        int middle = (end+start)/2;
        System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
        SumTask sumTask1 = new SumTask(start,middle,array);
        SumTask sumTask2 = new SumTask(middle,end,array);
        invokeAll(sumTask1,sumTask2);
        Long subresult1 = (Long) sumTask1.join();
        Long subresult2 = (Long) sumTask2.join();
        Long result = subresult1 + subresult2;
        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
    }
}
