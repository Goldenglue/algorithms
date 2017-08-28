package MergeSort;

import java.util.Scanner;

public class Test {
    static long sort(int[] arr, int array_size) {
        int temp[] = new int[array_size];
        return mergeSort(arr, temp, 0, array_size - 1);
    }

    static long mergeSort(int[] arr, int[] temp, int left, int right) {
        long inversions = 0;
        if (right > left) {

            int mid = (right + left) / 2;

            inversions = mergeSort(arr, temp, left, mid);
            inversions += mergeSort(arr, temp, mid + 1, right);

            inversions += merge(arr, temp, left, mid + 1, right);
        }
        return inversions;
    }

    static long merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i, j, k;
        long inversions = 0;

        i = left;
        j = mid;
        k = left;
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                inversions = inversions + (mid - i);
            }
        }

        while (i <= mid - 1) {
            temp[k++] = arr[i++];
        }


        while (j <= right) {
            temp[k++] = arr[j++];
        }


        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return inversions;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 9, 2, 9};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(sort(array, array.length));
    }
}
