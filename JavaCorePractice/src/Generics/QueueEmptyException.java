package Generics;
// An exception for queue-empty errors.
@SuppressWarnings("serial")
public class QueueEmptyException extends Exception{
	
	public String toString() {
		return "\nQueue is empty";
	}
}
