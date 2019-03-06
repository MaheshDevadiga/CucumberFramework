#Author: mahesh.devadiga@itcinfotech.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Automated End to End Test
  Automation of car booking from end to end

  @tag1
  Scenario Outline: Customer books the car
    Given Customer is on home page
    When Customer navigates to car booking page
    And he books the car on <date> to <date> from Manchester to Kaapa
    	| 09/02/2019 | 21/02/2019 |
    And he selects the Toyota Car
    And he selects location and time
    And he enters all "<customer>" details
    And he selects credit card for payment
    And he enters "<creditcardname>" details
    Then verify the DropLocationName
    Examples:
    	| customer | creditcardname |
    	| Sangram |	Sangram |