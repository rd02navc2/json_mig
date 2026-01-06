package com.example.demo.phase1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.demo.MyConst;


public class SingleMsgXmlWrapper {

	public static void genSingleMsgsXmls(String msgName, String rootEleName, String schemaFile, ResponseAbstract o) {
		String basepath = MyConst.getSchemaPath();

		PrintWriter out = null;

		try {
			schemaFile = schemaFile.replace("maindoc", "instance2");
			schemaFile = schemaFile.replace(".xsd", ".xml");

			out = new PrintWriter(new FileWriter(basepath + schemaFile));

			String body = o.getSchema();

//			 System.out.println("msgName="+msgName+",rootEleName="+rootEleName);
//			 System.out.println(body);

			if (rootEleName.equals("Declaration")) {
				String str = "<Response>";
				int start = body.indexOf(str) + str.length();
				// System.out.println(str + "===start===" + start);
				int end = body.lastIndexOf("</Response>");
				body = body.substring(start, end);
			}

			// if(msgName.equals("NX301"))
			//
			// System.out.println("www==="+body);
			// String s = getHeader() + body + getFooter();

			// String s = body;

			String s = getHeader(rootEleName, body, msgName);

			// test
			if (msgName.equals("NX601")) {
				// System.out.println("www===" + s);
			}

			//
			s = new XmlFormatter().format(s);
			//

			// System.out.println("ffff==="+s);

			out.println(s);
			out.close();

			// System.out.println("Done!!!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}

	static String getHeader(String rootEle, String body, String msgName) {
		StringBuffer sb = new StringBuffer();

		int n1 = body.indexOf("<");
		String s1 = body.substring(n1 + 1);

		int n2 = body.indexOf(">");
		String s2 = s1.substring(0, n2 - 1);

		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		sb.append("<" + s2 + " " + //
				"xsi:schemaLocation=\""+"urn:wco:datamodel:TW:" + msgName + ":" + MyConst.getMsgVersion(msgName) + //
				" ../maindoc/" + msgName + ".xsd\" " + //
				"xmlns=\"" +"urn:wco:datamodel:TW:"+ msgName + ":" + MyConst.getMsgVersion(msgName) + "\" " + //

				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"//
		);

		String bodyWithoutRoot = body.substring(("<" + s2 + "/>").length() - 1);

		sb.append(bodyWithoutRoot);

		sb.append("\n");

		return sb.toString();

	}

}
