@SmokeTest
Feature: F01_Register | User register

  Scenario: Guest user could register with valid data successfully
    Given user select the country Using SCROLL
    When user enter name"dsaa"
    And user select gender and click button Let’s shop
    Then user register successfully


  Scenario: Guest user could not register with invalid data
    Given user select the country Using SCROLL
    When user enter name""
    And user select gender and click button Let’s shop
    Then user register could not register appear for User Toast (Error)Message