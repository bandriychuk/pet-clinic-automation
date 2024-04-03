package pet.clinic.api.services.user;

import pet.clinic.api.assertions.AssertableResponse;
import pet.clinic.api.models.payloads.user.UserModel;
import pet.clinic.api.services.ApiService;
import pet.clinic.api.services.user.parameters.UserParameters;
import io.cucumber.spring.ScenarioScope;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Slf4j
@Component
@ScenarioScope
public class UserApiService extends ApiService {

    @Autowired
    protected UserApiHelper userApiHelper;

    @Step("Create new user with properties: ")
    public AssertableResponse createUser(UserParameters newUserPayload) {

        UserModel requestBody = UserModel.builder()
                .username(newUserPayload.getUsername())
                .password(newUserPayload.getPassword())
                .enabled(newUserPayload.getEnabled())
                .roles(List.of(UserModel.RolesItem.builder().name(newUserPayload.getRoles()).build()))
                .build();

        if (newUserPayload.getUsername() == null || newUserPayload.getRoles() == null) {
            throw new IllegalArgumentException("Fields: 'Username' and Roles[{ name: 'RoleName' }] are required");
        }

        return new AssertableResponse(
                setUp()
                        .when()
                        .body(requestBody)
                        .post("/api/users")
                        .then()
                        .extract()
                        .response());
    }

}
