@contactDetails
Feature: Change employee contact details

  Background: 
    When login with valid credentials
    Then navigate to employee list page

  Scenario: As an admin I should be able to change employee’s contact details.
    And search employee by name "Ummar" and click search
    Then click employee name
    Then click on contact details and change employee contact details and save
      | Address        | City       | State    | Zip code | Country       | Mobile     | WorkEmail      |
      | 123 Fordson Rd | Alexandria | Virginia |    22309 | United States | 7031111234 | test@gmail.com |
