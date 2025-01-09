
@tag
Feature: placing the order from Ecomerce website
 
 Background: 
 Given I want to land on login page


  @Regression
  Scenario Outline: positive test of submitting the order
    Given I want to login with <username> and <password> 
    When add the <product> to cart 
    And check out <product> 
    Then "Thankyou for the order." check this message after order placed succefully

    Examples: 
      | username         | password      | product        |
      | KK@GMAIL.COM     |   Vajju@123   | IPHONE 13 PRO  |

