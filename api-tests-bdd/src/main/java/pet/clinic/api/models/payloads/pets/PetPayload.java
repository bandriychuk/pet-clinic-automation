package pet.clinic.api.models.payloads.pets;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetPayload {

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private Type type;

    @JsonProperty("birthDate")
    private String birthDate;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Type {

        @JsonProperty("name")
        private String name;
    }
}