# tag example

@projectAPI
Feature: Project API
  Description: create, remove

  Background:
    Given I will use the user "tester1" to make the requests

  @createProject
  Scenario Outline: create a Project
    When I create a project "<ProjectName>" using the API
    Then the Project should be obtained with the correct values
  Examples:
    | ProjectName            |
    |My task to do           |
    |things to do before die |
    |Todo for the week 3     |