package com.example.demo.phase2.check.mapping_tree;

import java.util.ArrayList;

import com.example.demo.MyConst;

public class CheckTree {

	public static void run() {

		// Loop 所有 schema
		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.getSchemaPath() + MyConst.msg[i][2];

			// if (!msgName.equals("N5110"))
			// continue;
			
			String p = "00" + (i + 1);
			p = p.substring(p.length() - 2);

			boolean f = true;
			try {

				XSOMNavigator_GetTree o = new XSOMNavigator_GetTree(msgName, rootEleName, null);
				o.xsomNavigate(schemaFile);
				ArrayList<MyTreeRow> arSchemaTree = o.getTree();
				// ------------------------------------------------------------
				ReadTreeDoc o2 = new ReadTreeDoc();
				o2.readin(msgName);
				ArrayList<MyTreeRow> arMIGTree = o2.getTree();
				// ------------------------------------------------------------

				if (arSchemaTree.size() != arMIGTree.size()) {
					System.err.println(p + "-->" +msgName + " Error -->" + "SchemaTree lines=" + arSchemaTree.size() + ", MIGTree lines=" + arMIGTree.size());
					f = false;
					break;
				}

				for (int k = 0; k < arSchemaTree.size(); k++) {
					MyTreeRow t = (MyTreeRow) arSchemaTree.get(k);
					MyTreeRow t2 = (MyTreeRow) arMIGTree.get(k);
					String x1 = t.occur + "\t" + t.mc + "\t" + t.classid + "\t" + t.propid + "\t" + t.tree + "\t" + t.chnName;
					String x2 = t2.occur + "\t" + t2.mc + "\t" + t2.classid + "\t" + t2.propid + "\t" + t2.tree + "\t" + t2.chnName;

					if (!x1.equals(x2)) {
						System.err.println(msgName + " row " + k + " No match !!");
						System.err.println("Schema -->[" + x1 + "]");
						System.err.println("MIG ------>[" + x2 + "]");
						System.err.println("------------------------------------------");
						f = false;
						break;
					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}

			
			
			if (f) {
				
				System.out.println(p + "-->" + msgName + "\t\t 訊息樹狀圖 與 Schema 比對 ok!");
			}
		}

		System.out.println("Done !!");

	}

	public static void main(String[] args) {

		CheckTree.run();

	}

}
