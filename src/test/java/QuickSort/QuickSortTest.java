package QuickSort;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class QuickSortTest {
    private int[] numbers;
    private final static int SIZE = 10000;
    private final static int MAX = 10000;
    private final static int TESTS = 100;

    @Before
    public void setUp() {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    @Test
    public void testQuickSort() {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Should not happen");
            }
        }

        assertTrue("Quick sort test passed", true);
    }

    @Test
    public void multipleTests() {
        for (int i = 0; i < TESTS; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = generator.nextInt(MAX);
            }
            QuickSort quickSort = new QuickSort();
            quickSort.sort(numbers);

            for (int x = 0; x < numbers.length - 1; x++) {
                if (numbers[x] > numbers[x + 1]) {
                    fail("Should not happen");
                }
            }
        }
        assertTrue(true);
    }

}