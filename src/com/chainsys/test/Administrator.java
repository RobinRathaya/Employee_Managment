package com.chainsys.test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.administrator.Functionalites;
import com.chainsys.administrator.Validator;
import com.chainsys.resources.Employee;

public class Administrator {

	public static void choice(Scanner scanner) throws Exception {

		char select;
		do {
			System.out.println("Choose from the action");
			System.out.println("1.Insert new department");
			System.out.println("2.Add Employees");
			System.out.println("3.Delete Employees");
			System.out.println("4.Search Employee");
			System.out.println("5.Display");
//			System.out.println("6.Generate Report");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				addDepartment(scanner);
				break;
			case 2:
				addEmployee(scanner);
				break;
			case 3:
				delete(scanner);
				break;
			case 4:
				search(scanner);
				break;
			case 5:
			{
				
				ArrayList<Employee> employeeList=Functionalites.findAll();
				Functionalites.displayAll(employeeList);
				choice(scanner);
			}
				break;
//			case 6:
//				GenerateReport()
			default:
				System.out.println("Invalid input");
				break;
			}
			select = scanner.next().charAt(0);
		} while (select == 'y' || select == 'Y');

		choice(scanner);
	}

	/*private static void update(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("1.Update Department ID");
		System.out.println("2.Update Manager ID");
		System.out.println("2.Update Salary");
		int option = scanner.nextInt();
		switch (option) {
		case 1: {
			System.out.println("Department ID you want to update");
			int departmentId = scanner.nextInt();
			Functionalites.updateDepartmentById(departmentId);

		}
			break;
		case 2: {
			System.out.println("Employee ID you want to update");
			int ManagerId = scanner.nextInt();
			Functionalites.updateManagerId(ManagerId);
			
		}
		default:
			break;
		}
		choice(scanner);
		
		
		
	}*/

	public static void search(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("1.Search by Name");
		System.out.println("2.Search by ID");
		int option = scanner.nextInt();
		switch (option) {
		case 1: {
			System.out.println("Search the Employee Name you want to search");
			String name = scanner.next();
//			Validator.validateSearchByName(name);
			Employee employee=Functionalites.searchByName(name);
			Functionalites.display(employee);

		}
			break;
		case 2: {
			System.out.println("Search the Employee ID you want to search");
			int id = scanner.nextInt();
			Validator.validateId(id);
			Employee employee=Functionalites.searchById(id);
			Functionalites.display(employee);
			
		}
		default:
			break;
		}
		choice(scanner);
	}

	public static void delete(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		
		char select = 0;
		do {
			System.out.println("How do you want to delete?");
			System.out.println("1.Delete by Employee ID");
			System.out.println("2.Delete by Employee first name");
			int option = scanner.nextInt();
			switch (option) {
			case 1: {
				System.out.println("Enter the Employee ID you want to delete");
				int id = scanner.nextInt();
				Functionalites.deleteById(id);
			}
				break;

			case 2: {
				System.out
						.println("Enter the Employee first name you want to delete");
				String name = scanner.next();
				Functionalites.deleteByName(name);
			}
			default:
				System.out.println("Invalid selection");
			}

			select = scanner.next().charAt(0);
		} while (select == 'y' || select == 'Y');

		System.out.println("Invalid selection");
		choice(scanner);

	}

	public static void addEmployee(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		char select = 0;
		do {

			System.out.println("Enter the First Name : ");
			String first_Name = scanner.next();

			System.out.println("Enter the Last Name : ");
			String last_Name = scanner.next();

			System.out.println("Enter the Phone number: ");
			Long phone_number = scanner.nextLong();

			System.out.println("Enter the Hire Date (YYYY-MM-DD): ");
			String date = scanner.next();
			LocalDate hire_Date=LocalDate.parse(date);
//			Date hire_Date = Date.valueOf(date);

			System.out.println("Enter the Job ID : ");
			int job_Id = scanner.nextInt();

			System.out.println("Enter the Salary : ");
			float salary = scanner.nextFloat();

			System.out.println("Enter the Manager ID : ");
			int manager_Id = scanner.nextInt();

			System.out.println("Enter the Department ID : ");
			int dept_Id = scanner.nextInt();

			System.out.println("Enter the Date of Birth (YYYY-MM-DD): ");
			String birthDate = scanner.next();
			LocalDate dateOfBirth=LocalDate.parse(birthDate);
//			Date dateOfBirth = Date.valueOf(birthDate);

			System.out.println("Enter the Gender(M/F) : ");
			String gender = scanner.next();

			Validator.ValidateAddEmployee(first_Name, last_Name,
					phone_number, hire_Date, job_Id, salary, manager_Id,
					dept_Id, dateOfBirth, gender);
			Functionalites.insertEmployee(first_Name, last_Name, phone_number,
					hire_Date, job_Id, salary, manager_Id, dept_Id,
					dateOfBirth, gender);
			System.out.println("Do you want add again?[Y/y]");
			select = scanner.next().charAt(0);

		} while (select == 'y' || select == 'Y');

		choice(scanner);

	}

	public static void addDepartment(Scanner scanner) throws Exception {
		char select = 0;
		do {

			System.out.println("Enter the Department Name : ");
			String name = scanner.next();

			System.out.println("Enter the Manager ID : ");
			int manager_Id = scanner.nextInt();

			System.out.println("Enter the Location ID : ");
			int Location_Id = scanner.nextInt();

			Functionalites.insertDepartment(name, manager_Id, Location_Id);

			System.out.println("Do you want add again?[Y/y]");
			select = scanner.next().charAt(0);

		} while (select == 'y' || select == 'Y');

		choice(scanner);

	}

	/*
	 * public static void generate(Scanner scanner) { char select = 0; do {
	 * System.out.println("Report Generation");
	 * System.out.println("1.Upcoming event");
	 * System.out.println("2.Employee List with managers"); int option =
	 * scanner.nextInt(); switch (option) { case 1: {
	 * System.out.println("Enter the Employee ID you want to delete"); int id =
	 * scanner.nextInt(); Functionalites.deleteById(id); } break;
	 * 
	 * case 2: {
	 * System.out.println("Enter the Employee first name you want to delete");
	 * String name = scanner.next(); Functionalites.deleteByName(name); }
	 * default: System.out.println("Invalid selection"); }
	 * 
	 * select = scanner.next().charAt(0); } while (select == 'y' || select ==
	 * 'Y');
	 * 
	 * System.out.println("Invalid selection"); choice(scanner);
	 * 
	 * 
	 * }
	 */

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		choice(scanner);

	}

}
