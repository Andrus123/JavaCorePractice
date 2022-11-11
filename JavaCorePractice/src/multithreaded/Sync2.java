package multithreaded;

// Use a synchronized block to control access to SumArray.
class SumArray2 {
	private int sum;

	int sumArray(int[] nums) {
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

class MyThread7 implements Runnable {
	Thread thrd;
	static SumArray sa = new SumArray();
	int[] a;
	int answer;

	// Construct a new thread.
	MyThread7(String name, int[] nums) {
		thrd = new Thread(this, name);
		a = nums;
	}

	// A factory method that creates and starts a thread.
	public static MyThread7 createAndStart(String name, int[] nums) {
		MyThread7 myThrd = new MyThread7(name, nums);

		myThrd.thrd.start();
		return myThrd;
	}

	// Entry point of thread.
	public void run() {
		@SuppressWarnings("unused")
		int sum;

		System.out.println(thrd.getName() + " starting.");

		// synchronized calls to sumArray()
		synchronized (sa) {
			answer = sa.sumArray(a);
		}
		System.out.println("Sum for " + thrd.getName() + " is " + answer);

		System.out.println(thrd.getName() + " terminating.");
	}
}

public class Sync2 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		
		MyThread7 mt1 = MyThread7.createAndStart("Child #1", a);
		MyThread7 mt2 = MyThread7.createAndStart("Child #1", a);
		
		try {
			mt1.thrd.join();
			mt2.thrd.join();
		} catch (InterruptedException exc) {
			System.out.println("Main thread interrupted.");
		}
	}
}
