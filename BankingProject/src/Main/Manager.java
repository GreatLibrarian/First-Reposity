package Main;

public class Manager extends Employee
{
	private String timecards;
	
	public Manager()
	{
		
	}
	
	public Manager(String firstname, String lastname, long employeeid, String jobtitle, String timecards)
	{
		//super(firstname, lastname, employeeid, jobtitle);
		this.timecards = timecards;
	}
	
	public String getTimeCards()
	{
		return timecards;
	}
	
	public void setTimeCards(String timecards)
	{
		this.timecards = timecards;
	}
	
	public String toString()
	{
		return "Managar [timecards = " + timecards + "]";
	}
}
