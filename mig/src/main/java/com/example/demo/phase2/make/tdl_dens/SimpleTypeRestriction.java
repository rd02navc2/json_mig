package com.example.demo.phase2.make.tdl_dens;

import java.util.Vector;

import com.sun.xml.xsom.XSFacet;
import com.sun.xml.xsom.XSRestrictionSimpleType;
import com.sun.xml.xsom.XSSimpleType;

public class SimpleTypeRestriction {
	public String[] enumeration = null;
	public String maxValue = null;
	public String minValue = null;
	public String length = null;
	public String maxLength = null;
	public String minLength = null;
	public String[] pattern = null;
	public String totalDigits = null;

	public String toString() {
		String enumValues = "";
		if (enumeration != null) {
			for (String val : enumeration) {
				enumValues += val + ", ";
			}
			enumValues = enumValues.substring(0, enumValues.lastIndexOf(','));
		}

		String patternValues = "";
		if (pattern != null) {
			for (String val : pattern) {
				patternValues += "(" + val + ")|";
			}
			patternValues = patternValues.substring(0, patternValues.lastIndexOf('|'));
		}
		String retval = "";
		retval += maxValue == null ? "" : "[MaxValue  = " + maxValue + "]\t";
		retval += minValue == null ? "" : "[MinValue  = " + minValue + "]\t";
		retval += maxLength == null ? "" : "[MaxLength = " + maxLength + "]\t";
		retval += minLength == null ? "" : "[MinLength = " + minLength + "]\t";
		retval += pattern == null ? "" : "[Pattern(s) = " + patternValues + "]\t";
		retval += totalDigits == null ? "" : "[TotalDigits = " + totalDigits + "]\t";
		retval += length == null ? "" : "[Length = " + length + "]\t";
		retval += enumeration == null ? "" : "[Values = " + enumValues + "]\t";

		return retval;
	}

	public void initRestrictions(XSSimpleType xsSimpleType) {
		XSRestrictionSimpleType restriction = xsSimpleType.asRestriction();
		if (restriction != null) {
			Vector<String> enumeration = new Vector<String>();
			Vector<String> pattern = new Vector<String>();

			for (XSFacet facet : restriction.getDeclaredFacets()) {
				if (facet.getName().equals(XSFacet.FACET_ENUMERATION)) {
					enumeration.add(facet.getValue().value);
				}
				if (facet.getName().equals(XSFacet.FACET_MAXINCLUSIVE)) {
					maxValue = facet.getValue().value;
				}
				if (facet.getName().equals(XSFacet.FACET_MININCLUSIVE)) {
					minValue = facet.getValue().value;
				}
				if (facet.getName().equals(XSFacet.FACET_MAXEXCLUSIVE)) {
					maxValue = String.valueOf(Integer.parseInt(facet.getValue().value) - 1);
				}
				if (facet.getName().equals(XSFacet.FACET_MINEXCLUSIVE)) {
					minValue = String.valueOf(Integer.parseInt(facet.getValue().value) + 1);
				}
				if (facet.getName().equals(XSFacet.FACET_LENGTH)) {
					length = facet.getValue().value;
				}
				if (facet.getName().equals(XSFacet.FACET_MAXLENGTH)) {
					maxLength = facet.getValue().value;
				}
				if (facet.getName().equals(XSFacet.FACET_MINLENGTH)) {
					minLength = facet.getValue().value;
				}
				if (facet.getName().equals(XSFacet.FACET_PATTERN)) {
					pattern.add(facet.getValue().value);
				}
				if (facet.getName().equals(XSFacet.FACET_TOTALDIGITS)) {
					totalDigits = facet.getValue().value;
				}
			}
			if (enumeration.size() > 0) {
				this.enumeration = enumeration.toArray(new String[] {});
			}
			if (pattern.size() > 0) {
				this.pattern = pattern.toArray(new String[] {});
			}
		}
	}

}