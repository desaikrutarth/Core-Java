package General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Consider that the driver with one trip want to pick up some peoples in different locations like this: 
String[] locations ={ 
	"person1, person2, person3, person4, person5", 
	"person6, person7, person8, person9", 
	"person10, person11, person12", 
	"person13, person14, person15"
	} 
in each location there are different choice, so write a code present all possible way to pick up people in the different locations.
you can use every data structure needs.
 */
public class AllpermutationFromList 
{
	static List<String> getPermutations(List<String[]> input)
    {
        ArrayList<String> result = new ArrayList<>();
        if(input.size() == 0) 
        {
            return Arrays.asList("");
        }
        String[] current = input.get(0);
        //copy rest of array
        List<String[]> rest = input.subList(1, input.size());
        List<String> subCombos = getPermutations(rest);
        for(String s : current)
        {
            for(int i = 0; i < subCombos.size(); i++)
            {
                String combo = subCombos.get(i);
                result.add("->" + s + combo);
            }
        }
        return result;
    }
    
    public static void main (String[] args) 
	{
	       List<String[]> input = new ArrayList<>();
	       input.add(new String[]{"P1", "P2", "P3"});
	       input.add(new String[]{"P4", "P5", "P6"});
	       input.add(new String[]{"P7", "P8"});
	       List<String> result = getPermutations(input);
	       for (String s : result)
	       {
	           System.out.println(s);
	       }
	}
}
