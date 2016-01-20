Feature: As an API consumer
  I want to manage the projects using the REST API

  Scenario: project using REST
    When I did a post request "project" with the values:
      | Content  | nameProject|
      | Icon     | 6          |
    Then The response should contain the data with the string value "Content" and "nameProject"

    When I did a put request "project" with the id "3499345" and the values:
      | Content  | NameModified|
      | Icon     | 4           |
    Then The response should contain the data with the string value "Content" and "NameModified"

    When I did a get request "project" with the id "3499345"
    Then The response should contain "Id" and "3499345"

    When I did a get all request "project"
    Then Response is not empty

    When I did a delete request "project" with the id "3499344"
    Then The response should contain "Deleted" and "true"


