
@tag
Feature: placing the order from Ecomerce website


  @Errortest
  Scenario Outline: error validation test for login page
    Given I want to land on login page
    When I want to login with <username> and <password>
    Then check the error message "Incorrect email or password"

    Examples: 
      | username         | password      |
      | KK@GMAIL.COM     |   Vajju@123456   |
