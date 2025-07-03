package com.firstApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizedLock {
    private final List<Integer> integerList1 = new ArrayList<>();
    private final List<Integer> integerList2 = new ArrayList<>();
    private Random random = new Random();

    public void firstMethod(){
        synchronized (integerList1) {
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                System.out.println(e);
            }
            synchronized (integerList2) {
                for(int i=0; i < 10000; i++){
                    integerList1.add(random.nextInt(100));
                }
            }

        }
    }

    public void secondMethod() {
        synchronized (integerList2) {
            synchronized (integerList1){
                for(int i=0; i < 10000; i++){
                    integerList2.add(random.nextInt(100));
                }
            }

        }

    }

    public void getTheSize() {
        System.out.println(integerList1.size());
        System.out.println(integerList2.size());
    }
}
