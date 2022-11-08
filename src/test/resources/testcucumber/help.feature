Feature: We want help
  Ich möchte Hilfe bekommen, damit ich weiß, was ich überhaupt machen kann.

  Scenario: help on the loo
    Given I am on the loo
    When I ask for help
    Then I see "look around"
    And I see "go through door"
    And I see "look at magazines"

  Scenario: help in the washroom
    Given I am in the washroom
    When I ask for help
    Then I see "look around"
    And I see "use door to hallway"

  Scenario: help in the team office
    Given I am in the team office
    When I ask for help
    Then I see "look around"
    And I see "use door to hallway"

  Scenario: help in the Hallway
    Given I am in the hallway
    When I ask for help
    Then I see "look around"
    And I see "go through door"
    And I see "use door to kitchen"
    And I see "use door to team office"


  
