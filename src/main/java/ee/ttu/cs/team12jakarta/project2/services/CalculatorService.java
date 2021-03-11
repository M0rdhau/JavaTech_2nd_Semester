package ee.ttu.cs.team12jakarta.project2.services;

import ee.ttu.cs.team12jakarta.project2.dto.CalculatorResult;
import ee.ttu.cs.team12jakarta.project2.utils.CalcUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculatorService {

    public CalculatorResult calculateOne(List<Integer> input){
        List<Integer> nullInput = input.stream().filter(e -> e == null).collect(Collectors.toList());
        if(nullInput.isEmpty() && !input.isEmpty()){
            CalculatorResult res = new CalculatorResult();
            res.setMaxOdd(CalcUtils.maxOdd(input));
            res.setSum(CalcUtils.sum(input));
            res.setAbsolutes(CalcUtils.absolutes(input));
            return res;
        }else{
            return null;
        }
    }
}
