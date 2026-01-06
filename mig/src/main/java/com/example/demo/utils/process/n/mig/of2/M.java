package com.example.demo.utils.process.n.mig.of2;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.example.demo.utils.process.n.mig.X;

public class M {

	public M() {
		readXML("0");
	}

	class ZZZ {
		String x = "";
		String y = "";
	}

	public String getOldNewMapRemark(int tblnum, String name) {
		
		
		//System.out.println("pppppp=====>>>>"+tblnum+",,,,"+name);
		
		
		String r = "";
		ArrayList a = (ArrayList) hm.get("tb" + tblnum);
		if(a==null) return "";
		
		for (int i = 0; i < a.size(); i++) {
			ZZZ zzz = (ZZZ) a.get(i);
			if (zzz.x.equals(name)) {
				r = zzz.y;
				break;
			}
		}
		return r;
	}

	HashMap hm = new HashMap();

	public ArrayList readXML(String codeNumber) {
		ArrayList ar = new ArrayList();
		String fileName = "D:/mu20060711/workspace_svn_harmo/關港貿作業資料調和結果/關港貿作業資料調和結果_新舊對照_ 20120925/X.doc";

		try {
			FileInputStream in = new FileInputStream(fileName);
			POIFSFileSystem pfs = new POIFSFileSystem(in);
			HWPFDocument hwpf = new HWPFDocument(pfs);
			Range range = hwpf.getRange();
			TableIterator it = new TableIterator(range);

			if (it == null) {
				System.err.println("\n\nDDDDDDDDDDDDDDWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW----" + codeNumber);
			}

			int tblNum = 0;

			while (it.hasNext()) { // for each table

				String msg = "";
				// tableRows = new ArrayList();

				if (it == null) {
					System.err.println("\n\nDDDDDDDDDDDzzzzzzDDDWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW----" + codeNumber);
				} else {

				}

				Table tb = (Table) it.next();

				// boolean f = false;

				if (tblNum == 0) {
					tblNum++;
					continue;
				}

				System.out.println();
				System.out.println("tblNum=" + tblNum);
				System.out.println();

				for (int row = 0; row < tb.numRows(); row++) {

					TableRow tr = tb.getRow(row);

					// String hit = tr.getCell(0).getParagraph(0).text().trim();
					// // if(msgName.equals("N5109")){
					// // System.out.println(tblNum +" row="+row+" --->"+ hit);
					// // }
					//
					// // -------------------------------------------------
					// if (!f && (hit.trim().equalsIgnoreCase(codeNumber))) {
					// // System.err.println("gggg");
					// f = true;
					// }
					//
					// // if (!f) {
					// // break;
					// // }
					//
					// if (!f) {
					if (row < 2) {
						continue;
					}
					// }
					// ----------------------------------------------------------------

					if (tr.numCells() != 17) {
						System.err.println("tblNum " + tblNum + " only " + tr.numCells() + "cols");
					} else {
						// System.err.println("tblNum "+tblNum+" has " +tr.numCells()+ "cols");
					}
					// ----------------------------------------------------------------

					// X o = new X();

					String x = "", y = "";
					if (tblNum % 3 == 1) {
						x = tr.getCell(4).text().trim();
						y = tr.getCell(11).text().trim();
					} else if (tblNum % 3 == 2) {
						x = tr.getCell(4).text().trim();
						y = tr.getCell(11).text().trim();
					} else if (tblNum % 3 == 0) {
						x = tr.getCell(12).text().trim();
						y = tr.getCell(11).text().trim();
					}

					// System.out.println(line0 + "," + line1 + "," + line2);

					// ----------------------------------------------------------------
					if (y.equalsIgnoreCase(""))
						continue;

					System.out.println("item=" + x + ",y=" + y);

					ZZZ o = new ZZZ();
					o.x = x;
					o.y = y;
					
					
					for(int kk=0;kk<ar.size();kk++){
						ZZZ zzz=(ZZZ)ar.get(kk);
						if(zzz.x.equals(o.x)){
							System.out.println(tblNum+"--->"+o.x+"  repeat !!!!!+>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
						}
					}

					ar.add(o);
				}

				hm.put("tb" + tblNum, ar);

				tblNum++;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

		return ar;
	}

	String trimWhiteSpaces(String s) {
		String x = s;
		x = x.replace("\n", "");
		x = x.replace("\r", "");
		x = x.replace(System.getProperty("line.separator"), "");
		return x;
	}

	public static void main(String[] args) {
		M o = new M();

		o.readXML("0");

	}
}
