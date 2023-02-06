package multithreaded;

// Create a second thread by extending Thread
class NewThread2 extends Thread {
	NewThread2() {
		// Create a new, second thread
		super("Demo Thread");
		System.out.println("Child thread: " + this);
	}
	
	// This is the entry point for the second thread.
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Child Thread: "+ i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Child interrupted");
		}
		System.out.println("Exiting child thread.");
	}
}

public class ExtendThread2 {
	public static void main(String[] args) {
		NewThread2 nt = new NewThread2();	// Create a new thread
		
		nt.start();
		
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Main Thread: "+ i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted");
		}
		System.out.println("Main Thread exiting.");
	}

}
