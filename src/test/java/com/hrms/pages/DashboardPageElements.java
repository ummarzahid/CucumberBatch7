package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class DashboardPageElements extends BaseClass {

	@FindBy(css = "a#welcome")
	public WebElement welcomeAdmin;

	@FindBy(id = "menu_admin_viewAdminModule")
	public WebElement adminDashboard;

	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement PimBtn;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmpBtn;
	
	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement EmpListBtn;

	@FindBy(id = "menu_leave_viewLeaveModule")
	public WebElement leave;
	
	@FindBy(xpath = "//div[@class = 'menu']/ul/li")
	public List<WebElement> dashTabs;

	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}

}
