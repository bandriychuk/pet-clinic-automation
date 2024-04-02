package pet.clinic.api.steps.user;


import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pet.clinic.api.conditions.Conditions;
import pet.clinic.api.models.payloads.users.UserModel;
import pet.clinic.api.services.users.parameters.UserParameters;
import pet.clinic.api.steps.AbstractStepDefinitions;

import java.util.Map;

@Slf4j
public class UserSteps extends AbstractStepDefinitions {

    @DataTableType
    public UserParameters mapToUserParameters(Map<String, String> values) {
        return new UserParameters(values);
    }

    @When("Create new user with values:")
    public void createNewUserWithValues(UserParameters userParameters) {
        UserModel createUser = services.usersApiService()
                .createUser(userParameters)
                .shouldHave(Conditions.statusCode(201))
                .asPojo(UserModel.class);

        runtimeState.addCreatedUser(createUser);
    }

    @Then("Verify that created user {runtimeState} has correct value:")
    public void verifyThatUserHasCorrectValue(UserModel userModel, UserParameters userParameters) {
        services
                .usersApiService()
                .getUserApiHelper()
                .verifyThatCreatedUserHasCorrectValues(userModel, userParameters);
    }
}
