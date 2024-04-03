package pet.clinic.api.steps.visit;

import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import pet.clinic.api.conditions.Conditions;
import pet.clinic.api.models.responses.visits.CreateVisitResponse;
import pet.clinic.api.services.visit.params.VisitParameters;
import pet.clinic.api.steps.AbstractStepDefinitions;

@Slf4j
public class VisitSteps extends AbstractStepDefinitions {

    @Then("Verify that the visit {runtimeState} has correct values:")
    public void verifyThatVisitHasCorrectValues(CreateVisitResponse visit, VisitParameters visitParameters) {
        CreateVisitResponse createdVisit = services.visitApiService()
                .getVisitById(visit.getId())
                .shouldHave(Conditions.statusCode(200))
                .asPojo(CreateVisitResponse.class);

        services.visitApiService()
                .getVisitApiHelper()
                        .verifyThatVisitHasCorrectValues(createdVisit, visitParameters);

        runtimeState.addCreatedVisits(createdVisit);
    }
}
