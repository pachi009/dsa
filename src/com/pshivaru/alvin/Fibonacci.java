package com.pshivaru.alvin;

import java.util.HashMap;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 8;
        System.out.println("Fib " +n +" : " + fib(n));
    }

    static int fib (int n){
       return fib(n, new HashMap<Integer, Integer>());
    }

    static int fib (int n, HashMap<Integer, Integer> fibMap){
        if(n == 0 || n == 1)
            return n;
        if(fibMap.containsKey(n))
            return fibMap.get(n);
        int result = fib(n - 1, fibMap) + fib(n - 2, fibMap);
        fibMap.put(n, result);
        return result;
    }
}
