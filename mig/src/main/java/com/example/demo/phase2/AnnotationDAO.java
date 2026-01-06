package com.example.demo.phase2;

public class AnnotationDAO {

	public String UniqueID;
	public String DictionaryEntryName;
	public String Definition;
	public String Cardinality;
	public String ObjectClassTerm;
	public String PropertyTerm;
	public String RepresentationTerm;
	public String chineseName;
	public String remark="";
	public String format="";
	// public String tw_id; // Used to look up data in TDL
	//
	// public String oldChName;
	// public String oldS;
	// public String oldG;
	// public String oldE;
	//
	// public String changeReason;
	//
	// public String newS;
	// public String newG;
	// public String newE;
	//
	// public String cardinality;
	//
	// public String M_C;
	//
	// public String FMOCD;

	// -------------------------------------------------------
	// iii annotations

	String sn = "";
	String oldS = "";
	String oldG = "";
	String oldE = "";
	String oldChName = "";
	String oldEnName = "";
	String oldProp = "";
	String oldMC = "";
	String oldAirSea = "";
	String note94 = "";
	String changeReason = "";
	String newS = "";
	String newG = "";
	String newE = "";
	String newChName = ""; // as key
	// String newEnName =""; // should be retrived from TDL by key
	// String newChDef =""; // should be retrived from TDL by key
	// String newEnDef =""; // should be retrived from TDL by key
	// String newProp =""; // should be retrived from TDL by key
	String M_C = "";
	String wcoId = "";// should be retrived from TDL by key
	String wcoName = "";// should be retrived from TDL by key
	String FMOCD = "";

	public String allMsgs = "";

	public boolean isClass = false;

}
