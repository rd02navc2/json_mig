package com.example.demo.utils.process.n.mig;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


import com.example.demo.MyConst;
import com.example.demo.TWDENS_DAO;
import com.example.demo.XmaDB;

public class ReadItemTblDoc {

	static HashMap hm = new HashMap();

	public static ItemTblItem getItemTblItem(String k) {
		ItemTblItem o = (ItemTblItem) hm.get(k);
		return o;
	}

	// // Item unused by mapping tree
	// public static void showDataItemThatNotUsedByMappingTree() {
	// Iterator it = hm.keySet().iterator();
	// while (it.hasNext()) {
	// ItemTblItem item = (ItemTblItem) hm.get(it.next());
	// if (!item.isGroup && !item.appearInMappingTree) {
	// System.err.println("資料項目 -" + item.chName +
	// " Not appear in Mappin Tree!\n");
	// }
	// }
	// }

	public void prnOneTableRows() {
		for (int i = 0; i < oneTableRows.size(); i++) {
			String chname = (String) oneTableRows.get(i);
			System.out.println(i + "\t" + chname);
		}
	}

	ArrayList oneTableRows = new ArrayList();

	ArrayList getContent(String msgName) {

		readin(msgName);

		// oneTableRows = new ArrayList();
		//
		// Iterator it = hm.keySet().iterator();
		// while (it.hasNext()) {
		// String chname = (String) it.next();
		// oneTableRows.add(chname);
		// }
		return oneTableRows;
	}

