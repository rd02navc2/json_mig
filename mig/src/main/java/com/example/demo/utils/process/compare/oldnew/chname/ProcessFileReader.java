package com.example.demo.utils.process.compare.oldnew.chname;

import java.io.File;
import java.util.ArrayList;

import com.example.demo.MyConst;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

/*
 * 抓過程檔資料
 */
public class ProcessFileReader {

	// public static HashMap mapped = new HashMap();
	// public static HashMap added = new HashMap();
	// public static HashMap deleted = new HashMap();

	// public static HashMap errors = new HashMap();

	String path = MyConst.getProcessFilePath();

	// ReadTWDatasetExcel tdl = null;

	public ProcessFileReader() {
		// tdl = new ReadTWDatasetExcel();
		// tdl.readExcel();
		// System.getProperties().put("org.apache.commons.logging.simplelog.defaultlog","error");
		System.getProperties().put("jxl.nowarnings", "true");

	}

	// public void doit() throws Exception {
	//
	// for (int i = 0; i < MyConst.msg.length; i++) {
	// String msgName = MyConst.msg[i][0];
	//
	// System.out.println("******************" + msgName + "*****************************");
	//
	// getContent(msgName);
	//
	// // getContent(msgName);
	//
	// // if (i == 0)
	// // break;
	// }

	// }

	// void prnMap(HashMap mp) {
	// Iterator it = mp.keySet().iterator();
	//
	// while (it.hasNext()) {
	// String k = (String) it.next();
	//
	// ArrayList msgList = (ArrayList) mp.get(k);
	//
	// String xxx = "";
	// for (int i = 0; i < msgList.size(); i++) {
	// String msg = (String) msgList.get(i);
	// xxx = xxx + msg;
	// if (i != msgList.size()) {
	// xxx = xxx + " ";
	// }
	// }
	//
	// System.out.println(k + "\t" + xxx);
	// }

	// }

	ArrayList oneTableRows = new ArrayList();

	ArrayList cancledOldMsgRows = new ArrayList();

	ArrayList newMsgRows = new ArrayList();

	public void prnOneTableRows() {
		for (int i = 0; i < oneTableRows.size(); i++) {
			X x = (X) oneTableRows.get(i);
			System.out.println(i + "\t" + x.newChnName + "(" + x.newFormat + ")" + "\t" + x.oldChnName + "(" + x.oldFormat + ")");
		}
	}

	ArrayList getTableRows() throws Exception {
		return oneTableRows;
	}

	ArrayList getCancelled() throws Exception {
		return cancledOldMsgRows;
	}

	ArrayList getNewMsgRows() throws Exception {
		return newMsgRows;
	}

