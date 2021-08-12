package com.dadi.a;

import java.util.Arrays;
import java.util.Stack;

public class d {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};
        System.out.println(Arrays.toString(show(nums)));



    }

    public static int[] show(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() <= nums[i]) {
                s.pop();
            }
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }
}
