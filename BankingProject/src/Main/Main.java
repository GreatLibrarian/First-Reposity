package Main;

public class Main {

	public static void main(String[] args) 
	{
		Employee empone = new Employee("Bob", "Dylan", 10, "Musician");
		Employee emptwo = new Employee("Joseph", "Stalin", 52, "Dictator");
		empone.getLastname();
		empone.withdraw(200, 50);
		// empone.setLastname("blah"); Best practice to not use both
		
		Manager manone = new Manager("Joe", "Bagodonuts", 42, "Manager", "Sales Timecards");
		
	//	System.out.println(empone);
	//	System.out.println(emptwo);
	//	System.out.println(manone);
		
		Box<Integer> intBox = new Box<Integer>();
		intBox.add(234);
		intBox.add(435);
		intBox.add(867);
		intBox.add(965);
		
		System.out.println(intBox.get());
		
		Box<String> strBox = new Box<String>();
		strBox.add("Hi");
		strBox.add("Sup");
		
		System.out.println(strBox.get());
		
		String str = "Checking";
		Accounts accOne = new Accounts(AccountTypes.valueOf(str));
		
		accOne.chosenAccount();
		
	}

}
