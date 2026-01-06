package com.example.demo.phase2.make.tdl_dens;


import com.example.demo.MyConst;
import com.example.demo.phase2.KeyMaker;

public class MakeTDLDENs {

	public static void run() {
		// Loop 所有 schema
		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.getSchemaPath() + MyConst.msg[i][2];

			// ------------------------------------------------------
			// 1.
			// 收集 TDL, DENs 資料, 還不寫檔
			try {
				XSOMNavigator_GenTDL_DENs o = new XSOMNavigator_GenTDL_DENs(msgName, rootEleName, null);
				o.xsomNavigate(schemaFile);
				String p = "00" + (i + 1);
				p = p.substring(p.length() - 2);
				System.out.println(p + "-->\t" + msgName + "\t 產製 TDL DENs ok!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}

		}

		// --------------------------------------------------------------------------
		// 寫 TDL_DENs.xls

		String versionFolder = KeyMaker.newKey() + "/";

		WriteTDLDENsExcel excelTDL_DENs = new WriteTDLDENsExcel();

		excelTDL_DENs.setOutputFile(MyConst.getTDLDensPath());
		excelTDL_DENs.createDataSetExcel();

		(new XSOMNavigator_GenTDL_DENs()).writeToFile();

		excelTDL_DENs.closeDataSetExcel();
	}
}
