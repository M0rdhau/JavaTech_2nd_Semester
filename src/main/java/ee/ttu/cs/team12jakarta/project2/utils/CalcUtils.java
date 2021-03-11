package ee.ttu.cs.team12jakarta.project2.utils;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalcUtils {

    public static Integer maxOdd(List<Integer> input){
        try{
            return input.stream().filter(num -> num % 2 != 0).max(Integer::compareTo).get();
        }catch(Exception e){
            return null;
        }
    }

    public static Integer sum(List<Integer> input){
        try{
            return input.stream().reduce(Integer::sum).get();
        }catch(Exception e){
            return null;
        }
    }

    public static List<Integer> absolutes(List<Integer> input){
        try{
            List<Integer> collectedList = input.stream().map(e -> ((e < 0 ) ? e*(-1) : e)).collect(Collectors.toList());
            if(collectedList.isEmpty()) return null;
            return collectedList;
        }catch(Exception e){
            return null;
        }
    }
}
