package com.offer;

/**
 * describe:
 *
 * @author hu
 * @date 2021/07/25
 * @time 15:31
 */

public class PrintMaxN {
    public static void main(String[] args) {
        printMaxN(3);
        char[] chars = {'1', '2', '3'};
        String str = "123";
        System.out.println(str.equals(String.valueOf(chars)));
    }

    private static void printMaxN(int n) {
        if (n < 0) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            recursively(number, n, 0);
        }

    }

    private static void recursively(char[] number, int length, int index) {
        if (index == length - 1) {
            printStruct(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            recursively(number, length, index + 1);
        }
    }

    private static void printStruct(char[] number) {
        String str = String.valueOf(number);
        System.out.println(Integer.parseInt(str));
    }
}
