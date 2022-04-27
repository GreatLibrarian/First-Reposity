package doorsAndlocks;
import java.util.*;

public class Warehouse 
{
	//Used to be unused variables here, took them out
	private List<Door> doors;
	
	public Warehouse()
	{
		
	}
	
	public Warehouse(int amount, double ratio) //amount and ratio are variables for custom inputs. For the exercise, amount = 100 and ratio = 0.9)
	{
		doors = new ArrayList<Door>();
		int lockedDoors = (int)(amount * ratio); //amount of doors we want keys for
		int unlockedDoors = (int)(amount - (amount - ratio)); //amount of doors we don't want to have keys
		
		for(int x = 0; x < amount; x++)
		{
			if(x < lockedDoors) //if our door is part of our keyed doors, we build a key
			{
				int shapeValue = (int)Math.floor(Math.random() * 4); //this whole block is used to assign a shape for the key we are adding
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
				doors.add(new Door(new Key(shape))); //adding a door to the list with a key
			}
			else
			{
				doors.add(new Door(null)); //adding a door to the list that doesn't have a key
			}
		}
	}
	
	public List<Door> doors() //since doors is private, we use this method to display it in other classes
	{
		return doors;
	}
	
	public int size()
	{
		return doors.size();
	}
}
