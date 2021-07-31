package com.offer;

/**
 * describe:
 *
 * @author hu
 * @date 2021/07/31
 * @time 15:54
 */

public class Permutation {
    public static void main(String[] args) {
        permutation("abcd");
    }

    private static void permutation(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int index = 0;
        permutation(chars, index, len);
    }

    private static void permutation(char[] chars, int index, int len) {
        if (index == len) System.out.println(new String(chars));
        else {
            for (int i = index; i < len; i++) {
                char temp = chars[i];
                chars[i] = chars[index];
                chars[index] = temp;
                permutation(chars, index + 1, len);
                temp = chars[i];
                chars[i] = chars[index];
                chars[index] = temp;
            }
        }
    }
}
