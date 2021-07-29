package com.dadi.j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class DD {
    static {
        System.out.println("static {}");
    }

    {
        System.out.println("{}");
    }

    public static int a = 0;

    public DD() {
        System.out.println("DD");
    }
}

class BB {
    private String name = "张三";
    private int age = 24;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "name:" + name + "\tage:" + this.age;
    }
}

public class Test {

    public static HashMap<String, String> map;
    public static HashSet<String> startSet;
    public static HashSet<String> endSet;

    static {
        map = new HashMap<>();
        map.put("}", "{");
        map.put(")", "(");
        map.put("]", "[");

        startSet = new HashSet<>();
        startSet.add("{");
        startSet.add("(");
        startSet.add("[");

        endSet = new HashSet<String>();
        endSet.add("}");
        endSet.add(")");
        endSet.add("]");
    }


    public static void main(String[] args) {
        String str = "(hah(ah})";

        Stack<String> stack = new Stack<String>();

        boolean flag = false;
        boolean flag2 = true;
        for (char c : str.toCharArray()) {
            if (startSet.contains(c + "") && flag == false) {
                stack.push(c + "");
                continue;
            }

            if (endSet.contains(c + "")) {
                if (!flag) {
                    flag = true;
                }
                String end = stack.pop();
                if (end.equals(map.get(c + ""))) {
                    continue;
                } else {
                    flag2 = false;
                    System.out.println("不合适");
                    break;
                }
            }
        }

        if (flag2) {
            if (stack.size() == 0) {
                System.out.println("恭喜--");
            } else {
                System.out.println("不合适 and fuck you");
            }
        }

    }
}
