package com.dadi.a;

import java.util.ArrayDeque;
import java.util.Deque;

public
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length - k + 1];
        MyDeque myDeque = new MyDeque();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                myDeque.push(nums[i]);
            } else {
                myDeque.push(nums[i]);
                arr[i - k + 1] = myDeque.max();
                myDeque.pop(nums[i - k + 1]);
            }
        }
        return arr;
    }
}

class MyDeque {
    Deque<Integer> deque = new ArrayDeque<Integer>();

    public void push(int n) {
        while (!deque.isEmpty() && deque.getFirst() < n) {
            deque.pollFirst();
        }
        deque.push(n);
    }

    public int max() {
        return deque.getLast();
    }

    public void pop(int n) {
        if (!deque.isEmpty() && deque.getLast() == n) {
            deque.pollLast();
        }
    }
}
