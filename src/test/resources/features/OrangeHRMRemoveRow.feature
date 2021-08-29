@regression @ui @MB2P-117
Feature: Validating  OrangeHR application functionalities

  Background: Repeated  only first steps in each scenario.
    Given  user navigates to OrangeHR application
    When  user provides user name "Admin" and "admin123" and clicks on login
    And user clicks on Time and chooses Timesheet


  Scenario: Validating Edit and remove timesheet functionality
    And user click on Edit button, provides data and clicks to add row button
    And user selects one sheet and removes it
    Then  user validates that selected row was deleted with success message "Successfully Removed"

  Scenario: Validating  remove timesheet functionality without selecting timesheet
    And user clicks on Edit without choosing timesheet and clicks Remove Row
    Then user validates errorMessage "Select Records to Remove"

  Scenario: Validating remove functionality by selecting timesheet but with no data
    And user clicks on Edit and selects first row without data
    Then Validates warning message "No Changes to Delete"