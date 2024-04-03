package pet.clinic.api.models.responses.owner;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateOwnerResponse {

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


    @Builder
    @Data
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

        @Data
        @Builder
        public static class Type {

            @JsonProperty("name")
            private String name;

            @JsonProperty("id")
            private int id;

        }
    }

    @Data
    @Builder
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