	public void readin(String msgName) {

		String fileName = MyConst.getMIGpath() + msgName + ".doc";

		// String fileName =
		// "C:/Documents and Settings/900507/My Documents/Downloads/關港貿資料交換欄位對應表 1010117 1349_mmm.doc";

		try {
			FileInputStream in = new FileInputStream(fileName);
			POIFSFileSystem pfs = new POIFSFileSystem(in);
			HWPFDocument hwpf = new HWPFDocument(pfs);
			Range range = hwpf.getRange();
			TableIterator it = new TableIterator(range);

			// for each table
			while (it.hasNext()) {

				String msg = "";
				// tableRows = new ArrayList();

				Table tb = (Table) it.next();

				// for each row
				boolean f = false;
				for (int row = 0; row < tb.numRows(); row++) {

					TableRow tr = tb.getRow(row);

					String hit = tr.getCell(0).getParagraph(0).text().trim();

					// -------------------------------------------------
					if (!f && (hit.trim().equals("S0") || hit.trim().equals("S1"))) {
						f = true;
					}

					if (!f) {
						continue;
					}
					// ----------------------------------------------------------------
					String sS = tr.getCell(0).text();
					sS = sS.trim();
					if (sS.endsWith("")||sS.endsWith("　"))
						sS = sS.substring(0, sS.length() - 1).trim();
					if (sS.equals("　") || sS.equals(""))
						sS = "";
					// ----------------------------------------------------------------
					String sG = tr.getCell(1).text();
					sG = sG.trim();
					if (sG.endsWith("")||sG.endsWith("　"))
						sG = sG.substring(0, sG.length() - 1).trim();
					if (sG.equals("　") || sG.equals(""))
						sG = "";

					// ----------------------------------------------------------------
					String sE = tr.getCell(2).text();
					sE = sE.trim();
					if (sE.endsWith("")||sE.endsWith("　"))
						sE = sE.substring(0, sE.length() - 1).trim();
					if (sE.equals("　") || sE.equals(""))
						sE = "";

					// ----------------------------------------------------------------
					if (!sE.equals("")) {
						sS = "";
						sG = "";
					}

					// ----------------------------------------------------------------
					String chname = tr.getCell(3).text();
					chname = chname.trim();
					if (chname.endsWith("")||chname.endsWith("　"))
						chname = chname.substring(0, chname.length() - 1).trim();
					if (chname.equals("　") || chname.equals(""))
						chname = "";
					// ----------------------------------------------------------------
					String enname = tr.getCell(4).text();
					enname = enname.trim();
					if (enname.endsWith("")||enname.endsWith("　"))
						enname = enname.substring(0, enname.length() - 1).trim();
					if (enname.equals("　") || enname.equals(""))
						enname = "";
					// ----------------------------------------------------------------
					String format = tr.getCell(5).text();
					format = format.trim();
					if (format.endsWith("")||format.endsWith("　"))
						format = format.substring(0, format.length() - 1).trim();
					if (format.equals("　") || format.equals(""))
						format = "";
					// ----------------------------------------------------------------
					String mc = tr.getCell(6).text();
					mc = mc.trim();
					if (mc.endsWith(""))
						mc = mc.substring(0, mc.length() - 1).trim();
					if (mc.equals("　") || mc.equals(""))
						mc = "";
					// ----------------------------------------------------------------
					String rmk = tr.getCell(tr.numCells() - 1).text();
					rmk = rmk.trim();
					if (rmk.endsWith(""))
						rmk = rmk.substring(0, rmk.length() - 1).trim();
					if (rmk.equals("　") || rmk.equals(""))
						rmk = "";
					// ----------------------------------------------------------------

					// System.out.print(chname + "---" + enname + "---" + format
					// + "---" + rmk + "---");

					// each cell
					// for (int cell = 0; cell < tr.numCells(); cell++) {
					// TableCell td = tr.getCell(cell);
					// }

					// tableRows.add(myRow);
					// System.out.println();

					ItemTblItem item = new ItemTblItem();
					item.sS = sS;
					item.sG = sG;
					item.sE = sE;
					item.chName = chname;
					item.enName = enname;
					item.format = format;
					item.mc = mc;
					item.remark = rmk;
					if (item.format.trim().equals("　") || item.format.trim().equals("")) {
						item.isGroup = true;
					} else {
						item.isGroup = false;
					}

					hm.put(item.chName, item);
					// System.out.println(item.chName + "," + item.enName + ","
					// + item.format.trim() + "," + item.remark);

					oneTableRows.add(item.sS + "\t" + item.sG + "\t" + item.sE + "\t" + item.chName + "\t" + item.format + "\t" + item.mc);

				}

				// hm.put(msg, tableRows);"

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public void checkGroup() {
	// Iterator it = hm.keySet().iterator();
	// while (it.hasNext()) {
	// ItemTblItem item = (ItemTblItem) hm.get(it.next());
	//
	// // System.err.println("GGGGGGGroup---->"+item.chName);
	//
	// if (item.isGroup) {
	// XmaDB db = new XmaDB();
	// TWDENS_DAO densds = db.getGroupInfo(item.chName);
	// if (densds == null) {
	// // densds = new TWDENS_DAO();
	// System.err.println("\n資料 Group Not Exist -" + item.chName + "\n");
	// } else {
	// if (!item.enName.equals(densds.enName)) {
	// System.err.println("\n資料 Group English Name Not Match -" + item.chName + "\n資料項目表 -\n"
	// + item.enName + "\nDB -\n" + densds.enName + "\n");
	// }
	// }
	// }
	// }
	// }

	public void checkItem() {
		Iterator it = hm.keySet().iterator();
		while (it.hasNext()) {
			ItemTblItem item = (ItemTblItem) hm.get(it.next());

			// System.err.println("GGGGGGGroup---->"+item.chName);

			if (!item.isGroup) {

				// XmaPool db = new XmaPool();
				XmaDB db = new XmaDB();

				TWDENS_DAO densds = db.getDsResult2(item.chName);

				// System.out.println("---------vv-xxxx----->"+densds.enName);

				if (densds == null) {
					System.err.println("\n資料項目 Not Exist in DB -" + item.chName + "\n");
				} else {

					// if (!item.enName.equals(densds.enName)) {
					// System.err.println("\n資料 Group English Name Not Match -"
					// + item.chName + "\n資料項目表 -\n"
					// + item.enName + "\nDB -\n" + densds.enName + "\n");
					// }

					if (!item.enName.equals(densds.enName)) {
						System.err.println(item.chName + " English Name Mismatch --\nTDL:\n" + densds.enName //
								+ "\n資料項目表:\n" + item.enName + "\n");
					}

					if (!item.format.equals(densds.format)) {
						System.err.println(item.chName + " Format Name Mismatch --\nTDL:\n" + densds.format + "\n資料項目表:\n" + item.format + "\n");
					}

					String remark = densds.codeList;
					remark = remark.replace("---", MyConst.newline);
					// itemTblItem.remark=itemTblItem.remark.replace(
					// MyConst.newline,"---");
					if (!remark.equals(item.remark)) {
						System.err.println(item.chName + " Remark Mismatch --\nTDL:\n" + remark + "\n資料項目表:\n" + item.remark + "\n");
						// return null;
					}
				}
			}
		}
	}

	public void listItemTableContent() {
		Iterator it = hm.keySet().iterator();
		while (it.hasNext()) {
			ItemTblItem item = (ItemTblItem) hm.get(it.next());
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ReadItemTblDoc o = new ReadItemTblDoc();
		o.readin("NX202");

		System.out.println("****************************************");
		// XmaDB db = new XmaDB();
		// db.openConnection();
		// o.checkGroup();
		o.checkItem();

		// db.closeConnection();

	}
}