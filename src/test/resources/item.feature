Feature: As an API consumer
  I want to manage the items using the REST API

  Scenario: item using REST
    When I did a post request "item" with the values:
      | Content  | new Item|
    Then The response should contain the data with the string value "Content" and "new Item"

    When I did a put request "item" with the id "9307043" and the values:
      | Content  | modified item|
    Then The response should contain the data with the string value "Content" and "modified item"

    When I did a get request "item" with the id "9307043"
    Then The response should contain "Id" and "9307043"

    When I did a get all request "item"
    Then Response is not empty

    When I did a delete request "item" with the id "9307044"
    Then The response should contain "Deleted" and "true"


