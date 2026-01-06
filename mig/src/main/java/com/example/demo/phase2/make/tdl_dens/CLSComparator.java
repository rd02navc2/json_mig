package com.example.demo.phase2.make.tdl_dens;

import java.util.Comparator;



public class CLSComparator implements Comparator<XmaCls> {
	public int compare(XmaCls o1, XmaCls o2) {
		

		int n1 = o1.clsid.compareTo(o2.clsid);
		//if (n1 != 0) {
			return n1;
		//}

		//return o2.chName.compareTo(o1.chName);

	}

}