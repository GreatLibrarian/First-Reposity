package softwareDeveloperClubProjects;

import java.util.Scanner;

public class ClubMemberApp {

	public static void main(String[] args) {
		
		SoftwareDeveloperClub club = new SoftwareDeveloperClub("C:\\Users\\andre\\Desktop\\TekSystem-code\\First-Reposity\\myFirstJavaProject\\src\\main\\java\\softwareDeveloperClubProjects\\members.txt");
		
		int size = club.getSize();
		
		club.menu();
		
		
//		This commented out code was when I was trying to implement the menu method within the main method (club.menu()). I decided to instead put it 
//		into the SoftwareDeveloperClub class instead as a void method.
		
//		Scanner scan = new Scanner(System.in); 
//		int input;
//		
//		System.out.println("Select from the following menu.");
//		System.out.println("1: Display Members");
//		System.out.println("2: Remove Member");
//		System.out.println("3: Add Member");
//		System.out.println("4: Quit");
//		
//		switch(scan.nextInt())
//		{
//		case 1:
//			for(int x = 0; x < size; x++)
//			{
//				System.out.println("Member #" + (x+1) + " Name: " + club.getName()[x]);
//				System.out.println("Location: " + club.getCity()[x] + ", " + club.getState()[x]);
//				System.out.println("Favorite Language: " + club.getFavoriteLanguage()[x]);
//			}
//			break;
//		case 2:
//			System.out.println("Which number member would you like to remove?");
//			if(!(scan.nextInt() > size))
//			{
//				
//			}
//		}
	}

}
