package myFirstJavaProject;
import java.util.Scanner;

public class firstClass 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your name.");
		String firstName = scan.nextLine();
		
		System.out.println("Welcome " + firstName);
	}
}
