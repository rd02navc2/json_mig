package com.example.demo.phase1;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import com.example.demo.MyConst;

public class SingleMsgXsdWrapper {

	static String getHeader(String msgName) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append(MyConst.newline);

		// sb.append("<?xml-stylesheet href=\"GenHTML.xslt\" type=\"text/xsl\"?>");
		sb.append("<?xml-stylesheet href=\"GenHTML_TW.xslt\" type=\"text/xsl\"?>");
		sb.append(MyConst.newline);

		sb.append("<xsd:schema ");
		sb.append("xmlns=\"urn:wco:datamodel:TW:" + msgName + ":" + MyConst.getMsgVersion(msgName) + "\" ");
		sb.append("xmlns:ds=\"urn:wco:datamodel:WCO:DS:1\" ");
		sb.append("xmlns:twds=\"urn:wco:datamodel:TW:DS:" + MyConst.TWDS_version + "\" ");
		sb.append("xmlns:ccts=\"urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2\" ");
		sb.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ");
		sb.append("targetNamespace=\"urn:wco:datamodel:TW:" + msgName + ":" + MyConst.getMsgVersion(msgName) + "\" ");
		sb.append("xmlns:tsw=\"urn:SingleWindow:TW\" ");
		sb.append("elementFormDefault=\"qualified\" ");
		sb.append("attributeFormDefault=\"unqualified\" ");
		sb.append("version=\"" + MyConst.getMsgVersion(msgName) + "\">");

		sb.append(MyConst.newline);

		sb.append("<xsd:import namespace=\"urn:wco:datamodel:WCO:DS:1\" schemaLocation=\"" + ".." + "/common/WCODS_1p0.xsd\" />");

		sb.append(MyConst.newline);

		sb.append("<xsd:import namespace=\"urn:wco:datamodel:TW:DS:" + MyConst.TWDS_version + "\" " + //
				"schemaLocation=\"../common/TWDS_1p0.xsd\" />");

		sb.append(MyConst.newline);

