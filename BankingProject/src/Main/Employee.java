package Main;

public class Employee 
{
	private String firstname;
	private String lastname;
	private long employeeid;
	private String jobtitle;
	
	public Employee()
	{
		
	}
	
	public Employee(String firstname, String lastname, long employeeid, String jobtitle)
	{
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.employeeid = employeeid;
		this.jobtitle = jobtitle;
	}
	
	public Employee(String firstname, String lastname, long employeeid)
	{
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.employeeid = employeeid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(long employeeid) {
		this.employeeid = employeeid;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	@Override
	public String toString() {
		return "Employee ["
				+ "firstname=" + firstname
				+ ", lastname=" + lastname 
				+ ", employeeid=" + employeeid
				+ ", jobtitle=" + jobtitle + "]";
	}
	
	
	
	
}
