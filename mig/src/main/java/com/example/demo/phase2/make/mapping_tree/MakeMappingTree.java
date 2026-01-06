package com.example.demo.phase2.make.mapping_tree;

import com.example.demo.MyConst;

public class MakeMappingTree {

	// 產製 Excel Mapping trees
	public static void run() {

		// Loop 所有 schema
		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.getSchemaPath() + MyConst.msg[i][2];

			try {

				XSOMNavigator_GenMappingTreeExcel o = new XSOMNavigator_GenMappingTreeExcel(msgName, rootEleName, null);
				o.xsomNavigate(schemaFile);
				o.writefile(MyConst.getMappingTreePath() + "III_" + msgName + "_mappingTree.xls");

				String p = "00" + (i + 1);
				p = p.substring(p.length() - 2);
				System.out.println(p + "-->\t" + msgName + "\t 產製 Mapping tree excel file ok!");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}

		}

	}
}
