package com.example.demo.phase2.make.tdl_dens;

import java.util.ArrayList;
import java.util.Collections;

public class XmaDs {
	// public String twid = "";
	public String sn = "";
	public String chName = "";
	public String enName = "";
	public String chDef = "";
	public String enDef = "";
	public String format = "";

	public String codeRemark = " ";
	public String safe = " ";

	public String sample = " ";
	
	public boolean usedByCustom = false;// 海關有使用
	public boolean usedByControl = false;// 簽審機關有使用

	public ArrayList twids = new ArrayList();
	public ArrayList msgs = new ArrayList();
	public ArrayList itemPath = new ArrayList();

	public ArrayList dens = new ArrayList();
	public ArrayList clsIds = new ArrayList();
	public ArrayList objectClassTerms = new ArrayList();

	public ArrayList propertyTerms = new ArrayList();
	public ArrayList representationTerms = new ArrayList();

	public ArrayList namedComplexTypes = new ArrayList();

	public ArrayList xmlTagNames = new ArrayList();

	// -------------------------------------------------------

	public String getType() {
		if (usedByCustom && !usedByControl)
			return "A";
		else if (!usedByCustom && usedByControl)
			return "B";
		else if (usedByCustom && usedByControl)
			return "C";
		return "";
	}

	// ------------------------------------------------------------
	public boolean hasMsg(String msg) {
		for (int i = 0; i < msgs.size(); i++) {
			String x = (String) msgs.get(i);
			if (x.equals(msg))
				return true;
		}
		return false;
	}

	public void addMsg(String msg) {
		if (hasMsg(msg))
			return;
		msgs.add(msg);
	}

	public void addMsg(ArrayList msgss) {
		for (int i = 0; i < msgss.size(); i++) {
			String msg = (String) msgss.get(i);
			addMsg(msg);
		}
	}

	public String getMsgsStr() {
		String delimiter = " ";// "---"
		Collections.sort(msgs);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < msgs.size(); i++) {
			String x = (String) msgs.get(i);
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

	// ------------------------------------------------------------
	public boolean hasItemPath(String msg) {
		for (int i = 0; i < itemPath.size(); i++) {
			String x = (String) itemPath.get(i);
			if (x.equals(msg))
				return true;
		}
		return false;
	}

	public void addItemPath(String itemP) {
		if (hasItemPath(itemP))
			return;
		itemPath.add(itemP);
	}

	// ------------------------------------------------------------
	// public boolean hasDen(String den) {
	// for (int i = 0; i < dens.size(); i++) {
	// String x = (String) dens.get(i);
	// if (x.equals(den))
	// return true;
	// }
	// return false;
	// }
	//
	// public void addDen(String den) {
	// if (hasDen(den))
	// return;
	// dens.add(den);
	// }
	//
	// public String getDENsStr() {
	// String delimiter = "---";// "---"
	// // Collections.sort(dens);
	// StringBuffer sb = new StringBuffer();
	// for (int i = 0; i < dens.size(); i++) {
	// String x = (String) dens.get(i);
	// sb.append(delimiter);
	// sb.append(x);
	// // sb.append(";");
	// }
	//
	// String r = sb.toString();
	// if (r.startsWith(delimiter))
	// r = r.substring(delimiter.length());
	// // if (r.endsWith(";"))
	// // r = r.substring(0, r.length() - 1);
	// return r;
	// }
	//
	//	
	//	
	//	
	//	
	// -------------------------------------------------------

	public boolean hasTWID(String twid) {
		for (int i = 0; i < twids.size(); i++) {
			String x = (String) twids.get(i);
			if (x.equals(twid))
				return true;
		}
		return false;
	}

	public void addTWID(String twid) {
		if (hasTWID(twid))
			return;
		twids.add(twid);
	}

	public String getTWIDStr() {
		String delimiter = "---";// "---"
		// Collections.sort(clsIds);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < twids.size(); i++) {
			String x = (String) twids.get(i);
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

	//	
	//	
	// // -------------------------------------------------------
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
		// Collections.sort(dens);
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

	// ------------------------------------------------------------
	public boolean hasClassId(String classid) {
		for (int i = 0; i < clsIds.size(); i++) {
			String x = (String) clsIds.get(i);
			if (x.equals(classid))
				return true;
		}
		return false;
	}

	public void addClassId(String classid) {
		if (hasClassId(classid))
			return;
		clsIds.add(classid);
	}

	public String getClassidsStr() {
		String delimiter = "---";// "---"
		// Collections.sort(dens);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < clsIds.size(); i++) {
			String x = (String) clsIds.get(i);
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

	// ------------------------------------------------------------
	public boolean hasDen(String den) {
		for (int i = 0; i < dens.size(); i++) {
			String x = (String) dens.get(i);
			if (x.equals(den))
				return true;
		}
		return false;
	}

	public void addDen(String den) {
		if (hasDen(den))
			return;
		dens.add(den);
	}

	public String getDENsStr() {
		String delimiter = "---";// "---"
		// Collections.sort(dens);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < dens.size(); i++) {
			String x = (String) dens.get(i);
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

	public boolean hasObjectClassTerm(String objectClassTerm) {
		for (int i = 0; i < objectClassTerms.size(); i++) {
			String x = (String) objectClassTerms.get(i);
			if (x.equals(objectClassTerm))
				return true;
		}
		return false;
	}

	public void addObjectClassTerm(String objectClassTerm) {
		if (hasObjectClassTerm(objectClassTerm))
			return;
		objectClassTerms.add(objectClassTerm);
	}

	public String getObjectClassTermStr() {
		String delimiter = "---";// "---"
		// Collections.sort(clsIds);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < objectClassTerms.size(); i++) {
			String x = (String) objectClassTerms.get(i);
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

	// ------------------------------------------------------------
	public boolean hasProperty(String property) {
		for (int i = 0; i < propertyTerms.size(); i++) {
			String x = (String) propertyTerms.get(i);
			if (x.equals(property))
				return true;
		}
		return false;
	}

	public void addProperty(String property) {
		if (hasProperty(property))
			return;
		propertyTerms.add(property);
	}

	public String getPropertiesStr() {
		String delimiter = "---";// "---"
		// Collections.sort(dens);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < propertyTerms.size(); i++) {
			String x = (String) propertyTerms.get(i);
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

	// ------------------------------------------------------------
	public boolean hasRepre(String repre) {
		for (int i = 0; i < representationTerms.size(); i++) {
			String x = (String) representationTerms.get(i);
			if (x.equals(repre))
				return true;
		}
		return false;
	}

	public void addRepre(String repre) {
		if (hasRepre(repre))
			return;
		representationTerms.add(repre);
	}

	public String getRepreStr() {
		String delimiter = "---";// "---"
		// Collections.sort(dens);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < representationTerms.size(); i++) {
			String x = (String) representationTerms.get(i);
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

	public boolean hasNamedComplexTypes(String namedComplexType) {
		for (int i = 0; i < namedComplexTypes.size(); i++) {
			String x = (String) namedComplexTypes.get(i);
			if (x.equals(namedComplexType))
				return true;
		}
		return false;
	}

	public void addNamedComplexType(String namedComplexType) {
		if (hasNamedComplexTypes(namedComplexType))
			return;
		namedComplexTypes.add(namedComplexType);
	}

	public String getNamedComplexTypeStr() {
		String delimiter = "---";// "---"
		// Collections.sort(clsIds);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < namedComplexTypes.size(); i++) {
			String x = (String) namedComplexTypes.get(i);
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

}