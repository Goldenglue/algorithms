import javafx.util.Pair;

import java.util.*;

public class PointsCover {
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
        int size = segments.size();
        for (int i = 0; i < size; i++) {
            Pair<Integer, Integer> segment = segments.get(i);
            if (segment.getKey() > min) {
                points.add(segment.getValue());
                min = segment.getValue();
            }
        }
        System.out.println(points.size());
        points.forEach(System.out::println);
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
