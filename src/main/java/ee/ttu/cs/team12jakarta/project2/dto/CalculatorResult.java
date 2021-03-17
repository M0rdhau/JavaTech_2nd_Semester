package ee.ttu.cs.team12jakarta.project2.dto;

import lombok.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalculatorResult {
    private List<Integer> absolutes;
    private Integer maxOdd;
    private Integer sum;
    private List<Integer> positives;
    private Double averageOfEven;
}
