package com.offer;

/**
 * describe:
 *
 * @author hu
 * @date 2021/07/25
 * @time 14:16
 */

public class MaxProductsAfterCutting {
    public static void main(String[] args) {
        //System.out.println(maxProductAfterCuttingOne(50));
        //System.out.println(maxProductAfterCuttingTwo(50));
        System.out.println(15&0x1);
    }

    private static int maxProductAfterCuttingOne(int length) {
        long begin = System.currentTimeMillis();
        if (length < 2) {
            return 0;
        } else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (product > max) {
                    max = product;
                }
                products[i] = max;
            }
            max = products[length];
        }
        System.out.println("one cost time:" + (System.currentTimeMillis() - begin) + " ms");
        return max;
    }

    private static long maxProductAfterCuttingTwo(int length) {
        long begin = System.currentTimeMillis();
        if (length < 2) {
            return 0;
        } else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }
        int timesOf3 = length / 3;
        if (length - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        long max = (long)Math.pow(3, timesOf3)*(long)Math.pow(2, timesOf2);
        System.out.println("two cost time:" + (System.currentTimeMillis() - begin) + " ms");
        return max;
    }
}
