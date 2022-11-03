package usingIO;

import java.io.FileInputStream;
import java.io.IOException;

public class ShowFilewitharm {

	public static void main(String[] args) {
		int i;

		// First, make sure that a file name has been specified.
		if (args.length != 1) {
			System.out.println("Usage: ShowFile filename");
			return;
		}

		// The following code uses try-with-resources to open a file
		// and then automatically close it when the try block is left.
		try (FileInputStream fin = new FileInputStream(args[0])) {

			do {
				i = fin.read();
				if (i != -1)
					System.out.println((char) i);
			} while (i != -1);
		} catch (IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
	}

}
