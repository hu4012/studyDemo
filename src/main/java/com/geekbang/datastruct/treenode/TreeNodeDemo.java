package com.geekbang.datastruct.treenode;

/**
 * describe:
 *
 * @author hu
 * @date 2020/12/29
 * @time 21:31
 */

public class TreeNodeDemo {

    public int calculate(String s) {
        if (s == null) {
            return -1;
        }
        if (!s.contains("(") || !s.contains(")")) {
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (isCalculater(chars[i])) {

                }
            }
        }
        s = s.substring(s.indexOf('('), s.lastIndexOf(')'));
        return 0;
    }

    private int calculate(String a, String b, String c) {
        if ("+".equals(b)) {
            return Integer.parseInt(a) + Integer.parseInt(c);
        } else {
            return Integer.parseInt(a) - Integer.parseInt(c);
        }
    }

    private boolean isCalculater(char c) {
        return c == '+' || c == '-';
    }

}
