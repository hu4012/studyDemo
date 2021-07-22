package com.geekbang.datastruct.backtrack;

/**
 * describe:
 *
 * @author hu
 * @date 2020/12/21
 * @time 21:16
 */

public class BackTracking {
    public static void main(String[] args) {
        Pattern pattern = new Pattern("123*0".toCharArray(), 5);
        System.out.println(pattern.isMatched("12323110".toCharArray(), 8));
    }
}
