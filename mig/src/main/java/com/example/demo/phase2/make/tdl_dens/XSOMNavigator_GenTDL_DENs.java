package com.example.demo.phase2.make.tdl_dens;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.xml.parsers.SAXParserFactory;

import com.example.demo.TWDENS_DAO;
import com.example.demo.XmaDB;
import com.example.demo.phase2.AnnotationDAO;
import com.example.demo.phase2.AnnotationFactory;
import com.example.demo.phase2.make.data_item_set.ReadWCOBaseExcel;
import com.example.demo.phase2.make.data_item_set.WCOBaseClass;
import com.example.demo.phase2.make.data_item_set.WCOBaseDens;
import com.sun.xml.xsom.XSAnnotation;
import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSModelGroup;
import com.sun.xml.xsom.XSModelGroupDecl;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSSimpleType;
import com.sun.xml.xsom.XSTerm;
import com.sun.xml.xsom.parser.XSOMParser;

/**
 * 
 * 主程式是 build(...)
 * 
 */
public class XSOMNavigator_GenTDL_DENs {

	public String rootEle = "";
	// public PrintWriter out = null;

	// public BufferedWriter out = null;

	String msgName = "";

	// HashMap msgInfo = new HashMap();

	ArrayList arWCODens = new ArrayList();
	ArrayList arWCOClass = new ArrayList();

	public XSOMNavigator_GenTDL_DENs() {

	}

	public XSOMNavigator_GenTDL_DENs(String msgName, String rootEle, BufferedWriter out) {
		this.rootEle = rootEle;
		// this.out = out;
		this.msgName = msgName;
	}

	private void printGroup(XSModelGroup modelGroup, String occurs, String absPath, String indent) throws IOException {
		// out.println(indent + "[Start of " + modelGroup.getCompositor() +
		// occurs
		// + "]");

		for (XSParticle particle : modelGroup.getChildren()) {// Many particles
			// printParticle(particle, occurs, absPath, indent + "\t");
			printParticle(particle, occurs, absPath, indent);
		}

		// out.println(indent + "[End of " + modelGroup.getCompositor() + "]");
	}

	private void printGroupDecl(XSModelGroupDecl modelGroupDecl, String occurs, String absPath, String indent) throws IOException {
		// out.write(indent + "[Group " + modelGroupDecl.getName() + occurs + "]");
		printGroup(modelGroupDecl.getModelGroup(), occurs, absPath, indent);
	}

	String myoccurs = "";

	private void printParticle(XSParticle particle, String occurs, String absPath, String indent) throws IOException {
		// no need to pass in "occurs"
		// occurs = "  MinOccurs = " + particle.getMinOccurs() +
		// ", MaxOccurs = " + particle.getMaxOccurs();

		// String max = (particle.getMaxOccurs() == -1) ? "*" : ("" + particle.getMaxOccurs());
        BigInteger maxOccurs = particle.getMaxOccurs();
        String max = (maxOccurs.equals(BigInteger.valueOf(-1)) || 
                maxOccurs.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) 
                ? "*" 
                : maxOccurs.toString();
       
        occurs = particle.getMinOccurs() + "-" + max;

		myoccurs = particle.getMinOccurs() + "-" + max;

		// System.out.println(occurs);

		XSTerm term = particle.getTerm();

		if (term.isModelGroup()) {
			printGroup(term.asModelGroup(), occurs, absPath, indent);// !!!!!!!!!!!
		} else if (term.isModelGroupDecl()) {
			printGroupDecl(term.asModelGroupDecl(), occurs, absPath, indent);
		} else if (term.isElementDecl()) {
			printElement(term.asElementDecl(), occurs, absPath, indent);
		} else {

		}
	}

	private void printComplexType(XSComplexType complexType, String occurs, String absPath, String indent) throws IOException {
		XSParticle particle = complexType.getContentType().asParticle();
		if (particle != null) {
			printParticle(particle, occurs, absPath, indent);
		}
	}

	private void printSimpleType(XSSimpleType simpleType, String occurs, String absPath, String indent) {
		SimpleTypeRestriction restriction = new SimpleTypeRestriction();
		restriction.initRestrictions(simpleType);
		// System.out.println(restriction.toString());
	}

