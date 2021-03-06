package ee.ttu.cs.team12jakarta.project2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CalculatorResult {
    private Integer maxOdd;
    private Integer sum;
    private List<Integer> absolutes;
}
