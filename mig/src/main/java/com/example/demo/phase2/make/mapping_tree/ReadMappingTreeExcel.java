package com.example.demo.phase2.make.mapping_tree;

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

public class ReadMappingTreeExcel {

	private String inputFile;
	String msgName;

	public ReadMappingTreeExcel(String msgName) {
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
			// Loop over first 10 column and lines

			for (int row = 1; row < sheet.getRows(); row++) {
				MappingTreeRow o = new MappingTreeRow();
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

					if (col == 0) {
						o.occur = x;
					} else if (col == 1) {
						o.mc = x;
					} else if (col == 2) {
						o.classid = x;
					} else if (col == 3) {

						o.propid = x;
					} else if (col == 4) {
						o.tree = x;
					} else if (col == 6) {
						o.format = x;
					} else if (col == 7) {
						if (!x.startsWith("*"))
							o.chnName = x;
					}
				}
				ar.add(o);
				// System.out.println();
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
	}

	void enrich() {
		for (int i = 0; i < ar.size(); i++) {
			MappingTreeRow o = (MappingTreeRow) ar.get(i);

			String chineseName = o.chnName;
			if (!chineseName.trim().equals("")) {
				XmaDB db = new XmaDB();
				TWDENS_DAO dao = db.getDsResult2(chineseName);

				if (dao == null)
					System.out.println("Mapping Tree REader Error==>" + "'" + chineseName + "'");
				else {
					o.chnDef = dao.chDef;
					o.enDef = dao.enDef;
					o.enName = dao.enName;
				}
			}
			//o.prn();
		}
	}

	void writefile(String outputFile) {
		WriteMappingTreeExcel w = new WriteMappingTreeExcel();
		w.setOutputFile(outputFile);
		w.createDataSetExcel();

		w.writeFileTitles(msgName);

		for (int i = 0; i < ar.size(); i++) {
			MappingTreeRow o = (MappingTreeRow) ar.get(i);

			w.writeToFile(i, o);
		}

		w.closeDataSetExcel();
	}

	public static void main(String[] args) throws IOException {
		XmaDB db = new XmaDB();
		db.openConnection();
		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
		//	String rootEleName = msg[i][1];
			//String schemaFile = msg[i][2];

			ReadMappingTreeExcel test = new ReadMappingTreeExcel(msgName);
			test.setInputFile("d:/temp/mappingtrees/input/" + msgName + ".xls");
			test.read();

			test.enrich();
			test.writefile("d:/temp/mappingtrees/III_" + msgName + "_mappingTree.xls");

			System.out.println(msgName + " mapping tree done!\n");
		}
		db.closeConnection();

	}

}