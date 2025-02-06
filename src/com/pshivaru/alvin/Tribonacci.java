package com.pshivaru.alvin;

import java.util.HashMap;
import java.util.Map;
// 0 1 2 3 4 5 6 7  8  9  10
// 0 0 1 1 2 4 7 13 24 44 81
public class Tribonacci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("com.pshivaru.alvin.Tribonacci of " +n +"th number is: " +trib(n));
    }

    public static int trib(int n) {
        return trib(n, new HashMap<Integer, Integer>());
    }

    public static int trib(int n, Map<Integer, Integer> map) {
        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;
        if(map.containsKey(n))
            return map.get(n);
        int res = trib(n - 1, map) + trib(n - 2, map) + trib(n - 3, map);
        map.put(n, res);
        return res;
    }
}
