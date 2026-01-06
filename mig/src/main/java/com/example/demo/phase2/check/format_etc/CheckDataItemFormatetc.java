package com.example.demo.phase2.check.format_etc;


import com.example.demo.MyConst;
import com.example.demo.XmaDB;

public class CheckDataItemFormatetc {

	public static void run() {

		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.msg[i][2];

			// if (!msgName.equals("N5110"))
			// continue;

			boolean ok = true;

			try {

				ReadItemTblDoc o = new ReadItemTblDoc();
				o.readin(msgName);
				ok = o.checkItem();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}

			if (ok){
				String p = "00" + (i + 1);
				p = p.substring(p.length() - 2);
				System.out.println(p+ "-->\t" + msgName + "\t 資料項目表與 DB 比對 ok!");
			}
			else
				System.err.println("---------------------------------------------------------------");
		}

		System.out.println("Done !!");

	}

	public static void main(String[] args) {

		XmaDB db = new XmaDB();
		db.openConnection();

		CheckDataItemFormatetc.run();

		db.closeConnection();
	}

}
