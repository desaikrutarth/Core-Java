package Set;
import java.util.Arrays;

class HashSet
{
    private int[] setArray;
    private int nItems;
    private int maxSize;

    public HashSet(int size)
    {
        maxSize = size;
        setArray = new int[maxSize];
        nItems = 0;
    }

    public boolean contains(int value) 
    {
        for(int setItem : setArray)
        {
            if(setItem == value) 
            {
                return true;
            }
         }
         return false;
     }
    
    public void add(int x) 
    {
        if (contains(x))
            return;
        if (nItems >= maxSize) 
        {
            maxSize *= 2;
            setArray = Arrays.copyOf(setArray, maxSize);
        }
        setArray[nItems++] = x;
    }

    public boolean remove(int x)
    {
        boolean remove = false;
        for(int i = 0; i < maxSize; i++)
        {
            if(x == setArray[i])
            {
                setArray[i] = setArray[nItems -1];
                nItems--;
                remove =  true;
            }
            if(isEmpty())
            {
               remove =  false;
            }
        }
        return remove;
    }

    public void clear()
    {
        setArray = null;
        nItems = 0;
    }

    public int size()
    {
        return nItems;
    }

    public boolean isEmpty()
    {
        if(nItems == 0)
            return true;
        else
            return false;
    }

    public int[] toArray()
    {
        return Arrays.copyOf(setArray, maxSize);
    }
    
    public void print()
    {
        for(int i = 0; i<nItems; i++)
        {
            System.out.print(setArray[i]+" ");
        }
        System.out.println("");
    }
}

public class SetUsingArrays
{
	public static void main(String[] args)
    {
        HashSet s1 = new HashSet(3);
        s1.add(1);
        s1.add(2);
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s1.print();
        
     //   s1.remove(3);
     //   s1.print();
      //  System.out.println("Size: "+s1.size());
    }
   
}
