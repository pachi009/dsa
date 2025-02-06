package com.pshivaru.alvin;

import java.util.HashMap;
import java.util.List;

public class SumPossible {
    public static void main(String[] args) {
        int amount = 15;
        List<Integer> nums = List.of(4, 6, 10);
        System.out.println("Is Sum Possible: " +checkSumPossible(amount, nums));
        amount = 5;
        nums = List.of(1, 2, 3);
        System.out.println("Is Sum Possible: " +checkSumPossible(amount, nums));
    }

    private static boolean checkSumPossible(int amount, List<Integer> nums) {
        return checkSumPossible(amount, nums, new HashMap<Integer, Boolean>());
    }

    private static boolean checkSumPossible(int amount, List<Integer> nums, HashMap<Integer, Boolean> memo) {
        if(amount == 0)
            return true;
        if(amount < 0)
            return false;
        if(memo.containsKey(amount))
            return memo.get(amount);
        for(int n : nums){
            int subAmount = amount - n;
            if(checkSumPossible(subAmount, nums, memo)){
                memo.put(amount, true);
                return true;
            }
        }
        memo.put(amount, false);
        return false;
    }
}
