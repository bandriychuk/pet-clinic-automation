package pet.clinic.api.services.visit;

import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pet.clinic.api.models.responses.visits.CreateVisitResponse;
import pet.clinic.api.services.visit.params.VisitParameters;

import static org.assertj.core.api.Assertions.assertThat;
import static pet.clinic.api.services.Constants.DATE_FORMATTER;

@Component
@ScenarioScope
@Slf4j
public class VisitApiHelper {

    public void verifyThatVisitHasCorrectValues(CreateVisitResponse createVisit, VisitParameters visitParameters) {
        assertThat(createVisit.getDescription())
                .as("Verify visit 'Description'")
                .isEqualToIgnoringCase(visitParameters.getDescription());

        assertThat(createVisit.getDate())
                .as("Verify visit 'Date'")
                .isEqualToIgnoringCase(DATE_FORMATTER.format(visitParameters.getDate()));
    }

}
