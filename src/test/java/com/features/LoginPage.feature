Feature: Login to Orange HRM

  @TC_L0GIN_01
  Scenario: Login to the Application Successfully
    Given User is on the Login Page
    When User enters username "Admin"
    And User enters password "admin123"
    And User clicks on Login button
    Then User should landing to Dashboard Page


  @TC_L0GIN_02
  Scenario: Login to the Application with Invalid UserName
    Given User is on the Login Page
    When User enters username "jAdmin"
    And User enters password "admin123"
    And User clicks on Login button
    Then Error message should appear "Invalid credentials"


  @TC_L0GIN_03
  Scenario: Login to the Application with Invalid Password
    Given User is on the Login Page
    When User enters username "Admin"
    And User enters password "jadmin123"
    And User clicks on Login button
    Then Error message should appear "Invalid credentials"
