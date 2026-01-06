package com.example.demo.phase2.make.item_desc_tbl;

import java.io.IOException;
import java.math.BigInteger;
import java.util.StringTokenizer;

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

public class XSOMNavigator_itemDesc_from_xsd {

	String msgName = "";
	public String rootEle = "";

	public  Worker4ItemDescription dd = null;

	public static void main(String[] args) {

		String msgName = "NX5105";

		try {

			XmaDB db = new XmaDB();
			db.openConnection();

			// ReadItemTblDoc rr = new ReadItemTblDoc();
			// rr.readin(msgName);
			// rr.checkGroup();

			Worker4ItemDescription dd = new Worker4ItemDescription(msgName);
			dd.openDoc();

			// --------------------------------------------------------------------------------------------
			XSOMNavigator_itemDesc_from_xsd o = new XSOMNavigator_itemDesc_from_xsd(msgName, "Response", dd);
			o.xsomNavigate("D:/mu20060711/workspace_eclipse_galileo_SR2_jee/book_java_websrv_up/Harmo/maindoc/"
					+ msgName + ".xsd");

			// --------------------------------------------------------------------------------------------

			dd.closeDoc();

			ReadItemTblDoc.showDataItemThatNotUsedByMappingTree();

			db.closeConnection();

			System.out.println("done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void xsomNavigate(String xsdFile) {
		try {
			// XSOMParser parser = new XSOMParser();
			SAXParserFactory saxFactory = SAXParserFactory.newInstance();
			saxFactory.setNamespaceAware(true);

			XSOMParser parser = new XSOMParser(saxFactory);

			parser.setAnnotationParser(new AnnotationFactory());
			parser.parse(xsdFile);

			printElement(parser.getResult().getSchema(1).getElementDecl(rootEle), rootEle);

		} catch (Exception exp) {
			exp.printStackTrace(System.out);
		}
	}

	public XSOMNavigator_itemDesc_from_xsd() {

	}

//	public XSOMNavigator_itemDesc_from_xsd(String msgName, String rootEle) {
//		this.msgName = msgName;
//		this.rootEle = rootEle;
//		
//	
//		this.dd =  new Worker4ItemDescription(msgName);
//
//		ReadItemTblDoc rr = new ReadItemTblDoc();
//		rr.readin(msgName);
//		// rr.checkGroup();
//
//	
//	}
	
	public XSOMNavigator_itemDesc_from_xsd(String msgName, String rootEle, Worker4ItemDescription dd) {
		this.msgName = msgName;
		this.rootEle = rootEle;
		
		
		this.dd = dd;

		ReadItemTblDoc rr = new ReadItemTblDoc();
		rr.readin(msgName);
		// rr.checkGroup();

		// dd = new Worker4ItemDescription(msgName);
		// dd.openDoc();
	}

	DSAnnotationRef getImpostantAnno(XSAnnotation xsAnnotation) {
		DSAnnotationRef dsref = new DSAnnotationRef();
		if (xsAnnotation == null) {
			// out.println(" Errror --> No Annotation ");
			// throw new RuntimeException("!! No Annotation !! --->" + "[Element " + absPath + "]");
		} else {
			Object obj = xsAnnotation.getAnnotation();
			AnnotationDAO a = (AnnotationDAO) obj;
			if (a.ObjectClassTerm != null & a.PropertyTerm == null) {// This is a class
				dsref.uid = "";
				dsref.den = "";
				dsref.cls = a.ObjectClassTerm;
				dsref.cardinality = a.Cardinality;
				dsref.enDef = a.Definition;
				dsref.isClass = true;
			} else if (a.ObjectClassTerm != null & a.PropertyTerm != null) {// This is a property
				// if (a.DictionaryEntryName == null) {
				// throw new RuntimeException("!!NO DEN!! --->" + "[Element " + absPath + "]");
				// }
				dsref.uid = a.UniqueID;
				dsref.den = a.DictionaryEntryName;
				dsref.cls = a.ObjectClassTerm;
				dsref.cardinality = a.Cardinality;
				dsref.enDef = a.Definition;
				dsref.chn = a.chineseName;
				dsref.remark = a.remark;
				dsref.isClass = false;
			} else {
				// throw new RuntimeException("!!Wrong Annotation!! --->" + "[Element " + absPath + "]");
			}
		}
		return dsref;
	}

	// ---------------------------------------------------------------------------

	String delimiter = "/";

	private void printElement(XSElementDecl element, String absPath) throws IOException {

		XSParticle particle = element.getType().asComplexType().getContentType().asParticle();

		if (!particle.getTerm().isModelGroup())// // term is not "sequence" or ....
			return;

		Itemtable itemtable = new Itemtable();

		{
			DSAnnotationRef dsref = getImpostantAnno(element.getAnnotation());

//			System.out.println("\n\n" + element.getName() + "-->" + getOccurence(particle) + "--->" + element.getType()
//					+ "," + absPath + "," + dsref.cls);

			itemtable.classname = element.getName();
			itemtable.clsHiarachy = absPath;

			TWDENS_DAO dends0 = dd.getCls(dsref.cls);

			itemtable.mc = dd.getmc(dsref.cardinality);
			itemtable.cardinality = dsref.cardinality;
			itemtable.functionDescription = dends0.enDef;

		}
		// ----------------------------------------------------------------------------------
		int n = 1;
		for (XSParticle par : particle.getTerm().asModelGroup().getChildren()) {// each element in sequence

			XSTerm trm = par.getTerm();

			if (trm.isModelGroup()) {
				System.out.println("n=====" + n + " isModelGroup ");
			} else if (trm.isWildcard()) {
				System.out.println("n=====" + n + " isWildcard ");
			} else if (trm.isElementDecl()) {// each element in sequence

				XSElementDecl ele = trm.asElementDecl();

				// String tpe = "Unknown";
				// String basicType = new BasicType().canMapTo(ele.getType().getBaseType().getName());
				// if (basicType == null) {
				// tpe = "Class";
				// } else {
				// tpe = "Property";
				// }

				{
					DSAnnotationRef dsref = getImpostantAnno(ele.getAnnotation());

					if (dsref.isClass) {

//						System.out.println("n=====" + n + " : " + "Class" + "-->" + ele.getName() + ","
//								+ getOccurence(par) + "," + dsref.cls);

						Item item2 = new Item();
						item2.itemString = "<" + ele.getName() + ">";
						item2.mc = dd.getmc(dsref.cardinality);
						item2.datatype = "Aggregate";
						itemtable.items.add(item2);

					} else {// Property
//						System.out.println("n=====" + n + " : " + "Property" + "-->" + ele.getName() + ","
//								+ getOccurence(par) + "," + dsref.uid);

						TWDENS_DAO dends = dd.getProp(dsref);

						// ~~~~~~~~~~~~~~~~~~~~
						// get remark of item table, check consistency at the same time~
						String rmk = dd.compare(dsref.chn, dends.enName, dends.format, dends.codeList);
						// ~~~~~~~~~~~~~~~~~~~~

						Item item = new Item();
						item.itemString = "<" + ele.getName() + ">" + "---" + dends.enName + "---" + dsref.chn;
						item.mc = dd.getmc(dsref.cardinality);
						item.datatype = dd.getType(dsref.den);
						item.length = dends.format;
						// item.rmk = dends.codeList;
						item.rmk = rmk;
						itemtable.items.add(item);

						if (dsref.chn.contains(";")) {
							StringTokenizer st = new StringTokenizer(dsref.chn, ";");
							while (st.hasMoreTokens()) {
								dsref.chn = st.nextToken();
								TWDENS_DAO xx = dd.getProp(dsref);

								Item item2 = new Item();
								item2.itemString = xx.enName + "---" + dsref.chn;
								item2.length = xx.format;
								itemtable.items.add(item2);
							}
						}

						itemtable.sampleLines.add("\t" + "<" + ele.getName() + ">" + dends.sample + "</"
								+ ele.getName() + ">");

						itemtable.descriptions.add("<" + ele.getName() + ">" + "表示" + dends.chDef);

					}
				}
			}
			n++;
		}

		// dd.out2Console(itemtable);

		dd.out2Doc(itemtable);

		// ----------------------------------------------------------------------------------

		for (XSParticle par : particle.getTerm().asModelGroup().getChildren()) {// each element in sequence

			XSTerm trm = par.getTerm();

			if (!trm.isElementDecl())
				continue;

			XSElementDecl ele = trm.asElementDecl();

			if (!ele.getType().isComplexType())
				continue;

			if (ele.getType().asComplexType().getContentType().asParticle() == null)
				continue;

			// String path = "";
			// if (rootEle.equals(ele.getName()))
			// path = ele.getName();
			// else
			// path = absPath + delimiter + ele.getName();

			printElement(ele, absPath + delimiter + ele.getName());

		}

	}

	String getOccurence(XSParticle particle) {
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
		// System.out.println(occurs + "," + MC);
		return occurs + "," + MC;

	}

}
