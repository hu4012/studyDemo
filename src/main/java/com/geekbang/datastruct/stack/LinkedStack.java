package com.geekbang.datastruct.stack;

import com.geekbang.datastruct.common.LinkedNode;

import java.util.EmptyStackException;

/**
 * describe:
 *
 * @author hu
 * @date 2020/12/23
 * @time 20:03
 */

public class LinkedStack {

    private LinkedNode head;

    public LinkedNode createStack(int value) {
        head = new LinkedNode(value, null);
        return head;
    }

    public int pop() {
        if (head != null) {
            int data = head.data;
            head = head.next;
            return data;
        } else {
            throw new EmptyStackException();
        }
    }

    public void push(int value) {
        if (head == null) {
            throw new NullPointerException();
        } else {
            LinkedNode node = new LinkedNode(value, head);
            head = node;
        }
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.createStack(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
