package com.example.demo.phase1;

import java.util.StringTokenizer;

import com.example.demo.MyConst;



public class TTT {
	static FNum f1 = null;
	static FNum f2 = null;

	static class FNum {
		String sInt = null;
		String sFra = null;

		void setVal(String s) {
			if (s.contains(",")) {
				String[] digi = s.split(",");
				sInt = digi[0];
				sFra = digi[1];
			} else {
				sInt = s;
				sFra = null;
			}
		}

		void prn() {
			System.out.println(sInt + "," + sFra);
		}

		boolean hasFraction() {
			if (sFra != null)
				return true;
			else
				return false;
		}

	}

	// *****************************************************************************************
	static String getIntStart(int n) {
		return "000000000000000000000000000000000000000000000000000000".substring(0, n);
	}

	static String getIntEnd(int n) {

		// System.out.println("yyyyy="+n);
		return "999999999999999999999999999999999999999999999999999999999".substring(0, n);
	}

	static String fixedNumeric() {
		String xxxx = "";
		if (f1.sFra == null) {
			int len = (new Integer(f1.sInt)).intValue();
			xxxx = "<xsd:minInclusive value=\"" + getIntStart(len) + "\"/>";
			xxxx = xxxx + MyConst.newline;
			xxxx = xxxx + "<xsd:maxInclusive value=\"" + getIntEnd(len) + "\"/>";
			xxxx = xxxx + MyConst.newline;
		} else {

			xxxx = "<xsd:totalDigits value=\"" + f1.sInt + "\"/>";
			xxxx = xxxx + MyConst.newline;
			if (f1.hasFraction()){
				xxxx = xxxx + "<xsd:fractionDigits value=\"" + f1.sFra + "\"/>";
			xxxx = xxxx + MyConst.newline;}
		}
		return xxxx;
	}

	static String fixedString(String format) {
		String xxxx = "";
		if (format.startsWith("n")) {
			xxxx = "<xsd:length value=\"" + f1.sInt + "\"/>";
			xxxx = xxxx + MyConst.newline;
		} else if (format.startsWith("an")) {
			xxxx = "<xsd:length value=\"" + f1.sInt + "\"/>";
			xxxx = xxxx + MyConst.newline;
		} else if (format.startsWith("a")) {
			xxxx = "<xsd:length value=\"" + f1.sInt + "\"/>";
			xxxx = xxxx + MyConst.newline;
		} else {
			xxxx = "String type without a, n, or an??";
			xxxx = xxxx + MyConst.newline;
		}
		return xxxx;
	}

	static String fixed(String namedComplexType, String format) {
		String xxxx = "";

		// if (namedComplexType.endsWith("DeclarationIdentificationIDType")) {
		// xxxx = "<xsd:pattern value=\"[a-zA-Z]{2}[\\s]{2}[a-zA-Z]{10}\"></xsd:pattern>";
		// return xxxx;
		// }

		if (namedComplexType.endsWith("AmountType")) {
			if (format.startsWith("n")) {
				xxxx = fixedNumeric();
			} else {
				xxxx = "AmountType without n??";
				xxxx = xxxx + MyConst.newline;
			}
		} else if (namedComplexType.endsWith("QuantityType")) {
			if (format.startsWith("n")) {
				xxxx = fixedNumeric();
			} else {
				xxxx = "QuantityType without n??";
				xxxx = xxxx + MyConst.newline;
			}
		} else if (namedComplexType.endsWith("MeasureType")) {
			if (format.startsWith("n")) {
				xxxx = fixedNumeric();
			} else {
				xxxx = "MeasureType without n??";
				xxxx = xxxx + MyConst.newline;
			}
		} else if (namedComplexType.endsWith("PercentType")) {
			if (format.startsWith("n")) {
				xxxx = fixedNumeric();
			} else {
				xxxx = "MeasureType without n??";
				xxxx = xxxx + MyConst.newline;
			}
		} else if (namedComplexType.endsWith("NumericType")) {
			if (format.startsWith("n")) {
				xxxx = fixedNumeric();
			} else {
				xxxx = "NumericType without n??";
				xxxx = xxxx + MyConst.newline;
			}
		} else if (namedComplexType.endsWith("IDType")) {
			if (f1.hasFraction()) {
				xxxx = "IDType with  fraction??";
				xxxx = xxxx + MyConst.newline;
				return xxxx;
			}
			xxxx = fixedString(format);
		} else if (namedComplexType.endsWith("CodeType")) {
			if (f1.hasFraction()) {
				xxxx = "CodeType with  fraction??";
				xxxx = xxxx + MyConst.newline;
				return xxxx;
			}
			xxxx = fixedString(format);
		} else {
			xxxx = "<xsd:length value=\"" + f1.sInt + "\"/>";
			xxxx = xxxx + MyConst.newline;
		}
		return xxxx;
	}

