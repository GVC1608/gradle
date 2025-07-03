package com.firstApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/test.txt"));
        reader.lines()
                .forEach(
                        System.out::println
                );

//        ExecutorService executorSerive = Executors.newFixedThreadPool(10);
        DeadLockImplementation d1 = new DeadLockImplementation();
        Thread t1 = new Thread(() -> {
            try {
                d1.firstLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(()->{
            d1.secondLock();
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }
        d1.showNumber();

    }
}