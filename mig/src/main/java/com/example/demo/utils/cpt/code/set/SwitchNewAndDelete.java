package com.example.demo.utils.cpt.code.set;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/*
 * 對調'新增'與'廢止'到日期之後
 */
public class SwitchNewAndDelete {

	ArrayList tableRows = new ArrayList();
	HashMap hm = new HashMap();
	ArrayList msgList = new ArrayList();

	public String newline = System.getProperty("line.separator");

	public static void main(String[] args) throws Exception {

		SwitchNewAndDelete o = new SwitchNewAndDelete();
		o.testWord();
		o.prn();
		ArrayList tableRows = o.getResult();

		// ------------------------------------------------
		WriteSwitchedDoc o2 = new WriteSwitchedDoc();
		o2.setInput(tableRows);

		o2.openDoc();
		o2.outTWDS2Doc();
		o2.closeDoc();

		System.out.println("ok");
	}

	public void testWord() {

		// String fileName = "D:/mu20060711/workspace_svn_harmo/關港貿XML訊息建置指引(草案)/NX5105.doc";

		String fileName = "D:/temp/aaa.doc";

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

					MyRow myRow = new MyRow();

					TableRow tr = tb.getRow(row);

					String hit = tr.getCell(0).getParagraph(0).text().trim();

					// -------------------------------------------------

					// if (!f && hit.trim().equals("D0060")) {
					// f = true;
					// }
					//
					// if (!f) {
					// continue;
					// }

					// each cell
					for (int cell = 0; cell < tr.numCells(); cell++) {
						TableCell td = tr.getCell(cell);

						// String cellContent =td.text().trim();
						// cellContent=cellContent.replace("?", "\n");

						String cellContent = "";
						// --------------------------------------------
						// add all paragraphs in cell
						for (int p = 0; p < td.numParagraphs(); p++) {
							Paragraph para = td.getParagraph(p);
							String s = para.text().trim();

							// if(td.numParagraphs()>1){
							// System.out.println(td.text().trim()+"====>"+s);
							// }

							cellContent = cellContent + s;
							if (p != td.numParagraphs() - 1) {
								cellContent = cellContent + newline;
							}
						}
						// --------------------------------------------
						// if (f) {
						System.out.print(cellContent + ",");
						myRow.lines[cell] = cellContent;
						// }
					}

					tableRows.add(myRow);
					System.out.println();
				}

				// hm.put(msg, tableRows);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String changePos(String a, String t) {
		String b = "";
		// String t = "新增";
		if (a.startsWith(t)) {
			b = a.substring(t.length()).trim();
			if (b.endsWith(".")) {
				b = b.substring(0, b.length() - 1);
			}
			b = b + t;
		}

		return b;
	}

	public void prn() {

		System.out.println("tableRows.size()****************-->" + tableRows.size());

		int targetCol = 0;
		String b = "";

		String[] xxxx = { "新增", "變更公司名稱", "廢止", "註銷", " 註銷", "註消", "變更", "更名", "補列", "修正" };
		for (int m = 0; m < tableRows.size(); m++) {
			MyRow r = (MyRow) tableRows.get(m);

			// --------------------------------------

			String a = r.lines[targetCol].trim();

			for (int n = 0; n < xxxx.length; n++) {
				String result = changePos(a, xxxx[n]);
				if (!result.equals("")) {
					r.lines[targetCol] = result;
					break;
				} else {

				}
			}

			// {
			// b = "";
			// String t = "新增";
			// if (a.startsWith(t)) {
			// b = a.substring(t.length()).trim();
			// if (b.endsWith(".")) {
			// b = b.substring(0, b.length() - 1);
			// }
			// r.lines[targetCol] = b + t;
			// }
			// }
			//
			// {
			// b = "";
			// String t = "廢止";
			// if (a.startsWith(t)) {
			// b = a.substring(t.length()).trim();
			// if (b.endsWith(".")) {
			// b = b.substring(0, b.length() - 1);
			// }
			// r.lines[targetCol] = b + t;
			// }
			// }
			// {
			// b = "";
			// String t = "註銷";
			// if (a.startsWith("註銷") || a.startsWith(" 註銷")) {
			// b = a.substring(t.length()).trim();
			// if (b.endsWith(".")) {
			// b = b.substring(0, b.length() - 1);
			// }
			// r.lines[targetCol] = b + t;
			// }
			//
			// }
			// {
			// b = "";
			// String t = "變更公司名稱";
			// if (a.startsWith(t)) {
			// b = a.substring(t.length()).trim();
			// if (b.endsWith(".")) {
			// b = b.substring(0, b.length() - 1);
			// }
			// r.lines[targetCol] = b + t;
			// }
			//
			// }
			// {
			// b = "";
			// String t = "變更";
			// if (a.startsWith(t)) {
			// b = a.substring(t.length()).trim();
			// if (b.endsWith(".")) {
			// b = b.substring(0, b.length() - 1);
			// }
			// r.lines[targetCol] = b + t;
			// }
			//
			// }
			// {
			// b = "";
			// String t = "更名";
			// if (a.startsWith(t)) {
			// b = a.substring(t.length()).trim();
			// if (b.endsWith(".")) {
			// b = b.substring(0, b.length() - 1);
			// }
			// r.lines[targetCol] = b + t;
			// }
			//
			// }
			//
			// {
			// b = "";
			// String t = "補列";
			// if (a.startsWith(t)) {
			// b = a.substring(t.length()).trim();
			// if (b.endsWith(".")) {
			// b = b.substring(0, b.length() - 1);
			// }
			// r.lines[targetCol] = b + t;
			// }
			//
			// }
			// {
			// b = "";
			// String t = "修正";
			// if (a.startsWith(t)) {
			// b = a.substring(t.length()).trim();
			// if (b.endsWith(".")) {
			// b = b.substring(0, b.length() - 1);
			// }
			// r.lines[targetCol] = b + t;
			// }
			//
			// }

			// ---------------------------------------

			System.out.println("-->" + a + "," + r.lines[targetCol]);
		}

	}

	// public HashMap getResult() {
	// return hm;
	// }

	public ArrayList getResult() {
		return tableRows;
	}

	// public void testWord1() {
	// try {
	// // word 2003： ?片不?被?取
	// InputStream is = new FileInputStream(new File("D:\\sinye.doc"));
	// WordExtractor ex = new WordExtractor(is);
	// String text2003 = ex.getText();
	// System.out.println(text2003);
	// // word 2007 ?片不?被?取， 表格中的?据?被放在字符串的最后
	// OPCPackage opcPackage = POIXMLDocument.openPackage("D:\\sinye.doc");
	// POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
	// String text2007 = extractor.getText();
	// System.out.println(text2007);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	// ******************************************************************************************************

}