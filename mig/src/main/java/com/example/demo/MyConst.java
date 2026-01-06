package com.example.demo;

public class MyConst {

	public static String msg[][];
	public static String schemaOutputLocation = "";
	public static String messageListLocation = "";
	public static String TDL_DENsXslLocation = "";
	public static String dataItemSetTemplateLocation = "";
	public static String MIGLocation = "";
	public static String mappingTreeXslLocation = "";
	public static String dataItemDescriptionTemplateLocation = "";
	public static String wordAllLocation = "";
	public static String wCODataLocation = "";
	public static String processFileLocation = "";
	public static String dataHarmoResultTemplateLocation = "";

	static {
		System.out.println("vvvvvvv");

		try {
			ReadProperties o = new ReadProperties();
			o.readin();

			schemaOutputLocation = o.getSchemaOutputLocation();
			messageListLocation = o.getMessageListLocation();
			TDL_DENsXslLocation = o.getTDL_DENsXslLocation();
			MIGLocation = o.getMIGLocation();
			dataItemSetTemplateLocation = o.getDataItemSetTemplateLocation();
			mappingTreeXslLocation = o.getMappingTreeXslLocation();
			dataItemDescriptionTemplateLocation = o.getDataItemDescriptionTemplateLocation();
			wordAllLocation = o.getWordAllLocation();
			wCODataLocation = o.getWCODataLocation();
			processFileLocation = o.getProcessFileLocation();
			dataHarmoResultTemplateLocation = o.getDataHarmoResultTemplateLocation();
			// --------------------------------------------------------------------------------------
			ReadWriteTextFileWithEncoding test = new ReadWriteTextFileWithEncoding(messageListLocation, "big5");
			msg = test.read();

			System.out.println("Read Settings ok");
		} catch (Exception e) {
			System.err.println(e.toString());
		}

	}

	public static final String XML = "Xml";
	public static final String Single = "Single";
	public static String ttype = XML;
	public static String TwNameSpace = "tsw";
	public static String TWDS_version = "1";
	public static String newline = System.getProperty("line.separator");

	// ***************************************************************************
	// public static String TWDSxsdFile = getSchemaPath() + "common/TWDS_1p0.xsd";

	// Schema
	public static String getSchemaPath() {
		return schemaOutputLocation;
	}

	// 產製"TDL_DENs"後之存放位置
	public static String getTDLDensPath() {
		// String s = "D:/harmo_prod/TDL_DENs.xls";
		return TDL_DENsXslLocation;
	}

	// 資料項目集模板
	public static String getDataItemSetTemplatePath() {
		// String s = "D:/harmo_prod/資料項目集模板/資料項目集模板.doc";
		return dataItemSetTemplateLocation;
	}

	public static String getMappingTreePath() {
		// String s = "D:/harmo_prod/Mapping_Tree/";
		return mappingTreeXslLocation;
	}

	// 產製"資料項目使用說明模板"之存放位置
	public static String getDataItemDescriptionPath() {
		// String s = "C:\\MIG_5262\\Jeff\\harmo_prod\\資料項目使用說明模板";
		return dataItemDescriptionTemplateLocation;
	}

	// 產製"資料項目調和結果模板"之存放位置
	public static String getDataHarmoResultTemplateLocation() {
		return dataHarmoResultTemplateLocation;
	}

	public static String getMIGpath() {
		// String s = "D:/mu20060711/workspace_svn_harmo/關港貿XML訊息建置指引(草案)/";
		return MIGLocation;
	}

	public static String getProcessFilePath() {   
		// String s = "D:/mu20060711/workspace_svn_harmo/過程檔_single/";
		return processFileLocation;
	}

	public static String getWordAllBaseFilePath() {
		return wordAllLocation;
	}


	// WCOBase.xls 存放位置
	public static String getWCOBaseFilePath() {
		// String s = "D:/mu20060711/workspace_svn_harmo/WCOBase.xls";
		return wCODataLocation;
	}

	// ***************************************************************************
	public static String getMsgVersion(String msgName) {
		String ver = "";
		for (int i = 0; i < msg.length; i++) {
			String myMsgName = msg[i][0];
			if (myMsgName.equals(msgName)) {
				ver = msg[i][3];
				break;
			}
		}

		if (ver.equals("")) {
			throw new RuntimeException(msgName + " Has No Version !!haha...mu!");
		}

		return ver;
	}

	public static String getMsgName(String msgName) {
		String name = "";
		for (int i = 0; i < msg.length; i++) {
			String myMsgName = msg[i][0];
			if (myMsgName.equals(msgName)) {
				name = msg[i][4];
				break;
			}
		}
		return name;
	}

