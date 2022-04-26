package LibraryUsers;

public class AdultUsers implements LibraryUser
{
	private String allowedBook;
	private boolean registered;
	
	public AdultUsers()
	{
		allowedBook = "Fiction";
		registered = false;
	}
	
	@Override
	public void registerAccount(int age) 
	{
		if(age >= 12)
		{
			registered = true;
			System.out.println("You have successfully registered under an Adult Account.");
		}
		else
		{
			System.out.println("Sorry, you must be 12 years old or older to register as an adult.");
		}
	}

	@Override
	public void requestBook(String bookType) 
	{
		if(registered)
		{
			if(bookType.equals(allowedBook))
			{
				System.out.println("Book issued successfully, please return the book within 7 days.");
			}
			else
			{
				System.out.println("Oops, you are allowed to only take adult Fiction books.");
			}
		}
		else
		{
			System.out.println("You have not registered an Account yet.");
		}
	}
}
