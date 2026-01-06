package com.example.demo.phase2.make.mapping_tree;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;


import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class WriteMappingTreeExcel {

	// private static WritableCellFormat timesBoldUnderline;
	private static WritableCellFormat dataCellFormat;
	private static WritableCellFormat title0CellFormat;
	private static WritableCellFormat titleCellFormat;

	public static String inputFile;
	public static WritableWorkbook workbook = null;

	public void setOutputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public void createDataSetExcel() {
		try {
			File file = new File(inputFile);
			WorkbookSettings wbSettings = new WorkbookSettings();

			wbSettings.setLocale(new Locale("en", "EN"));

			workbook = Workbook.createWorkbook(file, wbSettings);
			workbook.createSheet("Mapping Tree", 0);
			// workbook.createSheet("DS", 1);
			// workbook.createSheet("DENs", 2);
			// workbook.createSheet("CLS", 3);

			// ----------------------------------------------
			WritableFont titleFont = new WritableFont(WritableFont.ARIAL, 12);
			// Define the cell format
			titleCellFormat = new WritableCellFormat(titleFont);
			titleCellFormat.setAlignment(Alignment.CENTRE);
			titleCellFormat.setBackground(Colour.YELLOW);
			titleCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			// titleCellFormat.setShrinkToFit(true);
			// titleCellFormat.setWrap(true);
			// ----------------------------------------------
			WritableFont title0Font = new WritableFont(WritableFont.ARIAL, 12);
			// Define the cell format
			title0CellFormat = new WritableCellFormat(title0Font);
			title0CellFormat.setAlignment(Alignment.LEFT);
			title0CellFormat.setBackground(Colour.WHITE);

			title0CellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			// title0CellFormat.setShrinkToFit(true);
			// title0CellFormat.setWrap(true);
			// ----------------------------------------------
			WritableFont myCellFont = new WritableFont(WritableFont.ARIAL, 10);
			// Define the cell format
			dataCellFormat = new WritableCellFormat(myCellFont);
			dataCellFormat.setVerticalAlignment(VerticalAlignment.TOP);
			// dataCellFormat.setShrinkToFit(true);
			// times.setBackground(Colour.YELLOW);
			// Lets automatically wrap the cells
			// dataCellFormat.setWrap(true);
			// ----------------------------------------------
			// Create create a bold font with unterlines
			// WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
			// UnderlineStyle.SINGLE);
			// timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
			//
			// // Lets automatically wrap the cells
			// timesBoldUnderline.setWrap(true);
			// ----------------------------------------------
			// CellView cv = new CellView();
			// cv.setFormat(dataCellFormat);
			// cv.setFormat(timesBoldUnderline);
			// cv.setAutosize(true);
			// ----------------------------------------------
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeDataSetExcel() {
		try {
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ************************************************************************************************
	// Class

	public void writeFileTitles(String msgName) {
		WritableSheet sheet = workbook.getSheet(0);
		sheet.getSettings().setDefaultColumnWidth(45);

		try {
			sheet.addCell(new Label(0, 0, msgName, title0CellFormat));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		int row = 1;
		int col = 0;
		try {
			sheet.setColumnView(col, 10);
			sheet.addCell(new Label(col++, row, "海關欄位註記", titleCellFormat));
			sheet.setColumnView(col, 6);
			sheet.addCell(new Label(col++, row, "序號", titleCellFormat));
			sheet.setColumnView(col, 8);
			sheet.addCell(new Label(col++, row, "WCOID", titleCellFormat));
			sheet.setColumnView(col, 8);
			sheet.addCell(new Label(col++, row, "Class ID", titleCellFormat));
			sheet.addCell(new Label(col++, row, "群組/資料元或組合資料元名稱", titleCellFormat));
			sheet.setColumnView(col, 5);
			sheet.addCell(new Label(col++, row, "sn", titleCellFormat));
			sheet.setColumnView(col, 20);
			sheet.addCell(new Label(col++, row, "中文名稱", titleCellFormat));
			sheet.setColumnView(col, 20);
			sheet.addCell(new Label(col++, row, "英文名稱", titleCellFormat));
			sheet.setColumnView(col, 8);
			sheet.addCell(new Label(col++, row, "迴圈", titleCellFormat));
			sheet.setColumnView(col, 5);
			sheet.addCell(new Label(col++, row, "M/C", titleCellFormat));
			// sheet.setColumnView(col, 5);
			// sheet.addCell(new Label(col++, row, "M/C", titleCellFormat));
			sheet.setColumnView(col, 5);
			sheet.addCell(new Label(col++, row, "Data Type", titleCellFormat));
			sheet.setColumnView(col, 8);
			sheet.addCell(new Label(col++, row, "長度", titleCellFormat));
			sheet.setColumnView(col, 5);
			sheet.addCell(new Label(col++, row, "Code Remark", titleCellFormat));
			sheet.addCell(new Label(col++, row, "中文說明", titleCellFormat));
			sheet.addCell(new Label(col++, row, "英文說明", titleCellFormat));

		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeToFile(int n, MappingTreeRow o) {
		WritableSheet sheet = workbook.getSheet(0);

		int row = n + 2;
		int col = 0;
		try {
			sheet.addCell(new Label(col++, row, "-", dataCellFormat));

			// sheet.addCell(new Label(col++, row, "-", dataCellFormat));
			// sheet.addCell(new Label(col++, row, "-", dataCellFormat));

			if (o.sn.trim().startsWith("999")) {
				o.sn = "-";
			}
			sheet.addCell(new Label(col++, row, o.sn, dataCellFormat));

			if (!o.propid.trim().equals(""))
				sheet.addCell(new Label(col++, row, o.propid, dataCellFormat));
			else
				col++;

			if (!o.classid.trim().equals(""))
				sheet.addCell(new Label(col++, row, o.classid, dataCellFormat));
			else
				col++;

			String tree = o.tree;
			if (tree.startsWith(" ")) {
				tree = tree.substring(1);
			}
			// tree = tree.replace("_", "____");
			// tree = tree.replace("　　", "           ");
			// tree = tree.replace("tw____", "tw_");
			//
			// // System.out.println(tree);
			//
			// String sp = "           ";
			// // String sp = "           ";
			// if (tree.contains(sp + sp + sp + sp + sp + sp + sp + sp + sp + sp)) {
			// tree = tree.replace(sp + sp + sp + sp + sp + sp + sp + sp + sp + sp,//
			// sp + sp + sp + sp + sp + sp + sp + sp + sp + sp + "         ");
			// } else if (tree.contains(sp + sp + sp + sp + sp + sp + sp + sp + sp)) {
			// tree = tree.replace(sp + sp + sp + sp + sp + sp + sp + sp + sp,//
			// sp + sp + sp + sp + sp + sp + sp + sp + sp + "        ");
			// } else if (tree.contains(sp + sp + sp + sp + sp + sp + sp + sp)) {
			// tree = tree.replace(sp + sp + sp + sp + sp + sp + sp + sp,//
			// sp + sp + sp + sp + sp + sp + sp + sp + "       ");
			// } else if (tree.contains(sp + sp + sp + sp + sp + sp + sp)) {
			// tree = tree.replace(sp + sp + sp + sp + sp + sp + sp,//
			// sp + sp + sp + sp + sp + sp + sp + "      ");
			// } else if (tree.contains(sp + sp + sp + sp + sp + sp)) {
			// tree = tree.replace(sp + sp + sp + sp + sp + sp,//
			// sp + sp + sp + sp + sp + sp + "     ");
			// } else if (tree.contains(sp + sp + sp + sp + sp)) {
			// tree = tree.replace(sp + sp + sp + sp + sp,//
			// sp + sp + sp + sp + sp + "    ");
			// } else if (tree.contains(sp + sp + sp + sp)) {
			// tree = tree.replace(sp + sp + sp + sp,//
			// sp + sp + sp + sp + "   ");
			// } else if (tree.contains(sp + sp + sp)) {
			// tree = tree.replace(sp + sp + sp,//
			// sp + sp + sp + "  ");
			// } else if (tree.contains(sp + sp)) {
			// // System.out.println("2");
			// tree = tree.replace(sp + sp,//
			// sp + sp + " ");
			// }

			if (!tree.trim().equals(""))
				sheet.addCell(new Label(col++, row, tree, dataCellFormat));
			else
				col++;

			// if (!o.propid.trim().equals(""))
			if (o.sn.trim().startsWith("999")) {
				o.sn = "-";
			}
			sheet.addCell(new Label(col++, row, o.sn, dataCellFormat));
			// else
			// sheet.addCell(new Label(col++, row, "-", dataCellFormat));

			if (!o.chnName.trim().equals(""))
				sheet.addCell(new Label(col++, row, o.chnName, dataCellFormat));
			else
				col++;

			if (!o.enName.trim().equals(""))
				sheet.addCell(new Label(col++, row, o.enName, dataCellFormat));
			else
				col++;

			if (!o.occur.trim().equals(""))
				sheet.addCell(new Label(col++, row, o.occur, dataCellFormat));
			else
				col++;

			if (!o.mc.trim().equals(""))
				sheet.addCell(new Label(col++, row, o.mc, dataCellFormat));
			// sheet.addCell(new Label(col++, row, "-", dataCellFormat));
			else
				col++;

			sheet.addCell(new Label(col++, row, "-", dataCellFormat));// representation

			if (!o.format.trim().equals(""))
				sheet.addCell(new Label(col++, row, o.format.trim(), dataCellFormat));
			else
				col++;

			sheet.addCell(new Label(col++, row, "-", dataCellFormat));// remark

			if (!o.chnDef.trim().equals(""))
				sheet.addCell(new Label(col++, row, o.chnDef, dataCellFormat));
			else
				col++;

			if (!o.enDef.trim().equals(""))
				sheet.addCell(new Label(col++, row, o.enDef, dataCellFormat));
			else
				col++;

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// *********************************************************************************
	// samples bellow

	// public void write() throws IOException, WriteException {
	// createLabel(workbook.getSheet(1));
	// createContent(workbook.getSheet(2));
	// }
	//
	// private void createLabel(WritableSheet sheet) throws WriteException {
	// // Lets create a times font
	// WritableFont times10pt = new WritableFont(WritableFont.ARIAL, 10);
	// // Define the cell format
	// dataCellFormat = new WritableCellFormat(times10pt);
	// // Lets automatically wrap the cells
	// dataCellFormat.setWrap(true);
	// // ----------------------------------------------
	// // Create create a bold font with unterlines
	// WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
	// UnderlineStyle.SINGLE);
	// timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
	// // Lets automatically wrap the cells
	// timesBoldUnderline.setWrap(true);
	// // ----------------------------------------------
	// CellView cv = new CellView();
	// cv.setFormat(dataCellFormat);
	// cv.setFormat(timesBoldUnderline);
	// cv.setAutosize(true);
	//
	// // Write a few headers
	// addCaption(sheet, 0, 0, "Header 1\n說明mmm");
	// addCaption(sheet, 1, 0, "This is \nanother header");
	// }
	//
	// private void addCaption(WritableSheet sheet, int column, int row, String s) throws RowsExceededException,
	// WriteException {
	// // Label label;
	// Label label = new Label(column, row, s, timesBoldUnderline);
	// sheet.addCell(label);
	// }
	//
	// private void createContent(WritableSheet sheet) throws WriteException, RowsExceededException {
	// // Write a few number
	// for (int i = 1; i < 10; i++) {
	// // First column
	// addNumber(sheet, 0, i, i + 10);
	// // Second column
	// addNumber(sheet, 1, i, i * i);
	// }
	// // Lets calculate the sum of it
	// // StringBuffer buf = new StringBuffer();
	// // buf.append("SUM(A2:A10)");
	// Formula f = new Formula(0, 10, "SUM(A2:A10)");
	// sheet.addCell(f);
	//
	// // buf = new StringBuffer();
	// // buf.append("SUM(B2:B10)");
	// f = new Formula(1, 10, "SUM(B2:B10)");
	// sheet.addCell(f);
	//
	// // Now a bit of text
	// for (int i = 12; i < 20; i++) {
	// // First column
	// addLabel(sheet, 0, i, "Boring text " + i);
	// // Second column
	// addLabel(sheet, 1, i, "Another text");
	// }
	// }
	//
	// private void addNumber(WritableSheet sheet, int column, int row, Integer integer) throws WriteException,
	// RowsExceededException {
	// // Number number;
	// Number number = new Number(column, row, integer, dataCellFormat);
	// sheet.addCell(number);
	// }
	//
	// private void addLabel(WritableSheet sheet, int column, int row, String s) throws WriteException,
	// RowsExceededException {
	// // Label label;
	// Label label = new Label(column, row, s, dataCellFormat);
	// sheet.addCell(label);
	// }

	public static void main(String[] args) throws WriteException, IOException {
		// WriteExcel test = new WriteExcel();
		// test.setOutputFile("d:/temp/lars.xls");
		// test.createDataSetExcel();
		// test.write();
		// test.closeDataSetExcel();
		// System.out.println("Please check the result file under c:/temp/lars.xls ");

		String tree = "|           |____ tw_Copy";
		String sp = "           ";
		if (tree.contains(sp)) {
			System.out.println("1");
		} else {
			System.out.println("no");
		}

	}
}
