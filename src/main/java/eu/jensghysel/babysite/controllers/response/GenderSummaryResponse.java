package eu.jensghysel.babysite.controllers.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GenderSummaryResponse {
    private double percentageBoys;
    private double percentageGirls;
}
