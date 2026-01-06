package com.example.demo.phase2.make.data_item_set;

import java.io.IOException;
import java.util.ArrayList;

public class EnglishNameCompare {

	ArrayList arTWDens = new ArrayList();
	ArrayList arTWWCODens = new ArrayList();
	ArrayList arWCO = new ArrayList();

	public EnglishNameCompare() {

	}

	public void comp() throws IOException {
		ReadTWDatasetExcel test = new ReadTWDatasetExcel();

		test.readDens();

		arTWDens = test.arTWDens;

		arTWWCODens = test.arWCODens;

		// ---------------------------------------------------------
		// fetch data
		ReadWCOBaseExcel wco = new ReadWCOBaseExcel();

		wco.readWCODens();
		// test.readWCOClass();
		// wco.findUsedDens();

		arWCO = wco.arWCODens;
		// ---------------------------------------------------------

		for (int i = 0; i < arTWDens.size(); i++) {
			WCOBaseDens tw = (WCOBaseDens) arTWDens.get(i);
			if (tw.wcoid.endsWith("*")) {

				if (hasNoStarElement(tw.wcoid)) {
					System.out.println(tw.wcoid + "(v)" + "\t" + tw.name + "\t" + tw.def);
				} else {
					System.out.println(tw.wcoid + "\t" + tw.name + "\t" + tw.def);
				}

				String x = tw.wcoid.substring(0, tw.wcoid.length() - 1);

				for (int j = 0; j < arWCO.size(); j++) {
					WCOBaseDens w = (WCOBaseDens) arWCO.get(j);

					// if(x.equals("115")){
					// System.err.println(w.wcoid + "\t" + w.name);
					// }

					if (w.wcoid.equals(x)) {
						if (!tw.name.equals(w.name) || !tw.def.equals(w.def))
							System.out.println("==>>>" + w.wcoid + "\t" + w.name + "\t" + w.def);
						else
							System.out.println(w.wcoid + "\t" + w.name + "\t" + w.def);
						break;
					}

				}

				System.out.println("");

			}// if (tw.wcoid.endsWith("*"))
		}
	}

	public boolean hasNoStarElement(String twidWithStar) {
		boolean b = false;

		String twidWithoutStar = twidWithStar.substring(0, twidWithStar.length() - 1);

		for (int i = 0; i < arTWWCODens.size(); i++) {
			WCOBaseDens tw = (WCOBaseDens) arTWWCODens.get(i);
			// if (!tw.wcoid.startsWith("TW") && !tw.wcoid.endsWith("*")) {

			if (tw.wcoid.equals(twidWithoutStar)) {
				b = true;
			}
			// }
		}
		return b;
	}

	public static void main(String[] args) throws IOException {

		EnglishNameCompare c = new EnglishNameCompare();
		c.comp();

	}

}
