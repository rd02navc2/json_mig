package com.example.demo.phase2.make.data_item_set;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.example.demo.MyConst;
import com.example.demo.TWDENS_DAO;
import com.example.demo.XmaDB;
import com.example.demo.phase2.make.mapping_tree.MappingTreeRow;

public class ReadWCOBaseExcel {

	ReadTWDatasetExcel twDatasetExl = new ReadTWDatasetExcel();

	private String inputFile;

	public ReadWCOBaseExcel() {
		try {
			twDatasetExl.readDens();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ReadWCOBaseExcel(String x) {

	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public ArrayList arWCODens = new ArrayList();
	public ArrayList arWCOClass = new ArrayList();

	public ArrayList getWcoDENs() {
		return arWCODens;
	}

	public ArrayList getWcoCls() {
		return arWCOClass;
	}

	public void readWCODens() throws IOException {
		File inputWorkbook = new File(MyConst.getWCOBaseFilePath());
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);

			// --------------------------------------------------------------------------------
			// Get WCO Dens

			Sheet sheet = w.getSheet(0);
			// Loop over first 10 column and lines

			// System.out.println("rows="+sheet.getRows());

			for (int row = 0; row < sheet.getRows() - 1; row++) {
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

					if (col == 0) {
						o.wcoid = x;
					} else if (col == 1) {
						o.name = x;
					} else if (col == 2) {
						o.def = x;
					} else if (col == 3) {
						o.clsName = x;
					} else if (col == 4) {
						o.den = x;
					} else if (col == 5) {
						o.objcls = x;
					} else if (col == 6) {
						o.propertyTerm = x;
					} else if (col == 7) {
						o.representationTerm = x;
					} else if (col == 8) {
						o.namedComplexType = x;
					} else if (col == 9) {
						o.xmlTagName = x;
					} else if (col == 10) {
						o.format = x;
					} else if (col == 11) {
						o.codeRemarks = x;
					} else if (col == 12) {
						o.safe = x;
					}
				}
				arWCODens.add(o);
				// System.out.println(row+"-->"+o.wcoid);
			}
			// System.out.println("arWCODens size=" + arWCODens.size());
			// --------------------------------------------------------------------------------
			// read wco classes

			sheet = w.getSheet(1);
			// Loop over first 10 column and lines

			for (int row = 0; row < sheet.getRows() - 1; row++) {
				WCOBaseClass o = new WCOBaseClass();

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
						o.wcoid = x;
					} else if (col == 1) {
						o.name = x;
					} else if (col == 2) {
						o.chnname = x;
					} else if (col == 3) {
						o.def = x;
					} else if (col == 4) {
						o.chndef = x;
					} else if (col == 5) {
						o.objcls = x;
					}
				}
				arWCOClass.add(o);
				// System.out.println();
			}

			// --------------------------------------------------------------------------------
			findClassIdFromClassName();

		} catch (BiffException e) {
			e.printStackTrace();
		}
	}

	void findClassIdFromClassName() {

		for (int i = 0; i < arWCODens.size(); i++) {
			WCOBaseDens wcoden = (WCOBaseDens) arWCODens.get(i);

			wcoden.clsId = getClassID(wcoden.wcoid, wcoden.clsName.trim());

		}

	}

	String getClassID(String denid, String clsname) {

		String xx = "";

		String[] clsnames = clsname.split("\n");
		for (int i = 0; i < clsnames.length; i++) {
			// System.out.println(i + "--clsname=" + clsnames[i]);

			String myclsname = clsnames[i];

			String clsid = "   ";
			for (int k = 0; k < arWCOClass.size(); k++) {
				WCOBaseClass cls = (WCOBaseClass) arWCOClass.get(k);
				// String name = o.name;
				if (cls.name.equals(myclsname)) {
					clsid = cls.wcoid;
					break;
				}
			}

			// if (clsid.equals("   "))
			// System.err.println(denid + "-->" + myclsname + " ----> No Class ID !");

			if (i != clsnames.length - 1)
				xx = xx + clsid + "\n";
			else
				xx = xx + clsid;
		}
		// System.out.println();
		return xx;
	}

	void findUsedCls() {
		for (int i = 0; i < arWCOClass.size(); i++) {
			WCOBaseClass o = (WCOBaseClass) arWCOClass.get(i);

			// -------------------------------------------------
			if (twDatasetExl.clsUsedByTw(o.wcoid)) {
				o.usedByTW = "V";
			} else {
				o.usedByTW = "";
			}

		}
	}

	void findUsedDens() {
		for (int i = 0; i < arWCODens.size(); i++) {
			WCOBaseDens wcoden = (WCOBaseDens) arWCODens.get(i);

			// -------------------------------------------------
			// String clsname = o.objcls.replace(" ", "").trim();
			// String clsid = getClassID(wcoden.clsName.trim());
			//
			// if (!clsid.trim().equals("")) {
			// wcoden.clsId = clsid;
			// }

			// -------------------------------------------------
			if (twDatasetExl.denUsedByTw(wcoden.wcoid)) {
				wcoden.usedByTW = "V";
			} else {
				wcoden.usedByTW = "";
			}

		}
	}

	public static void main(String[] args) throws IOException {

		// XmaDB db = new XmaDB();
		// db.openConnection();

		ReadWCOBaseExcel test = new ReadWCOBaseExcel();

		test.readWCODens();

		System.out.println("done!\n");

		// db.closeConnection();

	}

}