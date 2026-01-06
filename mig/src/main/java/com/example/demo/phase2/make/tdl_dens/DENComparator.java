package com.example.demo.phase2.make.tdl_dens;

import java.util.Comparator;



public class DENComparator implements Comparator<XmaDen> {
	public int compare(XmaDen o1, XmaDen o2) {
		String s1 = o1.twid;
		String s2 = o2.twid;
		// System.out.println(s1+","+s2);

		int n1 = o1.twid.compareTo(o2.twid);
		// if (n1 != 0) {
		return n1;
		// }

		// return o2.chName.compareTo(o1.chName);

	}

}