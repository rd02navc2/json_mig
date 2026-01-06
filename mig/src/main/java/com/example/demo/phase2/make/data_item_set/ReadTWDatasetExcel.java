package com.example.demo.phase2.make.data_item_set;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import com.example.demo.MyConst;
import com.example.demo.XmaDB;
import com.example.demo.phase2.make.item_desc_tbl.ReadItemTblDoc;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadTWDatasetExcel {

	public ArrayList arWCODens = new ArrayList();
	public ArrayList arTWDens = new ArrayList();

	public ArrayList arWCOClass = new ArrayList();
	public ArrayList arTWClass = new ArrayList();

	public ArrayList arTWDS = new ArrayList();

	public boolean denUsedByTw(String wcoid) {
		boolean b = false;
		for (int i = 0; i < arWCODens.size(); i++) {
			WCOBaseDens o = (WCOBaseDens) arWCODens.get(i);
			if (o.wcoid.equals(wcoid)) {
				b = true;
				break;
			}
		}
		return b;
	}

	public boolean clsUsedByTw(String wcoid) {
		boolean b = false;
		for (int i = 0; i < arWCOClass.size(); i++) {
			WCOBaseClass o = (WCOBaseClass) arWCOClass.get(i);
			if (o.wcoid.equals(wcoid)) {
				b = true;
				break;
			}
		}
		return b;
	}

	public void readDens() throws IOException {
		File inputWorkbook = new File(MyConst.getTDLDensPath());
		Workbook w = null;

		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet("DENs");
			// Loop over first 10 column and lines

			// System.out.println("rows="+sheet.getRows());

			for (int row = 1; row < sheet.getRows() ; row++) {
				WCOBaseDens o = new WCOBaseDens();

				// if(row>10)break;

				for (int col = 0; col < sheet.getColumns(); col++) {

					Cell cell = sheet.getCell(col, row);
					CellType type = cell.getType();

					String x = "";
					if (col == 3 && cell.getType() == CellType.NUMBER) {
						x = "000" + cell.getContents();
						x = x.substring(cell.getContents().length());
					} else {
						x = "" + cell.getContents();
					}

					x = x.trim();
					// System.out.print(x);
					// System.out.print("\t");

					if (col == 1) {
						o.wcoid = x;
					} else if (col == 2) {
						o.name = x;
					} else if (col == 3) {
						o.def = x;
					} else if (col == 4) {
						o.clsId = x;
					} else if (col == 5) {
						o.den = x;
					} else if (col == 6) {
						o.objcls = x;
					} else if (col == 7) {
						o.propertyTerm = x;
					} else if (col == 8) {
						o.representationTerm = x;
					} else if (col == 9) {
						o.namedComplexType = x;
					} else if (col == 10) {
						o.xmlTagName = x;
					} else if (col == 11) {

					}
				}
				if (o.wcoid.startsWith("TW") || o.wcoid.endsWith("*")) {
					//System.out.println(o.wcoid);
					arTWDens.add(o);
				} else {
					arWCODens.add(o);
					// System.out.println(row+"-->"+o.wcoid);
				}
			}
//			System.out.println("arDens size=" + arWCODens.size());
			// --------------------------------------------------------------------------------

			sheet = w.getSheet("CLS");
			// Loop over first 10 column and lines

			for (int row = 1; row < sheet.getRows(); row++) {
				WCOBaseClass twClass = new WCOBaseClass();

				// if(row>10)break;

				for (int col = 0; col < sheet.getColumns(); col++) {

					Cell cell = sheet.getCell(col, row);
					CellType type = cell.getType();

					String x = "";
					if (col == 3 && cell.getType() == CellType.NUMBER) {
						x = "000" + cell.getContents();
						x = x.substring(cell.getContents().length());
					} else {
						x = "" + cell.getContents();
					}

					// System.out.print(x);
					// System.out.print("\t");

					x = x.trim();

					if (col == 0) {
						twClass.wcoid = x;
					} else if (col == 1) {
						twClass.xmlTagName = x;
					} else if (col == 2) {
						twClass.chnname = x;
					} else if (col == 3) {
						twClass.name = x;
					} else if (col == 4) {
						twClass.chndef = x;
					} else if (col == 5) {
						twClass.def = x;
					} else if (col == 6) {
						twClass.objcls = x;
					} else if (col == 7) {

					}

				}

				if (twClass.wcoid.startsWith("TW")) {
					arTWClass.add(twClass);
				} else {
					arWCOClass.add(twClass);
					// System.out.println(row+"-->"+o.wcoid);
				}
			}
			// --------------------------------------------------------------------------------

			sheet = w.getSheet("DS");
			// Loop over first 10 column and lines

			for (int row = 1; row < sheet.getRows(); row++) {
				WCOBaseDS twDS = new WCOBaseDS();

				// if(row>10)break;

				for (int col = 0; col < sheet.getColumns(); col++) {

					Cell cell = sheet.getCell(col, row);
					CellType type = cell.getType();

					String x = "";
					if (col == 3 && cell.getType() == CellType.NUMBER) {
						x = "000" + cell.getContents();
						x = x.substring(cell.getContents().length());
					} else {
						x = "" + cell.getContents();
					}

					// System.out.print(x);
					// System.out.print("\t");

					x = x.trim();

					if (col == 0) {
						twDS.sn = x;
					} else if (col == 1) {
						twDS.chnname = x;
					} else if (col == 2) {
						twDS.name = x;
					} else if (col == 3) {
						twDS.chndef = x;
					} else if (col == 4) {
						twDS.def = x;
					} else if (col == 5) {
						twDS.format = x;
					} else if (col == 6) {
						twDS.usedByMsgs = x;
					} else if (col == 7) {
						twDS.wcoid = x;
					} else if (col == 15) {
						twDS.codeRemarks = x;
					}else if (col == 16) {
						twDS.starFlag = x;
					}

				}

				arTWDS.add(twDS);
			}

		} catch (BiffException e) {
			e.printStackTrace();

		} finally {
			if (w != null)
				w.close();
		}
	}

	public void enrichDS() throws IOException {

		ReadWCOBaseExcel o = new ReadWCOBaseExcel();
		o.readWCODens();
		ArrayList ar = o.arWCODens;

		for (int i = 0; i < arTWDS.size(); i++) {

			WCOBaseDS ds = (WCOBaseDS) arTWDS.get(i);

			for (int j = 0; j < ar.size(); j++) {
				WCOBaseDens wcoden = (WCOBaseDens) ar.get(j);
				if (wcoden.wcoid.equals(ds.wcoid)) {
					ds.wcoCodeList = wcoden.codeRemarks;
					ds.safe = wcoden.safe;
					break;
				}

			}

		}
	}

	public void prn() {
		for (int i = 0; i < arTWDS.size(); i++) {

			WCOBaseDS ds = (WCOBaseDS) arTWDS.get(i);
			System.out.println(ds.chnname + "\t" + ds.wcoid + "\t" + ds.codeRemarks + "\t" + ds.wcoCodeList + "\t"
					+ ds.safe);
		}
	}

	public static void main(String[] args) throws Exception {
		ReadTWDatasetExcel o = new ReadTWDatasetExcel();
		o.readDens();
		o.enrichDS();
		o.prn();

		System.out.println("****************************************");

	}
}