	String CurrentObjectClass = "N/A";

	// scan each element in schema
	private void printElement(XSElementDecl element, String occurs, String absPath, String indent) throws IOException {
		String delimiter = "__";
		if (rootEle.equals(element.getName()))
			absPath = element.getName();
		else
			absPath += delimiter + element.getName() + "[" + occurs + "]";

		// --------------------------------------------------------------------------------------
		AnnotationDAO a = null;
		XSAnnotation xsAnnotation = element.getAnnotation();
		if (xsAnnotation == null) {
			System.out.println(" Errror --> No Annotation ");
			// throw new RuntimeException("!! No Annotation !! --->" +
			// "[Element " + absPath + "]");
			a = new AnnotationDAO();
		} else {
			a = (AnnotationDAO) xsAnnotation.getAnnotation();
		}

		// --------------------------------------------------------------------------------------

		if (a.ObjectClassTerm != null & a.PropertyTerm == null) {// This is a class

			a.isClass = true;

			String objCls = a.ObjectClassTerm;

			TWDENS_DAO densds = new XmaDB().getClsResult(objCls);
			if (densds == null) {
				System.err.println(this.getClass().getName() + "XmaDB().getClsResult == null --->" + a.ObjectClassTerm);
				// densds = new TWDENS_DAO();
			} else {
				// System.err.println("objClsobjClsobjCls==="+objCls+","+densds.classid+","+densds.xmlTagName+","+densds.chName);

				saveClassInfo2(densds.classid, densds.xmlTagName, densds);

				CurrentObjectClass = densds.objclass;
			}

			// *****************************************************************************

		} else if (a.ObjectClassTerm != null & a.PropertyTerm != null) {// This is a property

			if (!CurrentObjectClass.equals(a.ObjectClassTerm)) {
				System.err
						.println("CurrentObjectClass=" + CurrentObjectClass + ", But property's class is " + a.ObjectClassTerm + "--->" + msgName + "," + a.DictionaryEntryName + "," + a.chineseName);
			}

			a.isClass = false;

			if (a.DictionaryEntryName == null) {
				throw new RuntimeException("!!NO DEN!! --->" + "[Element " + absPath + "]");
			}

			// System.out.println(a.chineseName + ":" + absPath);

			// --------------------------------------------------------------------------

			String uidd = a.UniqueID;
			if (uidd.endsWith("#") || uidd.endsWith("+")) {
				uidd = uidd.substring(0, uidd.length() - 1);
			}

			// if (!a.chineseName.startsWith("*") && !a.chineseName.contains(";")) {//一般的資料項目, 以及"*...類別代碼" 之TypeCode
			if (!a.chineseName.contains(";")) {// 一般的資料項目
				TWDENS_DAO densds = new XmaDB().getDsResult(a.chineseName, a.DictionaryEntryName, uidd);
				if (densds == null) {
					System.out.println(this.getClass().getName() + "XmaDB().getDsResult == null --->" + a.chineseName + "," + a.DictionaryEntryName);
					densds = new TWDENS_DAO();
				}

				build(a, densds, absPath);

			} else if (a.chineseName.contains(";")) {// 多個資料項目共用一節點, 以;分隔
				// System.out.println(a.chineseName + "," + a.remark);

				StringTokenizer st = new StringTokenizer(a.chineseName, ";");
				while (st.hasMoreTokens()) {
					String realds = st.nextToken();
					// System.out.println("---->" +realds);
					a.chineseName = realds;
					TWDENS_DAO densds = new XmaDB().getDsResult(a.chineseName, a.DictionaryEntryName, uidd);
					if (densds == null) {
						System.out.println(this.getClass().getName() + "XmaDB().getDsResult --->" + a.chineseName + "," + a.DictionaryEntryName);
						densds = new TWDENS_DAO();
					}
					build(a, densds, absPath);
				}
			}

		} else {
			// throw new RuntimeException("!!Wrong Annotation!! --->" +
			// "[Element " + absPath + "]");
		}

		// ----------------------------------------------------------------------
		if (element.getType().isComplexType()) {
			printComplexType(element.getType().asComplexType(), occurs, absPath, indent);
		} else {
			printSimpleType(element.getType().asSimpleType(), occurs, absPath, indent);
		}
	}

