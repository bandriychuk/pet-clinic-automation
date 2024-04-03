package pet.clinic.api.services.owner.parameters;

import lombok.Value;

import java.util.Map;

@Value
public class OwnerParameters {

    String firstName;
    String lastName;
    String address;
    String city;
    String telephone;

    public OwnerParameters(Map<String, String> values) {
        this.firstName = values.get("firstName");
        this.lastName = values.get("lastName");
        this.address = values.get("address");
        this.city = values.get("city");
        this.telephone = values.get("telephone");
    }
}
