package pet.clinic.api.services.user.parameters;

import lombok.NonNull;
import lombok.Value;

import java.util.Map;

import static java.util.Optional.ofNullable;

@Value
public class UserParameters {

    @NonNull
    String username;
    String password;
    @NonNull
    String roles;
    Boolean enabled;

    public UserParameters(Map<String, String> values) {
        this.username = values.get("username");
        this.password = ofNullable(values.get("password")).map(String::valueOf).orElse("1111"); // set default password
        this.enabled = ofNullable(values.get("enabled")).map(Boolean::parseBoolean).orElse(true);
        this.roles = values.get("roles");
    }
}
