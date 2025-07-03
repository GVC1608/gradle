package com.firstApp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockImplementation {
    private int i = 100;
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void increment() {
        i++;
    }

    public void firstLock() throws InterruptedException{
            for(int i=0; i<10000; i++) {
                System.out.println("Getting the first lock..");
                lock1.lock();
                Thread.sleep(1000);
                lock2.lock();
                try {
                    increment();
                } finally {
                    lock1.unlock();
                    lock2.unlock();
                }
            }
    }

    public void secondLock() {
        for(int i=0; i< 10000; i++){
            System.out.println("Getting the second lock..");
            lock2.lock();
            lock1.lock();
            try{
                increment();
            }finally {
                lock2.unlock();
                lock1.unlock();
            }
        }
    }

    public void showNumber(){
        System.out.println(i);
    }
}
