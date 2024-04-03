package pet.clinic.api.services;

import io.cucumber.spring.ScenarioScope;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pet.clinic.api.ApiConfigProperties;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

@Component
@ScenarioScope
@Slf4j
public class ApiService {

    @Autowired
    public ApiConfigProperties apiTestsProperties;

    protected RequestSpecification setUp() {
        return RestAssured
                .given()
                .filters(getFilters())
                .contentType(ContentType.JSON);
    }

    private List<Filter> getFilters() {
        if (apiTestsProperties.getLogging()) {
            return Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
        }
        return singletonList(new AllureRestAssured());
    }

}
