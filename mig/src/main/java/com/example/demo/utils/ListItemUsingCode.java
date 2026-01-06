package com.example.demo.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


import com.example.demo.MyConst;
import com.example.demo.XmaDB;
import com.example.demo.phase2.check.chap4n8.ItemTblItem;

/**
 * 
 * 列出每個資料項目使用的代碼
 * 
 */
public class ListItemUsingCode {

	static HashMap hm = new HashMap();

	public static ItemTblItem getItemTblItem(String k) {
		ItemTblItem o = (ItemTblItem) hm.get(k);
		return o;
	}

	// public void readin(String msgName) {
	// // String filesname = "N5158_1000310_V06.doc";
	// // String filesname = "itemtbl/" + msgName + "_itemsTbl.doc";
	// String filesname = MyConst.getMIGpath() + msgName + ".doc";
	//
	// POIFSFileSystem fs = null;
	// try {
	// fs = new POIFSFileSystem(new FileInputStream(filesname));
	// HWPFDocument doc = new HWPFDocument(fs);
	// WordExtractor we = new WordExtractor(doc);
	//
	// // int cnt = 0;
	// String[] fileData = we.getParagraphText();
	// String text = "";
	// // StringBuffer sb = new StringBuffer();
	//
	// ItemTblItem item = new ItemTblItem();
	//
	// boolean f = false;
	// for (int i = 0; i < fileData.length; i++) {
	// text = fileData[i];
	// // sb.append(text);
	//
	//
	// if (text.trim().equals("S0") || text.trim().equals("S1")) {
	// f = true;
	// }
	// if (!f)
	// continue;
	//
	// // System.out.print(i + "--->" +text);
	//
	//
	// String v = text;
	// if (v.endsWith("")) {
	// v = v.substring(0, v.length() - 1).trim();
	// // sb = new StringBuffer();
	//
	// }
	//
	// System.out.println(i+","+" --->"+v);
	//
	//
	// if (i == 3) {
	// System.out.println(i + " >>>>>>>>>>>>>>>>>>>>>" + v);
	// item = new ItemTblItem();
	// item.chName = v;
	// } else if (i == fileData.length - 1) {
	// // item = new Item();
	// item.enName = v;
	// System.out.println(i + " >>>>>>>>>>>>>>>>>>>>>" + v);
	// } else if (i == 5) {
	// System.out.println(i + " >>>>>>>>>>>>>>>>>>>>>" + v);
	// if (item.format.trim().equals("　") || item.format.trim().equals("")) {
	// item.isGroup = true;
	// } else {
	// item.isGroup = false;
	// }
	//
	// } else if (i % 5 == 3) {
	//
	// }
	//
	// addCode(item.chName, item.remark);
	// // cnt++;
	// // }
	// }
	// // System.out.println("--->>>>>" + cnt);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public void readin(String msgName) {

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

					rmk = rmk.replace("\r", "---");
					if (rmk.startsWith("代碼：---"))
						rmk = rmk.substring("代碼：---".length());

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

					if (!item.isGroup) {
						// ar.add(item);
						addCode(item.chName, item.remark);
					}

					// hm.put(item.chName, item);
					// System.out.println(item.chName + "," + item.enName + ","
					// + item.format.trim() + "," + item.remark);
				}

				// hm.put(msg, tableRows);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addCode(String chname, String code) {
		if (code.trim().equals(""))
			return;

		if (code.contains("格式"))
			return;

		if (code.contains("年(西元)"))
			return;

		if (code.contains("KGM only") || code.contains("CMQ only"))
			return;

		if (code.contains("暫保留"))
			return;

		if (code.startsWith("參照關港貿作業代碼")) {
			code = code.substring("參照".length());
		}

		if (hm.containsKey(chname)) {
			ArrayList codes = (ArrayList) hm.get(chname);
			boolean b = false;
			for (int i = 0; i < codes.size(); i++) {
				String oc = (String) codes.get(i);
				if (oc.equals(code)) {
					b = true;
					break;
				}
			}

			if (!b) {
				codes.add(code);
			}
		} else {
			ArrayList c = new ArrayList();
			c.add(code);
			hm.put(chname, c);
		}
	}

	public void listItemTableContent() {
		
		XmaDB db = new XmaDB();
		
		Iterator it = hm.keySet().iterator();
		while (it.hasNext()) {
			String chname = (String) it.next();
			System.out.print(chname + "\t\t");

			ArrayList codes = (ArrayList) hm.get(chname);

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < codes.size(); i++) {
				sb.append("---");
				// System.out.print("---");
				String oc = (String) codes.get(i);
				sb.append(oc);
			}
			String xxx = sb.toString();
			// --------------------------------------------------
			if (xxx.startsWith("---"))
				xxx = xxx.substring("---".length());

			// --------------------------------------------------
			String[] zzzz = xxx.split("---");
			HashSet set = new HashSet();
			for (int i = 0; i < zzzz.length; i++) {
				set.add(zzzz[i]);
			}

			// --------------------------------------------------
			ArrayList arrr = new ArrayList();
			Iterator it2 = set.iterator();
			while (it2.hasNext()) {
				String zxzzx = (String) it2.next();
				// System.out.println(zxzzx);
				arrr.add(zxzzx);
			}

			Collections.sort(arrr, new DSComparator());

			// System.out.println("YYYYYYYYYYMMMMMMMMMMM====>"+arrr.size());
			// --------------------------------------------------
			String yyyy = "";
			for (int i = 0; i < arrr.size(); i++) {
				// System.out.println("~~~"+(String)arrr.get(i));
				yyyy = yyyy + (String) arrr.get(i);
				if (i != arrr.size() - 1) {
					yyyy = yyyy + "---";
				}
			}
			// --------------------------------------------------

			System.out.println(yyyy);

			db.updateCodeList(chname, yyyy);
			// System.out.println("\n" + "*************************" + "\n");
		}
	}

	class DSComparator implements Comparator<String> {
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}

	}

	public static void main(String[] args) {

		XmaDB db = new XmaDB();
		db.openConnection();
		db.clearCodeList();

		ListItemUsingCode o = new ListItemUsingCode();

		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.msg[i][2];
			o.readin(msgName);
		}
		o.listItemTableContent();
		System.out.println("****************************************");

		db.closeConnection();

	}

}