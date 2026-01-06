package com.example.demo.phase2.make.item_desc_tbl;

import java.util.ArrayList;

public class DSAnnotationRef {
	public String uid = "";
	public String den = "";
	public String cls = "";

	public String enDef = "";

	public String cardinality = "";

	public String chn = "";

	public String boro = "";

	public String sample = "";

	public String remark = "";

	public String allRemark = "";

	public ArrayList msgs = new ArrayList();

	public ArrayList msgPaths = new ArrayList();

	public boolean isClass = false;

	// -------------------------------------------------
	boolean hasMsg(String msg) {
		for (int i = 0; i < msgs.size(); i++) {
			String x = (String) msgs.get(i);
			if (x.equals(msg))
				return true;
		}
		return false;
	}

	public void addMsg(String msg) {
		if (hasMsg(msg))
			return;
		msgs.add(msg);
	}

	// -------------------------------------------------
	boolean hasMsgPath(String msgPath) {
		for (int i = 0; i < msgPaths.size(); i++) {
			String x = (String) msgPaths.get(i);
			if (x.equals(msgPath))
				return true;
		}
		return false;
	}

	public void addMsgPath(String msgPath) {
		if (hasMsgPath(msgPath))
			return;
		msgPaths.add(msgPath);
	}

}