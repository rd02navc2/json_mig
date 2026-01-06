package com.example.demo.phase1;

import com.example.demo.TWDENS_DAO;
import com.example.demo.XmaDB;

public class XmaXML extends XmaInterf {

	public String addClsCap(String msgName, String clsName, DSAnnotationRef o) {
		StringBuffer sb = new StringBuffer();
//		 String className = (clsName.contains("$")) ? clsName.substring(clsName.lastIndexOf("$") + 1) : clsName
//		 .substring(clsName.lastIndexOf(".") + 1);

		String clsXmlName = "";

		XmaDB db = new XmaDB();
		TWDENS_DAO ooo = db.getClsResult(o.cls);

		clsXmlName = ooo.classname;

//		 if(msgName.equals("NX5105")){
//		 System.out.println("className==="+clsName+",clsXmlName="+clsXmlName);
//		 }

		sb.append(getClsEleHead("Single", msgName, clsXmlName));

		return sb.toString();
	}

	// **********************************************************************************************
	public String addClsClosing(String msgName, String clsName, DSAnnotationRef o) {
		String clsXmlName = "";

		// String className = (clsName.contains("$")) ? clsName.substring(clsName.lastIndexOf("$") + 1) : clsName
		// .substring(clsName.lastIndexOf(".") + 1);

		XmaDB db = new XmaDB();
		TWDENS_DAO ooo = db.getClsResult(o.cls);

		clsXmlName = ooo.classname;

		StringBuffer sb = new StringBuffer();
		sb.append("</" + clsXmlName + ">");
		return sb.toString();
	}

	// **********************************************************************************************
	public String addPropEle(String msgName, String propName, DSAnnotationRef o) {
		StringBuffer propSchema = new StringBuffer();
		TWDENS_DAO densds = getPropInfoFromDB(o);
		propSchema.append("<" + densds.xmlTagName + ">");
		propSchema.append(o.sample);
		propSchema.append("</" + densds.xmlTagName + ">");
		return propSchema.toString();
	}

	// **********************************************************************************************
	public String getClsEleHead(String type, String msgName, String clsXmlName) {
		StringBuffer sb = new StringBuffer();
		sb.append("<" + clsXmlName + ">");
		return sb.toString();
	}

}
