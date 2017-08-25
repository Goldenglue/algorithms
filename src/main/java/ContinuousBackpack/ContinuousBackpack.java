package ContinuousBackpack;

import javafx.util.Pair;

import java.util.*;

public class ContinuousBackpack {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pair<Integer, Integer>> items = new ArrayList<>();
        int n = scanner.nextInt();
        int weight = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            items.add(new Pair<>(scanner.nextInt(), scanner.nextInt()));
        }
        calculateMaxValue(items, weight);

    }

    private static void calculateMaxValue(List<Pair<Integer, Integer>> items, int capacity) {
        Comparator<Pair<Integer, Integer>> compare = (o1, o2) -> {
            double key1 = o1.getKey();
            double key2 = o2.getKey();
            double value1 = o1.getValue();
            double value2 = o2.getValue();
            return Double.compare(key1 / value1, key2 / value2);
        };
        items.sort(Collections.reverseOrder(compare));
        System.out.println(items);
        double value = 0.0;

        for (Pair<Integer, Integer> item : items) {
            if (capacity >= item.getValue()) {
                value += item.getKey();
                capacity -= item.getValue();
            } else if (capacity == 0) {
                break;
            } else {
                value += item.getKey() * (((double) capacity) / ((double) item.getValue()));
                break;
            }
        }
        System.out.println(value);
    }
}
