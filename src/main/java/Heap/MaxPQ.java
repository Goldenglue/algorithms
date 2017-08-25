package Heap;

import java.util.Arrays;
import java.util.Scanner;

public class MaxPQ {
    private Integer[] elements;
    private int size;

    public MaxPQ(int capacity) {
        elements = new Integer[capacity + 1];
        size = 0;

    }

    public int max() {
        int max = elements[1];
        swap(1, size--);
        shiftDown(1);
        elements[size + 1] = null;
        return max;
    }

    public void insert(int x) {
        elements[++size] = x;
        shiftUp(size);
    }

    private void shiftUp(int index) {
        while (index > 1 && less(index / 2, index)) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    private void shiftDown(int index) {
        while (2 * index <= size) {
            int j = 2 * index;
            if (j < size && less(j, j + 1)) {
                j++;
            }
            if (!less(index, j)) {
                break;
            }
            swap(index, j);
            index = j;
        }
    }

    private void swap(int index, int i) {
        int temp = elements[index];
        elements[index] = elements[i];
        elements[i] = temp;
    }

    private boolean less(int parent, int node) {
        return elements[parent].compareTo(elements[node]) < 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        MaxPQ heap = new MaxPQ(n);
        heap.insert(2);
        heap.insert(3);
        heap.insert(15);
        heap.insert(18);
        heap.insert(12);
        System.out.println(heap);
        heap.max();
        System.out.println(heap);
        heap.max();
        System.out.println(heap);
        heap.max();
        System.out.println(heap);

        /*scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.contains("Insert")) {
                heap.insert(Integer.valueOf(input.split(" ")[1]));
            } else {
                System.out.println(heap.max());
            }
        }*/

    }

    @Override
    public String toString() {
        return "MaxPQ{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}
