package com.geekbang.datastruct.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * describe:
 *
 * @author hu
 * @date 2020/12/24
 * @time 20:48
 */

public class SortDemo {

    public static void main(String[] args) {
        int[] a = {6, 4, 3, 1, 5, 9};
        /*printall(a);
        quickSort(a, 6);
        printall(a);*/
        System.out.println(getK(a, 2));
    }

    public static void printall(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] a, int n) {
        mergeSortc(a, 0, n - 1);
    }

    public static void mergeSortc(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = p + (r - p) / 2;
        mergeSortc(a, p, q);
        mergeSortc(a, q + 1, r);
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int[] leftarr = new int[q - p + 2];
        int[] rightarr = new int[r - q + 1];
        for (int i = 0; i <= q - p; i++) {
            leftarr[i] = a[p + i];
        }
        leftarr[q - p + 1] = Integer.MAX_VALUE;
        for (int i = 0; i < r - q; i++) {
            rightarr[i] = a[q + 1 + i];
        }
        rightarr[r - q] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            if (leftarr[i] <= rightarr[j]) {
                a[k++] = leftarr[i++];
            } else {
                a[k++] = rightarr[j++];
            }
        }
    }

    public static void quickSort(int[] a, int n) {
        quickSortc(a, 0, n - 1);
    }

    private static void quickSortc(int[] a, int p, int q) {
        if (p >= q) {
            return;
        }
        int r = partition(a, p, q);
        quickSortc(a, p, r - 1);
        quickSortc(a, r + 1, q);
    }

    private static int partition(int[] a, int p, int q) {
        int pivot = a[q];
        int i = p;
        int tmp;
        for (int j = p; j < q - 1; j++) {
            if (a[j] < pivot) {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        a[q] = a[i];
        a[i] = pivot;
        return i;
    }

    public static int getK(int[] a, int k) {
        int partition = partition(a, 0, a.length - 1);
        while (partition + 1 != k) {
            if (partition + 1 < k) {
                partition = partition(a, partition + 1, a.length - 1);
            } else {
                partition = partition(a, 0, partition - 1);
            }
        }

        return a[partition];
    }


}
