package Interfaces;

// Demostrate interface references
class ByTwos2 implements Series {
	int start;
	int val;

	ByTwos2() {
		start = 0;
		val = 0;
	}

	public int getNext() {
		val += 2;
		return val;
	}

	public void reset() {
		val = start;
	}

	public void setStart(int x) {
		start = x;
		val = x;
	}
}

class ByThrees2 implements Series {
	int start;
	int val;

	ByThrees2() {
		start = 0;
		val = 0;
	}

	public int getNext() {
		val += 3;
		return val;
	}

	public void reset() {
		val = start;
	}

	public void setStart(int x) {
		start = x;
		val = x;
	}
}

class SeriesDemo2 {
	public static void main(String[] args) {
		ByTwos2 twoOb = new ByTwos2();
		ByThrees2 threeOb = new ByThrees2();
		Series ob;

		for (int i = 0; i < 5; i++) {
			ob = twoOb;
			System.out.println("Next ByTwos value is " + ob.getNext());

			ob = threeOb;
			System.out.println("Next ByThrees value is " + ob.getNext());
		}
	}
}
