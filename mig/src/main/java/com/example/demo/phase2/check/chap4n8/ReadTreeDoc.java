package com.example.demo.phase2.check.chap4n8;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.example.demo.MyConst;


public class ReadTreeDoc {

	ArrayList<String> ar = new ArrayList<String>();

	public ArrayList<String> getTree() {
		return ar;
	}

	public void readin(String msgName) {

		String fileName = MyConst.getMIGpath() + msgName + ".doc";

		try {
			FileInputStream in = new FileInputStream(fileName);
			POIFSFileSystem pfs = new POIFSFileSystem(in);
			HWPFDocument hwpf = new HWPFDocument(pfs);
			Range range = hwpf.getRange();
			TableIterator it = new TableIterator(range);

			// for each table in the doc
			while (it.hasNext()) {

				Table tb = (Table) it.next();

				// TableRow tr1 = tb.getRow(0);
				// String hit1 = tr1.getCell(0).getParagraph(0).text().trim();
				// System.out.println(msgName
				// +" tb.numRows()="+tb.numRows()+" --->"+ hit1);
				// System.out.println("ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt "+msgName
				// +" tb.numRows()="+tb.numRows());
				// for each row
				boolean f = false;

				int cccount = 1;
				for (int row = 0; row < tb.numRows(); row++) { // for each row in the taable

					TableRow tr = tb.getRow(row);

					String hit = tr.getCell(0).getParagraph(0).text().trim();

					if (hit.endsWith(""))
						hit = hit.substring(0, hit.length() - 1).trim();
					if (hit.equals("　") || hit.equals(""))
						hit = "";

					// if (msgName.equals("N5109")) {
					// System.out.println(msgName + " row=" + row + " --->" + hit);
					// }

					// -------------------------------------------------
					if ((!f && hit.equals("迴圈"))) {
						f = true;
						cccount = 1;
						// System.out.println(msgName + " row=" + row + " --->" + hit);
					}

					if (!f) {
						continue;
					}

					if (cccount == 1) {
						cccount++;
						continue;
					}

					MyTreeRow o = new MyTreeRow();
					{// 迴圈
						String occur = tr.getCell(0).text().trim();
						if (occur.endsWith(""))
							occur = occur.substring(0, occur.length() - 1).trim();
						if (occur.equals("　") || occur.equals(""))
							occur = "";

						// System.out.println(msgName + " row=" + row + " --->" + occur);

						o.occur = occur;
					}
					{// M/C
						String mc = tr.getCell(1).text().trim();
						if (mc.endsWith(""))
							mc = mc.substring(0, mc.length() - 1).trim();
						if (mc.equals("　") || mc.equals(""))
							mc = "";

						// System.out.println(msgName + " row=" + row + " --->" + branch);

						o.mc = mc;
					}
					{// class id
						String classid = tr.getCell(2).text().trim();
						if (classid.endsWith(""))
							classid = classid.substring(0, classid.length() - 1).trim();
						if (classid.equals("　") || classid.equals(""))
							classid = "";

						// System.out.println(msgName + " row=" + row + " --->" + branch);

						o.classid = classid;
					}
					{// property id
						String propid = tr.getCell(3).text().trim();
						if (propid.endsWith(""))
							propid = propid.substring(0, propid.length() - 1).trim();
						if (propid.equals("　") || propid.equals(""))
							propid = "";

						// System.out.println(msgName + " row=" + row + " --->" + branch);

						o.propid = propid;
					}
					{
						String branch = tr.getCell(4).text().trim();
						if (branch.endsWith(""))
							branch = branch.substring(0, branch.length() - 1).trim();
						if (branch.equals("　") || branch.equals(""))
							branch = "";

						// System.out.println(msgName + " row=" + row + " --->" + branch);

						o.tree = branch;
					}
					{
						String branch = tr.getCell(4).text().trim();
						if (branch.endsWith(""))
							branch = branch.substring(0, branch.length() - 1).trim();
						if (branch.equals("　") || branch.equals(""))
							branch = "";

						// System.out.println(msgName + " row=" + row + " --->" + branch);

						o.tree = branch;
					}
					{// 中文名稱
						String chname = tr.getCell(5).text().trim();
						if (chname.endsWith(""))
							chname = chname.substring(0, chname.length() - 1).trim();
						if (chname.equals("　") || chname.equals(""))
							chname = "";

						// System.out.println(msgName + " row=" + row + " --->" + branch);

						chname = chname.replace("\r", ";");
						o.chnName = chname;
					}

					if (o.chnName.equals(""))
						continue;

					if (o.chnName.contains(";")) {
						String[] xxx = o.chnName.split(";");
						for (int nn = 0; nn < xxx.length; nn++) {
							ar.add(xxx[nn]);
						}
					} else {
						ar.add(o.chnName);
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ReadTreeDoc o = new ReadTreeDoc();
		o.readin("N5110");

	}
}