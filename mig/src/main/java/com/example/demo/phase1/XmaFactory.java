package com.example.demo.phase1;


import com.example.demo.MyConst;

public class XmaFactory {

	static public String current = "";

	static public XmaInterf intf = null;

	XmaInterf getXma() {

		// if (MyMain.ttype.equals(MyMain.Multi)) {
		// return new XmaBigTree();
		// } else

		// System.out.println("GGGGGGXXXXGGGGGGGGGG\n\n"+MyConst.ttype+"\n\n");

		if (current.equals(MyConst.ttype))
			return intf;

		if (MyConst.ttype.equals(MyConst.XML)) {

			intf = new XmaXML();
			return intf;
		} else {

			// System.out.println("GGGGGGGGGGGGGGGG\n\n"+MyConst.ttype+"\n\n");

			intf = new XmaSingle();
			return intf;

		}

	}
}