	void getContent(String msgName) throws Exception {
		try {
			String fullname = path + "過程檔-" + msgName + ".xls";

			oneTableRows = new ArrayList();

			File inputWorkbook = new File(fullname);

			Workbook w = Workbook.getWorkbook(inputWorkbook);

			// -----------------------------------------------------
			{
				Sheet sheet = w.getSheet("過程檔");

				if (sheet == null) {
					System.err.println(fullname + " =====>>> null");
				}

				int startRow = 2;

				for (int row = startRow; row < sheet.getRows(); row++) {
					X rowObject = new X();
					// rowObject.msg = msgName;
					// if(row>10)break;

					for (int col = 0; col < sheet.getColumns(); col++) {

						Cell cell = sheet.getCell(col, row);
						CellType type = cell.getType();

						String x = "";

						// if (col == 3 && cell.getType() == CellType.NUMBER) {
						// x = "000" + cell.getContents();
						// x = x.substring(cell.getContents().length());
						// } else {
						x = "" + cell.getContents();
						// }

						x = x.trim();
						// System.out.print(x);
						// System.out.print("\t");

						if (col == 0) {
							// rowObject.seq = x;
						} else if (col == 4) {
							rowObject.oldChnName = x;
						} else if (col == 5) {
							rowObject.oldEngName = x;
						} else if (col == 6) {

							rowObject.oldFormat = x;
						} else if (col == 7) {
							rowObject.oldMC = x;
						} else if (col == 8) {
							rowObject.oldSeaAir = x;

						} else if (col == 10) {
							rowObject.changedContent = x;
						} else if (col == 11) {
							rowObject.newS = x;

						} else if (col == 12) {
							rowObject.newG = x;

						} else if (col == 13) {
							rowObject.newE = x;

						} else if (col == 14) {
							rowObject.newChnName = x;
						} else if (col == 15) {
							rowObject.newEngName = x;
						} else if (col == 18) {
							rowObject.newFormat = x;
						} else if (col == 19) {
							rowObject.newMC = x;
						} else if (col == 20) {

							if (cell.getType() == CellType.NUMBER) {
								// if (x.endsWith("]")) {
								// x = x.substring(0, x.length() - 1);
								// }
								x = "000" + cell.getContents();
								x = x.substring(x.length() - 4, x.length() - 1);
							}
							rowObject.newWCOID = x;
						} else if (col == 22) {
							rowObject.cancelOrNot = x;
						}

					}// one row end

					// -------------------------------------------------------------------------------
					if (!rowObject.newE.equals("")) {
						rowObject.newS = "";
						rowObject.newG = "";
					}
					if (!rowObject.newS.equals("")) {
						rowObject.newG = "";

					}
					// -------------------------------------------------------------------------------
					// 比較新舊 format
					// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

					String oldNum = "";
					if (!rowObject.newChnName.trim().equals("") && !rowObject.cancelOrNot.trim().equals("C")) {

						if (!rowObject.oldFormat.trim().equals("")) {
							if ((rowObject.oldFormat.indexOf("(") < 0) || (rowObject.oldFormat.indexOf(")") < 0)) {
								throw new RuntimeException(msgName + "--->" + rowObject.oldChnName + " Number format error!!!!!!!" + rowObject.oldFormat);
							} else {
								int start = rowObject.oldFormat.indexOf("(") + 1;
								int end = rowObject.oldFormat.indexOf(")");

								oldNum = rowObject.oldFormat.substring(start, end).trim();
								// System.out.println(rowObject.oldChnName + "-->" + rowObject.oldFormat + "," + start + "," + end + "," + oldNum);

								if (oldNum.startsWith("0"))
									oldNum = oldNum.substring(1);
							}
						}

						String newNum = "";
						if (!rowObject.newFormat.trim().equals("")) {
							String x = rowObject.newFormat;
							if (x.startsWith("an")) {
								newNum = x.substring(2).trim();
							} else if (x.startsWith("a")) {
								newNum = x.substring(1).trim();
							} else if (x.startsWith("n")) {
								newNum = x.substring(1).trim();
							}

							if (newNum.startsWith("..")) {
								newNum = newNum.substring(2);
							}

						}
						// System.out.println(rowObject.newChnName + "-XXXXXXXXXXXX->" + rowObject.newFormat + "," + newNum);

						if (!oldNum.trim().equals("") && !newNum.trim().equals("")) {
							if (oldNum.trim().equals(newNum.trim())) {
								rowObject.diffLen = false;
							} else {
								rowObject.diffLen = true;
							}
						}

						// 比較新舊 format
						// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

						// 比較新舊中文名稱
						if (!rowObject.newChnName.trim().equals("") && !rowObject.oldChnName.trim().equals("") && !rowObject.oldChnName.trim().equals(rowObject.newChnName.trim())) {
							rowObject.diffChnName = true;
						} else {
							rowObject.diffChnName = false;
						}

						// 比較新舊英文名稱
						if (!rowObject.newEngName.trim().equals("") && !rowObject.oldEngName.trim().equals("") && !rowObject.oldEngName.trim().equalsIgnoreCase(rowObject.newEngName.trim())) {
							rowObject.diffEnName = true;
						} else {
							rowObject.diffEnName = false;
						}

						// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
						// 檢查修正內容正確性
						String xxxxx = rowObject.changedContent.replace("\n", "---");

						if (rowObject.diffChnName) {
							if (!xxxxx.contains("中文名稱")) {
								rowObject.changedError = true;
							}
						} else {
							if (xxxxx.contains("中文名稱")) {
								rowObject.changedError = true;
							}
						}

						if (rowObject.diffEnName) {
							if (!xxxxx.contains("英文名稱")) {
								rowObject.changedError = true;
							}
						} else {
							if (xxxxx.contains("英文名稱")) {
								rowObject.changedError = true;
							}
						}

						if (rowObject.diffLen) {
							if (!xxxxx.contains("長度")) {
								rowObject.changedError = true;
							}
						} else {
							if (xxxxx.contains("長度")) {
								rowObject.changedError = true;
							}
						}

						// System.out.println(xxxxx);

						// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
						oneTableRows.add(rowObject);
					}

					if (rowObject.cancelOrNot.trim().equals("N"))
						newMsgRows.add(rowObject);

					if (rowObject.cancelOrNot.trim().equals("C"))
						cancledOldMsgRows.add(rowObject);

					// ----------------------------------------------------------------
					// collect error
					// TDL_DS ds = tdl.getTWDS(rowObject.newChnName);
					// if (ds == null) {
					// String ek = k + "\tno entry in tdl";
					// // System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					// // System.err.println(k + "---> no entry in tdl");
					// // System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					// // throw new RuntimeException("===>>>"+msgName);
					//
					// if (errors.containsKey(ek)) {
					// ArrayList ar = (ArrayList) errors.get(ek);
					// if (!ar.contains(msgName))
					// ar.add(msgName);
					// } else {
					// ArrayList ar = new ArrayList();
					// ar.add(msgName);
					// errors.put(ek, ar);
					// }
					//
					// } else if (!ds.format.equals(rowObject.newFormat)) {
					//
					// String ek = k + "\tformat should be " + ds.format;
					//
					// // System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					// // System.err.println(k + "---> format should be " + ds.format);
					// // System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					// // throw new RuntimeException("===>>>"+msgName);
					//
					// if (errors.containsKey(ek)) {
					// ArrayList ar = (ArrayList) errors.get(ek);
					// if (!ar.contains(msgName))
					// ar.add(msgName);
					// } else {
					// ArrayList ar = new ArrayList();
					//
					// ar.add(msgName);
					// errors.put(ek, ar);
					// }
					// }
					// ----------------------------------------------------------------
					// collect mapped
					// if (!rowObject.oldChnName.equals("") && !rowObject.newChnName.equals("")) {
					// System.out.println(k);
					//
					// if (mapped.containsKey(k)) {
					// ArrayList ar = (ArrayList) mapped.get(k);
					// if (!ar.contains(msgName))
					// ar.add(msgName);
					// } else {
					// ArrayList ar = new ArrayList();
					//
					// ar.add(msgName);
					// mapped.put(k, ar);
					// }
					//
					// // } else if (!rowObject.oldChnName.equals("") && rowObject.newChnName.equals("")) {
					// // // System.out.println(rowObject.oldChnName + "\t" + rowObject.newChnName);
					// //
					// // if (deleted.containsKey(k)) {
					// // ArrayList ar = (ArrayList) deleted.get(k);
					// // ar.add(msgName);
					// // } else {
					// // ArrayList ar = new ArrayList();
					// // ar.add(msgName);
					// // deleted.put(k, ar);
					// // }
					//
					// // ----------------------------------------------------------------
					// // collect added
					//
					// } else if (rowObject.oldChnName.equals("") && !rowObject.newChnName.equals("")) {
					// // System.out.println(rowObject.oldChnName + "\t" + rowObject.newChnName);
					// if (added.containsKey(k)) {
					// ArrayList ar = (ArrayList) added.get(k);
					// if (!ar.contains(msgName))
					// ar.add(msgName);
					// } else {
					// ArrayList ar = new ArrayList();
					// ar.add(msgName);
					// added.put(k, ar);
					// }
					// }

					// System.out.println();

					// oneTableRows.add(rowObject);
				}
			}
			// ------------------------------------------------------------------
			// {
			// Sheet sheet = w.getSheet("刪除項目");
			//
			// if (sheet == null) {
			// System.err.println(fullname + " =====>>> null");
			// }
			//
			// int startRow = 3;
			//
			// for (int row = startRow; row < sheet.getRows(); row++) {
			// X rowObject = new X();
			// // rowObject.msg = msgName;
			// // if(row>10)break;
			//
			// for (int col = 0; col < sheet.getColumns(); col++) {
			//
			// Cell cell = sheet.getCell(col, row);
			// CellType type = cell.getType();
			//
			// String x = "";
			// // if (col == 3 && cell.getType() == CellType.NUMBER) {
			// // x = "000" + cell.getContents();
			// // x = x.substring(cell.getContents().length());
			// // } else {
			// x = "" + cell.getContents();
			// // }
			//
			// x = x.trim();
			// // System.out.print(x);
			// // System.out.print("\t");
			//
			// if (col == 0) {
			// // rowObject.seq = x;
			// } else if (col == 13) {
			// rowObject.oldChnName = x;
			// }
			//
			// }// one row end
			//
			// String k = rowObject.oldChnName;
			//
			// if (k.equals(""))
			// continue;
			//
			// System.out.println(msgName + "-->" + rowObject.oldChnName + "deleted !!");
			//
			// if (deleted.containsKey(k)) {
			// ArrayList ar = (ArrayList) deleted.get(k);
			// if (!ar.contains(msgName))
			// ar.add(msgName);
			// } else {
			// ArrayList ar = new ArrayList();
			// ar.add(msgName);
			// deleted.put(k, ar);
			// }
			//
			// // System.out.println();
			//
			// // oneTableRows.add(rowObject);
			// }
			// }
			// ------------------------------------------------------------------

			// return oneTableRows;
		} catch (Exception e) {
			// e.printStackTrace();
			// return null;

			throw e;
		}
	}

	public static void main(String[] args) throws Exception {
		ProcessFileReader processFileReader = new ProcessFileReader();
		processFileReader.getContent("N5101");
		ArrayList processFileData = processFileReader.getTableRows();
		processFileReader.prnOneTableRows();

		// System.out.println("%%%%%%%%%%%&&&&&&&&&&&&&&&Mapped&&&&&&&&&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		// o.prnMap(mapped);
		// System.out.println("%%%%%%%%%%%&&&&&&&&&&&&&&&Added&&&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		// o.prnMap(added);
		// System.out.println("%%%%%%%%%%%&&&&&&&&&&&&&&&Deleted&&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		// o.prnMap(deleted);
		// System.out.println("%%%%%%%%%%%&&&&&&&&&&&&&&&Errors&&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		// o.prnMap(errors);

	}

}
