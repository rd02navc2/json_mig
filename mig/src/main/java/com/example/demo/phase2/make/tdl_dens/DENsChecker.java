package com.example.demo.phase2.make.tdl_dens;

public class DENsChecker {

	void check(String src, String den, String objectClassTerm, String propertyTerm, String representationTerm,
			String namedComplexType, String xmlTagName) {

		String myDen = objectClassTerm.trim() //
				+ ". " + propertyTerm.trim() //
				+ ". " + representationTerm.trim();
		if (!myDen.equals(den)) {
			System.err.println("DEN Error==>\ndb den=\n" + den + "\nif combine from flds=\n" + myDen + "\n");
		}

		String myNamedComplexType = objectClassTerm.replace(" ", "").trim() //
				+ propertyTerm.replace(" ", "").trim()//
				+ namedComplexTypeTailStr(representationTerm.trim());
		if (!myNamedComplexType.equals(namedComplexType)) {
			System.err.println("namedComplexType Error==>" + den + "\n" + namedComplexType + "\n" + myNamedComplexType
					+ "\n");
		}

		String myXmlTagName = xmlTagNameStr(src, propertyTerm, representationTerm);
		if (!myXmlTagName.equals(xmlTagName)) {
			System.err.println("xmlTagName Error==>" + den + "\n" + xmlTagName + "\n" + myXmlTagName + "\n");
		}

	}

	String namedComplexTypeTailStr(String representationTerm) {
		String s = "";

		if (representationTerm.equals("Text")) {
			return "TextType";
		} else if (representationTerm.equals("Amount")) {
			return "AmountType";
		} else if (representationTerm.equals("Quantity")) {
			return "QuantityType";
		} else if (representationTerm.equals("Measure")) {
			return "MeasureType";
		} else if (representationTerm.equals("Numeric")) {
			return "NumericType";
		} else if (representationTerm.equals("Percent")) {
			return "PercentType";
		} else if (representationTerm.equals("Identifier")) {
			return "IDType";
		} else if (representationTerm.equals("Code")) {
			return "CodeType";
		} else if (representationTerm.equals("Date")) {
			return "DateType";
		} else if (representationTerm.equals("Date Time")) {
			return "DateTimeType";
		}
		return s;
	}

	String xmlTagNameStr(String src, String propertyTerm, String representationTerm) {
		String s = "";
		String tail = "";
		if (representationTerm.equals("Text")) {
			tail = "";
		} else if (representationTerm.equals("Amount")) {
			tail = "Amount";
		} else if (representationTerm.equals("Quantity")) {
			tail = "Quantity";
		} else if (representationTerm.equals("Measure")) {
			tail = "Measure";
		} else if (representationTerm.equals("Numeric")) {
			tail = "Numeric";
		} else if (representationTerm.equals("Percent")) {
			tail = "Percent";
		} else if (representationTerm.equals("Identifier")) {
			tail = "ID";
		} else if (representationTerm.equals("Code")) {
			tail = "Code";
		} else if (representationTerm.equals("Date")) {
			tail = "Date";
		} else if (representationTerm.equals("Date Time")) {
			tail = "DateTime";
		}

		s = propertyTerm.replace(" ", "").trim() + tail;

		if (s.equals("IdentificationID"))
			s = "ID";

		if (src.equals("TW"))
			s = "tw_" + s;
		return s;
	}
}
