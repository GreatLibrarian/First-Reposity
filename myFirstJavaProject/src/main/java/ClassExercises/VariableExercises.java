package ClassExercises;
import java.util.Scanner;

public class VariableExercises 
{
	int sum1;
	int sum2;
	double dsum1;
	double dsum2;
	
	public VariableExercises()
	{
		int sum1 = 0;
		int sum2 = 0;
		double dsum1 = 0;
		double dsum2 = 0;
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		VariableExercises var = new VariableExercises();
		
		System.out.println("Which question would you like to select?" + '\n' + "1 | 2 | 3 | 4 | 5 | 6 | 7 | 8");
		switch(scan.nextInt())
		{
		case 1: 
			//Question 1: Write a program that declares 2 integer variables, assigns an integer to each, and adds them together. Assign the sum to a variable. Print out the result.
			System.out.println("Write the two integers you want to add together.");
			System.out.println("Your sum is: " + var.sumInt(scan.nextInt(), scan.nextInt()));
			break;
		case 2:
			//Question 2: Write a program that declares 2 double variables, assigns a number to each, and adds them together. Assign the sum to a variable. Print out the result.
			System.out.println("Write the two doubles you want to add together.");
			System.out.println("Your sum is: " + var.sumDouble(scan.nextDouble(), scan.nextDouble()));
			break;
		case 3:
			//Question 3: Write a program that declares an integer variable and a double variable, assigns numbers to each, and adds them together. Assign the sum to a variable. Print out the result. What variable type must the sum be?
			System.out.println("Write the integer you want to add, then write the double.");
			System.out.println("Your sum is: " + var.sumIntDouble(scan.nextInt(), scan.nextDouble()));
			break;
		case 4:
			//Question 4: Write a program that declares 2 integer variables, assigns an integer to each, and divides the larger number by the smaller number. Assign the result to a variable. Print out the result. Now change the larger number to a decimal. What happens? What corrections are needed?
			System.out.println("Write your two integers that you want to divide the largest of here.");
			int x = scan.nextInt();
			int y = scan.nextInt();
			System.out.println("The integer quotient is: " + var.divideLargestInt(x, y));
			System.out.println("The double quotient is: " + var.divideLargestIntCast(x, y));
			break;
		case 5:
			//Question 5: Write a program that declares 2 double variables, assigns a number to each, and divides the larger by the smaller. Assign the result to a variable. Print out the result. Now, cast the result to an integer. Print out the result again.
			System.out.println("Write your two doubles that you want to divide by the largest with here.");
			double a = scan.nextDouble();
			double b = scan.nextDouble();
			System.out.println("The double quotient is: " + var.divideLargestDouble(a, b));
			System.out.println("The integer quotient is: " + var.divideLargestDoubleCast(a, b));
			break;
		case 6:
			//Question 6: Write a program that declares 2 integer variables, x, and y, and assign 5 to x and 6 to y. Declare a variable q and assign y/x to it and print q. Now, cast y to a double and assign to q. Print q again.
			//This can be done with my answer to question 4, so I'm skipping this.
			
			//Question 4: Write a program that declares 2 integer variables, assigns an integer to each, and divides the larger number by the smaller number. Assign the result to a variable. Print out the result. Now change the larger number to a decimal. What happens? What corrections are needed?
			System.out.println("Write your two integers that you want to divide the largest of here.");
			int n = scan.nextInt();
			int m = scan.nextInt();
			System.out.println("The integer quotient is: " + var.divideLargestInt(n, m));
			System.out.println("The double quotient is: " + var.divideLargestIntCast(n, m));
			break;
			
		case 7:
			//Question 7: Write a program that declares a named constant and uses it in a calculation. Print the result.
			System.out.println("Write the constant String you want to find in a sentence.");
			final String c = scan.next();
			System.out.println("Write the sentence you want to find the constant String in.");
			String d = scan.next();
			if(d.contains(c))
			{
				System.out.println("This sentence contains the constant " + c);
			}
			else
			{
				System.out.println("This sentence does not contain the constant " + c);
			}
			break;
		case 8: 
			//Write a program where you create 3 variables that represent products at a cafe. The products could be beverages like coffee, cappuccino, espresso, green tea, etc. Assign prices to each product. Create 2 more variables called subtotal and totalSale and complete an “order” for 3 items of the first product, 4 items of the second product, and 2 items of the third product. Add them all together to calculate the subtotal. Create a constant called SALES_TAX and add sales tax to the subtotal to obtain the totalSale amount. Be sure to format the results to 2 decimal places.
			final double sales_tax = 1.19;
			String frap = "Frappuccino";
			String cof = "Coffee";
			String decaf = "Decaf";
			
			double frap_price = 5.00;
			double coffee_price = 4.00;
			double decaf_price = 4.50;
			
			double price = 0;
			
			System.out.println("How many cups of " + frap + " would you like to have?");
			price = price + (frap_price * scan.nextInt());
			System.out.println("How many cups of " + cof + " would you like to have?");
			price = price + (coffee_price * scan.nextInt());
			System.out.println("How many cups of " + decaf + " would you like to have?");
			price = price + (decaf_price * scan.nextInt());
			
			double subtotal = price * sales_tax;
			double total = (int)(subtotal * 100) / 100;
			System.out.println("Your total cost is: $" + total);
			
			break;
		}
	}
	
	public int sumInt(int x, int y)
	{
		return x + y;
	}
	
	public double sumDouble(double x, double y)
	{
		return x + y;
	}
	
	public double sumIntDouble(int x, double y)
	{
		return x + y;
	}
	
	public int divideLargestInt(int x, int y)
	{
		if( x >= y)
		{
			return x / y;
		}
		else
		{
			return y / x;
		}
	}
	
	public double divideLargestIntCast(int x, int y)
	{
		if( x >= y)
		{
			return (double)x / y;
		}
		else
		{
			return (double)y / x;
		}
	}
	
	public double divideLargestDouble(double x, double y)
	{
		if( x >= y)
		{
			return x / y;
		}
		else
		{
			return y / x;
		}
	}
	
	public int divideLargestDoubleCast(double x, double y)
	{
		if( x >= y)
		{
			return (int) (x / y);
		}
		else
		{
			return (int) (y / x);
		}
	}
}
