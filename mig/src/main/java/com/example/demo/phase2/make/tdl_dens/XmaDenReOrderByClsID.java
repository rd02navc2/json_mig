package com.example.demo.phase2.make.tdl_dens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;



public class XmaDenReOrderByClsID {

	public class X {
		public String classid = "";
		public String den = "";
		public String objcls = "";
		public String namedComplexType = "";
	}

	public XmaDenReOrderByClsID(HashMap denmp) {
		doit(denmp);
	}

	void doit(HashMap denmp) {
		try {

			Iterator it = denmp.keySet().iterator();
			while (it.hasNext()) {
				String uid = (String) it.next();
				XmaDen myDen = (XmaDen) denmp.get(uid);

				// myDen中的4個array --> 1 array of X

				//System.out.println(uid + "--->myDen.clsIds==>>>" + myDen.clsIds.size());

				ArrayList arA = new ArrayList();
				ArrayList arB = new ArrayList();
				ArrayList arTW = new ArrayList();
				for (int i = 0; i < myDen.clsIds.size(); i++) {
					X x = new X();

					x.classid = (String) myDen.clsIds.get(i);
					x.den = (String) myDen.dens.get(i);
					x.objcls = (String) myDen.objectClassTerms.get(i);
					x.namedComplexType = (String) myDen.namedComplexTypes.get(i);

					if (x.classid.startsWith("TW")) {
						arTW.add(x);
					} else if (x.classid.endsWith("A")) {
						arA.add(x);
					} else if (x.classid.endsWith("B")) {
						arB.add(x);
					}
				}

				// re order
				XComparator comp = new XComparator();
				// Collections.sort(all, comp);
				Collections.sort(arTW, comp);
				Collections.sort(arA, comp);
				Collections.sort(arB, comp);

				ArrayList arALL = new ArrayList();
				arALL.addAll(arA);
				arALL.addAll(arB);
				arALL.addAll(arTW);

				//System.out.println(uid + "==>>>" + arALL.size());

				// 1 array of X --> 4 array of myDen
				ArrayList arClssIds = new ArrayList();
				ArrayList arDENs = new ArrayList();
				ArrayList arObjClss = new ArrayList();
				ArrayList arNamedComplexTypes = new ArrayList();

				for (int i = 0; i < arALL.size(); i++) {
					X xx = (X) arALL.get(i);
					arClssIds.add(xx.classid);
					arDENs.add(xx.den);
					arObjClss.add(xx.objcls);
					arNamedComplexTypes.add(xx.namedComplexType);
				}

				myDen.clsIds = arClssIds;
				myDen.dens = arDENs;
				myDen.objectClassTerms = arObjClss;
				myDen.namedComplexTypes = arNamedComplexTypes;
			}
		} catch (Exception e) {
			System.err.println("XmaDenReOrderByClsID Error" + e.toString());
			e.printStackTrace();
		}
	}

	public class XComparator implements Comparator<X> {
		public int compare(X o1, X o2) {
			int n1 = o1.classid.compareTo(o2.classid);
			return n1;

		}

	}
}
