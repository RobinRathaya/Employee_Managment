package com.chainsys.administrator;


import java.time.LocalDate;

public class Validator {
	public static void ValidateAddEmployee(String first_Name, String last_Name, Long phone_number, LocalDate hire_Date, int job_Id, float salary, int manager_Id, int dept_Id, LocalDate dateOfBirth, String gender) throws Exception
	{
		if(first_Name==null)
		{
			throw new Exception("input cannot be null");
		}
		if (last_Name==null) {
			throw new Exception("input cannot be null");
		}
		if (phone_number==0) {
			throw new Exception("input cannot be null");
		}
		if (hire_Date==null) {
			throw new Exception("input cannot be null");
		}
		if (job_Id==0) {
			throw new Exception("input cannot be null");
		}
		if (salary==0) {
			throw new Exception("input cannot be null");
		}
		if (manager_Id==0) {
			throw new Exception("input cannot be null");
		}
		if (dept_Id==0) {
			throw new Exception("input cannot be null");
		}
		if (dateOfBirth==null) {
			throw new Exception("input cannot be null");
		}
		if(gender==null)
		{
			throw new Exception("input cannot be null");
		}
		
	}

	public static void validateId(int id) throws Exception {
		// TODO Auto-generated method stub
		
		if(id<=-1)
		{
			throw new Exception("Employee ID not available");
		}
		
	}

	public static void validateName(String name) throws Exception {
		// TODO Auto-generated method stub
		if(name==null)
		{
			throw new Exception("Employee name not available");
		}
	}
	
	

}
