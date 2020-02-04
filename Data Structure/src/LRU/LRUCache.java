package LRU;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/*
 *  Implement LRU Cashe using LinkedHashMap
 */
public class LRUCache<K,V> extends LinkedHashMap<K, V>
{

	private static final long serialVersionUID = 1L;
	private int size;
	
	public LRUCache(int size)
	{
		super(size, 0.75f, true);
		this.size = size;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
		return size() > size;
	}
	
	public static <K, V> LRUCache<K, V> newInstance(int size){
		return new LRUCache<K, V>(size);
	}
	
	public static void main(String[] args)
	{
		LRUCache<String,Integer> lru = new LRUCache<>(3);
		lru.put("A", 1);
		lru.put("B", 1);
		lru.put("C", 1);
		lru.put("D", 1);
		lru.put("E", 1);
		
		Set<Entry<String,Integer>> entrySet = lru.entrySet();
		
		for(Entry<String, Integer> entry : entrySet)
		{
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
}