	public void xsomNavigate(String xsdFile) {

		String occurs = "";
		String absPath = "";
		String indent = "";

		// System.out.println("rootEle===>>>"+rootEle+","+xsdFile);

		try {
			// XSOMParser parser = new XSOMParser();

			SAXParserFactory saxFactory = SAXParserFactory.newInstance();
			saxFactory.setNamespaceAware(true);

			XSOMParser parser = new XSOMParser(saxFactory);

			parser.setAnnotationParser(new AnnotationFactory());
			
			// System.out.println("11111222");
			parser.parse(xsdFile);
			// System.out.println("111119999");
			printElement(parser.getResult().getSchema(1).getElementDecl(rootEle),//
					occurs,//
					absPath,//
					indent);
		} catch (Exception exp) {
			exp.printStackTrace(System.out);
		}
	}

	// ***********************************************************************************
	static HashMap clsmp = new HashMap();
	static HashMap dsmp = new HashMap();
	static HashMap denmp = new HashMap();

	boolean hasClsEntry(String key) {
		if (clsmp.containsKey(key))
			return true;
		return false;
	}

	boolean hasDsEntry(String key) {
		if (dsmp.containsKey(key))
			return true;
		return false;
	}

	boolean hasDenEntry(String key) {
		if (denmp.containsKey(key))
			return true;
		return false;
	}

	void remarkDs(AnnotationDAO a, TWDENS_DAO densds, String absPath) {
		String sn = densds.sn;
		String chineseName = a.chineseName;
		String uid = a.UniqueID;
		String remark = a.remark;

		String den = a.DictionaryEntryName;

		String codeList = densds.codeList;

		String classid = densds.classid;

		String objectClassTerm = densds.objclass;
		String propertyTerm = densds.propertyTerm;
		String representationTerm = densds.representationTerm;
		String namedComplexType = densds.namedComplexType;
		String xmlTagName = densds.xmlTagName;
		
		String sample = densds.sample;

		if (chineseName.startsWith("*"))
			return;

		if (hasDsEntry(chineseName)) {
			XmaDs myDs = (XmaDs) dsmp.get(chineseName);

			// ---------------------------------------------
			myDs.addMsg(msgName);
			myDs.addTWID(uid);

			// String sss = den + "(" + classid + "," + uid + ")";
			// myDs.addItemPath(msgName + "[" + msgInfo.get(msgName) + "]" + "\t" + sss + "\t" + absPath);

			//
			myDs.addClassId(classid);
			myDs.addDen(den);
			myDs.addObjectClassTerm(objectClassTerm);
			myDs.addProperty(propertyTerm);
			myDs.addRepre(representationTerm);
			myDs.addNamedComplexType(namedComplexType);
			myDs.addXmlTagName(xmlTagName);
			
			myDs.sample=sample;
			
		} else {
			XmaDs myDs = new XmaDs();

			myDs.chName = chineseName;
			myDs.sn = sn;

			myDs.enName = densds.enName;
			myDs.chDef = densds.chDef;
			myDs.enDef = densds.enDef;
			myDs.format = densds.format;
			myDs.codeRemark = densds.codeList;
			// ---------------------------------------------
			myDs.addMsg(msgName);
			myDs.addTWID(uid);

			// String sss = den + "(" + classid + "," + uid + ")";
			// myDs.addItemPath(msgName + "[" + msgInfo.get(msgName) + "]" + "\t" + sss + "\t" + absPath);

			myDs.addDen(den);
			myDs.addNamedComplexType(namedComplexType);

			myDs.addClassId(classid);
			myDs.addDen(den);
			myDs.addObjectClassTerm(objectClassTerm);
			myDs.addProperty(propertyTerm);
			myDs.addRepre(representationTerm);
			myDs.addNamedComplexType(namedComplexType);
			myDs.addXmlTagName(xmlTagName);

			myDs.sample=sample;
			dsmp.put(chineseName, myDs);
		}

	}

