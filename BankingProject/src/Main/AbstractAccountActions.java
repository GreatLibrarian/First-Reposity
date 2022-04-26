package Main;

public abstract class AbstractAccountActions 
{
	String bankAccount;
	
	abstract float withdraw(int amount, int withdrawAmount);
	abstract float deposit(int amount, int depositAmount);
	
}
