package pet.clinic.api.services.pet.params;

import lombok.NonNull;
import lombok.Value;
import pet.clinic.api.parameter.CustomParameterTypes;

import java.time.LocalDate;
import java.util.Map;

/*
 * API docs
 * http://localhost:9966/petclinic/swagger-ui/index.html#/pets/addPet
 * */
@Value
public class PetParameters {

    @NonNull String name;

    @NonNull LocalDate birthDate;

    @NonNull String typeName;


    public PetParameters(Map<String, String> values, CustomParameterTypes cpt) {
        this.name = values.get("name");
        this.typeName = values.get("typeName");
        this.birthDate = cpt.localDate(values.get("birthDate"));
    }

}
