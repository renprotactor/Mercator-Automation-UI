@test
Feature: Add Most Expensive Dress to Cart

  Scenario: Successfully add the most expensive dress to the cart
    Given I open the Sauce Demo site
    And I log in with valid credentials
    Then I should see the page title "Products"
    When I add the most expensive dress to the cart
    And I click on the cart icon on the products page
    Then I should see the page title "Your Cart"
    And validate that cart should contain the most expensive dress with the correct price
