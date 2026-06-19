Feature: Subscription Feature

  @subscription
  Scenario: Verify Subscription in home page
    Given Launch browser and navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When Scroll down to footer
    Then Verify text SUBSCRIPTION
    When Enter email address in input and click arrow button
    Then Verify success message You have been successfully subscribed! is visible

  @cart_subscription
  Scenario: Verify Subscription in Cart page
    Given Launch browser and navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When Click Cart button
    Then Scroll down to footer
    And Verify text SUBSCRIPTION
    When Enter email address in input and click arrow button
    Then Verify success message You have been successfully subscribed! is visible