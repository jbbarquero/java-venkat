package com.malsolo.venkat.completableFuture;

import java.util.concurrent.CompletableFuture;

public class Sample {

    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> System.out.println("Run async in completable future"));

        System.out.println(

        );

        CompletableFuture.supplyAsync(() -> {
            System.out.println("Supply async in completable future");
            return 2;
        }).thenAccept(
            data -> System.out.println(data)
        );

        System.out.println("In main");
    }

}
