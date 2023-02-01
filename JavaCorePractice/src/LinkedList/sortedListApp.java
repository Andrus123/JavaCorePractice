package LinkedList;

// demonstrates sorted list
class Link5 {
	public long dData;
	public Link5 next;

	public Link5(long dd) {
		dData = dd;
	}

	public void displayLink() {
		System.out.print(dData + " ");
	}
}

class SortedList {
	private Link5 first;
	
	public SortedList()
	{ first = null;}
	
	public boolean isEmpty()
	{ return (first==null);}
	
	public void insert(long key)
	{
		Link5 newLink = new Link5(key);
		Link5 previous = null;
		Link5 current = first;
		
		while(current != null && key > current.dData)
		{
			previous = current;
			current = current.next;
		}
		if(previous==null)		// at beginning of list
			first = newLink;	// first --> newLink
		else					// not at beginning
			previous.next = newLink;	// old prev --> newLink
		newLink.next = current;			// newLink --> old current
	}
	public Link5 remove()	// return && delete first link
	{
		Link5 temp = first;		// save first
		first = first.next;
		return temp;
	}
	public void displayList()
	{
		System.out.print("List (first-->last): ");
		Link5 current = first;	// start at beginning of list
		while(current != null)	// until end of list
		{
			current.displayLink();  // print data
			current = current.next;	// move to next link
		}
		System.out.println("");
	}
}

public class sortedListApp {

	public static void main(String[] args) {
		SortedList theSortedList = new SortedList();
		theSortedList.insert(20);
		theSortedList.insert(40);
		
		theSortedList.displayList();
		
		theSortedList.insert(10);
		theSortedList.insert(30);
		theSortedList.insert(50);
		
		theSortedList.displayList();
		
		theSortedList.remove();
		
		theSortedList.displayList();
	}
}
