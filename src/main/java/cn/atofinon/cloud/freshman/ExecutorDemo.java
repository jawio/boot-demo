package cn.atofinon.cloud.freshman;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/6/22 19:38
 * @Descrition
 */


public class ExecutorDemo<T> {

    class DirectExecutor implements Executor {
        @Override
        public void execute(Runnable command) {
            // 这里不是用的new Thread(r).start()，也就是说没有启动任何一个新的线程。
            command.run();
        }

    }

    class ThreadPerTaskExecutor implements Executor {

        @Override
        public void execute(Runnable r) {
            // 每个任务都用一个新的线程来执行
            new Thread(r).start();
        }
    }


    class SerialExecutor implements Executor {

        // 任务队列
        final Queue<Runnable> tasks = new ArrayDeque<Runnable>();
        // 这个才是真正的执行器
        final Executor executor;
        // 当前正在执行的任务
        Runnable active;

        // 初始化的时候，指定执行器
        SerialExecutor(Executor executor) {
            this.executor = executor;
        }

        // 添加任务到线程池: 将任务添加到任务队列，scheduleNext 触发执行器去任务队列取任务
        @Override
        public synchronized void execute(final Runnable r) {
            tasks.offer(new Runnable() {
                @Override
                public void run() {
                    try {
                        r.run();
                    } finally {
                        scheduleNext();
                    }
                }
            });
            if (active == null) {
                scheduleNext();
            }
        }

        protected synchronized void scheduleNext() {
            if ((active = tasks.poll()) != null) {
                // 具体的执行转给真正的执行器 executor
                executor.execute(active);
            }
        }

    }

    private static  <T> T fun(T task){
        T res=task;
        return  res;
    }
    private static final int COUNT_BITS = Integer.SIZE - 3;

    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    private static int a = -1<<COUNT_BITS;


    public static void main(String[] args) {
        try {
            BlockingQueue blockingQueue= new ArrayBlockingQueue(4);
            blockingQueue.put(1);
            blockingQueue.put(2);
            blockingQueue.add(4);
            System.out.println(blockingQueue.offer(1));
            System.out.println(blockingQueue.take());

            blockingQueue.poll();
            System.out.println(blockingQueue);

            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.submit(()-> System.out.println("task start"));
            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(CAPACITY));
        System.out.println(Integer.toBinaryString(~CAPACITY));

        System.out.println(CAPACITY);
        System.out.println(~CAPACITY);

    }
}
