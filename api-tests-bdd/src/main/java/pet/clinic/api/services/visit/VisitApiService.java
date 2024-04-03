package pet.clinic.api.services.visit;

import io.cucumber.spring.ScenarioScope;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pet.clinic.api.assertions.AssertableResponse;
import pet.clinic.api.services.ApiService;

@Getter
@Slf4j
@Component
@ScenarioScope
public class VisitApiService extends ApiService {

    @Autowired
    protected VisitApiHelper visitApiHelper;

    @Step("Get Visit by Id: {0}")
    public AssertableResponse getVisitById(int visitId) {
        return new AssertableResponse(
                setUp()
                        .when()
                        .get(String.format("/api/visits/%s", visitId))
                        .then()
                        .extract()
                        .response());
    }

}
