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

  @negative_login
  Scenario: Login User with incorrect email and password
    Given Launch browser and navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When Click on Signup_Login button
    Then Verify Login to your account is visible
    When Enter incorrect email address and password
    And Click login button
    Then Verify error Your email or password is incorrect! is visible

  @logout
  Scenario: Logout User End to End
    Given Launch browser and navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When Click on Signup_Login button
    Then Verify Login to your account is visible
    When Enter correct email address and password
    And Click login button
    Then Verify that Logged in as username is visible
    When Click Logout button
    Then Verify that user is navigated to login page