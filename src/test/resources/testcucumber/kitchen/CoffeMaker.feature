Feature: There is a coffee maker in the kitchen, that we can use.

  Scenario: Making coffee
    Given we are in the kitchen
    When I look around
    Then I can see the coffee maker

  Scenario: Adding beans
    Given we are in the kitchen
    When I say "add coffee beans"
    Then I see "beans have been added to the coffee machine"

  Scenario: Adding water
    Given we are in the kitchen
    When I say "add water"
    Then I see "water has been added to the coffee machine"

  Scenario: turning in the machine
    Given we are in the kitchen
    When I say "connect power"
    Then I see "You turned on the coffee machine"

  Scenario: putting in a cup
    Given we are in the kitchen
    When I say "put in cup"
    Then I see "You put a cup in the coffee machine"

  Scenario: Making coffee
    Given we are in the kitchen
    And I added all necessary components to the coffee machine
    When I say "make coffee"
    Then I see "you brewed a very nice looking cup of hot coffee"

  Scenario: Making coffee fails
    Given we are in the kitchen
    When I say "make coffee"
    Then I see "Can't make coffee"

  Scenario: Help to make coffee
    Given we are in the kitchen
    When I say "help"
    Then I see "add beans"
    And I see "add water"
    And I see "put in cup"
    And I see "make coffee"
    And I see "connect power"


