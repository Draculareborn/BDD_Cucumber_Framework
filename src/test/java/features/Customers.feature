#Author: Bhaskar
@device_windowspc @author_Bhaskar
Feature: Customers

  Background: Below are the common steps for each scenario
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard

  Scenario: Add a new Customer
    When User click on Customers Menu
    And Click on Customers Menu Item
    And Click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And Close browser

  Scenario: Search Customer by EmailId
    When User click on Customers Menu
    And Click on Customers Menu Item
    And Enter Customer Email
    When Click on search button
    Then User should find Email in th Search table
    And Close browser

  Scenario: Search Customer by Name
    When User click on Customers Menu
    And Click on Customers Menu Item
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then User should find Name in the Search table
    And Close browser
