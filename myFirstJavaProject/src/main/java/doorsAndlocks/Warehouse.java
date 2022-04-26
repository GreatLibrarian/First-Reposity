package doorsAndlocks;
import java.util.*;

public class Warehouse 
{
	private Door door;
	private Key key;
	private Keychain keychain;
	
	private List<Door> doors;
	
	public Warehouse()
	{
		
	}
	
	public Warehouse(int amount, double ratio)
	{
		doors = new ArrayList<Door>();
		int lockedDoors = (int)(amount * ratio);
		int unlockedDoors = (int)(amount - (amount - ratio));
		
		for(int x = 0; x < amount; x++)
		{
			if(x < lockedDoors)
			{
				int shapeValue = (int)Math.floor(Math.random() * 4);
				Keyshape shape = Keyshape.Unknown;
				switch(shapeValue)
				{
				case 0: 
					shape = Keyshape.Square;
					break;
				case 1:
					shape = Keyshape.Circular;
					break;
				case 2:
					shape = Keyshape.Oval;
					break;
				case 3:
					shape = Keyshape.TrapezoidDown;
					break;
				
				}
				doors.add(new Door(new Key(shape)));
			}
			else
			{
				doors.add(new Door(null));
			}
		}
	}
	
	public List<Door> doors()
	{
		return doors;
	}
	
	public int size()
	{
		return doors.size();
	}
}
