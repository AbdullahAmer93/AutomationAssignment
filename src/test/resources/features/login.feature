@feature
Feature: User Login and Shopping Flow

  Scenario: Login with invalid credentials and verify error messages
    Given I visit the login page
    When I enter invalid credentials
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login with valid credentials and complete shopping
    Given I visit the login page
    When I enter valid credentials with username "standard_user" and password "secret_sauce"
    Then I should be redirected to the products page
    When I add the most expensive two products to the cart
    And I click on the cart button
    Then I should be redirected to the cart page
    And I should see the two selected products in the cart
    When I click on the "Checkout" button
    Then I should be redirected to the checkout page
    When I fill the checkout form with valid details
    And I click on the "Continue" button
    Then I should be redirected to the "Overview" page
    And I should see the correct items total before taxes
    And the URL should be "https://www.saucedemo.com/checkout-step-two.html"
    When I click on the "Finish" button
    Then I should see a "Thank You" message
    And I should see an "Order has been dispatched" message
