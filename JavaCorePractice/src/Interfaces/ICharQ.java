package Interfaces;

import ExceptionHandles.QueueEmptyException;
import ExceptionHandles.QueueFullException;

// A character queue interface.
public interface ICharQ {
	// Put a character into the queue.
	void put(char ch) throws QueueFullException;
	
	// Get a character from the queuew
	char get() throws QueueEmptyException;
}
