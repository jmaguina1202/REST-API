Feature: Project
  I want to manage the projects using the REST API

  Background: create project
    Given I did a post request "project" with the values:
      | Content | nameProject |
      | Icon    | 6           |
    When I store the response "project"
    Then The response should contain the data with the string value "Content" and "nameProject"

  Scenario: project using REST
    When I did a put request "project" with the id "project.Id" and the values:
      | Content | NameModified |
      | Icon    | 4            |
    Then The response should contain the data with the string value "Content" and "NameModified"

    When I did a get request "project" with the id "project.Id"
    Then The response should contain "Id" and "project.Id"

    When I did a get all request "project"
    Then Response is not empty

    When I did a delete request "project" with the id "project.Id"
    Then The response should contain "Deleted" and "true"