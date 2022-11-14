package multithreaded;

// Suspending, resuming, and stopping a thread.

class MyThread9 implements Runnable {
	Thread thrd;
	boolean suspended;
	boolean stopped;
	
	MyThread9(String name) {
		thrd = new Thread(this, name);
		suspended = false;
		stopped = false;
	}
	
	// A factory method that creates and starts a thread.
	public static MyThread9 createAndStart(String name) {
		MyThread9 myThrd = new MyThread9(name);
		
		myThrd.thrd.start(); // start the thread
		return myThrd;
	}
	
	// Entry point of thread.
	public void run() {
		System.out.println(thrd.getName() + " starting.");
		try {
			for (int i = 1; i < 1000; i++) {
				System.out.print(i + " ");
				if ((i%10) == 0) {
					System.out.println();
					Thread.sleep(250);
				}
				// Use syncronized block to check suspended and stopped
				synchronized (this) {
					while (suspended) {
						wait();
					}
					if(stopped) break;
				}
			}
		} catch (InterruptedException exc) {
			System.out.println(thrd.getName() + " interrupted.");
		}
		System.out.println(thrd.getName() + " exiting.");
	}
	
	// Stop the thread.
	synchronized void mystop() {
		stopped = true;
		
		// The following ensures that a suspended thread can be stopped
		suspended = false;
		notify();
	}
	
	// Suspend the thread
	synchronized void mysuspend() {
		suspended = false;
		notify();
	}
	
	// Resume the thread
	synchronized void myresume() {
		suspended = false;
		notify();
	}
}

public class Suspend {
	public static void main(String[] args) {
		MyThread9 mt1 = MyThread9.createAndStart("My Thread");
		
		try {
			Thread.sleep(1000); // let ob1 thread start executing
			
			mt1.mysuspend();
			System.out.println("Suspending thread.");
			Thread.sleep(1000);
			
			mt1.myresume();
			System.out.println("Resuming thread.");
			Thread.sleep(1000);
			
			mt1.mysuspend();
			System.out.println("Suspending thread.");
			Thread.sleep(1000);
			
			mt1.myresume();
			System.out.println("Resuming thread");
			Thread.sleep(1000);
			
			mt1.mysuspend();
			System.out.println("Stopping thread.");
			mt1.mystop();
			
		} catch (InterruptedException exc) {
			System.out.println("Main thread Interrupted");
		}
		
		// wait for thread to finish
		try {
			mt1.thrd.join();
		} catch (InterruptedException exc) {
			System.out.println("Main thread Interrupted");
		}
		
		System.out.println("Main thread exiting.");
	}
}
