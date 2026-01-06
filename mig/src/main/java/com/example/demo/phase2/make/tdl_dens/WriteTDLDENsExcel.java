package com.example.demo.phase2.make.tdl_dens;

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

import com.example.demo.phase2.make.data_item_set.WCOBaseClass;
import com.example.demo.phase2.make.data_item_set.WCOBaseDens;

public class WriteTDLDENsExcel {

	// private static WritableCellFormat timesBoldUnderline;
	private static WritableCellFormat dataCellFormat;
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
			// workbook.createSheet("HISTORY", 0);
			workbook.createSheet("DS", 0);
			workbook.createSheet("DENs", 1);
			workbook.createSheet("CLS", 2);
			workbook.createSheet("WCO_DENs", 3);
			workbook.createSheet("WCO_CLS", 4);

			// ----------------------------------------------
			WritableFont titleFont = new WritableFont(WritableFont.ARIAL, 12);
			// Define the cell format
			titleCellFormat = new WritableCellFormat(titleFont);
			titleCellFormat.setAlignment(Alignment.CENTRE);
			titleCellFormat.setBackground(Colour.YELLOW);
			titleCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			titleCellFormat.setShrinkToFit(true);
			titleCellFormat.setWrap(true);
			// ----------------------------------------------
			WritableFont myCellFont = new WritableFont(WritableFont.ARIAL, 10);
			// Define the cell format
			dataCellFormat = new WritableCellFormat(myCellFont);
			dataCellFormat.setVerticalAlignment(VerticalAlignment.TOP);
			dataCellFormat.setShrinkToFit(true);
			// times.setBackground(Colour.YELLOW);
			// Lets automatically wrap the cells
			dataCellFormat.setWrap(true);

		} catch (Exception e) {

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
	// Data Set

	public void writeDataSetToExcelFileTitle() {
		WritableSheet sheet = workbook.getSheet(0);

		sheet.getSettings().setDefaultColumnWidth(25);

		int row = 0;
		int col = 0;
		try {
			sheet.setColumnView(col, 5);
			sheet.addCell(new Label(col++, row, "SN", titleCellFormat));
			sheet.setColumnView(col, 20);
			sheet.addCell(new Label(col++, row, "中文名稱", titleCellFormat));
			sheet.setColumnView(col, 20);
			sheet.addCell(new Label(col++, row, "英文名稱", titleCellFormat));
			sheet.setColumnView(col, 25);
			sheet.addCell(new Label(col++, row, "中文定義", titleCellFormat));
			sheet.setColumnView(col, 25);
			sheet.addCell(new Label(col++, row, "英文定義", titleCellFormat));
			sheet.setColumnView(col, 15);
			sheet.addCell(new Label(col++, row, "屬性及\n長度", titleCellFormat));
			sheet.setColumnView(col, 35);
			sheet.addCell(new Label(col++, row, "使用訊息", titleCellFormat));
			sheet.setColumnView(col, 15);
			sheet.addCell(new Label(col++, row, "WCO ID /\nTW ID", titleCellFormat));
			sheet.setColumnView(col, 15);
			sheet.addCell(new Label(col++, row, "ClassID", titleCellFormat));
			sheet.setColumnView(col, 45);
			sheet.addCell(new Label(col++, row, "Dictionary Entry Name", titleCellFormat));
			sheet.setColumnView(col, 30);
			sheet.addCell(new Label(col++, row, "Object Class Term", titleCellFormat));
			sheet.setColumnView(col, 25);
			sheet.addCell(new Label(col++, row, "Property Term", titleCellFormat));
			sheet.setColumnView(col, 25);
			sheet.addCell(new Label(col++, row, "Representation Term", titleCellFormat));
			sheet.setColumnView(col, 50);
			sheet.addCell(new Label(col++, row, "Named Complex Type", titleCellFormat));
			sheet.setColumnView(col, 30);
			sheet.addCell(new Label(col++, row, "XML Tag Name", titleCellFormat));
			//
			sheet.addCell(new Label(col++, row, "CodeList", titleCellFormat));

			sheet.addCell(new Label(col++, row, "備註", titleCellFormat));
			
			sheet.addCell(new Label(col++, row, "sample", titleCellFormat));

		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeDataSetToExcelFile(int n, XmaDs myDs) {
		WritableSheet sheet = workbook.getSheet(0);
		int row = n + 1;
		int col = 0;

		String starflag = "";

		try {
			HashSet set = new HashSet();

			String TWIDStr = myDs.getTWIDStr();
			String[] wids = TWIDStr.split("---");
			for (int k = 0; k < wids.length; k++) {
				String wid = wids[k];

				if (wid.endsWith("*"))
					starflag = "*";

				if (wid.endsWith("+") || wid.endsWith("#") || wid.endsWith("*"))
					wid = wid.substring(0, wid.length() - 1);

				set.add(wid);
			}
			// -----------------------------------------------------
			String idd = "";
			Iterator it = set.iterator();
			while (it.hasNext()) {
				idd = idd + (String) it.next() + "---";
			}
			idd = idd.substring(0, idd.length() - "---".length());
			// -----------------------------------------------------
			sheet.addCell(new Label(col++, row, myDs.sn, dataCellFormat));
			sheet.addCell(new Label(col++, row, myDs.chName, dataCellFormat));
			// sheet.addCell(new Label(col++, row, myDs.getType(), times));//used by custom or control
			sheet.addCell(new Label(col++, row, myDs.enName, dataCellFormat));

			sheet.addCell(new Label(col++, row, myDs.chDef, dataCellFormat));
			sheet.addCell(new Label(col++, row, myDs.enDef, dataCellFormat));
			sheet.addCell(new Label(col++, row, myDs.format, dataCellFormat));

			sheet.addCell(new Label(col++, row, myDs.getMsgsStr(), dataCellFormat));

			sheet.addCell(new Label(col++, row, idd.replace("---", "\n"), dataCellFormat));

			// sheet.addCell(new Label(col++, row, myDs.getTWIDStr().replace("---", "\n"), times));

			sheet.addCell(new Label(col++, row, myDs.getClassidsStr().replace("---", "\n"), dataCellFormat));
			sheet.addCell(new Label(col++, row, myDs.getDENsStr().replace("---", "\n"), dataCellFormat));
			sheet.addCell(new Label(col++, row, myDs.getObjectClassTermStr().replace("---", "\n"), dataCellFormat));
			sheet.addCell(new Label(col++, row, myDs.getPropertiesStr().replace("---", "\n"), dataCellFormat));
			sheet.addCell(new Label(col++, row, myDs.getRepreStr().replace("---", "\n"), dataCellFormat));
			sheet.addCell(new Label(col++, row, myDs.getNamedComplexTypeStr().replace("---", "\n"), dataCellFormat));
			sheet.addCell(new Label(col++, row, myDs.getXmlTagNameStr().replace("---", "\n"), dataCellFormat));

			//
			sheet.addCell(new Label(col++, row, myDs.codeRemark.replace("---", "\n"), dataCellFormat));

			sheet.addCell(new Label(col++, row, starflag, dataCellFormat));

			sheet.addCell(new Label(col++, row, myDs.sample.replace("---", "\n"), dataCellFormat));
			
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// ************************************************************************************************
	// DENs

	public void writeDENsToFileTitles() {
		WritableSheet sheet = workbook.getSheet(1);
		sheet.getSettings().setDefaultColumnWidth(35);
		int row = 0;
		int col = 0;
		try {
			sheet.addCell(new Label(col++, row, "中文名稱", titleCellFormat));
			sheet.addCell(new Label(col++, row, "TWID", titleCellFormat));
			sheet.addCell(new Label(col++, row, "Name", titleCellFormat));
			sheet.addCell(new Label(col++, row, "Definition", titleCellFormat));
			sheet.addCell(new Label(col++, row, "ClassID", titleCellFormat));
			sheet.addCell(new Label(col++, row, "Dictionary Entry Name", titleCellFormat));
			sheet.addCell(new Label(col++, row, "Object Class Term", titleCellFormat));

			sheet.addCell(new Label(col++, row, "Property Term", titleCellFormat));
			sheet.addCell(new Label(col++, row, "Representation Term", titleCellFormat));
			sheet.addCell(new Label(col++, row, "Named Complex Type", titleCellFormat));
			sheet.addCell(new Label(col++, row, "XML Tag Name", titleCellFormat));
			// sheet.addCell(new Label(col++, row, "Object Class Term", titles));

		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeDENsToFile(int n, XmaDen myDen) {
		WritableSheet sheet = workbook.getSheet(1);
		int row = n + 1;
		int col = 0;
		try {
			// sheet.addCell(new Label(col++, row, myDen.chName, dataCellFormat));
			sheet.addCell(new Label(col++, row, myDen.getChNamesStr().replace("---", "\n"), dataCellFormat));

			sheet.addCell(new Label(col++, row, myDen.twid, dataCellFormat));
			sheet.addCell(new Label(col++, row, myDen.enName, dataCellFormat));
			sheet.addCell(new Label(col++, row, myDen.enDef, dataCellFormat));
			sheet.addCell(new Label(col++, row, myDen.getClassidsStr().replace("---", "\n"), dataCellFormat));
			sheet.addCell(new Label(col++, row, myDen.getDENsStr().replace("---", "\n"), dataCellFormat));
			sheet.addCell(new Label(col++, row, myDen.getObjectClassTermStr().replace("---", "\n"), dataCellFormat));
			sheet.addCell(new Label(col++, row, myDen.getPropertiesStr().replace("---", "\n"), dataCellFormat));
			sheet.addCell(new Label(col++, row, myDen.getRepreStr().replace("---", "\n"), dataCellFormat));
			sheet.addCell(new Label(col++, row, myDen.getNamedComplexTypeStr().replace("---", "\n"), dataCellFormat));
			sheet.addCell(new Label(col++, row, myDen.getXmlTagNameStr().replace("---", "\n"), dataCellFormat));
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// ************************************************************************************************
	// Class

	public void writeClassToFileTitles() {
		WritableSheet sheet = workbook.getSheet(2);
		sheet.getSettings().setDefaultColumnWidth(25);
		int row = 0;
		int col = 0;
		try {
			sheet.addCell(new Label(col++, row, "類別代碼", titleCellFormat));
			sheet.addCell(new Label(col++, row, "XML Tag Name", titleCellFormat));
			sheet.addCell(new Label(col++, row, "類別中文名稱", titleCellFormat));
			sheet.addCell(new Label(col++, row, "類別英文名稱\nClass Name", titleCellFormat));
			sheet.addCell(new Label(col++, row, "類別中文定義", titleCellFormat));
			sheet.addCell(new Label(col++, row, "類別英文定義", titleCellFormat));
			sheet.addCell(new Label(col++, row, "Object Class Term", titleCellFormat));
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeClassToFile(int n, XmaCls myCls) {
		WritableSheet sheet = workbook.getSheet(2);

		int row = n + 1;
		int col = 0;
		try {
			sheet.addCell(new Label(col++, row, myCls.clsid, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.getXmlTagNameStr().replace("---", "\n"), dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.chName, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.enName, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.chDef, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.enDef, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.objClsTerm, dataCellFormat));
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// ************************************************************************************************
	// WCO DENs

	int WCO_DENs_SHEET = 3;

	public void writeWCO_DENsToFileTitles() {
		try {
			int beginRow = 0;

			WritableSheet sheet = workbook.getSheet(WCO_DENs_SHEET);

			sheet.mergeCells(0, beginRow, 2, beginRow);
			sheet.mergeCells(3, beginRow, 9, beginRow);

			sheet.addCell(new Label(0, 0, "WCO Detail", titleCellFormat));
			sheet.addCell(new Label(3, 0, "WCO XML Detail", titleCellFormat));

			// --------------------------------------------------------------
			sheet.getSettings().setDefaultColumnWidth(25);
			int row = 1;
			int col = 0;
			sheet.setColumnView(col, 7);
			sheet.addCell(new Label(col++, row, "WCO ID", titleCellFormat));
			sheet.setColumnView(col, 15);
			sheet.addCell(new Label(col++, row, "Name", titleCellFormat));
			sheet.setColumnView(col, 20);
			sheet.addCell(new Label(col++, row, "Definition", titleCellFormat));
			sheet.setColumnView(col, 7);
			sheet.addCell(new Label(col++, row, "Class ID", titleCellFormat));
			sheet.setColumnView(col, 35);
			sheet.addCell(new Label(col++, row, "WCO Dictionary Entry Name", titleCellFormat));
			sheet.setColumnView(col, 25);
			sheet.addCell(new Label(col++, row, "Object Class Term", titleCellFormat));
			sheet.setColumnView(col, 25);
			sheet.addCell(new Label(col++, row, "Property Term", titleCellFormat));
			sheet.setColumnView(col, 10);
			sheet.addCell(new Label(col++, row, "Representation Term", titleCellFormat));
			sheet.setColumnView(col, 45);
			sheet.addCell(new Label(col++, row, "Named Complex Type", titleCellFormat));
			sheet.setColumnView(col, 25);
			sheet.addCell(new Label(col++, row, "XML Tag Name", titleCellFormat));
			sheet.setColumnView(col, 7);
			sheet.addCell(new Label(col++, row, "本國使用", titleCellFormat));

		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeWCO_DENsToFile(int n, WCOBaseDens myCls) {
		WritableSheet sheet = workbook.getSheet(WCO_DENs_SHEET);

		int row = n + 2;
		int col = 0;
		try {
			sheet.addCell(new Label(col++, row, myCls.wcoid, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.name, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.def, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.clsId, dataCellFormat));
//			sheet.addCell(new Label(col++, row, myCls.clsName, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.den, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.objcls, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.propertyTerm, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.representationTerm, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.namedComplexType, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.xmlTagName, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.usedByTW, dataCellFormat));
		
			
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// ************************************************************************************************
	// WCO Class
	int WCO_CLASS_SHEET = 4;

	public void writeWCO_ClassToFileTitles() {
		WritableSheet sheet = workbook.getSheet(WCO_CLASS_SHEET);
		sheet.getSettings().setDefaultColumnWidth(25);
		int row = 0;
		int col = 0;
		try {
			sheet.setColumnView(col, 15);
			sheet.addCell(new Label(col++, row, "類別代碼", titleCellFormat));
			sheet.setColumnView(col, 30);
			sheet.addCell(new Label(col++, row, "類別英文名稱", titleCellFormat));
			// sheet.setColumnView(col, 25);
			// sheet.addCell(new Label(col++, row, "XML Tag Name", titleCellFormat));
			sheet.setColumnView(col, 25);
			sheet.addCell(new Label(col++, row, "類別中文名稱", titleCellFormat));
			sheet.setColumnView(col, 45);
			sheet.addCell(new Label(col++, row, "類別英文定義", titleCellFormat));
			sheet.setColumnView(col, 45);
			sheet.addCell(new Label(col++, row, "類別中文定義", titleCellFormat));
			sheet.setColumnView(col, 15);
			sheet.addCell(new Label(col++, row, "本國使用", titleCellFormat));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeWCO_ClassToFile(int n, WCOBaseClass myCls) {
		WritableSheet sheet = workbook.getSheet(WCO_CLASS_SHEET);

		int row = n + 1;
		int col = 0;
		try {
			sheet.addCell(new Label(col++, row, myCls.wcoid, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.name, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.chnname, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.def, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.chndef, dataCellFormat));
			sheet.addCell(new Label(col++, row, myCls.usedByTW, dataCellFormat));
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws WriteException, IOException {

	}
}
