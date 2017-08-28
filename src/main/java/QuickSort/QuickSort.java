package QuickSort;

import java.util.Random;

public class QuickSort {
    private Random random = new Random();

    void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int l, int r) {
        while (l < r) {
            int k = l + random.nextInt(r - l);

            int temp  = array[l];
            array[l] = array[k];
            array[k] = temp;

            int m = partition(array, l, r);

            quickSort(array, l, m - 1);
            l = m + 1;
        }
    }

    private int partition(int[] arr, int low, int high) {
        int x = arr[low];
        int i = low;

        for (int j = low + 1; j <= high; j++) {
            if (arr[j] <= x) {
                i++;
                swap(arr,i,j);
            }
        }

        swap(arr,i,low);

        return i;
    }

    private void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}
