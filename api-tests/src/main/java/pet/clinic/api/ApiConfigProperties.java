package pet.clinic.api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("pet.clinic.api-tests")
@Data
public class ApiConfigProperties {

    private String baseUri;

    private String locale;

    private String password;

    private String defaultRole;

    private Boolean logging;

}
