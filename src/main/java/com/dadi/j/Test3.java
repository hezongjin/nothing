package com.dadi.j;

class Father {
    public int money = 1;

    public Father() {
        money = 2;
        show();
    }

    public void show() {
        System.out.println("i'm a father, i have " + money + " money");
    }
}

class Son extends Father {
    public int money = 3;

    public Son() {
        money = 4;
        show();
    }

    public void show() {
        System.out.println("i'm a Son, i have " + money + " money");
    }
}

public class Test3 {
    public static void main(String[] args) {
        Father son = new Son();
        System.out.println(son.money);

    }
}


