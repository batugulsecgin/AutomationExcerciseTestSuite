Feature: Contact Us Feature

  @contact
  Scenario: Contact Us Form Submission
    Given Launch browser and navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When Click on Contact Us button
    Then Verify GET IN TOUCH is visible
    When Enter name, email, subject and message
    And Click Submit button
    And Click OK button on the alert
    Then Verify success message Success! Your details have been submitted successfully. is visible
    When Click Home button and verify that landed to home page successfully