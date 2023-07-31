#Неактуальный файл т.к не обходится капча
@GUI

Feature: Shiki - Login Page

  Background:
    Given I access the Shikimori login page


  Scenario: Validate Successful Login
    When I enter a login AttstPr
    And I enter a shiki password Pswrd!209
    And I click on the entry button
    And I click checkbox button
    Then I should be presented with the successful entry message

  Scenario: Validate Unsuccessful Login
    When I enter a username webdriver
    And I enter a password password123
    And I click on the login button
    Then I should be presented with the unsuccessful login message

  @smoke
  Scenario Outline: Validate - Successful & Unsuccessful Login
    When I enter a username <username>
    And I enter a password <password>
    And I click on the login button
    Then I should be presented with the following login validation message <loginValidationMessage>

    Examples:
      | username  | password     | loginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |
      | webdriver | webdriver1   | validation failed      |
      | joe_blogs | password1    | validation failed      |

