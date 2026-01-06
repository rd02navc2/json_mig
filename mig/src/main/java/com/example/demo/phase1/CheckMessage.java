package com.example.demo.phase1;

public class CheckMessage {

	public static boolean hasMessage(String theStr, String msgName) {
		// System.out.println(theStr);
		String[] seg = theStr.split(",");
		for (int i = 0; i < seg.length; i++) {
			int idx = seg[i].indexOf("=");
			String name = seg[i].substring(0, idx).trim();
			String val = seg[i].substring(idx + 1).trim();
			// System.out.println(name + "---->" + val);

			if (name.equals("name") && val.equals(msgName)) {
				return true;
			}

		}
		return false;
	}

	public static void main(String[] args) {

	}

}
