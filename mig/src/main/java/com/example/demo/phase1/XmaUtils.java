package com.example.demo.phase1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.example.demo.TWDENS_DAO;

public class XmaUtils {

	public boolean isSimple(TWDENS_DAO densds) {
		boolean isSimpleType = densds.representationTerm.endsWith("Date") //
				|| densds.representationTerm.endsWith("Time")//
				|| densds.representationTerm.endsWith("Date Time")//
				// || densds.representationTerm.endsWith("Text")//
				|| densds.representationTerm.endsWith("Indicator")//
				|| densds.representationTerm.endsWith("Numeric") //
				|| densds.representationTerm.endsWith("Rate") //
				|| densds.representationTerm.endsWith("Percent") //
		// || (densds.representationTerm.endsWith("Code") && densds.codeList.equals(""))//
		;

		return isSimpleType;
	}

	public boolean canRestrict(TWDENS_DAO densds) {
		
		
		
		
		boolean f = false//
				// densds.representationTerm.endsWith("Date") //
				// || densds.representationTerm.endsWith("Time")//
				|| densds.representationTerm.endsWith("Text")//
				|| densds.representationTerm.endsWith("Code")//
				|| densds.representationTerm.endsWith("Measure")//
				|| densds.representationTerm.endsWith("Identifier")//
				|| densds.representationTerm.endsWith("Quantity")//
				|| densds.representationTerm.endsWith("Amount")//
				|| densds.representationTerm.endsWith("Numeric") //
				|| densds.representationTerm.endsWith("Rate") //
				|| densds.representationTerm.endsWith("Percent") //
		// || (densds.representationTerm.endsWith("Code") && densds.codeList.equals(""))//
		;

		return f;
	}

	public String getBase(String representationTerm) {
		String baseType = "NoType";
		if (representationTerm.equals("Identifier")) {
			baseType = "udt:"+"IDType";
		} else if (representationTerm.equals("Date Time")) {
			baseType = "qdt:"+"DateMandatoryDateTimeType";
		} else {
			baseType ="udt:"+ representationTerm + "Type";
		}

		return baseType;
	}
	
//	public String getBaseType(String representationTerm) {
//		String baseType = "NoType";
//		if (representationTerm.equals("Identifier")) {
//			baseType = "IDType";
//		} else if (representationTerm.equals("Date Time")) {
//			baseType = "DateTimeType";
//		} else {
//			baseType = representationTerm + "Type";
//		}
//
//		return baseType;
//	}

	static BufferedWriter getWriter(String totalPath, String msgName) {
		// String line = "";
		// File file = new File(file_path);
		// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));

		makeProdFolder(totalPath);

		BufferedWriter out = null;
		try {
			File wfile = new File(totalPath + msgName);
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(wfile), "big5"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return out;
	}

	static PrintWriter getOut(String totalPath, String msgName) {
		makeProdFolder(totalPath);

		PrintWriter out = null;
		try {
			FileWriter outFile = new FileWriter(totalPath + msgName);
			out = new PrintWriter(outFile);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return out;
	}

	static void makeProdFolder(String fldr) {
		boolean success = (new File(fldr)).mkdirs();
		// if (success) {
		// System.out.println("Directories: " + fldr + " created");
		// } else {
		// throw new RuntimeException("Directories: " + fldr + " creation Failed!");
		// }
	}
}
