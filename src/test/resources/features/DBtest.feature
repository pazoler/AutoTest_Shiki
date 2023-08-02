@API @DB
Feature: Shiki - DB check

  Background:
    Given Site Shiki is working


  Scenario: Search for one of the highest score manga
    When I looking for Anime with name 1 in DB
    And I looking for Anime with id 154
    Then Anime name should be equal in DB


#  Scenario: Search for one of the highest score manga
#    When I looking for Anime with field name and value Shaman King in DB
#    And I looking for Anime with id 154
#    Then Anime name should be equal in DB

#
#  Scenario: Search for one of the highest score manga
#    When I looking for Anime with id 154
#    And Transform JSON to Object
#    Then Put fields of this object into DB

