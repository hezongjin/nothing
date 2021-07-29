package com.dadi.j;

import java.util.Random;

public class Test2 {
    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {


    }

    public static void show(String... abc) {
        String[] clone = abc.clone();
        System.out.println(clone[0]);
    }

}
