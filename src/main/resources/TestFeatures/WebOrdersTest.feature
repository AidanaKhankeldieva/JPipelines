@WebOrdersTest
Feature: Testing WebOrders application

  Background:
    Given User is loged in to WebOrders with "Tester" and "test"

  Scenario: Creating order and verifying it is created
    Given User verifies he is on WebOrder Homepage
    Then User goes to Orders page
    And User creates orders
      | Quantity | Customer name | Street | City     | Zip   | Card Nr  | Expire date |
      | 1        | John          | Elm    | Chicago  | 60625 | 12345678 | 06/21        |
      | 2        | Matt          | Clark  | New York | 11229 | 7654321  | 05/24        |
      | 1        | George        | State  | Atlanta  | 40045 | 98765654 | 02/26        |
    Then User goes to View All Orders page
    And User verifies that orders are created
    |Customer name|
    |John         |
    |Matt         |
    |George       |