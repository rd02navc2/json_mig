package com.example.demo.phase2.check.mapping_tree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;


import com.example.demo.MyConst;
import com.example.demo.phase2.AnnotationDAO;
import com.example.demo.phase2.AnnotationFactory;
import com.sun.xml.xsom.XSAnnotation;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSTerm;
import com.sun.xml.xsom.parser.XSOMParser;
import javax.xml.parsers.SAXParserFactory;

public class XSOMNavigator_GetTree {

	public String rootEle = "";

	String msgName = "";
	ArrayList<MyTreeRow> ar = new ArrayList<MyTreeRow>();
	String LLine = "|_ ";

	public XSOMNavigator_GetTree() {

	}

	public XSOMNavigator_GetTree(String msgName, String rootEle, BufferedWriter out) {
		this.rootEle = rootEle;
		// this.out = out;
		this.msgName = msgName;

	}

	public ArrayList<MyTreeRow> getTree() {
		return ar;
	}

	boolean lastChild = false;

	private void collectClassInfo(XSElementDecl element, String occurs, String MC, String tree) {
		AnnotationDAO a = null;
		XSAnnotation xsAnnotation = element.getAnnotation();
		if (xsAnnotation == null) {
			System.err.println(" Errror --> No Annotation ");
			// throw new RuntimeException("!! No Annotation !! --->" +
			// "[Element " + absPath + "]");
			a = new AnnotationDAO();
		} else {
			a = (AnnotationDAO) xsAnnotation.getAnnotation();
		}

		// --------------------------------------------------------------------------------------
		MyTreeRow o = new MyTreeRow();
		o.tree = tree;
		o.mc = MC;
		o.occur = occurs;
		o.classid = a.UniqueID;
		o.chnName = "";

		ar.add(o);
	}

	private void collectPropertyInfo(XSElementDecl element, String occurs, String MC, String tree) {
		AnnotationDAO a = null;
		XSAnnotation xsAnnotation = element.getAnnotation();
		if (xsAnnotation == null) {
			System.err.println(" Errror --> No Annotation ");
			// throw new RuntimeException("!! No Annotation !! --->" +
			// "[Element " + absPath + "]");
			a = new AnnotationDAO();
		} else {
			a = (AnnotationDAO) xsAnnotation.getAnnotation();
		}

		// --------------------------------------------------------------------------------------
		String chineseName = a.chineseName;
		if (chineseName.startsWith("*"))
			chineseName = "";

		MyTreeRow o = new MyTreeRow();
		o.chnName = chineseName;

		o.tree = tree;
		o.mc = MC;
		o.occur = occurs;
		// o.format = a.format;

		o.propid = a.UniqueID;
		if (o.propid.startsWith("WCOID")) {
			o.propid = o.propid.substring(5);
		}

		ar.add(o);

	}

	// void enrich() {
	// for (int i = 0; i < ar.size(); i++) {
	// MyTreeRow o = (MyTreeRow) ar.get(i);
	//
	// String chineseName = o.chnName;
	//
	// if (!chineseName.trim().equals("")) {
	// XmaDB db = new XmaDB();
	//
	// TWDENS_DAO dao = db.getDsResult2(chineseName);
	//
	// if (dao == null)
	// System.err.println("Mapping Tree REader Error cccc==>" + "'" + chineseName + "'");
	// else {
	// o.chnDef = dao.chDef;
	// o.enDef = dao.enDef;
	// o.enName = dao.enName;
	// // o.format = dao.format;
	// o.sn = dao.sn;
	// }
	// }
	//
	// if (o.chnName.startsWith("*")) {
	// o.chnName = "";
	// o.enName = "";
	// o.chnDef = "";
	// o.enDef = "";
	// }
	//
	// // o.prn();
	// }
	// }

