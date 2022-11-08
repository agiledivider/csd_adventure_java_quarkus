Feature: Dishwasher (white good)

  Scenario: A new dishwasher is made by ACME.
    Given I have a new dishwasher.
    When I read the make plate.
    Then I am told "ACME".

  Scenario: A new dishwasher is model Superswoosh 9000XR
    Given I have a new dishwasher.
    When I read the model plate.
    Then I am told "Superswoosh 9000XR".

  Scenario: A new dishwasher can load 12 plates.
    Given I have a new dishwasher.
    When I check the maximum plate load count.
    Then I am told 12.

  Scenario: The dishwasher cleans the load.
    Given I have a new dishwasher.
    When I load 12 dirty knives.
    And Start the cleaning.
    Then I get 12 clean knives.

  Scenario: A new dishwasher could load 12 dirty knives.
    Given I have a new dishwasher.
    Then I could 12 dirty knives.