	// 主程式
	public void build(AnnotationDAO a, TWDENS_DAO densds, String absPath) {

		if (a.UniqueID.startsWith("WCOID")) {
			a.UniqueID = a.UniqueID.substring(5);
		}

		// System.out.println(densds.sn+"---"+densds.chName);

		// String sn = densds.sn;

		String chineseName = a.chineseName;
		String uid = a.UniqueID;

		// String remark = a.remark;

		String den = a.DictionaryEntryName;
		String src = densds.src;
		String objectClassTerm = densds.objclass;
		String propertyTerm = densds.propertyTerm;
		String representationTerm = densds.representationTerm;
		String namedComplexType = densds.namedComplexType;
		String xmlTagName = densds.xmlTagName;

		String classid = densds.classid;
		String classXmlName = densds.classname;
		String cls_chName = densds.cls_chName;
		String cls_chDef = densds.cls_chDef;
		String cls_enName = densds.cls_enName;
		String cls_enDef = densds.cls_enDef;

		String codelist = densds.codeList;

		String sample = densds.sample;
		
		
		if (uid.endsWith("+") || uid.endsWith("#")) {
			uid = uid.substring(0, uid.length() - 1);
		}

		// if (classid.trim().equals("TW43A") || classid.trim().equals("TW53A")) {
		// System.err.println("classXmlName=" + classXmlName);
		// }

		// ******************************************************************
		// *************************Check DENs*******************************
		// ******************************************************************
		// if(den.contains("On Board")){
		// System.err.println(den+"======>>>>>"+namedComplexType);
		// }

		// if(msgName.contains("5205")){
		// System.err.println(den+"======>>>>>"+namedComplexType);
		// }
		new DENsChecker().check(src, den, objectClassTerm, propertyTerm, representationTerm, namedComplexType, xmlTagName);

		// ******************************************************************

		// *************************DS Part*********************************
		// ******************************************************************

		remarkDs(a, densds, absPath);

		// ******************************************************************
		// *************************DENs Part*********************************
		// ******************************************************************

		if (hasDenEntry(uid)) { // i.e. this DEN is not new, already found in previous scanned schemas
			XmaDen myDen = (XmaDen) denmp.get(uid);

			// ---------------------------------------------
			myDen.addChName(chineseName);
			myDen.addClassId(classid);
			myDen.addDen(den);
			myDen.addObjectClassTerm(objectClassTerm);
			myDen.addProperty(propertyTerm);
			myDen.addRepre(representationTerm);
			myDen.addNamedComplexType(namedComplexType);
			myDen.addXmlTagName(xmlTagName);
		} else {

			// System.out.println("GGGGGGGGGGGGG------SSSSSSSSSS" + densds.uid_enName);
			// System.out.println(densds.chName);
			XmaDen myDen = new XmaDen();

			myDen.twid = uid;

			// myDen.chName = densds.chName;
			myDen.enName = densds.uid_enName;// .enName;
			// myDs.chDef = densds.chDef;
			myDen.enDef = densds.uid_enDef;// .enDef;
			// myDs.format = densds.format;
			// ---------------------------------------------
			// myDs.addMsg(msgName);
			// myDs.addItemPath(msgName + "\t" + absPath);
			myDen.addChName(chineseName);
			// ---------------------------------------------

			myDen.addClassId(classid);
			myDen.addDen(den);
			myDen.addObjectClassTerm(objectClassTerm);
			myDen.addProperty(propertyTerm);
			myDen.addRepre(representationTerm);
			myDen.addNamedComplexType(namedComplexType);
			myDen.addXmlTagName(xmlTagName);

			denmp.put(uid, myDen);
		}
		// ******************************************************************
		// *************************Class Part*********************************
		// ******************************************************************

		saveClassInfo(classid, classXmlName, densds);

	}

	public void saveClassInfo(String classid, String classXmlName, TWDENS_DAO densds) {
		if (hasClsEntry(classid)) {

			XmaCls myCls = (XmaCls) clsmp.get(classid);

			// ---------------------------------------------
			myCls.addXmlTagName(classXmlName);
		} else {

			// System.out.println(densds.chName);
			XmaCls myCls = new XmaCls();
			// myCls = chineseName;
			myCls.clsid = densds.classid;

			myCls.enName = densds.cls_enName;
			if (myCls.enName.contains(" ")) {
				System.err.println("Class name -->" + myCls.enName + "<-- has space !!!");
				myCls.enName = myCls.enName.replace(" ", "");
			}
			myCls.objClsTerm = densds.objclass;
			myCls.chDef = densds.cls_chDef;
			myCls.enDef = densds.cls_enDef;
			myCls.chName = densds.cls_chName;
			// ---------------------------------------------
			myCls.addXmlTagName(classXmlName); // myDs.addDen(den);
			// myDs.addNamedComplexType(namedComplexType);

			clsmp.put(classid, myCls);
		}
	}

