package com.offer;


/**
 * describe:
 *
 * @author hu
 * @date 2021/08/02
 * @time 21:26
 */

public class NumberOneBetween1toN {
    public static void main(String[] args) {
        System.out.println(numberOneBetween1toN(12));
    }

    private static int numberOneBetween1toN(int i) {
        if (i <= 0) {
            return 0;
        }
        return numberOfN1(String.valueOf(i));
    }

    private static int numberOfN1(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        char[] chars = s.toCharArray();
        int first = chars[0] - '0';
        if (length == 1 && first == 0) {
            return 0;
        }
        if (length == 1 && first > 0) {
            return 1;
        }
        int numFirstDigit = 0;
        if (first > 1) {
            numFirstDigit = powerBase10(length - 1);
        } else if (first == 1) {
            numFirstDigit = Integer.parseInt(s.substring(1)) + 1;
        }
        int numOtherDigit = first * (length - 1) * powerBase10(length - 2);
        int numRecursive = numberOfN1(s.substring(1));

        return numFirstDigit + numOtherDigit + numRecursive;

    }

    private static int powerBase10(int len) {
        int result = 1;
        for (int i = 0; i < len; i++) {
            result *= 10;
        }
        return result;
    }


}
