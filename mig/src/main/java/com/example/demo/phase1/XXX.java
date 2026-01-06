package com.example.demo.phase1;

import java.lang.annotation.Annotation;

import com.example.demo.annotations.AAA;
import com.example.demo.annotations.DSREF;

public class XXX {

	public static DSAnnotationRef getSingleAnnotationData(String msgName, Annotation[] annos) {

		DSAnnotationRef o = new DSAnnotationRef();

		for (Annotation a : annos) {

			if (a instanceof DSREF) {

				DSREF vv = (DSREF) a;
				o.uid = vv.uid();
				o.den = vv.den();
				o.cls = vv.cls();
				// o.sample = vv.sam();
				// o.remark = vv.re();
				break;
			}
		}

		String theStr = "";
		for (Annotation a : annos) {
			if (a instanceof AAA) {
				AAA myAnnotation = (AAA) a;
				String[] s = myAnnotation.msg();

				for (int i = 0; i < s.length; i++) {
					// System.out.println(s[i]);

					if (CheckMessage.hasMessage(s[i], msgName)) {
						theStr = s[i];
						break;
					}
				}
			}
		}

		if (theStr.equals("")) {
			return null;
		}

		// System.out.println(theStr);
		String[] seg = theStr.split(",");
		for (int i = 0; i < seg.length; i++) {
			int idx = seg[i].indexOf("=");
			String name = seg[i].substring(0, idx).trim();
			String val = seg[i].substring(idx + 1).trim();
			// System.out.println(name + "---->" + val);

			if (name.equals("car")) {
				o.cardinality = val;
			} else if (name.equals("chn")) {
				o.chn = val;
			} else if (name.equals("boro")) {
				o.boro = val;
			}
		}

		return o;
	}
}
