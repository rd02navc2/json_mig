package com.example.demo.phase1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.example.demo.annotations.AAA;

public class Worker {

	String msgName = "NA";

	public Worker(String msgName) {
		this.msgName = msgName;
	}

	// ******************************************************************************************
	public boolean hasMachedProps(Object obj) {

		for (Field f : obj.getClass().getDeclaredFields()) {
			if (f.getModifiers() == 4112)
				continue;

			if (!f.getType().isMemberClass()) {

				// System.out.println(obj.getClass().getName() + "----test -------" + f.getName());

				for (Annotation a : f.getAnnotations()) {
					if (a instanceof AAA) {
						AAA myAnnotation = (AAA) a;

						String[] s = myAnnotation.msg();

						for (int i = 0; i < s.length; i++) {
							// System.out.println(s[i]);
							if (CheckMessage.hasMessage(s[i], msgName)) {
								return true;
							}
						}
					}
				}

			} else {
				try {
					Method mthd = f.getType().getMethod("hasMachedProps", new Class[] {});
					if ((Boolean) mthd.invoke(f.get(obj), new Object[] {}))
						return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public String getSchema(Object obj) {

		if (!hasMachedProps(obj)) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		String clsName = obj.getClass().getName();

		DSAnnotationRef clsAnno = XXX.getSingleAnnotationData(msgName, obj.getClass().getAnnotations());

		if (clsAnno != null) {
			sb.append(Xma.addClsEle(msgName, clsName, clsAnno));// -------------------------cap
		} else {
			throw new RuntimeException(obj.getClass() + " 's property has Message " + msgName //
					+ ", but not annoated on the Class " + obj.getClass().getName());
		}

		//
		//
		//
		for (Field f : obj.getClass().getDeclaredFields()) {

			String gg = f.getName();

			if (f.getModifiers() == 4112) {
				continue;
			}

			if (!f.getType().isMemberClass()) {

				DSAnnotationRef o = XXX.getSingleAnnotationData(msgName, f.getAnnotations());// ----------prop
				if (o != null) {
					sb.append(Xma.addPropEle(msgName, f.getName(), o));
				}

			} else {

				try {
					Method mthd = f.getType().getMethod("getSchema", new Class[] {});
					String xx = (String) mthd.invoke(f.get(obj), new Object[] {});
					// System.out.println(msgName + " --->xx getSchema()---" + xx);

					sb.append(xx);
				} catch (Exception e) {
					System.out.println(msgName + " --->hahahaha getSchema()---" + e);
					e.printStackTrace();
				}
			}
		}
		//
		//
		//

		sb.append(Xma.addElementClosing(msgName, obj.getClass().getName(), clsAnno));// ------------close

		return sb.toString();
	}

}
