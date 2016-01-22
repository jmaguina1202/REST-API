Feature: Item
  I want to manage the item using the REST API

  Background: create item
    Given I did a post request "item" with the values:
      | Content | new Item |
    Then I store the response "item"
    Then The response should have a "Content" attribute with value: "new Item"

  @item
  Scenario: item using REST
    When I did a put request "item" with the id "item.Id" and the values:
      | Content | modified item |
    Then The response should have a "Content" attribute with value: "modified item"

    When I did a get request "item" with the id "item.Id"
    Then The response should have a "Id" attribute with value: "item.Id"

    When I did a get all request "item"
    Then Response is not empty

    When I did a delete request "item" with the id "item.Id"
    Then The response should have a "Deleted" attribute with value: "true"
