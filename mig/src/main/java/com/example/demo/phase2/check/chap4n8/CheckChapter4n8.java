package com.example.demo.phase2.check.chap4n8;

import java.util.ArrayList;

import com.example.demo.MyConst;


public class CheckChapter4n8 {

	public static void run() {

		// Loop 所有 schema
		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.msg[i][2];

			// if (!msgName.equals("N5110"))
			// continue;

			boolean ok = true;

			try {

				ReadChapter8 o = new ReadChapter8();
				o.readin(msgName);
				ArrayList<ItemTblItem> ar = o.getItems();
				// ------------------------------------------------------------
				ReadTreeDoc o2 = new ReadTreeDoc();
				o2.readin(msgName);
				ArrayList<String> arTree = o2.getTree();

				// ------------------------------------------------------------
				for (int k = 0; k < ar.size(); k++) {
					ItemTblItem t = (ItemTblItem) ar.get(k);
					String tblItemChname = t.chName;
					boolean f = false;
					for (int m = 0; m < arTree.size(); m++) {
						String treeChname = (String) arTree.get(m);

						// if (msgName.equals("NX5105") && tblItemChname.equals("專責報關人員代號")) {
						// System.out.println( treeChname);
						// }

						if (treeChname.trim().equals(tblItemChname.trim())) {
							f = true;
							break;
						}
					}

					if (!f) {
						System.err.println(msgName + " 資料項目 " + tblItemChname + " 不在訊息樹狀圖中 !!");
						ok = false;
						break;
					}
				}
				// ------------------------------------------------------------
				for (int m = 0; m < arTree.size(); m++) {
					String treeChname = (String) arTree.get(m);
					boolean f = false;
					for (int k = 0; k < ar.size(); k++) {
						ItemTblItem t = (ItemTblItem) ar.get(k);
						String tblItemChname = t.chName;

						// if (msgName.equals("NX5106") && treeChname.equals("報單號碼")) {
						// System.out.println(tblItemChname);
						// }

						if (tblItemChname.trim().equals(treeChname.trim())) {
							f = true;
							break;
						}
					}

					if (!f) {
						System.err.println(msgName + " 訊息樹狀圖資料項目 " + treeChname + " 不在資料項目表中 !!");
						ok = false;
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}

			if (ok) {
				String p = "00" + (i + 1);
				p = p.substring(p.length() - 2);
				System.out.println(p + "-->\t" + msgName + "\t 資料項目與樹狀圖比對 ok!");
			}
		}

		System.out.println("Done !!");

	}

	public static void main(String[] args) {

		CheckChapter4n8.run();

	}

}