	// *****************************************************************************************
	static String zero2Numeric() {
		String xxxx = "";
		if (!f2.hasFraction()) {
			int len = (new Integer(f2.sInt)).intValue();
			xxxx = "<xsd:minInclusive value=\"0\"/>";
			xxxx = xxxx + MyConst.newline;
			xxxx = xxxx + "<xsd:maxInclusive value=\"" + getIntEnd(len) + "\"/>";
			xxxx = xxxx + MyConst.newline;
		} else {
//			xxxx = "<xsd:totalDigits value=\"" + f2.sInt + "\"/>";
//			xxxx = xxxx + MyConst.newline;
//			xxxx = xxxx + "<xsd:fractionDigits value=\"" + f2.sFra + "\"/>";
//			xxxx = xxxx + MyConst.newline;
			
			int intpart=Integer.parseInt(f2.sInt)-Integer.parseInt(f2.sFra);	
			xxxx = "<xsd:pattern value=\"[0-9]{0," + intpart + "}(\\.[0-9]{1," + f2.sFra + "}){0,1}\"></xsd:pattern>";
		}
		return xxxx;
	}

	static String zero2String(String format) {
		String xxxx = "";
		if (format.startsWith("n")) {
			xxxx = "<xsd:minLength value=\"0\"/>" + "<xsd:maxLength value=\"" + f2.sInt + "\"/>";
			xxxx = xxxx + MyConst.newline;
		} else if (format.startsWith("an")) {
			xxxx = "<xsd:minLength value=\"0\"/>" + "<xsd:maxLength value=\"" + f2.sInt + "\"/>";
			xxxx = xxxx + MyConst.newline;
		} else if (format.startsWith("a")) {
			xxxx = "<xsd:minLength value=\"0\"/>" + "<xsd:maxLength value=\"" + f2.sInt + "\"/>";
			xxxx = xxxx + MyConst.newline;
		} else {
			xxxx = "String Type without a, n, or an??";
			xxxx = xxxx + MyConst.newline;
		}
		return xxxx;
	}

	static String zeroUpto(String namedComplexType, String format) {

		// if("GoodsMeasureNetWeightMeasureType".equals(namedComplexType)){
		// System.out.println(namedComplexType+"--"+format+","+f2.sInt+","+f2.sFra);
		// }

		String xxxx = "";

		if (namedComplexType.endsWith("AmountType")) {
			if (format.startsWith("n")) {
				xxxx = zero2Numeric();
			} else {
				xxxx = "AmountType without n??";
				xxxx = xxxx + MyConst.newline;
			}
		} else if (namedComplexType.endsWith("QuantityType")) {
			if (format.startsWith("n")) {
				xxxx = zero2Numeric();
			} else {
				xxxx = "QuantityType without n??";
				xxxx = xxxx + MyConst.newline;
			}

		} else if (namedComplexType.endsWith("MeasureType")) {

			if (format.startsWith("n")) {
				xxxx = zero2Numeric();
			} else {
				xxxx = "MeasureType without n??";
				xxxx = xxxx + MyConst.newline;
			}

		} else if (namedComplexType.endsWith("NumericType")) {
			if (format.startsWith("n")) {
				xxxx = zero2Numeric();
			} else {
				xxxx = "NumericType without n??";
				xxxx = xxxx + MyConst.newline;
			}
		} else if (namedComplexType.endsWith("PercentType")) {
			if (format.startsWith("n")) {
				xxxx = zero2Numeric();
			} else {
				xxxx = "PercentType without n??";
				xxxx = xxxx + MyConst.newline;
			}
		} else if (namedComplexType.endsWith("IDType")) {
			if (f2.hasFraction()) {
				xxxx = "IDType with  fraction??";
				xxxx = xxxx + MyConst.newline;
				return xxxx;
			}

			xxxx = zero2String(format);
		} else if (namedComplexType.endsWith("TextType")) {
			if (f2.hasFraction()) {
				xxxx = "TextType with  fraction??";
				xxxx = xxxx + MyConst.newline;
				return xxxx;
			}

			xxxx = zero2String(format);
		} else if (namedComplexType.endsWith("CodeType")) {

			if (f2.hasFraction()) {
				xxxx = "CodeType with fraction??";
				xxxx = xxxx + MyConst.newline;
				return xxxx;
			}

			xxxx = zero2String(format);
		}
		return xxxx;
	}

