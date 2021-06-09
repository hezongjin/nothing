package com.dadi.a;


import java.util.*;


public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};

        System.out.println(add(arr, 3));
    }

    public static List<Integer> add(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                monotonicQueue.push(nums[i]);
            } else {
                monotonicQueue.push(nums[i]);
                list.add(monotonicQueue.max());
                monotonicQueue.pop(nums[i - k + 1]);
            }
        }
        return list;
    }

}

class MonotonicQueue {
    private Deque<Integer> data = new ArrayDeque<Integer>();

    public void push(int n) {
        while (!data.isEmpty() && data.getFirst() < n) {
            data.pollFirst();
        }
        data.push(n);
    }

    public int max() {
        return data.getLast();
    }

    public void pop(int n) {
        if (!data.isEmpty() && data.getLast() == n) {
            data.pollLast();
        }
    }
}
