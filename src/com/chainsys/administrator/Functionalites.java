package com.chainsys.administrator;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.chainsys.resources.Employee;
import com.chainsys.util.ConnectionUtil;

public class Functionalites {

	public static void deleteById(int id) throws Exception {

		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "DELETE FROM CHAINSYS_EMPLOYEE WHERE employee_id=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("Employee with ID " + id + " successfully");
			ConnectionUtil.close(connection, preparedStatement, null);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Unable to delete");
		}

	}

	public static void deleteByName(String name) throws Exception {

		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "DELETE FROM CHAINSYS_EMPLOYEE WHERE first_name=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			System.out.println("Employee with name " + name + "successfully");
			ConnectionUtil.close(connection, preparedStatement, null);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Unable to delete");
		}

	}

	public static Employee searchByName(String name) throws Exception {
		Employee employee = null;
		String sql = "SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,MANAGER_ID ,DEPARTMENT_ID,DATE_OF_BIRTH,GENDER FROM CHAINSYS_EMPLOYEE WHERE first_name =? ";
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);

			preparedStatement.setString(1, name);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("employee_id"));
				employee.setFirstName(resultSet.getString("first_name"));

				employee.setLastName(resultSet.getString("last_name"));
				employee.setPhoneNumber(resultSet.getLong("phone_number"));
				employee.setHireDate(resultSet.getDate("hire_date").toLocalDate());
				employee.setJobId(resultSet.getString("job_id"));
				employee.setSalary(resultSet.getFloat("salary"));
				employee.setManagerId(resultSet.getInt("manager_id"));
				employee.setDeptId(resultSet.getInt("department_id"));
				employee.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH").toLocalDate());
				employee.setGender(resultSet.getString("gender"));
			}
			return employee;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Unable to search");
		}

	}

	public static Employee searchById(int id) throws Exception {
		Employee employee = new Employee();
		String sql = "SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,MANAGER_ID ,DEPARTMENT_ID,DATE_OF_BIRTH,GENDER FROM CHAINSYS_EMPLOYEE WHERE EMPLOYEE_ID= ? ";
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				employee.setId(resultSet.getInt("employee_id"));
				employee.setFirstName(resultSet.getString("first_name"));

				employee.setLastName(resultSet.getString("last_name"));
				employee.setPhoneNumber(resultSet.getLong("phone_number"));
				employee.setHireDate(resultSet.getDate("hire_date").toLocalDate());
				employee.setJobId(resultSet.getString("job_id"));
				employee.setSalary(resultSet.getFloat("salary"));
				employee.setManagerId(resultSet.getInt("manager_id"));
				employee.setDeptId(resultSet.getInt("department_id"));
				employee.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH").toLocalDate());
				employee.setGender(resultSet.getString("gender"));
			}
			return employee;

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			throw new Exception("Unable to search by ID");
		}

	}

	public static void insertEmployee(String first_Name, String last_Name,
			Long phone_number, LocalDate hire_Date, int job_Id, float salary,
			int manager_Id, int dept_Id, LocalDate dateOfBirth, String gender)
			throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO chainsys_employee values(CHAINSYSEMPOYEE_EMPID_SQ.nextval,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, first_Name);
			preparedStatement.setString(2, last_Name);
			preparedStatement.setLong(3, phone_number);
			preparedStatement.setDate(4, Date.valueOf(hire_Date));
			preparedStatement.setInt(5, job_Id);
			preparedStatement.setFloat(6, salary);
			preparedStatement.setInt(7, manager_Id);
			preparedStatement.setInt(8, dept_Id);
			preparedStatement.setDate(9, Date.valueOf(dateOfBirth));
			preparedStatement.setString(10, gender);
			preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Unable to Insert Employee");
		}

	}

	public static void insertDepartment(String name, int manager_Id,
			int location_Id) throws Exception {
		// TODO Auto-generated method stub
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("Insert into chainsys_departments values(CHAINSYSDEPARTMENTS_DEPTID_SEQ.nextval,?,?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, manager_Id);
			preparedStatement.setInt(3, location_Id);
			preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Unable to Insert Department");
		}

	}

	public static ArrayList<Employee> findAll()
			throws Exception {

		String sql = "SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,MANAGER_ID ,DEPARTMENT_ID,DATE_OF_BIRTH,GENDER FROM CHAINSYS_EMPLOYEE";

		try {
			ArrayList<Employee> employeeList = new ArrayList<>();
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Employee employee = new Employee();
				employee.setId(resultSet.getInt("employee_id"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setPhoneNumber(resultSet.getLong("phone_number"));
				employee.setHireDate(resultSet.getDate("hire_date").toLocalDate());
				employee.setJobId(resultSet.getString("job_id"));
				employee.setSalary(resultSet.getFloat("salary"));
				employee.setManagerId(resultSet.getInt("manager_id"));
				employee.setDeptId(resultSet.getInt("department_id"));
				employee.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH").toLocalDate());
				employee.setGender(resultSet.getString("gender"));
				employeeList.add(employee);
			}
			return employeeList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("No Record Found");
		}

	}

	public static void displayAll(ArrayList<Employee> employeeList) {
		// TODO Auto-generated method stub

		for (Employee e : employeeList) {
			System.out.println(e.getId() + " " + e.getFirstName() + " "
					+ e.getLastName() + " " + e.getPhoneNumber() + " "
					+ e.getHireDate() + " " + e.getJobId() + " "
					+ e.getSalary() + " " + e.getDeptId() + " "
					+ e.getManagerId() + " " + e.getDateOfBirth() + " "
					+ e.getGender());
		}
	}

	public static void display(Employee employee) {
		// TODO Auto-generated method stub
		if (employee == null) {
			return;
		} else {
			System.out.println(employee.getId() + " " + employee.getFirstName()
					+ " " + employee.getLastName() + " "
					+ employee.getPhoneNumber() + " " + employee.getHireDate()
					+ " " + employee.getJobId() + " " + employee.getSalary()
					+ " " + employee.getDeptId() + " "
					+ employee.getManagerId() + " " + employee.getDateOfBirth()
					+ " " + employee.getGender());
		}

	}

	/*
	 * public static void updateDepartmentById(int departmentId) { // TODO
	 * Auto-generated method stub try { Connection connection =
	 * ConnectionUtil.getConnection(); PreparedStatement preparedStatement =
	 * connection
	 * .prepareStatement("UPDATE chainsys_departments SET department_id=? where "
	 * ); preparedStatement.setString(1, name); preparedStatement.setInt(2,
	 * manager_Id); preparedStatement.setInt(3, location_Id);
	 * preparedStatement.executeUpdate(); ConnectionUtil.close(connection,
	 * preparedStatement, null); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); throw new
	 * Exception("Unable to Insert Department"); }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public static void updateManagerId(int managerId) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */

}
