package pet.clinic.api.models.payloads.visits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitPayload {

    @JsonProperty("date")
    private String date;

    @JsonProperty("description")
    private String description;
}