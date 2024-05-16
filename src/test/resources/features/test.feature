Feature: Guess the word

  @Smoke
  Scenario: Make simple api request
    When we send API request
    Then api request successful
    Then api request 400