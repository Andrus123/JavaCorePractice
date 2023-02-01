package LinkedList;
// demonstrates a stack implemented as a list

class Link4 {
	public long dData; // data item
	public Link4 next; // next link in list

	public Link4(long dd) // constructor
	{
		dData = dd;
	}

	public void displayLink() // display ourself
	{
		System.out.print(dData + " ");
	}
}

class LinkList3 {
	private Link4 first; // ref to first item on list

	public LinkList3() // constructor
	{
		first = null; // no items on list yet
	}

	public boolean isEmpty() // true if list is empty
	{
		return (first == null);
	}

	public void insertFirst(long dd) // insert at start of list
	{ // make new link
		Link4 newLink = new Link4(dd);
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}

	public long deleteFirst() { // delete first item
		Link4 temp = first; // save reference to link
		first = first.next; // delete it: first --> old next
		return temp.dData; // return deleted link
	}

	public void displayList() {
		Link4 current = first; // start at beginning of list
		while (current != null) // until end of list
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}
}

class LinkStack {
	private LinkList3 theList;
	
	public LinkStack()	// constructor
	{
		theList = new LinkList3();
	}
	public void push(long j)	// put item on top of stack
	{
		theList.insertFirst(j);
	}
	public long pop()			// take item from top of stack
	{
		return theList.deleteFirst();
	}
	public boolean isEmpty() {	// true if stack is empty
		return (theList.isEmpty());
	}
	public void displayStack() {
		System.out.print("Stack (top-->bottom): ");
		theList.displayList();
	}
}

public class linkStackApp {
	public static void main(String[] args) {
		LinkStack theStack = new LinkStack();	// make stack
		theStack.push(20);
		theStack.push(40);
		
		theStack.displayStack();
		
		theStack.push(60);
		theStack.push(80);
		
		theStack.displayStack();
		
		theStack.pop();
		theStack.pop();
		
		theStack.displayStack();
	}
}
