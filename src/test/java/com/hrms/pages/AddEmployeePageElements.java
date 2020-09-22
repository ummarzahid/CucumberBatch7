package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AddEmployeePageElements extends BaseClass {

	@FindBy(id = "firstName")
	public WebElement firstNameTxtBox;

	@FindBy(xpath = "//input[@id = 'middleName']")
	public WebElement middleNameTxtBox;

	@FindBy(id = "lastName")
	public WebElement lastNameTxtBox;

	@FindBy(id = "chkLogin")
	public WebElement createLoginChkBox;

	@FindBy(id = "user_name")
	public WebElement userName;

	@FindBy(id = "user_password")
	public WebElement userPassword;

	@FindBy(id = "re_password")
	public WebElement confirmPassword;
	
	@FindBy(id = "btnSave")
	public WebElement saveButton;
	
	@FindBy(id = "employeeId")
	public WebElement empIdTxtBox;
	
	public AddEmployeePageElements() {
		PageFactory.initElements(driver, this);
	}

}
