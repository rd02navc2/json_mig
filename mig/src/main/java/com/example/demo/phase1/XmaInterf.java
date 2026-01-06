package com.example.demo.phase1;

import com.example.demo.TWDENS_DAO;
import com.example.demo.XmaDB;

public abstract class XmaInterf {

	// public abstract boolean hasMachedProps(String msgName, Annotation[] annos);

	public abstract String addClsCap(String msgName, String propName, DSAnnotationRef o);

	public abstract String addPropEle(String msgName, String propName, DSAnnotationRef o);

	public abstract String addClsClosing(String msgName, String clsName, DSAnnotationRef o);

	public TWDENS_DAO getPropInfoFromDB(DSAnnotationRef o) {
		XmaDB db = new XmaDB();
//		XmaPool db = new XmaPool();
		

		String uid = o.uid;
		
//		System.out.println("uid--->"+uid+",  o.den="+ o.den+", n="+o.chn+", cls="+o.cls);
		
		if (o.boro.equals("*")) {
			uid = o.uid + "*";
		}

		TWDENS_DAO densds = db.getDsResult(o.chn, o.den, uid);


		//System.out.println("Pool Loadedcccc, No reload, uid--->"+densds.chName);


		if (densds == null) {
			// System.out.println("rrrrr == null --->" + o.den);
			densds = new TWDENS_DAO();
		}
		return densds;
	}

	// **********************************************************************************************
	static String getNS(String src) {
		String ns = "ds:";
		if (src.equals("TW")) {
			ns = "twds:";
		}
		return ns;
	}



}
