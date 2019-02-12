package Google_3;
/*
 
Give an Enum, where each element has a parent-children relationship, and children's expression is the value of parent append an index,
such as
	enum vehicle
	{
         car = 1
             toyota = 11
                  camry = 111
                  corolla = 112
             honda = 12
        truck = 2
             GMC = 21
	}  

Ask a value, return to his parent, such as GMC = 21, return to the truck
 */
public class EnumHierarchical 
{
	static enum Vehicle
	{
		car(null,1),
			toyota(car,11),
				camry(toyota,111),
				coroloa(toyota,112),
			honda(car,12),
		track(null,2),
			GMC(track,21);
		
		public Vehicle parent;
		public int value;
		
		Vehicle(Vehicle parent,int value)
		{
			this.parent = parent;
			this.value = value;
		}
			
	}
	

	public static void main(String[] args)
	{
		System.out.println(Vehicle.GMC + " " + Vehicle.GMC.value);
		System.out.println(Vehicle.GMC.parent + " " + Vehicle.GMC.parent.value);
	}
}
