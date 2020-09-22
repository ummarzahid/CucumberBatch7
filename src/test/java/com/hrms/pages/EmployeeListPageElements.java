package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class EmployeeListPageElements extends BaseClass {

	@FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr/td")
	public List<WebElement> table;

	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement empSearchByName;

	@FindBy(id = "empsearch_id")
	public WebElement empSearchById;

	@FindBy(id = "searchBtn")
	public WebElement searchButton;
	
	public EmployeeListPageElements() {
		PageFactory.initElements(driver, this);
	}

}
