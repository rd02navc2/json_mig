package com.example.demo.phase2.make.mapping_tree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.xml.parsers.SAXParserFactory;

import com.example.demo.TWDENS_DAO;
import com.example.demo.XmaDB;
import com.example.demo.phase2.AnnotationDAO;
import com.example.demo.phase2.AnnotationFactory;
import com.sun.xml.xsom.XSAnnotation;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSTerm;
import com.sun.xml.xsom.parser.XSOMParser;

public class XSOMNavigator_GenMappingTreeExcel {

	public String rootEle = "";

	String msgName = "";
	ArrayList<MappingTreeRow> ar = new ArrayList<MappingTreeRow>();
	String LLine = "|____ ";

	public XSOMNavigator_GenMappingTreeExcel() {

	}

	public XSOMNavigator_GenMappingTreeExcel(String msgName, String rootEle, BufferedWriter out) {
		this.rootEle = rootEle;
		// this.out = out;
		this.msgName = msgName;

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
		MappingTreeRow o = new MappingTreeRow();
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

		if (!chineseName.contains(";")) {

			MappingTreeRow o = new MappingTreeRow();
			o.chnName = a.chineseName;

			o.tree = tree;
			o.mc = MC;
			o.occur = occurs;
			o.format = a.format;

			o.propid = a.UniqueID;
			if (o.propid.startsWith("WCOID")) {
				o.propid = o.propid.substring(5);
			}

			ar.add(o);
		} else {
			String[] chineseNames = chineseName.split(";");
			for (int i = 0; i < chineseNames.length; i++) {
				String chname = chineseNames[i];

				MappingTreeRow o = new MappingTreeRow();
				o.chnName = chname;

				if (i == 0) {
					o.tree = tree;
					o.mc = MC;
					o.occur = occurs;
					o.format = a.format;

					o.propid = a.UniqueID;
					if (o.propid.startsWith("WCOID")) {
						o.propid = o.propid.substring(5);
					}
				} else {
					o.tree = "";
					o.mc = "";
					o.occur = "";
					o.propid = "";
					o.format = "";
				}

				ar.add(o);
			}
		}
	}

	void enrich() {
		for (int i = 0; i < ar.size(); i++) {
			MappingTreeRow o = (MappingTreeRow) ar.get(i);

			String chineseName = o.chnName;

			if (!chineseName.trim().equals("")) {
				XmaDB db = new XmaDB();

				TWDENS_DAO dao = db.getDsResult2(chineseName);

				if (dao == null)
					System.err.println("Mapping Tree REader Error cccc==>" + "'" + chineseName + "'");
				else {
					o.chnDef = dao.chDef;
					o.enDef = dao.enDef;
					o.enName = dao.enName;
					// o.format = dao.format;
					o.sn = dao.sn;
				}
			}

			if (o.chnName.startsWith("*")) {
				o.chnName = "";
				o.enName = "";
				o.chnDef = "";
				o.enDef = "";
			}

			// o.prn();
		}
	}

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
						printParticle(par, indent + "|           ");
					else
						printParticle(par, indent + "            ");
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
		enrich();
	}

	public void writefile(String outputFile) {
		WriteMappingTreeExcel w = new WriteMappingTreeExcel();
		w.setOutputFile(outputFile);
		w.createDataSetExcel();

		w.writeFileTitles(msgName);

		for (int i = 0; i < ar.size(); i++) {
			MappingTreeRow o = (MappingTreeRow) ar.get(i);

			w.writeToFile(i, o);
		}

		w.closeDataSetExcel();
	}

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

	}
}
