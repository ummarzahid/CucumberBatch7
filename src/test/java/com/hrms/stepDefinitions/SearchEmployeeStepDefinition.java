package com.hrms.stepDefinitions;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Then;

public class SearchEmployeeStepDefinition extends CommonMethods {

	@Then("navigate to employee list page")
	public void navigate_to_employee_list_page() {
		click(dash.PimBtn);
		click(dash.EmpListBtn);
		
	}

	@Then("enter {string} name")
	public void enter_name(String empName) throws InterruptedException {
		waitForVisibility(empList.empSearchByName);
		waitForClickability(empList.empSearchByName);
		sendText(empList.empSearchByName, empName);
	}

	@Then("click on search button")
	public void click_on_search_button() {
		click(empList.searchButton);
	}
	
	@Then("enter {string}")
	public void enter(String empId) {
		waitForVisibility(empList.empSearchById);
		waitForClickability(empList.empSearchById);
		sendText(empList.empSearchById, empId);
	}

}
