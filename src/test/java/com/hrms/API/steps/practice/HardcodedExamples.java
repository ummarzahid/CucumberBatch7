package com.hrms.API.steps.practice;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardcodedExamples {

	/*
	 * REST Assured -Java library specifically used developed to automate REST
	 * endpoints
	 * 
	 * Given - preparing your request, When - What action will you perform, what
	 * type of call are you making Then - Verification
	 * 
	 */

	/** Concatenates with endpoint */
	String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MDM2MzU3MjMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYwMzY3ODkyMywidXNlcklkIjoiMTI3NCJ9.Ymlubt2WgDOfvY_aC55HuyC31fE5VX1RiJNPEn628oI";

	static String employeeID;

	// @Test
	public void sampleTest() {

		/** BaseURI for all endpoints */
		// RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

		/** JWT */

		/** Preparing request for /getOneEmployee.php **/
		/** Using .log.all to print out everything being sent with request */
		RequestSpecification preparingOneEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application/json").queryParam("employee_id", "7910").log().all();

		/** Making call to /getOneEmployee.php **/
		Response getOneEmployeeResponse = preparingOneEmployeeRequest.when().get("/getOneEmployee.php");

		/** One way to print response object **/
		// System.out.println(getOneEmployeeResponse.asString());

		/** Second way using rest assured prettyPrint **/
		// getOneEmployeeResponse.prettyPrint();

		/** Using assertThat() to verify status code */
		getOneEmployeeResponse.then().assertThat().statusCode(200);

		/** Using assertThat() to verify header and it's value */
		getOneEmployeeResponse.then().assertThat().header("Content-Type", "application/json");

	}

	@Test
	public void aPOSTcreateEmployee() {

		/** Preaparing request for creating employee **/
		RequestSpecification createEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application/json")
				.body("{\r\n" + "  \"emp_firstname\": \"Swift\",\r\n" + "  \"emp_lastname\": \"Madonna\",\r\n"
						+ "  \"emp_middle_name\": \"Wick\",\r\n" + "  \"emp_gender\": \"F\",\r\n"
						+ "  \"emp_birthday\": \"1990-10-11\",\r\n" + "  \"emp_status\": \"Employee\",\r\n"
						+ "  \"emp_job_title\": \"Chief Financial Officer\"\r\n" + "}")
				.log().all();

		/** making call to /createEmployee.php */
		Response createEmployeeResponse = createEmployeeRequest.when().log().all().post("/createEmployee.php");

		/** Printing response */
		// createEmployeeResponse.prettyPrint();

		/**
		 * Using jsonPath() to view the response body which lets us get the employee ID
		 * We are storing the employeeID as a static variable to able to use with other
		 * calls
		 **/
		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");

		// System.out.println(employeeID);

		/** Using assertThat() to verify status code 201 */
		createEmployeeResponse.then().assertThat().statusCode(201);

		/**
		 * Verifying response body "Message" is paired with "Entry Created" equalTo()
		 * method comes from static Hamcrest package - NEED TO IMPORT MANUALLY import
		 * static org.hamcrest.Matchers.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));

		/** Verifying created employee first name */
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Swift"));

		/** Verifying server Apache/2.4.39 (Win64) PHP/7.2.18 */
		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

	}

	@Test
	public void bGETcreatedEmployee() {

		/** Preparing request to get created employee */
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID);

		/** Storing response for retrieving created employee */
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");

		/** Printing response */
		// getCreatedEmployeeResponse.prettyPrint();

		/**
		 * Storing response employee ID into empID to compare with static global
		 * employee ID
		 */
		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");

		/** Comparing empID with stored employeeID from created employee call */
		boolean verifyingEmployeeID = empID.contentEquals(employeeID);

		/** Asserting to verify the above condition is true */
		Assert.assertTrue(verifyingEmployeeID);

		/** Verifying status code is 200 */
		getCreatedEmployeeResponse.then().assertThat().statusCode(200);

		/**
		 * Storing full response as string so that we are able to pass it as an argument
		 * with jsonPath
		 */
		String response = getCreatedEmployeeResponse.asString();

		/** Created object of JsonPath */
		JsonPath js = new JsonPath(response);

		/** Grabbing employee ID using 'js' */
		String employeeId = js.getString("employee[0].employee_id");
		String employeeFirstName = js.getString("employee[0].emp_firstname");
		String employeeMiddleName = js.getString("employee[0].emp_middle_name");
		String employeeLastName = js.getString("employee[0].emp_lastname");
		String employeeDOB = js.getString("employee[0].emp_birthday");
		String employeeGneder = js.getString("employee[0].emp_gender");
		String employeeJobTitle = js.getString("employee[0].emp_job_title");
		String employeeStatus = js.getString("employee[0].emp_status");

		/** Asserting response employee ID matches stored employee ID */
		Assert.assertTrue(employeeId.contentEquals(employeeID));

		Assert.assertEquals(employeeFirstName, "Swift");
		Assert.assertEquals(employeeMiddleName, "Wick");
		Assert.assertEquals(employeeLastName, "Madonna");
		Assert.assertEquals(employeeDOB, "1990-10-11");
		Assert.assertEquals(employeeGneder, "Female");
		Assert.assertEquals(employeeJobTitle, "Chief Financial Officer");
		Assert.assertEquals(employeeStatus, "Employee");
	}

	@Test
	public void cGETallEmployees() {

		/** Preparing request to get all employees */
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);

		/** Storing response for retrieving all employee */
		Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");

		/** Printing response */
		// getAllEmployeesResponse.prettyPrint();

		/** Storing response as a String */
		String response = getAllEmployeesResponse.asString();

		/**
		 * Created object of JsonPath and passing response as a String as an argument
		 */
		JsonPath js = new JsonPath(response);

		/** Retrieving the size of the array (the number of object is in the array) */
		int count = js.getInt("Employees.size()");
		System.out.println(count);

//		for (int i = 0; i < count; i++) {
//			String allEmployeeIDs = js.getString("Employees[" + i + "].employee_id");
//
//			// System.out.println(allEmployeeIDs);
//
//			if (allEmployeeIDs.contentEquals(employeeID)) {
//
//				System.out.println("Employee ID: " + employeeID + "is present in the body");
//				String firstNameOfEmpID = js.getString("Employees[" + 1 + "].emp_firstname");
//				System.out.println(firstNameOfEmpID);
//				break;
//			}
//
//		}

		/** for loops to print out first names of all employees */

//		for (int i = 0; i < count; i++) {
//
//			String allFirstNames = js.getString("Employees[" + i + "].emp_firstname");
//			System.out.println(allFirstNames);
//
//		}

	}
	
	
	
	@Test
	public void dPUTupdateCreatedEmployee() {
		
		/** Preaparing request for update created employee **/
		RequestSpecification updateCreatedEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application/json")
				.body("{\r\n" + 
						"  \"employee_id\": \"" + employeeID + "\",\r\n" + 
						"  \"emp_firstname\": \"John\",\r\n" + 
						"  \"emp_lastname\": \"Wick\",\r\n" + 
						"  \"emp_middle_name\": \"007\",\r\n" + 
						"  \"emp_gender\": \"M\",\r\n" + 
						"  \"emp_birthday\": \"1990-10-11\",\r\n" + 
						"  \"emp_status\": \"Employee\",\r\n" + 
						"  \"emp_job_title\": \"Data Quality Manager\"\r\n" + 
						"}");
		
		/** making call to /createEmployee.php */
		Response updateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().log().all().put("/updateEmployee.php");
		
		/** Printing response */
		updateCreatedEmployeeResponse.prettyPrint();
		
	}

	
	
	
}
