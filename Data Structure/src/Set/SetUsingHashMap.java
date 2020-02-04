package Set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SetUsingHashMap 
{
	HashMap<Integer, Integer> map = new HashMap<>();
	
	void add(int data)
	{
		map.merge(data, 1, Integer::sum);
	}
	
	int get(int index)
	{
		return new ArrayList<>(map.keySet()).get(index);
	}
	
	int getRandom()
	{
		return new ArrayList<>(map.keySet()).get(new Random().nextInt(map.size()));
	}
	
	void print()
	{
		System.out.println(map.keySet());
	}
	
	public static void main(String args[])
	{
		SetUsingHashMap set = new SetUsingHashMap();
		set.add(10);
		set.add(20);
		set.add(20);
		set.add(50);
		set.add(50);
		
		set.print();
		System.out.println(set.get(0));
		System.out.println("Random: "+set.getRandom());
		
	}
}