	// *****************************************************************************************
	static String twoEnds(String namedComplexType, String format) {

		System.out.println("~~~~~ Two Ends ~~~" + namedComplexType);

		String xxxx = "<xsd:minLength value=\"" + f1.sInt + "\"/>" + "<xsd:maxLength value=\"" + f2.sInt + "\"/>";
		xxxx = xxxx + MyConst.newline;

		return xxxx;
	}

	static String getRestrictionMiddle(String src, String name, String namedComplexType, String cardinality,
			String format, String codeList) {

		String xx = "";

		String remains = "";
		if (format.startsWith("an")) {
			remains = format.substring(2);
		} else if (format.startsWith("a") || format.startsWith("n")) {
			remains = format.substring(1);
		}

		if (remains.contains("..")) {
			if (remains.startsWith("..")) {/////////////////////////////////////ex. an..5, n..5, a..5, n..16,6
				f2 = new FNum();
				f2.setVal(remains.substring(2));
				// f2.prn();

				xx = zeroUpto(namedComplexType, format);
			} else {// a2..3
				FNum[] fnum = { new FNum(), new FNum() };
				StringTokenizer st = new StringTokenizer(remains, "..");
				int n = 0;
				while (st.hasMoreTokens()) {
					fnum[n].setVal(st.nextToken());
					n++;
				}

				f1 = fnum[0];
				// f1.prn();
				f2 = fnum[1];
				// f2.prn();
				xx = twoEnds(namedComplexType, format);
			}
		} else {//////////////////////////////////////////////////////////////ex. an6, n6, a6
			f1 = new FNum();
			f1.setVal(remains);
			// f1.prn();

			xx = fixed(namedComplexType, format);
		}

		return xx;
	}

	static String getcar(String cardinality) {
		// System.out.println("++++++++++++++++++++++++++==>>" + car);

		String[] bb = { "", "" };
		StringTokenizer st = new StringTokenizer(cardinality, "..");
		int ggg = 0;
		while (st.hasMoreTokens()) {
			bb[ggg] = st.nextToken();
			ggg++;
		}

		// System.out.println("++++++++++++++++++++++++++==>>" + car + "," + ggg
		// + "," + bb[0] + "," + bb[1]);

		String minOccurs = "";
		if (bb[0].equals("1"))
			// if (bb[1].equals(""))
			minOccurs = "";
		// else
		// minOccurs = " minOccurs=\"" + bb[0] + "\"";
		else
			minOccurs = " minOccurs=\"" + bb[0] + "\"";

		String maxOccurs = "";
		if (bb[1].equals("") || bb[1].equals("1")) {
			maxOccurs = "";
		} else {
			maxOccurs = " maxOccurs=\"" + bb[1] + "\"";
		}

		return " " + minOccurs + " " + maxOccurs + " ";
	}

	public static void main(String[] args) {
		String format = "a8,99..7";

	}

}
