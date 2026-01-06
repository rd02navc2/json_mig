package com.example.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public final class ReadWriteTextFileWithEncoding {

	/** Requires two arguments - the file name, and the encoding to use. */
/*	public static void main(String... aArgs) throws IOException {
		String fileName = "D:/harmo_prod/訊息表.txt";
		String encoding = "big5";
		ReadWriteTextFileWithEncoding test = new ReadWriteTextFileWithEncoding(fileName, encoding);
		// test.write();
		test.read();
	}
*/
	/** Constructor. */
	public ReadWriteTextFileWithEncoding(String aFileName, String aEncoding) {
		fEncoding = aEncoding;
		fFileName = aFileName;
	}

	// /** Write fixed content to the given file. */
	// void write() throws IOException {
	// log("Writing to file named " + fFileName + ". Encoding: " + fEncoding);
	// Writer out = new OutputStreamWriter(new FileOutputStream(fFileName), fEncoding);
	// try {
	// out.write(FIXED_TEXT);
	// } finally {
	// out.close();
	// }
	// }

	/** Read the contents of the given file. */
	String[][] read() throws IOException {
		log("Reading from file.");
		StringBuilder text = new StringBuilder();
		String NL = System.getProperty("line.separator");
		Scanner scanner = new Scanner(new FileInputStream(fFileName), fEncoding);
		try {

			ArrayList ar = new ArrayList();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.startsWith("#"))
					continue;
				String[] msg = line.split(",");
				String[] msgx = new String[msg.length];
				for (int k = 0; k < msg.length; k++) {
					msgx[k] = msg[k].trim();
				}
				ar.add(msgx);
				// text.append(scanner.nextLine() + NL);
			}

			String[][] msgs = new String[ar.size()][];
			for (int i = 0; i < ar.size(); i++) {
				msgs[i] = (String[]) ar.get(i);
			}

			// log("length="+msgs.length);

			return msgs;
		} finally {
			scanner.close();
		}
		// log("Text read in: " + text);
	}

	// PRIVATE
	private final String fFileName;
	private final String fEncoding;
	private final String FIXED_TEXT = "But soft! what code in yonder program breaks?";

	private void log(String aMessage) {
		System.out.println(aMessage);
	}
}
