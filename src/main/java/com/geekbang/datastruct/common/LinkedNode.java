package com.geekbang.datastruct.common;

import com.geekbang.datastruct.stack.LinkedStack;

/**
 * describe:
 *
 * @author hu
 * @date 2020/12/23
 * @time 21:09
 */

public class LinkedNode {
    public int data;
    public LinkedNode next;

    public LinkedNode(int data, LinkedNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }
}
