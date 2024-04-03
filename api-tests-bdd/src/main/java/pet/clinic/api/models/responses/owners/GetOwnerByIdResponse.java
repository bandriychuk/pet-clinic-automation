package pet.clinic.api.models.responses.owners;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetOwnerByIdResponse {

    @JsonProperty("pets")
    private List<PetsItem> pets;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("telephone")
    private String telephone;

    @JsonProperty("id")
    private int id;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PetsItem {

        @JsonProperty("visits")
        private List<VisitsItem> visits;

        @JsonProperty("name")
        private String name;

        @JsonProperty("id")
        private int id;

        @JsonProperty("type")
        private Type type;

        @JsonProperty("ownerId")
        private int ownerId;

        @JsonProperty("birthDate")
        private String birthDate;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Type {

        @JsonProperty("name")
        private String name;

        @JsonProperty("id")
        private int id;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VisitsItem {

        @JsonProperty("date")
        private String date;

        @JsonProperty("petId")
        private int petId;

        @JsonProperty("description")
        private String description;

        @JsonProperty("id")
        private int id;
    }
}