package pet.clinic.api.services.owner;

import io.cucumber.spring.ScenarioScope;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pet.clinic.api.assertions.AssertableResponse;
import pet.clinic.api.services.ApiService;
import pet.clinic.api.services.owner.parameters.OwnerParameters;

@Getter
@Slf4j
@Component
@ScenarioScope
public class OwnerApiService extends ApiService {

    @Autowired
    protected OwnerApiHelper ownerApiHelper;

    @Step("Create new user with properties: ")
    public AssertableResponse createOwner(OwnerParameters ownerPayload) {



        return new AssertableResponse(
                setUp()
                        .when()
                        .body(ownerPayload)
                        .post("/api/owners")
                        .then()
                        .extract()
                        .response());
    }


}
