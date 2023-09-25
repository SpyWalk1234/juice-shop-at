Feature: Registration feature

  #As some scenarios need login, user is created for them on background.
  Background:
    Given Open Juiceshop main page on web version
    And I go to Login Page
    And I go to Registration Page
    And I register a new predefined user

  @Test
  Scenario: Attempt to register with already used email scenario
    Given Open Juiceshop main page on web version
    When I go to Login Page
    And I go to Registration Page
    And I register a new predefined user
    Then I see error message "Email must be unique"


  @Test
  Scenario: Contact customer support scenario
    Given Open Juiceshop main page on web version
    When I go to Login Page
    And I login to the juice shop
    And I open Complaint page
    And I enter complain message "The website is not working"
    Then I see accept message "Customer support will get in touch with you soon!"


  @Test
  Scenario: Browse and Add products to basket scenario
    Given Open Juiceshop main page on web version
    When I go to Login Page
    And I login to the juice shop
    And I search for a "Juice" product
    And I add "Apple Juice" to basket
    And I add "Banana Juice" to basket
    And I add "Lemon Juice" to basket
    And I open the basket
    Then I see "Apple Juice" in the basket
    Then I see "Banana Juice" in the basket
    Then I see "Lemon Juice" in the basket