	// public static String msg[][] = {//
	// { "NX5105", "Declaration", "maindoc/NX5105.xsd", "R-00-02", "單證合一進口報單" },//
	// { "NX5106", "Response", "maindoc/NX5106.xsd", "R-00-02", "單證合一核覆訊息" },//
	// //
	// { "N5101", "Declaration", "maindoc/N5101.xsd", "R-00-02", "進（轉）口貨物艙單" },//
	// { "N5102", "Declaration", "maindoc/N5102.xsd", "R-00-02", "進（轉）口貨物進倉資料" },//
	//
	// { "N5103", "Declaration", "maindoc/N5103.xsd", "R-00-02", "艙位配置圖" },//
	//
	// { "N5107", "Response", "maindoc/N5107.xsd", "R-00-02", "應補辦事項通知" },//
	// { "N5108", "Response", "maindoc/N5108.xsd", "R-00-02", "倉儲或運輸業申報訊息回覆通知" },//
	// { "N5109", "Response", "maindoc/N5109.xsd", "R-00-02", "查驗貨物通知" },//
	// { "N5110", "Response", "maindoc/N5110.xsd", "R-00-02", "進口貨物稅費繳納證兼匯款申請書" },//
	// { "N5111", "Response", "maindoc/N5111.xsd", "R-00-02", "國庫專戶存款收款書兼匯款申請書" },//
	// { "N5116", "Response", "maindoc/N5116.xsd", "R-00-02", "進口貨物放行通知" },//
	// { "N5117", "Declaration", "maindoc/N5117.xsd", "R-00-02", "進口貨物出倉資料" },//
	// { "N5135", "Declaration", "maindoc/N5135.xsd", "R-00-02", "進口快遞貨物簡易申報單" },//
	// { "N5151", "Declaration", "maindoc/N5151.xsd", "R-00-02", "預報船舶資料" },//
	// { "N5158", "Response", "maindoc/N5158.xsd", "R-00-01", "卸貨准單" },//
	// { "N5162", "Declaration", "maindoc/N5162.xsd", "R-00-02", "進口貨物短溢卸報告" },//
	// { "N5165", "Declaration", "maindoc/N5165.xsd", "R-00-02", "貨櫃（物）運送單" },//
	// { "N5166", "Response", "maindoc/N5166.xsd", "R-00-02", "進口貨櫃清單" },//
	// { "N5167", "Declaration", "maindoc/N5167.xsd", "R-00-02", "進口貨物查驗申請書" },//
	// { "N5168", "Declaration", "maindoc/N5168.xsd", "R-00-02", "無法吊櫃通知" },//
	// { "N5170", "Response", "maindoc/N5170.xsd", "R-00-02", "作業指示通知" },//
	// //
	// { "N5201", "Declaration", "maindoc/N5201.xsd", "R-00-02", "出口貨物進倉資料" },//
	// { "N5202", "Declaration", "maindoc/N5202.xsd", "R-00-02", "出口貨物艙單" },//
	// { "N5203", "Declaration", "maindoc/N5203.xsd", "R-00-02", "出口報單" },//
	// { "N5204", "Response", "maindoc/N5204.xsd", "R-00-02", "出口貨物放行通知" },//
	// { "N5205", "Declaration", "maindoc/N5205.xsd", "R-00-02", "出口快遞貨物簡易申報單" },//
	// { "N5251", "Declaration", "maindoc/N5251.xsd", "R-00-02", "出口船舶開航預報單" },//
	// // { "N5252", "Response", "maindoc/N5252.xsd" ,"出口報單放行清表"},//
	// // { "N5262", "Declaration", "maindoc/N5262.xsd", "R-00-01" ,"預備裝船清表"},//
	// { "N5301", "Declaration", "maindoc/N5301.xsd", "R-00-02", "轉運申請書" },//
	// { "N5302", "Response", "maindoc/N5302.xsd", "R-00-02", "轉運准單" },//
	// { "N5401", "Declaration", "maindoc/N5401.xsd", "R-00-02", "自由港區事業按月彙報貨物申請書" },//
	// { "N5402", "Response", "maindoc/N5402.xsd", "R-00-02", "自由港區事業按月彙報貨物核准通知" },//
	// { "N5403", "Response", "maindoc/N5403.xsd", "R-00-02", "自由港區事業按月彙報貨物不受理或取消核准通知" },//
	// { "N5404", "Response", "maindoc/N5404.xsd", "R-00-02", "自由港區事業按月彙報核准條件異動通知" },//
	//
	// { "NX201_01", "Declaration", "maindoc/NX201_01.xsd", "R-00-02", "同意文件申辦訊息" },//
	// { "NX201_07", "Declaration", "maindoc/NX201_07.xsd", "R-00-02", "同意文件申辦註銷或展期訊息" },//
	// { "NX202", "Response", "maindoc/NX202.xsd", "R-00-02", "同意文件核覆訊息" },//
	// { "NX301", "Declaration", "maindoc/NX301.xsd", "R-00-02", "報驗申辦訊息" },//
	// { "NX401", "Declaration", "maindoc/NX401.xsd", "R-00-02", "檢疫申辦訊息" },//
	// { "NX601", "Declaration", "maindoc/NX601.xsd", "R-00-02", "輸入食品報驗申辦訊息" },//
	// { "NX603", "Declaration", "maindoc/NX603.xsd", "R-00-01", "醫療器材報驗申辦訊息" },//
	// { "NX301_DN", "Declaration", "maindoc/NX301_DN.xsd", "R-00-02", "酒類查驗申辦訊息" },//
	// { "NX302", "Response", "maindoc/NX302.xsd", "R-00-02", "審核結果核覆訊息" },//
	// { "NX402", "Response", "maindoc/NX402.xsd", "R-00-02", "檢疫核覆訊息" },//
	// { "NX602", "Response", "maindoc/NX602.xsd", "R-00-02", "輸入食品查驗結果回覆訊息" },//
	// { "NX302_DN", "Response", "maindoc/NX302_DN.xsd", "R-00-02", "酒類查驗核覆訊息" },//
	//
	// //
	// { "NX801", "Declaration", "maindoc/NX801.xsd", "R-00-03", "單證比對會辦訊息" },//
	// { "NX802", "Response", "maindoc/NX802.xsd", "R-00-03", "單證比對回覆訊息" },//
	// { "NX901", "Response", "maindoc/NX901.xsd", "R-00-02", "簽審回應訊息" },//
	// { "NX902", "Response", "maindoc/NX902.xsd", "R-00-02", "簽審通知訊息" },//
	// { "NX903", "Response", "maindoc/NX903.xsd", "R-00-02", "格式錯誤通知訊息" },//
	// };

}
