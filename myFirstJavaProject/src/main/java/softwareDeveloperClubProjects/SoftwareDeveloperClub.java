package softwareDeveloperClubProjects;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SoftwareDeveloperClub {

//	File file;
//	Scanner input;

	private ArrayList<String> name;
	private ArrayList<String> city;
	private ArrayList<String> state;
	private ArrayList<String> favoriteLanguage;
	private int size;
	private ArrayList<String[]> data;

	public SoftwareDeveloperClub(String path) {
		try {
			File file = new File(path);
			Scanner input = new Scanner(file);
			data = new ArrayList<>();

			while (input.hasNextLine()) {
				String line = input.nextLine();
				data.add(line.split("\\*\\*"));
			}

//			for (String[] l : data) {
//				System.out.println(l[0] + "|" + l[1] + "|" + l[2] + "|" + l[3]);
//			}
//			System.out.println(data.get(0)[1]);

			size = data.size() - 1; // This is because the column names are all part of the first element
			name = new ArrayList<>();
			city = new ArrayList<>();
			state = new ArrayList<>();
			favoriteLanguage = new ArrayList<>();

			for (int x = 0; x < size; x++) {
				name.add(data.get(x + 1)[0]);
				city.add(data.get(x + 1)[1]);
				state.add(data.get(x + 1)[2]);
				favoriteLanguage.add(data.get(x + 1)[3]);
			}

			input.close();

		} catch (FileNotFoundException e) {
			System.out.println("File " + path + " not found.");
			e.printStackTrace();
		}
	}
	
	public void menu()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Select from the following menu:");
		System.out.println("1: Display Members");
		System.out.println("2: Remove Member");
		System.out.println("3: Add Member");
		System.out.println("4: Quit");
		
		switch(scan.nextInt())
		{
		case 1:
			for(int x = 0; x < size; x++)
			{
				System.out.println("Member #" + (x+1) + " Name: " + getName().get(x));
				System.out.println("Location: " + getCity().get(x) + ", " + getState().get(x));
				System.out.println("Favorite Language: " + getFavoriteLanguage().get(x) + '\n');
			}
			System.out.println("Enter any character to return to menu.");
			scan.next();
			menu();
			break;
		case 2:
			System.out.println("Which number member would you like to remove?");
			int remover = scan.nextInt() - 1;
			if(remover < size)
			{
				getName().remove(remover);
				getCity().remove(remover);
				getState().remove(remover);
				getFavoriteLanguage().remove(remover);
				size--;
				
				System.out.println("Member successfully removed." + '\n' + "Enter any character to return to menu.");
				scan.next();
				menu();
				break;
			}
		case 3:
			System.out.println("Enter the name of the member you would like to add.");
			getName().add(scan.next());
			System.out.println("Enter their city.");
			getCity().add(scan.next());
			System.out.println("Enter their state abbreviation");
			getState().add(scan.next());
			System.out.println("Enter their favorite programming language");
			getFavoriteLanguage().add(scan.next());
			size++;
			
			System.out.println("Member successfully added." + '\n' + "Enter any character to return to menu.");
			scan.next();
			menu();
			break;
		case 4:
			System.out.println("Program successfully closed. Have a nice day!");
			break;
		}
	}

	
	
	public ArrayList<String> getName() {
		return name;
	}

	public void setName(ArrayList<String> name) {
		this.name = name;
	}

	public ArrayList<String> getCity() {
		return city;
	}

	public void setCity(ArrayList<String> city) {
		this.city = city;
	}

	public ArrayList<String> getState() {
		return state;
	}

	public void setState(ArrayList<String> state) {
		this.state = state;
	}

	public ArrayList<String> getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(ArrayList<String> favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<String[]> getData() {
		return data;
	}

	public void setData(ArrayList<String[]> data) {
		this.data = data;
	}
	
	
}
