package com.example.demo.phase1;


import com.example.demo.MyConst;
import com.example.demo.TWDENS_DAO;
import com.example.demo.XmaDB;

public class XmaSingle extends XmaInterf {

	String clsName = "";

	public String addClsCap(String msgName, String clsName, DSAnnotationRef clsAnno) {

		// System.out.println(clsName);
		this.clsName = clsName;

		StringBuffer sb = new StringBuffer();
		String className = (clsName.contains("$")) ? clsName.substring(clsName.lastIndexOf("$") + 1) : clsName.substring(clsName.lastIndexOf(".") + 1);
		sb.append(getClsEleHead("Single", msgName, className, clsAnno));
		return sb.toString();
	}

	// **********************************************************************************************
	public String addPropEle(String msgName, String propName, DSAnnotationRef o) {
		StringBuffer propBuffer = new StringBuffer();
		propBuffer.append(buildPropSchema("Single", msgName, propName, o, clsName));
		return propBuffer.toString();
	}

	// **********************************************************************************************
	public String addClsClosing(String msgName, String clsName, DSAnnotationRef o) {
		StringBuffer sb = new StringBuffer();
		sb.append("</xsd:sequence></xsd:complexType></xsd:element>");
		return sb.toString();
	}

	// **********************************************************************************************
	public String getClsEleHead(String type, String msgName, String className, DSAnnotationRef o) {
		XmaDB db = new XmaDB();

		TWDENS_DAO r = db.getClsResult(o.cls.trim());// object class

		if (r == null)
			r = new TWDENS_DAO();

		// ---------------------------------------------------

		String car = TTT.getcar(o.cardinality);

		String test = car.trim();
		if (test.equals(""))
			car = "";

		// !!!!!! Note !!!

		StringBuffer sb = new StringBuffer();

		sb.append("<xsd:element name=\"" + r.classname + "\"" + car + ">");
		sb.append(MyConst.newline);
		sb.append("<xsd:annotation>");
		sb.append(MyConst.newline);
		sb.append("<xsd:documentation xml:lang=\"en\">");
		sb.append(MyConst.newline);
		sb.append("<ccts:UniqueID>" + r.classid + o.boro + "</ccts:UniqueID>");
		sb.append(MyConst.newline);
		sb.append("<ccts:Definition>" + r.enDef + "</ccts:Definition>");
		sb.append(MyConst.newline);
		sb.append("<ccts:Cardinality>" + o.cardinality + "</ccts:Cardinality>");
		sb.append(MyConst.newline);
		sb.append("<ccts:ObjectClassTerm>" + o.cls + "</ccts:ObjectClassTerm>");
		sb.append(MyConst.newline);
		sb.append("<" + MyConst.TwNameSpace + ":Remark>" + o.remark + "</" + MyConst.TwNameSpace + ":Remark>");
		sb.append(MyConst.newline);
		sb.append("</xsd:documentation>");
		sb.append(MyConst.newline);
		sb.append("</xsd:annotation>");
		sb.append(MyConst.newline);
		sb.append("<xsd:complexType>");
		sb.append(MyConst.newline);
		sb.append("<xsd:sequence>");
		sb.append(MyConst.newline);

		return sb.toString();
	}

