package ee.ttu.cs.team12jakarta.project2.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import java.util.List;

@Getter
@Setter
@Builder
public abstract class CalculatorResult {
    private List<Integer> absolutes;
    private Integer maxOdd;
    private Integer sum;
    private List<Integer> positives;
    private Double averageOfEven;
}
