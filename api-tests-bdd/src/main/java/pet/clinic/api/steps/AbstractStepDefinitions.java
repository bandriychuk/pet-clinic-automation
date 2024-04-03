package pet.clinic.api.steps;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import pet.clinic.api.ApiConfigProperties;
import pet.clinic.api.Services;
import pet.clinic.api.parameter.CustomParameterTypes;
import pet.clinic.api.state.RuntimeState;

@Getter
public class AbstractStepDefinitions {

    @Autowired
    protected ApiConfigProperties apiConfig;

    @Autowired
    protected Services services;

    @Autowired
    protected RuntimeState runtimeState;

    @Autowired
    protected CustomParameterTypes cpt;

}
