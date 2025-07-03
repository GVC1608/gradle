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

        ExecutorService executorSerive = Executors.newFixedThreadPool(10);



    }
}