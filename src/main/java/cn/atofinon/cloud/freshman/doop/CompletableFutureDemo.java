package cn.atofinon.cloud.freshman.doop;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/7/20 21:47
 * @Descrition
 */


public class CompletableFutureDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture cf=new CompletableFuture();

        cf.complete("coding...");
        System.out.println(cf.get());
    }
}
