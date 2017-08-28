package MergeSort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Hooooly i have to refactor this
 */
public class MergeSort {
    private static int inversions = 0;

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        iterativeMergeSort(arr);*/
        /*int[] array = {2,3,4,5, 6,7,8,9};
        Integer[] x = iterativeMergeSort(array);
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
        System.out.println(inversions);*/
    }

    Integer[] iterativeMergeSort(int[] array) {
        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            Integer[] temp = {array[i]};
            queue.add(temp);
        }
        while (queue.size() > 1) {
            Integer[] poll = queue.poll();
            Integer[] poll1 = queue.poll();
            queue.add(merge(poll, poll1));
        }
        return queue.poll();
    }

    private Integer[] merge(Integer[] first, Integer second[]) {
        Integer[] merged = new Integer[first.length + second.length];

        int m = 0;
        int f = 0;
        int s = 0;

        while (f < first.length || s < second.length) {
            if (f < first.length && s >= second.length) {
                while (f < first.length) {
                    merged[m] = first[f];
                    ++m;
                    ++f;
                }
                break;
            } else if (f >= first.length && s < second.length) {
                while (s < second.length) {
                    merged[m] = second[s];
                    ++m;
                    ++s;
                }
                break;
            }
            if (first[f] < second[s]) {
                while (f < first.length && first[f] < second[s]) {
                    merged[m] = first[f];
                    ++m;
                    ++f;
                }
                merged[m] = second[s];
                ++m;
                ++s;
            } else if (first[f] > second[s]) {
                inversions += first.length - f;
                while (s < second.length && first[f] > second[s]) {
                    merged[m] = second[s];
                    ++m;
                    ++s;
                }
                merged[m] = first[f];
                ++m;
                ++f;
            } else if (first[f].equals(second[s])) {
                merged[m] = first[f];
                ++m;
                merged[m] = second[s];
                ++m;
                ++f;
                ++s;
            }
        }
        return merged;
    }
}
