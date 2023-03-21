package com.shandrikov.kata;

import java.util.List;

public class MinMax {
    public static void main(String[] args) {
        List<Integer> prices = List.of(1, 10, 2, 6, -1);

        System.out.println(calculateMaxProfit(prices));
    }

    public static int calculateMaxProfit(List<Integer> prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer price : prices) {
            min = Math.min(price, min);
            max = Math.max(price - min, max);
        }

        return max;
    }
}
