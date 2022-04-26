package doorsAndlocks;

public class Main implements Cloneable {

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse(100, 0.9);
		System.out.println("Number of Doors: " + warehouse.size());

		for (int x = 0; x < warehouse.size(); x++) {
			System.out.println("Door #" + (x + 1));
			System.out.print("Door Key: ");
			if (warehouse.doors().get(x).key() == null) {
				System.out.println("None");
			} else {
				System.out.println(warehouse.doors().get(x).key());
			}
			System.out.print("Door Locked: ");
			if (warehouse.doors().get(x).isLocked()) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			if (warehouse.doors().get(x).key() != null) {
				System.out.println("Key Shape: " + warehouse.doors().get(x).key().shape());
			}

		}
//		Key spareKey = (Key)key.clone();
	}

}
