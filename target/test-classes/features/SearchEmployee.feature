@searchEmployee
Feature: Search Employee

  Background: 
    When login with valid credentials
    Then navigate to employee list page

  @searchByName
  Scenario Outline: Search employee by name
    And enter "<Employee name>" name
    Then click on search button

    Examples: 
      | Employee Name |
      | Novak         |
      | Arslan        |
      | Salih         |
      | Ummar         |

  @searchById
  Scenario Outline: search employye by Id
    Then enter "<Id>"
    And click on search button

    Examples: 
      | Id   |
      | 7910 |
      | 7214 |
      | 7215 |
      | 7911 |
