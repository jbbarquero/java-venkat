package com.malsolo.venkat.completableFuture;

import java.util.concurrent.CompletableFuture;

public class Sample {

    public static void printIt(int value) {
        System.out.printf("Value %d written at thread %s%n", value, Thread.currentThread().toString());
    }

    public static int generate() {
        System.out.println("Doing work " + Thread.currentThread());
        //Sleep.sleep(500);
        return 2;
    }

    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> System.out.println("Run async in completable future"));

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Sample::generate);

        //Sleep.sleep(1000);

        future.thenAccept(Sample::printIt);

        Sleep.sleep(1000);

        System.out.println("In main");
    }

}
