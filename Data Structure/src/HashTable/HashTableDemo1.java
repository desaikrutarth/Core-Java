package HashTable;

class DataItems
{
	private int data;
	
	public DataItems(int data)
	{
		this.data = data;
	}
	public int getData()
	{
		return data;
	}
}

class HashTable1
{
	private DataItems[] hashArray;
	private int maxSize;
	
	public HashTable1(int size)
	{
		maxSize = size;
		hashArray = new DataItems[maxSize];
	}
	
	public int hashFunc(int key)
	{
		return key % maxSize;
	}
	
	public void insert(DataItems data)
	{
		int key = data.getData();
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null)
		{
			hashVal++;
			hashVal %= maxSize;
		}
		hashArray[hashVal] = data;
	}
	
	public DataItems delete(int key)
	{
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null)
		{
			if(hashArray[hashVal].getData() == key)
			{
				DataItems temp = hashArray[hashVal];
				hashArray[hashVal] = null;
				return temp;
			}
			hashVal++;
			hashVal %= maxSize;
		}
		return null;
	}
	
	public void display()
	{
		for(int i=0; i < maxSize; i++)
		{
			if(hashArray[i] != null) 
				System.out.println(hashArray[i].getData());
		}
	}
}

public class HashTableDemo1
{
	public static void main(String[] args)
	{
		HashTable1 htable = new HashTable1(5);
		
		DataItems dItems = new DataItems(10);
		htable.insert(dItems);
		
		DataItems dItems1 = new DataItems(20);
		htable.insert(dItems1);
		
		DataItems dItems2 = new DataItems(30);
		htable.insert(dItems2);
		
		DataItems data = htable.delete(20);
		System.out.println(data.getData()+" is deleted");
		
		htable.display();
	}
}
