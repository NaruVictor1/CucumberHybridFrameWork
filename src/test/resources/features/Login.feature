@all
Feature: User login
  Registered User should be able to login to access account details

  @login @validcredentials @smoke @regression @dev
  Scenario Outline: Login with valid credentials
    Given User navigates to home page
    When User enters vaild email address <emailAddress> into email field
    And Enter vaild password <password> into password field
    And Clicks on Login button
    Then User should get successfully
    Examples:
    |emailAddress          |password|
    |narunagamma@gmail.com |12345   |
    |narunagamma1@gmail.com|12345   |
    |narunamma@gmail.com   |12345   |
  @login @invaildcredentails @smoke @regression
  Scenario: Login with invaild credentails
    Given User navigates to home page
    When User enters invalid email address into email field
    And Enter invaild password "1234567890" into password field
    And Clicks on Login button
    Then User should get a proper warning message

  @login @vaildemailaddressandinvaildpassword @regression
  Scenario: Login with vaild email address and invaild password
    Given User navigates to home page
    When User enters vaild email address "narunagamma@gmail.com" into email field
    And Enter invaild password "1234567890" into password field
    And Clicks on Login button
    Then User should get a proper warning message

  @login @invaildemailaddressandvaildpassword @regression
  Scenario: Login with invaild email address and vaild password
    Given User navigates to home page
    When User enters invalid email address into email field
    And Enter vaild password "12345" into password field
    And Clicks on Login button
    Then User should get a proper warning message

  @login @nocredentials @regression @igonre
  Scenario: Login with without providing any credentials
    Given User navigates to home page
    When User dont enter any credentails
    And Clicks on Login button
    Then User should get a proper warning message
