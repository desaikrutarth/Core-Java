package Google_3;

import java.util.HashMap;

/*
 Write all the possible numbers returned from a calculator pad where a start number move in a L direction in any directions(1-2moves) 

ie. From calculator pad. Start from 8 --> go in L shape (2up, 1right), and it returns 3 
ie. Start from 2, (move 2 down, 1 left), it will be 7 
ie. Start from 2(move 2 down, 1 right), it will be 9 
ie. Start from 7(move 1 left, 2 up), it will be 2 
ie. Start from 7(move 1 up, 2 left), it will be 6

 	|1,2,3|
 *  |4,5,6|
 *  |7,8,9|
 *  |0|
 */
public class CalculatorMoveHashMap 
{	     
	     
	     public static void generate(int number)
	     {
	         
	        HashMap<Integer, HashMap<String, Integer>> calculator = new HashMap<Integer, HashMap<String, Integer>>();
	        
	        calculator.put(0, new HashMap<String, Integer>());
	        calculator.get(0).put("x", 3);
	        calculator.get(0).put("y", 2);
	        
	        calculator.put(1, new HashMap<String, Integer>());
	        calculator.get(1).put("x", 2);
	        calculator.get(1).put("y", 1);
	        
	        calculator.put(2, new HashMap<String, Integer>());
	        calculator.get(2).put("x", 2);
	        calculator.get(2).put("y", 2);
	        
	        calculator.put(3, new HashMap<String, Integer>());
	        calculator.get(3).put("x", 2);
	        calculator.get(3).put("y", 3);
	        
	        calculator.put(4, new HashMap<String, Integer>());
	        calculator.get(4).put("x", 1);
	        calculator.get(4).put("y", 1);
	        
	        calculator.put(5, new HashMap<String, Integer>());
	        calculator.get(5).put("x", 1);
	        calculator.get(5).put("y", 2);
	        
	        calculator.put(6, new HashMap<String, Integer>());
	        calculator.get(6).put("x", 1);
	        calculator.get(6).put("y", 3);
	        
	        calculator.put(7, new HashMap<String, Integer>());
	        calculator.get(7).put("x", 0);
	        calculator.get(7).put("y", 1);
	        
	        calculator.put(8, new HashMap<String, Integer>());
	        calculator.get(8).put("x", 0);
	        calculator.get(8).put("y", 2);
	        
	        calculator.put(9, new HashMap<String, Integer>());
	        calculator.get(9).put("x", 0);
	        calculator.get(9).put("y", 3);
	            
	            int[][] LMove= {{-1,-2},
				{-1,2},
				{1,2},
				{1,-2},
				{-2,-1},
				{-2,1},
				{2,-1},
				{2,1}};
				
			int currentX = calculator.get(number).get("x");
			int currentY = calculator.get(number).get("y");
			
			for (int[] move : LMove)
			{
			    
			    int destX = currentX + move[0];
			    int destY = currentY + move[1];
			    
			    HashMap<String, Integer> point= new HashMap<String, Integer>();
			    
			    point.put("x", destX);
			    point.put("y", destY);
			    int destNum = getKeyFromValue(calculator, point);
			    if(destNum !=10){
			        
			        System.out.println(destNum);
			        
			    }
			    
			}
	               
	     }
	     
	     public static int getKeyFromValue(HashMap hm, Object value)
	     {
	        for (Object o : hm.keySet())
	        {
	            if (hm.get(o).equals(value)) 
	            {
	                
	                int i = (int) o;
	                return i;
	            }
	        }
	        return 10;
	     }
	     
	     public static void main(String []args)
	     {		   
		      generate(6); 
		 }
}
