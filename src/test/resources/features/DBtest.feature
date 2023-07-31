@API @DB
Feature: Shiki - DB check

  Background:
    Given Site Shiki is working


#  Scenario: Search for one of the highest score manga
#    When I looking for Anime with name Name in DB
#    And I looking for Anime with id 1
#    Then Anime name should be equal in DB



  Scenario: Search for one of the highest score manga
    When I looking for Anime with id 7
    And Transform JSON to Object
    Then Put fields of this object into DB

