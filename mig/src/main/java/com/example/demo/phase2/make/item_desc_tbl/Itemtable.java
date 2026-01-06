package com.example.demo.phase2.make.item_desc_tbl;

import java.util.ArrayList;


public class Itemtable {
	public String classname = "";
	public String mc = "";
	public String cardinality = "";
	public String clsHiarachy = "";
	public String functionDescription = "";

	public ArrayList<Item> items = new ArrayList<Item>();// 資料項目
	public ArrayList<String> descriptions = new ArrayList<String>();// 說明
	public ArrayList<String> sampleLines = new ArrayList<String>();// 範例
}