package pet.clinic.api.state;

import pet.clinic.api.models.payloads.user.UserModel;
import io.cucumber.spring.ScenarioScope;
import lombok.Getter;
import org.springframework.stereotype.Component;

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
     * List of users created during test scenario
     * They would be removed after completion
     * **/
    private final List<UserModel> createdUser = new LinkedList<>();

    public void addCreatedUser(UserModel userModel) {
        this.createdUser.add(userModel);
    }
}
