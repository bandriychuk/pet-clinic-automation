package pet.clinic.api.steps.owner;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pet.clinic.api.conditions.Conditions;
import pet.clinic.api.models.responses.owners.CreateOwnerResponse;
import pet.clinic.api.models.responses.pets.CreatePetResponse;
import pet.clinic.api.models.responses.visits.CreateVisitResponse;
import pet.clinic.api.services.owner.parameters.OwnerParameters;
import pet.clinic.api.services.pet.params.PetParameters;
import pet.clinic.api.services.visit.params.VisitParameters;
import pet.clinic.api.steps.AbstractStepDefinitions;

import java.util.List;
import java.util.Map;

@Slf4j
public class OwnerSteps extends AbstractStepDefinitions {

    @DataTableType
    public OwnerParameters mapToOwnerParameters(Map<String, String> values) {
        return new OwnerParameters(values, cpt);
    }

    @DataTableType
    public PetParameters mapToPetParameters(Map<String, String> values) {
        return new PetParameters(values, cpt);
    }

    @DataTableType
    public VisitParameters mapToVisitParameters(Map<String, String> values) {
        return new VisitParameters(values, cpt);
    }


    @When("Create new owners:")
    public void createNewOwnerWithValues(List<OwnerParameters> ownerPayload) {
        ownerPayload.forEach(owner -> {
            CreateOwnerResponse createOwner = services.ownerApiService()
                    .createOwner(owner)
                    .shouldHave(Conditions.statusCode(201))
                    .asPojo(CreateOwnerResponse.class);
            runtimeState.addCreatedOwners(createOwner);
        });
    }

    @And("Update owners {runtimeState} values:")
    public void updateOwnerWithId(CreateOwnerResponse createOwner, OwnerParameters newOwnerValues) {
        services.ownerApiService()
                .updateOwner(createOwner, newOwnerValues)
                .shouldHave(Conditions.statusCode(204));
    }

    @Then("Verify that created owners {runtimeState} has correct value:")
    public void verifyThatCreatedOwnersHasCorrectValue(CreateOwnerResponse createdOwner, OwnerParameters expectedOwner) {
        CreateOwnerResponse getCreatedOwner = services.ownerApiService()
                .getOwnerById(createdOwner.getId())
                .shouldHave(Conditions.statusCode(200))
                .asPojo(CreateOwnerResponse.class);

        services.ownerApiService()
                .getOwnerApiHelper()
                .verifyThatOwnerHasCorrectValues(getCreatedOwner, expectedOwner);
    }


    @When("Create owner with pets:")
    public void createOwnerWithPet(PetParameters pet) {
        CreateOwnerResponse createdDefaultOwner = services.ownerApiService()
                .createDefaultOwner()
                .shouldHave(Conditions.statusCode(201))
                .asPojo(CreateOwnerResponse.class);

        CreatePetResponse createdPet = services.ownerApiService()
                .addPetToOwnerWithId(createdDefaultOwner.getId(), pet)
                .shouldHave(Conditions.statusCode(201))
                .asPojo(CreatePetResponse.class);

        runtimeState.addCreatedOwners(createdDefaultOwner);
        runtimeState.addCreatedPets(createdPet);
    }

    @When("Owner {runtimeState} adds a vet visit:")
    public void ownerAddsVetVisit(CreateOwnerResponse owner, VisitParameters visitParameters) {
        CreateVisitResponse createdVisit = services.ownerApiService()
                .addVetVisit(owner, visitParameters)
                .shouldHave(Conditions.statusCode(201))
                .asPojo(CreateVisitResponse.class);

        runtimeState.addCreatedVisits(createdVisit);
    }

    @Then("Verify that owner {runtimeState} has pet:")
    public void verifyThatOwnerHasPet(CreateOwnerResponse owner, PetParameters petParameters) {
        CreateOwnerResponse ownerWithPet = services.ownerApiService()
                .getOwnerById(owner.getId())
                .shouldHave(Conditions.statusCode(200))
                .asPojo(CreateOwnerResponse.class);

        services.ownerApiService()
                .getOwnerApiHelper()
                .verifyThatOwnerHasPet(ownerWithPet, petParameters);
    }

    @Then("Verify that owner has visit with correct values:")
    public void verifyThatVisitHasCorrectValues(CreateVisitResponse visit, VisitParameters visitParameters) {
        CreateVisitResponse createdVisit = services.visitApiService()
                .getVisitById(visit.getId())
                .shouldHave(Conditions.statusCode(200))
                .asPojo(CreateVisitResponse.class);

        services.visitApiService()
                .getVisitApiHelper()
                .verifyThatVisitHasCorrectValues(createdVisit, visitParameters);

        runtimeState.addCreatedVisits(createdVisit);
    }
}
