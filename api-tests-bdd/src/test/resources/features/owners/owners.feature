Feature: Owners Feature

  Scenario: Create and Updated new owners with properties
    When Create new owners:
      | firstName  | lastName       | address            | city    | telephone  |
      | userName   | userLastName   | 110 W. Liberty St. | Madison | 6085551023 |
      | secondName | secondLastName | 110 W. Liberty St. | London  | 1235551023 |
    Then Verify that created owners "#{createdOwners[0]}" has correct value:
      | firstName | lastName     | address            | city    | telephone  |
      | userName  | userLastName | 110 W. Liberty St. | Madison | 6085551023 |
    And Verify that created owners "#{createdOwners[1]}" has correct value:
      | firstName  | lastName       | address            | city   | telephone  |
      | secondName | secondLastName | 110 W. Liberty St. | London | 1235551023 |
    And Update owners "#{createdOwners[0]}" values:
      | firstName | lastName | address            | city    | telephone  |
      | newFN     | newLN    | 114 W. Liberty St. | newCity | 1999991023 |
    Then Verify that created owners "#{createdOwners[0]}" has correct value:
      | firstName | lastName | address            | city    | telephone  |
      | newFN     | newLN    | 114 W. Liberty St. | newCity | 1999991023 |
    And Verify that created owners "#{createdOwners[1]}" has correct value:
      | firstName  | lastName       | address            | city   | telephone  |
      | secondName | secondLastName | 110 W. Liberty St. | London | 1235551023 |


  Scenario: Adds a pet to an owner and adds a vet visit
    When Create owner with pets:
      | name | birthDate | typeName |
      | Leo  | today-10  | dog      |
    Then Verify that owner "#{createdOwners[0]}" has pet:
      | name | birthDate | typeName |
      | Leo  | today-10  | dog      |
    And Owner "#{createdOwners[0]}" adds a vet visit:
      | date    | description |
      | today+5 | rabies shot |
    Then Verify that the visit "#{createdVisits[0]}" has correct values:
      | date    | description |
      | today+5 | rabies shot |
