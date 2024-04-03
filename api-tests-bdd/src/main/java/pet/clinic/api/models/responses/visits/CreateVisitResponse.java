package pet.clinic.api.models.responses.visits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateVisitResponse {

    @JsonProperty("date")
    private String date;

    @JsonProperty("petId")
    private int petId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("id")
    private int id;
}