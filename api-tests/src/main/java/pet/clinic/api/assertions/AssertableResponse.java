package pet.clinic.api.assertions;

import pet.clinic.api.conditions.Condition;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class AssertableResponse {

    private final Response response;

    public <T> T asPojo(Class<T> clazz) {
        return response.as(clazz);
    }

    @Step("Assertable response should have: '{0}'")
    public AssertableResponse shouldHave(Condition condition) {
        log.info("Asserting condition {}", condition);
        condition.check(response);
        return this;
    }
}
