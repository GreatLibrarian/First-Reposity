package customException;

public class Main 
{
	public static void main(String[] args) throws CustomExceptionFile
	{
		
	
		try
		{
			withdraw(250, 100);
		}
		catch(CustomExceptionFile e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Everything is working");
		}

		
	}
	
	public static void withdraw(double amount, double balance) throws CustomExceptionFile
	{
		if(amount <= balance)
		{
			balance -= amount;
		}
		else
		{
			double accountBelow = amount - balance;
			throw new CustomExceptionFile(accountBelow, "Balance is less than the Amount being withdrawn.");
		}
	}
}
