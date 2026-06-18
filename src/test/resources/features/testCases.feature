Feature: Test Cases Page Verification

  @testcases
  Scenario: Verify Test Cases Page
    Given Launch browser and navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When Click on Test Cases button
    Then Verify user is navigated to test cases page successfully