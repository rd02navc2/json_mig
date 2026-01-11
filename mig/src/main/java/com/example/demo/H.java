package com.example.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.phase1.ResponseAbstract;
import com.example.demo.phase1.SingleMsgXmlWrapper;
import com.example.demo.phase1.SingleMsgXsdWrapper;
import com.example.demo.phase1.XmaTwXsdBuilder;
import com.example.demo.phase2.check.chap4n8.CheckChapter4n8;
import com.example.demo.phase2.check.format_etc.CheckDataItemFormatetc;
import com.example.demo.phase2.check.mapping_tree.CheckTree;
import com.example.demo.phase2.make.data_item_set.ProduceDataItemSet;
import com.example.demo.phase2.make.item_desc_tbl.MakeItemDescTemplate;
import com.example.demo.phase2.make.mapping_tree.MakeMappingTree;
import com.example.demo.phase2.make.tdl_dens.MakeTDLDENs;
import com.example.demo.utils.DynamicClassLoader;
import com.example.demo.utils.ListCodeReference;
import com.example.demo.utils.process.n.mig.CheckProcessFileWithItemTable;
import com.example.demo.utils.process.n.mig.WriteHarmoResultDoc;

public class H {

	public static void mappingXml() throws Exception {
		MyConst.ttype = MyConst.XML;

		for (int i = 0; i < MyConst.msg.length; i++) {

			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.msg[i][2];

			// if (!msgName.equals("NX5105"))
			// continue;

			// ---------------------------------------------------------------
			Class cls = Class.forName("_harmo.MyMapping");
			Constructor ctor = cls.getDeclaredConstructor(String.class);
			ctor.setAccessible(true);
			ResponseAbstract o = (ResponseAbstract) ctor.newInstance(msgName);
			// Method mthd = cls.getDeclaredMethod(aMethod, params);
			Method mthd = cls.getMethod("getSchema", new Class[] {});
			String xx = (String) mthd.invoke(o, new Object[] {});

			// Or
			// MyMapping o = new MyMapping(msgName);
			// ---------------------------------------------------------------

			String body = o.getSchema();

			SingleMsgXmlWrapper.genSingleMsgsXmls(msgName, rootEleName, schemaFile, o);
			System.out.println((i + 1) + "-" + msgName + " xml done!\n");
		}
	}

	public static void mappingXsd() throws Exception {
		MyConst.ttype = MyConst.Single;
		DynamicClassLoader dynamicClassLoader = new DynamicClassLoader();
		
		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.msg[i][2];

			// ---------------------------------------------------------------
			Class cls = Class.forName("com.example.demo.MyMapping");
		    // 從 resources 動態載入
			
			// Class<?> cls = dynamicClassLoader.loadClassFromResource("template/MyMapping.java");
			Constructor ctor = cls.getDeclaredConstructor(String.class);
			ctor.setAccessible(true);
			ResponseAbstract o = (ResponseAbstract) ctor.newInstance(msgName);
			// Method mthd = cls.getDeclaredMethod(aMethod, params);
			Method mthd = cls.getMethod("getSchema", new Class[] {});
			String xx = (String) mthd.invoke(o, new Object[] {});

			// Or
			// MyMapping o = new MyMapping(msgName);
			// ---------------------------------------------------------------

			String body = o.getSchema();

			SingleMsgXsdWrapper.genSingleMsgXsd(msgName, rootEleName, schemaFile, o);
			System.out.println((i + 1) + "-" + msgName + " xsd done!\n");
		}

		XmaTwXsdBuilder.writeTwDsXsdFile();  
	}

	public static void checkDataItemFormatetc() {
		CheckDataItemFormatetc.run();
	}

	public static void checkChapter4n8() {
		CheckChapter4n8.run();
	}

	public static void checkTree() {
		CheckTree.run();
	}

	public static void makeTDLDENs() {
		MakeTDLDENs.run();
	}

	public static void makeItemDescTemplate() {
		MakeItemDescTemplate.run();
	}

	public static void makeMappingTree() {
		MakeMappingTree.run();
	}

	public static void makeDataItemSet() {
		ProduceDataItemSet.run();
	}

	public static void listCodeReference() {
		ListCodeReference.run();
	}

	public static void checkProcessFileWithItemTable() {
		CheckProcessFileWithItemTable.run();
	}

	public static void writeHarmoResultDoc() {
//		M mmm = new M();
//		WriteHarmoResultDoc_ForOldNewMap.run(mmm);
		 WriteHarmoResultDoc.run();
	}
/*
	public static void main(String[] args) {

	}
*/
}

