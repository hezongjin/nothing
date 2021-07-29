package com.dadi.j;

class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static final int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }

    public static int value1 = 123;
}


public class LoadDemo {
    public static void main(String[] args) {
        System.out.println(SuperClass.value);
    }
}





















