package com.example.demo.phase2.check.format_etc;

import java.io.FileInputStream;
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

	String msgName = "";
	static HashMap hm = new HashMap();

	public static ItemTblItem getItemTblItem(String k) {
		ItemTblItem o = (ItemTblItem) hm.get(k);
		return o;
	}

	// Item unused by mapping tree
	// public static void showDataItemThatNotUsedByMappingTree() {
	// Iterator it = hm.keySet().iterator();
	// while (it.hasNext()) {
	// ItemTblItem item = (ItemTblItem) hm.get(it.next());
	// if (!item.isGroup && !item.appearInMappingTree) {
	// System.err.println("資料項目 -" + item.chName + " Not appear in Mappin Tree!\n");
	// }
	// }
	// }

	public void readin(String msgName) {
		this.msgName = msgName;
		
		hm = new HashMap();
		
		String fileName = MyConst.getMIGpath() + msgName + ".doc";

		try {
			FileInputStream in = new FileInputStream(fileName);
			POIFSFileSystem pfs = new POIFSFileSystem(in);
			HWPFDocument hwpf = new HWPFDocument(pfs);
			Range range = hwpf.getRange();
			TableIterator it = new TableIterator(range);

			if (it == null) {
				System.err.println("\n\nDDDDDDDDDDDDDDWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW----" + msgName);
			}
			// for each table
			while (it.hasNext()) {

				String msg = "";
				// tableRows = new ArrayList();

				if (it == null) {
					System.err.println("\n\nDDDDDDDDDDDzzzzzzDDDWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW----" + msgName);
				} else {

				}
				Table tb = (Table) it.next();

				// TableRow tr1 = tb.getRow(0);
				// String hit1 = tr1.getCell(0).getParagraph(0).text().trim();
				// System.out.println(msgName
				// +" tb.numRows()="+tb.numRows()+" --->"+ hit1);
				// System.out.println("ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt "+msgName
				// +" tb.numRows()="+tb.numRows());
				// for each row
				boolean f = false;
				for (int row = 0; row < tb.numRows(); row++) {

					TableRow tr = tb.getRow(row);

					String hit = tr.getCell(0).getParagraph(0).text().trim();
					// if(msgName.equals("N5109")){
					// System.out.println(msgName +" row="+row+" --->"+ hit);
					// }

					// -------------------------------------------------
					if (!f && (hit.trim().equals("S0") || hit.trim().equals("S1"))) {
						f = true;
					}

					if (!f) {
						continue;
					}
					// ----------------------------------------------------------------
					String chname = tr.getCell(3).text();
					chname = chname.trim();
					if (chname.endsWith(""))
						chname = chname.substring(0, chname.length() - 1).trim();
					if (chname.equals("　") || chname.equals(""))
						chname = "";
					// ----------------------------------------------------------------
					String enname = tr.getCell(4).text();
					enname = enname.trim();
					if (enname.endsWith(""))
						enname = enname.substring(0, enname.length() - 1).trim();
					if (enname.equals("　") || enname.equals(""))
						enname = "";
					// ----------------------------------------------------------------
					String format = tr.getCell(5).text();
					format = format.trim();
					if (format.endsWith(""))
						format = format.substring(0, format.length() - 1).trim();
					if (format.equals("　") || format.equals(""))
						format = "";
					// ----------------------------------------------------------------
					String rmk = tr.getCell(tr.numCells() - 1).text();
					rmk = rmk.trim();
					if (rmk.endsWith(""))
						rmk = rmk.substring(0, rmk.length() - 1).trim();
					if (rmk.equals("　") || rmk.equals(""))
						rmk = "";

					rmk = rmk.replace("\r", "\n");

					// ----------------------------------------------------------------

					ItemTblItem item = new ItemTblItem();
					item.chName = chname;
					item.enName = enname;
					item.format = format;
					item.remark = rmk;
					if (item.format.trim().equals("　") || item.format.trim().equals("")) {
						item.isGroup = true;
					} else {
						item.isGroup = false;
					}

					hm.put(item.chName, item);
					// System.out.println(item.chName + "," + item.enName + ","
					// + item.format.trim() + "," + item.remark);
				}

				// hm.put(msg, tableRows);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkItem() {
		boolean ok=true;
		Iterator it = hm.keySet().iterator();
		while (it.hasNext()) {
			ItemTblItem item = (ItemTblItem) hm.get(it.next());

			// System.err.println("GGGGGGGroup---->"+item.chName);

			if (item.isGroup)
				continue;

			XmaDB db = new XmaDB();

			TWDENS_DAO densds = db.getDsResult2(item.chName);

			if (densds == null) {
				System.err.println(msgName + " 資料項目 " + item.chName + " Not Exist in TDL !!");
				ok=false;
				break;
			}

			if (!item.enName.trim().equals(densds.enName.trim())) {
				System.err.println(msgName + " 資料項目 " + item.chName + " 英文名稱不一致");
				System.err.println("TDL:\t\t\t" + densds.enName); //
				System.err.println("資料項目表:\t" + item.enName);
				ok=false;
				break;
			}

			if (!item.format.equals(densds.format)) {
				System.err.println(msgName + " 資料項目 " + item.chName + " 屬性與長度不一致");
				System.err.println("TDL:\t\t\t" + densds.format); //
				System.err.println("資料項目表:\t" + item.format);
				ok=false;
				break;
			}

			// String remark = densds.codeList;
			// remark = remark.replace("---", MyConst.newline);
			// itemTblItem.remark=itemTblItem.remark.replace(
			// MyConst.newline,"---");
			// if (!remark.equals(item.remark)) {
			// System.err.println(item.chName + " Remark Mismatch --\nTDL:\n" + remark + "\n資料項目表:\n" + item.remark + "\n");
			// // return null;
			// }

		}
		
		return ok;
	}

	// public void listItemTableContent() {
	// Iterator it = hm.keySet().iterator();
	// while (it.hasNext()) {
	// ItemTblItem item = (ItemTblItem) hm.get(it.next());
	// System.out.println();
	// }
	// }

	public static void main(String[] args) {

	}
}