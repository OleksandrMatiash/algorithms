package com.vortex;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class QuickSort {
    private static final Random RNG = new Random(System.currentTimeMillis());


    public static <T extends Comparable<T>> List<T> sort(List<T> toSort) {
        if (toSort.size() <= 1) {
            return toSort;
        }

        List<T> less = new ArrayList<>();
        List<T> eq = new ArrayList<>();
        List<T> greater = new ArrayList<>();
        T ref = toSort.get(RNG.nextInt(toSort.size()));
        for (T t : toSort) {
            int compResult = t.compareTo(ref);
            if (compResult < 0) {
                less.add(t);
            } else if (compResult > 0) {
                greater.add(t);
            } else {
                eq.add(t);
            }
        }

        List<T> result = sort(less);
        result.addAll(eq);
        result.addAll(sort(greater));
        return result;
    }

    public static <T extends Comparable<T>> List<T> sortFunctional(List<T> toSort) {
        if (toSort == null) {
            return null;
        }
        if (toSort.size() <= 1) {
            return toSort;
        }

        T ref = toSort.get(RNG.nextInt(toSort.size()));
        Map<Integer, List<T>> group = toSort.stream()
                .collect(Collectors.groupingBy(ref::compareTo));
        return Stream.of(sortFunctional(group.get(1)), group.get(0), sortFunctional(group.get(-1)))
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(toList());
    }

    public static void sort(int[] arr) {
        sort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        int ref = arr[start];
        int left = start;
        int right = end;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] <= ref) {
                temp[left] = arr[i];
                left++;
            } else {
                temp[right] = arr[i];
                right--;
            }
        }
        temp[left] = ref;
        System.arraycopy(temp, start, arr, start, end + 1 - start);
        sort(arr, temp, start, left - 1);
        sort(arr, temp, left + 1, end);
    }
}
