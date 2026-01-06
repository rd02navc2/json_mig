package com.example.demo.phase2.make.tdl_dens;

import java.util.ArrayList;
import java.util.Collections;

public class XmaCls  {
	public String clsid = "";
	public String chName = "";
	public String enName = "";
	public String chDef = "";
	public String enDef = "";
	public String objClsTerm = "";
	

//	public boolean usedByCustom = false;// 海關有使用
//	public boolean usedByControl = false;// 簽審機關有使用

//	public ArrayList msgs = new ArrayList();
//	public ArrayList itemPath = new ArrayList();
//	
//	public ArrayList dens = new ArrayList();
//	public ArrayList clsIds = new ArrayList();
//	public ArrayList objectClassTerms = new ArrayList();
//	
//	public ArrayList propertyTerms = new ArrayList();
//	public ArrayList representationTerms = new ArrayList();
//	
//	public ArrayList namedComplexTypes = new ArrayList();
//	
	public ArrayList xmlTagNames = new ArrayList();

	

	// ------------------------------------------------------------
	public boolean hasXmlTagName(String xmlTagName) {
		for (int i = 0; i < xmlTagNames.size(); i++) {
			String x = (String) xmlTagNames.get(i);
			if (x.equals(xmlTagName))
				return true;
		}
		return false;
	}

	public void addXmlTagName(String xmlTagName) {
		if (hasXmlTagName(xmlTagName))
			return;
		xmlTagNames.add(xmlTagName);
	}

	public String getXmlTagNameStr() {
		String delimiter = "---";// "---"
	//	Collections.sort(dens);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < xmlTagNames.size(); i++) {
			String x = (String) xmlTagNames.get(i);
			sb.append(delimiter);
			sb.append(x);
			// sb.append(";");
		}

		String r = sb.toString();
		if (r.startsWith(delimiter))
			r = r.substring(delimiter.length());
		// if (r.endsWith(";"))
		// r = r.substring(0, r.length() - 1);
		return r;
	}

	
	// -------------------------------------------------------

//	@Override
//	public int compareTo(Object o) {
//
//		if (o instanceof XmaCls) {
//			String twid2 = ((XmaCls) o).twid.trim();
//			return this.twid.trim().compareTo(twid2);
//		}
//
//		return 0;
//	}

}