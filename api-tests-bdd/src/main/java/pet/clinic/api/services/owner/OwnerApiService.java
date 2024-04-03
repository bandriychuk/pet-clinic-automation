package pet.clinic.api.services.owner;

import io.cucumber.spring.ScenarioScope;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pet.clinic.api.assertions.AssertableResponse;
import pet.clinic.api.models.payloads.owners.OwnerPayload;
import pet.clinic.api.models.payloads.pets.PetPayload;
import pet.clinic.api.models.payloads.visits.VisitPayload;
import pet.clinic.api.models.responses.owners.CreateOwnerResponse;
import pet.clinic.api.models.responses.owners.GetOwnerByIdResponse;
import pet.clinic.api.services.ApiService;
import pet.clinic.api.services.owner.parameters.OwnerParameters;
import pet.clinic.api.services.pet.params.PetParameters;
import pet.clinic.api.services.visit.params.VisitParameters;

import static pet.clinic.api.services.Constants.DATE_FORMATTER;

@Getter
@Slf4j
@Component
@ScenarioScope
public class OwnerApiService extends ApiService {

    @Autowired
    protected OwnerApiHelper ownerApiHelper;

    @Step("Create new owner")
    public AssertableResponse createOwner(OwnerParameters owner) {
        OwnerPayload newOwnerBody = OwnerPayload.builder()
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .address(owner.getAddress())
                .city(owner.getCity())
                .telephone(owner.getTelephone())
                .build();

        return new AssertableResponse(
                setUp()
                        .when()
                        .body(newOwnerBody)
                        .post("/api/owners")
                        .then()
                        .extract()
                        .response());
    }

    @Step("Create new owner")
    public AssertableResponse createDefaultOwner() {
        return new AssertableResponse(
                setUp()
                        .when()
                        .body(OwnerPayload.builder()
                                .firstName("Borys")
                                .lastName("Andriychuk")
                                .address("Lampwing Lane 12")
                                .city("Manchester")
                                .telephone("123456789")
                                .build())
                        .post("/api/owners")
                        .then()
                        .extract()
                        .response());
    }

    @Step("Add vet visit")
    public AssertableResponse addVetVisit(CreateOwnerResponse createdOwner, VisitParameters visitParam) {

        int ownerId = createdOwner.getId();

        int petOwnerId = getOwnerById(ownerId).asPojo(GetOwnerByIdResponse.class).getPets().get(0).getId();


        return new AssertableResponse(
                setUp()
                        .when()
                        .body(VisitPayload.builder()
                                .date(DATE_FORMATTER.format(visitParam.getDate()))
                                .description(visitParam.getDescription())
                                .build())
                        .post(String.format("/api/owners/%s/pets/%s/visits", ownerId, petOwnerId))
                        .then()
                        .extract()
                        .response());
    }

    @Step("Add Pet to Owner with Id: {0}")
    public AssertableResponse addPetToOwnerWithId(int ownerId, PetParameters petParameters) {
        return new AssertableResponse(
                setUp()
                        .when()
                        .body(PetPayload.builder()
                                .name(petParameters.getName())
                                .birthDate(DATE_FORMATTER.format(petParameters.getBirthDate()))
                                .type(PetPayload.Type.builder()
                                        .name(petParameters.getTypeName())
                                        .build())
                                .build())
                        .post(String.format("/api/owners/%s/pets", ownerId))
                        .then()
                        .extract()
                        .response());
    }


    @Step("Updated Owner")
    public AssertableResponse updateOwner(CreateOwnerResponse createOwner, OwnerParameters newOwnerValues) {
        OwnerPayload newOwnerBody = OwnerPayload.builder()
                .firstName(newOwnerValues.getFirstName())
                .lastName(newOwnerValues.getLastName())
                .address(newOwnerValues.getAddress())
                .city(newOwnerValues.getCity())
                .telephone(newOwnerValues.getTelephone())
                .build();
        return new AssertableResponse(
                setUp()
                        .when()
                        .body(newOwnerBody)
                        .put(String.format("/api/owners/%s", createOwner.getId()))
                        .then()
                        .extract()
                        .response());
    }

    @Step("Delete Owner with id:'{0}'")
    public AssertableResponse deleteOwner(int ownerId) {
        return new AssertableResponse(
                setUp()
                        .when()
                        .delete(String.format("/api/owners/%s", ownerId))
                        .then()
                        .extract()
                        .response());
    }

    @Step("Get Owner by Id: {0}")
    public AssertableResponse getOwnerById(int ownerId) {
        return new AssertableResponse(
                setUp()
                        .when()
                        .get(String.format("/api/owners/%s", ownerId))
                        .then()
                        .extract()
                        .response());
    }

}
