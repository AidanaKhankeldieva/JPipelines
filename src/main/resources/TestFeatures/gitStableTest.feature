@gitstable @smokeTest @regressionTest
Feature: Testing Gitstable website

    Background:
      Given User is on gitstable website loginpage
  @loginP
  Scenario: Verifying LogIn functionality with valid credentials
    Then User logs in with valid crendetials login "demo" password "demo"
    Then User verifies logged in to homepage
  @loginN
  Scenario:  Verifying LogIn functionality with invalid credentials
    Then User logs in with valid crendetials login "demoo" password "demoo"
    And User verifies error "Invalid username or password." message

