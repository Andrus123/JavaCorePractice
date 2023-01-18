package StacksandQueues;

// stack used to reverse a string

import java.io.*; // for I/O
import java.lang.String;

class StackY {
	private int maxSize;
	private char[] stackArray;
	private int top;

	public StackY(int max) {
		maxSize = max;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void push(char j) { // put item on top of stack
		stackArray[++top] = j;
	}

	public char pop() { // take item from top of stack
		return stackArray[top--];
	}

	public char peek() { // peek at top of stack
		return stackArray[top];
	}

	public boolean isEmpty() { // true if stack is empty
		return (top == -1);
	}
}

class Reverser {
	private String input;
	private String output;

	public Reverser(String in) { // constructor
		input = in;
	}

	public String doRev() { // reverse the string
		int stackSize = input.length(); // get max stack size
		StackY theStack = new StackY(stackSize); // make stack

		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			theStack.push(ch);
		}
		output = "";
		while (!theStack.isEmpty()) {
			char ch = theStack.pop();
			output = output + ch;
		}
		return output;
	}
}

public class reverseApp {

	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {
			System.out.println("Enter a string: ");
			System.out.flush();
			input = getString(); // read a string from kbd
			if (input.equals("")) // quit if [Enter]
				break;

			Reverser theReverser = new Reverser(input);
			output = theReverser.doRev();
			System.out.println("Reversed: " + output);
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
