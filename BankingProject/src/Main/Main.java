package Main;

public class Main {

	public static void main(String[] args) 
	{
		Employee empone = new Employee("Bob", "Dylan", 10, "Musician");
		Employee emptwo = new Employee("Joseph", "Stalin", 52, "Dictator");
		empone.getLastname();
		// empone.setLastname("blah"); Best practice to not use both
		
		Manager manone = new Manager("Joe", "Bagodonuts", 42, "Manager", "Sales Timecards");
		
		System.out.println(empone);
		System.out.println(emptwo);
		System.out.println(manone);
	}

}
