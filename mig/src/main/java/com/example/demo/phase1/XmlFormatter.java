package com.example.demo.phase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

// import org.apache.xml.serialize.OutputFormat;
// import org.apache.xml.serialize.XMLSerializer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.example.demo.MyConst;



public class XmlFormatter {

	public XmlFormatter() {
	}

	public String fmt(String strXML) throws Exception {
		Element e = createDOM(strXML);
		String s = prettyPrint(e);

		return s;
	}

	public Element createDOM(String strXML) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputSource sourceXML = new InputSource(new StringReader(strXML));
		Document xmlDoc = db.parse(sourceXML);
		Element e = xmlDoc.getDocumentElement();
		e.normalize();
		return e;
	}

	public String prettyPrint(Node xml) throws TransformerConfigurationException, TransformerFactoryConfigurationError,
			TransformerException {

		Transformer tf = TransformerFactory.newInstance().newTransformer();
		// tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");

		StreamResult result = new StreamResult(new StringWriter());
		tf.transform(new DOMSource(xml), result);

		String xmlString = result.getWriter().toString();
		return xmlString;
	}

	// -------------------------------------------------------------------------
	public String prettyFormat(String input, int indent) {
		try {
			Source xmlInput = new StreamSource(new StringReader(input));
			StringWriter stringWriter = new StringWriter();
			StreamResult xmlOutput = new StreamResult(stringWriter);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			transformerFactory.setAttribute("indent-number", indent);

			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			transformer.transform(xmlInput, xmlOutput);
			return xmlOutput.getWriter().toString();
		} catch (Exception e) {
			throw new RuntimeException(e); // simple exception handling, please review it
		}
	}

	public String prettyFormat(String input) {
		return prettyFormat(input, 2);
	}

	// -------------------------------------------------------------------------
/*
	public String format(String unformattedXml) {
		try {
			final Document document = parseXmlFile(unformattedXml);

			OutputFormat format = new OutputFormat(document);
			format.setLineWidth(6500);
			// format.setIndenting(true);
			format.setEncoding("UTF-8");

			format.setIndent(4);
			format.setLineSeparator(MyConst.newline);

			// format.setOmitXMLDeclaration(true);
			// format.setOmitDocumentType(true);

			Writer out = new StringWriter();
			XMLSerializer serializer = new XMLSerializer(out, format);
			serializer.serialize(document);
			return out.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
*/
	//
	public String format(String unformattedXml) {
	    try {
	        Document document = parseXmlFile(unformattedXml);

	        TransformerFactory factory = TransformerFactory.newInstance();
	        Transformer transformer = factory.newTransformer();

	        // === 等同 OutputFormat 設定 ===
	        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty(OutputKeys.METHOD, "xml");

	        // 縮排寬度（JDK 內建 Xerces 支援）
	        transformer.setOutputProperty(
	            "{http://xml.apache.org/xslt}indent-amount", "4"
	        );

	        StringWriter writer = new StringWriter();
	        transformer.transform(
	            new DOMSource(document),
	            new StreamResult(writer)
	        );

	        // 統一換行符（取代 Transformer 預設）
	        return writer.toString()
	                     .replace("\r\n", "\n")
	                     .replace("\n", MyConst.newline);

	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

	private Document parseXmlFile(String in) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(in));
			return db.parse(is);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		// String unformattedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><QueryMessage"
		// + " xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\""
		// + " xmlns:query=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query\">" + "<Query>"
		// + "<query:CategorySchemeWhere>" + "<query:AgencyID>ECB</query:AgencyID>"
		// + "</query:CategorySchemeWhere>" + "</Query>" + "</QueryMessage>";
		//
		// System.out.println(new XmlFormatter().prettyFormat(unformattedXml));
		// System.out.println("************************************************");
		// System.out.println(new XmlFormatter().format(unformattedXml));

		String xx = "                            <xsd:element maxOccurs=\"2\" minOccurs=\"0\" name=\"TransportContractDocument\">";

		StringTokenizer st = new StringTokenizer(xx, " ");
		while (st.hasMoreTokens()) {
			String cc = st.nextToken();
			// System.out.println(xx);
		}

		

		int n = xx.indexOf("<xsd:element") + "<xsd:element".length();
		String head = xx.substring(0, n);
		System.out.println(head);

		String remain = xx.substring(n + 1);
		System.out.println(remain);

		String[] xxx = remain.split(" ");
		for (int i = 0; i < xxx.length; i++) {
			System.out.println(xxx[i]);
		}
	}

}
