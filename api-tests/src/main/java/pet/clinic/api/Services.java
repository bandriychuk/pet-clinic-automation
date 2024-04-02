package pet.clinic.api;

import pet.clinic.api.services.users.UsersApiService;
import io.cucumber.spring.ScenarioScope;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
@Getter
@Accessors(fluent = true)
public class Services {

    @Autowired
    protected UsersApiService usersApiService;

}
