Feature: Products and Product Details Feature

  @products
  Scenario: Verify All Products and product detail page
    Given Launch browser and navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    When Click on View Product of first product
    Then User is landed to product detail page
    And Verify that details are visible: product name, category, price, availability, condition, brand