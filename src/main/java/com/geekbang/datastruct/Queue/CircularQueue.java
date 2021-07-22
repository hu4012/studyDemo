package com.geekbang.datastruct.Queue;

/**
 * describe:
 *
 * @author hu
 * @date 2020/12/23
 * @time 21:29
 */

public class CircularQueue {
    private String[] items;
    private int n = 0;
    private int head;
    private int tail;

    public CircularQueue(int n) {
        this.n = n;
        this.items = new String[n];
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue(String data) {
        if ((tail + 1) % n == head) {
            return false;
        } else {
            items[tail] = data;
            tail = (tail + 1) % n;
            return true;
        }
    }

    public String dequeue() {
        if (tail == head) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }
}
