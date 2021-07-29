package com.dadi.j;

public class Test4 {
    static class QQ {
    }

    static class _360 {
    }

    public static class Father {

     /*   public Father() {
            hardChoice(new QQ());
        }*/

        public void hardChoice(QQ arg) {
            System.out.println("father chose QQ");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father chose _360");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("son chose QQ");
        }

        public void hardChoice(_360 arg) {
            System.out.println("son chose _360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();

        father.hardChoice(new _360());
        son.hardChoice(new QQ());

        int[][][] ints = new int[1][2][-1];

        //还没有结束 我放弃尼玛的啊 法克
    }
}
