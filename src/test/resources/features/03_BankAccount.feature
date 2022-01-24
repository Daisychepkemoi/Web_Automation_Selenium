#Author: dchepkemoi
@CRUDONBANKACCOUNT
Feature: All crud operations on a bankaccouunt linked to a customer
  I to do all CRUD operations for a given customer

  @createCustomer
  Scenario Outline: Validate create customer operations are executed successfully 
    Given I am at the home_page page
    Then I can view Bank Manager_Login_Button
    When I click on Bank_Manager_Login_Button
    Then I should be able to view Open_Account_Button
    When I click on Open Account Button
    Then I should view input options to enter customer Bank account details
    When I select "<Customer>", "<currency>" and click on Process
    Then I should get a success "<message>" on the operation
		Examples: 
		      | Customer  | currency | message|
		      |||Please fill out this field.|
		      ||test|Please fill out this field.|
		      |test||Please fill out this field.|
		      |test|test|Please fill out this field.|
		      