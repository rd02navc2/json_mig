package com.example.demo.utils.process.compare.oldnew.chname;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.example.demo.MyConst;

public class Main {

	static HashMap hm = new HashMap();

	// ArrayList newDataElements = new ArrayList();

	public static void run() throws Exception {

		ProcessFileReader processFileReader = new ProcessFileReader();

		for (int i = 0; i < MyConst.msg.length; i++) {
			String msgName = MyConst.msg[i][0];
			String rootEleName = MyConst.msg[i][1];
			String schemaFile = MyConst.msg[i][2];
			// run((i+1),msgName);

			processFileReader.getContent(msgName);
			ArrayList oneTableRows = processFileReader.getTableRows();
			// processFileReader.prnOneTableRows();

			collectData(msgName, oneTableRows);

			// System.out.println("*******************************************");
		}
	}

	static void collectData(String msgName, ArrayList oneTableRows) {

		for (int i = 0; i < oneTableRows.size(); i++) {

			X x = (X) oneTableRows.get(i);

			if (x.oldChnName.trim().equals("") || x.oldFormat.trim().equals(""))
				continue;

			String newChnameKey = x.newChnName + "  " + x.newFormat + "";
			String oldChnameKey = x.oldChnName + "  " + x.oldFormat + "";

			if (hm.containsKey(newChnameKey)) {

				HashMap oldChnsWithThisNewChn = (HashMap) hm.get(newChnameKey);

				if (oldChnsWithThisNewChn.containsKey(oldChnameKey)) {
					ArrayList msgNames = (ArrayList) oldChnsWithThisNewChn.get(oldChnameKey);
					msgNames.add(msgName);
				} else {
					ArrayList msgNames = new ArrayList();
					msgNames.add(msgName);
					oldChnsWithThisNewChn.put(oldChnameKey, msgNames);
				}

			} else {
				HashMap oldChnsWithThisNewChn = new HashMap();
				ArrayList msgNames = new ArrayList();
				msgNames.add(msgName);
				oldChnsWithThisNewChn.put(oldChnameKey, msgNames);

				hm.put(newChnameKey, oldChnsWithThisNewChn);
			}

			// System.out.println(i + "\t" + x.newChnName + "(" + x.newFormat + ")" + "\t" + x.oldChnName + "(" + x.oldFormat + ")");
		}

	}

	public static void prn() {

		Iterator it = hm.keySet().iterator();
		while (it.hasNext()) {
			String newChnameKey = (String) it.next();

			System.out.println(newChnameKey);

			HashMap oldChnsWithThisNewChn = (HashMap) hm.get(newChnameKey);

			Iterator it2 = oldChnsWithThisNewChn.keySet().iterator();

			while (it2.hasNext()) {
				String oldChnameKey = (String) it2.next();
				System.out.print("\t" + oldChnameKey);

				ArrayList msgNames = (ArrayList) oldChnsWithThisNewChn.get(oldChnameKey);
				for (int i = 0; i < msgNames.size(); i++) {
					String msg = (String) msgNames.get(i);
					System.out.print("\t" + msg);
				}

				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws Exception {

		Main.run();

		Main.prn();
	}

}
