package ee.ttu.cs.team12jakarta.project2.services;

import ee.ttu.cs.team12jakarta.project2.dto.CalculatorResult;
import ee.ttu.cs.team12jakarta.project2.utils.CalcUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculatorService {

    public CalculatorResult calculateOne(List<Integer> input) {
        List<Integer> nullInput = input.stream().filter(e -> e == null).collect(Collectors.toList());
        if (nullInput.isEmpty() && !input.isEmpty()) {            
            return CalculatorResult.builder()
                                   .maxOdd(CalcUtils.maxOdd(input))
                                   .sum(CalcUtils.sum(input))
                                   .absolutes(CalcUtils.absolutes(input))
                                   .build();
        } else {
            return null;
        }
    }

    public CalculatorResult calculateTwo(List<Integer> input) {
        List<Integer> nullInput = input.stream().filter(e -> e == null).collect(Collectors.toList());
        if (nullInput.isEmpty() && !input.isEmpty()) {
            return CalculatorResult.builder()
                                   .positives(CalcUtils.positives(input))
                                   .averageOfEven(CalcUtils.averageOfEven(input))
                                   .absolutes(CalcUtils.absolutes(input))
                                   .build();
        } else {
            return null;
        }
    }
}
