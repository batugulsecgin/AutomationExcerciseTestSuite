Feature: Add Products in Cart Feature

  @add_to_cart
  Scenario: Add Products in Cart
    Given Launch browser and navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When Click on Products button
    Then Hover over first product and click Add to cart
    And Click Continue Shopping button
    Then Hover over second product and click Add to cart
    And Click View Cart button
    Then Verify both products are added to Cart
    And Verify their prices, quantity and total price