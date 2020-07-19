package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. 
Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []].
 Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.

Example 1:

Input: ([[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1)
Output: 11
Explanation:
Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3.
They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 */
class Employee 
{
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class EmployeeImportance
{
	public int getImportance(List<Employee> employees, int queryid) 
	{
		HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
		
		for(Employee employee : employees)
		{
			map.put(employee.id, employee);
		}
		
		int total = 0;
		
		Employee emp = map.get(queryid);
		total += emp.importance;
	
		for(int sub : emp.subordinates)
		{
			Employee e = map.get(sub);
			total += e.importance;
		}
		return total;
	}
	
/*	Map<Integer, Employee> emap;
	public int getImportance(List<Employee> employees, int queryid) 
	{
        emap = new HashMap<>();
        for (Employee e: employees)
        	emap.put(e.id, e);
        
        
        Employee employee = emap.get(queryid);
        int importance = employee.importance;
        
        for(int subId : employee.subordinates)
        {
     	   Employee e = emap.get(subId);
     	   importance += e.importance;
        }
        return importance;
    }
*/	
	public static void main(String[] args) 
	{
		ArrayList<Employee> employees = new ArrayList<>();
		
		Employee e1 = new Employee();
		e1.subordinates = new ArrayList<>();
		e1.id = 1;
		e1.importance = 5;
		e1.subordinates.add(2);
		e1.subordinates.add(3);
		employees.add(e1);
		
		Employee e2 = new Employee();
		e2.subordinates = new ArrayList<>();
		e2.id = 2;
		e2.importance = 3;
		employees.add(e2);
		
		Employee e3 = new Employee();
		e3.subordinates = new ArrayList<>();
		e3.id = 3;
		e3.importance = 3;
		employees.add(e3);
		
		System.out.println(new EmployeeImportance().getImportance(employees, 1));
	}
}
