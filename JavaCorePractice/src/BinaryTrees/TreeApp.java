package BinaryTrees;

// demonstrates binary tree
import java.io.*;
import java.util.*; // for Stack class

class Node {
	public int iData; // data used as key value
	public double dData; // other data
	public Node leftChild; // this node's left child
	public Node rightChild; // this node's right child

	public void displayNode() { // display ourself
		System.out.print('{');
		System.out.print(iData);
		System.out.print(", ");
		System.out.print(dData);
		System.out.print("} ");
	}
}

class Tree {
	private Node root; // the only data field in Tree

	public Tree() // constructor
	{
		root = null;
	} // no nodes in tree yet

	public Node find(int key) { // find node with given key
		Node current = root; // start at root
		while (current.iData != key) // while no match
		{
			if (key < current.iData)
				current = current.leftChild; // go left?
			else
				current = current.rightChild; // or go right?
			if (current == null) // if no child
				return null; // didn't find it
		}
		return current; // found it
	}

	public void insert(int id, double dd) {
		Node newNode = new Node(); // make new node
		newNode.iData = id; // insert data
		newNode.dData = dd;
		if (root == null) // no node in root
			root = newNode;
		else // root occupied
		{
			Node current = root; // start at root
			Node parent;
			while (true) { // (exits internally)
				parent = current;
				if (id < current.iData) // go left?
				{
					current = current.leftChild;
					if (current == null) // if end of the line,
					{ // insert on left
						parent.leftChild = newNode;
						return;
					}
				} // end if go right?
				else // or go right?
				{
					current = current.rightChild;
					if (current == null) // if end of the line
					{ // insert on right
						parent.rightChild = newNode;
						return;
					}
				} // end else go right
			} // end while
		} // end else not root
	}	// end insert()

	public boolean delete(int key) {	// delete node with given key
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.iData != key) // search for node
		{
			parent = current;
			if(key<current.iData)	// go left?
			{
				isLeftChild = true;
				current = current.leftChild;
			}
			else					// or go right?
			{		
				isLeftChild = false;
				current = current.rightChild;
			}
		  if(current == null)      // end of the line,
			  return false;		   // didn't find it
		} // end while
		// found node to delete
		
		// if no children, simply delete it
		if(current.leftChild==null && current.rightChild==null)
		{
			if(current==root)   // if root,
				root = null;    // tree is empty
			else if(isLeftChild)
				parent.leftChild = null;   // disconnect
			else
				parent.rightChild = null;
		}
		// if no right child, replace with left subtree
		else if(current.rightChild==null)
			if(current==root)
				root = current.leftChild;
			else if(isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		else	// two children, so replace with inorder successor
		{
			// get successor of node to delete(current)
			Node successor = getSuccessor(current);	
			
			// connect parent of current to successor instead
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			// connect successor to current's left child
			successor.leftChild = current.leftChild;
		}  // end else two children
		// (successor cannot have a left child)
		return true;
	}  // end delete()
	
	// Returns node with next highest value after delNode
	// goes to right child, then right child's left descendents
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; // go to right child
		while(current!=null)			// until no more
		{
			successorParent = successor;
			successor = current;
			current = current.leftChild; // go to left child
		}
		if(successor!= delNode.rightChild) // right child
		{
			successorParent.leftChild=successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
	
	public void traverse(int traverseType)
	{
		switch(traverseType)
		{
		case 1: System.out.println("\nPreorder traversal: ");
		  		preOrder(root);
		  		break;
		case 2: System.out.println("\nInOrder traversal: ");
				inOrder(root);
				break;
		case 3: System.out.println("\nPostOrder traversal: ");
		        postOrder(root);
		        break;
		}
		System.out.println();
	}
	private void preOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			System.out.println(localRoot.iData+" ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	private void inOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.leftChild);
			System.out.println(localRoot.iData+" ");
			inOrder(localRoot.rightChild);
		}
	}
	private void postOrder(Node localRoot)
	{
		if(localRoot!=null)
		{
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.println(localRoot.iData+" ");
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void displayTree() {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("...............................");
		while(isRowEmpty==false)
		{
			Stack localStack = new Stack();
			isRowEmpty = true;
			
			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');
			
			while(globalStack.isEmpty()==false)
			{
				Node temp = (Node)globalStack.pop();
				if(temp!=null)
				{
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if(temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("..");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks; j++)
					System.out.println(' ');
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push(localStack.pop());
		} // end while isRowEmpty is false
		System.out.println(".........................................");
	} // end displayTree()
} // end class Treee

public class TreeApp {
	public static void main(String[] args) {
		int value;
		Tree theTree = new Tree(); // make a tree

		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.7);
		theTree.insert(12, 1.5);
		theTree.insert(37, 1.2);
		theTree.insert(43, 1.7);
		theTree.insert(30, 1.5);
		theTree.insert(33, 1.2);
		theTree.insert(87, 1.7);
		theTree.insert(93, 1.5);
		theTree.insert(97, 1.5);
		
		while(true)
		{
			System.out.println("Enter first letter of show, ");
			System.out.println("insert, find, delete, or traverse: ");
			@SuppressWarnings("resource")
			Scanner stdin = new Scanner(System.in);
			char choice = stdin.next().charAt(0);
			switch(choice)
			{
			case 's':
				theTree.displayTree();
				break;
			case 'i':
				System.out.println("Enter value to insert: ");
				value = stdin.nextInt();
				theTree.insert(value, value+0.9);
				break;
			case 'f':
				System.out.println("Enter value to find: ");
				value = stdin.nextInt();
				Node found = theTree.find(value);
				if(found != null)
				{
					System.out.print("Found: ");
					found.displayNode();
					System.out.print("\n");
				}
				else
					System.out.println("Could not find ");
					System.out.println(value+'\n');
				break;
			case 'd':
				System.out.print("Enter value to delete: ");
				value = stdin.nextInt();
				boolean didDelete = theTree.delete(value);
				if(didDelete)
					System.out.println("Could not delete");
				else
					System.out.print("Could not delete ");
					System.out.print(value + '\n');
				break;
			case 't':
				System.out.println("Enter type 1, 2 or 3: ");
				value = stdin.nextInt();
				theTree.traverse(value);
				break;
			default:
				System.out.println("Invalid entry\n");
			} // end switch
		}  // end while
	} // end main() 
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
}
