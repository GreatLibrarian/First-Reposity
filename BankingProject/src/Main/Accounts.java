package Main;

enum AccountTypes
{
	CHECKING, SAVINGS, CREDIT
}

public class Accounts 
{
	// reference of the enum
	AccountTypes accountTypes;
	
	public Accounts(AccountTypes accountTypes)
	{
		super();
		this.accountTypes = accountTypes;
	}
	
	//method of choosing account types
	public void chosenAccount()
	{
		switch(accountTypes)
		{
		case CHECKING:
			System.out.println("You Chose Checking");
			break;
		case SAVINGS:
			System.out.println("You Chose Savings");
			break;
		case CREDIT:
			System.out.println("You Chose Credit");
			break;
		}
	}
}
