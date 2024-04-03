package pet.clinic.api.steps.owner;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pet.clinic.api.conditions.Conditions;
import pet.clinic.api.models.payloads.owner.OwnerPayload;
import pet.clinic.api.models.payloads.user.UserModel;
import pet.clinic.api.models.responses.owner.CreateOwnerResponse;
import pet.clinic.api.services.owner.parameters.OwnerParameters;
import pet.clinic.api.services.user.parameters.UserParameters;
import pet.clinic.api.steps.AbstractStepDefinitions;

import java.util.Map;

@Slf4j
public class OwnerSteps extends AbstractStepDefinitions {

    @DataTableType
    public OwnerParameters mapToOwnerParameters(Map<String, String> values) {
        return new OwnerParameters(values);
    }


//    When Create new owners with values:
//            | firstName | lastName | address | city | telephone |
//            | testUser  | admin    |         |      |           |

    @When("Create new owner with values:")
    public void createNewOwnerWithValues(OwnerParameters ownerPayload) {
        CreateOwnerResponse createUser = services.ownerApiService()
                .createOwner(ownerPayload)
                .shouldHave(Conditions.statusCode(201))
                .asPojo(CreateOwnerResponse.class);
    }
}
