$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/nameValidationInDB.feature");
formatter.feature({
  "name": "Feature: Name validations against DB",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "First name validation against DB - searching by Employee ID",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@dbValidation"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "login with valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.login_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the dashboard logo is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.verify_the_dashboard_logo_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "navigate to employee list",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.EmployeeSearchStepDefinitions.navigate_to_employee_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter a valid Employee id \"0056266\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.EmployeeSearchStepDefinitions.enter_a_valid_Employee_id(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on search Button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.EmployeeSearchStepDefinitions.click_on_search_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the table is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.EmployeeSearchStepDefinitions.verify_the_table_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "get first name from the table",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.EmployeeSearchStepDefinitions.get_first_name_from_the_table()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "get first name from the db",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.DBStepDefinitions.get_first_name_from_the_db()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate first names from ui against db",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.EmployeeSearchStepDefinitions.validate_first_names_from_ui_against_db()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "First name validation against DB - searching by Employee ID");
formatter.after({
  "status": "passed"
});
});