package pet.clinic.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@ComponentScan({"pet.clinic"})
@EnableRetry
@EnableConfigurationProperties
public class ApiTests {

    public static void main(String[] args) {
        SpringApplication.run(ApiTests.class, args);
    }
}
