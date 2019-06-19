package com.vortex;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MergeSortTest {
    @Test
    public void sort() {
        for (int j = 0; j < 10000; j++) {
            Random rng = new Random(System.currentTimeMillis());
            int numOfElements = rng.nextInt(10);
            int[] toSort = new int[numOfElements];
            for (int i = 0; i < numOfElements; i++) {
                toSort[i] = rng.nextInt(10) - 5;
            }

            int[] expectedSorted = Arrays.stream(toSort).sorted().toArray();

            MergeSort.sort(toSort);

            Assert.assertArrayEquals(expectedSorted, toSort);
        }
    }
}