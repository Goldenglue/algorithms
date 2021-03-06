package PointsProblems;

import javafx.util.Pair;

import java.util.*;

public class PointsCover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Double> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(scanner.nextDouble());
        }
        pointsCover(points);
    }





    private static List<Pair<Double, Double>> pointsCover(List<Double> points) {
        points.sort(Comparator.comparingDouble(o -> o));
        List<Pair<Double, Double>> result = new ArrayList<>();
        System.out.println(points);
        int size = points.size();
        for (int i = 0; i < size - 1; ) {
            Double left = points.get(i);
            Double right = left + 1.0;
            Pair<Double, Double> segment = new Pair<>(left, right);
            System.out.println(segment);
            result.add(segment);
            i++;
            while (i < size - 1 && points.get(i) <= right) {
                i++;
            }
        }
        return result;
    }
}
