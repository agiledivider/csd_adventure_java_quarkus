Feature: Shower

  Scenario: A new shower
    Given I got a shower
    When I check the condition
    Then I should see that the shower is new

  Scenario: A used shower
    Given I got a shower from a friend
    When I check the condition
    Then I should see that the shower is used

  Scenario: A broken shower
    Given I bought a shower at the flea market
    When I check the condition
    Then I should realize that the shower is broken