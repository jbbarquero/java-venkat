package com.malsolo.venkat;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        Arrays.asList(1, 2, 3, 4, 5)
            .stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n*2)
            .forEach(System.out::println);
        ;

    }
}
