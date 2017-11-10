package com.malsolo.venkat.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class Sample {

    public static void printIt(int value) {
        //System.out.printf("Value %d written at thread %s%n", value, Thread.currentThread().toString());
        System.out.println(value);
    }

    public static int generate() {
        //System.out.println("Doing work " + Thread.currentThread());
        return 2;
    }

    public static void main(String[] args) {

        CompletableFuture.runAsync(() -> System.out.println("Run async in completable future " + Thread.currentThread()));

        ForkJoinPool pool1 = new ForkJoinPool(10);

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Sample::generate, pool1);

        //Sleep.sleep(1000);

        future.thenAcceptAsync(Sample::printIt, pool1);

        Sleep.sleep(1000);

        CompletableFuture.supplyAsync(Sample::generate)
            .thenApply(data -> data * 2)            //It's like a map
            .thenAccept(data -> printIt(data));     //It's like an iterate (foreach)

        System.out.println("In main");
    }

}
