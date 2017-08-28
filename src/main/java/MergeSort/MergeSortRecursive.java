package MergeSort;

public class MergeSortRecursive {
    private int[] numbers;
    private int[] helper;

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 9, 2, 9};
        MergeSortRecursive msr = new MergeSortRecursive();
        msr.sort(array);
    }

    public void sort(int[] values) {
        this.numbers = values;
        int number = values.length;
        this.helper = new int[number];
        mergeSort(0, number - 1);
    }

    private void mergeSort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;

            mergeSort(low, middle);
            mergeSort(middle + 1, high);

            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        System.arraycopy(numbers, low, helper, low, high + 1 - low);

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle - 1 && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
    }
}
