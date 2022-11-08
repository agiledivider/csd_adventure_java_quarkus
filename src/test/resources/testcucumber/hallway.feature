Feature: hallway
  The hallway connects all rooms in our game.

  Scenario: Use the door from the washroom to the hallway
    Given I am in the washroom
    When I use the door to the hallway
    Then I am now in the hallway

  Scenario: Use the door from the hallway to the team office
    Given I am in the hallway
    When I use the door to the team office
    Then I am now in the team office