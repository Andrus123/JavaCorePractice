package StacksandQueues;

import java.io.IOException;

class PriorityQ {
	// array in sorted order, from max at 0 to min at size-1
	private int maxSize;
	private long[] queArray;
	private int nItems;

	public PriorityQ(int s) {
		maxSize = s;
		queArray = new long[maxSize];
		nItems = 0;
	}

	public void insert(long item) {
		int j;

		if (nItems == 0) // if no items
			queArray[nItems++] = item; // insert at 0
		else {
			for (j = nItems - 1; j >= 0; j--) // start at end,
			{
				if (item > queArray[j]) // if new item larger,
					queArray[j + 1] = queArray[j]; // shift upward
				else // if smaller,
					break; // done shifting
			}
			queArray[j + 1] = item; // insert it
			nItems++;
		} // end else (nItems>0)
	} // end insert()

	public long remove() {
		return queArray[--nItems];
	}

	public long peekMin() {
		return queArray[nItems - 1];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}
}

public class PriorityQApp {

	public static void main(String[] args) throws IOException {
		PriorityQ thePQ = new PriorityQ(5);
		thePQ.insert(30);
		thePQ.insert(50);
		thePQ.insert(10);
		thePQ.insert(40);
		thePQ.insert(20);
		
		while(!thePQ.isEmpty())
		{
			long item = thePQ.remove();
			System.out.println(item + " "); // 10,20,30,40,50
		}
		System.out.println("");
	}
}
