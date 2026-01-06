package com.example.demo.phase1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;


import com.example.demo.MyConst;
import com.example.demo.TWDENS_DAO;

public class XmaTwXsdBuilder {

	// static HashMap twDSXsdMap = new HashMap();

	static ArrayList twDSXsdArray = new ArrayList();
	static ArrayList twDSXsdArray_WCO = new ArrayList();
	static ArrayList twDSXsdArray_TW = new ArrayList();

	// static HashSet twDSSet = new HashSet();

	// static boolean hasDEN(String den) {
	//
	// if (twDSXsdMap.containsKey(den))
	// return true;
	// return false;
	//
	// }

	static boolean hasDEN(String den) {
		for (int i = 0; i < twDSXsdArray.size(); i++) {
			DenSchema d = (DenSchema) twDSXsdArray.get(i);
			// System.out.println("tw den==>" + den);
			if (den.equals(d.den)) {
				return true;
			}
		}
		return false;
	}

	// public static void buildAll() {
	// // ArrayList denDAOs=new ArrayList();
	// DB_Query db_Query = new DB_Query();
	// db_Query.openConnection();
	// ArrayList dens = db_Query.getAllDirectoryEntryNames();
	// for (int i = 0; i < dens.size(); i++) {
	// String den = (String) dens.get(i);
	//
	// TWDENS_DAO densds = db_Query.getDsResult(den);
	// // denDAOs.add(densds);
	//
	// if (densds == null) {
	// System.out.println("null -->" + den);
	// continue;
	//
	// }
	//
	// build(densds);
	// }
	// db_Query.closeConnection();
	// }

	public static void build(TWDENS_DAO densds, DSAnnotationRef anno) {
		build(densds);
	}

