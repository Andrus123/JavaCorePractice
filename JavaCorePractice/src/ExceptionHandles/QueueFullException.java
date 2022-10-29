package ExceptionHandles;

// An exception for queue-full errors
@SuppressWarnings("serial")
public class QueueFullException extends Exception {
	int size;

	QueueFullException(int s) {
		size = s;
	}

	public String toString() {
		return "\nQueue is full. Maximum size is " + size;
	}
}