		return sb.toString();

	}

	static String getFooter() {
		return "</xsd:schema>";
	}

	// static String getTwDensHead() {
	// StringBuffer sb = new StringBuffer();
	// sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	// sb.append(MyConst.newline);
	//
	// sb.append("<xsd:schema xmlns=\"urn:wco:datamodel:TW:DS:1\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ");
	// sb.append("xmlns:udt=\"urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6\" ");
	// sb.append("xmlns:qdt=\"urn:un:unece:uncefact:data:standard:QualifiedDataType:5\" ");
	// sb
	// .append("xmlns:ccts=\"urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2\" ");
	// sb.append("targetNamespace=\"urn:wco:datamodel:TW:DS:1\" " + //
	// "elementFormDefault=\"unqualified\" attributeFormDefault=\"unqualified\">");
	// sb.append("<xsd:import namespace=\"urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6\" " + //
	// "schemaLocation=\"UnqualifiedDataType_6p0.xsd\"/>");
	// sb.append("<xsd:import namespace=\"urn:un:unece:uncefact:data:standard:QualifiedDataType:5\" " + //
	// "schemaLocation=\"QualifiedDataType_5p0.xsd\"/>");
	//
	// return sb.toString();
	// }

	public static void genSingleMsgXsd(String msgName, String rootEleName, String schemaFile, ResponseAbstract o) {
		String basepath = MyConst.getSchemaPath();

		// String fname = "d:/zz/twdens.txt";

		PrintWriter out = null;
		// BufferedWriter out2 = null;
		try {
			// out2 = new BufferedWriter(new FileWriter(fname));
			// out2.write(getTwDensHead());
			// out2.close();
			// -----------------------------------------
			// for (int i = 0; i < MyMain.msg.length; i++) {
			// String msgName = MyMain.msg[i][0];
			// String rootEleName = MyMain.msg[i][1];
			// String schemaFile = MyMain.msg[i][2];

			out = new PrintWriter(new FileWriter(basepath + schemaFile));

			String body = o.getSchema();
			//dc-
			System.out.println("NNNNKKKKKKK\n\n" + body);

			if (rootEleName.equals("Declaration")) {
				String str = "<xsd:element name=\"Declaration\">";
				int start = body.indexOf(str);
				// System.out.println(str + "===start===" + start);
				int end = body.lastIndexOf("</xsd:sequence></xsd:complexType></xsd:element>");
				body = body.substring(start, end);
			}

			String s = getHeader(msgName) + body + getFooter();

			s = s.replace(MyConst.newline, "");
			//

			s = new XmlFormatter().format(s);

			// s=new XmlTest().formatXml(s);
			//
			// ----------------------------------------------------------------
			// reposition minOccurs & maxOccurs
			StringBuffer sb = new StringBuffer();

			BufferedReader br = new BufferedReader(new StringReader(s));
			String strLine;
			while ((strLine = br.readLine()) != null) {

				int min = strLine.indexOf("minOccurs");
				int max = strLine.indexOf("maxOccurs");

				if (min >= 0 || max >= 0) {
					strLine = strLine.substring(0, strLine.length() - 1);
					int n = strLine.indexOf("<xsd:element");
					// System.out.println("-->>> " + strLine);

					n = n + "<xsd:element".length();
					String head = strLine.substring(0, n);
					// System.out.println(head);

					String remain = strLine.substring(n + 1);
					// System.out.println(remain);

					String nameS = "";
					String minS = "";
					String maxS = "";
					String typeS = "";
					String[] xxx = remain.split(" ");
					for (int i = 0; i < xxx.length; i++) {
						if (xxx[i].startsWith("name"))
							nameS = xxx[i];
						if (xxx[i].startsWith("minOccurs"))
							minS = xxx[i];
						if (xxx[i].startsWith("maxOccurs"))
							maxS = xxx[i];
						if (xxx[i].startsWith("type"))
							typeS = xxx[i];
						// System.out.println();
					}

					String newline = head + " " + nameS;
					if (!typeS.equals(""))
						newline = newline + " " + typeS;
					if (!minS.equals(""))
						newline = newline + " " + minS;
					if (!maxS.equals(""))
						newline = newline + " " + maxS;
					newline = newline + ">";
					// System.out.println("==>>> " + newline + MyConst.newline);
					sb.append(newline + MyConst.newline);
				} else {
					sb.append(strLine + MyConst.newline);
				}

			}
			// ----------------------------------------------------------------
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
					
					sb2.append("\tSchema type\t\t\t: "+msgName);
					sb2.append(MyConst.newline);
					
					sb2.append("\tSchema version\t\t: " + MyConst.getMsgVersion(msgName));
					sb2.append(MyConst.newline);
					
					sb2.append("\tSchema date\t\t\t: "+ DateTimeFormater.getDateForm());
					sb2.append(MyConst.newline);
					
					sb2.append("");
					sb2.append(MyConst.newline);
					sb2.append("\tCopyright (C) Taiwan Customs ("+ DateTimeFormater.getYearForm()+"). All Rights Reserved.");
					sb2.append(MyConst.newline);
					sb2.append("-->	");
					sb2.append(MyConst.newline);

				} else
					sb2.append(strLine2 + MyConst.newline);

			}

			// -------------------------------------------------------------------------------

			// ----------------------------------------------------------------

			out.println(sb2.toString());
			out.close();

			// }
			// -----------------------------------------
			// out2 = new BufferedWriter(new FileWriter(fname, true));
			// out2.write(getFooter());
			// out2.close();

			// System.out.println("Done!!!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}
	
	public static void genSingleMsgXsdJson(String msgName, String rootEleName, String schemaFile, String xsdContent) {
	        String basepath = MyConst.getSchemaPath();
	
	        try (PrintWriter out = new PrintWriter(new FileWriter(basepath + schemaFile))) {
	
	            // 移除 xsdContent 中可能的 XML 宣告
	            if (xsdContent.trim().startsWith("<?xml")) {
	                int idx = xsdContent.indexOf("?>");
	                if (idx > 0) {
	                    xsdContent = xsdContent.substring(idx + 2);
	                }
	            }
	
	            // 根據 rootEleName 可以裁切 body（如果需要）
	            String body = xsdContent;
	            if ("Declaration".equals(rootEleName)) {
	                String str = "<xsd:element name=\"Declaration\">";
	                int start = body.indexOf(str);
	                int end = body.lastIndexOf("</xsd:sequence></xsd:complexType></xsd:element>");
	                if (start >= 0 && end > start) {
	                    body = body.substring(start, end);
	                }
	            }
	
	            // 加上標準 header & footer
	            String s = getHeader(msgName) + body + getFooter();
	
	            // 格式化
	            s = s.replace(MyConst.newline, "");
	            s = new XmlFormatter().format(s);
	
	            // 加上 minOccurs/maxOccurs 調整（保留原邏輯）
	            StringBuffer sb = new StringBuffer();
	            try (BufferedReader br = new BufferedReader(new StringReader(s))) {
	                String strLine;
	                while ((strLine = br.readLine()) != null) {
	                    if (strLine.contains("minOccurs") || strLine.contains("maxOccurs")) {
	                        strLine = adjustMinMax(strLine);
	                    }
	                    sb.append(strLine + MyConst.newline);
	                }
	            }
	
	            // 加入版權資訊
	            StringBuffer sb2 = new StringBuffer();
	            try (BufferedReader br2 = new BufferedReader(new StringReader(sb.toString()))) {
	                String strLine2;
	                while ((strLine2 = br2.readLine()) != null) {
	                    if (strLine2.contains("xml-stylesheet")) {
	                        sb2.append(strLine2).append(MyConst.newline);
	                        sb2.append("<!--").append(MyConst.newline);
	                        sb2.append("\tSchema agency\t: Taiwan Customs").append(MyConst.newline);
	                        sb2.append("\tSchema type\t\t: ").append(msgName).append(MyConst.newline);
	                        sb2.append("\tSchema version\t: ").append(MyConst.getMsgVersion(msgName)).append(MyConst.newline);
	                        sb2.append("\tSchema date\t\t: ").append(DateTimeFormater.getDateForm()).append(MyConst.newline);
	                        sb2.append("\tCopyright (C) Taiwan Customs (")
	                           .append(DateTimeFormater.getYearForm())
	                           .append("). All Rights Reserved.").append(MyConst.newline);
	                        sb2.append("-->").append(MyConst.newline);
	                    } else {
	                        sb2.append(strLine2).append(MyConst.newline);
	                    }
	                }
	            }
	
	            out.println(sb2.toString());
	            System.out.println(msgName + " XSD 已生成：" + basepath + schemaFile);
	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

    private static String adjustMinMax(String line) {
        // 原本的 minOccurs/maxOccurs 調整邏輯
        int n = line.indexOf("<xsd:element") + "<xsd:element".length();
        String head = line.substring(0, n);
        String remain = line.substring(n + 1);

        String nameS = "", minS = "", maxS = "", typeS = "";
        for (String part : remain.split(" ")) {
            if (part.startsWith("name")) nameS = part;
            if (part.startsWith("minOccurs")) minS = part;
            if (part.startsWith("maxOccurs")) maxS = part;
            if (part.startsWith("type")) typeS = part;
        }

        String newline = head + " " + nameS;
        if (!typeS.isEmpty()) newline += " " + typeS;
        if (!minS.isEmpty()) newline += " " + minS;
        if (!maxS.isEmpty()) newline += " " + maxS;
        newline += ">";
        return newline;
    }


}
