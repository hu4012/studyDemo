package com.geekbang.datastruct.stack;

import com.geekbang.datastruct.backtrack.Pattern;

/**
 * describe:
 *
 * @author hu
 * @date 2020/12/23
 * @time 20:24
 */

public class ArrayStack {
    private String[] items;
    private int count; //栈中元素个数
    private int n; //栈大小

    public ArrayStack(int n) {
        this.count = 0;
        this.items = new String[count];
        this.n = n;
    }

    public boolean push(String item) {
        if (count == n) {
            return false;
        }
        items[count] = item;
        ++count;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String item = items[count-1];
        --count;
        return item;
    }
}
