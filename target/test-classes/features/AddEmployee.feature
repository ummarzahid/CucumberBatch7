@addEmployee
Feature: Add Employee

  Background: 
    When login with valid credentials
    Then navigate to add employee page

  Scenario: Add employee without login details
    And enter first and last name
    Then click on save Button
    And verify the employee is added successfully

  Scenario: Add employee with login credentials
    And enter first and last name
    When check login details checkbox
    Then enter login details
    Then click on save Button
    And verify the employee is added successfully

  @parameter
  Scenario: Add employee without login details but with middel name
    When enter first name as "Ahmet" middel name as "Can" last as "Bicer"
    Then click on save Button
    And verify that "Ahmet Can Bicer" is added successfully

  @examples
  Scenario Outline: Adding multiple employees without login details
    When enter employee "<First Name>", "<Middle Name>" and "<Last Name>"
    Then click on save Button
    And Verify that "<First Name>", "<Middle Name>" and "<Last Name>" is successfully added

    Examples: 
      | First Name | Middle Name | Last Name |
      | Mark       | j           | Smith     |
      | Hunter     | ABC         | Musoev    |
      | John       | M           | Wick      |
      | John       | F           | Kennedy   |

  @dtwithHeader
  Scenario: Adding multiple employees at one execution
    When add multiple employees and verify they are added
      | First Name | Middle Name | Last Name | Employee ID |
      | Mark       | j           | Smith     | adsdeerdf   |
      | Hunter     | ABC         | Musoev    | njhbissasdd |
      | John       | M           | Wick      | njkskccivv  |
      | John       | F           | Kennedy   | cckzzsiixcv |

  @excelTask
  Scenario: Adding multiple employees from excel file
    When add multiple employees from "AddEmployee" verify they are added successfully
