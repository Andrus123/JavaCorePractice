package LinkedList;

class Link {
	public int iData; // data item(key)
	public double dData;
	public Link next;

	public Link(int id, double dd) // constructor
	{
		iData = id; // initialize data
		dData = dd;
	}

	public void displayLink() { // display ourself
		System.out.print("{" + iData + ", " + dData + "} ");
	}
}

class LinkList {
	private Link first; // ref to first link on list

	public LinkList() { // constructor
		first = null; // no items on list yet
	}

	public boolean isEmpty() { // true if list is empty
		return (first == null);
	}

	// insert at start of list
	public void insertFirst(int id, double dd) {
		// make new link
		Link newLink = new Link(id, dd);
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}

	// delete first item
	public Link deleteFirst() { // (assumes list not empty)
		Link temp = first;
		first = first.next;
		return temp;
	}

	public void displayList() {
		System.out.print("List (first-->last): ");
		Link current = first; // start at beginning of list
		while (current != null) // until end of list,
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}
}

public class LinkListApp {

	public static void main(String[] args) {
		LinkList theList = new LinkList(); // make new list

		theList.insertFirst(22, 2.99);
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);

		theList.displayList(); // display list

		while (!theList.isEmpty()) {
			Link aLink = theList.deleteFirst();
			System.out.print("Deleted ");
			aLink.displayLink();
			System.out.println("");
		}
		theList.displayList();
		theList.insertFirst(77, 4.64);
		theList.insertFirst(66, 5.88);
		theList.displayList();
	}
}
