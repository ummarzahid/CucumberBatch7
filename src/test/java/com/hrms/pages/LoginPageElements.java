package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.testbase.PageInitializer;

public class LoginPageElements extends PageInitializer {

	@FindBy(id = "txtUsername")
	public WebElement userNametextBox;

	@FindBy(xpath = "//input[@id = 'txtPassword']")
	public WebElement passwordTextBox;

	@FindBy(css = "input#btnLogin")
	public WebElement loginBtn;

	@FindBy(id = "divLogo")
	public WebElement syntaxLogo;

	@FindBy(id = "spanMessage")
	public WebElement spanMessage;
	
	public static final String ERROR_MSG_EMPTY_USERNAME = "Username cannot be empty";
	
	public static final String ERROR_MSG_EMPTY_PASSWORD = "Password cannot be empty";

	/**
	 * this method will login to hrms by the given username and password
	 * @param username
	 * @param password
	 */
	public void loginToHrms(String username, String password) {
		login.userNametextBox.sendKeys(username);
		login.passwordTextBox.sendKeys(password);
		login.loginBtn.click();
	}

	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}

}
