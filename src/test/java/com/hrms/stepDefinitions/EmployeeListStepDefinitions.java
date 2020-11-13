package com.hrms.stepDefinitions;

import java.util.List;
import java.util.Map;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeListStepDefinitions extends CommonMethods {
	
	@Then("search employee by name {string} and click search")
	public void search_employee_by_name_and_click_search(String firstName){
		
	    sendText(empList.empSearchByName, firstName);
	    
	    click(empList.searchButton);
	}

	@Then("click employee name")
	public void click_employee_name() throws InterruptedException {
		waitForClickability(empList.empName);
	   waitForVisibility(empList.empName);
		jsClick(empList.empName);
		
	}

	@Then("click on contact details and change employee contact details and save")
	public void click_on_contact_details_and_change_employee_contact_details_and_save(DataTable employeeContactDetails) {
		click(persDetails.empContactDetails);
		click(persDetails.editAndSaveBtn);
		
		List<Map<String, String>> empDetails = employeeContactDetails.asMaps();
		
		for (Map<String, String> contactDetails : empDetails) {
			
			String address = contactDetails.get("Address");
			String city = contactDetails.get("City");
			String state = contactDetails.get("State");
			String zip = contactDetails.get("Zip code");
			String country = contactDetails.get("Country");
			String mobile = contactDetails.get("Mobile");
			String email = contactDetails.get("WorkEmail");
			
			sendText(persDetails.empAddress, address);
			sendText(persDetails.empCity, city);
			selectDDValue(persDetails.empState, state);
			sendText(persDetails.empZipCode, zip);
			selectDDValue(persDetails.empCountry, country);
			sendText(persDetails.empMobile, mobile);
			sendText(persDetails.empWorkEmail, email);
			
			click(persDetails.editAndSaveBtn);
		}
	}

}
