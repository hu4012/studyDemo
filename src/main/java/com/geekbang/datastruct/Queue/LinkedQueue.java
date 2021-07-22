package com.geekbang.datastruct.Queue;

import com.geekbang.datastruct.common.LinkedNode;

import java.util.Queue;

/**
 * describe:
 *
 * @author hu
 * @date 2020/12/23
 * @time 21:08
 */

public class LinkedQueue {
    private LinkedNode head;
    private LinkedNode tail;

    public void enqueue(int value) {
        if (head == null ){
            head = new LinkedNode(value, null);
            tail = head;
        } else {
            tail.next = new LinkedNode(value, null);
            tail = tail.next;
        }
    }

    public int dequeue() {
        if (head == null) {
            return -1;
        } else {
            int tmp = head.data;
            head = head.next;
            return tmp;
        }
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
