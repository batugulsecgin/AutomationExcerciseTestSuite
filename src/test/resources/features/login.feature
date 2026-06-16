Feature: User Login Feature

  @smoke
  Scenario: Login User with correct email and password
    Given Launch browser and navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When Click on Signup_Login button
    Then Verify Login to your account is visible
    When Enter correct email address and password
    And Click login button
    Then Verify that Logged in as username is visible