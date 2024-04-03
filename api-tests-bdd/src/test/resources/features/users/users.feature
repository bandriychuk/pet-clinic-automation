Feature: Users Feature

  Scenario: Create new user with properties
    When Create new user with values:
      | username | roles |
      | testUser | admin |
    Then Verify that created user "#{createdUsers[0]}" has correct value:
      | username | password | roles      |
      | testUser | 1111     | ROLE_admin |

  Scenario: Failed: Create new user with properties
    When Create new user with values:
      | username | roles |
      | testUser | admin |
    Then Verify that created user "#{createdUsers[0]}" has correct value:
      | username | password | roles      |
      | testUser | 1111     | ROLE_admin1 |