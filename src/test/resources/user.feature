Feature: As an API consumer
  I want to manage the projects using the REST API

  Scenario: project using REST
    When I did a post request "user" with the values:
      | Email        | usernew10@email.com|
      | FullName     | Joe Blow      |
      | Password     | pASswoRd      |
    Then The response should contain the data with the string value "FullName" and "Joe Blow"

    When I did a get request "user" with the id "574257"
    Then The response should contain "Id" and "574257"

    When I did a get all request "user"
    Then Response is not empty

    When I did a put request "user" with the id "3494146" and the values:
      | FullName  | rob|
    Then The response should contain the data with the string value "FullName" and "rob"