package MergeSort;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
    private int[] numbers;
    private final static int SIZE = 2000;
    private final static int MAX = 1000;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    @Test
    public void testMergeSort() {
        long startTime = System.currentTimeMillis();

        MergeSort sorter = new MergeSort();
        Integer[] integers = sorter.iterativeMergeSort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Mergesort " + elapsedTime);

        for (int i = 0; i < integers.length - 1; i++) {
            if (integers[i] > integers[i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true);

    }

    @Test
    public void itWorksRepeatably() {
        for (int i = 0; i < 2000; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for (int a = 0; a < numbers.length; a++) {
                numbers[a] = generator.nextInt(MAX);
            }
            MergeSort sorter = new MergeSort();
            Integer[] integers = sorter.iterativeMergeSort(numbers);
            for (int j = 0; j < integers.length - 1; j++) {
                if (integers[j] > integers[j + 1]) {
                    fail("Should not happen");
                }
            }
            assertTrue(true);
        }
    }
}
