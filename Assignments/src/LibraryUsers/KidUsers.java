package LibraryUsers;

public class KidUsers implements LibraryUser
{
	private String allowedBook;
	private boolean registered;
	
	public KidUsers()
	{
		allowedBook = "Kids";
		registered = false;
	}
	
	@Override
	public void registerAccount(int age) 
	{
		if(age < 12)
		{
			registered = true;
			System.out.println("You have successfully registered under a Kids Account.");
		}
		else
		{
			System.out.println("Sorry, you must be less than 12 years old to register as a kid.");
		}
	}

	@Override
	public void requestBook(String bookType) 
	{
		if(registered)
		{
			if(bookType.equals(allowedBook))
			{
				System.out.println("Book issued successfully, please return the book within 10 days.");
			}
			else
			{
				System.out.println("Oops, you are allowed to only take kids books.");
			}
		}
		else
		{
			System.out.println("You have not registered an Account yet.");
		}
	}
	
}
