package ManagerAndTrainee;

public class Employee 
{
	private long employee_id;
	private String employee_name;
	private String employee_address;
	private long employee_phone;
	private double basic_salary;
	private double special_allowance = 250.80;
	private double hra = 1000.50;
	
	public Employee()
	{
		
	}
	
	public Employee(long employee_id, String employee_name, String employee_address, long employee_phone)
	{
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_address = employee_address;
		this.employee_phone = employee_phone;
	}
	
	public double calculateSalary()
	{
		double salary = basic_salary + (basic_salary * special_allowance/100) + (basic_salary * hra/100);
		return salary;
	}
}
