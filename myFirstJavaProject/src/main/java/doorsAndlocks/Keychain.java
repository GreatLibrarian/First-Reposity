package doorsAndlocks;
import java.util.*;

public class Keychain 
{
	private HashMap<Keyshape, ArrayList<Key>> keys = new HashMap<Keyshape, ArrayList<Key>>(); // <- holds duplicate keys and can organize by shape
	
//	private Set<Key> keys = new TreeSet<Key>(); <- This can't hold duplicate keys and doesn't organize by shape
	
	public Keychain()
	{
		
	}
	
	public Keychain(Collection<Key> keys)
	{
//		this.keys.addAll(keys); <- Used for TreeSet
		for(Key k : keys)
		{
			addKey(k);
		}
	}
	
	public boolean addKey(Key key)
	{
//		return keys.add(key);
		if(!keys.containsKey(key.shape()))
		{
			keys.put(key.shape(), new ArrayList<Key>());
		}
		
		keys.get(key.shape()).add(key);
		return true;
	}
	
	public boolean removeKey(Key key)
	{
//		return keys.remove(key);
		if(keys.containsKey(key.shape()))
		{
			return keys.get(key.shape()).remove(key);
		}
		return false;
	}
	
	public int keyCount()
	{
//		return keys.size();
		int keyCount = 0;
		for(Keyshape keyshape : keys.keySet())
		{
			keyCount += keys.get(keyshape).size();
		}
		return keyCount;
	}
	
	
	public boolean lock(Door door)
	{
//		if (door.isLocked())
//		{
//			return true;
//		}
//		
//		for(Key k : keys)
//		{
//			if(door.unlock(k))
//			{
//				return true;
//			}
//		}
//		
//		return false;
		
		if(door.isLocked()) return true;
		if(!door.hasKey()) return false;
		if(!keys.containsKey(door.key().shape())) return false;
		for(Key k : keys.get(door.key().shape()))
		{
			if(door.lock(k)) return true;
		}
		return false;
	}
	
	public boolean unlock(Door door)
	{
//		if(!door.isLocked())
//		{
//			return true;
//		}
//		for(Key k: keys)
//		{
//			if(door.unlock(k))
//			{
//				return true;
//			}
//		}
//		return false;
		
		if(!door.isLocked()) return true;
		if(!door.hasKey()) return true;
		if(!keys.containsKey(door.key().shape())) return false;
		for(Key k : keys.get(door.key().shape()))
		{
			if(door.unlock(k)) return true;
		}
		return false;
	}
}
