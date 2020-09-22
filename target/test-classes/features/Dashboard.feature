Feature: Dasboard Functionality

@dash
  Scenario: Dasboard tab verification
    When login with valid credentials
    Then verify the following dashboard tabs
      | Admin | PIM | Leave | Time | Recruitment | Performance | Dashboard | Directory |
