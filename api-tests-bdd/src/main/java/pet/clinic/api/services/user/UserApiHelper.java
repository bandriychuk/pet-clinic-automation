package pet.clinic.api.services.user;

import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pet.clinic.api.models.payloads.users.UserModel;
import pet.clinic.api.services.user.parameters.UserParameters;

import static org.assertj.core.api.Assertions.assertThat;

@Component
@ScenarioScope
@Slf4j
public class UserApiHelper {

    public void verifyThatCreatedUserHasCorrectValues(UserModel createdUserValues, UserParameters expectedUserValues) {
        log.info("Verify that created user has correct values:");
        log.info("Created User: " + createdUserValues.toString());
        log.info("Expected User: " + expectedUserValues.toString());
        if (expectedUserValues.getUsername() != null) {
            assertThat(createdUserValues.getUsername())
                    .as("Verify created user 'USERNAME'")
                    .contains(expectedUserValues.getUsername());
        }
        if (expectedUserValues.getPassword() != null) {
            assertThat(createdUserValues.getPassword())
                    .as("Verify created 'PASSWORD'")
                    .contains(expectedUserValues.getPassword());
        }
        if (expectedUserValues.getRoles() != null) {
            assertThat(expectedUserValues.getRoles())
                    .as("Verify 'ROLES' value")
                    .isEqualToIgnoringCase(createdUserValues.getRoles().get(0).getName());
        }
        if (expectedUserValues.getEnabled() != null) {
            assertThat(createdUserValues.getEnabled())
                    .as("Verify created 'ENABLED'")
                    .isEqualTo(expectedUserValues.getEnabled());
        } else {
            throw new IllegalStateException("You must specify the required fields to validate! Requires: USERNAME, PASSWORD, ROLES. \n Optional: ENABLED");
        }

    }

}
