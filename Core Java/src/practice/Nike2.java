package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class Nike2
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\kruta\\Downloads\\nike-test.txt"));
    String line;
   
    HashSet<String> set = new HashSet<String>();
    while ((line = in.readLine()) != null)
    {
        String function = "";
        String input = "";
    	
        if(line.contains("|"))
    	{
    	     function = line.substring(0, line.indexOf('|'));
    	     input = line.substring(line.indexOf('|')+1);
    	}
    	else
    		function = line;
      
      if(function.equals("Add"))
      {
    	  if(set.contains(input))
    		  System.out.println("False");
    	  else
    	  {
    		  set.add(input);
    		  System.out.println("True");
    	  }
      }
      
      if(function.equals("Get"))
      {
    	  if(set.contains(input))
    		  System.out.println(input);
    	  else
    		  System.out.println("NULL");
      }
      
      if(function.equals("Remove"))
      {
    	  if(set.contains(input))
    	  {
    		  set.remove(input);
    		  System.out.println("True");
    	  }
    	  else
    		  System.out.println("False");
      }
      
      if(function.equals("Has"))
      {
    	  if(set.contains(input))
    		  System.out.println("True");
    	  else
    		  System.out.println("False");
      }
      
      if(function.equals("Reset"))
      {
    	  set = new HashSet<String>();
      }
    }
  }
}
