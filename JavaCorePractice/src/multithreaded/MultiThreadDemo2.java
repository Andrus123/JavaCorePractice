package multithreaded;

// Create multiple threads.
class NewThread3 implements Runnable {
	String name; // name of thread
	Thread t;
	
	NewThread3(String threadname) {
		name = threadname;
		t = new Thread(this, name);
		System.out.println("New thread: " + t);
	}
	
	// This is the entry point for thread
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println(name + ": "+i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(name + "Interrupted");
		}
		System.out.println(name + " exiting.");
	}
}

public class MultiThreadDemo2 {
	public static void main(String[] args) {
		NewThread3 nt1 = new NewThread3("One");
		NewThread3 nt2 = new NewThread3("Two");
		NewThread3 nt3 = new NewThread3("Three");
		
		// Start the threads.
		nt1.t.start();
		nt2.t.start();
		nt3.t.start();
		
		try {
			// wait for other threads to end
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		System.out.println("Main thread exiting.");
	}
}
