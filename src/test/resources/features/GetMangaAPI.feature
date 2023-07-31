@API
Feature: Shiki - API manga check

  Background:
    Given Site Shiki is working


  Scenario: Search for one of the highest score manga
    When Check for API work by List of Manga
    Then Should be presented with manga Slam Dunk

  Scenario: Search magna by id
    When I looking for manga with id 1
    Then Manga should be named Monster