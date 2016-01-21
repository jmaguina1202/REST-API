Feature: Item
  I want to manage the item using the REST API
  Background: create item
    Given I did a post request "item" with the values:
      | Content  | new Item|
    Then I store the response "item"
    Then The response should contain the data with the string value "Content" and "new Item"

  Scenario: item using REST
    When I did a put request "item" with the id "item.Id" and the values:
      | Content  | modified item|
    Then The response should contain the data with the string value "Content" and "modified item"

    When I did a get request "item" with the id "item.Id"
    Then The response should contain "Id" and "item.Id"

    When I did a get all request "item"
    Then Response is not empty

    When I did a delete request "item" with the id "item.Id"
    Then The response should contain "Deleted" and "true"
