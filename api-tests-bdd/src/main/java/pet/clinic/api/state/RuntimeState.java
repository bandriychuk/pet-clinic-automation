package pet.clinic.api.state;

import io.cucumber.spring.ScenarioScope;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import pet.clinic.api.models.payloads.users.UserModel;
import pet.clinic.api.models.responses.owners.CreateOwnerResponse;
import pet.clinic.api.models.responses.pets.CreatePetResponse;
import pet.clinic.api.models.responses.visits.CreateVisitResponse;

import java.time.Instant;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;

/**
 * General class to store runtime state across step definitions in one Scenario/Example.
 * Can be autowired into step definitions class.
 */
@Getter
@Component
@ScenarioScope
public class RuntimeState {

    /**
     * Date time of test scenario
     */
    private final Instant testDateTime;

    /**
     * TimeZone used for test scenario
     */
    private final ZoneId testTimeZone;

    /**
     * Readable unique identifier of test execution.
     * May be used to generate unique names.
     */
    @Getter
    private final String testPostfix;


    public RuntimeState() {
        this.testDateTime = Instant.now();
        this.testTimeZone = ZoneId.of("Europe/London");
        this.testPostfix = RandomStringUtils.random(8, true, false);
    }

    /**
     * List of users created during test scenario
     * They would be removed after completion
     **/
    private final List<UserModel> createdUsers = new LinkedList<>();

    /**
     * List of owners created during test scenario
     * They would be removed after completion
     **/
    private final List<CreateOwnerResponse> createdOwners = new LinkedList<>();

    /**
     * List of pets created during test scenario
     * They would be removed after completion
     **/
    private final List<CreatePetResponse> createdPets = new LinkedList<>();
    private final List<CreateVisitResponse> createdVisits = new LinkedList<>();

    public void addCreatedOwners(CreateOwnerResponse owner) {
        this.createdOwners.add(owner);
    }

    public void addCreatedVisits(CreateVisitResponse visit) {
        this.createdVisits.add(visit);
    }

    public void addCreatedUsers(UserModel userModel) {
        this.createdUsers.add(userModel);
    }

    public void addCreatedPets(CreatePetResponse userModel) {
        this.createdPets.add(userModel);
    }
}
