package doorsAndlocks;

public class Main implements Cloneable {

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse(100, 0.9); //100 and 0.9 are the amount of doors and the ratio of keyed doors, respectively
		System.out.println("Number of Doors: " + warehouse.size()); //Total # of doors

		for (int x = 0; x < warehouse.size(); x++) {
			System.out.println("Door #" + (x + 1)); //Door #1, for example
			System.out.print("Door Key: ");
			if (warehouse.doors().get(x).key() == null) { //This block is tidying up the language, if a door has no key, "None" will be printed
				System.out.println("None");
			} else {
				System.out.println(warehouse.doors().get(x).key());
			}
			System.out.print("Door Locked: ");
			if (warehouse.doors().get(x).isLocked()) { //Instead of true false, we're outputting Yes or No
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			if (warehouse.doors().get(x).key() != null) { //Using this method when key is null results in a runtime error
				System.out.println("Key Shape: " + warehouse.doors().get(x).key().shape());
			}

		}
		
//		Keychain chain = new Keychain();
//		for(int x = 0; x < warehouse.size(); x++)
//		{
//			if(warehouse.doors().get(x).key() != null)
//			{
//				chain.addKey(warehouse.doors().get(x).key());
//			}
//		}
	}

}
