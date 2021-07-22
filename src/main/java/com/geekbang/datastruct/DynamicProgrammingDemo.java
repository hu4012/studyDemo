package com.geekbang.datastruct;

/**
 * describe:
 *
 * @author hu
 * @date 2020/12/30
 * @time 22:03
 */

public class DynamicProgrammingDemo {
    private int maxW = Integer.MIN_VALUE;
    private int[] weight = {2, 2, 4, 6, 3};
    private int n = 5;
    private int w = 9;
    private boolean[][] mem = new boolean[5][10];

    private void f(int i, int cw) {
        if (i == n || cw == w) {
            if (cw > maxW) maxW = cw;
            return;
        }
        if (mem[i][cw]) return;
        mem[i][cw] = true;
        f(i + 1, cw);
        if (cw + i <= w) {
            f(i + 1, cw + weight[i]);
        }
    }

    private int knpackage(int[] weight, int n, int w) {
        boolean[][] state = new boolean[n][w + 1];
        state[0][0] = true;
        if (weight[0] <= w) {
            state[0][weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            //不把第i 个放进背包
            for (int j = 0; j <= w; j++) {
                if (state[i - 1][j]) state[i][j] = true;
            }
            // 把第 i 个放进背包
            for (int j = 0; j <= w - weight[i]; j++) {
                if (state[i - 1][j]) state[i][j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; i--) {
            if (state[n-1][i]) return i;
        }
        return 0;
    }

    
    /*
    硬币找零问题，我们在贪心算法那一节中讲过一次。我们今天来看一个新的硬币找零问题。假设我们有几种不同币值的硬币 v1，v2，……，vn（单位是元）。
    如果我们要支付 w 元，求最少需要多少个硬币。比如，我们有 3 种不同的硬币，1 元、3 元、5 元，我们要支付 9 元，
    最少需要 3 个硬币（3 个 3 元的硬币）。
       f(n) = 1 + min(f(n-1), f(n-3), f(n-5)
     */

    public int chargeCoin(int money) {
        int[] moneyCharge = new int[money+1];
        moneyCharge[1] = 1;
        moneyCharge[2] = 2;
        moneyCharge[3] = 1;
        moneyCharge[4] = 2;
        moneyCharge[5] = 1;
        for (int i = 6; i <= money; i++) {
            moneyCharge[i] = 1 + Math.min(moneyCharge[i-1], Math.min(moneyCharge[i-3], moneyCharge[i-5]));
        }
        return moneyCharge[money];
    }

    public static void main(String[] args) {
        DynamicProgrammingDemo demo = new DynamicProgrammingDemo();
        /*long begin = System.currentTimeMillis();
        System.out.println("需要硬币: " + demo.chargeCoin(9));
        System.out.println("花费时间: " + (System.currentTimeMillis() - begin) + " ms");*/
        demo.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k + 1];
        int value = Integer.MIN_VALUE;
        for ( int i = 0; i<= nums.length - k; i++) {
            for (int j = i; j <= k; j++) {
                if (nums[j] > value) {
                    value = nums[j];
                }
            }
            result[i] = value;
            value = Integer.MIN_VALUE;
        }
        return result;
    }
}
