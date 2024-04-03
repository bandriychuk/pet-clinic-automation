package pet.clinic.api.services.visit.params;

import lombok.NonNull;
import lombok.Value;
import pet.clinic.api.parameter.CustomParameterTypes;

import java.time.LocalDate;
import java.util.Map;

/*
 * API docs
 * http://localhost:9966/petclinic/swagger-ui/index.html#/visits/addVisit
 * */
@Value
public class VisitParameters {

    LocalDate date;
    @NonNull
    String description;


    public VisitParameters(Map<String, String> values, CustomParameterTypes cpt) {
        this.date = cpt.localDate(values.get("date"));
        this.description = values.get("description");
    }

}
