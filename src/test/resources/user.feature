Feature: As an API consumer
  I want to manage the user using the REST API

  Background:
    Given I did a post request "user" with the values:
      | Email        | Newuser123@email.com|
      | FullName     | Joe Blow      |
      | Password     | pASswoRd      |
    Then I store the response "user"
    Then The response should contain the data with the string value "FullName" and "Joe Blow"

  Scenario: project using REST
    When I did a get request "user" with the id "user.Id"
    Then The response should contain "Id" and "user.Id"

    When I did a get all request "user"
    Then Response is not empty

    When I did a put request "user" with the id "user.Id" and the values:
      | FullName  | rob|
    Then The response should contain the data with the string value "FullName" and "rob"

    When I did a delete request "user" with the id "user.Id"
    Then The response should contain "Deleted" and "true"