	private void printParticle(XSParticle particle, String indent) throws IOException {
		// String max = (particle.getMaxOccurs() == -1) ? "*" : ("" + particle.getMaxOccurs());
		// String min = particle.getMinOccurs() + "";
		BigInteger maxOccurs = particle.getMaxOccurs();
		BigInteger minOccurs = particle.getMinOccurs();
		    

		String max = (maxOccurs.equals(BigInteger.valueOf(-1)) || 
		             maxOccurs.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) 
		             ? "*" 
		             : maxOccurs.toString();
		    
		String min = minOccurs.toString();
		
		String occurs = "";
		if (min.equals(max)) {
			occurs = min;
		} else {
			occurs = min + ".." + max;
		}
		String MC = "";
		if (min.equals("0")) {
			MC = "C";
		} else {
			MC = "M";
		}
		// ------------------------------------------------------
		XSTerm term = particle.getTerm();
		if (term.isModelGroup()) {// entry point --> root element's complexType's "sequence"
			int cnt = term.asModelGroup().getChildren().length;
			int n = 1;
			for (XSParticle par : term.asModelGroup().getChildren()) {// each element in sequence
				lastChild = (n == cnt);
				printParticle(par, indent);
				n++;
			}
		} else if (term.isElementDecl()) {//
			XSElementDecl element = term.asElementDecl();

			if (element.getType().isComplexType()) {

				XSParticle par = element.getType().asComplexType().getContentType().asParticle();

				if (par != null) { // class
					collectClassInfo(element, occurs, MC, indent + LLine + element.getName());

					if (!lastChild)
						printParticle(par, indent + "|　　");
					else
						printParticle(par, indent + "　　");
				} else { // property
					collectPropertyInfo(element, occurs, MC, indent + LLine + element.getName());
				}
			} else { // property
				collectPropertyInfo(element, occurs, MC, indent + LLine + element.getName());
			}
		}
	}

	private void printRootElement(XSElementDecl rootElement) throws IOException {
		collectClassInfo(rootElement, "1", "M", rootElement.getName());
		printParticle(rootElement.getType().asComplexType().getContentType().asParticle(), "");
		// enrich();
	}

	// public void writefile(String outputFile) {
	// WriteMappingTreeExcel w = new WriteMappingTreeExcel();
	// w.setOutputFile(outputFile);
	// w.createDataSetExcel();
	//
	// w.writeFileTitles(msgName);
	//
	// for (int i = 0; i < ar.size(); i++) {
	// MappingTreeRow o = (MappingTreeRow) ar.get(i);
	//
	// w.writeToFile(i, o);
	// }
	//
	// w.closeDataSetExcel();
	// }

	public void xsomNavigate(String xsdFile) {
		try {
			// XSOMParser parser = new XSOMParser();
			SAXParserFactory saxFactory = SAXParserFactory.newInstance();
			saxFactory.setNamespaceAware(true);

			XSOMParser parser = new XSOMParser(saxFactory);
			
			parser.setAnnotationParser(new AnnotationFactory());
			parser.parse(xsdFile);
			printRootElement(parser.getResult().getSchema(1).getElementDecl(rootEle));
		} catch (Exception exp) {
			exp.printStackTrace(System.out);
		}
	}

	public static void main(String[] args) throws Exception {

		// XmaDB db = new XmaDB();
		// db.openConnection();

		// Loop 所有 schema
		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.msg[i][2];

			if (!msgName.equals("N5110"))
				continue;

			try {

				XSOMNavigator_GetTree o = new XSOMNavigator_GetTree(msgName, rootEleName, null);
				o.xsomNavigate(schemaFile);
				// o.writefile(MyConst.getMappingTreePath() + "III_" + msgName + "_mappingTree.xls");

				ArrayList<MyTreeRow> ar = o.getTree();

				for (int k = 0; k < ar.size(); k++) {
					MyTreeRow t = (MyTreeRow) ar.get(k);
					System.out.println(t.occur + "\t" + t.tree + "\t" + t.chnName);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}

		}

		// db.closeConnection();

	}
}
