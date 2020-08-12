package Unrolled_LinkedList;

import java.util.Random;
import java.util.Scanner;

class UnrollNode
{ 
    UnrollNode next; 
    int numOfElements; 
    int array[]; 
  
    public UnrollNode(int n) 
    { 
        next = null; 
        numOfElements = 0; 
        array = new int[n]; 
    } 
} 

public class UnrolledLinkedList
{
	private UnrollNode start; 
    private UnrollNode end; 
  
    int sizeOfNode; 
    int nNode; 
  
    // Parameterized Constructor 
    UnrolledLinkedList(int capacity) 
    { 
        start = null; 
        end = null; 
        nNode = 0; 
        sizeOfNode = capacity + 1; 
    } 
  
    // Insertion operation 
    public void insert(int num) 
    { 
        nNode++; 
  
        // Check if the list starts from NULL 
        if (start == null)
        { 
            start = new UnrollNode(sizeOfNode); 
            start.array[0] = num; 
            start.numOfElements++; 
            end = start; 
            return; 
        } 
  
        // Attaching the elements into nodes 
        if (end.numOfElements + 1 < sizeOfNode)
        { 
            end.array[end.numOfElements] = num; 
            end.numOfElements++; 
        } 
        // Creation of new Node 
        else
        { 
            UnrollNode newNode = new UnrollNode(sizeOfNode); 
            int j = 0; 
            for (int i = end.numOfElements / 2 + 1; i < end.numOfElements; i++) 
                newNode.array[j++] = end.array[i]; 
  
            newNode.array[j++] = num; 
            newNode.numOfElements = j; 
            end.numOfElements = end.numOfElements / 2 + 1; 
            end.next = newNode; 
            end = newNode; 
        } 
    } 
  
    // Display the Linked List 
    public void display() 
    { 
        System.out.print("\nUnrolled Linked List = "); 
        System.out.println(); 
        UnrollNode pointer = start; 
        while (pointer != null)
        { 
            for (int i = 0; i < pointer.numOfElements; i++) 
                System.out.print(pointer.array[i] + " "); 
            
            System.out.println(); 
            pointer = pointer.next; 
        } 
        System.out.println(); 
    } 
    
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in); 
  
        // create instance of Random class 
        Random randam = new Random(); 
  
        UnrolledLinkedList ull = new UnrolledLinkedList(5);	//capacity = 5 
  
        // Perform Insertion Operation 
        for (int i = 0; i < 12; i++)
        { 
            // Generate random integers in range 0 to 99 
            int rand = randam.nextInt(100); 
            System.out.println("Entered Element is " + rand); 
            ull.insert(rand); 
            ull.display(); 
        } 
    } 
}
