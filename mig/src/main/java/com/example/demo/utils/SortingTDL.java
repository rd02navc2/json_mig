package com.example.demo.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.example.demo.XmaDB;

/**
 * 排資料項目的序號
 *
 */
public class SortingTDL {

	private String inputFile;
	String msgName;

	public SortingTDL() {

	}

	public SortingTDL(String msgName) {
		this.msgName = msgName;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;

	}

	ArrayList ar = new ArrayList();

	public void read() throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			for (int row = 0; row < sheet.getRows(); row++) {
				int col = 0;
				Cell cell = sheet.getCell(col, row);
				CellType type = cell.getType();

				X o = new X();
				o.sn = ("000" + (row + 1)).substring(("000" + (row + 1)).length() - 3);
				o.name = cell.getContents();

				ar.add(o);
				// System.out.println();
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
	}

	class X {
		String sn = "";
		String name = "";
	}



	void writefile(String outputFile) {

		for (int i = 0; i < ar.size(); i++) {
			X o = (X) ar.get(i);
			System.out.println(o.sn + "--" + o.name);
			
			XmaDB db = new XmaDB();
//			XmaPool db = new XmaPool();
			db.updateTDLsn(o.sn,o.name);
		}
	}

	public static void main(String[] args) throws IOException {

		XmaDB db = new XmaDB();
		db.openConnection();

		SortingTDL test = new SortingTDL();
		test.setInputFile("d:/sn.xls");
		test.read();

	
		test.writefile("");

		System.out.println("sorting tdl done!\n");

		db.closeConnection();

	}

}