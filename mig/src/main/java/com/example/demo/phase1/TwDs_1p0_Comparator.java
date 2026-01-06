package com.example.demo.phase1;

import java.util.Comparator;


public class TwDs_1p0_Comparator implements Comparator<DenSchema> {
	public int compare(DenSchema o1, DenSchema o2) {

		int n1 = o1.uid.compareTo(o2.uid);
		if (n1 != 0) {
			return n1;
		}

		return o1.clsid.compareTo(o2.clsid);

	}

}