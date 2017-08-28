package QuickSort;

import java.util.Random;

public class QuickSort {
    private Random random = new Random();

    void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int l, int r) {
        if (l < r) {
            int k = l + random.nextInt(r - l);
            int temp  = array[l];
            array[l] = array[k];
            array[k] = temp;
            int m = partition(array, l, r);
            quickSort(array, l, m - 1);
            quickSort(array, m + 1, r);
        }
    }

    //    private int partition(int[] arr, int low, int high) {
//        int x = arr[low];
//        int i = low - 1;
//        for (int j = low; j < high; j++) {
//            if (arr[j] <= x) {
//                i++;
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//        i++;
//        int temp = arr[i];
//        arr[i] = arr[low];
//        arr[low] = temp;
//        return i;
//    }
    private int partition(int[] arr, int low, int high) {
        int x = arr[low];
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] <= x) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
        return i;
    }


    private void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 9, 7, 9};
        QuickSort sort = new QuickSort();
        sort.quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}