	public static void build(TWDENS_DAO densds) {

		if (!densds.twid.startsWith("TW")) {

			if (!densds.twid.endsWith("*") && !densds.twid.endsWith("+") && !densds.twid.endsWith("#")) {
				densds.twid = "WCOID" + densds.twid;
			} else {

			}

		}

		if (hasDEN(densds.den))
			return;

		if (!densds.src.equals("TW"))
			return;

		try {

			boolean isSimpleType = new XmaUtils().isSimple(densds);

			StringBuffer sb = new StringBuffer();

			if (isSimpleType) {
				sb.append(MyConst.newline);
				sb.append("<xsd:simpleType name=\"" + densds.namedComplexType + "\">");
				sb.append(MyConst.newline);
				sb.append("<xsd:annotation>");
				sb.append(MyConst.newline);
				sb.append("<xsd:documentation xml:lang=\"en\">");
				sb.append(MyConst.newline);
				sb.append("<ccts:UniqueID>" + densds.twid + "</ccts:UniqueID>");
				sb.append(MyConst.newline);
				sb.append("<ccts:DictionaryEntryName>" + densds.den + "</ccts:DictionaryEntryName>");
				sb.append(MyConst.newline);
				sb.append("<ccts:Definition>" + densds.uid_enDef + "</ccts:Definition>");
				sb.append(MyConst.newline);
				sb.append("<ccts:ObjectClassTerm>" + densds.objclass + "</ccts:ObjectClassTerm>");
				sb.append(MyConst.newline);
				sb.append("<ccts:PropertyTerm>" + densds.propertyTerm + "</ccts:PropertyTerm>");
				sb.append(MyConst.newline);
				sb.append("<ccts:RepresentationTerm>" + densds.representationTerm + "</ccts:RepresentationTerm>");
				sb.append(MyConst.newline);
				sb.append("</xsd:documentation>");
				sb.append(MyConst.newline);
				sb.append("</xsd:annotation>");
				sb.append(MyConst.newline);

				// sb.append("<xsd:restriction base=\"udt:" + new XmaUtils().getBaseType(densds.representationTerm)
				// + "\"/>");

				sb.append("<xsd:restriction base=\"" + new XmaUtils().getBase(densds.representationTerm) + "\"/>");

				sb.append(MyConst.newline);
				sb.append("</xsd:simpleType>");
				sb.append(MyConst.newline);

				// twDSMap.put(densds.den, sb.toString());
				// twDSSet.add(densds.den);
				// out.write(sb.toString());

				DenSchema o = new DenSchema();
				o.den = densds.den;
				o.uid = densds.twid;
				o.clsObjTerm = densds.objclass;
				o.clsid = densds.classid;

				o.schema = sb.toString();

				twDSXsdArray.add(o);

				if (o.uid.startsWith("WCOID")) {
					twDSXsdArray_WCO.add(o);
				} else {
					twDSXsdArray_TW.add(o);
				}
			} else {
				sb.append(MyConst.newline);
				sb.append("<xsd:complexType name=\"" + densds.namedComplexType + "\">");
				sb.append(MyConst.newline);
				sb.append("<xsd:annotation>");
				sb.append(MyConst.newline);
				sb.append("<xsd:documentation xml:lang=\"en\">");
				sb.append(MyConst.newline);
				sb.append("<ccts:UniqueID>" + densds.twid + "</ccts:UniqueID>");
				sb.append(MyConst.newline);
				sb.append("<ccts:DictionaryEntryName>" + densds.den + "</ccts:DictionaryEntryName>");
				sb.append(MyConst.newline);
				sb.append("<ccts:Definition>" + densds.uid_enDef + "</ccts:Definition>");
				sb.append(MyConst.newline);
				sb.append("<ccts:ObjectClassTerm>" + densds.objclass + "</ccts:ObjectClassTerm>");
				sb.append(MyConst.newline);
				sb.append("<ccts:PropertyTerm>" + densds.propertyTerm + "</ccts:PropertyTerm>");
				sb.append(MyConst.newline);
				sb.append("<ccts:RepresentationTerm>" + densds.representationTerm + "</ccts:RepresentationTerm>");
				sb.append(MyConst.newline);
				sb.append("</xsd:documentation>");
				sb.append(MyConst.newline);
				sb.append("</xsd:annotation>");
				sb.append(MyConst.newline);
				sb.append("<xsd:simpleContent>");
				sb.append(MyConst.newline);

				// sb.append("<xsd:restriction base=\"udt:" + new XmaUtils().getBaseType(densds.representationTerm)
				// + "\"/>");

				sb.append("<xsd:restriction base=\"" + new XmaUtils().getBase(densds.representationTerm) + "\"/>");

				sb.append(MyConst.newline);
				sb.append("</xsd:simpleContent>");
				sb.append(MyConst.newline);
				sb.append("</xsd:complexType>");
				sb.append(MyConst.newline);

				// twDSMap.put(densds.den, sb.toString());
				// twDSSet.add(densds.den);
				// out.write(sb.toString());

				DenSchema o = new DenSchema();
				o.den = densds.den;
				o.uid = densds.twid;
				o.clsObjTerm = densds.objclass;
				o.clsid = densds.classid;
				o.schema = sb.toString();
				twDSXsdArray.add(o);

				if (o.uid.startsWith("WCOID")) {
					twDSXsdArray_WCO.add(o);
				} else {
					twDSXsdArray_TW.add(o);
				}
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			// try {
			// // out.close();
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
		}
	}

	// public static void build_old(TWDENS_DAO densds) {
	// if (twDSSet == null) {
	// twDSSet = new HashSet();
	// }
	//
	// // System.out.println(densds.den+" RRRRRR");
	//
	// if (hasDEN(densds.den))
	// return;
	//
	// // if (twDSMap.containsKey(densds.den))
	// // return;
	//
	// if (!densds.src.equals("TW"))
	// return;
	//
	// // System.out.println(densds.den + " *-------------------");
	//
	// BufferedWriter out = null;
	// // String fname = "d:/zz/twXsd.txt";
	// try {
	// out = new BufferedWriter(new FileWriter(MyConst.xsdFile, true));
	//
	// boolean isSimpleType = new XmaUtils().isSimple(densds);
	//
	// StringBuffer sb = new StringBuffer();
	//
	// if (isSimpleType) {
	// sb.append(MyConst.newline);
	// sb.append("<xsd:simpleType name=\"" + densds.namedComplexType + "\">");
	// sb.append("<xsd:annotation>");
	// sb.append("<xsd:documentation xml:lang=\"en\">");
	// sb.append("<ccts:UniqueID>" + densds.twid + "</ccts:UniqueID>");
	// sb.append("<ccts:DictionaryEntryName>" + densds.den + "</ccts:DictionaryEntryName>");
	// sb.append("<ccts:Definition>" + densds.enDef + "</ccts:Definition>");
	// sb.append("<ccts:ObjectClassTerm>" + densds.objclass + "</ccts:ObjectClassTerm>");
	// sb.append("<ccts:PropertyTerm>" + densds.propertyTerm + "</ccts:PropertyTerm>");
	// sb.append("<ccts:RepresentationTerm>" + densds.representationTerm + "</ccts:RepresentationTerm>");
	// sb.append("</xsd:documentation>");
	// sb.append("</xsd:annotation>");
	// sb.append("<xsd:restriction base=\"udt:" + new XmaUtils().getBaseType(densds.representationTerm)
	// + "\"/>");
	// sb.append("</xsd:simpleType>");
	// sb.append(MyConst.newline);
	//
	// // twDSMap.put(densds.den, sb.toString());
	// twDSSet.add(densds.den);
	// out.write(sb.toString());
	// } else {
	// sb.append(MyConst.newline);
	// sb.append("<xsd:complexType name=\"" + densds.namedComplexType + "\">");
	// sb.append("<xsd:annotation>");
	// sb.append("<xsd:documentation xml:lang=\"en\">");
	// sb.append("<ccts:UniqueID>" + densds.twid + "</ccts:UniqueID>");
	// sb.append("<ccts:DictionaryEntryName>" + densds.den + "</ccts:DictionaryEntryName>");
	// sb.append("<ccts:Definition>" + densds.enDef + "</ccts:Definition>");
	// sb.append("<ccts:ObjectClassTerm>" + densds.objclass + "</ccts:ObjectClassTerm>");
	// sb.append("<ccts:PropertyTerm>" + densds.propertyTerm + "</ccts:PropertyTerm>");
	// sb.append("<ccts:RepresentationTerm>" + densds.representationTerm + "</ccts:RepresentationTerm>");
	// sb.append("</xsd:documentation>");
	// sb.append("</xsd:annotation>");
	// sb.append("<xsd:simpleContent>");
	// sb.append("<xsd:restriction base=\"udt:" + new XmaUtils().getBaseType(densds.representationTerm)
	// + "\"/>");
	// sb.append("</xsd:simpleContent>");
	// sb.append("</xsd:complexType>");
	// sb.append(MyConst.newline);
	//
	// // twDSMap.put(densds.den, sb.toString());
	// twDSSet.add(densds.den);
	// out.write(sb.toString());
	// }
	// } catch (Exception e) {
	// System.err.println("Error: " + e.getMessage());
	// } finally {
	// try {
	// out.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }

	// public static void startTwDsXsdFile() {
	// BufferedWriter out = null;
	// try {
	// File wfile = new File(MyConst.xsdFile);
	// out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(wfile), "big5"));
	//
	// out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	// out
	// .write("<xsd:schema xmlns=\"urn:wco:datamodel:TW:DS:1\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:udt=\"urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6\" xmlns:qdt=\"urn:un:unece:uncefact:data:standard:QualifiedDataType:5\" xmlns:ccts=\"urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2\" targetNamespace=\"urn:wco:datamodel:TW:DS:1\" elementFormDefault=\"qualified\" attributeFormDefault=\"unqualified\">");
	// out
	// .write("<xsd:import namespace=\"urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6\" schemaLocation=\"UnqualifiedDataType_6p0.xsd\" />");
	// out
	// .write("<xsd:import namespace=\"urn:un:unece:uncefact:data:standard:QualifiedDataType:5\" schemaLocation=\"QualifiedDataType_5p0.xsd\" />");
	//
	// // out.write("");
	// out.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public static void closeTwDsXsdFile() {
	// BufferedWriter out = null;
	// try {
	// out = new BufferedWriter(new FileWriter(MyConst.xsdFile, true));
	// out.write("</xsd:schema>");
	//
	// } catch (Exception e) {
	// System.err.println("Error: " + e.getMessage());
	// } finally {
	// try {
	// out.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }

	static String getBigXsdStr() {
		StringBuffer sb = new StringBuffer();

		String separator = "<!-- =========================================================================== -->";
		try {

			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append(MyConst.newline);

			sb.append("<?xml-stylesheet href=\"GenAnnotation_tw.xslt\" type=\"text/xsl\"?>");
			sb.append(MyConst.newline);

//			sb.append(separator);
//			sb.append(MyConst.newline);

//			sb.append("<!-- ===== TWDS Schema 1.0 ===== -->");
//			sb.append(MyConst.newline);

//			sb.append(separator);
//			sb.append(MyConst.newline);

			sb.append("<xsd:schema "
					+ //
					"xmlns=\"urn:wco:datamodel:TW:DS:" + MyConst.TWDS_version + "\" "
					+ //
					"xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
					+ //
					"xmlns:udt=\"urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6\" "
					+ //
					"xmlns:qdt=\"urn:un:unece:uncefact:data:standard:QualifiedDataType:5\" "
					+ //
					"xmlns:ccts=\"urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2\" "
					+ //
					"targetNamespace=\"urn:wco:datamodel:TW:DS:" + MyConst.TWDS_version + "\" " //
					+ //
					"elementFormDefault=\"qualified\" " + //
					"attributeFormDefault=\"unqualified\"" + //
					">");

			sb.append(MyConst.newline);
			sb
					.append("<xsd:import namespace=\"urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6\" schemaLocation=\"UnqualifiedDataType_6p0.xsd\" />");
			sb.append(MyConst.newline);
			sb
					.append("<xsd:import namespace=\"urn:un:unece:uncefact:data:standard:QualifiedDataType:5\" schemaLocation=\"QualifiedDataType_5p0.xsd\" />");

			sb.append(MyConst.newline);

			sb.append(separator);

			sb.append(MyConst.newline);

			sb.append("<!-- ===== Type Definitions ===== -->");

			sb.append(MyConst.newline);

			TwDs_1p0_Comparator com = new TwDs_1p0_Comparator();
			Collections.sort(twDSXsdArray, com);
			Collections.sort(twDSXsdArray_WCO, com);
			Collections.sort(twDSXsdArray_TW, com);

			// for (int i = 0; i < twDSXsdArray.size(); i++) {
			// DenSchema o = (DenSchema) twDSXsdArray.get(i);
			//
			// sb.append(separator);
			// sb.append(MyConst.newline);
			// sb.append("<!-- ===== " + o.den + ". Type" + "===== -->");
			// sb.append(MyConst.newline);
			// sb.append(separator);
			// // sb.append(MyConst.newline);
			//
			// sb.append(o.schema);
			// // sb.append(MyConst.newline);
			//
			// }

			for (int i = 0; i < twDSXsdArray_WCO.size(); i++) {
				DenSchema o = (DenSchema) twDSXsdArray_WCO.get(i);
				sb.append(separator);
				sb.append(MyConst.newline);
				sb.append("<!-- ===== " + o.den + ". Type" + "===== -->");
				sb.append(MyConst.newline);
				sb.append(separator);
				// sb.append(MyConst.newline);
				sb.append(o.schema);
				// sb.append(MyConst.newline);
			}

			for (int i = 0; i < twDSXsdArray_TW.size(); i++) {
				DenSchema o = (DenSchema) twDSXsdArray_TW.get(i);
				sb.append(separator);
				sb.append(MyConst.newline);
				sb.append("<!-- ===== " + o.den + ". Type" + "===== -->");
				sb.append(MyConst.newline);
				sb.append(separator);
				// sb.append(MyConst.newline);
				sb.append(o.schema);
				// sb.append(MyConst.newline);
			}

			sb.append("</xsd:schema>");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	public static void writeTwDsXsdFile() {
		BufferedWriter out = null;

		String separator = "<!-- =========================================================================== -->";
		try {
			File wfile = new File(MyConst.getSchemaPath() + "common/TWDS_1p0.xsd");
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(wfile), "UTF-8"));
			String s = getBigXsdStr();

			s = new XmlFormatter().format(s);

			//-------------------------------------------------------------------
			// add copy right
			StringBuffer sb2 = new StringBuffer();

			BufferedReader br2 = new BufferedReader(new StringReader(s));
			String strLine2;
			while ((strLine2 = br2.readLine()) != null) {

				if (strLine2.contains("xml-stylesheet")) {
					sb2.append(strLine2 + MyConst.newline);
					sb2.append("<!--");
					sb2.append(MyConst.newline);
					
					sb2.append("\tSchema agency\t: Taiwan Customs");
					sb2.append(MyConst.newline);
					
					sb2.append("\tSchema type\t\t\t: TWDS");
					sb2.append(MyConst.newline);
					
					sb2.append("\tSchema version\t\t: " +MyConst.TWDS_version);
					sb2.append(MyConst.newline);
					
					sb2.append("\tSchema date\t\t\t: "+ DateTimeFormater.getDateForm());
					sb2.append(MyConst.newline);
					
					sb2.append("");
					sb2.append(MyConst.newline);
					sb2.append("  Copyright (C) Taiwan Customs ("+ DateTimeFormater.getYearForm()+"). All Rights Reserved.");
					sb2.append(MyConst.newline);
					sb2.append("-->	");
					sb2.append(MyConst.newline);

				} else
					sb2.append(strLine2 + MyConst.newline);

			}
			//-------------------------------------------------------------------
			
			out.write(sb2.toString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// startTwDsXsdFile();
		// buildAll();
	}

}