	public String buildPropSchema(String type, String msgName, String propName, DSAnnotationRef anno, String clsName) {
		// DB work

		TWDENS_DAO densds = getPropInfoFromDB(anno);

		if (densds.twid.trim().equals("TW")) {
			System.out.println(densds.den + "--->" + densds.twid + "," + densds.wcoid);
		}

		// --------------------------------------------------------------------------
		// build twds_1p0.xsd

		// System.out.println(clsName+"."+densds.xmlTagName);

		XmaTwXsdBuilder.build(densds, anno);
		// XmaTwClsBuilder.build(densds, o);
		// XmaTwDsBuilder.build(densds, anno);
		// XmaTwDENsBuilder.build(densds, anno);

		// --------------------------------------------------------------------------

		if (densds.representationTerm == null)
			System.out.println(propName + "-->densds.representationTerm==null");

		boolean canRestrict = new XmaUtils().canRestrict(densds);

		boolean isSimple = new XmaUtils().isSimple(densds);

		// --------------------------------------------------------------------------

		StringBuffer sb = new StringBuffer();

		// sb.append(MyConst.newline);
		// sb.append("<xsd:element name=\"" + propName + "\"");
		sb.append("<xsd:element name=\"" + densds.xmlTagName.trim() + "\"");

		//
		String src = densds.src.trim();

		if (!canRestrict) {
			sb.append(" type =\"" + getNS(src) + densds.namedComplexType + "\"");
		}

		//
		String cardi = TTT.getcar(anno.cardinality).trim();
		if (cardi.equals("")) {

		} else {
			cardi = TTT.getcar(anno.cardinality);
		}
		sb.append(cardi); //

		sb.append(">");
		sb.append(MyConst.newline);
		// ---------------------------------------------
		String myUniqueId = anno.uid;
		if (myUniqueId.startsWith("TW")) {

		} else {// uid has no prefix
			if (anno.boro.equals("")) {
				myUniqueId = "WCOID" + myUniqueId;
			} else if (anno.boro.equals("#")) {
				myUniqueId = "WCOID" + myUniqueId + anno.boro;
			} else {
				myUniqueId = myUniqueId + anno.boro;
			}
		}

		// new DENsChecker().check(src, den, densds.objclass, densds.propertyTerm, densds.representationTerm,
		// namedComplexType,
		// xmlTagName);

		// --------------------------------------------
		sb.append("<xsd:annotation>");
		sb.append(MyConst.newline);
		sb.append("<xsd:documentation xml:lang=\"en\">");
		sb.append(MyConst.newline);
		sb.append("<ccts:UniqueID>" + myUniqueId + "</ccts:UniqueID>");
		sb.append(MyConst.newline);
		sb.append("<ccts:DictionaryEntryName>" + anno.den + "</ccts:DictionaryEntryName>");
		sb.append(MyConst.newline);
		sb.append("<ccts:Definition>" + densds.uid_enDef + "</ccts:Definition>");
		sb.append(MyConst.newline);
		sb.append("<ccts:Cardinality>" + anno.cardinality + "</ccts:Cardinality>");
		sb.append(MyConst.newline);
		sb.append("<ccts:ObjectClassTerm>" + densds.objclass + "</ccts:ObjectClassTerm>");
		sb.append(MyConst.newline);
		sb.append("<ccts:PropertyTerm>" + densds.propertyTerm + "</ccts:PropertyTerm>");
		sb.append(MyConst.newline);
		sb.append("<ccts:RepresentationTerm>" + densds.representationTerm + "</ccts:RepresentationTerm>");
		sb.append(MyConst.newline);
		sb.append("<" + MyConst.TwNameSpace + ":ChineseName>" + anno.chn + "</" + MyConst.TwNameSpace + ":ChineseName>");
		// sb.append("<sw:ChineseName>" + anno.chn + "</sw:ChineseName>");
		sb.append(MyConst.newline);
		sb.append("<" + MyConst.TwNameSpace + ":Remark>" + anno.remark + "</" + MyConst.TwNameSpace + ":Remark>");
		sb.append(MyConst.newline);
		sb.append("<" + MyConst.TwNameSpace + ":Format>" + densds.format + "</" + MyConst.TwNameSpace + ":Format>");
		sb.append(MyConst.newline);

		if (type.equals("Multi")) {
			sb.append("<" + MyConst.TwNameSpace + ":chn>" + anno.allRemark + "</" + MyConst.TwNameSpace + ":chn>");
			sb.append(MyConst.newline);
		}
		// sb.append("<sw:chn>" + anno.allRemark + "</sw:chn>");

		sb.append("</xsd:documentation>");
		sb.append(MyConst.newline);
		sb.append("</xsd:annotation>");
		sb.append(MyConst.newline);

		//
		if (canRestrict) {
			sb.append(getRestriction(src, propName, densds.namedComplexType, anno.cardinality, densds.format, densds.codeList, isSimple));
			sb.append(MyConst.newline);
		}

		sb.append("</xsd:element>");
		sb.append(MyConst.newline);

		return sb.toString();
	}

	// **********************************************************************************************
	// Restriction block

	static String getRestrictionHeader(String src, String name, String namedComplexType, String cardinality, String format, String codeList, boolean isSimple) {

		StringBuffer sb = new StringBuffer();

		if (isSimple) {
			sb.append("<xsd:simpleType>");
			sb.append(MyConst.newline);
		} else {
			sb.append("<xsd:complexType>");
			sb.append(MyConst.newline);
			sb.append("<xsd:simpleContent>");
			sb.append(MyConst.newline);
		}

		sb.append("<xsd:restriction base=\"" + //
				getNS(src) + namedComplexType + //
				"\">");
		sb.append(MyConst.newline);

		return sb.toString();
	}

	static String getRestrictionTail(String src, String name, String namedComplexType, String cardinality, String format, String codeList, boolean isSimple) {

		StringBuffer sb = new StringBuffer();

		sb.append("</xsd:restriction>");
		sb.append(MyConst.newline);

		if (isSimple) {
			sb.append("</xsd:simpleType>");
			sb.append(MyConst.newline);
		} else {
			sb.append("</xsd:simpleContent>");
			sb.append(MyConst.newline);
			sb.append("</xsd:complexType>");
			// sb.append(MyConst.newline);
		}
		// sb.append(MyConst.newline);

		return sb.toString();
	}

	static String getRestriction(String src, String name, String namedComplexType, String cardinality, String format, String codeList, boolean isSimple) {

		StringBuffer sb = new StringBuffer();

		sb.append(getRestrictionHeader(src, name, namedComplexType, cardinality, format, codeList, isSimple));

		// if (codeList != null) {
		// if (!codeList.trim().equals("")) {
		// StringTokenizer st = new StringTokenizer(codeList, ";");
		// while (st.hasMoreTokens()) {
		// sb.append("<enumeration value=\"" + st.nextToken() + "\"/>");
		// sb.append(MyConst.newline);
		// }
		// } else {
		// sb.append(TTT.getRestrictionMiddle(src, name, namedComplexType, cardinality, format, codeList));
		// }
		//
		// } else {
		// sb.append(TTT.getRestrictionMiddle(src, name, namedComplexType, cardinality, format, codeList));
		// }

		sb.append(TTT.getRestrictionMiddle(src, name, namedComplexType, cardinality, format, codeList));

		sb.append(getRestrictionTail(src, name, namedComplexType, cardinality, format, codeList, isSimple));

		return sb.toString();
	}
}
