Feature: Testing Etsy Website

  Background:
    Given User is on etsy homepage

  @api
  Scenario: Verifying search functionality
    Then User searches for "phone wireless charger"
    And User verifies the result is only for searched item

  @api
  Scenario: Verifying price range results
    Then User searches for "phone wireless charger"
    Then User choose under 25 price range
    And User verifies the all result prices are under 25

  @scenarioOutline
  Scenario Outline:Verifying search functionality with different items
    Then User searches for "<item>"
    And User verifies the result is only for searched "<item>"
    Examples:
      | item                   |
      | phone wireless charger |
      | wooden spoon           |

  @scenarioOutline2
  Scenario Outline: Verifying each section of etsy webPage
    When User click on "<section>"
    Then User verifies "<title>"
    Examples:
      | section               | title                         |
      | Jewelry & Accessories | Jewelry & Accessories \| Etsy |
      | Clothing & Shoes      | Clothing & Shoes \| Etsy      |
      | Home & Living         | Home & Living \| Etsy         |
      | Wedding & Party       | Wedding & Party \| Etsy       |
      | Toys & Entertainment  | Toys & Entertainment \| Etsy  |

