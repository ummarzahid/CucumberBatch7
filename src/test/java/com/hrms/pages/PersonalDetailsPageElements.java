package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsPageElements extends BaseClass {
	
	@FindBy(xpath = "//div[@class = 'imageHolder']/preceding-sibling::h1")
	public WebElement profileName;
	
	@FindBy(linkText =  "Contact Details")
	public WebElement empContactDetails;
	
	@FindBy(id = "btnSave")
	public WebElement editAndSaveBtn;
	
	@FindBy(id = "contact_street1")
	public WebElement empAddress;
	
	@FindBy(id = "contact_city")
	public WebElement empCity;
	
	@FindBy(id = "contact_state")
	public WebElement empState;
	
	@FindBy(id = "contact_emp_zipcode")
	public WebElement empZipCode;
	
	@FindBy(id = "contact_country")
	public WebElement empCountry;
	
	@FindBy(id = "contact_emp_hm_telephone")
	public WebElement empHmTelephone;
	
	@FindBy(id = "contact_emp_mobile")
	public WebElement empMobile;
	
	@FindBy(id = "contact_emp_work_email")
	public WebElement empWorkEmail;
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(driver, this);
	}


}
