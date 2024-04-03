package pet.clinic.api.services.owner.parameters;

import lombok.Value;
import pet.clinic.api.parameter.CustomParameterTypes;

import java.util.Map;

/*
 * API docs
 * http://localhost:9966/petclinic/swagger-ui/index.html#/owners/addOwner
 * */
@Value
public class OwnerParameters {

    String firstName;
    String lastName;
    String address;
    String city;
    String telephone;

    public OwnerParameters(Map<String, String> values, CustomParameterTypes cpt) {
        this.firstName = cpt.elString(values.get("firstName"));
        this.lastName = cpt.elString(values.get("lastName"));
        this.address = values.get("address");
        this.city = values.get("city");
        this.telephone = values.get("telephone");
    }
}
