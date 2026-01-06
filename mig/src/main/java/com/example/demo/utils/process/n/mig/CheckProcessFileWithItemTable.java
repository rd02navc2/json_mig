package com.example.demo.utils.process.n.mig;

import java.util.ArrayList;

import com.example.demo.MyConst;

/*
 * 比較資料項目表與過程檔差異
 */
public class CheckProcessFileWithItemTable {

	public static void run() {
		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.msg[i][2];
			run((i + 1), msgName);
		}
	}

	public static void run(int num, String msgName) {
		try {
			// ReadTWDatasetExcel readTWDatasetExcel = new ReadTWDatasetExcel();
			// ArrayList tds = readTWDatasetExcel.getDS();

			// ------------------------------------------------------------------------------------
			// Read MIG item table rows
			ReadItemTblDoc readItemTblDoc = new ReadItemTblDoc();
			ArrayList itemTableData = readItemTblDoc.getContent(msgName);
			// readItemTblDoc.prnOneTableRows();

			// System.out.println("**************************************************");

			// Read Process rows
			ProcessFileReader processFileReader = new ProcessFileReader();
			processFileReader.getContent(msgName);

			ArrayList processFileData = processFileReader.getTableRows();

			// processFileReader.prnOneTableRows();

//			if (msgName.equals("N5301")) {
//			System.out.println("itemTableData.size="+itemTableData.size()+"ize=,processFileData size="+processFileData.size());
//			}
			try {
				for (int i = 0; i < itemTableData.size(); i++) {

					String migChname = (String) itemTableData.get(i);

					X x = (X) processFileData.get(i);
					String processFileChnName = x.newS + "\t" + x.newG + "\t" + x.newE + "\t" + x.newChnName + "\t" + x.newFormat + "\t" + x.newMC;

					// oneTableRows.add(item.sS + "\t" + item.sG + "\t" + item.sE + "\t" + item.chName + "\t" + item.format + "\t" + item.mc);

					if(i>(processFileData.size()-1)){
						throw new RuntimeException("MIG "+migChname+" 超出過程檔長度");
					}
//					if (msgName.equals("N5301")) {
//						System.out.println(i);
//						System.out.println("PRO=" + processFileChnName.trim());
//						System.out.println("MIG=" + migChname.trim());
//						System.out.println(i);
//					}

					if (!processFileChnName.trim().equals(migChname.trim())) {
						System.err.println(msgName + " MIG item " + i);
						System.err.println("MIG-->" + migChname);
						System.err.println("PRO-->" + processFileChnName);
						throw new RuntimeException("Not match");
					}

				}

				for (int i = 0; i < processFileData.size(); i++) {

					String migChname = (String) itemTableData.get(i);

					X x = (X) processFileData.get(i);
					String processFileChnName = x.newS + "\t" + x.newG + "\t" + x.newE + "\t" + x.newChnName + "\t" + x.newFormat + "\t" + x.newMC;

					// oneTableRows.add(item.sS + "\t" + item.sG + "\t" + item.sE + "\t" + item.chName + "\t" + item.format + "\t" + item.mc);

					if (!processFileChnName.trim().equals(migChname.trim())) {
						System.err.println(msgName + " MIG item " + i);
						System.err.println("MIG-->" + migChname);
						System.err.println("PRO-->" + processFileChnName);
						throw new RuntimeException("Not match");
					}

				}
			} catch (Exception e) {
				throw new RuntimeException(msgName + " --->Length Erorr --> " + e.toString());
				// e.printStackTrace();
			}

			System.out.println(num + "-" + msgName + "\t\t\t比較資料項目表與過程檔一致性 ok");
			// System.out.println("-------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {

		// Loop 所有 schema
		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.msg[i][2];
			// if (i==48) {
			CheckProcessFileWithItemTable.run(i, msgName);

			// }
		}

	}
}
