package com.example.demo.phase2.make.tdl_dens;

import java.util.Comparator;


public class DSComparator implements Comparator<XmaDs> {
	public int compare(XmaDs o1, XmaDs o2) {
//		String s1 = o1.chName;
//		String s2 = o2.chName;
		// System.out.println(s1+","+s2);

		int n1 = o1.sn.compareTo(o2.sn);
		if (n1 != 0) {
			return n1;
		}

		return o2.chName.compareTo(o1.chName);

	}

}