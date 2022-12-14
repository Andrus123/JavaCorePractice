package multithreaded;

// Use synchronize to control access.

class SumArray {
	private int sum;

	synchronized int sumArray(int[] nums) {
		sum = 0; // reset sum

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			System.out.println("Running total for " + Thread.currentThread().getName() + " is " + sum);
			try {
				Thread.sleep(10); // allow task-switch
			} catch (InterruptedException exc) {
				System.out.println("Thread interrupted.");
			}
		}
		return sum;
	}
}

class MyThread6 implements Runnable {
	Thread thrd;
	static SumArray sa = new SumArray();
	int[] a;
	int answer;
	
	// Construct a new thread.
	MyThread6(String name, int[] nums) {
		thrd = new Thread(this, name);
		a = nums;
	}
	
	// A factory method that creates and starts a thread.
	public static MyThread6 createAndStart(String name, int[] nums) {
		MyThread6 myThrd = new MyThread6(name, nums);
		
		myThrd.thrd.start(); // start the thread
		return myThrd;
	}
	
	// Entry point of thread.
	public void run() {
		@SuppressWarnings("unused")
		int sum;
		
		System.out.println(thrd.getName() + " starting.");
		
		answer = sa.sumArray(a);
		System.out.println("Sum for " + thrd.getName() + " is " + answer);
		
		System.out.println(thrd.getName() + " terminating.");
	}
}

public class Sync {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		
		MyThread6 mt1 = MyThread6.createAndStart("Child #1", a);
		MyThread6 mt2 = MyThread6.createAndStart("Child #2", a);
		
		try {
			mt1.thrd.join();
			mt2.thrd.join();
		} catch (InterruptedException exc) {
			System.out.println("Main thread interrupted.");
		}
	}
}
