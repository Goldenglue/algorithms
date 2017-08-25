package PointsProblems;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PointsDecover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Pair<Integer, Integer>> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            segments.add(new Pair<>(scanner.nextInt(), scanner.nextInt()));
        }
        pointsDecover(segments);
    }

    private static void pointsDecover(List<Pair<Integer, Integer>> segments) {
        segments.sort(Comparator.comparingInt(Pair::getValue));
        List<Integer> points = new ArrayList<>();
        int min = segments.get(0).getKey() - 1;
        for (Pair<Integer, Integer> segment : segments) {
            if (segment.getKey() > min) {
                points.add(segment.getValue());
                min = segment.getValue();
            }
        }
        System.out.println(points.size());
        points.forEach(System.out::println);
    }
}
