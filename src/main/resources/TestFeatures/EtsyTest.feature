Feature: Testing Etsy Website

  Scenario: Verifying search functionality
    Given User is on etsy homepage
    Then User searches for "phone wireless charger"
    And User verifies the result is only for searched item

  Scenario: Verifying price range results
    Given User is on etsy homepage
    Then User searches for "iphone"
    Then User choose under 25 price range
    And User verifies the all result prices are under 25


