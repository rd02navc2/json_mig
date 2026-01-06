package com.example.demo.phase1;

public class Xma {

	static XmaInterf itf = null;

	public Xma() {
		itf = new XmaFactory().getXma();
		System.out.println("~~~~" + itf.getClass().getName());
	}

	public static String addClsEle(String msgName, String clsName, DSAnnotationRef o) {
		itf = new XmaFactory().getXma();
		return itf.addClsCap(msgName, clsName, o);
	}

	public static String addPropEle(String msgName, String propName, DSAnnotationRef o) {
		itf = new XmaFactory().getXma();
		return itf.addPropEle(msgName, propName, o);
	}

	public static String addElementClosing(String msgName, String clsName, DSAnnotationRef o) {
		itf = new XmaFactory().getXma();
		return itf.addClsClosing(msgName, clsName, o);
	}

}
