package pet.clinic.api.models.payloads.user;

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
/**
 * !! UserModel is used for building request and casts  response to objects due to the same fields model
 */
public class UserModel {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("roles")
    private List<RolesItem> roles;

    @JsonProperty("enabled")
    private Boolean enabled;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RolesItem{

        @JsonProperty("name")
        private String name;

    }
}