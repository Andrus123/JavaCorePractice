package LinkedList;



public class StackLink<Item> {
	private Node first;
	private int N;
	
	private class Node
	{
		Item item;
		Node next;
	}
	
	public boolean isEmpty() { return first == null;}	// Or: N==0
	public int size()		 { return N;}
	
	public void push(Item item)
	{	// Add item to top of stack
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop()
	{	// Remove item from top of stack
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
}
