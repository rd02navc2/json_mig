package com.example.demo.phase2.make.item_desc_tbl;

import com.example.demo.MyConst;

public class MakeItemDescTemplate {

	public static void run() {
		// Loop 所有 schema
		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.msg[i][2];

			ReadItemTblDoc readItemTblDoc = new ReadItemTblDoc();
			readItemTblDoc.readin(msgName);
			
			// ------------------------------------------------------
			// Write Data Item Table template of one message
			Worker4ItemDescription dd = new Worker4ItemDescription(msgName);

			try {
				dd.openDoc();

				XSOMNavigator_itemDesc_from_xsd o = new XSOMNavigator_itemDesc_from_xsd(msgName, rootEleName, dd);
				o.xsomNavigate(MyConst.getSchemaPath() + "maindoc/" + msgName + ".xsd");

				String p = "00" + (i + 1);
				p = p.substring(p.length() - 2);
				System.out.println(p+"-->\t"+msgName + "\t 產製資料項目使用說明模板ok");
			} catch (Exception e) {
				System.err.println("\n\n\n EEEERRRRRR====>" + msgName);
				e.printStackTrace();
			} finally {
				dd.closeDoc();

				dd = null;
			}
		}
	}
}
