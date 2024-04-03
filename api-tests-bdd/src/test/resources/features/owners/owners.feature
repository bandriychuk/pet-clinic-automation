Feature: Owners Feature

  Scenario: Create new owner with properties
    When Create new owner with values:
      | firstName | lastName | address | city | telephone |
      | testUser  | admin    |         |      |           |
#    When Update owners with id "#{createdOwners[0].id}" values:
#      | firstName | lastName | address | city | telephone |
#      | testUser  | admin    |         |      |           |
#    Then Verify that created owners "#{createdOwners[0]}" has correct value:
#      | firstName | lastName | address | city | telephone |
#      | testUser  | admin    |         |      |           |


  Scenario: The owner can create a vet visit
    When Create new owners with values:
      | firstName | lastName | address | city | telephone |
      | testUser  | admin    |         |      |           |
    And Create new pet with values:
      | name     | birthDate | name |
      | testUser | admin     | dog  |
#  //api/owners/{ownerId}/pets/{petId}/visits
    When The Owner "OwnerName" with pet "PetName" can create visit:
      | date | description |
      |      |             |
    Then Verify that visit for Owner "OwnerName" with pet "PetName" has correct values:
      | date | description |
      |      |             |