package com.vortex;

public class MergeSort {
    public static void sort(int[] toSort) {
        sort(toSort, new int[toSort.length], 0, toSort.length - 1);
    }

    private static void sort(int[] toSort, int[] temp, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int middle = (endIndex - startIndex) / 2 + startIndex;
        sort(toSort, temp, startIndex, middle);
        sort(toSort, temp, middle + 1, endIndex);
        merge(toSort, temp, startIndex, middle, endIndex);
    }

    private static void merge(int[] toSort, int[] temp, int startIndex, int middle, int endIndex) {
        int leftIndex = startIndex;
        int rightIndex = middle + 1;

        for (int tempIndex = startIndex; tempIndex <= endIndex; tempIndex++) {
            if (rightIndex <= endIndex && (leftIndex > middle || toSort[rightIndex] < toSort[leftIndex])) {
                temp[tempIndex] = toSort[rightIndex];
                rightIndex++;
            } else {
                temp[tempIndex] = toSort[leftIndex];
                leftIndex++;
            }
        }
        System.arraycopy(temp, startIndex, toSort, startIndex, endIndex + 1 - startIndex);
    }
}
