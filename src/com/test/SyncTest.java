package com.test;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Airy on 2018/5/27
 */


public class SyncTest {

    public void func(int index){
        synchronized (this){
            for (int i=0;i<5;i++){
                System.out.println(index+"-> "+i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ArrayList<>();
        SyncTest syncTest = new SyncTest();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> syncTest.func(1));
        executorService.execute(()->syncTest.func(2));

        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("run..");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();


    }

}


