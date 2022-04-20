package monsterAssignment;

public class Main 
{
	public static void main(String[] args)
	{
		Monster m1 = new FireMonster("yes");
		Monster m2 = new WaterMonster("no");
		Monster m3 = new StoneMonster("maybe");
		
		System.out.println(m1.attack());
		System.out.println(m2.attack());
		System.out.println(m3.attack());
		
		m1 = new StoneMonster("so");
		System.out.println(m1.attack());
		
		Monster m4 = new Monster("huh?");
		System.out.println(m4.attack());
	}
}
