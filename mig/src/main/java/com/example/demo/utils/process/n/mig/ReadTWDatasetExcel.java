package com.example.demo.utils.process.n.mig;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.example.demo.XmaDB;
import com.example.demo.phase2.make.item_desc_tbl.ReadItemTblDoc;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadTWDatasetExcel {

	// public ArrayList arWCODens = new ArrayList();
	// public ArrayList arTWDens = new ArrayList();
	//
	// public ArrayList arWCOClass = new ArrayList();
	// public ArrayList arTWClass = new ArrayList();

	public ArrayList arTWDS = new ArrayList();

	// public ArrayList arMap = new ArrayList();

	public void readExcel() {
		
//		System.getProperties().put("org.apache.commons.logging.simplelog.defaultlog","fatal"); 
		// File inputWorkbook = new File("D:/mu20060711/workspace_svn_harmo/TDL_DENs.xls");

		File inputWorkbook = new File("D:/mu20060711/workspace_svn_harmo/TDL_DENs.xls");

		Workbook w = null;

		try {
			w = Workbook.getWorkbook(inputWorkbook);

			Sheet sheet = w.getSheet("DS");
			// Loop over first 10 column and lines

			for (int row = 1; row < sheet.getRows(); row++) {
				TDL_DS twDS = new TDL_DS();

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
					} else if (col == 12) {
						twDS.representationTerm = x;
					} else if (col == 15) {
						twDS.codeRemarks = x;
					} else if (col == 16) {
						twDS.starFlag = x;
					} else if (col == 17) {
						twDS.EDILength = x;
					}

				}

				arTWDS.add(twDS);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (w != null)
				w.close();
		}
	}

	// public void enrichDSMapFormat() throws IOException {
	// for (int i = 0; i < arMap.size(); i++) {
	// DS_Map map = (DS_Map) arMap.get(i);
	//
	// TDL_DS d = (TDL_DS) getTWDS(map.newChnname);
	// if (d == null) {
	// map.newFormat = "??";
	// } else {
	// map.newFormat = d.format;
	// }
	// }
	// }

	public TDL_DS getTWDS(String chnname) {
		TDL_DS ds = null;
		for (int i = 0; i < arTWDS.size(); i++) {
			ds = (TDL_DS) arTWDS.get(i);
			if (ds != null) {

			} else {
				System.err.println("--->" + i);
			}
			if (ds.chnname.trim().equals(chnname.trim()))
				return ds;
		}
		return null;

	}

	public void prn() {
		for (int i = 0; i < arTWDS.size(); i++) {
			TDL_DS ds = (TDL_DS) arTWDS.get(i);
			System.out
					.println(ds.chnname + "\t" + ds.wcoid + "\t" + ds.format + "\t" + ds.wcoCodeList + "\t" + ds.safe);
		}

	}

	public ArrayList getDS() {
		return arTWDS;
	}

	public static void main(String[] args) throws Exception {
		ReadTWDatasetExcel o = new ReadTWDatasetExcel();
		o.readExcel();
		// o.enrichDSMapFormat();
		o.prn();

		System.out.println("****************************************");

	}
}
