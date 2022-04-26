package customException;

public class CustomExceptionFile extends Exception
{
	private double amount;
	private static double balance;
	public CustomExceptionFile(double amount, String message)
	{
		super(message);
		this.amount = amount;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
}
