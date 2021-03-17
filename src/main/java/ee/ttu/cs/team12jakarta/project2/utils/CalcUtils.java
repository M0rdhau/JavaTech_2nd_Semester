package ee.ttu.cs.team12jakarta.project2.utils;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collection;

@Service
public class CalcUtils {

    public static Integer maxOdd(List<Integer> input) {
        return input.stream().filter(num -> num % 2 != 0).max(Integer::compareTo).get();
    }

    public static Integer sum(List<Integer> input) {
        return input.stream().reduce(Integer::sum).get();
    }

    public static List<Integer> absolutes(List<Integer> input) {
        List<Integer> collectedList = input.stream().map(e -> ((e < 0) ? e * (-1) : e)).collect(Collectors.toList());
        if (collectedList.isEmpty()) return null;
        return collectedList;
    }

    private static List<Integer> nullIfEmpty(List<Integer> collection) {
        if (collection == null || collection.isEmpty()) return null;
        return collection;
    }

    public static List<Integer> positives(List<Integer> input) {
        return nullIfEmpty(input.stream().filter(num -> num > 0).collect(Collectors.toList()));
    }

    public static Double averageOfEven(List<Integer> input) {
        return input.stream()
                    .filter(num -> num % 2 == 0)
                    .mapToDouble(num -> num)
                    .average().orElse(Double.NaN);
    }
}
