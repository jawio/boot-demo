package cn.atofinon.cloud.freshman.doop;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/5/29 16:59
 * @Descrition
 */


public class PoolDemo {


    public static void main(String[] args) {

//        DirectExecutor executor = new DirectExecutor();
        ThreadPerTaskExecutor executor = new ThreadPerTaskExecutor();
//        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("task 1");
                }
        );
        executor.execute(() -> System.out.println("task 2"));

    }

    static class DirectExecutor implements Executor {

        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }


    static class ThreadPerTaskExecutor implements Executor {

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }
}
