Feature: As an API consumer
  I want to manage the user using the REST API

  Background:
    Given I did a post request "user" with the values:
      | Email    | Newuser4@email.com |
      | FullName | Joe Blow           |
      | Password | pASswoRd           |
    Then I store the response "user"
    Then The response should have a "FullName" attribute with value: "Joe Blow"

  @user
  Scenario: project using REST
    When I did a get request "user" with the id "user.Id"
    Then The response should have a "Id" attribute with value: "user.Id"

    When I did a get all request "user"
    Then Response is not empty

    When I did a put request "user" with the id "user.Id" and the values:
      | FullName | rob |
    Then The response should have a "FullName" attribute with value: "rob"


