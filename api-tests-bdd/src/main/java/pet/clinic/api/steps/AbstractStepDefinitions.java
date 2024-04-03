package pet.clinic.api.steps;

import pet.clinic.api.ApiConfigProperties;
import pet.clinic.api.Services;
import pet.clinic.api.state.RuntimeState;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public class AbstractStepDefinitions {

    @Autowired
    protected ApiConfigProperties apiConfig;

    @Autowired
    protected Services services;

    @Autowired
    protected RuntimeState runtimeState;

}