	public void saveClassInfo2(String classid, String classXmlName, TWDENS_DAO densds) {
		if (hasClsEntry(classid)) {

			XmaCls myCls = (XmaCls) clsmp.get(classid);

			// ---------------------------------------------
			myCls.addXmlTagName(classXmlName);
		} else {

			// System.out.println(densds.chName);
			XmaCls myCls = new XmaCls();
			// myCls = chineseName;
			myCls.clsid = densds.classid;

			myCls.enName = densds.enName;
			if (myCls.enName.contains(" ")) {
				System.err.println("Class name -->" + myCls.enName + "<-- has space !!!");
				myCls.enName = myCls.enName.replace(" ", "");
			}
			myCls.objClsTerm = densds.objclass;
			myCls.chDef = densds.chDef;
			myCls.enDef = densds.enDef;
			myCls.chName = densds.chName;
			// ---------------------------------------------
			myCls.addXmlTagName(classXmlName); // myDs.addDen(den);
			// myDs.addNamedComplexType(namedComplexType);

			clsmp.put(classid, myCls);
		}
	}

	public void writeToFile() {
		// clearFile();

		// =================================================================
		// =================================================================
		// Write ds sheet
		{
			ArrayList all = new ArrayList();

			Iterator it = dsmp.keySet().iterator();

			// System.out.println("-------" + dsmp.size());

			while (it.hasNext()) {
				String chName = (String) it.next();

				// System.out.println(chName);

				XmaDs myDs = (XmaDs) dsmp.get(chName);

				// checkForCustom(myDs);
				// checkForControl(myDs);

				all.add(myDs);
			}

			DSComparator comp = new DSComparator();
			Collections.sort(all, comp);

			// write data set
			{
				// BufferedWriter out = null;
				try {

					new WriteTDLDENsExcel().writeDataSetToExcelFileTitle();// write DS sheet title
					for (int i = 0; i < all.size(); i++) {
						XmaDs myDs = (XmaDs) all.get(i);
						// writeDataSetToFile(i, myDs, out);
						new WriteTDLDENsExcel().writeDataSetToExcelFile(i, myDs);// write DS sheet data
					}

				} catch (Exception e) {
					System.err.println("Error: " + e.getMessage());
					e.printStackTrace();
				} finally {
					// try {
					// // out.close();
					// } catch (IOException e) {
					// e.printStackTrace();
					// }
				}
			}

		}

		// =================================================================
		// write dens sheet, firstly re-order DENs by classid
		{

			// System.out.println("BBBBBBBBBBBBBBBBB=="+denmp.size());
			XmaDenReOrderByClsID x = new XmaDenReOrderByClsID(denmp);
		}

		// write dens sheet
		{
			// ArrayList all = new ArrayList();
			ArrayList allNoStar = new ArrayList();
			ArrayList allStar = new ArrayList();

			Iterator it = denmp.keySet().iterator();
			while (it.hasNext()) {
				String uid = (String) it.next();
				XmaDen myDen = (XmaDen) denmp.get(uid);

				// ---------------------------------
				// 分辨通關使用或簽審使用
				// checkForCustom(myDs);
				// checkForControl(myDs);
				// ---------------------------------

				// all.add(myDen);

				if (!myDen.twid.endsWith("*")) {
					allNoStar.add(myDen);
				} else {
					allStar.add(myDen);
				}
			}

			DENComparator comp = new DENComparator();
			// Collections.sort(all, comp);
			Collections.sort(allNoStar, comp);
			Collections.sort(allStar, comp);
			//
			// for (int i = 0; i < all.size(); i++) {
			// XmaDen myDen = (XmaDen) all.get(i);
			// writeDENsToFile(i, myDen);
			// }

			ArrayList all2 = new ArrayList();
			all2.addAll(allNoStar);
			all2.addAll(allStar);

			new WriteTDLDENsExcel().writeDENsToFileTitles();
			for (int i = 0; i < all2.size(); i++) {
				XmaDen myDen = (XmaDen) all2.get(i);
				new WriteTDLDENsExcel().writeDENsToFile(i, myDen);
			}
		}

		// =================================================================
		// write class sheet
		{
			ArrayList all = new ArrayList();
			ArrayList allA = new ArrayList();
			ArrayList allB = new ArrayList();
			ArrayList allTW = new ArrayList();

			Iterator it = clsmp.keySet().iterator();

			// System.out.println("-------" + denmp.size());

			while (it.hasNext()) {
				String uid = (String) it.next();

				// System.out.println(chName);

				XmaCls myCls = (XmaCls) clsmp.get(uid);

				// checkForCustom(myDs);
				// checkForControl(myDs);

				if (myCls.clsid.startsWith("TW")) {
					allTW.add(myCls);
				} else if (myCls.clsid.endsWith("A")) {
					allA.add(myCls);
				} else if (myCls.clsid.endsWith("B")) {
					allB.add(myCls);
				}

			}

			CLSComparator comp = new CLSComparator();
			Collections.sort(allA, comp);
			Collections.sort(allB, comp);
			Collections.sort(allTW, comp);

			all.addAll(allA);
			all.addAll(allB);
			all.addAll(allTW);

			{
				try {
					new WriteTDLDENsExcel().writeClassToFileTitles();
					for (int i = 0; i < all.size(); i++) {
						XmaCls myCls = (XmaCls) all.get(i);
						new WriteTDLDENsExcel().writeClassToFile(i, myCls);
					}
				} catch (Exception e) {
					System.err.println("Error: " + e.getMessage());
					e.printStackTrace();
				} finally {
					try {
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			// =================================================================
			// Read WCO DENs & Class, Mark ones that used by TW
			// =================================================================
			try {
				ReadWCOBaseExcel wcobase = new ReadWCOBaseExcel("");
				wcobase.readWCODens();

				arWCODens = wcobase.getWcoDENs();
				findUsedDens();

				arWCOClass = wcobase.getWcoCls();
				findUsedCls();

			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// =================================================================
			// write WCO DENs sheet
			try {
				new WriteTDLDENsExcel().writeWCO_DENsToFileTitles();
				for (int i = 0; i < arWCODens.size(); i++) {
					WCOBaseDens x = (WCOBaseDens) arWCODens.get(i);
					new WriteTDLDENsExcel().writeWCO_DENsToFile(i, x);
				}
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// =================================================================
			// write WCO Class sheet
			try {
				new WriteTDLDENsExcel().writeWCO_ClassToFileTitles();
				for (int i = 0; i < arWCOClass.size(); i++) {
					WCOBaseClass myCls = (WCOBaseClass) arWCOClass.get(i);
					new WriteTDLDENsExcel().writeWCO_ClassToFile(i, myCls);
				}
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	void findUsedCls() {
		for (int i = 0; i < arWCOClass.size(); i++) {
			WCOBaseClass o = (WCOBaseClass) arWCOClass.get(i);
			o.usedByTW = "";
			Iterator it = clsmp.keySet().iterator(); // Classes used in this project
			while (it.hasNext()) {
				String uid = (String) it.next();
				XmaCls myCls = (XmaCls) clsmp.get(uid);
				if (myCls.clsid.equals(o.wcoid)) {
					o.usedByTW = "V";
					break;
				}
			}
		}
	}

	void findUsedDens() {
		for (int i = 0; i < arWCODens.size(); i++) {
			WCOBaseDens o = (WCOBaseDens) arWCODens.get(i);

			o.usedByTW = "";
			Iterator it = denmp.keySet().iterator(); // DENs used in this project
			while (it.hasNext()) {
				String uid = (String) it.next();
				XmaDen myDen = (XmaDen) denmp.get(uid);
				if (myDen.twid.equals(o.wcoid)) {
					o.usedByTW = "V";
					break;
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {

	}
}
