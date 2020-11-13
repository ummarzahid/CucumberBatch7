package com.hrms.utils;

import org.json.JSONObject;

public class APIPayloadCommonMethods {

	public static String createEmployeeBody() {

		String createdEmployeeBody = "{\r\n" + "  \"emp_firstname\": \"Larkyn\",\r\n"
				+ "  \"emp_lastname\": \"Madonna\",\r\n" + "  \"emp_middle_name\": \"Rose\",\r\n"
				+ "  \"emp_gender\": \"F\",\r\n" + "  \"emp_birthday\": \"1990-10-11\",\r\n"
				+ "  \"emp_status\": \"Employee\",\r\n" + "  \"emp_job_title\": \"Chief Financial Officer\"\r\n" + "}";

		return createdEmployeeBody;

	}

	public static String createEmployeePayload() {

		JSONObject obj = new JSONObject();
		obj.put("emp_firstname", "Larkyn");
		obj.put("emp_lastname", "Madonna");
		obj.put("emp_middle_name", "Rose");
		obj.put("emp_gender", "F");
		obj.put("emp_birthday", "1990-10-11");
		obj.put("emp_status", "Employee");
		obj.put("emp_job_title", "Chief Financial Officer");
		return obj.toString();

	}
	
	public static String createEmployeePayloadMoreDynamic(String firstName, String lastName, String middleName,
			String gender, String dob, String employeeStatus, String employeeJobTitle) {
		JSONObject obj = new JSONObject();
		obj.put("emp_firstname", firstName);
		obj.put("emp_lastname", lastName);
		obj.put("emp_middle_name", middleName);
		obj.put("emp_gender", gender);
		obj.put("emp_birthday", dob);
		obj.put("emp_status", employeeStatus);
		obj.put("emp_job_title", employeeJobTitle);
		return obj.toString();
	}

}
