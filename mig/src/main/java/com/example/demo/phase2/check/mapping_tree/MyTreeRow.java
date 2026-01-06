package com.example.demo.phase2.check.mapping_tree;

public class MyTreeRow {
	public String sn = "-";
	public String occur = "";
	public String mc = "";
	public String classid = "";
	public String propid = "";
	public String tree = "";
	public String chnName = "";
	public String enName = "";
	public String format = "";
	public String enDef = "";
	public String chnDef = "";
	

	public void prn() {
		System.out.println(occur + "\t" + mc + "\t" + classid + "\t" + propid + "\t" + tree + "\t" + chnName + "\t"
				+ format);
	}
}