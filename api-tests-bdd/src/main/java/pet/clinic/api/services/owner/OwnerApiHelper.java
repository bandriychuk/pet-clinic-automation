package pet.clinic.api.services.owner;

import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pet.clinic.api.models.responses.owners.CreateOwnerResponse;
import pet.clinic.api.services.owner.parameters.OwnerParameters;
import pet.clinic.api.services.pet.params.PetParameters;

import static org.assertj.core.api.Assertions.assertThat;
import static pet.clinic.api.services.Constants.DATE_FORMATTER;

@Component
@ScenarioScope
@Slf4j
public class OwnerApiHelper {

    public void verifyThatOwnerHasCorrectValues(CreateOwnerResponse createOwner, OwnerParameters expectedOwner) {
        log.info("Verify that created owner has correct values:");
        log.info("Created Owner: " + createOwner.toString());
        log.info("Expected Owner: " + expectedOwner.toString());


        if (expectedOwner.getFirstName() != null) {
            assertThat(createOwner.getFirstName())
                    .as("Verify created owner 'FIRST_NAME'")
                    .isEqualToIgnoringCase(expectedOwner.getFirstName());
        }

        if (expectedOwner.getLastName() != null) {
            assertThat(createOwner.getLastName())
                    .as("Verify created owner 'LAST_NAME'")
                    .isEqualToIgnoringCase(expectedOwner.getLastName());
        }

        if (expectedOwner.getAddress() != null) {
            assertThat(createOwner.getAddress())
                    .as("Verify 'ADDRESS' value")
                    .isEqualToIgnoringCase(expectedOwner.getAddress());
        }

        if (expectedOwner.getCity() != null) {
            assertThat(createOwner.getCity())
                    .as("Verify 'CITY' value")
                    .isEqualToIgnoringCase(expectedOwner.getCity());
        }

        if (expectedOwner.getTelephone() != null) {
            assertThat(createOwner.getTelephone())
                    .as("Verify 'TELEPHONE' value")
                    .isEqualToIgnoringCase(expectedOwner.getTelephone());
        } else {
            throw new IllegalStateException("You must specify the required fields to validate! Requires: FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE");
        }
    }

    public void verifyThatOwnerHasPet(CreateOwnerResponse owner, PetParameters petParameters) {
        owner.getPets().forEach(pet -> {
            assertThat(pet.getName())
                    .as("Verify owner pet 'Name'")
                    .isEqualToIgnoringCase(petParameters.getName());
            assertThat(pet.getBirthDate())
                    .as("Verify owner pet 'Birth Date'")
                    .isEqualToIgnoringCase(DATE_FORMATTER.format(petParameters.getBirthDate()));
            assertThat(pet.getType().getName())
                    .as("Verify owner pet 'Type Name'")
                    .isEqualToIgnoringCase(petParameters.getTypeName());
        });
    }
}
