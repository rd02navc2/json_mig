package com.example.demo.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.example.demo.MyConst;

/**
 * 
 * 列出所有關港貿作業代碼以及使用該代碼的訊息
 * 
 */
public class ListCodeReference {

	static HashMap hmp = new HashMap();

	static class ItemTblItem {
		public String chName = "";
		public String enName = "";
		public String format = "";
		public String remark = "";

		public boolean isGroup = false;
		public boolean appearInMappingTree = false;
	}

	public static void readin(String msgName) {
		// String filesname = "N5158_1000310_V06.doc";
		String filesname = MyConst.getMIGpath() + msgName + ".doc";
		POIFSFileSystem fs = null;
		try {
			fs = new POIFSFileSystem(new FileInputStream(filesname));
			// Couldn't close the braces at the end as my site did not allow it
			// to close

			HWPFDocument doc = new HWPFDocument(fs);

			WordExtractor we = new WordExtractor(doc);

			// String[] paragraphs = we.getParagraphText();

			// System.out.println("Word Document has " + paragraphs.length +
			// " paragraphs");

			// for (int i = 0; i < paragraphs.length; i++) {
			// paragraphs[i] = paragraphs[i].replaceAll("\\cM?\r?\n", "");
			// //System.out.println("Length:" + paragraphs[i].length());
			// }

			int cnt = 0;
			String[] fileData = we.getParagraphText();
			String text = "";
			// StringBuffer sb = new StringBuffer();

			ItemTblItem item = new ItemTblItem();

			boolean f = false;
			for (int i = 0; i < fileData.length; i++) {
				text = fileData[i];

				if (text.trim().equals("S0") || text.trim().equals("S1")) {
					f = true;
				}
				if (!f)
					continue;

				// sb.append(text);

				if (text.trim().contains("參照")) {

					int n = text.indexOf("參照");
					text = text.substring(n);

					if (text.endsWith("")) {
						text = text.toString().substring(0, text.toString().length() - 1).trim();
					}

					if (text.endsWith(MyConst.newline)) {
						text = text.toString().substring(0, text.toString().length() - 1).trim();
					}

					// System.out.println(i + "--->" + text);

					if (hmp.containsKey(text)) {
						HashSet st = (HashSet) hmp.get(text);
						st.add(msgName);
					} else {
						HashSet st = new HashSet();
						st.add(msgName);
						hmp.put(text, st);
					}
				}

			}

		} catch (Exception e) {
			System.err.println(e);
			// e.printStackTrace();
		}
	}

	public static void list() {
		Iterator it = hmp.keySet().iterator();

		ArrayList mapKeys = new ArrayList(hmp.keySet());

		Collections.sort(mapKeys);

		// while (it.hasNext()) {
		// String text = (String) it.next();
		for (int j = 0; j < mapKeys.size(); j++) {
			String text = (String) mapKeys.get(j);
			System.out.print(text + "---->");

			HashSet st = (HashSet) hmp.get(text);

			ArrayList a = new ArrayList();
			Object[] ar = st.toArray();
			for (int i = 0; i < ar.length; i++) {
				a.add(ar[i]);
			}
			Collections.sort(a);

			for (int i = 0; i < a.size(); i++) {
				String msgname = (String) a.get(i);
				// System.out.print("\t" + msgname);
				System.out.print(msgname);

				if (i != a.size() - 1) {
					System.out.print("、");
				}

			}

			System.out.println();
		}
	}

	public static void run() {
		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.msg[i][2];

			// System.out.println(msgName + "****************************************");
			readin(msgName);
		}
		System.out.println("****************************************");
		System.out.println("****************************************");
		System.out.println("****************************************");
		System.out.println("****************************************");
		System.out.println("****************************************");
		list();
	}

	public static void main(String[] args) {
		ListCodeReference.run();
	}

}