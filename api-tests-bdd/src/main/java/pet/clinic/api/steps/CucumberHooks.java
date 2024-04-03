package pet.clinic.api.steps;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class CucumberHooks extends AbstractStepDefinitions {

    @Before
    public void setUp() {
        RestAssured.baseURI = apiConfig.getBaseUri();
    }
}
