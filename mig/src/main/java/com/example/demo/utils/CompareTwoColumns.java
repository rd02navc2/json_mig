package com.example.demo.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.example.demo.TWDENS_DAO;
import com.example.demo.XmaDB;

/*
 * 
 * 比較樹狀圖
 */

public class CompareTwoColumns {

	private String inputFile;

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	ArrayList ar1 = new ArrayList();
	ArrayList ar2 = new ArrayList();

	public void read() throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);

			Sheet sheet0 = w.getSheet(0);

			for (int row = 0; row < sheet0.getRows(); row++) {

				for (int col = 0; col < sheet0.getColumns(); col++) {

					Cell cell = sheet0.getCell(col, row);
					CellType type = cell.getType();

					String x = "" + cell.getContents();

					// x = x.trim();
					// System.out.println(col+"-->"+x);
					// System.out.print("\t");

					if (col == 10) {
						x = x.replace("           ", "　　");
						ar1.add(x);
					} else if (col == 11) {
						ar2.add(x);
					}
				}
				// System.out.println("***************************************************");

			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
	}

	public void read2() throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);

			Sheet sheet0 = w.getSheet(0);
			Sheet sheet1 = w.getSheet(1);

			for (int row = 0; row < sheet0.getRows(); row++) {

				for (int col = 0; col < 6; col++) {

					System.out.println(row+","+col);
					// -----------------------------------------------
					Cell cell0 = sheet0.getCell(col, row);
					// CellType type = cell0.getType();
					String x0 =  cell0.getContents();

					// -----------------------------------------------
					Cell cell1 = sheet1.getCell(col, row);
					// CellType type = cell0.getType();
					
					String x1 =  cell1.getContents();

					
					
					// x = x.trim();
					// System.out.println(col+"-->"+x);
					// System.out.print("\t");

					// -----------------------------------------------
					if (col == 4) {
						x1 = x1.replace("           ", "　　");
					}
					
					// -----------------------------------------------
					if (!x0.equals(x1)) {
						System.err.println("("+(row+1)+","+(col+1)+")" + "--->" + x0 + "<--->" + x1);
					}

					// if (col == 10) {
					// x0 = x0.replace("           ", "　　");
					// ar1.add(x0);
					// } else if (col == 11) {
					// ar2.add(x0);
					// }
				}
				// System.out.println("***************************************************");

			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
	}

	void compare() {

		System.out.println(ar1.size() + "," + ar2.size());

		for (int i = 0; i < ar1.size(); i++) {

			System.out.println(i + "--->" + ar1.get(i) + "," + ar2.get(i));
			String a = (String) ar1.get(i);
			String b = (String) ar2.get(i);
			if (!a.equals(b)) {
				System.err.println(i + "--->" + ar1.get(i) + "," + ar2.get(i));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		CompareTwoColumns test = new CompareTwoColumns();
		test.setInputFile("d:/harmo_prod/mmmm.xls");
		test.read2();
		test.compare();

	}

}