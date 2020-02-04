			package HashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


class Map<K, V>
{
	  private final K key;
	  private V value;

	  public Map(K key, V value)
	  {
		  this.key = key;
		  this.value = value;
	  }

	  public K getKey() {
	    return key;
	  }

	  public V getValue() {
	    return value;
	  }

	  public void setValue(V value) {
	    this.value = value;
	  }
} 

public class HashMap<K, V>
{
	private int size;
	private int DEFAULT_CAPACITY = 16;
	@SuppressWarnings("unchecked")
	private Map<K, V>[] values = new Map[DEFAULT_CAPACITY];

	public V get(K key)
	{
		for (int i = 0; i < size; i++)
	    {
			if (values[i] != null)
			{
				if (values[i].getKey().equals(key))
				{
					return values[i].getValue();
				}
			}
	    }
	    return null;
	}

	public void put(K key, V value)
	{
		boolean insert = true;
	    for (int i = 0; i < size; i++)
	    {
	    	if (values[i].getKey().equals(key))
	    	{
	    		values[i].setValue(value);
	    		insert = false;
	    	}
	    }
	    if (insert) 
	    {
	    	ensureCapa();
	    	values[size++] = new Map<K, V>(key, value);
	    }
	}

	private void ensureCapa()
	{
	    if (size == values.length)
	    {
	    	int newSize = values.length * 2;
	    	values = Arrays.copyOf(values, newSize);
	    }
	}

	public int size() 
	{
	    return size;
	}

	public void remove(K key)
	{
	    for (int i = 0; i < size; i++)
	    {
	    	if (values[i].getKey().equals(key))
	    	{
	    		values[i] = null;
	    		size--;
	    		condenseArray(i);
	    	}
	    }
	}

	private void condenseArray(int start)
	{
		for (int i = start; i < size; i++)
		{
			values[i] = values[i + 1];
	    }
	}

	public Set<K> keySet()
	{
	    Set<K> set = new HashSet<K>();
	    for (int i = 0; i < size; i++) {
	      set.add(values[i].getKey());
	    }
	    return set;
	}
	  
	public void print()
	{
		for(int i=0; i<size; i++)
			System.out.println(values[i].getKey()+"="+values[i].getValue());
	}
	  
	public static void main(String[] args)
	{
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(10, 1);
		map.put(20, 1);
		map.put(30, 1);
		map.put(10, 2);
		map.put(20, 2);
		 
		map.print();
	}
}
