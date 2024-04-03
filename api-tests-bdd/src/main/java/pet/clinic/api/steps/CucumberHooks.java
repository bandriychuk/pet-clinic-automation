package pet.clinic.api.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import pet.clinic.api.conditions.Conditions;

public class CucumberHooks extends AbstractStepDefinitions {

    @Before
    public void setUp() {
        RestAssured.baseURI = apiConfig.getBaseUri();
    }

    @After
    public void cleanUpTestResources() {

        // Delete created owners
        runtimeState.getCreatedOwners()
                .forEach(o -> services.ownerApiService()
                        .deleteOwner(o.getId())
                        .shouldHave(Conditions.statusCode(204)));
    }
}
