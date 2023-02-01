package CollectionFramework;

// Demonstrate LinkedList
import java.util.*;

public class LinkedListDemo {
	public static void main(String[] args) {
		// Create a linked list
		LinkedList<String> l1 = new LinkedList<String>();
		
		// Add elements to the linked list
		l1.add("F");
		l1.add("B");
		l1.add("D");
		l1.add("E");
		l1.add("C");
		l1.addLast("Z");
		l1.addFirst("A");
		
		l1.add(1,"A2");
		
		System.out.println("Original contents of l1: "+ l1);
		
		// Remove elements from the linked list
		l1.remove("F");
		l1.remove(2);
		
		System.out.println("Contents of l1 after deletions: "+l1);
		// Remove first and last elements
		l1.removeFirst();
		l1.removeLast();
		
		System.out.println("l1 after deleting first and last: "+l1);
		
		// Get and set a value
		String va1 = l1.get(2);
		l1.set(2, va1+" Changed");
		
		System.out.println("l1 after change: "+l1);
	}
}
