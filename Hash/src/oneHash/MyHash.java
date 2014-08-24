package oneHash;

import java.io.*;

public class MyHash {

	public static void main(String[] args) throws Exception {
		FileInputStream file = null;

		HashDescription gather = new HashDescription();
		try {
			file = new FileInputStream("C:\\MyDir\\4.txt");

			int i = 0;
			do {
				i = file.read();
				if (i != -1)
					System.out.print((char) i);
				gather.searchsym((char) i);
				gather.searchword((char) i, i);
				gather.searchstr((char) i, i, "oeh");
			} while (i != -1);
		} catch (FileNotFoundException exc) {
			System.out.println("File not found");
			return;

		} catch (IOException exc) {
			System.out.println("Error reading file");
		} finally {
			try {
				System.out.println("fldkfja;;");
				if (file != null) file.close();
			} catch (IOException exc) {
				System.out.println("Error closing file");
			}
		}
		System.out.println();
		gather.sort(5);
		System.out.println();
		gather.resultsym();

	}
}
