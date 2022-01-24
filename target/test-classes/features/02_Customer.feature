#Author: dchepkemoi
@crudCustomer
Feature: All crud operations on a customer
  I to do all CRUD operations for a given customer

  @createCustomer
  Scenario Outline: Validate create customer operations are executed successfully 
    Given I am at the home page
    Then I can see Bank Manager Login_Button
    When I click on Bank Manager Login
    Then I should be able to view Add Customer_Button
    When I click on Add Customer Button
    Then I should view input options to enter customer details
    When I Input "<FirstName>", "<LastName>","<PostCode>" and click on Add Customer
    Then I should get a success "<message>" on the operation 

    Examples: 
      | FirstName  | LastName | PostCode  |message|
      ||||Please fill out this field.|
      ||test|5|Please fill out this field.|
      |test||30|Please fill out this field.|
      |test|test||Please fill out this field.|
      |test|test|45|Please check the details. Customer may be duplicate.|
      |test|test|45|Please check the details. Customer may be duplicate.|
