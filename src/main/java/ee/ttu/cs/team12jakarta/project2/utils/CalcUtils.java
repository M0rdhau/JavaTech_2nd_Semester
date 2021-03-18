package ee.ttu.cs.team12jakarta.project2.utils;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collection;

@Service
public class CalcUtils {

    // Next two functions are written in an odd way, with a try-catch block surrounding them
    // because originally, tests required that on null input the output be null.
    // in the last commit I removed try/catch block because the CalculatorService was already
    // dealing with null input - implementing the same approach as in the service looks like
    // copy-pasted code to me, while try/catch just looks ugly.
    // couldn't figure a better way to do it
    public static Integer maxOdd(List<Integer> input) {
        try{
            return input.stream().filter(num -> num % 2 != 0).max(Integer::compareTo).get();
        } catch(Exception e){
            //log the exception
            return null;
        }
    }

    public static Integer sum(List<Integer> input) {
        try{
            return input.stream().reduce(Integer::sum).get();
        } catch (Exception e){
            //log the exception
            return null;
        }
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
