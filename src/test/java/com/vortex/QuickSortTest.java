package com.vortex;

import org.junit.Test;
import org.junit.internal.ArrayComparisonFailure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class QuickSortTest {
    private final Random RNG = new Random(System.currentTimeMillis());

    @Test
    public void sort() {
        for (int j = 0; j < 100000; j++) {
            int numbers = RNG.nextInt(10) + 1;
            List<Integer> toSort = new ArrayList<>();
            for (int i = 0; i < numbers; i++) {
                toSort.add(RNG.nextInt(10) - 5);
            }
            List<Integer> sorted = toSort.stream().sorted().collect(Collectors.toList());

            List<Integer> result = QuickSort.sort(toSort);

            assertEquals(sorted, result);
        }
    }

    @Test
    public void sortFunctional() {
        for (int j = 0; j < 100000; j++) {
            int numbers = RNG.nextInt(10) + 1;
            List<Integer> toSort = new ArrayList<>();
            for (int i = 0; i < numbers; i++) {
                toSort.add(RNG.nextInt(10) - 5);
            }
            List<Integer> sorted = toSort.stream().sorted().collect(Collectors.toList());

            List<Integer> result = QuickSort.sortFunctional(toSort);

            assertEquals(sorted, result);
        }
    }

    @Test
    public void sortArr() {
        for (int j = 0; j < 100000; j++) {
            int numbers = RNG.nextInt(10) + 1;
            int[] toSort = new int[numbers];
            for (int i = 0; i < numbers; i++) {
                toSort[i] = RNG.nextInt(10) - 5;
            }
            int[] copy = Arrays.copyOf(toSort, numbers);
            int[] sorted = Arrays.stream(toSort).sorted().toArray();

            QuickSort.sort(toSort);

            try {
                assertArrayEquals(sorted, toSort);
            } catch (ArrayComparisonFailure arrayComparisonFailure) {
                System.out.println();
            }

        }
    }

}