package com.example.demo;

import com.example.demo.annotations.AAA;
import com.example.demo.annotations.DSREF;
import com.example.demo.phase1.ResponseAbstract;
import com.example.demo.phase1.Worker;

@DSREF(cls = "Response")
@AAA(msg = {
//
		"name=N5101,car=1,boro=",//
		"name=N5102,car=1,boro=",//
		"name=N5103,car=1,boro=",//
		"name=N5107,car=1,boro=",//
		"name=N5108,car=1,boro=",//
		"name=N5109,car=1,boro=",//
		"name=N5110,car=1,boro=",//
		"name=N5111,car=1,boro=",//
		"name=N5116,car=1,boro=",//
		"name=N5117,car=1,boro=",//
		"name=N5135,car=1,boro=",//
		"name=N5151,car=1,boro=",//
		"name=N5158,car=1,boro=",//
		"name=N5162,car=1,boro=",//
		"name=N5165,car=1,boro=",//
		"name=N5166,car=1,boro=",//
		"name=N5167,car=1,boro=",//
		"name=N5168,car=1,boro=",//
		"name=N5170,car=1,boro=",//
		"name=N5201,car=1,boro=",//
		"name=N5202,car=1,boro=",//
		"name=N5203,car=1,boro=",//
		"name=N5204,car=1,boro=",//
		"name=N5205,car=1,boro=",//
		"name=N5251,car=1,boro=",//
		"name=N5252,car=1,boro=",//
		"name=N5262,car=1,boro=",//
		"name=N5301,car=1,boro=",//
		"name=N5302,car=1,boro=",//
		"name=N5401,car=1,boro=",//
		"name=N5402,car=1,boro=",//
		"name=N5403,car=1,boro=",//
		"name=N5404,car=1,boro=",//
		"name=NX201_01,car=1,boro=",//
		"name=NX201_07,car=1,boro=",//
		"name=NX202,car=1,boro=",//
		"name=NX301,car=1,boro=",//
		"name=NX301_DN,car=1,boro=",//
		"name=NX302,car=1,boro=",//
		"name=NX302_DN,car=1,boro=",//
		"name=NX401,car=1,boro=",//
		"name=NX402,car=1,boro=",//
		"name=NX5105,car=1,boro=",//
		"name=NX5106,car=1,boro=",//
		"name=NX601,car=1,boro=",//
		"name=NX602,car=1,boro=",//
		"name=NX603,car=1,boro=",//
		"name=NX801,car=1,boro=",//
		"name=NX802,car=1,boro=",//
		"name=NX901,car=1,boro=",//
		"name=NX902,car=1,boro=",//
		"name=NX903,car=1,boro=",//
})
public class MyMapping implements ResponseAbstract {

	private static String msgName = "";

	public MyMapping(String msgName) {
		this.msgName = msgName;
	}

	@DSREF(den = "Response. Functional Reference. Identifier", uid = "D026", cls = "Response")
	@AAA(msg = {
			//
			"name=N5109,car=1,boro=,chn=查驗貨物通知編號",//
			"name=NX903,car=1,boro=,chn=訊息編號",//
	})
	public String FunctionalReferenceID;

	@DSREF(den = "Response. Function. Code", uid = "017", cls = "Response")
	@AAA(msg = {
			//
			"name=N5116,car=1,boro=,chn=訊息功能代碼",//
			"name=N5166,car=1,boro=,chn=訊息功能代碼",//
			"name=N5204,car=1,boro=,chn=訊息功能代碼",//
			"name=NX302,car=1,boro=,chn=訊息功能代碼",//
			"name=NX302_DN,car=1,boro=,chn=訊息功能代碼",//
			"name=NX402,car=1,boro=,chn=訊息功能代碼",//
			"name=NX602,car=1,boro=,chn=訊息功能代碼",//
			"name=NX802,car=1,boro=,chn=訊息功能代碼",//
	})
	public String FunctionCode;

	@DSREF(den = "Response. Function. Code", uid = "017", cls = "Response")
	public String tw_OriginalSenderCode;

	public boolean hasMachedProps() {
		return new Worker(msgName).hasMachedProps(this);
	}

	public String getSchema() {
		return new Worker(msgName).getSchema(this);
	}

	@DSREF(den = "Response. Issue. Date Time", uid = "D029", cls = "Response")
	@AAA(msg = {
			//
			"name=N5107,car=1,boro=,chn=通知日期與時間",//
			"name=N5111,car=1,boro=,chn=核發日期",//
			"name=N5402,car=1,boro=,chn=核准日期與時間",//
			"name=N5403,car=1,boro=,chn=通知日期與時間",//
			"name=NX202,car=0..1,boro=,chn=文件核發日期",//
			"name=NX302,car=1,boro=,chn=通知日期與時間",//
			"name=NX302_DN,car=1,boro=,chn=通知日期與時間",//
			"name=NX402,car=1,boro=,chn=通知日期與時間",//
			"name=NX602,car=1,boro=,chn=通知日期與時間",//
			"name=NX901,car=0..1,boro=,chn=通知日期與時間",//
			"name=NX902,car=0..1,boro=,chn=通知日期與時間",//
			"name=NX903,car=1,boro=,chn=通知日期與時間",//
	})
	public String IssueDateTime;

	@DSREF(den = "Response. Goods Status. Code", uid = "TW539", cls = "Response")
	public String tw_GoodsStatusCode;

	public AdditionalDocument_Moved AdditionalDocument = new AdditionalDocument_Moved();

	@DSREF(cls = "Additional Document")
	@AAA(msg = {
	//
	"name=NX202,car=0..1,boro=+",//
	})
	public class AdditionalDocument_Moved {

		public boolean hasMachedProps() {
			return new Worker(msgName).hasMachedProps(this);
		}

		public String getSchema() {
			return new Worker(msgName).getSchema(this);
		}

		@DSREF(den = "Additional Document. Amount. Amount", uid = "263", cls = "Additional Document")
		public String AmountAmount;
		@DSREF(den = "Additional Document. Authentication Location Name. Text", uid = "D017", cls = "Additional Document")
		public String AuthenticationLocationName;

		@DSREF(den = "Additional Document. Identification. Identifier", uid = "D005", cls = "Additional Document")
		@AAA(msg = {
		//
		"name=NX202,car=0..1,boro=,chn=輸出入許可文件號碼",//
		})
		public String ID;

		@DSREF(den = "Additional Document. LPCO Expiration. Date Time", uid = "275", cls = "Additional Document")
		@AAA(msg = {
		//
		"name=NX202,car=0..1,boro=,chn=文件有效日期",//
		})
		public String LPCOExpirationDateTime;
	}

	public AdditionalInformation AdditionalInformation = new AdditionalInformation();

	@DSREF(cls = "Additional Information")
	@AAA(msg = {
			//
			"name=N5101,car=1,boro=",//
			"name=N5102,car=1,boro=",//
			"name=N5107,car=1,boro=",//
			"name=N5108,car=1,boro=",//
			"name=N5109,car=1,boro=",//
			"name=N5110,car=0..1,boro=",//
			"name=N5111,car=1,boro=",//
			"name=N5116,car=0..9,boro=",//
			"name=N5117,car=1,boro=",//
			"name=N5135,car=1,boro=",//
			"name=N5151,car=1,boro=",//
			"name=N5158,car=1,boro=",//
			"name=N5162,car=1,boro=",//
			"name=N5165,car=1,boro=",//
			"name=N5166,car=1,boro=",//
			"name=N5167,car=1,boro=",//
			"name=N5168,car=1,boro=",//
			"name=N5201,car=1,boro=",//
			"name=N5202,car=1,boro=",//
			"name=N5203,car=1,boro=",//
			"name=N5204,car=0..9,boro=",//
			"name=N5205,car=1,boro=",//
			"name=N5251,car=1,boro=",//
			"name=N5252,car=1,boro=",//
			"name=N5262,car=1,boro=",//
			"name=N5301,car=1,boro=",//
			"name=N5302,car=0..1,boro=",//
			"name=N5401,car=1,boro=",//
			"name=N5402,car=0..1,boro=",//
			"name=N5403,car=1,boro=",//
			"name=N5404,car=1,boro=",//
			"name=NX202,car=1,boro=",//
			"name=NX302,car=1,boro=",//
			"name=NX302_DN,car=0..1,boro=",//
			"name=NX402,car=1,boro=",//
			"name=NX5106,car=0..1,boro=",//
			"name=NX602,car=1,boro=",//
			"name=NX901,car=0..1,boro=",//
			"name=NX902,car=0..1,boro=",//
			"name=NX903,car=1,boro=",//
	})
	public class AdditionalInformation {

		public boolean hasMachedProps() {
			return new Worker(msgName).hasMachedProps(this);
		}

		public String getSchema() {
			return new Worker(msgName).getSchema(this);
		}

		@DSREF(den = "Additional Information. Content. Text", uid = "105", cls = "Additional Information")
		@AAA(msg = {
		//
		// "name=NX202,car=0..1,boro=#,chn=說明",//
		// "name=NX901,car=1,boro=#,chn=說明",//
		// "name=NX902,car=1,boro=#,chn=說明",//
		})
		public String tw_Content;

		@DSREF(den = "Additional Information. Statement. Code", uid = "226", cls = "Additional Information")
		@AAA(msg = {
				//
				"name=N5116,car=1,boro=,chn=放行附帶條件代碼",//
				"name=N5204,car=1,boro=,chn=放行附帶條件代碼",//
				"name=N5302,car=1,boro=,chn=有否查驗",//
				"name=NX202,car=0..1,boro=,chn=加註有關規定",//
		})
		public String StatementCode;

		@DSREF(den = "Additional Information. Statement Description. Text", uid = "225", cls = "Additional Information")
		@AAA(msg = {
		//
		"name=NX5106,car=1,boro=,chn=備註",//
		})
		public String StatementDescription;

		@DSREF(den = "Additional Information. Limit. Date Time", uid = "264", cls = "Additional Information")
		@AAA(msg = {
		//
		"name=N5107,car=1,boro=,chn=補辦期限",//
		})
		public String LimitDateTime;

		@DSREF(den = "Additional Information. Statement Type. Code", uid = "369", cls = "Additional Information")
		public String StatementTypeCode;

		@DSREF(den = "Additional Information. Application Number. Text", uid = "TW_127", cls = "Additional Information")
		public String tw_ApplicationNumber;

		@DSREF(den = "Additional Information. Inspection Rate. Code", uid = "TW058", cls = "Additional Information")
		@AAA(msg = {
		//
		"name=N5402,car=1,boro=,chn=出入區抽核比率代碼",//
		})
		public String tw_InspectionRateCode;

		@DSREF(den = "Additional Information. Notice Number. Text", uid = "TW028", cls = "Additional Information")
		@AAA(msg = {
		//
		"name=NX302_DN,car=1,boro=,chn=通知書號碼",//
		})
		public String tw_NoticeNumber;

		@DSREF(den = "Additional Information. Process Number. Text", uid = "TW128", cls = "Additional Information")
		@AAA(msg = {
				//
				"name=NX202,car=1,boro=,chn=收件編號",//
				"name=NX402,car=1,boro=,chn=收件編號",//
		})
		public String tw_ProcessNumber;

		@DSREF(den = "Additional Information. Split. Identifier", uid = "TW129", cls = "Additional Information")
		public String tw_SplitIdentification;

		@DSREF(den = "Additional Information. Universally Unique. Identifier", uid = "TW130", cls = "Additional Information")
		public String tw_UniversallyUniqueID;

		public Pointer Pointer = new Pointer();

		@DSREF(cls = "Pointer")
		public class Pointer {

			public Pointer() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Pointer. Document Section. Code", uid = "375", cls = "Pointer")
			public String DocumentSectionCode;
			@DSREF(den = "Pointer. Sequence. Numeric", uid = "006", cls = "Pointer")
			public String SequenceNumeric;
			@DSREF(den = "Pointer. Tag. Identifier", uid = "381", cls = "Pointer")
			public String TagID;
		}
	}

	public Amendment Amendment = new Amendment();

	@DSREF(cls = "Amendment")
	public class Amendment {

		public boolean hasMachedProps() {
			return new Worker(msgName).hasMachedProps(this);
		}

		public String getSchema() {
			return new Worker(msgName).getSchema(this);
		}

		@DSREF(den = "Amendment. Change Reason. Code", uid = "099", cls = "Amendment")
		public String ChangeReasonCode;
		public Pointer Pointer = new Pointer();

		@DSREF(cls = "Pointer")
		public class Pointer {

			public Pointer() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Pointer. Document Section. Code", uid = "375", cls = "Pointer")
			public String DocumentSectionCode;
			@DSREF(den = "Pointer. Sequence. Numeric", uid = "006", cls = "Pointer")
			public String SequenceNumeric;
			@DSREF(den = "Pointer. Tag. Identifier", uid = "381", cls = "Pointer")
			public String TagID;
		}
	}

	public BankAccount BankAccount = new BankAccount();

	@DSREF(cls = "Bank Account")
	@AAA(msg = {
			//
			"name=N5110,car=0..1,boro=",//
			"name=N5111,car=1,boro=",//
	})
	public class BankAccount {

		public boolean hasMachedProps() {
			return new Worker(msgName).hasMachedProps(this);
		}

		public String getSchema() {
			return new Worker(msgName).getSchema(this);
		}

		@DSREF(den = "Bank Account. Identification. Identifier", uid = "372", cls = "Bank Account")
		@AAA(msg = {
				//
				"name=N5110,car=0..1,boro=,chn=銷帳編號",//
				"name=N5111,car=0..1,boro=,chn=銷帳編號",//
		})
		public String ID;

		@DSREF(den = "Bank Account. Reference. Identifier", uid = "R069", cls = "Bank Account")
		@AAA(msg = {
				//
				"name=N5110,car=1,boro=,chn=海關帳戶",//
				"name=N5111,car=1,boro=,chn=海關帳戶",//
		})
		public String ReferenceID;
	}

	public ContactOffice ContactOffice = new ContactOffice();

	@DSREF(cls = "Contact Office")
	@AAA(msg = {
			//
			"name=N5101,car=1,boro=",//
			"name=N5102,car=1,boro=",//
			"name=N5107,car=1,boro=",//
			"name=N5108,car=1,boro=",//
			"name=N5109,car=1,boro=",//
			"name=N5110,car=1,boro=",//
			"name=N5111,car=1,boro=",//
			"name=N5116,car=1,boro=",//
			"name=N5117,car=1,boro=",//
			"name=N5135,car=1,boro=",//
			"name=N5151,car=1,boro=",//
			"name=N5158,car=1,boro=",//
			"name=N5162,car=1,boro=",//
			"name=N5165,car=1,boro=",//
			"name=N5166,car=1,boro=",//
			"name=N5167,car=1,boro=",//
			"name=N5168,car=1,boro=",//
			"name=N5201,car=1,boro=",//
			"name=N5202,car=1,boro=",//
			"name=N5203,car=1,boro=",//
			"name=N5204,car=1,boro=",//
			"name=N5205,car=1,boro=",//
			"name=N5251,car=1,boro=",//
			"name=N5252,car=1,boro=",//
			"name=N5262,car=1,boro=",//
			"name=N5301,car=1,boro=",//
			"name=N5302,car=1,boro=",//
			"name=N5401,car=1,boro=",//
			"name=N5402,car=1,boro=",//
			"name=N5403,car=1,boro=",//
			"name=N5404,car=1,boro=",//
			"name=NX302_DN,car=0..1,boro=",//
			"name=NX402,car=1,boro=",//
			"name=NX901,car=0..1,boro=",//
			"name=NX902,car=0..1,boro=",//
			"name=NX903,car=1,boro=",//
	})
	public class ContactOffice {

		public ContactOffice() {

		}

		public boolean hasMachedProps() {
			return new Worker(msgName).hasMachedProps(this);
		}

		public String getSchema() {
			return new Worker(msgName).getSchema(this);
		}

		@DSREF(den = "Contact Office. Identification. Identifier", uid = "G002", cls = "Contact Office")
		@AAA(msg = {
				//
				"name=N5107,car=1,boro=,chn=受理單位",//
				"name=NX402,car=1,boro=,chn=受理單位",//
				"name=NX901,car=1,boro=,chn=受理單位",//
				"name=NX902,car=1,boro=,chn=受理單位",//
				"name=NX903,car=1,boro=,chn=通知方代碼",//
		})
		public String IdentificationCode;

		public Communication Communication = new Communication();

		@DSREF(cls = "Communication")
		public class Communication {

			public Communication() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
			public String ID;
			@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
			public String TypeID;
		}

		public Contact Contact = new Contact();

		@DSREF(cls = "Contact")
		public class Contact {

			public Contact() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
			public String Name;
			public Communication Communication = new Communication();

			@DSREF(cls = "Communication")
			public class Communication {

				public Communication() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
				public String ID;
				@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
				public String TypeID;
			}
		}
	}

	public Control Control = new Control();

	@DSREF(cls = "Control")
	@AAA(msg = {
			//
			"name=N5109,car=1,boro=",//
			"name=NX202,car=1,boro=",//
			"name=NX302,car=1,boro=",//
			"name=NX302_DN,car=1,boro=",//
			"name=NX402,car=1,boro=",//
			"name=NX602,car=1,boro=",//
	})
	public class Control {

		public boolean hasMachedProps() {
			return new Worker(msgName).hasMachedProps(this);
		}

		public String getSchema() {
			return new Worker(msgName).getSchema(this);
		}

		@DSREF(den = "Control. Time-Limit. Date Time", uid = "264", cls = "Control")
		public String LimitDateTime;

		@DSREF(den = "Control. Inspection End. Date Time", uid = "356", cls = "Control")
		public String InspectionEndDateTime;

		@DSREF(den = "Control. Inspection Start. Date Time", uid = "355", cls = "Control")
		@AAA(msg = {
		//
		"name=N5109,car=1,boro=,chn=派驗日期與時間",//
		})
		public String InspectionStartDateTime;

		@DSREF(den = "Control. Description. Text", uid = "353", cls = "Quarantine")
		public String tw_Description;

		@DSREF(den = "Control. Result. Text", uid = "TW_131", cls = "Quarantine")
		public String tw_Result;
	}

	public Error Error = new Error();

	@DSREF(cls = "Error")
	@AAA(msg = {
			//
			"name=N5108,car=0..9,boro=",//
			"name=NX302,car=0..99,boro=",//
			"name=NX302_DN,car=0..99,boro=",//
			"name=NX602,car=0..99,boro=",//
			"name=NX802,car=1,boro=",//
			"name=NX903,car=1..99,boro=",//
	})
	public class Error {

		public Error() {

		}

		public boolean hasMachedProps() {
			return new Worker(msgName).hasMachedProps(this);
		}

		public String getSchema() {
			return new Worker(msgName).getSchema(this);
		}

		@DSREF(den = "Error. Validation. Code", uid = "377", cls = "Error")
		@AAA(msg = {
				//
				"name=N5108,car=1,boro=,chn=駁回原因代碼",//
				"name=NX802,car=1,boro=,chn=單證比對結果代碼",//
				"name=NX903,car=1,boro=,chn=錯誤種類代碼",//
		})
		public String ValidationCode;

		@DSREF(den = "Error. Content. Text", uid = "105", cls = "Error")
		public String tw_Content;

		public AdditionalInformation AdditionalInformation = new AdditionalInformation();

		@DSREF(cls = "Additional Information")
		@AAA(msg = {
		//
		"name=NX903,car=1,boro=+",//
		})
		public class AdditionalInformation {

			public AdditionalInformation() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Additional Information. Content. Text", uid = "105", cls = "Additional Information")
			@AAA(msg = {
			//
			"name=NX903,car=1,boro=,chn=說明",//
			})
			public String Content;
		}

	}

	public Status Status = new Status();

	@DSREF(cls = "Status")
	@AAA(msg = {
			//
			"name=N5101,car=1,boro=",//
			"name=N5102,car=1,boro=",//
			"name=N5107,car=1,boro=",//
			"name=N5108,car=0..1,boro=",//
			"name=N5109,car=1,boro=",//
			"name=N5110,car=0..1,boro=",//
			"name=N5111,car=0..1,boro=",//
			"name=N5116,car=1,boro=",//
			"name=N5117,car=1,boro=",//
			"name=N5135,car=1,boro=",//
			"name=N5151,car=1,boro=",//
			"name=N5158,car=1,boro=",//
			"name=N5162,car=1,boro=",//
			"name=N5165,car=1,boro=",//
			"name=N5166,car=1,boro=",//
			"name=N5167,car=1,boro=",//
			"name=N5168,car=1,boro=",//
			"name=N5201,car=1,boro=",//
			"name=N5202,car=1,boro=",//
			"name=N5203,car=1,boro=",//
			"name=N5204,car=1,boro=",//
			"name=N5205,car=1,boro=",//
			"name=N5251,car=1,boro=",//
			"name=N5252,car=1,boro=",//
			"name=N5262,car=1,boro=",//
			"name=N5301,car=1,boro=",//
			"name=N5302,car=1,boro=",//
			"name=N5401,car=1,boro=",//
			"name=N5402,car=1,boro=",//
			"name=N5403,car=1,boro=",//
			"name=N5404,car=1,boro=",//
			"name=NX202,car=1,boro=",//
			"name=NX302,car=1,boro=",//
			"name=NX302_DN,car=1,boro=",//
			"name=NX402,car=1,boro=",//
			"name=NX5106,car=0..1,boro=",//
			"name=NX602,car=1,boro=",//
			"name=NX901,car=1..99,boro=",//
			"name=NX902,car=0..1,boro=",//
	})
	public class Status {

		public boolean hasMachedProps() {
			return new Worker(msgName).hasMachedProps(this);
		}

		public String getSchema() {
			return new Worker(msgName).getSchema(this);
		}

		@DSREF(den = "Status. Effective. Date Time", uid = "380", cls = "Status")
		@AAA(msg = {
		//
		"name=N5404,car=1,boro=,chn=異動日期與時間",//
		})
		public String EffectiveDateTime;

		@DSREF(den = "Status. Name. Code", uid = "379", cls = "Status")
		@AAA(msg = {
				//
				"name=N5107,car=1,boro=,chn=通關方式",//
				"name=N5108,car=1,boro=,chn=回應別",//
				"name=N5110,car=1,boro=,chn=通關方式",//
				"name=N5111,car=1,boro=,chn=通關方式",//
				"name=N5116,car=1,boro=,chn=通關方式",//
				"name=N5204,car=1,boro=,chn=通關方式",//
				"name=NX202,car=1,boro=,chn=審核結果",//
				"name=NX302,car=1,boro=,chn=審核結果",//
				"name=NX302_DN,car=1,boro=,chn=審核結果",//
				"name=NX402,car=1,boro=,chn=審核結果",//
				"name=NX5106,car=1,boro=,chn=回應狀況代碼",//
				"name=NX602,car=1,boro=,chn=審核結果",//
				"name=NX901,car=1,boro=,chn=回應狀況代碼",//
				"name=NX902,car=1,boro=,chn=通知代碼",//
		})
		public String NameCode;

		@DSREF(den = "Status. Release. Date Time", uid = "277", cls = "Status")
		@AAA(msg = {
				//
				"name=N5116,car=1,boro=,chn=放行日期與時間",//
				"name=N5204,car=1,boro=,chn=放行日期與時間",//
		})
		public String ReleaseDateTime;

		@DSREF(den = "Status. Requested Assignment. Date Time", uid = "273", cls = "Status")
		public String RequestedAssignmentDateTime;

		@DSREF(den = "Status. Combination Shipments. Text", uid = "TW066", cls = "Status")
		public String tw_CombinationShipments;

		@DSREF(den = "Status. Content. Text", uid = "105", cls = "Status")
		public String tw_Content;

		@DSREF(den = "Status. Examination Type. Code", uid = "TW_136", cls = "Status")
		public String tw_ExaminationTypeCode;

		@DSREF(den = "Status. Release Type. Code", uid = "TW122", cls = "Status")
		@AAA(msg = {
		//
		"name=N5116,car=0..1,boro=,chn=放行通知類別",//
		})
		public String tw_ReleaseTypeCode;

		@DSREF(den = "Status. Total Package. Quantity", uid = "146", cls = "Status")
		@AAA(msg = {
				//
				"name=N5116,car=1,boro=*,chn=放行件數",//
				"name=N5204,car=1,boro=*,chn=放行件數",//
		})
		public String tw_TotalPackageQuantity;

		@DSREF(den = "Status. Unreleased Package. Quantity", uid = "TW_097", cls = "Status")
		public String tw_UnreleasedPackageQuantity;

	}

	public tw_Quarantine tw_Quarantine = new tw_Quarantine();

	@DSREF(cls = "Quarantine")
	public class tw_Quarantine {

		public boolean hasMachedProps() {
			return new Worker(msgName).hasMachedProps(this);
		}

		public String getSchema() {
			return new Worker(msgName).getSchema(this);
		}

		@DSREF(den = "Quarantine. Result. Code", uid = "TW546", cls = "Quarantine")
		public String tw_ResultCode;
	}

	public tw_Sampling tw_Sampling = new tw_Sampling();

	@DSREF(cls = "Sampling")
	@AAA(msg = {
			//
			"name=NX302,car=0..1,boro=",//
			"name=NX302_DN,car=0..1,boro=",//
			"name=NX602,car=0..1,boro=",//
			"name=NX902,car=0..1,boro=",//
	})
	public class tw_Sampling {

		public boolean hasMachedProps() {
			return new Worker(msgName).hasMachedProps(this);
		}

		public String getSchema() {
			return new Worker(msgName).getSchema(this);
		}

		@DSREF(den = "Sampling. Period. Code", uid = "TW132", cls = "Sampling")
		@AAA(msg = {
		//
		"name=NX902,car=0..1,boro=,chn=取樣時段",//
		})
		public String tw_PeriodCode;

		@DSREF(den = "Sampling. Sampling. Date", uid = "TW133", cls = "Sampling")
		@AAA(msg = {
		//
		"name=NX902,car=0..1,boro=,chn=取樣日期",//
		})
		public String tw_SamplingDate;

	}

	public tw_UnreleasedPackages tw_UnreleasedPackages = new tw_UnreleasedPackages();

	@DSREF(cls = "Unreleased Packages")
	@AAA(msg = {
			//
			"name=N5116,car=0..1,boro=",//
			"name=N5204,car=0..1,boro=",//
	})
	public class tw_UnreleasedPackages {

		public boolean hasMachedProps() {
			return new Worker(msgName).hasMachedProps(this);
		}

		public String getSchema() {
			return new Worker(msgName).getSchema(this);
		}

		@DSREF(den = "Unreleased Packages. Quantity. Quantity", uid = "144", cls = "Unreleased Packages")
		@AAA(msg = {
				//
				"name=N5116,car=1,boro=*,chn=未放行件數",//
				"name=N5204,car=1,boro=*,chn=未放行件數",//
		})
		public String QuantityQuantity;

		@DSREF(den = "Unreleased Packages. Type. Code", uid = "141", cls = "Unreleased Packages")
		@AAA(msg = {
				//
				"name=N5116,car=1,boro=*,chn=件數單位",//
				"name=N5204,car=1,boro=*,chn=件數單位",//
		})
		public String TypeCode;
	}

	public Declaration Declaration = new Declaration();

	@DSREF(cls = "Declaration")
	@AAA(msg = {
			//
			"name=N5101,car=1,boro=",//
			"name=N5102,car=1,boro=",//
			"name=N5103,car=1,boro=",//
			"name=N5107,car=1,boro=",//
			"name=N5108,car=1,boro=",//
			"name=N5109,car=1,boro=",//
			"name=N5110,car=1,boro=",//
			"name=N5111,car=1,boro=",//
			"name=N5116,car=1,boro=",//
			"name=N5117,car=1,boro=",//
			"name=N5135,car=1,boro=",//
			"name=N5151,car=1,boro=",//
			"name=N5158,car=1,boro=",//
			"name=N5162,car=1,boro=",//
			"name=N5165,car=1,boro=",//
			"name=N5166,car=1,boro=",//
			"name=N5167,car=1,boro=",//
			"name=N5168,car=1,boro=",//
			"name=N5170,car=1,boro=",//
			"name=N5201,car=1,boro=",//
			"name=N5202,car=1,boro=",//
			"name=N5203,car=1,boro=",//
			"name=N5204,car=1,boro=",//
			"name=N5205,car=1,boro=",//
			"name=N5251,car=1,boro=",//
			"name=N5252,car=1,boro=",//
			"name=N5262,car=1,boro=",//
			"name=N5301,car=1,boro=",//
			"name=N5302,car=1,boro=",//
			"name=N5401,car=1,boro=",//
			"name=N5402,car=1,boro=",//
			"name=N5403,car=1,boro=",//
			"name=N5404,car=1,boro=",//
			"name=NX201_01,car=1,boro=",//
			"name=NX201_07,car=1,boro=",//
			"name=NX202,car=1,boro=",//
			"name=NX301,car=1,boro=",//
			"name=NX301_DN,car=1,boro=",//
			"name=NX302,car=1,boro=",//
			"name=NX302_DN,car=1,boro=",//
			"name=NX401,car=1,boro=",//
			"name=NX402,car=1,boro=",//
			"name=NX5105,car=1,boro=",//
			"name=NX5106,car=1,boro=",//
			"name=NX601,car=1,boro=",//
			"name=NX602,car=1,boro=",//
			"name=NX603,car=1,boro=",//
			"name=NX801,car=1,boro=",//
			"name=NX802,car=1,boro=",//
			"name=NX901,car=1,boro=",//
			"name=NX902,car=1,boro=",//
			"name=NX903,car=1,boro=",//
	})
	public class Declaration {

		public boolean hasMachedProps() {
			return new Worker(msgName).hasMachedProps(this);
		}

		public String getSchema() {
			return new Worker(msgName).getSchema(this);
		}

		@DSREF(den = "Declaration. Acceptance. Date Time", uid = "023", cls = "Declaration")
		@AAA(msg = {
				//
				"name=N5135,car=1,boro=,chn=報關日期",//
				"name=N5203,car=1,boro=,chn=報關日期",//
				"name=N5205,car=1,boro=,chn=報關日期",//
				"name=NX401,car=0..1,boro=,chn=報關日期",//
				"name=NX402,car=0..1,boro=,chn=報關日期",//
				"name=NX5105,car=1,boro=,chn=報關日期",//
				"name=NX801,car=0..1,boro=,chn=報關日期",//
				"name=NX901,car=0..1,boro=,chn=收件日期與時間",//
				"name=NX902,car=0..1,boro=,chn=收件日期與時間",//
		})
		public String AcceptanceDateTime;

		@DSREF(den = "Declaration. Authentication. Text", uid = "104", cls = "Declaration")
		@AAA(msg = {
				//
				"name=N5203,car=0..1,boro=,chn=簽證情形",//
				"name=NX5105,car=0..1,boro=,chn=簽證情形",//
		})
		public String Authentication;

		@DSREF(den = "Declaration. Declaration Office. Identifier", uid = "065", cls = "Declaration")
		@AAA(msg = {
				//
				"name=N5111,car=1,boro=,chn=核發關別代碼",//
				"name=N5151,car=1,boro=,chn=受理關別",//
				"name=N5167,car=1,boro=,chn=收單關別代碼",//
				"name=N5201,car=0..1,boro=,chn=收單關別代碼",//
				"name=N5401,car=1,boro=,chn=收單關別代碼",//
				"name=N5402,car=1,boro=,chn=收單關別代碼",//
				"name=N5404,car=1,boro=,chn=收單關別代碼",//
		})
		public String DeclarationOfficeID;

		@DSREF(den = "Declaration. Functional Reference. Identifier", uid = "D026", cls = "Declaration")
		@AAA(msg = {
				//
				"name=N5101,car=1,boro=#,chn=訊息編號",//
				"name=N5102,car=1,boro=#,chn=訊息編號",//
				"name=N5103,car=1,boro=#,chn=訊息編號",//
				"name=N5151,car=1,boro=#,chn=訊息編號",//
				"name=N5162,car=1,boro=#,chn=訊息編號",//
				"name=N5165,car=1,boro=#,chn=訊息編號",//
				"name=N5167,car=1,boro=#,chn=訊息編號",//
				"name=N5201,car=1,boro=#,chn=訊息編號",//
				"name=N5202,car=1,boro=#,chn=訊息編號",//
				"name=N5251,car=1,boro=#,chn=訊息編號",//
				"name=N5262,car=1,boro=#,chn=訊息編號",//
				"name=N5401,car=1,boro=#,chn=訊息編號",//
				"name=NX201_01,car=1,boro=#,chn=訊息編號",//
				"name=NX201_07,car=1,boro=#,chn=訊息編號",//
				"name=NX301,car=1,boro=#,chn=訊息編號",//
				"name=NX301_DN,car=1,boro=#,chn=訊息編號",//
				"name=NX401,car=1,boro=#,chn=訊息編號",//
				"name=NX601,car=1,boro=#,chn=訊息編號",//
				"name=NX603,car=1,boro=#,chn=訊息編號",//
		})
		public String FunctionalReferenceID;

		@DSREF(den = "Declaration. Function. Code", uid = "017", cls = "Declaration")
		@AAA(msg = {
				//
				"name=N5101,car=1,boro=,chn=訊息功能代碼",//
				"name=N5102,car=1,boro=,chn=訊息功能代碼",//
				"name=N5103,car=1,boro=,chn=訊息功能代碼",//
				"name=N5117,car=1,boro=,chn=訊息功能代碼",//
				"name=N5135,car=1,boro=,chn=訊息功能代碼",//
				"name=N5162,car=1,boro=,chn=訊息功能代碼",//
				"name=N5165,car=1,boro=,chn=訊息功能代碼",//
				"name=N5167,car=1,boro=,chn=訊息功能代碼",//
				"name=N5201,car=1,boro=,chn=訊息功能代碼",//
				"name=N5202,car=1,boro=,chn=訊息功能代碼",//
				"name=N5203,car=1,boro=,chn=訊息功能代碼",//
				"name=N5205,car=1,boro=,chn=訊息功能代碼",//
				"name=N5251,car=1,boro=,chn=訊息功能代碼",//
				"name=N5262,car=1,boro=,chn=訊息功能代碼",//
				"name=N5301,car=1,boro=,chn=訊息功能代碼",//
				"name=N5401,car=1,boro=,chn=訊息功能代碼",//
				"name=NX201_01,car=1,boro=,chn=訊息功能代碼",//
				"name=NX201_07,car=1,boro=,chn=訊息功能代碼",//
				"name=NX202,car=1,boro=,chn=訊息功能代碼",//
				"name=NX301,car=1,boro=,chn=訊息功能代碼",//
				"name=NX301_DN,car=1,boro=,chn=訊息功能代碼",//
				"name=NX401,car=1,boro=,chn=訊息功能代碼",//
				"name=NX5105,car=1,boro=,chn=訊息功能代碼",//
				"name=NX601,car=1,boro=,chn=訊息功能代碼",//
				"name=NX603,car=1,boro=,chn=訊息功能代碼",//
				"name=NX801,car=1,boro=,chn=訊息功能代碼",//
				"name=NX901,car=1,boro=,chn=訊息功能代碼",//
				"name=NX902,car=1,boro=,chn=訊息功能代碼",//
		})
		public String FunctionCode;

		@DSREF(den = "Declaration. Goods Item. Quantity", uid = "228", cls = "Declaration")
		public String GoodsItemQuantity;

		@DSREF(den = "Declaration. Identification. Identifier", uid = "D014", cls = "Declaration")
		@AAA(msg = {
				//
				"name=N5107,car=1,boro=,chn=報單號碼",//
				"name=N5109,car=1,boro=,chn=報單號碼",//
				"name=N5110,car=1,boro=,chn=報單號碼",//
				"name=N5111,car=0..1,boro=,chn=報單號碼",//
				"name=N5116,car=1,boro=,chn=報單號碼",//
				"name=N5135,car=1,boro=,chn=報單號碼",//
				"name=N5168,car=1,boro=,chn=報單號碼",//
				"name=N5203,car=1,boro=,chn=報單號碼",//
				"name=N5204,car=1,boro=,chn=報單號碼",//
				"name=N5205,car=1,boro=,chn=報單號碼",//
				"name=N5301,car=1,boro=,chn=轉運申請書編號",//
				"name=N5302,car=1,boro=,chn=轉運申請書編號",//
				"name=NX201_01,car=0..1,boro=,chn=報單號碼",//
				"name=NX301,car=1,boro=,chn=報單號碼",//
				"name=NX301_DN,car=1,boro=,chn=報單號碼",//
				"name=NX302,car=1,boro=,chn=報單號碼",//
				"name=NX302_DN,car=1,boro=,chn=報單號碼",//
				"name=NX401,car=1,boro=,chn=報單號碼",//
				"name=NX402,car=1,boro=,chn=報單號碼",//
				"name=NX5105,car=1,boro=,chn=報單號碼",//
				"name=NX5106,car=1,boro=,chn=報單號碼",//
				"name=NX601,car=1,boro=,chn=報單號碼",//
				"name=NX602,car=1,boro=,chn=報單號碼",//
				"name=NX603,car=1,boro=,chn=報單號碼",//
				"name=NX801,car=1,boro=,chn=報單號碼",//
				"name=NX802,car=1,boro=,chn=報單號碼",//
				"name=NX901,car=0..1,boro=,chn=報單號碼",//
				"name=NX902,car=0..1,boro=,chn=報單號碼",//
				"name=NX903,car=0..1,boro=,chn=報單號碼",//
		})
		public String ID;

		@DSREF(den = "Declaration. Invoice. Amount", uid = "109", cls = "Declaration")
		@AAA(msg = {
				//
				"name=N5203,car=1,boro=,chn=發票總金額",//
				"name=NX5105,car=1,boro=,chn=發票總金額",//
		})
		public String InvoiceAmount;

		@DSREF(den = "Declaration. Issue. Date Time", uid = "D011", cls = "Declaration")
		@AAA(msg = {
				//
				"name=N5401,car=1,boro=,chn=申請日期與時間",//
				"name=NX201_01,car=1,boro=,chn=申請日期與時間",//
				"name=NX201_07,car=1,boro=,chn=申請日期與時間",//
				"name=NX202,car=1,boro=,chn=申請日期與時間",//
		})
		public String IssueDateTime;

		@DSREF(den = "Declaration. Issue Location. Identifier", uid = "D012", cls = "Declaration")
		public String IssueLocationID;

		@DSREF(den = "Declaration. Jurisdiction. Date Time", uid = "274", cls = "Declaration")
		public String JurisdictionDateTime;

		@DSREF(den = "Declaration. Loading List. Quantity", uid = "013", cls = "Declaration")
		public String LoadingListQuantity;

		@DSREF(den = "Declaration. Rejection. Date Time", uid = "374", cls = "Declaration")
		public String RejectionDateTime;

		@DSREF(den = "Declaration. Status. Code", uid = "019", cls = "Declaration")
		public String StatusCode;

		@DSREF(den = "Declaration. Subsequent Declaration Office. Identifier", uid = "187", cls = "Declaration")
		public String SubsequentDeclarationOfficeID;

		@DSREF(den = "Declaration. Total Gross Mass. Measure", uid = "131", cls = "Declaration")
		@AAA(msg = {
				//
				"name=N5102,car=0..1,boro=,chn=總毛重",//
				"name=N5116,car=1,boro=,chn=總毛重",//
				"name=N5201,car=0..1,boro=,chn=總毛重",//
				"name=N5203,car=1,boro=,chn=總毛重",//
				"name=N5204,car=0..1,boro=,chn=總毛重",//
				"name=N5301,car=1,boro=,chn=總毛重",//
				"name=NX5105,car=1,boro=,chn=總毛重",//
		})
		public String TotalGrossMassMeasure;

		@DSREF(den = "Declaration. Total Package. Quantity", uid = "146", cls = "Declaration")
		@AAA(msg = {
				//
				"name=N5102,car=0..1,boro=,chn=總件數",//
				"name=N5107,car=0..1,boro=,chn=總件數",//
				"name=N5110,car=1,boro=,chn=總件數",//
				"name=N5116,car=1,boro=,chn=總件數",//
				"name=N5162,car=1,boro=,chn=總件數",//
				"name=N5165,car=0..1,boro=#,chn=放行件數",//
				"name=N5203,car=1,boro=,chn=總件數",//
				"name=N5301,car=1,boro=,chn=總件數",//
				"name=N5302,car=1,boro=,chn=總件數",//
				"name=NX5105,car=1,boro=,chn=總件數",//
		})
		public String TotalPackageQuantity;

		@DSREF(den = "Declaration. Associated Government Procedure. Code", uid = "233", cls = "Declaration")
		@AAA(msg = {
				//
				"name=N5203,car=0..1,boro=*,chn=申請審驗方式",//
				"name=NX5105,car=0..1,boro=*,chn=申請審驗方式",//
		})
		public String tw_AssociatedGovernmentProcedureCode;

		@DSREF(den = "Declaration. Combined Note. Text", uid = "TW148", cls = "Declaration")
		@AAA(msg = {
		//
		"name=NX5105,car=0..1,boro=,chn=單證合一註記",//
		})
		public String tw_CombinedNote;

		@DSREF(den = "Declaration. Copy. Text", uid = "TW037", cls = "Additional Information")
		public String tw_Copy;

		@DSREF(den = "Declaration. Exit Warehouse. Date Time", uid = "TW_124", cls = "Declaration")
		public String tw_ExitWarehouseDateTime;

		@DSREF(den = "Declaration. First Arrival Location. Identifier", uid = "085", cls = "Declaration")
		@AAA(msg = {
		//
		"name=N5101,car=0..1,boro=*,chn=第一抵達港口代碼",//
		})
		public String tw_FirstArrivalLocationID;

		@DSREF(den = "Declaration. Message Type. Code", uid = "TW060", cls = "Declaration")
		@AAA(msg = {
				//
				"name=N5101,car=1,boro=,chn=訊息類別代碼",//
				"name=N5202,car=1,boro=,chn=訊息類別代碼",//
		})
		public String tw_MessageTypeCode;

		@DSREF(den = "Declaration. Print. Date Time", uid = "TW141", cls = "Declaration")
		@AAA(msg = {
		//
		"name=N5165,car=0..1,boro=,chn=列印日期與時間",//
		})
		public String tw_PrintDateTime;

		@DSREF(den = "Declaration. Total Weight. Measure", uid = "TW149", cls = "Declaration")
		@AAA(msg = {
		//
		"name=N5165,car=0..1,boro=,chn=總重(含櫃重)",//
		})
		public String tw_TotalWeightMeasure;

		@DSREF(den = "Declaration. Trader Reference. Identifier", uid = "TW036", cls = "Declaration")
		public String tw_TraderReferenceID;

		@DSREF(den = "Declaration. Unreleased Package. Quantity", uid = "TW_097", cls = "Declaration")
		public String tw_UnreleasedPackageQuantity;

		@DSREF(den = "Declaration. Value Added Network. Identifier", uid = "TW071", cls = "Declaration")
		@AAA(msg = {
				//
				"name=NX801,car=1,boro=,chn=通關網路業者",//
				"name=NX802,car=1,boro=,chn=通關網路業者",//
		})
		public String tw_ValueAddedNetworkID;

		@DSREF(den = "Declaration. Type. Code", uid = "D013", cls = "Declaration")
		@AAA(msg = {
				//
				"name=N5107,car=0..1,boro=,chn=報單類別",//
				"name=N5110,car=0..1,boro=,chn=報單類別",//
				"name=N5116,car=0..1,boro=,chn=報單類別",//
				"name=N5135,car=1,boro=,chn=報單類別",//
				"name=N5203,car=1,boro=,chn=報單類別",//
				"name=N5204,car=0..1,boro=,chn=報單類別",//
				"name=N5205,car=1,boro=,chn=報單類別",//
				"name=N5301,car=1,boro=,chn=轉運申請書類別",//
				"name=N5302,car=1,boro=,chn=轉運申請書類別",//
				"name=NX401,car=0..1,boro=,chn=報單類別",//
				"name=NX5105,car=1,boro=,chn=報單類別",//
		})
		public String TypeCode;

		public AdditionalDocument_Moved AdditionalDocument = new AdditionalDocument_Moved();

		@DSREF(cls = "Additional Document")
		@AAA(msg = {
				//
				"name=N5101,car=0..1,boro=",//
				"name=N5102,car=1,boro=",//
				"name=N5107,car=1,boro=",//
				"name=N5108,car=1,boro=",//
				"name=N5109,car=1,boro=",//
				"name=N5110,car=1,boro=",//
				"name=N5111,car=1,boro=",//
				"name=N5116,car=1,boro=",//
				"name=N5117,car=1,boro=",//
				"name=N5135,car=1,boro=",//
				"name=N5151,car=1,boro=",//
				"name=N5158,car=1,boro=",//
				"name=N5162,car=0..1,boro=",//
				"name=N5165,car=0..999,boro=",//
				"name=N5166,car=0..1,boro=",//
				"name=N5167,car=1,boro=#",//
				"name=N5168,car=1,boro=",//
				"name=N5201,car=0..1,boro=",//
				"name=N5202,car=0..1,boro=#",//
				"name=N5203,car=0..3,boro=",//
				"name=N5204,car=1,boro=",//
				"name=N5205,car=1,boro=",//
				"name=N5251,car=1,boro=",//
				"name=N5252,car=1,boro=",//
				"name=N5262,car=1,boro=",//
				"name=N5301,car=1,boro=",//
				"name=N5302,car=1,boro=",//
				"name=N5401,car=1,boro=#",//
				"name=N5402,car=1,boro=#",//
				"name=N5403,car=1,boro=#",//
				"name=N5404,car=1,boro=#",//
				"name=NX201_01,car=0..1,boro=#",//
				"name=NX201_07,car=1,boro=#",//
				"name=NX202,car=0..1,boro=#",//
				"name=NX301,car=0..1,boro=#",//
				"name=NX301_DN,car=0..1,boro=#",//
				"name=NX302,car=1,boro=",//
				"name=NX302_DN,car=1..2,boro=+",//
				"name=NX401,car=0..1,boro=#",//
				"name=NX402,car=1..2,boro=+",//
				"name=NX601,car=0..1,boro=#",//
				"name=NX602,car=1,boro=",//
				"name=NX603,car=1,boro=#",//
				"name=NX901,car=0..2,boro=",//
				"name=NX902,car=1..2,boro=+",//
		})
		public class AdditionalDocument_Moved {

			public AdditionalDocument_Moved() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Additional Document. Amount. Amount", uid = "263", cls = "Additional Document")
			public String AmountAmount;

			@DSREF(den = "Additional Document. Authentication Location Name. Text", uid = "D017", cls = "Additional Document")
			public String AuthenticationLocationName;

			@DSREF(den = "Additional Document. Identification. Identifier", uid = "D005", cls = "Additional Document")
			@AAA(msg = {
					//
					"name=N5158,car=1,boro=,chn=普通准單號碼",//
					"name=N5165,car=1,boro=,chn=海關核准編號",//
					"name=N5203,car=1,boro=,chn=檢附文件號碼",//
					"name=N5401,car=1,boro=,chn=按月彙報申請書編號",//
					"name=N5402,car=1,boro=,chn=海關核准編號",//
					"name=N5403,car=1,boro=,chn=按月彙報申請書編號",//
					"name=NX201_01,car=1,boro=,chn=輸出入許可文件號碼",//
					"name=NX201_07,car=1,boro=,chn=輸出入許可文件號碼",//
					"name=NX301,car=1,boro=,chn=輸出入許可文件號碼",//
					"name=NX401,car=1,boro=,chn=輸出入許可文件號碼",//
					"name=NX601,car=1,boro=,chn=輸出入許可文件號碼",//
					"name=NX603,car=1,boro=,chn=輸出入許可文件號碼",//
			})
			public String ID;

			@DSREF(den = "Additional Document. Type. Code", uid = "D006", cls = "Additional Document")
			public String TypeCode;

			@DSREF(den = "Additional Document. LPCO Expiration. Date Time", uid = "275", cls = "Additional Document")
			@AAA(msg = {
			//
			"name=NX201_07,car=0..1,boro=,chn=文件有效日期",//
			})
			public String LPCOExpirationDateTime;

			@DSREF(den = "Additional Document. Name. Text", uid = "D028", cls = "Additional Document")
			public String Name;

			@DSREF(den = "Additional Document. Reference. Identifier", uid = "TW099", cls = "Additional Document")
			public String tw_ReferenceID;

			@DSREF(den = "Additional Document. FTZ Application Type. Text", uid = "TW126", cls = "Additional Document")
			@AAA(msg = {
					//
					"name=N5401,car=1,boro=,chn=按月彙報申請書類別",//
					"name=N5402,car=1,boro=,chn=按月彙報申請書類別",//
			})
			public String tw_FTZApplicationType;

			@DSREF(den = "Additional Document. Sequence. Numeric", uid = "006", cls = "Additional Document")
			@AAA(msg = {
			//
			"name=N5165,car=1,boro=*,chn=項次",//
			})
			public String tw_SequenceNumeric;

		}

		public AdditionalInformation AdditionalInformation = new AdditionalInformation();

		@DSREF(cls = "Additional Information")
		@AAA(msg = {
				//
				"name=N5116,car=0..1,boro=",//
				"name=N5117,car=0..1,boro=",//
				"name=N5165,car=0..1,boro=",//
				"name=N5168,car=1,boro=",//
				"name=N5201,car=0..1,boro=",//
				"name=N5203,car=0..1,boro=",//
				"name=N5251,car=0..1,boro=",//
				"name=N5262,car=0..1,boro=",//
				"name=NX201_01,car=0..1,boro=",//
				"name=NX201_07,car=0..1,boro=",//
				"name=NX202,car=0..1,boro=",//
				"name=NX302,car=0..1,boro=",//
				"name=NX302_DN,car=0..1,boro=",//
				"name=NX5105,car=0..1,boro=",//
				"name=NX5106,car=0..1,boro=",//
				"name=NX602,car=0..1,boro=",//
				"name=NX901,car=0..1,boro=",//
				"name=NX902,car=0..1,boro=",//
		})
		public class AdditionalInformation {

			public AdditionalInformation() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Additional Information. Content. Text", uid = "105", cls = "Additional Information")
			@AAA(msg = {
					//
					"name=NX201_01,car=0..1,boro=,chn=描述與說明",//
					"name=NX201_07,car=1,boro=,chn=描述與說明",//
					"name=NX202,car=1,boro=,chn=說明",//
					"name=NX901,car=0..1,boro=,chn=說明",//
					"name=NX902,car=0..1,boro=,chn=說明",//

			})
			public String Content;

			@DSREF(den = "Additional Information. Reconciliation Reason. Code", uid = "300", cls = "Additional Information")
			public String ReconciliationReasonCode;

			@DSREF(den = "Additional Information. Request Override. Code", uid = "095", cls = "Additional Information")
			@AAA(msg = {
			//
			"name=N5168,car=1,boro=#,chn=無法吊櫃原因代碼",//
			})
			public String RequestOverrideCode;

			@DSREF(den = "Additional Information. Requested Inspection. Date Time", uid = "220", cls = "Additional Information")
			public String RequestedInspectionDateTime;

			@DSREF(den = "Additional Information. Statement. Code", uid = "226", cls = "Additional Information")
			@AAA(msg = {
					//
					"name=N5116,car=1,boro=,chn=合併註記",//
					"name=N5117,car=1,boro=,chn=簡易申報註記",//
					"name=N5201,car=1,boro=,chn=簡易申報註記",//
			})
			public String StatementCode;

			@DSREF(den = "Additional Information. Statement Description. Text", uid = "225", cls = "Additional Information")
			@AAA(msg = {
					//
					"name=N5165,car=1,boro=#,chn=備註",//
					"name=N5262,car=1,boro=,chn=備註",//
			})
			public String StatementDescription;

			@DSREF(den = "Additional Information. Statement Type. Code", uid = "369", cls = "Additional Information")
			public String StatementTypeCode;

			@DSREF(den = "Additional Information. Copy. Text", uid = "TW037XXX", cls = "Additional Information")
			public String tw_Copy;

			@DSREF(den = "Additional Information. Copy. Quantity", uid = "TW037", cls = "Additional Information")
			@AAA(msg = {
					//
					"name=N5203,car=1,boro=,chn=申請報單副本份數",//
					"name=NX5105,car=1,boro=,chn=申請報單副本份數",//
			})
			public String tw_CopyQuantity;

			@DSREF(den = "Additional Information. Del Process Number. Text", uid = "TW135", cls = "Additional Information")
			@AAA(msg = {
			//
			"name=NX201_01,car=0..1,boro=,chn=餘額註銷案件之收件編號",//
			})
			public String tw_DelProcessNumber;

			@DSREF(den = "Additional Information. Estimated Clearance. Date Time", uid = "TW072", cls = "Additional Information")
			@AAA(msg = {
			//
			"name=N5251,car=1,boro=,chn=預定結關日期與時間",//
			})
			public String tw_EstimatedClearanceDateTime;

			@DSREF(den = "Additional Information. Issue. Date Time", uid = "D029", cls = "Additional Information")
			@AAA(msg = {
			//
			"name=NX5106,car=1,boro=*,chn=通知日期與時間",//
			})
			public String tw_IssueDateTime;

			@DSREF(den = "Additional Information. Process Number. Text", uid = "TW128", cls = "Additional Information")
			@AAA(msg = {
					//
					"name=NX201_01,car=0..1,boro=,chn=收件編號",//
					"name=NX901,car=0..1,boro=,chn=收件編號",//
					"name=NX902,car=0..1,boro=,chn=收件編號",//
			})
			public String tw_ProcessNumber;

		}

		public Agent Agent = new Agent();

		@DSREF(cls = "Agent")
		@AAA(msg = {
				//
				"name=N5101,car=1,boro=",//
				"name=N5102,car=1,boro=",//
				"name=N5107,car=0..1,boro=",//
				"name=N5108,car=1,boro=",//
				"name=N5109,car=0..1,boro=",//
				"name=N5110,car=1,boro=",//
				"name=N5111,car=1,boro=",//
				"name=N5116,car=1,boro=",//
				"name=N5117,car=1,boro=",//
				"name=N5135,car=1,boro=",//
				"name=N5151,car=1,boro=",//
				"name=N5158,car=1,boro=",//
				"name=N5162,car=1,boro=",//
				"name=N5165,car=1,boro=",//
				"name=N5166,car=1,boro=",//
				"name=N5167,car=1,boro=",//
				"name=N5168,car=0..1,boro=",//
				"name=N5201,car=0..1,boro=",//
				"name=N5202,car=1,boro=",//
				"name=N5203,car=1,boro=",//
				"name=N5204,car=1,boro=",//
				"name=N5205,car=1,boro=",//
				"name=N5251,car=1,boro=",//
				"name=N5252,car=1,boro=",//
				"name=N5262,car=1,boro=",//
				"name=N5301,car=0..1,boro=",//
				"name=N5302,car=0..1,boro=",//
				"name=N5401,car=1,boro=",//
				"name=N5402,car=1,boro=",//
				"name=N5403,car=1,boro=",//
				"name=N5404,car=1,boro=",//
				"name=NX301,car=0..1,boro=",//
				"name=NX301_DN,car=0..1,boro=",//
				"name=NX302,car=0..1,boro=",//
				"name=NX302_DN,car=0..1,boro=",//
				"name=NX401,car=0..1,boro=",//
				"name=NX402,car=0..1,boro=",//
				"name=NX5105,car=1,boro=",//
				"name=NX5106,car=0..1,boro=",//
				"name=NX601,car=0..1,boro=",//
				"name=NX602,car=0..1,boro=",//
				"name=NX603,car=0..1,boro=",//
				"name=NX901,car=0..1,boro=",//
				"name=NX902,car=0..1,boro=",//
				"name=NX903,car=0..1,boro=",//
		})
		public class Agent {

			public Agent() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Agent. Function. Code", uid = "102", cls = "Agent")
			public String FunctionCode;

			@DSREF(den = "Agent. Identification. Identifier", uid = "R004", cls = "Agent")
			@AAA(msg = {
					//
					"name=N5107,car=1,boro=,chn=報關業者箱號",//
					"name=N5109,car=1,boro=,chn=報關業者箱號",//
					"name=N5110,car=1,boro=,chn=報關業者箱號",//
					"name=N5111,car=1,boro=,chn=報關業者箱號",//
					"name=N5116,car=1,boro=,chn=報關業者箱號",//
					"name=N5135,car=1,boro=,chn=報關業者箱號",//
					"name=N5167,car=1,boro=,chn=報關業者箱號",//
					"name=N5168,car=1,boro=,chn=報關業者箱號",//
					"name=N5201,car=1,boro=,chn=報關業者箱號",//
					"name=N5203,car=1,boro=,chn=報關業者箱號",//
					"name=N5204,car=1,boro=,chn=報關業者箱號",//
					"name=N5205,car=1,boro=,chn=報關業者箱號",//
					"name=N5301,car=1,boro=,chn=報關業者箱號",//
					"name=N5302,car=1,boro=,chn=報關業者箱號",//
					"name=NX301,car=1,boro=,chn=報關業者箱號",//
					"name=NX301_DN,car=1,boro=,chn=報關業者箱號",//
					"name=NX302,car=1,boro=,chn=報關業者箱號",//
					"name=NX302_DN,car=1,boro=,chn=報關業者箱號",//
					"name=NX401,car=1,boro=,chn=報關業者箱號",//
					"name=NX402,car=1,boro=,chn=報關業者箱號",//
					"name=NX5105,car=1,boro=,chn=報關業者箱號",//
					"name=NX5106,car=1,boro=,chn=報關業者箱號",//
					"name=NX601,car=1,boro=,chn=報關業者箱號",//
					"name=NX602,car=1,boro=,chn=報關業者箱號",//
					"name=NX603,car=1,boro=,chn=報關業者箱號",//
					"name=NX901,car=1,boro=,chn=報關業者箱號",//
					"name=NX902,car=1,boro=,chn=報關業者箱號",//
			})
			public String ID;

			@DSREF(den = "Agent. Name. Text", uid = "R003", cls = "Agent")
			public String Name;

			@DSREF(den = "Agent. Quality Assurance. Indicator", uid = "249", cls = "Agent")
			public String QualityAssuranceIndicator;

			@DSREF(den = "Agent. Role. Code", uid = "R005", cls = "Agent")
			@AAA(msg = {
					//
					"name=N5107,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=N5109,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=N5110,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=N5111,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=N5116,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=N5135,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=N5167,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=N5168,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=N5201,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=N5203,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=N5204,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=N5205,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=N5301,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=N5302,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=NX301,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=NX301_DN,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=NX302,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=NX302_DN,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=NX401,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=NX402,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=NX5105,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=NX5106,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=NX601,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=NX602,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=NX603,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=NX901,car=1,boro=,chn=*代理人號碼類別代碼",//
					"name=NX902,car=1,boro=,chn=*代理人號碼類別代碼",//
			})
			public String RoleCode;

			@DSREF(den = "Agent. Sub Box. Identifier", uid = "TW100", cls = "Agent")
			@AAA(msg = {
					//
					"name=N5107,car=1,boro=,chn=報關業者箱號附碼",//
					"name=N5109,car=1,boro=,chn=報關業者箱號附碼",//
					"name=N5110,car=1,boro=,chn=報關業者箱號附碼",//
					"name=N5111,car=1,boro=,chn=報關業者箱號附碼",//
					"name=N5116,car=1,boro=,chn=報關業者箱號附碼",//
					"name=N5135,car=1,boro=,chn=報關業者箱號附碼",//
					"name=N5167,car=1,boro=,chn=報關業者箱號附碼",//
					"name=N5168,car=1,boro=,chn=報關業者箱號附碼",//
					"name=N5201,car=1,boro=,chn=報關業者箱號附碼",//
					"name=N5203,car=1,boro=,chn=報關業者箱號附碼",//
					"name=N5204,car=1,boro=,chn=報關業者箱號附碼",//
					"name=N5205,car=1,boro=,chn=報關業者箱號附碼",//
					"name=N5301,car=1,boro=,chn=報關業者箱號附碼",//
					"name=N5302,car=1,boro=,chn=報關業者箱號附碼",//
					"name=NX301,car=1,boro=,chn=報關業者箱號附碼",//
					"name=NX301_DN,car=1,boro=,chn=報關業者箱號附碼",//
					"name=NX302,car=1,boro=,chn=報關業者箱號附碼",//
					"name=NX302_DN,car=1,boro=,chn=報關業者箱號附碼",//
					"name=NX401,car=1,boro=,chn=報關業者箱號附碼",//
					"name=NX402,car=1,boro=,chn=報關業者箱號附碼",//
					"name=NX5105,car=1,boro=,chn=報關業者箱號附碼",//
					"name=NX5106,car=1,boro=,chn=報關業者箱號附碼",//
					"name=NX601,car=1,boro=,chn=報關業者箱號附碼",//
					"name=NX602,car=1,boro=,chn=報關業者箱號附碼",//
					"name=NX603,car=1,boro=,chn=報關業者箱號附碼",//
					"name=NX901,car=1,boro=,chn=報關業者箱號附碼",//
					"name=NX902,car=1,boro=,chn=報關業者箱號附碼",//
			})
			public String tw_SubBoxID;

			public Address Address = new Address();

			@DSREF(cls = "Address")
			public class Address {

				public Address() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
				public String CityName;
				@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
				public String CountryCode;
				@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
				public String CountrySubDivisionID;
				@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
				public String CountrySubDivisionName;
				@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
				public String Line;
				@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
				public String PostcodeID;
			}

			public Communication Communication = new Communication();

			@DSREF(cls = "Communication")
			// @NX301(car = "", chn = "", mc = "")
			public class Communication {

				public Communication() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
				public String ID;
				@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
				public String TypeID;
			}

			public Contact Contact = new Contact();

			@DSREF(cls = "Contact")
			public class Contact {

				public Contact() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
				public String Name;
				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}
			}

			public GovernmentProcedure GovernmentProcedure = new GovernmentProcedure();

			@DSREF(cls = "Government Procedure")
			public class GovernmentProcedure {

				public GovernmentProcedure() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Government Procedure. Extra Requirement. Code", uid = "TW_103", cls = "Government Procedure")
				public String tw_ExtraRequirementCode;
			}

			public RepresentativePerson RepresentativePerson = new RepresentativePerson();

			@DSREF(cls = "Representative Person")
			public class RepresentativePerson {

				public RepresentativePerson() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Representative Person. Contact Function. Text", uid = "248", cls = "Representative Person")
				public String ContactFunction;
				@DSREF(den = "Representative Person. Name. Text", uid = "R006", cls = "Representative Person")
				public String Name;
				public Address Address = new Address();

				@DSREF(cls = "Address")
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;
					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;
					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

		}

		public Amendment Amendment = new Amendment();

		@DSREF(cls = "Amendment")
		public class Amendment {

			public Amendment() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Amendment. Change Reason. Code", uid = "099", cls = "Amendment")
			public String ChangeReasonCode;
			public Pointer Pointer = new Pointer();

			@DSREF(cls = "Pointer")
			public class Pointer {

				public Pointer() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Pointer. Document Section. Code", uid = "375", cls = "Pointer")
				public String DocumentSectionCode;
				@DSREF(den = "Pointer. Sequence. Numeric", uid = "006", cls = "Pointer")
				public String SequenceNumeric;
				@DSREF(den = "Pointer. Tag. Identifier", uid = "381", cls = "Pointer")
				public String TagID;
			}
		}

		public ApprovedEstablishmentPlace ApprovedEstablishmentPlace = new ApprovedEstablishmentPlace();

		@DSREF(cls = "Approved Establishment Place")
		public class ApprovedEstablishmentPlace {

			public ApprovedEstablishmentPlace() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Approved Establishment Place. Identification. Identifier", uid = "L058", cls = "Approved Establishment Place")
			public String ID;
			@DSREF(den = "Approved Establishment Place. Name. Text", uid = "L057", cls = "Approved Establishment Place")
			public String Name;
		}

		public Authenticator Authenticator = new Authenticator();

		@DSREF(cls = "Authenticator")
		public class Authenticator {

			public Authenticator() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Authenticator. Identification. Identifier", uid = "R008", cls = "Authenticator")
			public String ID;

			@DSREF(den = "Authenticator. Name. Text", uid = "R007", cls = "Authenticator")
			public String Name;

			public Address Address = new Address();

			@DSREF(cls = "Address")
			public class Address {

				public Address() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
				public String CityName;
				@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
				public String CountryCode;
				@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
				public String CountrySubDivisionID;
				@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
				public String CountrySubDivisionName;
				@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
				public String Line;
				@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
				public String PostcodeID;
			}

			public Communication Communication = new Communication();

			@DSREF(cls = "Communication")
			public class Communication {

				public Communication() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
				public String ID;
				@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
				public String TypeID;
			}

			public Contact Contact = new Contact();

			@DSREF(cls = "Contact")
			public class Contact {

				public Contact() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
				public String Name;
				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}
			}
		}

		public AuthorisedPerson AuthorisedPerson = new AuthorisedPerson();

		@DSREF(cls = "Authorised Person")
		public class AuthorisedPerson {

			public AuthorisedPerson() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Authorised Person. Identification. Identifier", uid = "R068", cls = "Authorised Person")
			public String ID;
			@DSREF(den = "Authorised Person. Name. Text", uid = "R067", cls = "Authorised Person")
			public String Name;
			public Address Address = new Address();

			@DSREF(cls = "Address")
			public class Address {

				public Address() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
				public String CityName;
				@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
				public String CountryCode;
				@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
				public String CountrySubDivisionID;
				@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
				public String CountrySubDivisionName;
				@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
				public String Line;
				@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
				public String PostcodeID;
			}

			public Communication Communication = new Communication();

			@DSREF(cls = "Communication")
			public class Communication {

				public Communication() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
				public String ID;
				@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
				public String TypeID;
			}

			public Contact Contact = new Contact();

			@DSREF(cls = "Contact")
			public class Contact {

				public Contact() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
				public String Name;
				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}
			}
		}

		public BankAccount BankAccount = new BankAccount();

		@DSREF(cls = "Bank Account")
		public class BankAccount {

			public BankAccount() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Bank Account. Identification. Identifier", uid = "372", cls = "Bank Account")
			public String ID;

			@DSREF(den = "Bank Account. Reference. Identifier", uid = "R069", cls = "Bank Account")
			public String ReferenceID;
		}

		public BorderTransportMeans BorderTransportMeans = new BorderTransportMeans();

		@DSREF(cls = "Border Transport Means")
		@AAA(msg = {
				//
				"name=N5101,car=1,boro=",//
				"name=N5102,car=1,boro=",//
				"name=N5103,car=1,boro=",//
				"name=N5107,car=1,boro=",//
				"name=N5108,car=1,boro=",//
				"name=N5109,car=1,boro=",//
				"name=N5110,car=0..1,boro=",//
				"name=N5111,car=1,boro=",//
				"name=N5116,car=1,boro=",//
				"name=N5117,car=1,boro=",//
				"name=N5135,car=1,boro=",//
				"name=N5151,car=1,boro=",//
				"name=N5158,car=1,boro=",//
				"name=N5162,car=1,boro=",//
				"name=N5165,car=1,boro=",//
				"name=N5166,car=1,boro=",//
				"name=N5167,car=1,boro=",//
				"name=N5168,car=1,boro=",//
				"name=N5170,car=1,boro=",//
				"name=N5201,car=1,boro=",//
				"name=N5202,car=1,boro=",//
				"name=N5203,car=1,boro=",//
				"name=N5204,car=1,boro=",//
				"name=N5205,car=1,boro=",//
				"name=N5251,car=1,boro=",//
				"name=N5252,car=1,boro=",//
				"name=N5262,car=1,boro=",//
				"name=N5301,car=1,boro=#",//
				"name=N5302,car=1,boro=#",//
				"name=N5401,car=1,boro=",//
				"name=N5402,car=1,boro=",//
				"name=N5403,car=1,boro=",//
				"name=N5404,car=1,boro=",//
				"name=NX301,car=1,boro=",//
				"name=NX301_DN,car=1,boro=",//
				"name=NX401,car=1,boro=",//
				"name=NX402,car=1,boro=",//
				"name=NX5105,car=1,boro=",//
				"name=NX5106,car=0..1,boro=",//
				"name=NX601,car=1,boro=",//
				"name=NX603,car=1,boro=",//
				"name=NX801,car=1,boro=",//
				"name=NX802,car=1,boro=",//
		})
		public class BorderTransportMeans {

			public BorderTransportMeans() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Border Transport Means. Arrival. Date Time", uid = "172", cls = "Border Transport Means")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=,chn=（預定）抵達第一港口之日期與時間",//
					"name=N5102,car=0..1,boro=,chn=進口日期",//
					"name=N5107,car=0..1,boro=,chn=進口日期",//
					"name=N5108,car=0..1,boro=,chn=航機抵達日期",//
					"name=N5110,car=1,boro=,chn=進口日期",//
					"name=N5116,car=1,boro=,chn=進口日期",//
					"name=N5135,car=1,boro=,chn=進口日期",//
					"name=N5162,car=0..1,boro=,chn=進口日期",//
					"name=N5202,car=0..1,boro=,chn=航行次一港預定到達日期與時間",//
					"name=NX301,car=1,boro=,chn=進口日期",//
					"name=NX301_DN,car=1,boro=,chn=進口日期",//
					"name=NX401,car=0..1,boro=,chn=進口日期",//
					"name=NX5105,car=1,boro=,chn=進口日期",//
					"name=NX601,car=1,boro=,chn=進口日期",//
					"name=NX603,car=1,boro=,chn=進口日期",//
					"name=NX801,car=0..1,boro=,chn=進口日期",//
			})
			public String ArrivalDateTime;

			@DSREF(den = "Border Transport Means. Conveyance First Port Of Arrival. Date Time", uid = "267", cls = "Border Transport Means")
			public String ConveyanceFirstPortOfArrivalDateTime;

			@DSREF(den = "Border Transport Means. Departure. Date Time", uid = "156", cls = "Border Transport Means")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=,chn=前一國外港離港日期與時間",//
					"name=N5202,car=0..1,boro=,chn=離港日期與時間",//
					"name=N5251,car=0..1,boro=,chn=預定開航日期與時間",//
			})
			public String DepartureDateTime;

			@DSREF(den = "Border Transport Means. First Arrival Location. Identifier", uid = "085", cls = "Border Transport Means")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=,chn=停泊港口代碼",//
					"name=N5202,car=0..1,boro=,chn=航行次一港",//
					"name=N5251,car=0..1,boro=,chn=航行次一港",//
			})
			public String FirstArrivalLocationID;

			@DSREF(den = "Border Transport Means. Identification. Identifier", uid = "T006", cls = "Border Transport Means")
			@AAA(msg = {
					//
					"name=N5101,car=1,boro=,chn=船（機）代碼",//
					"name=N5102,car=1,boro=,chn=船（機）代碼",//
					"name=N5103,car=1,boro=,chn=船（機）代碼",//
					"name=N5108,car=0..1,boro=,chn=船（機）代碼",//
					"name=N5151,car=1,boro=,chn=船（機）代碼",//
					"name=N5158,car=1,boro=,chn=船（機）代碼",//
					"name=N5162,car=1,boro=,chn=船（機）代碼",//
					"name=N5165,car=0..1,boro=,chn=船（機）代碼",//
					"name=N5166,car=1,boro=,chn=船（機）代碼",//
					"name=N5170,car=1,boro=,chn=船（機）代碼",//
			})
			public String ID;

			@DSREF(den = "Border Transport Means. Importation Into Port Limits. Date Time", uid = "271", cls = "Border Transport Means")
			public String ImportationIntoPortLimitsDateTime;

			@DSREF(den = "Border Transport Means. Journey. Identifier", uid = "149", cls = "Border Transport Means")
			@AAA(msg = {
					//
					"name=N5101,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
					"name=N5102,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
					"name=N5103,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
					"name=N5108,car=0..1,boro=,chn=船舶航次（海）/航機班次（空）",//
					"name=N5151,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
					"name=N5158,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
					"name=N5162,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
					"name=N5165,car=0..1,boro=,chn=船舶航次（海）/航機班次（空）",//
					"name=N5166,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
					"name=N5170,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
					"name=N5202,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
					"name=N5251,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
					"name=N5252,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
					"name=N5262,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
			})
			public String JourneyID;

			@DSREF(den = "Border Transport Means. Name. Text", uid = "T005", cls = "Border Transport Means")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=,chn=船舶名稱",//
					"name=N5103,car=0..1,boro=,chn=船舶名稱",//
					"name=N5151,car=1,boro=,chn=船舶名稱",//
					"name=N5165,car=0..1,boro=,chn=船舶名稱",//
			})
			public String Name;

			@DSREF(den = "Border Transport Means. Registration Nationality. Code", uid = "T014", cls = "Border Transport Means")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=,chn=船/機國籍代碼",//
					"name=N5103,car=0..1,boro=,chn=船/機國籍代碼",//
					"name=N5202,car=0..1,boro=,chn=船/機國籍代碼",//
			})
			public String RegistrationNationalityCode;

			@DSREF(den = "Border Transport Means. Transport Equipment. Quantity", uid = "150", cls = "Border Transport Means")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=#,chn=貨櫃總數",//
					"name=N5103,car=1,boro=#,chn=貨櫃總數",//
					"name=N5202,car=0..1,boro=#,chn=貨櫃總數",//
			})
			public String TransportEquipmentQuantity;

			@DSREF(den = "Border Transport Means. Boarded. Quantity", uid = "314", cls = "Border Transport Means")
			@AAA(msg = {
			//
			"name=N5101,car=0..1,boro=*,chn=艙號筆數",//
			})
			public String tw_BoardedQuantity;

			@DSREF(den = "Border Transport Means. Call Sign. Identifier", uid = "TW092", cls = "Border Transport Means")
			@AAA(msg = {
					//
					"name=N5151,car=1,boro=,chn=船舶呼號",//
					"name=N5202,car=0..1,boro=,chn=船舶呼號",//
			})
			public String tw_CallSignID;

			@DSREF(den = "Border Transport Means. Pier. Code", uid = "TW044", cls = "Border Transport Means")
			public String tw_PierCode;

			@DSREF(den = "Border Transport Means. Registration. Text", uid = "TW043", cls = "Border Transport Means")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=,chn=海關通關號碼",//
					"name=N5102,car=0..1,boro=,chn=海關通關號碼",//
					"name=N5108,car=0..1,boro=,chn=海關通關號碼",//
					"name=N5162,car=0..1,boro=,chn=海關通關號碼",//
					"name=N5165,car=0..1,boro=,chn=海關通關號碼",//
					"name=N5166,car=0..1,boro=,chn=海關通關號碼",//
					"name=N5170,car=0..1,boro=,chn=海關通關號碼",//
					"name=N5201,car=0..1,boro=,chn=海關通關號碼",//
					"name=N5202,car=0..1,boro=,chn=海關通關號碼",//
					"name=N5251,car=0..1,boro=,chn=海關通關號碼",//
					"name=N5252,car=1,boro=,chn=海關通關號碼",//
					"name=N5262,car=0..1,boro=,chn=海關通關號碼",//
					"name=N5301,car=0..1,boro=,chn=海關通關號碼",//
					"name=N5302,car=0..1,boro=,chn=海關通關號碼",//
			})
			public String tw_Registration;

			@DSREF(den = "Consignment. Shipping Order Number. Text", uid = "TW078", cls = "Consignment")
			public String tw_ShippingOrderNumber;

			@DSREF(den = "Border Transport Means. Vessel. Identifier", uid = "TW_107", cls = "Border Transport Means")
			public String tw_VesselID;

			@DSREF(den = "Border Transport Means. Export Journey. Identifier", uid = "TW091", cls = "Border Transport Means")
			@AAA(msg = {
			//
			"name=N5151,car=0..1,boro=,chn=出口航次",//
			})
			public String tw_ExportJourneyID;

			@DSREF(den = "Border Transport Means. Type. Code", uid = "T010", cls = "Border Transport Means")
			@AAA(msg = {
					//
					"name=N5101,car=1,boro=,chn=海空運別",//
					"name=N5102,car=1,boro=,chn=海空運別",//
					"name=N5107,car=1,boro=,chn=海空運別",//
					"name=N5108,car=1,boro=,chn=海空運別",//
					"name=N5116,car=1,boro=,chn=海空運別",//
					"name=N5117,car=1,boro=,chn=海空運別",//
					"name=N5162,car=1,boro=,chn=海空運別",//
					"name=N5165,car=1,boro=,chn=海空運別",//
					"name=N5201,car=1,boro=,chn=海空運別",//
					"name=N5202,car=1,boro=,chn=海空運別",//
					"name=N5203,car=1,boro=,chn=海空運別",//
					"name=N5204,car=1,boro=,chn=海空運別",//
					"name=N5301,car=1,boro=,chn=海空運別",//
					"name=N5302,car=1,boro=,chn=海空運別",//
					"name=NX301,car=1,boro=,chn=海空運別",//
					"name=NX301_DN,car=1,boro=,chn=海空運別",//
					"name=NX401,car=1,boro=,chn=海空運別",//
					"name=NX5105,car=1,boro=,chn=海空運別",//
					"name=NX5106,car=1,boro=,chn=海空運別",//
					"name=NX601,car=1,boro=,chn=海空運別",//
					"name=NX603,car=1,boro=,chn=海空運別",//
					"name=NX801,car=1,boro=,chn=海空運別",//
					"name=NX802,car=1,boro=,chn=海空運別",//
			})
			public String TypeCode;

			public DepartureConveryanceFacility DepartureConveryanceFacility = new DepartureConveryanceFacility();

			@DSREF(cls = "Departure Conveyance Facility")
			public class DepartureConveryanceFacility {

				public DepartureConveryanceFacility() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Departure Conveyance Facility. Identification. Identifier", uid = "L053", cls = "Departure Conveyance Facility")
				public String ID;
			}

			public DepartureTransportMeans DepartureTransportMeans = new DepartureTransportMeans();

			@DSREF(cls = "Departure Transport Means")
			public class DepartureTransportMeans {

				public DepartureTransportMeans() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Departure Transport Means. Identification. Identifier", uid = "T004", cls = "Departure Transport Means")
				public String ID;

				@DSREF(den = "Departure Transport Means. Name. Text", uid = "T003", cls = "Departure Transport Means")
				public String Name;

				@DSREF(den = "Departure Transport Means. Registration Nationality. Code", uid = "T013", cls = "Departure Transport Means")
				public String RegistrationNationalityCode;

				@DSREF(den = "Departure Transport Means. Type. Code", uid = "T009", cls = "Departure Transport Means")
				public String TypeCode;
			}

			public ExaminationPlace_Moved ExaminationPlace = new ExaminationPlace_Moved();

			@DSREF(cls = "Examination Place")
			public class ExaminationPlace_Moved {

				public ExaminationPlace_Moved() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Examination Place. Identification. Identifier", uid = "L029", cls = "Examination Place")
				public String ID;
				@DSREF(den = "Examination Place. Name. Text", uid = "L069", cls = "Examination Place")
				public String Name;
			}

			public GoodsConsignedPlace_Added GoodsConsignedPlace_Added = new GoodsConsignedPlace_Added();

			@DSREF(cls = "Goods Consigned Place")
			public class GoodsConsignedPlace_Added {

				public GoodsConsignedPlace_Added() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Goods Consigned Place. Identification. Identifier", uid = "L024", cls = "Goods Consigned Place")
				public String ID;

				@DSREF(den = "Goods Consigned Place. Name. Text", uid = "L023", cls = "Goods Consigned Place")
				public String Name;
			}

			public GoodsLocation_A GoodsLocation = new GoodsLocation_A();

			@DSREF(cls = "Goods Location")
			@AAA(msg = {
			//
			"name=N5166,car=1,boro=+",//
			})
			public class GoodsLocation_A {

				public GoodsLocation_A() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Goods Location. Identification. Identifier", uid = "L017", cls = "Goods Location")
				@AAA(msg = {
				//
				"name=N5166,car=1,boro=,chn=卸存地點代碼",//
				})
				public String ID;

				@DSREF(den = "Goods Location. Name. Text", uid = "L016", cls = "Goods Location")
				public String Name;
			}

			public Itinerary Itinerary = new Itinerary();

			@DSREF(cls = "Itinerary")
			@AAA(msg = {
					//
					"name=N5101,car=0..99,boro=",//
					"name=N5102,car=1,boro=",//
					"name=N5107,car=1,boro=",//
					"name=N5108,car=1,boro=",//
					"name=N5109,car=1,boro=",//
					"name=N5110,car=1,boro=",//
					"name=N5111,car=1,boro=",//
					"name=N5116,car=1,boro=",//
					"name=N5117,car=1,boro=",//
					"name=N5135,car=1,boro=",//
					"name=N5151,car=1,boro=",//
					"name=N5158,car=1,boro=",//
					"name=N5162,car=1,boro=",//
					"name=N5165,car=1,boro=",//
					"name=N5166,car=1,boro=",//
					"name=N5167,car=1,boro=",//
					"name=N5168,car=1,boro=",//
					"name=N5201,car=1,boro=",//
					"name=N5202,car=1,boro=",//
					"name=N5203,car=0..99,boro=#",//
					"name=N5204,car=1,boro=",//
					"name=N5205,car=1,boro=",//
					"name=N5251,car=1,boro=",//
					"name=N5252,car=1,boro=",//
					"name=N5262,car=1,boro=",//
					"name=N5301,car=1,boro=",//
					"name=N5302,car=1,boro=",//
					"name=N5402,car=1,boro=",//
					"name=N5403,car=1,boro=",//
					"name=N5404,car=1,boro=",//
					"name=NX401,car=0..99,boro=#",//
					"name=NX5105,car=0..99,boro=#",//
			})
			public class Itinerary {

				public Itinerary() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Itinerary. Routing Country. Code", uid = "064", cls = "Itinerary")
				@AAA(msg = {
						//
						// "name=N5101,car=1,boro=,chn=過境國家代碼",//
						"name=N5203,car=1,boro=,chn=過境國家代碼",//
						"name=NX401,car=1,boro=,chn=過境國家代碼",//
						"name=NX5105,car=1,boro=,chn=過境國家代碼",//
				})
				public String RoutingCountryCode;

				@DSREF(den = "Itinerary. Routing Region. Identifer", uid = "393", cls = "Itinerary")
				public String RoutingRegionID;
			}

			public Master_borrowed Master = new Master_borrowed();

			@DSREF(cls = "Master")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=",//
					"name=N5103,car=0..1,boro=",//
					"name=N5202,car=0..1,boro=",//
			})
			public class Master_borrowed {

				public Master_borrowed() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Master. Identification. Identifier", uid = "R017", cls = "Master")
				public String ID;

				@DSREF(den = "Master. Name. Text", uid = "R016", cls = "Master")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=,chn=船/機長姓名",//
						"name=N5103,car=1,boro=,chn=船/機長姓名",//
						"name=N5202,car=1,boro=,chn=船/機長姓名",//
				})
				public String Name;
			}

			public TransitDestination TransitDestination = new TransitDestination();

			@DSREF(cls = "Transit Destination")
			@AAA(msg = {
			//
			"name=N5166,car=0..1,boro=+",//
			})
			public class TransitDestination {

				public TransitDestination() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Transit Destination. Identification. Identifier", uid = "L008", cls = "Transit Destination")
				@AAA(msg = {
				//
				"name=N5166,car=1,boro=,chn=轉運/轉口地點代碼",//
				})
				public String ID;

			}

			public TransportEquipment TransportEquipment = new TransportEquipment();

			@DSREF(cls = "Transport Equipment")
			@AAA(msg = {
					//
					"name=N5165,car=0..1,boro=",//
					"name=N5166,car=0..1,boro=#",//
					"name=N5201,car=0..999,boro=",//
			})
			public class TransportEquipment {

				public TransportEquipment() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Transport Equipment. Characteristic. Code", uid = "152", cls = "Transport Equipment")
				@AAA(msg = {
				//
				"name=N5165,car=1,boro=,chn=貨櫃種類",//
				})
				public String CharacteristicCode;

				@DSREF(den = "Transport Equipment. Identification. Identifier", uid = "159", cls = "Transport Equipment")
				@AAA(msg = {
				//
				"name=N5165,car=1,boro=,chn=貨櫃號碼",//
				})
				public String ID;

				@DSREF(den = "Transport Equipment. License Plate Issuing Country. Code", uid = "279", cls = "Transport Equipment")
				public String LicensePlateIssuingCountryCode;

				@DSREF(den = "Transport Equipment. Registration Country Subdivision. Code", uid = "293", cls = "Transport Equipment")
				public String RegistrationCountrySubdivisionCode;

				@DSREF(den = "Transport Equipment. Sequence. Numeric", uid = "006", cls = "Transport Equipment")
				public String SequenceNumeric;

				@DSREF(den = "Transport Equipment. Empty Container. Quantity", uid = "TW105", cls = "Transport Equipment")
				@AAA(msg = {
				//
				"name=N5166,car=0..1,boro=,chn=空櫃總數",//
				})
				public String tw_EmptyContainerQuantity;

				@DSREF(den = "Transport Equipment. Full Container. Quantity", uid = "TW047", cls = "Transport Equipment")
				@AAA(msg = {
				//
				"name=N5166,car=1,boro=,chn=實櫃總數",//
				})
				public String tw_FullContainerQuantity;

				@DSREF(den = "Transport Equipment. Goods Loading Type. Code", uid = "TW048", cls = "Transport Equipment")
				@AAA(msg = {
				//
				"name=N5166,car=0..1,boro=,chn=貨櫃（物）裝貨型態",//
				})
				public String tw_GoodsLoadingTypeCode;

				@DSREF(den = "Transport Equipment. Used Capacity. Code", uid = "TW030", cls = "Transport Equipment")
				// @N5165(car = "1", chn = "貨櫃（物）裝貨型態")
				public String tw_UsedCapacityCode;

				public tw_Seal tw_Seal = new tw_Seal();

				@DSREF(cls = "Seal")
				@AAA(msg = {
				//
				"name=N5165,car=0..10,boro=",//
				})
				public class tw_Seal {

					public tw_Seal() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Seal. Seal. Identifier", uid = "165", cls = "Seal")
					@AAA(msg = {
					//
					"name=N5165,car=1,boro=*,chn=封條號碼",//
					})
					public String tw_SealID;

				}
			}

			public TransportMeansOperator TransportMeansOperator = new TransportMeansOperator();

			@DSREF(cls = "Transport Means Operator")
			public class TransportMeansOperator {

				public TransportMeansOperator() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Transport Means Operator. Identification. Identifier", uid = "R056", cls = "Transport Means Operator")
				public String ID;

			}

			public TranshipmentLocation TranshipmentLocation = new TranshipmentLocation();

			@DSREF(cls = "Transhipment Location")
			public class TranshipmentLocation {

				public TranshipmentLocation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Transhipment Location. Identification. Identifier", uid = "L015", cls = "Transhipment Location")
				public String ID;

				@DSREF(den = "Transhipment Location. Name. Text", uid = "L014", cls = "Transhipment Location")
				public String Name;
			}

		}

		public Carrier_Moved Carrier = new Carrier_Moved();

		@DSREF(cls = "Carrier")
		@AAA(msg = {
				//
				"name=N5101,car=1..99,boro=",//
				"name=N5103,car=1,boro=",//
				"name=N5151,car=1,boro=",//
				"name=N5158,car=1,boro=",//
				"name=N5162,car=1,boro=",//
				"name=N5165,car=0..1,boro=",//
				"name=N5166,car=0..1,boro=",//
				"name=N5168,car=1,boro=",//
				"name=N5170,car=0..1,boro=",//
				"name=N5201,car=0..1,boro=",//
				"name=N5202,car=1..99,boro=",//
				"name=N5251,car=1,boro=",//
				"name=N5252,car=1,boro=",//
				"name=N5262,car=1,boro=",//
				"name=N5301,car=0..1,boro=",//
				"name=N5302,car=0..1,boro=",//
		})
		public class Carrier_Moved {

			public Carrier_Moved() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Carrier. Identification. Identifier", uid = "R012", cls = "Carrier")
			@AAA(msg = {
					//
					"name=N5101,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5103,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5151,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5158,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5162,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5165,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5166,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5168,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5170,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5201,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5202,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5251,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5252,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5262,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5301,car=1,boro=,chn=運輸業者/代理行代碼",//
					"name=N5302,car=1,boro=,chn=運輸業者/代理行代碼",//
			})
			public String ID;

			@DSREF(den = "Carrier. Name. Text", uid = "R011", cls = "Carrier")
			public String Name;

			@DSREF(den = "Carrier. Type. Code", uid = "TW061", cls = "Carrier")
			@AAA(msg = {
					//
					"name=N5101,car=1,boro=,chn=運輸業者/代理行類別代碼",//
					"name=N5202,car=1,boro=,chn=運輸業者/代理行類別代碼",//
			})
			public String tw_TypeCode;

		}

		public Consignment Consignment = new Consignment();

		@DSREF(cls = "Consignment")
		@AAA(msg = {
				//
				"name=N5101,car=0..9999,boro=",//
				"name=N5102,car=1,boro=",//
				"name=N5103,car=1..99999,boro=",//
				"name=N5107,car=0..1,boro=#",//
				"name=N5108,car=0..1,boro=",//
				"name=N5109,car=1,boro=",//
				"name=N5110,car=1,boro=",//
				"name=N5111,car=1,boro=",//
				"name=N5116,car=0..1,boro=#",//
				"name=N5117,car=1..9999,boro=",//
				"name=N5135,car=1,boro=#",//
				"name=N5151,car=1,boro=#",//
				"name=N5158,car=1..99,boro=",//
				"name=N5162,car=1,boro=",//
				"name=N5165,car=0..1,boro=#",//
				"name=N5166,car=1..9999,boro=",//
				"name=N5167,car=1,boro=",//
				"name=N5168,car=1,boro=",//
				"name=N5170,car=1..999,boro=",//
				"name=N5201,car=1,boro=",//
				"name=N5202,car=0..9999,boro=",//
				"name=N5203,car=1,boro=",//
				"name=N5204,car=1,boro=",//
				"name=N5205,car=1,boro=#",//
				"name=N5251,car=1..99,boro=#",//
				"name=N5252,car=1..99,boro=",//
				"name=N5262,car=1..9999,boro=",//
				"name=N5301,car=1,boro=",//
				"name=N5302,car=1,boro=",//
				"name=N5401,car=1,boro=",//
				"name=N5402,car=1,boro=",//
				"name=N5403,car=1,boro=",//
				"name=N5404,car=1,boro=",//
				"name=NX201_01,car=0..1,boro=#",//
				"name=NX301_DN,car=1,boro=#",//
				"name=NX5105,car=0..9999,boro=#",//
				"name=NX601,car=1,boro=#",//
				"name=NX801,car=0..1,boro=#",//
		})
		public class Consignment {

			public Consignment() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Consignment. Arrival Confirmation. Indicator", uid = "162", cls = "Consignment")
			public String ArrivalConfirmationIndicator;

			@DSREF(den = "Consignment. Boarded. Quantity", uid = "314", cls = "Consignment")
			@AAA(msg = {
					//
					"name=N5107,car=0..1,boro=,chn=併袋筆數",//
					"name=N5116,car=0..1,boro=,chn=併袋筆數",//
					"name=N5108,car=0..1,boro=,chn=艙號筆數",//
					"name=N5135,car=0..1,boro=,chn=併袋筆數",//
					"name=N5205,car=0..1,boro=,chn=併袋筆數",//
			})
			public String BoardedQuantity;

			@DSREF(den = "Consignment. Carrier Assigned. Identifier", uid = "004", cls = "Consignment")
			public String CarrierAssignedID;
			@DSREF(den = "Consignment. Container. Indicator", uid = "096", cls = "Consignment")
			public String ContainerIndicator;

			@DSREF(den = "Consignment. Goods Status. Code", uid = "094", cls = "Consignment")
			@AAA(msg = {
			//
			"name=N5117,car=0..1,boro=,chn=部分放行註記",//
			})
			public String GoodsStatusCode;

			@DSREF(den = "Consignment. Gross Volume. Measure", uid = "134", cls = "Consignment")
			@AAA(msg = {
			//
			"name=N5101,car=0..1,boro=,chn=體積",//
			})
			public String GrossVolumeMeasure;

			@DSREF(den = "Consignment. Sequence. Numeric", uid = "006", cls = "Consignment")
			@AAA(msg = {
			//
			// "name=N5101,car=0..1,boro=,chn=艙單號碼",//
			// "name=N5102,car=0..1,boro=,chn=艙單號碼",//
			// "name=N5108,car=0..1,boro=,chn=艙單號碼",//
			// "name=N5162,car=0..1,boro=,chn=艙單號碼",//
			// "name=N5166,car=0..1,boro=,chn=艙單號碼",//
			})
			public String SequenceNumeric;

			@DSREF(den = "Consignment. Total Package. Quantity", uid = "146", cls = "Consignment")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=,chn=總件數",//
					"name=N5102,car=0..1,boro=,chn=本批件數",//
					"name=N5117,car=0..1,boro=,chn=出倉件數",//
					"name=N5162,car=1,boro=,chn=實到件數",//
					"name=N5165,car=0..1,boro=,chn=本櫃車件數",//
					"name=N5201,car=1,boro=,chn=總件數",//
					"name=N5202,car=0..1,boro=,chn=總件數",//
			})
			public String TotalPackageQuantity;

			@DSREF(den = "Consignment. Declaration Office. Identifier", uid = "065", cls = "Consignment")
			@AAA(msg = {
					//
					"name=N5202,car=0..1,boro=*,chn=收單關別代碼",//
					"name=N5251,car=1,boro=*,chn=收單關別代碼",//
					"name=N5252,car=1,boro=*,chn=收單關別代碼",//
			})
			public String tw_DeclarationOfficeID;

			@DSREF(den = "Consignment. Exit Warehouse. Quantity", uid = "TW_123", cls = "Consignment")
			public String tw_ExitWarehouseQuantity;

			@DSREF(den = "Consignment. House Bill Note. Text", uid = "TW146", cls = "Consignment")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=,chn=分提單註記",//
					"name=N5202,car=0..1,boro=,chn=分號註記",//
			})
			public String tw_HouseBillNote;

			@DSREF(den = "Consignment. Invoice. Amount", uid = "109", cls = "Consignment")
			@AAA(msg = {
			//
			"name=N5101,car=0..1,boro=*,chn=申報之價值",//
			})
			public String tw_InvoiceAmount;

			@DSREF(den = "Consignment. Item Group. Identifier", uid = "TW_101", cls = "Consignment")
			public String tw_ItemGroupID;

			@DSREF(den = "Consignment. Manifest Serial Number. Text", uid = "TW153", cls = "Consignment")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=,chn=艙單號碼",//
					"name=N5102,car=0..1,boro=,chn=艙單號碼",//
					"name=N5108,car=0..1,boro=,chn=艙單號碼",//
					"name=N5162,car=0..1,boro=,chn=艙單號碼",//
					"name=N5166,car=0..1,boro=,chn=艙單號碼",//
			})
			public String tw_ManifestSerialNumber;

			@DSREF(den = "Consignment. Original Shipping Order Number. Text", uid = "TW151", cls = "Consignment")
			@AAA(msg = {
			//
			"name=N5202,car=0..1,boro=,chn=原裝貨單號碼",//
			})
			public String tw_OriginalShippingOrderNumber;

			@DSREF(den = "Consignment. Shipping Order Number. Text", uid = "TW078", cls = "Consignment")
			@AAA(msg = {
					//
					"name=N5108,car=0..1,boro=,chn=裝貨單號碼",//
					"name=N5201,car=0..1,boro=,chn=裝貨單號碼",//
					"name=N5202,car=0..1,boro=,chn=裝貨單號碼",//
					"name=N5262,car=0..1,boro=,chn=裝貨單號碼",//
					"name=N5301,car=0..1,boro=,chn=裝貨單號碼",//
					"name=N5302,car=0..1,boro=,chn=裝貨單號碼",//
			})
			public String tw_ShippingOrderNumber;

			@DSREF(den = "Consignment. Total Gross Mass. Measure", uid = "131", cls = "Consignment")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=*,chn=總毛重",//
					"name=N5202,car=0..1,boro=*,chn=總毛重",//
			})
			public String tw_TotalGrossMassMeasure;

			@DSREF(den = "Consignment. Type. Code", uid = "D013", cls = "Consignment")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=*,chn=艙單類別",//
					"name=N5166,car=0..1,boro=*,chn=艙單類別",//
					"name=N5202,car=0..1,boro=*,chn=艙單類別",//
					"name=N5262,car=1,boro=*,chn=艙單類別",//
			})
			public String tw_TypeCode;

			public AdditionalInformation AdditionalInformation = new AdditionalInformation();

			@DSREF(cls = "Additional Information")
			@AAA(msg = {
					//
					"name=N5117,car=0..1,boro=#",//
					"name=N5165,car=0..9,boro=#",//
					"name=N5201,car=0..1,boro=",//
					"name=N5251,car=1,boro=#",//
					"name=N5262,car=0..1,boro=#",//
			})
			public class AdditionalInformation {

				public AdditionalInformation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Additional Information. Limit. Date Time", uid = "264", cls = "Additional Information")
				@AAA(msg = {
						//
						"name=N5201,car=1,boro=,chn=截止收貨日",//
						"name=N5251,car=1,boro=,chn=截止收貨日",//
				})
				public String LimitDateTime;

				@DSREF(den = "Additional Information. Reconciliation Reason. Code", uid = "300", cls = "Additional Information")
				public String ReconciliationReasonCode;

				@DSREF(den = "Additional Information. Request Override. Code", uid = "095", cls = "Additional Information")
				public String RequestOverrideCode;

				@DSREF(den = "Additional Information. Requested Inspection. Date Time", uid = "220", cls = "Additional Information")
				public String RequestedInspectionDateTime;

				@DSREF(den = "Additional Information. Statement. Code", uid = "226", cls = "Additional Information")
				@AAA(msg = {
				//
				"name=N5165,car=1,boro=,chn=放行附帶條件代碼",//
				})
				public String StatementCode;

				@DSREF(den = "Additional Information. Statement Description. Text", uid = "225", cls = "Additional Information")
				public String StatementDescription;

				@DSREF(den = "Additional Information. Statement Type. Code", uid = "369", cls = "Additional Information")
				public String StatementTypeCode;

				@DSREF(den = "Additional Information. Copy. Text", uid = "TW037", cls = "Additional Information")
				public String tw_Copy;

				@DSREF(den = "Additional Information. Estimated Clearance. Date Time", uid = "264", cls = "Additional Information")
				public String tw_EstimatedClearanceDateTime;
			}

			public AssociatedTransportDocument AssociatedTransportDocument = new AssociatedTransportDocument();

			@DSREF(cls = "Associated Transport Document")
			@AAA(msg = {
					//
					"name=N5107,car=0..1,boro=#",//
					"name=N5116,car=0..1,boro=#",//
					"name=N5135,car=0..1,boro=#",//
					"name=N5205,car=0..1,boro=#",//
			})
			public class AssociatedTransportDocument {

				public AssociatedTransportDocument() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Associated Transport Document. Identification. Identifier", uid = "D008", cls = "Associated Transport Document")
				@AAA(msg = {
						//
						"name=N5107,car=1,boro=,chn=併袋號碼",//
						"name=N5116,car=1,boro=,chn=併袋號碼",//
						"name=N5135,car=1,boro=,chn=併袋號碼",//
						"name=N5205,car=1,boro=,chn=併袋號碼",//
				})
				public String ID;

				@DSREF(den = "Associated Transport Document. Type. Code", uid = "D009", cls = "Associated Transport Document")
				public String TypeCode;

			}

			public BorderTransportMeans BorderTransportMeans = new BorderTransportMeans();

			@DSREF(cls = "Border Transport Means")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=#",//
					"name=N5135,car=1,boro=#",//
					"name=N5165,car=1,boro=#",//
					"name=N5202,car=0..1,boro=#",//
					"name=N5205,car=1,boro=#",//
					"name=N5301,car=1,boro=",//
					"name=N5302,car=1,boro=",//
			})
			public class BorderTransportMeans {

				public BorderTransportMeans() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Border Transport Means. Arrival. Date Time", uid = "172", cls = "Border Transport Means")
				@AAA(msg = {
						//
						"name=N5301,car=1,boro=#,chn=進口日期",//
						"name=N5302,car=1,boro=#,chn=進口日期",//
				})
				public String ArrivalDateTime;

				@DSREF(den = "Border Transport Means. Conveyance First Port Of Arrival. Date Time", uid = "267", cls = "Border Transport Means")
				public String ConveyanceFirstPortOfArrivalDateTime;

				@DSREF(den = "Border Transport Means. Departure. Date Time", uid = "156", cls = "Border Transport Means")
				public String DepartureDateTime;

				@DSREF(den = "Border Transport Means. First Arrival Location. Identifier", uid = "085", cls = "Border Transport Means")
				public String FirstArrivalLocationID;

				@DSREF(den = "Border Transport Means. Identification. Identifier", uid = "T006", cls = "Border Transport Means")
				@AAA(msg = {
						//
						"name=N5301,car=1,boro=#,chn=船（機）代碼",//
						"name=N5302,car=1,boro=#,chn=船（機）代碼",//
				})
				public String ID;

				@DSREF(den = "Border Transport Means. Journey. Identifier", uid = "149", cls = "Border Transport Means")
				@AAA(msg = {
						//
						"name=N5135,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
						"name=N5205,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
						"name=N5301,car=1,boro=#,chn=船舶航次（海）/航機班次（空）",//
						"name=N5302,car=1,boro=#,chn=船舶航次（海）/航機班次（空）",//
				})
				public String JourneyID;

				@DSREF(den = "Border Transport Means. Name. Text", uid = "T005", cls = "Border Transport Means")
				@AAA(msg = {
						//
						"name=N5301,car=0..1,boro=,chn=船舶名稱",//
						"name=N5302,car=0..1,boro=,chn=船舶名稱",//
				})
				public String Name;

				@DSREF(den = "Border Transport Means. Original Registration. Text", uid = "TW150", cls = "Border Transport Means")
				@AAA(msg = {
				//
				"name=N5202,car=0..1,boro=,chn=原海關通關號碼",//
				})
				public String tw_OriginalRegistration;

				@DSREF(den = "Border Transport Means. Registration. Text", uid = "TW043", cls = "Consignment")
				public String tw_Registration;

				@DSREF(den = "Border Transport Means. Type. Code", uid = "T010", cls = "Border Transport Means")
				public String TypeCode;

				public Itinerary Itinerary = new Itinerary();

				@DSREF(cls = "Itinerary")
				@AAA(msg = {
						//
						"name=N5101,car=0..99,boro=#",//
						"name=N5202,car=0..99,boro=#",//
				})
				public class Itinerary {

					public Itinerary() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Itinerary. Routing Country. Code", uid = "064", cls = "Itinerary")
					@AAA(msg = {
							//
							"name=N5101,car=1,boro=,chn=過境國家代碼",//
							"name=N5202,car=1,boro=,chn=過境國家代碼",//
					})
					public String RoutingCountryCode;

					@DSREF(den = "Itinerary. Routing Region. Identifer", uid = "393", cls = "Itinerary")
					public String RoutingRegionID;
				}

			}

			public Carrier_Moved Carrier = new Carrier_Moved();

			@DSREF(cls = "Carrier")
			public class Carrier_Moved {

				public Carrier_Moved() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Carrier. Identification. Identifier", uid = "R012", cls = "Carrier")
				public String ID;

				@DSREF(den = "Carrier. Name. Text", uid = "R011", cls = "Carrier")
				public String Name;

				@DSREF(den = "Carrier. Type. Code", uid = "TW061", cls = "Carrier")
				public String tw_TypeCode;

			}

			public Consignee_Moved Consignee = new Consignee_Moved();

			@DSREF(cls = "Consignee")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=",//
					"name=N5102,car=1,boro=",//
					"name=N5107,car=1,boro=",//
					"name=N5108,car=1,boro=",//
					"name=N5109,car=1,boro=",//
					"name=N5110,car=1,boro=",//
					"name=N5111,car=1,boro=",//
					"name=N5116,car=1,boro=",//
					"name=N5117,car=1,boro=",//
					"name=N5135,car=1,boro=",//
					"name=N5151,car=1,boro=",//
					"name=N5158,car=1,boro=",//
					"name=N5162,car=1,boro=",//
					"name=N5165,car=0..1,boro=#",//
					"name=N5166,car=1,boro=",//
					"name=N5167,car=1,boro=",//
					"name=N5168,car=1,boro=",//
					"name=N5201,car=1,boro=",//
					"name=N5202,car=0..1,boro=",//
					"name=N5203,car=1,boro=",//
					"name=N5204,car=1,boro=",//
					"name=N5205,car=1,boro=",//
					"name=N5251,car=1,boro=",//
					"name=N5252,car=1,boro=",//
					"name=N5262,car=1,boro=",//
					"name=N5301,car=1,boro=",//
					"name=N5302,car=1,boro=",//
					"name=N5401,car=1,boro=",//
					"name=N5402,car=1,boro=",//
					"name=N5403,car=1,boro=",//
					"name=N5404,car=1,boro=",//
			})
			public class Consignee_Moved {

				public Consignee_Moved() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Consignee. Identification. Identifier", uid = "R015", cls = "Consignee")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=,chn=收貨人代碼",//
						"name=N5202,car=0..1,boro=,chn=收貨人代碼",//
				})
				public String ID;

				@DSREF(den = "Consignee. Name. Text", uid = "R014", cls = "Consignee")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=,chn=收貨人英文名稱",//
						"name=N5202,car=0..1,boro=,chn=收貨人英文名稱",//
				})
				public String Name;

				@DSREF(den = "Consignee. Chinese Name. Text", uid = "TW004", cls = "Consignee")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=,chn=收貨人中文名稱",//
						"name=N5165,car=1,boro=,chn=收貨人中文名稱",//
						"name=N5202,car=0..1,boro=,chn=收貨人中文名稱",//
				})
				public String tw_ChineseName;

				@DSREF(den = "Consignee. Type. Code", uid = "TW104", cls = "Consignee")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=,chn=身分識別代碼",//
						"name=N5202,car=0..1,boro=,chn=身分識別代碼",//
				})
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=",//
						"name=N5102,car=1,boro=",//
						"name=N5202,car=0..1,boro=",//
				})
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;

					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					@AAA(msg = {
							//
							"name=N5101,car=0..1,boro=,chn=收貨人英文地址",//
							"name=N5202,car=0..1,boro=,chn=收貨人英文地址",//
					})
					public String Line;

					@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
					@AAA(msg = {
							//
							"name=N5101,car=0..1,boro=,chn=收貨人中文地址",//
							"name=N5202,car=0..1,boro=,chn=收貨人中文地址",//
					})
					public String tw_ChineseLine;

					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

			}

			public ConsignmentItem_Borrowed ConsignmentItem = new ConsignmentItem_Borrowed();

			@DSREF(cls = "Consignment Item")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=",//
					"name=N5102,car=0..1,boro=",//
					"name=N5103,car=0..1,boro=",//
					"name=N5108,car=0..1,boro=",//
					"name=N5117,car=0..1,boro=",//
					"name=N5162,car=1,boro=",//
					"name=N5165,car=0..1,boro=#",//
					"name=N5166,car=1..9999,boro=",//
					"name=N5170,car=0..99,boro=",//
					"name=N5201,car=1,boro=",//
					"name=N5202,car=0..1,boro=",//
					"name=N5252,car=1..9999,boro=",//
					"name=N5262,car=1,boro=",//
					"name=N5301,car=1,boro=",//
					"name=N5302,car=1,boro=",//
					"name=NX201_01,car=0..1,boro=#",//
					"name=NX301_DN,car=1,boro=#",//
					"name=NX5105,car=0..1,boro=#",//
					"name=NX601,car=1,boro=#",//
			})
			public class ConsignmentItem_Borrowed {

				public ConsignmentItem_Borrowed() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Consignment Item. Split. Text", uid = "TW045", cls = "Consignment Item")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=,chn=分批註記",//
						"name=N5202,car=0..1,boro=,chn=分批註記",//
				})
				public String tw_Split;

				@DSREF(den = "Consignment Item. Shipping Order Number. Text", uid = "TW078", cls = "Consignment Item")
				@AAA(msg = {
				//
				"name=N5252,car=1,boro=,chn=裝貨單號碼",//
				})
				public String tw_ShippingOrderNumber;

				@DSREF(den = "Consignment Item. Total Gross Mass. Measure", uid = "131", cls = "Consignment Item")
				@AAA(msg = {
				//
				"name=N5252,car=1,boro=*,chn=總毛重",//
				})
				public String tw_TotalGrossMassMeasure;

				@DSREF(den = "Consignment Item. Total Package. Quantity", uid = "146", cls = "Consignment Item")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=*,chn=本批件數",//
						"name=N5202,car=0..1,boro=*,chn=本批件數",//
						"name=N5252,car=1,boro=*,chn=總件數",//
				})
				public String tw_TotalPackageQuantity;

				@DSREF(den = "Consignment Item. Volume Unit. Code", uid = "TW007", cls = "Consignment Item")
				@AAA(msg = {
				//
				"name=N5101,car=0..1,boro=,chn=體積單位",//
				})
				public String tw_VolumeUnitCode;

				@DSREF(den = "Consignment Item. Goods Status. Code", uid = "094", cls = "Consignment Item")
				public String GoodsStatusCode;

				public AdditionalDocument_Moved AdditionalDocument = new AdditionalDocument_Moved();

				@DSREF(cls = "Additional Document")
				@AAA(msg = {
				//
				"name=N5170,car=0..1,boro=",//
				})
				public class AdditionalDocument_Moved {

					public AdditionalDocument_Moved() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Additional Document. Identification. Identifier", uid = "D005", cls = "Additional Document")
					public String ID;

					@DSREF(den = "Response. Issue. Date Time", uid = "D029", cls = "Response")
					public String IssueDateTime;

					@DSREF(den = "Additional Document. Type. Code", uid = "D006", cls = "Additional Document")
					public String TypeCode;

					public TransportContractDocument TransportContractDocument = new TransportContractDocument();

					@DSREF(cls = "Transport Contract Document")
					@AAA(msg = {
					//
					"name=N5170,car=0..2,boro=+",//
					})
					public class TransportContractDocument {

						public TransportContractDocument() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Transport Contract Document. Identification. Identifier", uid = "D023", cls = "Transport Contract Document")
						@AAA(msg = {
						//
						"name=N5170,car=1,boro=,chn=主提單號碼;分提單號碼",//
						})
						public String ID;

						@DSREF(den = "Transport Contract Document. Type. Code", uid = "D024", cls = "Transport Contract Document")
						@AAA(msg = {
						//
						"name=N5170,car=1,boro=,chn=*運輸合約文件類別代碼",//
						})
						public String TypeCode;

					}

				}

				public AdditionalInformation AdditionalInformation = new AdditionalInformation();

				@DSREF(cls = "Additional Information")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=",//
						"name=N5102,car=0..1,boro=",//
						"name=N5162,car=1,boro=",//
						"name=N5202,car=0..1,boro=",//
				})
				public class AdditionalInformation {

					public AdditionalInformation() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Additional Information. Statement. Code", uid = "226", cls = "Additional Information")
					@AAA(msg = {
					//
					"name=N5162,car=1,boro=,chn=短溢卸註記",//
					})
					public String StatementCode;

					@DSREF(den = "Additional Information. Statement Description. Text", uid = "225", cls = "Additional Information")
					@AAA(msg = {
							//
							"name=N5101,car=1,boro=,chn=備註",//
							"name=N5202,car=1,boro=,chn=備註",//
					})
					public String StatementDescription;

				}

				public Commodity Commodity = new Commodity();

				@DSREF(cls = "Commodity")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=",//
						"name=N5102,car=0..1,boro=",//
						"name=N5103,car=0..1,boro=",//
						"name=N5202,car=0..1,boro=",//
						"name=N5301,car=1,boro=",//
						"name=NX301_DN,car=1,boro=#",//
						"name=NX601,car=1,boro=#",//
				})
				public class Commodity {

					public Commodity() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Commodity. Cargo Description. Text", uid = "138", cls = "Commodity")
					@AAA(msg = {
							//
							"name=N5101,car=1,boro=,chn=貨名",//
							"name=N5202,car=1,boro=,chn=貨名",//
							"name=N5301,car=1,boro=,chn=貨名",//
					})
					public String CargoDescription;

					@DSREF(den = "Commodity. Count. Quantity", uid = "315", cls = "Commodity")
					// @N5102(car = "0..1", chn = "異常件數")
					public String CountQuantity;

					@DSREF(den = "Commodity. Criteria Conformance. Code", uid = "305", cls = "Commodity")
					// @N5102(car = "1", chn = "異常狀況代碼")
					public String CriteriaConformanceCode;

					@DSREF(den = "Commodity. Description. Text", uid = "137", cls = "Commodity")
					@AAA(msg = {
					//
					"name=NX301_DN,car=1,boro=,chn=貨物名稱",//
					})
					public String Description;

					@DSREF(den = "Commodity. Name. Text", uid = "258", cls = "Commodity")
					@AAA(msg = {
					//
					"name=NX601,car=1,boro=,chn=商標(牌名)",//
					})
					public String Name;

					@DSREF(den = "Commodity. Goods Group Name. Code", uid = "332", cls = "Commodity")
					@AAA(msg = {
					//
					"name=NX301_DN,car=1,boro=,chn=產品種類",//
					})
					public String GoodsGroupNameCode;

					public Classification Classification = new Classification();

					@DSREF(cls = "Classification")
					@AAA(msg = {
							//
							"name=N5101,car=0..2,boro=",//
							"name=N5102,car=0..2,boro=",//
							"name=N5103,car=0..1,boro=",//
							"name=N5202,car=0..1,boro=",//
					})
					public class Classification {

						public Classification() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Classification. Identification. Identifier", uid = "145", cls = "Classification")
						@AAA(msg = {
								//
								"name=N5101,car=1,boro=,chn=貨品分類號列前六碼;危險貨物代碼",//
								"name=N5103,car=1,boro=,chn=危險貨物代碼",//
								"name=N5202,car=1,boro=,chn=危險貨物代碼",//
						})
						public String ID;

						@DSREF(den = "Classification. Identification Type. Code", uid = "337", cls = "Classification")
						@AAA(msg = {
								//
								"name=N5101,car=1,boro=,chn=*貨品分類號類別代碼",//
								"name=N5202,car=1,boro=,chn=*貨品分類號類別代碼",//
						})
						public String IdentificationTypeCode;
					}

					public CommodityRelatedPackaging CommodityRelatedPackaging = new CommodityRelatedPackaging();

					@DSREF(cls = "Commodity Related Packaging")
					@AAA(msg = {
					//
					"name=NX301_DN,car=1,boro=#",//
					})
					public class CommodityRelatedPackaging {

						public CommodityRelatedPackaging() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Commodity Related Packaging. Marking. Text", uid = "345", cls = "Commodity Related Packaging")
						public String Marking;

						@DSREF(den = "Commodity Related Packaging. Packing Method Description. Text", uid = "343", cls = "Commodity Related Packaging")
						public String PackingMethodDescription;

						@DSREF(den = "Commodity Related Packaging. Material. Code", uid = "TW112", cls = "Commodity Related Packaging")
						@AAA(msg = {
						//
						"name=NX301_DN,car=1,boro=,chn=包裝材料代碼",//
						})
						public String tw_MaterialCode;

						@DSREF(den = "Commodity Related Packaging. Specification. Text", uid = "TW110", cls = "Commodity Related Packaging")
						public String tw_Specification;
					}
				}

				public Consignee_Moved Consignee = new Consignee_Moved();

				@DSREF(cls = "Consignee")
				@AAA(msg = {
						//
						"name=N5301,car=0..1,boro=",//
						"name=N5302,car=0..1,boro=",//
				})
				public class Consignee_Moved {

					public Consignee_Moved() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Consignee. Identification. Identifier", uid = "R015", cls = "Consignee")
					@AAA(msg = {
							//
							"name=N5301,car=0..1,boro=,chn=收貨人代碼",//
							"name=N5302,car=0..1,boro=,chn=收貨人代碼",//
					})
					public String ID;

					@DSREF(den = "Consignee. Name. Text", uid = "R014", cls = "Consignee")
					@AAA(msg = {
							//
							"name=N5301,car=1,boro=,chn=收貨人英文名稱",//
							"name=N5302,car=1,boro=,chn=收貨人英文名稱",//
					})
					public String Name;

					@DSREF(den = "Consignee. Chinese Name. Text", uid = "TW004", cls = "Consignee")
					@AAA(msg = {
							//
							"name=N5301,car=0..1,boro=,chn=收貨人中文名稱",//
							"name=N5302,car=0..1,boro=,chn=收貨人中文名稱",//
					})
					public String tw_ChineseName;

					@DSREF(den = "Consignee. Customs Control. Identifier", uid = "TW003", cls = "Consignee")
					@AAA(msg = {
							//
							"name=N5301,car=0..1,boro=,chn=海關監管編號",//
							"name=N5302,car=0..1,boro=,chn=海關監管編號",//
					})
					public String tw_CustomsControlID;

					@DSREF(den = "Consignee. Type. Code", uid = "TW104", cls = "Consignee")
					@AAA(msg = {
							//
							"name=N5301,car=0..1,boro=,chn=身分識別代碼",//
							"name=N5302,car=0..1,boro=,chn=身分識別代碼",//
					})
					public String tw_TypeCode;

					public Address Address = new Address();

					@DSREF(cls = "Address")
					@AAA(msg = {
							//
							"name=N5301,car=0..1,boro=",//
							"name=N5302,car=0..1,boro=",//
					})
					public class Address {

						public Address() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
						public String CityName;
						@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
						public String CountryCode;
						@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
						public String CountrySubDivisionID;
						@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
						public String CountrySubDivisionName;

						@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
						@AAA(msg = {
								//
								"name=N5301,car=1,boro=,chn=收貨人英文地址",//
								"name=N5302,car=1,boro=,chn=收貨人英文地址",//
						})
						public String Line;

						@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
						@AAA(msg = {
								//
								"name=N5301,car=0..1,boro=,chn=收貨人中文地址",//
								"name=N5302,car=0..1,boro=,chn=收貨人中文地址",//
						})
						public String tw_ChineseLine;

						@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
						public String PostcodeID;
					}

				}

				public GoodsMeasure GoodsMeasure = new GoodsMeasure();

				@DSREF(cls = "Goods Measure")
				@AAA(msg = {
						//
						"name=N5301,car=0..1,boro=",//
						"name=NX301,car=1,boro=",//
						"name=NX301_DN,car=0..1,boro=",//
						"name=NX401,car=1,boro=",//
						"name=NX5105,car=0..1,boro=",//
						"name=NX601,car=1,boro=",//
						"name=NX603,car=1,boro=",//
						"name=NX801,car=0..1,boro=",//
						"name=NX802,car=0..1,boro=",//
				})
				public class GoodsMeasure {

					public GoodsMeasure() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Goods Measure. Gross Mass. Measure", uid = "126", cls = "Goods Measure")
					public String GrossMassMeasure;
					@DSREF(den = "Goods Measure. Net Weight. Measure", uid = "128", cls = "Goods Measure")
					public String NetNetWeightMeasure;

					@DSREF(den = "Goods Measure. Tariff. Quantity", uid = "130", cls = "Goods Measure")
					@AAA(msg = {
					//
					"name=N5301,car=1,boro=,chn=數量",//
					})
					public String TariffQuantity;

					@DSREF(den = "Goods Measure. Tariff Quantity. Amount", uid = "324", cls = "Goods Measure")
					public String TariffQuantityAmount;

					@DSREF(den = "Goods Measure. Unit. Code", uid = "TW026", cls = "Goods Measure")
					@AAA(msg = {
					//
					"name=N5301,car=1,boro=,chn=數量單位",//
					})
					public String tw_UnitCode;
				}

				public GovernmentProcedure GovernmentProcedure = new GovernmentProcedure();

				@DSREF(cls = "Government Procedure")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=",//
						"name=N5102,car=0..1,boro=",//
						"name=N5107,car=1,boro=",//
						"name=N5108,car=1,boro=",//
						"name=N5109,car=1,boro=",//
						"name=N5110,car=1,boro=",//
						"name=N5111,car=1,boro=",//
						"name=N5116,car=1,boro=",//
						"name=N5117,car=0..1,boro=",//
						"name=N5135,car=1,boro=",//
						"name=N5151,car=1,boro=",//
						"name=N5158,car=1,boro=",//
						"name=N5162,car=1,boro=",//
						"name=N5165,car=1,boro=",//
						"name=N5166,car=0..9,boro=",//
						"name=N5167,car=1,boro=",//
						"name=N5168,car=1,boro=",//
						"name=N5201,car=1,boro=",//
						"name=N5202,car=1,boro=",//
						"name=N5203,car=1,boro=",//
						"name=N5204,car=1,boro=",//
						"name=N5205,car=1,boro=",//
						"name=N5251,car=1,boro=",//
						"name=N5252,car=0..1,boro=",//
						"name=N5262,car=1,boro=",//
						"name=N5301,car=1,boro=",//
						"name=N5302,car=1,boro=",//
						"name=N5401,car=1,boro=",//
						"name=N5402,car=1,boro=",//
						"name=N5403,car=1,boro=",//
						"name=N5404,car=1,boro=",//
				})
				public class GovernmentProcedure {

					public GovernmentProcedure() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Government Procedure. Current. Code", uid = "166", cls = "Government Procedure")
					@AAA(msg = {
					//
					"name=N5166,car=1,boro=,chn=處理註記",//
					})
					public String CurrentCode;

					@DSREF(den = "Government Procedure. Description. Text", uid = "353", cls = "Government Procedure")
					public String Description;

					@DSREF(den = "Government Procedure. Dismantle. Text", uid = "TW053", cls = "Government Procedure")
					@AAA(msg = {
					//
					"name=N5102,car=1,boro=,chn=拆櫃進倉註記",//
					})
					public String tw_Dismantle;

					@DSREF(den = "Government Procedure. Partial Release. Text", uid = "TW056", cls = "Government Procedure")
					public String tw_PartialRelease;

					@DSREF(den = "Government Procedure. Landed Note. Code", uid = "TW_095", cls = "Government Procedure")
					public String tw_LandedNoteCode;

					@DSREF(den = "Government Procedure. Logout Note. Code", uid = "TW052", cls = "Government Procedure")
					@AAA(msg = {
					//
					"name=N5252,car=1,boro=,chn=退關註銷未放行報單註記",//
					})
					public String tw_LogoutNoteCode;

					@DSREF(den = "Government Procedure. Transport Status. Code", uid = "TW_054", cls = "Government Procedure")
					public String tw_TransportStatusCode;

					@DSREF(den = "Government Procedure. Transport Type. Code", uid = "TW051", cls = "Government Procedure")
					public String tw_TransportTypeCode;

					@DSREF(den = "Government Procedure. Previous. Code", uid = "161", cls = "Government Procedure")
					public String PreviousCode;

				}

				public Origin Origin = new Origin();

				@DSREF(cls = "Origin")
				@AAA(msg = {
						//
						"name=NX201_01,car=0..1,boro=#",//
						"name=NX301_DN,car=1,boro=#",//
						"name=NX601,car=1,boro=#",//
				})
				public class Origin {

					public Origin() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Origin. Country. Code", uid = "063", cls = "Origin")
					@AAA(msg = {
							//
							"name=NX201_01,car=1,boro=,chn=生產國別代碼",//
							"name=NX301_DN,car=1,boro=,chn=生產國別代碼",//
							"name=NX601,car=1,boro=,chn=生產國別代碼",//
					})
					public String CountryCode;
				}

				public Packaging Packaging = new Packaging();

				@DSREF(cls = "Packaging")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=",//
						"name=N5102,car=0..1,boro=",//
						"name=N5103,car=0..1,boro=",//
						"name=N5107,car=1,boro=",//
						"name=N5108,car=1,boro=",//
						"name=N5109,car=1,boro=",//
						"name=N5110,car=1,boro=",//
						"name=N5111,car=1,boro=",//
						"name=N5116,car=1,boro=",//
						"name=N5117,car=0..1,boro=",//
						"name=N5135,car=1,boro=",//
						"name=N5151,car=1,boro=",//
						"name=N5158,car=1,boro=",//
						"name=N5162,car=1,boro=",//
						"name=N5165,car=1,boro=",//
						"name=N5166,car=1,boro=",//
						"name=N5167,car=1,boro=",//
						"name=N5168,car=1,boro=",//
						"name=N5201,car=1,boro=",//
						"name=N5202,car=0..1,boro=",//
						"name=N5203,car=1,boro=",//
						"name=N5204,car=1,boro=",//
						"name=N5205,car=1,boro=",//
						"name=N5251,car=1,boro=",//
						"name=N5252,car=1,boro=",//
						"name=N5262,car=1,boro=",//
						"name=N5301,car=1,boro=",//
						"name=N5302,car=1,boro=",//
						"name=N5401,car=1,boro=",//
						"name=N5402,car=1,boro=",//
						"name=N5403,car=1,boro=",//
						"name=N5404,car=1,boro=",//
				})
				public class Packaging {

					public Packaging() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Packaging. Marks Numbers. Text", uid = "142", cls = "Packaging")
					@AAA(msg = {
							//
							"name=N5101,car=0..1,boro=,chn=標記",//
							"name=N5202,car=0..1,boro=,chn=標記",//
							"name=N5301,car=0..1,boro=,chn=標記",//
					})
					public String MarksNumbers;

					@DSREF(den = "Packaging. Packaging Material Description. Text", uid = "344", cls = "Packaging")
					@AAA(msg = {
							//
							"name=N5101,car=0..1,boro=#,chn=包裝說明",//
							"name=N5162,car=0..1,boro=#,chn=包裝說明",//
							"name=N5201,car=0..1,boro=#,chn=包裝說明",//
							"name=N5202,car=0..1,boro=#,chn=包裝說明",//
							"name=N5301,car=0..1,boro=#,chn=包裝說明",//
					})
					public String PackagingMaterialDescription;

					@DSREF(den = "Packaging. Combination. Text", uid = "TW011", cls = "Packaging")
					@AAA(msg = {
							//
							"name=N5101,car=0..1,boro=,chn=合成註記",//
							"name=N5102,car=0..1,boro=,chn=合成註記",//
							"name=N5301,car=0..1,boro=,chn=合成註記",//
							"name=N5302,car=0..1,boro=,chn=合成註記",//
					})
					public String tw_Combination;

					@DSREF(den = "Packaging. Quantity. Quantity", uid = "144", cls = "Packaging")
					public String QuantityQuantity;

					@DSREF(den = "Packaging. Size Description. Text", uid = "367", cls = "Packaging")
					public String SizeDescription;

					@DSREF(den = "Packaging. Type. Code", uid = "141", cls = "Packaging")
					@AAA(msg = {
							//
							"name=N5101,car=1,boro=,chn=件數單位",//
							"name=N5102,car=1,boro=,chn=件數單位",//
							"name=N5117,car=1,boro=,chn=件數單位",//
							"name=N5162,car=1,boro=,chn=件數單位",//
							"name=N5201,car=1,boro=,chn=件數單位",//
							"name=N5202,car=1,boro=,chn=件數單位",//
							"name=N5252,car=1,boro=,chn=件數單位",//
							"name=N5301,car=1,boro=,chn=件數單位",//
							"name=N5302,car=1,boro=,chn=件數單位",//
					})
					public String TypeCode;

					@DSREF(den = "Packaging. Volume. Measure", uid = "395", cls = "Packaging")
					public String VolumeMeasure;
				}

				public PreviousDocument PreviousDocument = new PreviousDocument();

				@DSREF(cls = "Previous Document")
				@AAA(msg = {
				//
				"name=N5108,car=0..1,boro=",//
				})
				public class PreviousDocument {

					public PreviousDocument() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Previous Document. Identification. Identifier", uid = "D018", cls = "Previous Document")
					public String ID;

					@DSREF(den = "Previous Document. Issue. Date Time", uid = "D010", cls = "Previous Document")
					public String IssueDateTime;

					@DSREF(den = "Previous Document. Line. Numeric", uid = "171", cls = "Previous Document")
					public String LineNumeric;

					@DSREF(den = "Previous Document. Functional Reference. Identifier", uid = "D026", cls = "Previous Document")
					@AAA(msg = {
					//
					"name=N5108,car=0..1,boro=*,chn=原訊息編號",//
					})
					public String tw_FunctionalReferenceID;

					@DSREF(den = "Previous Document. Reference. Identifier", uid = "TW_106", cls = "Previous Document")
					public String tw_ReferenceID;

					@DSREF(den = "Previous Document. Type. Code", uid = "D019", cls = "Previous Document")
					@AAA(msg = {
					//
					"name=N5108,car=0..1,boro=,chn=原訊息類別",//
					})
					public String TypeCode;

					public Submitter Submitter = new Submitter();

					@DSREF(cls = "Submitter")
					@AAA(msg = {
					//
					"name=N5108,car=0..1,boro=",//
					})
					public class Submitter {

						public Submitter() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Submitter. Identification. Identifier", uid = "R059", cls = "Submitter")
						@AAA(msg = {
						//
						"name=N5108,car=1,boro=,chn=原訊息傳送者代碼",//
						})
						public String ID;

						@DSREF(den = "Submitter. Name. Text", uid = "WCOIDR058", cls = "Submitter")
						public String Name;
					}
				}

				public TransportContractDocument TransportContractDocument = new TransportContractDocument();

				@DSREF(cls = "Transport Contract Document")
				@AAA(msg = {
						//
						"name=N5165,car=0..2,boro=#",//
						"name=N5170,car=0..2,boro=#",//
						"name=N5252,car=1..2,boro=#",//
						"name=N5262,car=0..2,boro=#",//
						"name=N5301,car=0..2,boro=",//
						"name=N5302,car=0..2,boro=",//
				})
				public class TransportContractDocument {

					public TransportContractDocument() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Transport Contract Document. Condition. Code", uid = "091", cls = "Transport Contract Document")
					public String ConditionCode;

					@DSREF(den = "Transport Contract Document. Identification. Identifier", uid = "D023", cls = "Transport Contract Document")
					@AAA(msg = {
							//
							"name=N5165,car=1,boro=,chn=託運單主號;託運單分號",//
							"name=N5170,car=1,boro=,chn=託運單主號;託運單分號",//
							"name=N5252,car=1,boro=,chn=託運單主號;託運單分號",//
							"name=N5262,car=1,boro=,chn=託運單主號;託運單分號",//
							"name=N5301,car=1,boro=,chn=託運單主號;託運單分號",//
							"name=N5302,car=1,boro=,chn=託運單主號;託運單分號",//
					})
					public String ID;

					@DSREF(den = "Transport Contract Document. Issue. Date Time", uid = "D020", cls = "Transport Contract Document")
					public String IssueDateTime;

					@DSREF(den = "Transport Contract Document. Issue Location. Text", uid = "D021", cls = "Transport Contract Document")
					public String IssueLocation;

					@DSREF(den = "Transport Contract Document. Issuing Party. Identifier", uid = "D022", cls = "Transport Contract Document")
					public String IssuingPartyID;

					@DSREF(den = "Transport Contract Document. Type. Code", uid = "D024", cls = "Transport Contract Document")
					@AAA(msg = {
							//
							"name=N5165,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=N5170,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=N5252,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=N5262,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=N5301,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=N5302,car=1,boro=,chn=*運輸合約文件類別代碼",//
					})
					public String TypeCode;

				}

				public TransportEquipment TransportEquipment = new TransportEquipment();

				@DSREF(cls = "Transport Equipment")
				@AAA(msg = {
						//
						"name=N5117,car=0..9999,boro=",//
						"name=N5162,car=0..99,boro=",//
						"name=N5166,car=1,boro=",//
						"name=N5202,car=0..9999,boro=",//
						"name=N5262,car=1..9999,boro=#",//
				})
				public class TransportEquipment {

					public TransportEquipment() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Transport Equipment. Attached. Code", uid = "387", cls = "Transport Equipment")
					public String AttachedCode;

					@DSREF(den = "Transport Equipment. Characteristic. Code", uid = "152", cls = "Transport Equipment")
					@AAA(msg = {
					//
					"name=N5166,car=1,boro=,chn=貨櫃種類",//
					// "name=N5202,car=1,boro=,chn=空櫃種類",//
					})
					public String CharacteristicCode;

					@DSREF(den = "Transport Equipment. Event Status. Code", uid = "351", cls = "Transport Equipment")
					public String EventStatusCode;
					@DSREF(den = "Transport Equipment. Fullness. Code", uid = "154", cls = "Transport Equipment")
					public String FullnessCode;

					@DSREF(den = "Transport Equipment. Identification. Identifier", uid = "159", cls = "Transport Equipment")
					@AAA(msg = {
							//
							"name=N5117,car=1,boro=,chn=實櫃號碼",//
							"name=N5162,car=1,boro=,chn=貨櫃號碼",//
							"name=N5166,car=1,boro=,chn=貨櫃號碼",//
					// "name=N5202,car=1,boro=,chn=空櫃號碼",//
					})
					public String ID;

					@DSREF(den = "Transport Equipment. Used Capacity. Code", uid = "TW030", cls = "Transport Equipment")
					@AAA(msg = {
					//
					"name=N5166,car=1,boro=,chn=貨櫃裝運方式",//
					})
					public String tw_UsedCapacityCode;

					@DSREF(den = "Transport Equipment. Current. Code", uid = "166", cls = "Transport Equipment")
					public String tw_CurrentCode;

					@DSREF(den = "Transport Equipment. Legal Status. Indicator", uid = "157", cls = "Transport Equipment")
					public String LegalStatusIndicator;
					@DSREF(den = "Transport Equipment. License Plate Issuing Country. Code", uid = "279", cls = "Transport Equipment")
					public String LicensePlateIssuingCountryCode;
					@DSREF(den = "Transport Equipment. Registration Country Subdivision. Code", uid = "293", cls = "Transport Equipment")
					public String RegistrationCountrySubdivisionCode;
					@DSREF(den = "Transport Equipment. Name. Text", uid = "358", cls = "Transport Equipment")
					public String Name;

					public tw_Seal tw_Seal = new tw_Seal();

					@DSREF(cls = "Seal")
					@AAA(msg = {
					//
					"name=N5166,car=0..10,boro=",//
					})
					public class tw_Seal {

						public tw_Seal() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Seal. Seal. Identifier", uid = "165", cls = "Seal")
						@AAA(msg = {
						//
						"name=N5166,car=1,boro=*,chn=封條號碼",//
						})
						public String tw_SealID;

					}
				}

				public UCR UCR = new UCR();

				@DSREF(cls = "UCR")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=",//
						"name=N5102,car=1,boro=",//
						"name=N5103,car=0..1,boro=",//
						"name=N5202,car=0..1,boro=",//
				})
				public class UCR {

					public UCR() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "UCR. Identification. Identifier", uid = "016", cls = "UCR")
					@AAA(msg = {
							//
							"name=N5101,car=1,boro=,chn=貨物唯一追蹤號碼",//
							"name=N5202,car=1,boro=,chn=貨物唯一追蹤號碼",//
					})
					public String ID;

					@DSREF(den = "UCR. Trader Assigned Reference. Identifier", uid = "009", cls = "UCR")
					public String TraderAssignedReferenceID;
				}
			}

			public Consignor_moved Consignor = new Consignor_moved();

			@DSREF(cls = "Consignor")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=",//
					"name=N5102,car=0..1,boro=",//
					"name=N5202,car=0..1,boro=",//
			})
			public class Consignor_moved {

				public Consignor_moved() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Consignor. Identification. Identifier", uid = "R021", cls = "Consignor")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=,chn=發貨人代碼",//
						"name=N5202,car=1,boro=,chn=發貨人代碼",//
				})
				public String ID;

				@DSREF(den = "Consignor. Name. Text", uid = "R020", cls = "Consignor")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=,chn=發貨人英文名稱",//
						"name=N5202,car=0..1,boro=,chn=發貨人英文名稱",//
				})
				public String Name;

				@DSREF(den = "Consignor. Chinese Name. Text", uid = "TW009", cls = "Consignor")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=,chn=發貨人中文名稱",//
						"name=N5202,car=0..1,boro=,chn=發貨人中文名稱",//
				})
				public String tw_ChineseName;

				@DSREF(den = "Consignor. Type. Code", uid = "TW104", cls = "Consignor")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=,chn=身分識別代碼",//
						"name=N5202,car=1,boro=,chn=身分識別代碼",//
				})
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=",//
						"name=N5102,car=1,boro=",//
						"name=N5202,car=0..1,boro=",//
				})
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					@AAA(msg = {
							//
							"name=N5101,car=0..1,boro=,chn=發貨人英文地址",//
							"name=N5202,car=0..1,boro=,chn=發貨人英文地址",//
					})
					public String Line;

					@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
					@AAA(msg = {
							//
							"name=N5101,car=0..1,boro=,chn=發貨人中文地址",//
							"name=N5202,car=0..1,boro=,chn=發貨人中文地址",//
					})
					public String tw_ChineseLine;

					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}
			}

			public Control Control = new Control();

			@DSREF(cls = "Control")
			@AAA(msg = {
			//
			"name=N5168,car=1,boro=",//
			})
			public class Control {

				public Control() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Control. Inspection End. Date Time", uid = "356", cls = "Control")
				public String InspectionEndDateTime;

				@DSREF(den = "Control. Inspection Start. Date Time", uid = "355", cls = "Control")
				@AAA(msg = {
				//
				"name=N5168,car=1,boro=,chn=派驗日期與時間",//
				})
				public String InspectionStartDateTime;

				@DSREF(den = "Control. Limit. Date Time", uid = "264", cls = "Control")
				public String LimitDateTime;

				@DSREF(den = "Control. Review Place. Identifier", uid = "289", cls = "Control")
				public String ReviewPlaceID;
			}

			public DepartureTransportMeans DepartureTransportMeans = new DepartureTransportMeans();

			@DSREF(cls = "Departure Transport Means")
			@AAA(msg = {
					//
					"name=N5301,car=0..1,boro=",//
					"name=N5302,car=0..1,boro=",//
			})
			public class DepartureTransportMeans {

				public DepartureTransportMeans() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Departure Transport Means. Identification. Identifier", uid = "T004", cls = "Departure Transport Means")
				@AAA(msg = {
						//
						"name=N5301,car=1,boro=#,chn=出口船（機）代碼",//
						"name=N5302,car=1,boro=#,chn=出口船（機）代碼",//
				})
				public String ID;

				@DSREF(den = "Departure Transport Means. Name. Text", uid = "T003", cls = "Departure Transport Means")
				@AAA(msg = {
						//
						"name=N5301,car=0..1,boro=,chn=出口船舶名稱",//
						"name=N5302,car=0..1,boro=,chn=出口船舶名稱",//
				})
				public String Name;

				@DSREF(den = "Departure Transport Means. Registration Nationality. Code", uid = "T013", cls = "Departure Transport Means")
				public String RegistrationNationalityCode;

				@DSREF(den = "Departure Transport Means. Journey. Identifier", uid = "149", cls = "Departure Transport Means")
				@AAA(msg = {
						//
						"name=N5301,car=1,boro=*,chn=船舶航次（海）/航機班次（空）",//
						"name=N5302,car=1,boro=*,chn=船舶航次（海）/航機班次（空）",//
				})
				public String tw_JourneyID;

				@DSREF(den = "Departure Transport Means. Type. Code", uid = "T009", cls = "Departure Transport Means")
				public String TypeCode;

			}

			public MyCurrencyExchange MyCurrencyExchange = new MyCurrencyExchange();

			@DSREF(cls = "Currency Exchange")
			@AAA(msg = {
			//
			"name=N5101,car=0..1,boro=+",//
			})
			public class MyCurrencyExchange {

				public MyCurrencyExchange() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Currency Exchange. Currency Type. Code", uid = "135", cls = "Currency Exchange")
				@AAA(msg = {
				//
				"name=N5101,car=1,boro=,chn=幣別代碼",//
				})
				public String CurrencyTypeCode;

			}

			public MyCustomsValuation MyCustomsValuation = new MyCustomsValuation();

			@DSREF(cls = "Customs Valuation")
			@AAA(msg = {
			//
			"name=N5101,car=0..1,boro=+",//
			})
			public class MyCustomsValuation {

				public MyCustomsValuation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Customs Valuation. Charges Type. Code", uid = "371", cls = "Customs Valuation")
				@AAA(msg = {
				//
				"name=N5101,car=0..1,boro=,chn=裝卸計費條件",//
				})
				public String ChargesTypeCode;

				@DSREF(den = "Customs Valuation. Exit To Entry Charge. Amount", uid = "121", cls = "Customs Valuation")
				@AAA(msg = {
				//
				"name=N5101,car=0..1,boro=,chn=保險費",//
				})
				public String ExitToEntryChargeAmount;

				@DSREF(den = "Customs Valuation. Freight Charge. Amount", uid = "117", cls = "Customs Valuation")
				@AAA(msg = {
				//
				"name=N5101,car=1,boro=,chn=運費",//
				})
				public String FreightChargeAmount;

				@DSREF(den = "Customs Valuation. Other Charge Deduction. Amount", uid = "D023", cls = "Transport Contract Document")
				public String OtherChargeDeductionAmount;

			}

			public MyExitOffice MyExitOffice = new MyExitOffice();

			@DSREF(cls = "Exit Office")
			@AAA(msg = {
			//
			"name=N5101,car=0..1,boro=+",//
			})
			public class MyExitOffice {

				public MyExitOffice() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Exit Office. Identification. Identifier", uid = "G005", cls = "Exit Office")
				@AAA(msg = {
				//
				"name=N5101,car=1,boro=,chn=離境海關辦公室代碼",//
				})
				public String ID;

			}

			public Freight Freight = new Freight();

			@DSREF(cls = "Freight")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=",//
					"name=N5102,car=0..1,boro=",//
					"name=N5202,car=0..1,boro=",//
			})
			public class Freight {

				public Freight() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Freight. Payment Method. Code", uid = "098", cls = "Freight")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=,chn=運費付費方式代碼",//
						"name=N5202,car=1,boro=,chn=運費付費方式代碼",//
				})
				public String PaymentMethodCode;

				@DSREF(den = "Freight. Rate. Amount", uid = "310", cls = "Freight")
				public String RateAmount;
				@DSREF(den = "Freight. Rate. Quantity", uid = "308", cls = "Freight")
				public String RateQuantity;
				@DSREF(den = "Freight. Rate Type. Code", uid = "309", cls = "Freight")
				public String RateTypeCode;
			}

			public GoodsConsignedPlace GoodsConsignedPlace = new GoodsConsignedPlace();

			@DSREF(cls = "Goods Consigned Place")
			@AAA(msg = {
					//
					"name=N5151,car=1,boro=#",//
					"name=NX201_01,car=0..1,boro=#",//
					"name=NX801,car=0..1,boro=#",//
			})
			public class GoodsConsignedPlace {

				public GoodsConsignedPlace() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Goods Consigned Place. Identification. Identifier", uid = "L024", cls = "Goods Consigned Place")
				@AAA(msg = {
				//
				"name=N5151,car=1,boro=,chn=到港前一港",//
				})
				public String ID;

				@DSREF(den = "Goods Consigned Place. Name. Text", uid = "L023", cls = "Goods Consigned Place")
				public String Name;
			}

			public GoodsLocation GoodsLocation = new GoodsLocation();

			@DSREF(cls = "Goods Location")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=",//
					"name=N5102,car=1,boro=",//
					"name=N5107,car=1,boro=",//
					"name=N5108,car=1,boro=",//
					"name=N5109,car=1,boro=",//
					"name=N5110,car=1,boro=",//
					"name=N5111,car=1,boro=",//
					"name=N5116,car=1,boro=",//
					"name=N5117,car=1,boro=",//
					"name=N5135,car=1,boro=#",//
					"name=N5151,car=1,boro=",//
					"name=N5158,car=1,boro=",//
					"name=N5162,car=1,boro=",//
					"name=N5165,car=0..1,boro=#",//
					"name=N5166,car=1,boro=",//
					"name=N5167,car=1,boro=",//
					"name=N5168,car=1,boro=",//
					"name=N5201,car=1,boro=",//
					"name=N5202,car=0..1,boro=",//
					"name=N5203,car=1,boro=+",//
					"name=N5204,car=1,boro=",//
					"name=N5205,car=1,boro=#",//
					"name=N5251,car=1,boro=",//
					"name=N5252,car=1,boro=",//
					"name=N5262,car=1,boro=",//
					"name=N5301,car=0..1,boro=",//
					"name=N5302,car=1,boro=",//
					"name=N5401,car=1,boro=",//
					"name=N5402,car=1,boro=",//
					"name=N5403,car=1,boro=",//
					"name=N5404,car=1,boro=",//
			})
			public class GoodsLocation {

				public GoodsLocation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Goods Location. Identification. Identifier", uid = "L017", cls = "Goods Location")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=,chn=卸存地點代碼",//
						"name=N5102,car=1,boro=,chn=卸存地點代碼",//
						"name=N5135,car=1,boro=,chn=卸存地點代碼",//
						"name=N5158,car=1,boro=,chn=卸存地點代碼",//
						"name=N5162,car=1,boro=,chn=卸存地點代碼",//
						"name=N5165,car=1,boro=,chn=貨櫃儲區",//
						"name=N5168,car=1,boro=,chn=卸存地點代碼",//
						"name=N5201,car=1,boro=,chn=卸存地點代碼",//
						"name=N5202,car=1,boro=,chn=卸存地點代碼",//
						"name=N5205,car=1,boro=,chn=卸存地點代碼",//
				})
				public String ID;

				@DSREF(den = "Goods Location. Name. Text", uid = "L016", cls = "Goods Location")
				public String Name;
			}

			public GovernmentAgencyGoodsItem GovernmentAgencyGoodsItem = new GovernmentAgencyGoodsItem();

			@DSREF(cls = "Government Agency Goods Item")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=#",//
					"name=NX601,car=1,boro=#",//
			})
			public class GovernmentAgencyGoodsItem {

				public GovernmentAgencyGoodsItem() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				public GoodsLocation_Added GoodsLocation_Added = new GoodsLocation_Added();

				@DSREF(cls = "Goods Location")
				@AAA(msg = {
				//
				"name=N5101,car=0..1,boro=#",//
				})
				public class GoodsLocation_Added {

					public GoodsLocation_Added() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Goods Location. Identification. Identifier", uid = "L017", cls = "Goods Location")
					@AAA(msg = {
					//
					// "name=N5101,car=0..1,boro=,chn=空櫃卸存地點代碼",//
					})
					public String ID;

					@DSREF(den = "Goods Location. Subtotal Empty Container. Quantity", uid = "TW046", cls = "Goods Location")
					@AAA(msg = {
					//
					// "name=N5101,car=0..1,boro=,chn=空櫃小計",//
					})
					public String tw_SubtotalEmptyContainerQuantity;

					public TransportEquipment_Added TransportEquipment_Added = new TransportEquipment_Added();

					@DSREF(cls = "Transport Equipment")
					@AAA(msg = {
					//
					"name=N5101,car=0..9999,boro=+",//
					})
					public class TransportEquipment_Added {

						public TransportEquipment_Added() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Transport Equipment. Characteristic. Code", uid = "152", cls = "Transport Equipment")
						@AAA(msg = {
						//
						// "name=N5101,car=1,boro=,chn=空櫃種類",//
						})
						public String CharacteristicCode;

						@DSREF(den = "Transport Equipment. Identification. Identifier", uid = "159", cls = "Transport Equipment")
						@AAA(msg = {
						//
						// "name=N5101,car=0..1,boro=,chn=空櫃號碼",//
						})
						public String ID;

					}

				}

				public Manufacturer Manufacturer = new Manufacturer();

				@DSREF(cls = "Manufacturer")
				@AAA(msg = {
				//
				"name=NX601,car=1,boro=#",//
				})
				public class Manufacturer {

					public Manufacturer() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Manufacturer. Identification. Identifier", uid = "R043", cls = "Manufacturer")
					@AAA(msg = {
					//
					"name=NX601,car=0..1,boro=,chn=國外製造廠代碼",//
					})
					public String ID;

					@DSREF(den = "Manufacturer. Name. Text", uid = "R042", cls = "Manufacturer")
					@AAA(msg = {
					//
					"name=NX601,car=1,boro=,chn=國外製造廠名稱",//
					})
					public String Name;

					@DSREF(den = "Manufacturer. State. Identifier", uid = "TW_089", cls = "Manufacturer")
					public String tw_StateID;

					@DSREF(den = "Manufacturer. State Name. Text", uid = "TW093", cls = "Manufacturer")
					public String tw_StateName;

					@DSREF(den = "Manufacturer. Type. Code", uid = "TW104", cls = "Manufacturer")
					public String tw_TypeCode;

					public Address Address = new Address();

					@DSREF(cls = "Address")
					@AAA(msg = {
					//
					"name=NX601,car=0..1,boro=#",//
					})
					public class Address {

						public Address() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
						public String CityName;
						@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
						public String CountryCode;

						@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
						@AAA(msg = {
						//
						"name=NX601,car=0..1,boro=,chn=國外製造廠州別代碼",//
						})
						public String CountrySubDivisionID;

						@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
						@AAA(msg = {
						//
						"name=NX601,car=0..1,boro=,chn=國外製造廠州別名稱",//
						})
						public String CountrySubDivisionName;

						@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
						@AAA(msg = {
						//
						"name=NX601,car=0..1,boro=,chn=國外製造廠地址",//
						})
						public String Line;

						@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
						public String PostcodeID;
					}

					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}

					public Contact Contact = new Contact();

					@DSREF(cls = "Contact")
					public class Contact {

						public Contact() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
						public String Name;
						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}
					}
				}

			}

			public GovernmentProcedure GovernmentProcedure = new GovernmentProcedure();

			@DSREF(cls = "Government Procedure")
			@AAA(msg = {
					//
					"name=N5170,car=1,boro=",//
					"name=N5202,car=0..1,boro=",//
					"name=N5252,car=0..1,boro=",//
					"name=N5302,car=0..1,boro=",//
			})
			public class GovernmentProcedure {

				public GovernmentProcedure() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Government Procedure. Current. Code", uid = "166", cls = "Government Procedure")
				public String CurrentCode;

				@DSREF(den = "Government Procedure. Logout Note. Code", uid = "TW052", cls = "Government Procedure")
				@AAA(msg = {
				//
				"name=N5202,car=1,boro=,chn=退關註銷未放行報單註記",//
				})
				public String tw_LogoutNoteCode;

				@DSREF(den = "Government Procedure. Transport Type. Code", uid = "TW051", cls = "Government Procedure")
				@AAA(msg = {
				//
				"name=N5170,car=1,boro=,chn=進出口別代碼",//
				})
				public String tw_TransportTypeCode;
			}

			public LandingLocation LandingLocation = new LandingLocation();

			@DSREF(cls = "Landing Location")
			@AAA(msg = {
			//
			"name=N5101,car=0..1,boro=+",//
			})
			public class LandingLocation {

				public LandingLocation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Landing Location. Identification. Identifier", uid = "L075", cls = "Landing Location")
				@AAA(msg = {
				//
				"name=N5101,car=1,boro=,chn=停泊碼頭（含浮筒）代碼",//
				})
				public String ID;

				@DSREF(den = "Landing Location. Name. Text", uid = "L074", cls = "Landing Location")
				public String Name;
			}

			public LoadingLocation LoadingLocation = new LoadingLocation();

			@DSREF(cls = "Loading Location")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=",//
					"name=N5102,car=0..1,boro=",//
					"name=N5103,car=1,boro=",//
					"name=N5107,car=1,boro=",//
					"name=N5108,car=1,boro=",//
					"name=N5109,car=1,boro=",//
					"name=N5110,car=1,boro=",//
					"name=N5111,car=1,boro=",//
					"name=N5116,car=1,boro=",//
					"name=N5117,car=1,boro=",//
					"name=N5135,car=1,boro=",//
					"name=N5151,car=1,boro=",//
					"name=N5158,car=1,boro=",//
					"name=N5162,car=1,boro=",//
					"name=N5165,car=0..1,boro=#",//
					"name=N5166,car=1,boro=",//
					"name=N5167,car=1,boro=",//
					"name=N5168,car=1,boro=",//
					"name=N5201,car=1,boro=",//
					"name=N5202,car=0..1,boro=",//
					"name=N5203,car=1,boro=",//
					"name=N5204,car=1,boro=",//
					"name=N5205,car=1,boro=",//
					"name=N5251,car=1,boro=",//
					"name=N5252,car=1,boro=",//
					"name=N5262,car=1,boro=",//
					"name=N5301,car=1,boro=",//
					"name=N5302,car=1,boro=",//
					"name=N5401,car=1,boro=",//
					"name=N5402,car=1,boro=",//
					"name=N5403,car=1,boro=",//
					"name=N5404,car=1,boro=",//
			})
			public class LoadingLocation {

				public LoadingLocation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Loading Location. Departure. Date Time", uid = "169", cls = "Loading Location")
				public String DepartureDateTime;

				@DSREF(den = "Loading Location. Identification. Identifier", uid = "L010", cls = "Loading Location")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=,chn=裝貨港代碼",//
						"name=N5103,car=1,boro=,chn=裝貨港代碼",//
						"name=N5202,car=1,boro=,chn=裝貨港代碼",//
						"name=N5262,car=1,boro=,chn=起運地點代碼",//
						"name=N5301,car=1,boro=#,chn=裝貨港代碼",//
						"name=N5302,car=1,boro=#,chn=裝貨港代碼",//
				})
				public String ID;

				@DSREF(den = "Loading Location. Loading. Date Time", uid = "031", cls = "Loading Location")
				// @N5262(car = "1", chn = "裝船日期與時間")
				public String LoadingDateTime;

				@DSREF(den = "Loading Location. Name. Text", uid = "L009", cls = "Loading Location")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=,chn=裝貨港",//
						"name=N5202,car=0..1,boro=#,chn=裝貨港",//
				})
				public String Name;
			}

			public NotifyParty NotifyParty = new NotifyParty();

			@DSREF(cls = "Notify Party")
			@AAA(msg = {
			//
			"name=N5101,car=0..3,boro=",//
			})
			public class NotifyParty {

				public NotifyParty() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Notify Party. Identification. Identifier", uid = "R046", cls = "Notify Party")
				@AAA(msg = {
				//
				"name=N5101,car=0..1,boro=,chn=被通知人代碼",//
				})
				public String ID;

				@DSREF(den = "Notify Party. Name. Text", uid = "R045", cls = "Notify Party")
				@AAA(msg = {
				//
				"name=N5101,car=1,boro=,chn=被通知人英文名稱",//
				})
				public String Name;

				@DSREF(den = "Notify Party. Chinese Name. Text", uid = "TW005", cls = "Notify Party")
				@AAA(msg = {
				//
				"name=N5101,car=0..1,boro=,chn=被通知人中文名稱",//
				})
				public String tw_ChineseName;

				@DSREF(den = "Notify Party. Type. Code", uid = "TW104", cls = "Notify Party")
				@AAA(msg = {
				//
				"name=N5101,car=0..1,boro=,chn=身分識別代碼",//
				})
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				@AAA(msg = {
				//
				"name=N5101,car=0..1,boro=",//
				})
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=,chn=被通知人英文地址",//
					})
					public String Line;

					@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
					@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=,chn=被通知人中文地址",//
					})
					public String tw_ChineseLine;

				}
			}

			public Packaging Packaging = new Packaging();

			@DSREF(cls = "Packaging")
			@AAA(msg = {
					//
					"name=N5117,car=0..1,boro=",//
					"name=N5252,car=1,boro=#",//
			})
			public class Packaging {

				public Packaging() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Packaging. Type. Code", uid = "141", cls = "Packaging")
				public String TypeCode;

				@DSREF(den = "Packaging. Volume. Measure", uid = "395", cls = "Packaging")
				public String VolumeMeasure;
			}

			public TranshipmentLocation TranshipmentLocation = new TranshipmentLocation();

			@DSREF(cls = "Transhipment Location")
			public class TranshipmentLocation {

				public TranshipmentLocation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Transhipment Location. Identification. Identifier", uid = "L015", cls = "Transhipment Location")
				public String ID;

				@DSREF(den = "Transhipment Location. Name. Text", uid = "L014", cls = "Transhipment Location")
				public String Name;
			}

			public TransitDeparture TransitDeparture = new TransitDeparture();

			@DSREF(den = "", uid = "", cls = "Transit Departure")
			public class TransitDeparture {

				public TransitDeparture() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Transit Departure. Departure. Date Time", uid = "156", cls = "Transit Departure")
				public String DepartureDateTime;

				@DSREF(den = "Transit Departure. Identification. Identifier", uid = "L087", cls = "Transit Departure")
				public String ID;
			}

			public TransitDestination TransitDestination = new TransitDestination();

			@DSREF(cls = "Transit Destination")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=",//
					"name=N5103,car=0..1,boro=",//
					"name=N5158,car=0..1,boro=",//
					"name=N5301,car=0..1,boro=",//
					"name=N5302,car=1,boro=",//
			})
			public class TransitDestination {

				public TransitDestination() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Transit Destination. Identification. Identifier", uid = "L008", cls = "Transit Destination")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=,chn=轉運/轉口地點代碼",//
						"name=N5158,car=1,boro=,chn=轉運/轉口地點代碼",//
				})
				public String ID;

				@DSREF(den = "Transit Destination. Name. Text", uid = "WCOIDL007", cls = "Transit Destination")
				public String Name;
			}

			public TransitTransportMeans TransitTransportMeans = new TransitTransportMeans();

			@DSREF(cls = "Transit Transport Means")
			public class TransitTransportMeans {

				public TransitTransportMeans() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Transit Transport Means. Identification. Identifier", uid = "WCOIDT007", cls = "Transit Transport Means")
				public String ID;

				@DSREF(den = "Transit Transport Means. Registration Nationality. Identifier", uid = "WCOIDT015", cls = "Transit Transport Means")
				public String RegistrationNationalityID;
				@DSREF(den = "Transit Transport Means. Type. Code", uid = "WCOIDT011", cls = "Transit Transport Means")
				public String TypeCode;
			}

			public TransportContractDocument TransportContractDocument = new TransportContractDocument();

			@DSREF(cls = "Transport Contract Document")
			@AAA(msg = {
					//
					"name=N5101,car=0..2,boro=",//
					"name=N5102,car=1..2,boro=",//
					"name=N5107,car=1,boro=",//
					"name=N5108,car=0..4,boro=",//
					"name=N5109,car=1,boro=",//
					"name=N5110,car=1,boro=",//
					"name=N5111,car=1,boro=",//
					"name=N5116,car=1,boro=",//
					"name=N5117,car=1..2,boro=",//
					"name=N5135,car=1,boro=#",//
					"name=N5151,car=1,boro=",//
					"name=N5158,car=1,boro=",//
					"name=N5162,car=1..2,boro=",//
					"name=N5165,car=0..3,boro=#",//
					"name=N5166,car=1..2,boro=",//
					"name=N5167,car=1,boro=",//
					"name=N5168,car=1..4,boro=",//
					"name=N5201,car=1..2,boro=",//
					"name=N5202,car=0..2,boro=",//
					"name=N5203,car=1,boro=",//
					"name=N5204,car=1,boro=",//
					"name=N5205,car=1,boro=#",//
					"name=N5251,car=1,boro=",//
					"name=N5252,car=2..2,boro=",//
					"name=N5262,car=0..2,boro=",//
					"name=N5301,car=1..2,boro=",//
					"name=N5302,car=1..2,boro=",//
					"name=N5401,car=1,boro=",//
					"name=N5402,car=1,boro=",//
					"name=N5403,car=1,boro=",//
					"name=N5404,car=1,boro=",//
			})
			public class TransportContractDocument {

				public TransportContractDocument() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Transport Contract Document. Condition. Code", uid = "091", cls = "Transport Contract Document")
				public String ConditionCode;

				@DSREF(den = "Transport Contract Document. Identification. Identifier", uid = "D023", cls = "Transport Contract Document")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=,chn=主提單號碼;分提單號碼",//
						"name=N5102,car=1,boro=,chn=主提單號碼;分提單號碼",//
						"name=N5108,car=1,boro=,chn=主提單號碼;分提單號碼;託運單主號;託運單分號",//
						"name=N5117,car=1,boro=,chn=主提單號碼;分提單號碼",//
						"name=N5135,car=1,boro=,chn=主提單號碼",//
						"name=N5162,car=1,boro=,chn=主提單號碼;分提單號碼",//
						"name=N5165,car=1,boro=,chn=主提單號碼;分提單號碼;運送單號碼",//
						"name=N5166,car=1,boro=,chn=主提單號碼;分提單號碼",//
						"name=N5168,car=1,boro=,chn=主提單號碼;分提單號碼;託運單主號;託運單分號",//
						"name=N5201,car=1,boro=,chn=託運單主號;託運單分號",//
						"name=N5202,car=1,boro=,chn=託運單主號;託運單分號",//
						"name=N5205,car=1,boro=,chn=託運單主號",//
						"name=N5262,car=1,boro=,chn=主提單號碼;分提單號碼",//
						"name=N5301,car=1,boro=,chn=主提單號碼;分提單號碼",//
						"name=N5302,car=1,boro=,chn=主提單號碼;分提單號碼",//
				})
				public String ID;

				@DSREF(den = "Transport Contract Document. Issue. Date Time", uid = "D020", cls = "Transport Contract Document")
				public String IssueDateTime;

				@DSREF(den = "Transport Contract Document. Issue Location. Text", uid = "D021", cls = "Transport Contract Document")
				public String IssueLocation;

				@DSREF(den = "Transport Contract Document. Issuing Party. Identifier", uid = "D022", cls = "Transport Contract Document")
				public String IssuingPartyID;

				@DSREF(den = "Transport Contract Document. Type. Code", uid = "D024", cls = "Transport Contract Document")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=,chn=*運輸合約文件類別代碼",//
						"name=N5102,car=1,boro=,chn=*運輸合約文件類別代碼",//
						"name=N5108,car=1,boro=,chn=*運輸合約文件類別代碼",//
						"name=N5117,car=1,boro=,chn=*運輸合約文件類別代碼",//
						"name=N5162,car=1,boro=,chn=*運輸合約文件類別代碼",//
						"name=N5165,car=1,boro=,chn=*運輸合約文件類別代碼",//
						"name=N5166,car=1,boro=,chn=*運輸合約文件類別代碼",//
						"name=N5168,car=1,boro=,chn=*運輸合約文件類別代碼",//
						"name=N5201,car=1,boro=,chn=*運輸合約文件類別代碼",//
						"name=N5202,car=1,boro=,chn=*運輸合約文件類別代碼",//
						"name=N5262,car=1,boro=,chn=*運輸合約文件類別代碼",//
						"name=N5301,car=1,boro=,chn=*運輸合約文件類別代碼",//
						"name=N5302,car=1,boro=,chn=*運輸合約文件類別代碼",//
				})
				public String TypeCode;

				public Consolidator Consolidator = new Consolidator();

				@DSREF(cls = "Consolidator")
				@AAA(msg = {
						//
						"name=N5201,car=0..1,boro=",//
						"name=N5202,car=0..1,boro=",//
				})
				public class Consolidator {

					public Consolidator() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Consolidator. Identification. Identifier", uid = "R019", cls = "Consolidator")
					@AAA(msg = {
							//
							"name=N5201,car=1,boro=,chn=出口承攬運送業者代碼",//
							"name=N5202,car=1,boro=,chn=出口承攬運送業者代碼",//
					})
					public String ID;

					@DSREF(den = "Consolidator. Name. Text", uid = "R018", cls = "Consolidator")
					public String Name;
				}

				public Deconsolidator Deconsolidator = new Deconsolidator();

				@DSREF(cls = "Deconsolidator")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=",//
						"name=N5301,car=0..1,boro=#",//
						"name=N5302,car=0..1,boro=#",//
				})
				public class Deconsolidator {

					public Deconsolidator() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Deconsolidator. Identification. Identifier", uid = "R023", cls = "Deconsolidator")
					@AAA(msg = {
							//
							"name=N5101,car=1,boro=,chn=承攬運送業者代碼",//
							"name=N5301,car=1,boro=,chn=承攬運送業者代碼",//
							"name=N5302,car=1,boro=,chn=承攬運送業者代碼",//
					})
					public String ID;

					@DSREF(den = "Deconsolidator. Name. Text", uid = "R022", cls = "Deconsolidator")
					public String Name;
				}
			}

			public TransportEquipment TransportEquipment = new TransportEquipment();

			@DSREF(cls = "Transport Equipment")
			@AAA(msg = {
					//
					"name=N5101,car=0..9999,boro=",//
					"name=N5102,car=1,boro=",//
					"name=N5103,car=1,boro=",//
					"name=N5107,car=1,boro=",//
					"name=N5108,car=0..9999,boro=",//
					"name=N5109,car=1,boro=",//
					"name=N5110,car=1,boro=",//
					"name=N5111,car=1,boro=",//
					"name=N5116,car=1,boro=",//
					"name=N5117,car=0..1,boro=",//
					"name=N5135,car=1,boro=",//
					"name=N5151,car=1,boro=",//
					"name=N5158,car=1,boro=",//
					"name=N5162,car=0..1,boro=",//
					"name=N5165,car=1,boro=",//
					"name=N5166,car=0..1,boro=",//
					"name=N5167,car=1,boro=",//
					"name=N5168,car=1,boro=",//
					"name=N5170,car=1,boro=",//
					"name=N5201,car=0..9999,boro=",//
					"name=N5202,car=0..9999,boro=",//
					"name=N5203,car=1,boro=",//
					"name=N5204,car=1,boro=",//
					"name=N5205,car=1,boro=",//
					"name=N5251,car=1,boro=",//
					"name=N5252,car=1,boro=",//
					"name=N5262,car=1..9999,boro=",//
					"name=N5301,car=0..9999,boro=",//
					"name=N5302,car=0..9999,boro=",//
					"name=N5401,car=1,boro=",//
					"name=N5402,car=1,boro=",//
					"name=N5403,car=1,boro=",//
					"name=N5404,car=1,boro=",//
			})
			public class TransportEquipment {

				public TransportEquipment() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Transport Equipment. Attached. Code", uid = "387", cls = "Transport Equipment")
				public String AttachedCode;

				@DSREF(den = "Transport Equipment. Characteristic. Code", uid = "152", cls = "Transport Equipment")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=,chn=實櫃種類",//
						"name=N5201,car=1,boro=,chn=貨櫃種類",//
						"name=N5202,car=0..1,boro=,chn=實櫃種類",//
						"name=N5262,car=1,boro=,chn=貨櫃種類",//
						"name=N5301,car=1,boro=,chn=貨櫃種類",//
				})
				public String CharacteristicCode;

				@DSREF(den = "Transport Equipment. Event Status. Code", uid = "351", cls = "Transport Equipment")
				// @N5168(car = "1", chn = "無法吊櫃原因代碼")
				public String EventStatusCode;

				@DSREF(den = "Transport Equipment. Fullness. Code", uid = "154", cls = "Transport Equipment")
				public String FullnessCode;

				@DSREF(den = "Transport Equipment. Identification. Identifier", uid = "159", cls = "Transport Equipment")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=,chn=實櫃號碼",//
						"name=N5103,car=1,boro=,chn=貨櫃號碼",//
						"name=N5108,car=1,boro=,chn=實櫃號碼",//
						"name=N5170,car=1,boro=,chn=貨櫃號碼",//
						"name=N5201,car=1,boro=,chn=貨櫃號碼",//
						"name=N5202,car=1,boro=,chn=實櫃號碼",//
						"name=N5262,car=1,boro=,chn=貨櫃號碼",//
						"name=N5301,car=1,boro=,chn=貨櫃號碼",//
						"name=N5302,car=1,boro=,chn=貨櫃號碼",//
				})
				public String ID;

				@DSREF(den = "Transport Equipment. Name. Text", uid = "358", cls = "Transport Equipment")
				public String Name;
				@DSREF(den = "Transport Equipment. Legal Status. Indicator", uid = "157", cls = "Transport Equipment")
				public String LegalStatusIndicator;
				@DSREF(den = "Transport Equipment. License Plate Issuing Country. Code", uid = "279", cls = "Transport Equipment")
				public String LicensePlateIssuingCountryCode;
				@DSREF(den = "Transport Equipment. Registration Country Subdivision. Code", uid = "293", cls = "Transport Equipment")
				public String RegistrationCountrySubdivisionCode;

				@DSREF(den = "Transport Equipment. Current. Code", uid = "166", cls = "Transport Equipment")
				@AAA(msg = {
						//
						"name=N5170,car=1,boro=*,chn=處理註記",//
						"name=N5302,car=0..1,boro=*,chn=處理註記",//
				})
				public String tw_CurrentCode;

				@DSREF(den = "Transport Equipment. Empty Container. Quantity", uid = "TW105", cls = "MyTransportEquipment")
				public String tw_EmptyContainerQuantity;

				@DSREF(den = "Transport Equipment. Full Container. Quantity", uid = "TW047", cls = "Transport Equipment")
				@AAA(msg = {
				//
				"name=N5117,car=1,boro=,chn=實櫃總數",//
				})
				public String tw_FullContainerQuantity;

				@DSREF(den = "Transport Equipment. Goods Loading Type. Code", uid = "TW048", cls = "Transport Equipment")
				@AAA(msg = {
				//
				"name=N5162,car=1,boro=,chn=貨櫃（物）裝貨型態",//
				})
				public String tw_GoodsLoadingTypeCode;

				@DSREF(den = "Transport Equipment. Storage Location. Text", uid = "TW065", cls = "Transport Equipment")
				@AAA(msg = {
				//
				"name=N5103,car=1,boro=,chn=貨櫃（物）存放位置",//
				})
				public String tw_StorageLocation;

				@DSREF(den = "Transport Equipment. Used Capacity. Code", uid = "TW030", cls = "Transport Equipment")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=,chn=貨櫃裝運方式",//
						"name=N5103,car=1,boro=,chn=貨櫃裝運方式",//
						"name=N5201,car=0..1,boro=,chn=貨櫃裝運方式",//
						"name=N5202,car=0..1,boro=,chn=貨櫃裝運方式",//
						"name=N5262,car=1,boro=,chn=貨櫃裝運方式",//
						"name=N5301,car=1,boro=,chn=貨櫃裝運方式",//
				})
				public String tw_UsedCapacityCode;

				public tw_Seal tw_Seal = new tw_Seal();

				@DSREF(cls = "Seal")
				@AAA(msg = {
						//
						"name=N5101,car=0..10,boro=",//
						"name=N5202,car=0..10,boro=",//
						"name=N5262,car=0..10,boro=",//
				})
				public class tw_Seal {

					public tw_Seal() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Seal. Seal. Identifier", uid = "165", cls = "Seal")
					@AAA(msg = {
							//
							"name=N5101,car=1,boro=*,chn=封條號碼",//
							"name=N5202,car=1,boro=*,chn=封條號碼",//
							"name=N5262,car=1,boro=*,chn=封條號碼",//
					})
					public String tw_SealID;

				}
			}

			public tw_AdditionalDeclaration tw_AdditionalDeclaration = new tw_AdditionalDeclaration();

			@DSREF(cls = "Additional Declaration")
			@AAA(msg = {
			//
			"name=N5117,car=1,boro=",//
			})
			public class tw_AdditionalDeclaration {

				public tw_AdditionalDeclaration() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Additional Declaration. Identification. Identifier", uid = "D014", cls = "Additional Declaration")
				@AAA(msg = {
				//
				"name=N5117,car=1,boro=*,chn=報單號碼",//
				})
				public String tw_ID;

			}

			public tw_SpecialPermit tw_SpecialPermit = new tw_SpecialPermit();

			@DSREF(cls = "Special Permit")
			@AAA(msg = {
			//
			"name=N5158,car=0..1,boro=",//
			})
			public class tw_SpecialPermit {

				public tw_SpecialPermit() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Special Permit. Identification. Identifier", uid = "D005", cls = "Special Permit")
				@AAA(msg = {
				//
				"name=N5158,car=1,boro=*,chn=特別准單號碼",//
				})
				public String tw_ID;

				@DSREF(den = "Special Permit. Statement Type. Code", uid = "369", cls = "Special Permit")
				@AAA(msg = {
				//
				"name=N5158,car=0..1,boro=*,chn=特別准單核發原因代碼",//
				})
				public String tw_StatementTypeCode;
			}

			public UnloadingLocation UnloadingLocation = new UnloadingLocation();

			@DSREF(cls = "Unloading Location")
			@AAA(msg = {
					//
					"name=N5103,car=1,boro=",//
					"name=N5108,car=0..1,boro=",//
					"name=N5151,car=1,boro=#",//
					"name=N5165,car=0..1,boro=#",//
					"name=N5201,car=0..1,boro=",//
					"name=N5202,car=0..1,boro=",//
					"name=N5301,car=0..1,boro=#",//
					"name=N5302,car=1,boro=#",//
			})
			public class UnloadingLocation {

				public UnloadingLocation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Unloading Location. Arrival. Date Time", uid = "173", cls = "Unloading Location")
				@AAA(msg = {
				//
				"name=N5151,car=1,boro=,chn=（預定）到達日期",//
				})
				public String ArrivalDateTime;

				@DSREF(den = "Unloading Location. Identification. Identifier", uid = "L013", cls = "Unloading Location")
				@AAA(msg = {
						//
						"name=N5103,car=1,boro=,chn=目的地代碼",//
						"name=N5165,car=1,boro=,chn=目的地代碼",//
						"name=N5201,car=1,boro=,chn=國外卸貨港代碼",//
						"name=N5202,car=1,boro=,chn=國外卸貨港代碼",//
				})
				public String ID;

				@DSREF(den = "Unloading Location. Name. Text", uid = "L012", cls = "Unloading Location")
				public String Name;
			}

			public Warehouse_Added Warehouse = new Warehouse_Added();

			@DSREF(cls = "Warehouse")
			@AAA(msg = {
					//
					"name=N5102,car=1,boro=#",//
					"name=N5162,car=1,boro=#",//
					"name=N5201,car=0..1,boro=#",//
			})
			public class Warehouse_Added {

				public Warehouse_Added() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Warehouse. Arrival. Date Time", uid = "221", cls = "Warehouse")
				@AAA(msg = {
						//
						"name=N5102,car=1,boro=,chn=進倉日期與時間",//
						"name=N5162,car=1,boro=,chn=進倉日期與時間",//
						"name=N5201,car=0..1,boro=,chn=進倉日期與時間",//
				})
				public String ArrivalDateTime;

				@DSREF(den = "Warehouse. Storage Area. Code", uid = "TW063", cls = "Warehouse")
				@AAA(msg = {
						//
						"name=N5102,car=0..1,boro=,chn=倉別",//
						"name=N5201,car=0..1,boro=,chn=倉別",//
				})
				public String tw_StorageAreaCode;

				@DSREF(den = "Warehouse. Storage Location. Text", uid = "TW065", cls = "Warehouse")
				@AAA(msg = {
				//
				"name=N5102,car=0..1,boro=,chn=貨櫃（物）存放位置",//
				})
				public String tw_StorageLocation;

				@DSREF(den = "Warehouse. Storage Type. Code", uid = "TW064", cls = "Warehouse")
				@AAA(msg = {
						//
						"name=N5102,car=0..1,boro=,chn=存放區",//
						"name=N5201,car=0..1,boro=,chn=存放區",//
				})
				public String tw_StorageTypeCode;

				@DSREF(den = "Warehouse. Identification. Identifier", uid = "L019", cls = "Warehouse")
				public String ID;
				@DSREF(den = "Warehouse. Name. Text", uid = "L018", cls = "Warehouse")
				public String Name;

			}

		}

		public Consolidator Consolidator = new Consolidator();

		@DSREF(cls = "Consolidator")
		@AAA(msg = {
		//
		"name=N5202,car=0..1,boro=+",//
		})
		public class Consolidator {

			public Consolidator() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Consolidator. Identification. Identifier", uid = "R019", cls = "Consolidator")
			@AAA(msg = {
			//
			"name=N5202,car=1,boro=,chn=出口承攬運送業者代碼",//
			})
			public String ID;

			@DSREF(den = "Consolidator. Name. Text", uid = "R018", cls = "Consolidator")
			public String Name;
		}

		public ContactOffice ContactOffice = new ContactOffice();

		@DSREF(cls = "Contact Office")
		public class ContactOffice {

			public ContactOffice() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Contact Office. Identification. Identifier", uid = "G002", cls = "Contact Office")
			public String ID;

		}

		public ContainerTerminalOperator ContainerTerminalOperator = new ContainerTerminalOperator();

		@DSREF(cls = "Container Terminal Operator")
		@AAA(msg = {
				//
				"name=N5102,car=1,boro=#",//
				"name=N5117,car=1,boro=#",//
				"name=N5201,car=1,boro=#",//
		})
		public class ContainerTerminalOperator {

			public ContainerTerminalOperator() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Container Terminal Operator. Identification. Identifier", uid = "R089", cls = "Container Terminal Operator")
			@AAA(msg = {
					//
					"name=N5102,car=1,boro=,chn=倉儲業者統一編號",//
					"name=N5117,car=1,boro=,chn=倉儲業者統一編號",//
					"name=N5201,car=1,boro=,chn=倉儲業者統一編號",//
			})
			public String ID;

			@DSREF(den = "Container Terminal Operator. Type. Code", uid = "TW104", cls = "Container Terminal Operator")
			@AAA(msg = {
					//
					"name=N5102,car=1,boro=,chn=身分識別代碼",//
					"name=N5117,car=1,boro=,chn=身分識別代碼",//
					"name=N5201,car=1,boro=,chn=身分識別代碼",//
			})
			public String tw_TypeCode;
		}

		public CurrencyExchange CurrencyExchange = new CurrencyExchange();

		@DSREF(cls = "Currency Exchange")
		@AAA(msg = {
				//
				"name=N5203,car=1,boro=",//
				"name=NX301,car=1,boro=",//
				"name=NX301_DN,car=1,boro=",//
				"name=NX401,car=1,boro=",//
				"name=NX5105,car=1,boro=",//
				"name=NX601,car=1,boro=",//
				"name=NX603,car=1,boro=",//
				"name=NX801,car=0..1,boro=",//
		})
		public class CurrencyExchange {

			public CurrencyExchange() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Currency Exchange. Currency Type. Code", uid = "135", cls = "Currency Exchange")
			@AAA(msg = {
					//
					"name=N5203,car=1,boro=,chn=幣別代碼",//
					"name=NX301,car=1,boro=,chn=幣別代碼",//
					"name=NX301_DN,car=1,boro=,chn=幣別代碼",//
					"name=NX401,car=1,boro=,chn=幣別代碼",//
					"name=NX5105,car=1,boro=,chn=幣別代碼",//
					"name=NX601,car=1,boro=,chn=幣別代碼",//
					"name=NX603,car=1,boro=,chn=幣別代碼",//
					"name=NX801,car=1,boro=,chn=幣別代碼",//
			})
			public String CurrencyTypeCode;

			@DSREF(den = "Currency Exchange. Rate. Numeric", uid = "118", cls = "Currency Exchange")
			@AAA(msg = {
					//
					"name=N5203,car=1,boro=,chn=外幣匯率",//
					"name=NX401,car=0..1,boro=,chn=外幣匯率",//
					"name=NX5105,car=1,boro=,chn=外幣匯率",//
					"name=NX603,car=1,boro=,chn=外幣匯率",//
					"name=NX801,car=0..1,boro=,chn=外幣匯率",//
			})
			public String RateRate;

		}

		public Deconsolidator Deconsolidator = new Deconsolidator();

		@DSREF(cls = "Deconsolidator")
		@AAA(msg = {
		//
		"name=N5101,car=0..1,boro=+",//
		})
		public class Deconsolidator {

			public Deconsolidator() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Deconsolidator. Identification. Identifier", uid = "R023", cls = "Deconsolidator")
			@AAA(msg = {
			//
			"name=N5101,car=1,boro=,chn=承攬運送業者代碼",//
			})
			public String ID;

			@DSREF(den = "Deconsolidator. Name. Text", uid = "R022", cls = "Deconsolidator")
			public String Name;
		}

		public DepartureTransportMeans DepartureTransportMeans = new DepartureTransportMeans();

		@DSREF(cls = "Departure Transport Means")
		@AAA(msg = {
				//
				"name=N5201,car=0..1,boro=+",//
				"name=N5202,car=1,boro=+",//
				"name=N5251,car=1,boro=+",//
				"name=N5252,car=1,boro=+",//
				"name=N5262,car=1,boro=+",//
		})
		public class DepartureTransportMeans {

			public DepartureTransportMeans() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Departure Transport Means. Identification. Identifier", uid = "T004", cls = "Departure Transport Means")
			@AAA(msg = {
					//
					"name=N5201,car=1,boro=,chn=出口船（機）代碼",//
					"name=N5202,car=1,boro=,chn=出口船（機）代碼",//
					"name=N5251,car=1,boro=,chn=出口船（機）代碼",//
					"name=N5252,car=1,boro=,chn=出口船（機）代碼",//
					"name=N5262,car=1,boro=,chn=出口船（機）代碼",//
			})
			public String ID;

			@DSREF(den = "Departure Transport Means. Name. Text", uid = "T003", cls = "Departure Transport Means")
			@AAA(msg = {
					//
					"name=N5201,car=0..1,boro=,chn=出口船舶名稱",//
					"name=N5202,car=0..1,boro=,chn=出口船舶名稱",//
			})
			public String Name;

			@DSREF(den = "Departure Transport Means. Registration Nationality. Code", uid = "T013", cls = "Departure Transport Means")
			public String RegistrationNationalityCode;

			@DSREF(den = "Departure Transport Means. Journey. Identifier", uid = "149", cls = "Departure Transport Means")
			public String tw_JourneyID;

			@DSREF(den = "Departure Transport Means. Type. Code", uid = "T009", cls = "Departure Transport Means")
			public String TypeCode;
		}

		public DutyTaxFee DutyTaxFee = new DutyTaxFee();

		@DSREF(cls = "Duty Tax Fee")
		@AAA(msg = {
				//
				"name=N5110,car=1,boro=",//
				"name=N5111,car=1,boro=",//
				"name=N5135,car=1,boro=",//
				"name=N5203,car=0..1,boro=",//
				"name=NX301,car=1,boro=",//
				"name=NX301_DN,car=1,boro=",//
				"name=NX302,car=0..1,boro=",//
				"name=NX302_DN,car=0..1,boro=",//
				"name=NX401,car=1,boro=",//
				"name=NX5105,car=1,boro=",//
				"name=NX601,car=1,boro=",//
				"name=NX602,car=0..1,boro=",//
				"name=NX603,car=1,boro=",//
				"name=NX901,car=0..1,boro=",//
				"name=NX902,car=0..1,boro=",//
		})
		public class DutyTaxFee {

			public DutyTaxFee() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Duty Tax Fee. AdValorem Tax Base. Amount", uid = "116", cls = "Duty Tax Fee")
			public String AdValoremTaxBaseAmount;
			@DSREF(den = "Duty Tax Fee. Deduct. Amount", uid = "111", cls = "Duty Tax Fee")
			public String DeductAmount;
			@DSREF(den = "Duty Tax Fee. Deduction. Quantity", uid = "127", cls = "Duty Tax Fee")
			public String DeductionQuantity;
			@DSREF(den = "Duty Tax Fee. Duty Regime. Code", uid = "164", cls = "Duty Tax Fee")
			public String DutyRegimeCode;
			@DSREF(den = "Duty Tax Fee. Elected Entry. Date Time", uid = "272", cls = "Duty Tax Fee")
			public String ElectedEntryDateTime;

			@DSREF(den = "Duty Tax Fee. Specific Tax Base. Quantity", uid = "129", cls = "Duty Tax Fee")
			public String SpecificTaxBaseQuantity;

			@DSREF(den = "Duty Tax Fee. Duty Exemption Waiver Note. Text", uid = "TW143", cls = "Duty Tax Fee")
			@AAA(msg = {
			//
			"name=NX5105,car=0..1,boro=,chn=排除低價免稅註記",//
			})
			public String tw_DutyExemptionWaiverNote;

			@DSREF(den = "Duty Tax Fee. Duty Memo Printed. Text", uid = "TW080", cls = "Duty Tax Fee")
			@AAA(msg = {
			//
			"name=NX5105,car=0..1,boro=,chn=申請稅單列印",//
			})
			public String tw_DutyMemoPrinted;

			@DSREF(den = "Duty Tax Fee. Duty Method. Code", uid = "TW006", cls = "Duty Tax Fee")
			@AAA(msg = {
					//
					"name=N5135,car=1,boro=,chn=海關稅費繳納方式代碼",//
					"name=N5203,car=1,boro=,chn=海關稅費繳納方式代碼",//
					"name=NX5105,car=1,boro=,chn=海關稅費繳納方式代碼",//
			})
			public String tw_DutyMethodCode;

			@DSREF(den = "Duty Tax Fee. Deferred Reference. Identifier", uid = "TW271", cls = "Obligation Guarantee")
			public String tw_DeferredReferenceID;

			@DSREF(den = "Duty Tax Fee. PrePaid Reference. Identifier", uid = "TW272", cls = "Obligation Guarantee")
			public String tw_PrePaidReferenceID;

			@DSREF(den = "Duty Tax Fee. Total Duty Tax Fee. Amount", uid = "TW029", cls = "Duty Tax Fee")
			@AAA(msg = {
					//
					"name=N5110,car=1,boro=,chn=稅費合計",//
					"name=NX5105,car=1,boro=,chn=稅費合計",//
			})
			public String tw_TotalDutyTaxFeeAmount;

			@DSREF(den = "Duty Tax Fee. Tax Rate. Numeric", uid = "115", cls = "Duty Tax Fee")
			public String TaxRate;

			@DSREF(den = "Duty Tax Fee. Type. Code", uid = "113", cls = "Duty Tax Fee")
			public String TypeCode;

			public Payment Payment = new Payment();

			@DSREF(cls = "Payment")
			@AAA(msg = {
					//
					"name=N5110,car=1,boro=",//
					"name=N5111,car=1,boro=",//
					"name=N5135,car=0..1,boro=",//
					"name=NX301,car=1,boro=",//
					"name=NX301_DN,car=1,boro=",//
					"name=NX302,car=0..1,boro=",//
					"name=NX302_DN,car=0..1,boro=",//
					"name=NX401,car=1,boro=",//
					"name=NX5105,car=0..1,boro=",//
					"name=NX601,car=1,boro=",//
					"name=NX602,car=0..1,boro=",//
					"name=NX603,car=1,boro=",//
					"name=NX901,car=0..1,boro=",//
					"name=NX902,car=0..1,boro=",//
			})
			public class Payment {

				public Payment() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Payment. Method. Code", uid = "107", cls = "Payment")
				public String MethodCode;

				@DSREF(den = "Payment. Due. Date Time", uid = "376", cls = "Payment")
				@AAA(msg = {
				//
				"name=N5110,car=1,boro=#,chn=繳款截止日",//
				})
				public String DueDateTime;

				@DSREF(den = "Payment. Payment. Amount", uid = "378", cls = "Payment")
				@AAA(msg = {
						//
						"name=N5111,car=1,boro=#,chn=金額",//
						"name=NX902,car=0..1,boro=#,chn=應繳費用",//
				})
				public String PaymentAmount;

				@DSREF(den = "Payment. Reference. Identifier", uid = "014", cls = "Payment")
				@AAA(msg = {
						//
						"name=N5110,car=1,boro=,chn=稅費繳納證號碼",//
						"name=N5111,car=1,boro=,chn=存款收款書號碼",//
						"name=NX902,car=0..1,boro=,chn=繳費號碼",//
				})
				public String ReferenceID;

				@DSREF(den = "Payment. Tax Assessed. Amount", uid = "120", cls = "Payment")
				public String TaxAssessedAmount;

				@DSREF(den = "Payment. Belong Date. Text", uid = "TW090", cls = "Payment")
				@AAA(msg = {
				//
				"name=N5111,car=1,boro=,chn=款項所屬年月",//
				})
				public String tw_BelongDate;

				@DSREF(den = "Payment. Deposit Type. Code", uid = "TW067", cls = "Payment")
				@AAA(msg = {
				//
				"name=N5111,car=1,boro=,chn=存款種類代碼",//
				})
				public String tw_DepositTypeCode;

				@DSREF(den = "Payment. Issue Reason. Code", uid = "TW070", cls = "Payment")
				@AAA(msg = {
						//
						"name=N5110,car=0..1,boro=,chn=核發原因代碼",//
						"name=N5111,car=0..1,boro=,chn=核發原因代碼",//
				})
				public String tw_IssueReasonCode;

				public ObligationGuarantee ObligationGuarantee = new ObligationGuarantee();

				@DSREF(cls = "Obligation Guarantee")
				@AAA(msg = {
						//
						"name=N5111,car=1,boro=",//
						"name=N5135,car=1,boro=",//
						"name=NX5105,car=1,boro=",//
				})
				public class ObligationGuarantee {

					public ObligationGuarantee() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Obligation Guarantee. LPCO Expiration. Date Time", uid = "275", cls = "Obligation Guarantee")
					public String LPCOExpirationDateTime;

					@DSREF(den = "Obligation Guarantee. Reference. Identifier", uid = "100", cls = "Obligation Guarantee")
					@AAA(msg = {
							//
							"name=N5135,car=1,boro=#,chn=預繳稅費案號",//
							"name=NX5105,car=1,boro=#,chn=先放後稅核准之案號",//
					})
					public String ReferenceID;

					@DSREF(den = "Obligation Guarantee. Security Details. Code", uid = "101", cls = "Obligation Guarantee")
					public String SecurityDetailsCode;

					public Surety Surety = new Surety();

					@DSREF(cls = "Surety")
					public class Surety {

						public Surety() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Surety. Identification. Identifier", uid = "R055", cls = "Surety")
						public String ID;

						@DSREF(den = "Surety. Name. Text", uid = "R054", cls = "Surety")
						public String Name;

						@DSREF(den = "Surety. Type. Code", uid = "TW104", cls = "Importer")
						public String tw_TypeCode;
					}
				}
			}
		}

		public ExitOffice_Added ExitOffice = new ExitOffice_Added();

		@DSREF(cls = "Exit Office")
		public class ExitOffice_Added {

			public ExitOffice_Added() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Exit Office. Identification. Identifier", uid = "G005", cls = "Exit Office")
			public String ID;
		}

		public Exporter Exporter = new Exporter();

		@DSREF(cls = "Exporter")
		@AAA(msg = {
				//
				"name=N5168,car=0..1,boro=#",//
				"name=N5204,car=1,boro=",//
				"name=N5205,car=1,boro=",//
		})
		public class Exporter {

			public Exporter() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Exporter. Identification. Identifier", uid = "R032", cls = "Exporter")
			@AAA(msg = {
			//
			"name=N5205,car=1,boro=,chn=出口人(貨物輸出人)統一編號",//
			})
			public String ID;

			@DSREF(den = "Exporter. Name. Text", uid = "R031", cls = "Exporter")
			@AAA(msg = {
			//
			"name=N5205,car=1,boro=,chn=出口人(貨物輸出人)英文名稱",//
			})
			public String Name;

			@DSREF(den = "Exporter. Chinese Name. Text", uid = "TW039", cls = "Exporter")
			@AAA(msg = {
			//
			"name=N5205,car=0..1,boro=,chn=出口人(貨物輸出人)中文名稱",//
			})
			public String tw_ChineseName;

			@DSREF(den = "Exporter.  tw_CustomsControlID. Text", uid = "TW003", cls = "Exporter")
			public String tw_CustomsControlID;

			@DSREF(den = "Exporter. Type. Code", uid = "TW104", cls = "Exporter")
			@AAA(msg = {
			//
			"name=N5205,car=1,boro=,chn=身分識別代碼",//
			})
			public String tw_TypeCode;

			public Address Address = new Address();

			@DSREF(cls = "Address")
			@AAA(msg = {
			//
			"name=N5205,car=1,boro=",//
			})
			public class Address {

				public Address() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
				public String CityName;
				@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
				public String CountryCode;
				@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
				public String CountrySubDivisionID;
				@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
				public String CountrySubDivisionName;

				@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
				public String PostcodeID;

				@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
				@AAA(msg = {
				//
				"name=N5205,car=1,boro=,chn=出口人(貨物輸出人)英文地址",//
				})
				public String Line;

				@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
				@AAA(msg = {
				//
				"name=N5205,car=0..1,boro=,chn=出口人(貨物輸出人)中文地址",//
				})
				public String tw_ChineseLine;

			}

		}

		public FinalTransportMeansLoadingPlace FinalTransportMeansLoadingPlace = new FinalTransportMeansLoadingPlace();

		@DSREF(cls = "Final Transport Means Loading Place")
		public class FinalTransportMeansLoadingPlace {

			public FinalTransportMeansLoadingPlace() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Final Transport Means Loading Place. Identification. Identifier", uid = "L084", cls = "Final Transport Means Loading Place")
			public String ID;
		}

		public GoodsConsignedPlace_Added GoodsConsignedPlace_Added = new GoodsConsignedPlace_Added();

		@DSREF(cls = "Goods Consigned Place")
		@AAA(msg = {
		//
		"name=N5101,car=0..1,boro=+",//
		})
		public class GoodsConsignedPlace_Added {

			public GoodsConsignedPlace_Added() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Goods Consigned Place. Identification. Identifier", uid = "L024", cls = "Goods Consigned Place")
			@AAA(msg = {
			//
			"name=N5101,car=1,boro=,chn=到港前一國外港",//
			})
			public String ID;

			@DSREF(den = "Goods Consigned Place. Name. Text", uid = "L023", cls = "Goods Consigned Place")
			public String Name;
		}

		public GoodsLocation_Added GoodsLocation_Added = new GoodsLocation_Added();

		@DSREF(cls = "Goods Location")
		@AAA(msg = {
		//
		"name=N5117,car=1,boro=+",//
		})
		public class GoodsLocation_Added {

			public GoodsLocation_Added() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Goods Location. Identification. Identifier", uid = "L017", cls = "Goods Location")
			@AAA(msg = {
			//
			"name=N5117,car=1,boro=,chn=卸存地點代碼",//
			})
			public String ID;

			@DSREF(den = "Goods Location. Subtotal Empty Container. Quantity", uid = "TW046", cls = "MyGoodsConsignedPlace")
			public String tw_SubtotalEmptyContainerQuantity;

			public TransportEquipment_Added TransportEquipment_Added = new TransportEquipment_Added();

			@DSREF(cls = "Transport Equipment")
			public class TransportEquipment_Added {

				public TransportEquipment_Added() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Transport Equipment. Characteristic. Code", uid = "152", cls = "MyTransportEquipment")
				public String CharacteristicCode;

				@DSREF(den = "Transport Equipment. Identification. Identifier", uid = "159", cls = "MyTransportEquipment")
				public String ID;

			}

		}

		public GoodsShipment GoodsShipment = new GoodsShipment();

		@DSREF(cls = "Goods Shipment")
		@AAA(msg = {
				//
				"name=N5101,car=1,boro=#",//
				"name=N5102,car=1,boro=#",//
				"name=N5103,car=1,boro=#",//
				"name=N5107,car=1,boro=",//
				"name=N5108,car=1,boro=",//
				"name=N5109,car=1,boro=",//
				"name=N5110,car=1,boro=",//
				"name=N5111,car=1,boro=",//
				"name=N5116,car=1,boro=",//
				"name=N5117,car=1,boro=",//
				"name=N5135,car=1..9999,boro=",//
				"name=N5151,car=1,boro=",//
				"name=N5158,car=1,boro=",//
				"name=N5162,car=1,boro=#",//
				"name=N5165,car=0..1,boro=#",//
				"name=N5166,car=1,boro=",//
				"name=N5167,car=1,boro=",//
				"name=N5168,car=1,boro=",//
				"name=N5201,car=1,boro=",//
				"name=N5202,car=1,boro=#",//
				"name=N5203,car=1,boro=",//
				"name=N5204,car=1,boro=",//
				"name=N5205,car=1..9999,boro=",//
				"name=N5251,car=1,boro=#",//
				"name=N5252,car=1,boro=#",//
				"name=N5262,car=1,boro=",//
				"name=N5301,car=1,boro=",//
				"name=N5302,car=1,boro=",//
				"name=N5401,car=1,boro=",//
				"name=N5402,car=1,boro=",//
				"name=N5403,car=1,boro=",//
				"name=N5404,car=1..9999,boro=",//
				"name=NX201_01,car=1,boro=",//
				"name=NX201_07,car=1,boro=",//
				"name=NX202,car=0..1,boro=",//
				"name=NX301,car=1,boro=",//
				"name=NX301_DN,car=1,boro=",//
				"name=NX302,car=1,boro=",//
				"name=NX302_DN,car=1,boro=",//
				"name=NX401,car=1,boro=",//
				"name=NX402,car=1,boro=",//
				"name=NX5105,car=1,boro=",//
				"name=NX5106,car=0..1,boro=",//
				"name=NX601,car=1,boro=",//
				"name=NX602,car=1,boro=",//
				"name=NX603,car=1,boro=",//
				"name=NX801,car=0..1,boro=",//
				"name=NX802,car=0..1,boro=",//
				"name=NX901,car=0..1,boro=",//
				"name=NX902,car=0..1,boro=",//
				"name=NX903,car=1,boro=",//
		})
		public class GoodsShipment {

			public GoodsShipment() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Goods Shipment. Dispatch. Date Time", uid = "030", cls = "Goods Shipment")
			public String DispatchDateTime;

			@DSREF(den = "Goods Shipment. Exit. Date Time", uid = "024", cls = "Goods Shipment")
			@AAA(msg = {
					//
					"name=NX202,car=1,boro=,chn=出口日期",//
					"name=NX401,car=1,boro=,chn=國外出口日期",//
					"name=NX5105,car=1,boro=,chn=國外出口日期",//
					"name=NX601,car=1,boro=,chn=國外出口日期",//
					"name=NX603,car=1,boro=,chn=國外出口日期",//
					"name=NX801,car=0..1,boro=,chn=國外出口日期",//
			})
			public String ExitDateTime;

			@DSREF(den = "Goods Shipment. Exportation Country. Code", uid = "062", cls = "Goods Shipment")
			public String ExportationCountryCode;

			@DSREF(den = "Goods Shipment. Free Trade Zone Status. Code", uid = "303", cls = "Goods Shipment")
			public String FreeTradeZoneStatusCode;

			@DSREF(den = "Goods Shipment. Sequence. Numeric", uid = "006", cls = "Goods Shipment")
			@AAA(msg = {
					//
					"name=N5135,car=1,boro=,chn=序號",//
					"name=N5205,car=1,boro=,chn=序號",//
			})
			public String SequenceNumeric;

			@DSREF(den = "Goods Shipment. Transaction Nature. Code", uid = "103", cls = "Goods Shipment")
			public String TransactionNatureCode;

			@DSREF(den = "Goods Shipment. Item Charge. Amount", uid = "112", cls = "Goods Shipment")
			@AAA(msg = {
					//
					"name=N5203,car=1,boro=*,chn=總離岸價格(新台幣)",//
					"name=N5205,car=1,boro=*,chn=總離岸價格(新台幣)",//
					"name=NX5105,car=1,boro=*,chn=總離岸價格",//
			})
			public String tw_ItemChargeAmount;

			@DSREF(den = "Goods Shipment. Invoice. Amount", uid = "109", cls = "Goods Shipment")
			@AAA(msg = {
			//
			"name=N5135,car=1,boro=*,chn=發票總金額",//
			})
			public String tw_InvoiceAmount;

			@DSREF(den = "Goods Shipment. Purpose. Code", uid = "TW075", cls = "Goods Shipment")
			public String tw_PurposeCode;

			@DSREF(den = "Goods Shipment. Tax Fee Declared. Text", uid = "TW119", cls = "Goods Shipment")
			@AAA(msg = {
			//
			"name=N5135,car=0..1,boro=,chn=主動申報繳納稅款註記",//
			})
			public String tw_TaxFeeDeclared;

			@DSREF(den = "Goods Shipment. Total CIF. Amount", uid = "TW145", cls = "Goods Shipment")
			@AAA(msg = {
			//
			"name=NX5105,car=1,boro=,chn=總起岸價格(新台幣)",//
			})
			public String tw_TotalCIFAmount;

			@DSREF(den = "Goods Shipment. Total Gross Mass. Measure", uid = "131", cls = "Goods Shipment")
			@AAA(msg = {
					//
					"name=N5135,car=1,boro=*,chn=總毛重",//
					"name=N5205,car=1,boro=*,chn=總毛重",//
			})
			public String tw_TotalGrossMassMeasure;

			// ////////////////////////////////////////////////////////////////////////////
			public AdditionalDocument AdditionalDocument = new AdditionalDocument();

			@DSREF(cls = "Additional Document")
			@AAA(msg = {
					//
					"name=N5204,car=0..5,boro=",//
					"name=N5401,car=1,boro=",//
					"name=N5402,car=1,boro=",//
					"name=N5403,car=1,boro=",//
					"name=N5404,car=1,boro=",//
					"name=NX201_01,car=0..5,boro=",//
					"name=NX201_07,car=0..5,boro=",//
					"name=NX202,car=0..1,boro=",//
					"name=NX301,car=0..99,boro=",//
					"name=NX301_DN,car=0..99,boro=",//
					"name=NX302,car=1,boro=",//
					"name=NX302_DN,car=1,boro=",//
					"name=NX401,car=0..99,boro=",//
					"name=NX402,car=1,boro=",//
					"name=NX5105,car=0..99,boro=",//
					"name=NX601,car=0..99,boro=",//
					"name=NX602,car=1,boro=",//
					"name=NX603,car=0..99,boro=",//
					"name=NX801,car=0..1,boro=",//
					"name=NX901,car=0..1,boro=",//
					"name=NX902,car=0..1,boro=",//
			})
			public class AdditionalDocument {

				public AdditionalDocument() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Additional Document. Identification. Identifier", uid = "D005", cls = "Additional Document")
				@AAA(msg = {
						//
						"name=N5404,car=1,boro=,chn=海關核准編號",//
						"name=NX302,car=1,boro=,chn=輸出入許可文件號碼",//
						"name=NX302_DN,car=1,boro=,chn=輸出入許可文件號碼",//
						"name=NX402,car=1,boro=,chn=輸出入許可文件號碼",//
						"name=NX602,car=1,boro=,chn=輸出入許可文件號碼",//
						"name=NX901,car=1,boro=,chn=輸出入許可文件號碼",//
						"name=NX902,car=1,boro=,chn=輸出入許可文件號碼",//
				})
				public String ID;

				@DSREF(den = "Additional Document. Declaration Office. Identifier", uid = "065", cls = "Additional Document")
				public String tw_DeclarationOfficeID;

				@DSREF(den = "Additional Document. Image File Format. Code", uid = "TW101", cls = "Additional Document")
				public String tw_ImageFileFormatCode;

				@DSREF(den = "Additional Document. Image File Name. Text", uid = "TW097", cls = "Additional Document")
				public String tw_ImageFileName;

				@DSREF(den = "Additional Document. Split. Identifier", uid = "TW129", cls = "Additional Document")
				@AAA(msg = {
				//
				"name=NX402,car=0..1,boro=,chn=輸出入許可文件分割號碼",//
				})
				public String tw_SplitID;

				@DSREF(den = "Additional Document. Type. Code", uid = "D006", cls = "Additional Document")
				@AAA(msg = {
				//
				"name=NX801,car=1,boro=,chn=文件類別",//
				})
				public String TypeCode;

			}

			public AdditionalInformation AdditionalInformation = new AdditionalInformation();

			@DSREF(cls = "Additional Information")
			@AAA(msg = {
					//
					"name=N5116,car=0..1,boro=",//
					"name=N5401,car=0..1,boro=",//
					"name=N5402,car=0..1,boro=",//
					"name=N5404,car=1,boro=",//
					"name=NX901,car=0..1,boro=",//
			})
			public class AdditionalInformation {

				public AdditionalInformation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Additional Information. Content. Text", uid = "105", cls = "Additional Information")
				public String Content;
				@DSREF(den = "Additional Information. Limit. Date Time", uid = "264", cls = "Additional Information")
				public String LimitDateTime;
				@DSREF(den = "Additional Information. Reconciliation Reason. Code", uid = "300", cls = "Additional Information")
				public String ReconciliationReasonCode;
				@DSREF(den = "Additional Information. Request Override. Code", uid = "095", cls = "Additional Information")
				public String RequestOverrideCode;
				@DSREF(den = "Additional Information. Requested Inspection. Date Time", uid = "220", cls = "Additional Information")
				public String RequestedInspectionDateTime;

				@DSREF(den = "Additional Information. Statement. Code", uid = "226", cls = "Additional Information")
				@AAA(msg = {
				//
				"name=N5116,car=1,boro=,chn=有否短卸",//
				})
				public String StatementCode;

				@DSREF(den = "Additional Information. Statement Description. Text", uid = "225", cls = "Additional Information")
				@AAA(msg = {
						//
						"name=N5401,car=1,boro=,chn=用料清表號碼",//
						"name=N5402,car=1,boro=,chn=用料清表號碼",//
						"name=NX901,car=1,boro=,chn=備註",//
				})
				public String StatementDescription;

				@DSREF(den = "Additional Information. Statement Type. Code", uid = "369", cls = "Additional Information")
				public String StatementTypeCode;

				@DSREF(den = "Additional Information. Inspection Rate. Code", uid = "TW058", cls = "Additional Information")
				@AAA(msg = {
				//
				"name=N5404,car=1,boro=,chn=出入區抽核比率代碼",//
				})
				public String tw_InspectionRateCode;
			}

			public ApprovedEstablishmentPlace ApprovedEstablishmentPlace = new ApprovedEstablishmentPlace();

			@DSREF(cls = "Approved Establishment Place")
			public class ApprovedEstablishmentPlace {

				public ApprovedEstablishmentPlace() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Approved Establishment Place. Identification. Identifier", uid = "L058", cls = "Approved Establishment Place")
				public String ID;
				@DSREF(den = "Approved Establishment Place. Name. Text", uid = "L057", cls = "Approved Establishment Place")
				public String Name;
			}

			public BorderTransportMeans BorderTransportMeans = new BorderTransportMeans();

			@DSREF(cls = "Border Transport Means")
			public class BorderTransportMeans {

				public BorderTransportMeans() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Border Transport Means. Arrival. Date Time", uid = "172", cls = "Border Transport Means")
				public String ArrivalDateTime;
				@DSREF(den = "Border Transport Means. Conveyance First Port Of Arrival. Date Time", uid = "267", cls = "Border Transport Means")
				public String ConveyanceFirstPortOfArrivalDateTime;
				@DSREF(den = "Border Transport Means. First Arrival Location. Identifier", uid = "085", cls = "Border Transport Means")
				public String FirstArrivalLocationID;

				@DSREF(den = "Border Transport Means. Identification. Identifier", uid = "T006", cls = "Border Transport Means")
				public String ID;

				@DSREF(den = "Border Transport Means. Importation Into Port Limits. Date Time", uid = "271", cls = "Border Transport Means")
				public String ImportationIntoPortLimitsDateTime;

				@DSREF(den = "Border Transport Means. Journey. Identifier", uid = "149", cls = "Border Transport Means")
				public String JourneyID;

				@DSREF(den = "Border Transport Means. Registration. Text", uid = "TW043", cls = "Border Transport Means")
				public String tw_Registration;

				@DSREF(den = "Border Transport Means. Name. Text", uid = "T005", cls = "Border Transport Means")
				public String Name;
				@DSREF(den = "Border Transport Means. Registration Nationality. Code", uid = "T014", cls = "Border Transport Means")
				public String RegistrationNationalityCode;
				@DSREF(den = "Border Transport Means. Type. Code", uid = "T010", cls = "Border Transport Means")
				public String TypeCode;
			}

			public Buyer Buyer = new Buyer();

			@DSREF(cls = "Buyer")
			@AAA(msg = {
					//
					"name=N5203,car=1,boro=#",//
					"name=N5401,car=1,boro=",//
					"name=N5402,car=1,boro=",//
					"name=NX201_01,car=0..1,boro=",//
					"name=NX201_07,car=0..1,boro=",//
					"name=NX202,car=0..1,boro=",//
					"name=NX801,car=0..1,boro=",//
			})
			public class Buyer {

				public Buyer() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Buyer. Identification. Identifier", uid = "R010", cls = "Buyer")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=,chn=買方統一編號",//
						"name=N5401,car=1,boro=,chn=買方統一編號",//
						"name=N5402,car=1,boro=,chn=買方統一編號",//
				})
				public String ID;

				@DSREF(den = "Buyer. Name. Text", uid = "R009", cls = "Buyer")
				@AAA(msg = {
						//
						"name=N5203,car=1,boro=,chn=買方英文名稱",//
						"name=N5401,car=1,boro=,chn=買方英文名稱",//
						"name=N5402,car=1,boro=,chn=買方英文名稱",//
						"name=NX201_01,car=1,boro=,chn=買方英文名稱",//
				})
				public String Name;

				@DSREF(den = "Buyer. Chinese Name. Text", uid = "TW147", cls = "Buyer")
				@AAA(msg = {
						//
						"name=N5401,car=0..1,boro=,chn=買方中文名稱",//
						"name=N5402,car=0..1,boro=,chn=買方中文名稱",//
				})
				public String tw_ChineseName;

				@DSREF(den = "Buyer. Customs Control. Identifier", uid = "TW003", cls = "Buyer")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=,chn=海關監管編號",//
						"name=N5401,car=0..1,boro=,chn=海關監管編號",//
						"name=N5402,car=0..1,boro=,chn=海關監管編號",//
				})
				public String tw_CustomsControlID;

				@DSREF(den = "Buyer. Type. Code", uid = "TW104", cls = "Buyer")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=,chn=身分識別代碼",//
						"name=N5401,car=1,boro=,chn=身分識別代碼",//
						"name=N5402,car=1,boro=,chn=身分識別代碼",//
				})
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				@AAA(msg = {
						//
						"name=N5203,car=1,boro=#",//
						"name=N5401,car=1,boro=",//
						"name=N5402,car=1,boro=",//
						"name=NX201_01,car=1,boro=",//
						"name=NX201_07,car=0..1,boro=",//
						"name=NX202,car=0..1,boro=",//
						"name=NX801,car=0..1,boro=",//
				})
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;

					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=買方國家代碼",//
							"name=NX201_01,car=1,boro=,chn=買方國家代碼",//
							"name=NX801,car=1,boro=,chn=買方國家代碼",//
					})
					public String CountryCode;

					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;

					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=,chn=買方英文地址",//
							"name=N5401,car=1,boro=,chn=買方英文地址",//
							"name=N5402,car=1,boro=,chn=買方英文地址",//
							"name=NX201_01,car=0..1,boro=,chn=買方英文地址",//
					})
					public String Line;

					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;

					@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
					@AAA(msg = {
							//
							"name=N5401,car=0..1,boro=,chn=買方中文地址",//
							"name=N5402,car=0..1,boro=,chn=買方中文地址",//
					})
					public String tw_ChineseLine;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public Carrier Carrier = new Carrier();

			@DSREF(cls = "Carrier")
			@AAA(msg = {
					//
					"name=N5167,car=0..1,boro=+",//
					"name=NX5105,car=0..1,boro=",//
					"name=NX5106,car=0..1,boro=",//
			})
			public class Carrier {

				public Carrier() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Carrier. Identification. Identifier", uid = "R012", cls = "Carrier")
				// @N5167(car = "1", chn = "運輸業者/代理行代碼")
				public String ID;

				@DSREF(den = "Carrier. Name. Text", uid = "R011", cls = "Carrier")
				public String Name;
			}

			public Commodity Commodity = new Commodity();

			@DSREF(cls = "Commodity")
			@AAA(msg = {
			//
			"name=N5204,car=1,boro=+",//
			})
			public class Commodity {

				public Commodity() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				public Classification Classification = new Classification();

				@DSREF(cls = "Classification")
				@AAA(msg = {
				//
				"name=N5204,car=1,boro=+",//
				})
				public class Classification {

					public Classification() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Classification. Identification. Identifier", uid = "145", cls = "Classification")
					// @N5204(car = "1", chn = "貨品分類號列", re = "")
					public String ID;

					@DSREF(den = "Classification. Identification Type. Code", uid = "337", cls = "Classification")
					// @N5204(car = "1", chn = "*貨品分類號類別代碼")
					public String IdentificationTypeCode;
				}

			}

			public Consignee Consignee = new Consignee();

			@DSREF(cls = "Consignee")
			@AAA(msg = {
					//
					"name=N5135,car=0..1,boro=",//
					"name=N5203,car=0..1,boro=",//
					"name=NX201_01,car=0..1,boro=",//
					"name=NX201_07,car=0..1,boro=",//
					"name=NX202,car=0..1,boro=",//
					"name=NX401,car=0..1,boro=",//
					"name=NX5105,car=0..1,boro=",//
			})
			public class Consignee {

				public Consignee() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Consignee. Identification. Identifier", uid = "R015", cls = "Consignee")
				@AAA(msg = {
						//
						"name=N5135,car=0..1,boro=,chn=收貨人代碼",//
						"name=N5203,car=0..1,boro=,chn=收貨人代碼",//
						"name=NX401,car=0..1,boro=,chn=收貨人代碼",//
						"name=NX5105,car=0..1,boro=,chn=收貨人代碼",//
				})
				public String ID;

				@DSREF(den = "Consignee. Name. Text", uid = "R014", cls = "Consignee")
				@AAA(msg = {
						//
						"name=N5135,car=1,boro=,chn=收貨人英文名稱",//
						"name=N5203,car=0..1,boro=,chn=收貨人英文名稱",//
						"name=NX201_01,car=1,boro=,chn=收貨人英文名稱",//
						"name=NX401,car=1,boro=,chn=收貨人英文名稱",//
						"name=NX5105,car=0..1,boro=,chn=收貨人英文名稱",//
				})
				public String Name;

				@DSREF(den = "Consignee. Chinese Name. Text", uid = "TW004", cls = "Consignee")
				@AAA(msg = {
						//
						"name=N5135,car=0..1,boro=,chn=收貨人中文名稱",//
						"name=N5203,car=0..1,boro=,chn=收貨人中文名稱",//
						"name=NX401,car=1,boro=,chn=收貨人中文名稱",//
						"name=NX5105,car=0..1,boro=,chn=收貨人中文名稱",//
				})
				public String tw_ChineseName;

				@DSREF(den = "Consignee. Type. Code", uid = "TW104", cls = "Consignee")
				@AAA(msg = {
						//
						"name=N5135,car=0..1,boro=,chn=身分識別代碼",//
						"name=N5203,car=0..1,boro=,chn=身分識別代碼",//
						"name=NX401,car=0..1,boro=,chn=身分識別代碼",//
						"name=NX5105,car=0..1,boro=,chn=身分識別代碼",//
				})
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				@AAA(msg = {
						//
						"name=N5135,car=0..1,boro=",//
						"name=N5203,car=0..1,boro=",//
						"name=NX201_01,car=1,boro=",//
						"name=NX201_07,car=0..1,boro=",//
						"name=NX202,car=0..1,boro=",//
						"name=NX401,car=1,boro=",//
						"name=NX5105,car=0..1,boro=",//
				})
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;

					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					@AAA(msg = {
					//
					"name=NX201_01,car=1,boro=,chn=收貨人國家代碼",//
					})
					public String CountryCode;

					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;

					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					@AAA(msg = {
							//
							"name=N5135,car=1,boro=,chn=收貨人英文地址",//
							"name=N5203,car=0..1,boro=,chn=收貨人英文地址",//
							"name=NX201_01,car=0..1,boro=,chn=收貨人英文地址",//
							"name=NX401,car=1,boro=,chn=收貨人英文地址",//
							"name=NX5105,car=0..1,boro=,chn=收貨人英文地址",//
					})
					public String Line;

					@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
					@AAA(msg = {
							//
							"name=N5135,car=0..1,boro=,chn=收貨人中文地址",//
							"name=N5203,car=0..1,boro=,chn=收貨人中文地址",//
							"name=NX401,car=1,boro=,chn=收貨人中文地址",//
							"name=NX5105,car=0..1,boro=,chn=收貨人中文地址",//
					})
					public String tw_ChineseLine;

					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public Consignment Consignment = new Consignment();

			@DSREF(cls = "Consignment")
			@AAA(msg = {
					//
					"name=N5101,car=0..9999,boro=#",//
					"name=N5102,car=1,boro=",//
					"name=N5107,car=1,boro=",//
					"name=N5108,car=1,boro=",//
					"name=N5109,car=1,boro=",//
					"name=N5110,car=1,boro=",//
					"name=N5111,car=1,boro=",//
					"name=N5116,car=1,boro=",//
					"name=N5117,car=1,boro=",//
					"name=N5135,car=1,boro=",//
					"name=N5151,car=1,boro=",//
					"name=N5158,car=1,boro=",//
					"name=N5162,car=1,boro=",//
					"name=N5165,car=1,boro=",//
					"name=N5166,car=1,boro=",//
					"name=N5167,car=0..1,boro=",//
					"name=N5168,car=1,boro=",//
					"name=N5201,car=1,boro=",//
					"name=N5202,car=0..9999,boro=#",//
					"name=N5203,car=1,boro=",//
					"name=N5204,car=1,boro=",//
					"name=N5205,car=1,boro=",//
					"name=N5251,car=1,boro=",//
					"name=N5252,car=1,boro=",//
					"name=N5262,car=1,boro=",//
					"name=N5301,car=1,boro=",//
					"name=N5302,car=1,boro=",//
					"name=N5401,car=0..1,boro=",//
					"name=N5402,car=0..1,boro=",//
					"name=N5403,car=1,boro=",//
					"name=N5404,car=1,boro=",//
					"name=NX201_01,car=0..1,boro=",//
					"name=NX201_07,car=1,boro=",//
					"name=NX202,car=0..1,boro=",//
					"name=NX301,car=1,boro=",//
					"name=NX301_DN,car=1,boro=",//
					"name=NX401,car=1,boro=",//
					"name=NX402,car=0..1,boro=",//
					"name=NX5105,car=1,boro=",//
					"name=NX5106,car=0..1,boro=",//
					"name=NX601,car=1,boro=",//
					"name=NX603,car=1,boro=",//
					"name=NX801,car=0..1,boro=",//
			})
			public class Consignment {

				public Consignment() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Consignment. Boarded. Quantity", uid = "314", cls = "Consignment")
				public String BoardedQuantity;

				@DSREF(den = "Consignment. Container. Indicator", uid = "096", cls = "Consignment")
				public String ContainerIndicator;

				@DSREF(den = "Consignment. Sequence. Numeric", uid = "006", cls = "Consignment")
				@AAA(msg = {
				//
				// "name=NX5105,car=0..1,boro=,chn=艙單號碼",//
				})
				public String SequenceNumeric;

				@DSREF(den = "Consignment. Total Package. Quantity", uid = "146", cls = "Consignment")
				@AAA(msg = {
						//
						"name=N5135,car=1,boro=,chn=總件數",//
						"name=N5205,car=1,boro=,chn=總件數",//
				})
				public String TotalPackageQuantity;

				@DSREF(den = "Consignment. Invoice. Amount", uid = "109", cls = "Consignment")
				@AAA(msg = {
				//
				"name=N5135,car=1,boro=*,chn=總完稅價格（新台幣）",//
				})
				public String tw_InvoiceAmount;

				@DSREF(den = "Consignment. Manifest Serial Number. Text", uid = "TW153", cls = "Consignment")
				@AAA(msg = {
				//
				"name=NX5105,car=0..1,boro=,chn=艙單號碼",//
				})
				public String tw_ManifestSerialNumber;

				@DSREF(den = "Consignment. Shipping Order Number. Text", uid = "TW078", cls = "Consignment")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=,chn=裝貨單號碼",//
						"name=N5204,car=0..1,boro=,chn=裝貨單號碼",//
				})
				public String tw_ShippingOrderNumber;

				public AdditionalInformation AdditionalInformation = new AdditionalInformation();

				@DSREF(cls = "Additional Information")
				@AAA(msg = {
						//
						"name=N5116,car=0..1,boro=",//
						"name=N5203,car=0..10,boro=",//
						"name=N5401,car=1,boro=",//
						"name=N5402,car=1,boro=",//
						"name=NX5105,car=0..10,boro=",//
						"name=NX603,car=0..10,boro=",//
				})
				public class AdditionalInformation {

					public AdditionalInformation() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Additional Information. Content. Text", uid = "105", cls = "Additional Information")
					public String Content;
					@DSREF(den = "Additional Information. Limit. Date Time", uid = "264", cls = "Additional Information")
					public String LimitDateTime;
					@DSREF(den = "Additional Information. Reconciliation Reason. Code", uid = "300", cls = "Additional Information")
					public String ReconciliationReasonCode;
					@DSREF(den = "Additional Information. Request Override. Code", uid = "095", cls = "Additional Information")
					public String RequestOverrideCode;
					@DSREF(den = "Additional Information. Requested Inspection. Date Time", uid = "220", cls = "Additional Information")
					public String RequestedInspectionDateTime;

					@DSREF(den = "Additional Information. Statement. Code", uid = "226", cls = "Additional Information")
					@AAA(msg = {
							//
							"name=N5116,car=1,boro=,chn=有否查驗",//
							"name=N5203,car=1,boro=,chn=*備註類別代碼",//
							"name=NX5105,car=1,boro=,chn=*備註類別代碼",//
							"name=NX603,car=1,boro=,chn=*備註類別代碼",//
					})
					public String StatementCode;

					@DSREF(den = "Additional Information. Statement Description. Text", uid = "225", cls = "Additional Information")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=備用欄位",//
							"name=N5401,car=1,boro=,chn=備註",//
							"name=N5402,car=1,boro=,chn=備註",//
							"name=NX5105,car=1,boro=,chn=備用欄位",//
							"name=NX603,car=1,boro=,chn=備用欄位",//
					})
					public String StatementDescription;

					@DSREF(den = "Additional Information. Statement Type. Code", uid = "369", cls = "Additional Information")
					public String StatementTypeCode;
				}

				public ArrivalTransportMeans ArrivalTransportMeans = new ArrivalTransportMeans();

				@DSREF(cls = "Arrival Transport Means")
				@AAA(msg = {
						//
						"name=NX301,car=0..1,boro=",//
						"name=NX401,car=0..1,boro=",//
						"name=NX402,car=0..1,boro=",//
						"name=NX5105,car=1,boro=",//
						"name=NX601,car=1,boro=",//
						"name=NX603,car=0..1,boro=",//
				})
				public class ArrivalTransportMeans {

					public ArrivalTransportMeans() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Arrival Transport Means. Identification. Identifier", uid = "T002", cls = "Arrival Transport Means")
					public String ID;

					@DSREF(den = "Arrival Transport Means. Name. Text", uid = "T001", cls = "Arrival Transport Means")
					public String Name;

					@DSREF(den = "Arrival Transport Means. Registration Nationality. Code", uid = "T012", cls = "Arrival Transport Means")
					public String RegistrationNationalityCode;

					@DSREF(den = "Arrival Transport Means. Type. Code", uid = "T008", cls = "Arrival Transport Means")
					@AAA(msg = {
							//
							"name=NX401,car=1,boro=,chn=進口運輸方式代碼",//
							"name=NX402,car=1,boro=,chn=進口運輸方式代碼",//
							"name=NX5105,car=1,boro=,chn=進口運輸方式代碼",//
					})
					public String TypeCode;
				}

				public AssociatedTransportDocument AssociatedTransportDocument = new AssociatedTransportDocument();

				@DSREF(cls = "Associated Transport Document")
				public class AssociatedTransportDocument {

					public AssociatedTransportDocument() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Associated Transport Document. Identification. Identifier", uid = "D008", cls = "Associated Transport Document")
					public String ID;

					@DSREF(den = "Associated Transport Document. Type. Code", uid = "D009", cls = "Associated Transport Document")
					public String TypeCode;

				}

				public BorderTransportMeans BorderTransportMeans = new BorderTransportMeans();

				@DSREF(cls = "Border Transport Means")
				@AAA(msg = {
						//
						"name=N5107,car=0..1,boro=",//
						"name=N5109,car=0..1,boro=",//
						"name=N5110,car=1,boro=",//
						"name=N5116,car=1,boro=",//
						"name=N5203,car=1,boro=",//
						"name=N5204,car=1,boro=",//
						"name=NX401,car=1,boro=",//
						"name=NX5105,car=1,boro=",//
						"name=NX801,car=0..1,boro=",//
				})
				public class BorderTransportMeans {

					public BorderTransportMeans() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Border Transport Means. Arrival. Date Time", uid = "172", cls = "Border Transport Means")
					public String ArrivalDateTime;
					@DSREF(den = "Border Transport Means. Conveyance First Port Of Arrival. Date Time", uid = "267", cls = "Border Transport Means")
					public String ConveyanceFirstPortOfArrivalDateTime;
					@DSREF(den = "Border Transport Means. First Arrival Location. Identifier", uid = "085", cls = "Border Transport Means")
					public String FirstArrivalLocationID;

					@DSREF(den = "Border Transport Means. Identification. Identifier", uid = "T006", cls = "Border Transport Means")
					@AAA(msg = {
							//
							"name=N5109,car=0..1,boro=,chn=船（機）代碼",//
							"name=N5110,car=1,boro=,chn=船（機）代碼",//
							"name=N5116,car=1,boro=,chn=船（機）代碼",//
							"name=NX401,car=1,boro=,chn=船（機）代碼",//
							"name=NX5105,car=1,boro=,chn=船（機）代碼",//
							"name=NX801,car=0..1,boro=,chn=船（機）代碼",//
					})
					public String ID;

					@DSREF(den = "Border Transport Means. Importation Into Port Limits. Date Time", uid = "271", cls = "Border Transport Means")
					public String ImportationIntoPortLimitsDateTime;

					@DSREF(den = "Border Transport Means. Journey. Identifier", uid = "149", cls = "Border Transport Means")
					@AAA(msg = {
							//
							"name=N5107,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
							"name=N5109,car=0..1,boro=,chn=船舶航次（海）/航機班次（空）",//
							"name=N5110,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
							"name=N5116,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
							"name=N5203,car=1,boro=#,chn=船舶航次（海）/航機班次（空）",//
							"name=N5204,car=1,boro=#,chn=船舶航次（海）/航機班次（空）",//
							"name=NX401,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
							"name=NX5105,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
							"name=NX801,car=1,boro=,chn=船舶航次（海）/航機班次（空）",//
					})
					public String JourneyID;

					@DSREF(den = "Border Transport Means. Name. Text", uid = "T005", cls = "Border Transport Means")
					public String Name;

					@DSREF(den = "Border Transport Means. Registration Nationality. Code", uid = "T014", cls = "Border Transport Means")
					public String RegistrationNationalityCode;

					@DSREF(den = "Border Transport Means. Call Sign. Identifier", uid = "TW092", cls = "Border Transport Means")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=,chn=船舶呼號",//
							"name=N5204,car=0..1,boro=,chn=船舶呼號",//
					})
					public String tw_CallSignID;

					@DSREF(den = "Border Transport Means. Registration. Text", uid = "TW043", cls = "Border Transport Means")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=,chn=海關通關號碼",//
							"name=N5204,car=0..1,boro=,chn=海關通關號碼",//
							"name=NX5105,car=0..1,boro=,chn=海關通關號碼",//
					})
					public String tw_Registration;

					@DSREF(den = "Border Transport Means. Type. Code", uid = "T010", cls = "Border Transport Means")
					public String TypeCode;
				}

				public Carrier Carrier = new Carrier();

				@DSREF(cls = "Carrier")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=",//
						"name=N5102,car=1,boro=",//
						"name=N5107,car=0..1,boro=",//
						"name=N5108,car=1,boro=",//
						"name=N5109,car=0..1,boro=",//
						"name=N5110,car=1,boro=",//
						"name=N5111,car=1,boro=",//
						"name=N5116,car=0..1,boro=",//
						"name=N5117,car=1,boro=",//
						"name=N5135,car=1,boro=",//
						"name=N5151,car=1,boro=",//
						"name=N5158,car=1,boro=",//
						"name=N5162,car=1,boro=",//
						"name=N5165,car=1,boro=",//
						"name=N5166,car=1,boro=",//
						"name=N5167,car=0..1,boro=",//
						"name=N5168,car=1,boro=",//
						"name=N5201,car=1,boro=",//
						"name=N5202,car=1,boro=",//
						"name=N5203,car=0..1,boro=",//
						"name=N5204,car=0..1,boro=",//
						"name=N5205,car=1,boro=",//
						"name=N5251,car=1,boro=",//
						"name=N5252,car=1,boro=",//
						"name=N5262,car=1,boro=",//
						"name=N5301,car=1,boro=",//
						"name=N5302,car=1,boro=",//
						"name=N5401,car=1,boro=",//
						"name=N5402,car=1,boro=",//
						"name=N5403,car=1,boro=",//
						"name=N5404,car=1,boro=",//
						"name=NX5105,car=0..1,boro=",//
						"name=NX5106,car=0..1,boro=",//
				})
				public class Carrier {

					public Carrier() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Carrier. Identification. Identifier", uid = "R012", cls = "Carrier")
					@AAA(msg = {
							//
							"name=N5107,car=1,boro=,chn=運輸業者/代理行代碼",//
							"name=N5109,car=1,boro=,chn=運輸業者/代理行代碼",//
							"name=N5203,car=1,boro=,chn=運輸業者/代理行代碼",//
							"name=N5204,car=1,boro=,chn=運輸業者/代理行代碼",//
							"name=NX5105,car=1,boro=,chn=運輸業者/代理行代碼",//
							"name=NX5106,car=1,boro=,chn=運輸業者/代理行代碼",//
					})
					public String ID;

					@DSREF(den = "Carrier. Name. Text", uid = "R011", cls = "Carrier")
					public String Name;

					@DSREF(den = "Carrier. Type. Code", uid = "TW061", cls = "Carrier")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=運輸業者/代理行類別代碼",//
							"name=NX5105,car=1,boro=,chn=運輸業者/代理行類別代碼",//
					})
					public String tw_TypeCode;

					public Address Address = new Address();

					@DSREF(cls = "Address")
					public class Address {

						public Address() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
						public String CityName;
						@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
						public String CountryCode;
						@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
						public String CountrySubDivisionID;
						@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
						public String CountrySubDivisionName;
						@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
						public String Line;
						@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
						public String PostcodeID;
					}

					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}

					public Contact Contact = new Contact();

					@DSREF(cls = "Contact")
					public class Contact {

						public Contact() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
						public String Name;
						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}
					}
				}

				public Consignment2 Consignment2 = new Consignment2();

				@DSREF(cls = "Consignment")
				public class Consignment2 {

					public Consignment2() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Declaration. Associated Government Procedure. Code", uid = "233", cls = "Declaration")
					public String tw_AssociatedGovernmentProcedureCode;

				}

				public ConsignmentItem ConsignmentItem = new ConsignmentItem();

				@DSREF(cls = "Consignment Item")
				@AAA(msg = {
						//
						"name=N5135,car=0..1,boro=+",//
						"name=N5201,car=1,boro=",//
						"name=N5205,car=0..1,boro=+",//
				})
				public class ConsignmentItem {

					public ConsignmentItem() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Consignment Item. Split. Text", uid = "TW045", cls = "Consignment Item")
					public String tw_Split;

					@DSREF(den = "Consignment Item. Total Package. Quantity", uid = "146", cls = "Consignment Item")
					public String tw_TotalPackageQuantity;

					@DSREF(den = "Consignment Item. Volume Unit. Code", uid = "TW007", cls = "Consignment Item")
					public String tw_VolumeUnitCode;

					@DSREF(den = "Consignment Item. Goods Status. Code", uid = "094", cls = "Consignment Item")
					public String GoodsStatusCode;

					@DSREF(den = "Consignment Item. Sequence. Numeric", uid = "006", cls = "Consignment Item")
					public String SequenceNumeric;

					@DSREF(den = "Consignment Item. Associated Government Procedure. Code", uid = "233", cls = "Consignment Item")
					@AAA(msg = {
							//
							"name=N5135,car=1,boro=,chn=申請審驗方式",//
							"name=N5205,car=1,boro=,chn=申請審驗方式",//
					})
					public String AssociatedGovernmentProcedureCode;

				}

				public ContainerOperator ContainerOperator = new ContainerOperator();

				@DSREF(cls = "Container Operator")
				public class ContainerOperator {

					public ContainerOperator() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Container Operator. Identification. Identifier", uid = "R044", cls = "Container Operator")
					public String ID;
					public Address Address = new Address();

					@DSREF(cls = "Address")
					public class Address {

						public Address() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
						public String CityName;
						@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
						public String CountryCode;
						@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
						public String CountrySubDivisionID;
						@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
						public String CountrySubDivisionName;
						@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
						public String Line;
						@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
						public String PostcodeID;
					}

					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}

					public Contact Contact = new Contact();

					@DSREF(cls = "Contact")
					public class Contact {

						public Contact() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
						public String Name;
						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}
					}
				}

				public Control Control = new Control();

				@DSREF(cls = "Control")
				public class Control {

					public Control() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Control. Inspection End. Date Time", uid = "356", cls = "Control")
					public String InspectionEndDateTime;
					@DSREF(den = "Control. Inspection Start. Date Time", uid = "355", cls = "Control")
					public String InspectionStartDateTime;
					@DSREF(den = "Control. Time-Limit. Date Time", uid = "264", cls = "Control")
					public String LimitDateTime;
					@DSREF(den = "Control. Review Place. Identifier", uid = "289", cls = "Control")
					public String ReviewPlaceID;

				}

				public DepartureTransportMeans DepartureTransportMeans = new DepartureTransportMeans();

				@DSREF(cls = "Departure Transport Means")
				@AAA(msg = {
						//
						"name=N5201,car=0..1,boro=",//
						"name=N5203,car=1,boro=",//
						"name=N5204,car=0..1,boro=",//
				})
				public class DepartureTransportMeans {

					public DepartureTransportMeans() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Departure Transport Means. Identification. Identifier", uid = "T004", cls = "Departure Transport Means")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=,chn=出口船（機）代碼",//
							"name=N5204,car=0..1,boro=,chn=出口船（機）代碼",//
					})
					public String ID;

					@DSREF(den = "Departure Transport Means. Name. Text", uid = "T003", cls = "Departure Transport Means")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=,chn=出口船舶名稱",//
							"name=N5204,car=0..1,boro=,chn=出口船舶名稱",//
					})
					public String Name;

					@DSREF(den = "Departure Transport Means. Registration Nationality. Code", uid = "T013", cls = "Departure Transport Means")
					public String RegistrationNationalityCode;

					@DSREF(den = "Departure Transport Means. Journey. Identifier", uid = "149", cls = "Departure Transport Means")
					public String tw_JourneyID;

					@DSREF(den = "Departure Transport Means. Type. Code", uid = "T009", cls = "Departure Transport Means")
					@AAA(msg = {
					//
					"name=N5203,car=1,boro=,chn=出口運輸方式代碼",//
					})
					public String TypeCode;

				}

				public ExaminationPlace ExaminationPlace = new ExaminationPlace();

				@DSREF(cls = "Examination Place")
				public class ExaminationPlace {

					public ExaminationPlace() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Examination Place. Identification. Identifier", uid = "L029", cls = "Examination Place")
					public String ID;

					@DSREF(den = "Examination Place. Name. Text", uid = "L069", cls = "Examination Place")
					public String Name;
				}

				public FinalTransportMeansLoadingPlace FinalTransportMeansLoadingPlace = new FinalTransportMeansLoadingPlace();

				@DSREF(cls = "Final Transport Means Loading Place")
				public class FinalTransportMeansLoadingPlace {

					public FinalTransportMeansLoadingPlace() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Final Transport Means Loading Place. Identification. Identifier", uid = "L084", cls = "Final Transport Means Loading Place")
					public String ID;
				}

				public FreeTradeZone FreeTradeZone = new FreeTradeZone();

				@DSREF(cls = "Free Trade Zone")
				public class FreeTradeZone {

					public FreeTradeZone() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Free Trade Zone. Identification. Identifier", uid = "L066", cls = "Free Trade Zone")
					public String ID;

					@DSREF(den = "Free Trade Zone. Name. Text", uid = "L065", cls = "Free Trade Zone")
					public String Name;

				}

				public GoodsConsignedPlace GoodsConsignedPlace = new GoodsConsignedPlace();

				@DSREF(cls = "Goods Consigned Place")
				public class GoodsConsignedPlace {

					public GoodsConsignedPlace() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Goods Consigned Place. Identification. Identifier", uid = "L024", cls = "Goods Consigned Place")
					public String ID;
				}

				public GoodsLocation GoodsLocation = new GoodsLocation();

				@DSREF(cls = "Goods Location")
				@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=+",//
						"name=N5109,car=1,boro=+",//
						"name=N5116,car=1,boro=+",//
						"name=N5203,car=1..2,boro=+",//
						"name=N5204,car=1,boro=+",//
						"name=NX301,car=1,boro=+",//
						"name=NX301_DN,car=1,boro=+",//
						"name=NX401,car=1,boro=+",//
						"name=NX5105,car=1,boro=+",//
						"name=NX601,car=1,boro=+",//
						"name=NX603,car=1,boro=+",//
						"name=NX801,car=0..1,boro=+",//
				})
				public class GoodsLocation {

					public GoodsLocation() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Goods Location. Identification. Identifier", uid = "L017", cls = "Goods Location")
					@AAA(msg = {
							//
							"name=N5101,car=0..1,boro=,chn=空櫃卸存地點代碼",//
							"name=N5109,car=1,boro=,chn=卸存地點代碼",//
							"name=N5116,car=1,boro=,chn=卸存地點代碼",//
							"name=N5203,car=1,boro=,chn=卸存地點代碼",//
							"name=N5204,car=1,boro=,chn=卸存地點代碼",//
							"name=NX301,car=1,boro=,chn=卸存地點代碼",//
							"name=NX401,car=1,boro=,chn=卸存地點代碼",//
							"name=NX5105,car=1,boro=,chn=卸存地點代碼",//
							"name=NX601,car=1,boro=,chn=卸存地點代碼",//
							"name=NX603,car=1,boro=,chn=卸存地點代碼",//
							"name=NX801,car=1,boro=,chn=卸存地點代碼",//
					})
					public String ID;

					@DSREF(den = "Goods Location. Name. Text", uid = "L016", cls = "Goods Location")
					public String Name;

					@DSREF(den = "Goods Location. Subtotal Empty Container. Quantity", uid = "TW046", cls = "Goods Location")
					@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=,chn=空櫃小計",//
					})
					public String tw_SubtotalEmptyContainerQuantity;
				}

				public GovernmentProcedure GovernmentProcedure = new GovernmentProcedure();

				@DSREF(cls = "Government Procedure")
				@AAA(msg = {
						//
						"name=N5135,car=0..2,boro=",//
						"name=N5167,car=1,boro=",//
						"name=N5204,car=1,boro=",//
						"name=N5205,car=0..2,boro=",//
						"name=N5402,car=0..1,boro=",//
				})
				public class GovernmentProcedure {

					public GovernmentProcedure() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Government Procedure. Current. Code", uid = "166", cls = "Government Procedure")
					public String CurrentCode;

					@DSREF(den = "Government Procedure. Description. Text", uid = "353", cls = "Government Procedure")
					@AAA(msg = {
							//
							"name=N5135,car=1,boro=,chn=其他申報事項",//
							"name=N5205,car=1,boro=,chn=其他申報事項",//
					})
					public String Description;

					@DSREF(den = "Government Procedure. Previous. Code", uid = "161", cls = "Government Procedure")
					public String PreviousCode;

					@DSREF(den = "Government Procedure. Extra Requirement. Code", uid = "TW_103", cls = "Government Procedure")
					public String tw_ExtraRequirementCode;

					@DSREF(den = "Government Procedure. Previous. Code", uid = "161", cls = "Government Procedure")
					public String tw_TransportStatusCode;

					@DSREF(den = "Government Procedure. Transport Type. Code", uid = "TW051", cls = "Government Procedure")
					public String tw_TransportTypeCode;
				}

				public LoadingLocation LoadingLocation = new LoadingLocation();

				@DSREF(cls = "Loading Location")
				@AAA(msg = {
						//
						"name=N5135,car=1,boro=",//
						"name=N5203,car=0..1,boro=",//
						"name=NX201_01,car=0..1,boro=",//
						"name=NX201_07,car=0..1,boro=",//
						"name=NX202,car=0..1,boro=",//
						"name=NX301,car=0..1,boro=",//
						"name=NX301_DN,car=1,boro=",//
						"name=NX401,car=1,boro=",//
						"name=NX5105,car=1,boro=",//
						"name=NX601,car=1,boro=",//
						"name=NX603,car=1,boro=",//
						"name=NX801,car=0..1,boro=",//
				})
				public class LoadingLocation {

					public LoadingLocation() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Loading Location. Identification. Identifier", uid = "L010", cls = "Loading Location")
					@AAA(msg = {
							//
							"name=N5135,car=1,boro=,chn=裝貨港代碼",//
							"name=N5203,car=1,boro=,chn=裝貨港代碼",//
							"name=NX201_01,car=1,boro=,chn=裝貨港代碼",//
							"name=NX301,car=1,boro=,chn=裝貨港代碼",//
							"name=NX301_DN,car=1,boro=,chn=裝貨港代碼",//
							"name=NX401,car=1,boro=,chn=裝貨港代碼",//
							"name=NX5105,car=1,boro=,chn=裝貨港代碼",//
							"name=NX601,car=1,boro=,chn=裝貨港代碼",//
							"name=NX603,car=1,boro=,chn=裝貨港代碼",//
							"name=NX801,car=1,boro=,chn=裝貨港代碼",//
					})
					public String ID;

					@DSREF(den = "Loading Location. Loading. Date Time", uid = "031", cls = "Loading Location")
					public String LoadingDateTime;
					@DSREF(den = "Loading Location. Name. Text", uid = "L009", cls = "Loading Location")
					public String Name;
					public CustomsValuation CustomsValuation = new CustomsValuation();

					@DSREF(cls = "Customs Valuation")
					public class CustomsValuation {

						public CustomsValuation() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Customs Valuation. Charges Type. Code", uid = "371", cls = "Customs Valuation")
						public String ChargesTypeCode;
						@DSREF(den = "Customs Valuation. Exit To Entry Charge. Amount", uid = "121", cls = "Customs Valuation")
						public String ExitToEntryChargeAmount;
						@DSREF(den = "Customs Valuation. Freight Charge. Amount", uid = "117", cls = "Customs Valuation")
						public String FreightChargeAmount;
						@DSREF(den = "Customs Valuation. Freight Charge Apportionment. Code", uid = "124", cls = "Customs Valuation")
						public String FreightChargeApportionmentCode;
						@DSREF(den = "Customs Valuation. Method. Code", uid = "122", cls = "Customs Valuation")
						public String MethodCode;
						@DSREF(den = "Customs Valuation. Other Charge Deduction. Amount", uid = "181", cls = "Customs Valuation")
						public String OtherChargeDeductionAmount;
						@DSREF(den = "Customs Valuation. Party Relationship. Code", uid = "163", cls = "Customs Valuation")
						public String PartyRelationshipCode;
						@DSREF(den = "Customs Valuation. Payment Terms. Code", uid = "301", cls = "Customs Valuation")
						public String PaymentTermsCode;
					}
				}

				public Packaging Packaging = new Packaging();

				@DSREF(cls = "Packaging")
				@AAA(msg = {
						//
						"name=N5135,car=1,boro=#",//
						"name=N5205,car=1,boro=#",//
						"name=NX5105,car=1,boro=",//
						"name=NX801,car=0..1,boro=",//
				})
				public class Packaging {

					public Packaging() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Packaging. Marks Numbers. Text", uid = "142", cls = "Packaging")
					// @NX5105(car = "1", chn = "標記")
					// @NX801(car = "1", chn = "標記")
					// @N5101(car = "1", chn = "標記")
					// @N5202(car = "0..1", chn = "標記")
					// @N5116(car = "1", chn = "標記")
					// @N5203(car = "1", chn = "標記")
					// @N5204(car = "1", chn = "標記")
					// @N5301(car = "1", chn = "標記")
					public String MarksNumbers;

					@DSREF(den = "Packaging. Packaging Material Description. Text", uid = "344", cls = "Packaging")
					// @N5301(car = "0..1", chn = "包裝說明")
					public String PackagingMaterialDescription;

					@DSREF(den = "Packaging. Combination. Text", uid = "TW011", cls = "Packaging")
					// @NX5105(car = "0..1", chn = "合成註記", re =
					// "C(C)3(-)D(-)6(-)4(-)")
					// @N5101(car = "0..1", chn = "合成註記")
					// @N5116(car = "0..1", chn = "合成註記")
					// @N5301(car = "0..1", chn = "合成註記")
					// @N5302(car = "0..1", chn = "合成註記")
					public String tw_Combination;

					@DSREF(den = "Packaging. Quantity. Quantity", uid = "144", cls = "Packaging")
					// @N5205(car = "1", chn = "分託運單總件數")
					// @N5205(car = "1", chn = "總件數")
					public String QuantityQuantity;

					@DSREF(den = "Packaging. Size Description. Text", uid = "367", cls = "Packaging")
					public String SizeDescription;

					@DSREF(den = "Packaging. Type. Code", uid = "141", cls = "Packaging")
					@AAA(msg = {
							//
							"name=N5135,car=1,boro=,chn=件數單位",//
							"name=N5205,car=1,boro=,chn=件數單位",//
					})
					public String TypeCode;

					@DSREF(den = "Packaging. Volume. Measure", uid = "395", cls = "Packaging")
					public String VolumeMeasure;
				}

				public PreviousDocument PreviousDocument = new PreviousDocument();

				@DSREF(cls = "Previous Document")
				@AAA(msg = {
				//
				"name=N5204,car=0..1,boro=",//
				})
				public class PreviousDocument {

					public PreviousDocument() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Previous Document. Identification. Identifier", uid = "D018", cls = "Previous Document")
					@AAA(msg = {
					//
					"name=N5204,car=1,boro=,chn=原報單號碼",//
					})
					public String ID;

				}

				public PropertyOperator PropertyOperator = new PropertyOperator();

				@DSREF(cls = "Property Operator")
				public class PropertyOperator {

					public PropertyOperator() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Property Operator. Identification. Identifier", uid = "R088", cls = "Property Operator")
					public String ID;
					@DSREF(den = "Property Operator. Name. Text", uid = "R057", cls = "Property Operator")
					public String Name;
					public Address Address = new Address();

					@DSREF(cls = "Address")
					public class Address {

						public Address() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
						public String CityName;
						@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
						public String CountryCode;
						@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
						public String CountrySubDivisionID;
						@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
						public String CountrySubDivisionName;
						@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
						public String Line;
						@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
						public String PostcodeID;
					}

					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}

					public Contact Contact = new Contact();

					@DSREF(cls = "Contact")
					public class Contact {

						public Contact() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
						public String Name;
						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}
					}
				}

				public PropertyOwner PropertyOwner = new PropertyOwner();

				@DSREF(cls = "Property Owner")
				public class PropertyOwner {

					public PropertyOwner() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Property Owner. Identification. Identifier", uid = "R098", cls = "Property Owner")
					public String ID;
					@DSREF(den = "Property Owner. Name. Text", uid = "R095", cls = "Property Owner")
					public String Name;
					public Address Address = new Address();

					@DSREF(cls = "Address")
					public class Address {

						public Address() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
						public String CityName;
						@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
						public String CountryCode;
						@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
						public String CountrySubDivisionID;
						@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
						public String CountrySubDivisionName;
						@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
						public String Line;
						@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
						public String PostcodeID;
					}

					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}

					public Contact Contact = new Contact();

					@DSREF(cls = "Contact")
					public class Contact {

						public Contact() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
						public String Name;
						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}
					}
				}

				public Storage Storage = new Storage();

				@DSREF(cls = "Storage")
				public class Storage {

					public Storage() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Storage. Country. Code", uid = "400", cls = "Storage")
					public String CountryCode;
					@DSREF(den = "Storage. Geographic Region. Text", uid = "398", cls = "Storage")
					public String GeographicRegion;
					@DSREF(den = "Storage. Political Region. Identifier", uid = "399", cls = "Storage")
					public String PoliticalRegionCode;
				}

				public Temperature Temperature = new Temperature();

				@DSREF(cls = "Temperature")
				public class Temperature {

					public Temperature() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Temperature. Actual. Measure", uid = "320", cls = "Temperature")
					public String ActualMeasure;
					@DSREF(den = "Temperature. Category. Code", uid = "319", cls = "Temperature")
					public String CategoryCode;
					@DSREF(den = "Temperature. Storage Requirement. Measure", uid = "321", cls = "Temperature")
					public String StorageRequirementMeasure;
				}

				public TranshipmentLocation TranshipmentLocation = new TranshipmentLocation();

				@DSREF(cls = "Transhipment Location")
				@AAA(msg = {
						//
						"name=NX201_01,car=0..1,boro=",//
						"name=NX201_07,car=0..1,boro=",//
						"name=NX202,car=0..1,boro=",//
				})
				public class TranshipmentLocation {

					public TranshipmentLocation() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Transhipment Location. Identification. Identifier", uid = "L015", cls = "Transhipment Location")
					@AAA(msg = {
					//
					"name=NX201_01,car=1,boro=,chn=轉口港代碼",//
					})
					public String ID;

					@DSREF(den = "Transhipment Location. Name. Text", uid = "L014", cls = "Transhipment Location")
					public String Name;
				}

				public TransitDeparture TransitDeparture = new TransitDeparture();

				@DSREF(cls = "Transit Departure")
				@AAA(msg = {
						//
						"name=NX201_01,car=0..1,boro=+",//
						"name=NX201_07,car=0..1,boro=+",//
						"name=NX202,car=0..1,boro=+",//
				})
				public class TransitDeparture {

					public TransitDeparture() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Transit Departure. Departure. Date Time", uid = "156", cls = "Transit Departure")
					public String DepartureDateTime;

					@DSREF(den = "Transit Departure. Identification. Identifier", uid = "L087", cls = "Transit Departure")
					@AAA(msg = {
					//
					"name=NX201_01,car=1,boro=,chn=第三地起運口岸代碼",//
					})
					public String ID;
				}

				public TransportContractDocument TransportContractDocument = new TransportContractDocument();

				@DSREF(cls = "Transport Contract Document")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=",//
						"name=N5102,car=1,boro=",//
						"name=N5107,car=1..4,boro=",//
						"name=N5108,car=1,boro=",//
						"name=N5109,car=0..2,boro=",//
						"name=N5110,car=1..2,boro=",//
						"name=N5111,car=1,boro=",//
						"name=N5116,car=1..2,boro=",//
						"name=N5117,car=1,boro=",//
						"name=N5135,car=1,boro=",//
						"name=N5151,car=1,boro=",//
						"name=N5158,car=1,boro=",//
						"name=N5162,car=1,boro=",//
						"name=N5165,car=1,boro=",//
						"name=N5166,car=1,boro=",//
						"name=N5167,car=1,boro=",//
						"name=N5168,car=1,boro=",//
						"name=N5201,car=1..2,boro=",//
						"name=N5202,car=1,boro=",//
						"name=N5203,car=1..101,boro=",//
						"name=N5204,car=1..2,boro=",//
						"name=N5205,car=1,boro=",//
						"name=N5251,car=1,boro=",//
						"name=N5252,car=1,boro=",//
						"name=N5262,car=1,boro=",//
						"name=N5301,car=1,boro=",//
						"name=N5302,car=1,boro=",//
						"name=N5401,car=1,boro=",//
						"name=N5402,car=1,boro=",//
						"name=N5403,car=1,boro=",//
						"name=N5404,car=1,boro=",//
						"name=NX301,car=0..2,boro=",//
						"name=NX301_DN,car=0..2,boro=",//
						"name=NX401,car=0..2,boro=",//
						"name=NX5105,car=1..101,boro=",//
						"name=NX5106,car=0..2,boro=",//
						"name=NX601,car=0..2,boro=",//
						"name=NX603,car=0..2,boro=",//
						"name=NX801,car=0..2,boro=",//
				})
				public class TransportContractDocument {

					public TransportContractDocument() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Transport Contract Document. Identification. Identifier", uid = "D023", cls = "Transport Contract Document")
					@AAA(msg = {
							//
							"name=N5107,car=1,boro=,chn=主提單號碼;分提單號碼;託運單主號;託運單分號",//
							"name=N5109,car=1,boro=,chn=主提單號碼;分提單號碼;託運單主號;託運單分號",//
							"name=N5110,car=1,boro=,chn=主提單號碼;分提單號碼",//
							"name=N5116,car=1,boro=,chn=主提單號碼;分提單號碼",//
							"name=N5135,car=1,boro=,chn=分提單號碼",//
							"name=N5203,car=1,boro=,chn=託運單主號;託運單分號;運送單號碼",//
							"name=N5204,car=1,boro=,chn=託運單主號;託運單分號",//
							"name=N5205,car=1,boro=,chn=託運單分號",//
							"name=NX301,car=1,boro=,chn=主提單號碼;分提單號碼",//
							"name=NX401,car=1,boro=,chn=主提單號碼;分提單號碼",//
							"name=NX5105,car=1,boro=,chn=主提單號碼;分提單號碼;運送單號碼",//
							"name=NX5106,car=1,boro=,chn=主提單號碼;分提單號碼;託運單主號;託運單分號",//
							"name=NX601,car=1,boro=,chn=主提單號碼;分提單號碼",//
							"name=NX603,car=1,boro=,chn=主提單號碼;分提單號碼",//
							"name=NX801,car=1,boro=,chn=主提單號碼;分提單號碼;託運單主號;託運單分號",//
					})
					public String ID;

					@DSREF(den = "Transport Contract Document. Issue. Date Time", uid = "D020", cls = "Transport Contract Document")
					public String IssueDateTime;

					@DSREF(den = "Transport Contract Document. Type. Code", uid = "D024", cls = "Transport Contract Document")
					@AAA(msg = {
							//
							"name=N5107,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=N5109,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=N5110,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=N5116,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=N5203,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=N5204,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=NX301,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=NX401,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=NX5105,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=NX5106,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=NX601,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=NX603,car=1,boro=,chn=*運輸合約文件類別代碼",//
							"name=NX801,car=1,boro=,chn=*運輸合約文件類別代碼",//
					})
					public String TypeCode;

					public Authenticator Authenticator = new Authenticator();

					@DSREF(cls = "Authenticator")
					public class Authenticator {

						public Authenticator() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Authenticator. Identification. Identifier", uid = "R008", cls = "Authenticator")
						public String ID;
						@DSREF(den = "Authenticator. Name. Text", uid = "R007", cls = "Authenticator")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public Submitter Submitter = new Submitter();

					@DSREF(cls = "Submitter")
					public class Submitter {

						public Submitter() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Submitter. Identification. Identifier", uid = "R059", cls = "Submitter")
						public String ID;
						@DSREF(den = "Submitter. Name. Text", uid = "R058", cls = "Submitter")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}
				}

				public TransportEquipment TransportEquipment = new TransportEquipment();

				@DSREF(cls = "Transport Equipment")
				@AAA(msg = {
						//
						"name=N5101,car=0..9999,boro=#",//
						"name=N5102,car=1,boro=",//
						"name=N5107,car=1,boro=",//
						"name=N5108,car=1,boro=",//
						"name=N5109,car=0..99,boro=",//
						"name=N5110,car=1,boro=",//
						"name=N5111,car=1,boro=",//
						"name=N5116,car=0..9999,boro=",//
						"name=N5117,car=1,boro=",//
						"name=N5135,car=1,boro=",//
						"name=N5151,car=1,boro=",//
						"name=N5158,car=1,boro=",//
						"name=N5162,car=1,boro=",//
						"name=N5165,car=1,boro=",//
						"name=N5166,car=1,boro=",//
						"name=N5167,car=1,boro=",//
						"name=N5168,car=1,boro=",//
						"name=N5201,car=1,boro=",//
						"name=N5202,car=0..9999,boro=#",//
						"name=N5203,car=0..9999,boro=",//
						"name=N5204,car=0..9999,boro=",//
						"name=N5205,car=1,boro=",//
						"name=N5251,car=1,boro=",//
						"name=N5252,car=1,boro=",//
						"name=N5262,car=1,boro=",//
						"name=N5301,car=1,boro=",//
						"name=N5302,car=1,boro=",//
						"name=N5401,car=1,boro=",//
						"name=N5402,car=1,boro=",//
						"name=N5403,car=1,boro=",//
						"name=N5404,car=1,boro=",//
						"name=NX301_DN,car=0..9999,boro=",//
						"name=NX401,car=0..9999,boro=",//
						"name=NX5105,car=0..9999,boro=",//
						"name=NX601,car=0..9999,boro=",//
						"name=NX801,car=0..9999,boro=",//
				})
				public class TransportEquipment {

					public TransportEquipment() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Transport Equipment. Characteristic. Code", uid = "152", cls = "Transport Equipment")
					@AAA(msg = {
							//
							"name=N5101,car=0..1,boro=,chn=空櫃種類",//
							"name=N5202,car=0..1,boro=,chn=空櫃種類",//
							"name=N5203,car=1,boro=#,chn=貨櫃種類",//
							"name=NX401,car=0..1,boro=#,chn=貨櫃種類",//
							"name=NX5105,car=1,boro=#,chn=貨櫃種類",//
					})
					public String CharacteristicCode;

					@DSREF(den = "Transport Equipment. Identification. Identifier", uid = "159", cls = "Transport Equipment")
					@AAA(msg = {
							//
							"name=N5101,car=0..1,boro=,chn=空櫃號碼",//
							"name=N5202,car=0..1,boro=,chn=空櫃號碼",//
							"name=N5109,car=1,boro=,chn=貨櫃號碼",//
							"name=N5116,car=1,boro=,chn=實櫃號碼",//
							"name=N5203,car=1,boro=,chn=貨櫃號碼",//
							"name=N5204,car=1,boro=,chn=實櫃號碼",//
							"name=NX301_DN,car=1,boro=,chn=貨櫃號碼",//
							"name=NX401,car=0..1,boro=,chn=貨櫃號碼",//
							"name=NX5105,car=1,boro=,chn=貨櫃號碼",//
							"name=NX801,car=1,boro=,chn=貨櫃號碼",//
					})
					public String ID;

					@DSREF(den = "Transport Equipment. Current. Code", uid = "166", cls = "Transport Equipment")
					@AAA(msg = {
							//
							"name=N5116,car=0..1,boro=*,chn=處理註記",//
							"name=N5204,car=0..1,boro=*,chn=處理註記",//
					})
					public String tw_CurrentCode;

					@DSREF(den = "Transport Equipment. Used Capacity. Code", uid = "TW030", cls = "Transport Equipment")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=貨櫃裝運方式",//
							"name=NX401,car=0..1,boro=,chn=貨櫃裝運方式",//
							"name=NX5105,car=1,boro=,chn=貨櫃裝運方式",//
					})
					public String tw_UsedCapacityCode;

					@DSREF(den = "Transport Equipment. License Plate Issuing Country. Code", uid = "279", cls = "Transport Equipment")
					public String LicensePlateIssuingCountryCode;
					@DSREF(den = "Transport Equipment. Registration Country Subdivision. Code", uid = "293", cls = "Transport Equipment")
					public String RegistrationCountrySubdivisionCode;
					@DSREF(den = "Transport Equipment. Sequence. Numeric", uid = "006", cls = "Transport Equipment")
					public String SequenceNumeric;

					public LoadingLocation LoadingLocation = new LoadingLocation();

					@DSREF(cls = "Loading Location")
					@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=+",//

					})
					public class LoadingLocation {

						public LoadingLocation() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Loading Location. Identification. Identifier", uid = "L010", cls = "Loading Location")
						@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=,chn=裝貨港代碼",//

						})
						public String ID;

						@DSREF(den = "Loading Location. Name. Text", uid = "L009", cls = "Loading Location")
						@AAA(msg = {
						//
						"name=N5101,car=0..1,boro=,chn=裝貨港",//

						})
						public String Name;
					}

					public tw_Seal tw_Seal = new tw_Seal();

					@DSREF(cls = "Seal")
					@AAA(msg = {
							//
							"name=N5203,car=0..10,boro=",//
							"name=NX401,car=0..10,boro=",//
							"name=NX5105,car=0..10,boro=",//
					})
					public class tw_Seal {

						public tw_Seal() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Seal. Seal. Identifier", uid = "165", cls = "Seal")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=*,chn=封條號碼",//
								"name=NX401,car=1,boro=*,chn=封條號碼",//
								"name=NX5105,car=1,boro=*,chn=封條號碼",//
						})
						public String tw_SealID;

					}

				}

				public tw_BondedGoods tw_BondedGoods = new tw_BondedGoods();

				@DSREF(cls = "Bonded Goods")
				@AAA(msg = {
						//
						"name=N5203,car=1,boro=",//
						"name=NX5105,car=0..1,boro=",//
				})
				public class tw_BondedGoods {

					public tw_BondedGoods() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Bonded Goods. Add Duty Reason. Code", uid = "TW035", cls = "Bonded Goods")
					@AAA(msg = {
					//
					"name=NX5105,car=0..1,boro=,chn=保稅貨物內銷補稅原因代碼",//
					})
					public String tw_AddDutyReasonCode;

					@DSREF(den = "Bonded Goods. Document. Code", uid = "TW041", cls = "Bonded Goods")
					@AAA(msg = {
					//
					"name=N5203,car=0..1,boro=,chn=檢附外銷品使用原料及其供應商資料表",//
					})
					public String tw_DocumentCode;

					@DSREF(den = "Bonded Goods. Refundable. Text", uid = "TW038", cls = "Bonded Goods")
					@AAA(msg = {
					//
					"name=N5203,car=1,boro=,chn=申請沖退原料稅",//
					})
					public String tw_Refundable;

					public tw_BondedFactory tw_BondedFactory = new tw_BondedFactory();

					@DSREF(cls = "Bonded Factory")
					@AAA(msg = {
					//
					"name=N5203,car=0..10,boro=",//
					})
					public class tw_BondedFactory {

						public tw_BondedFactory() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Bonded Factory. Customs Control. Identifier", uid = "TW003", cls = "Bonded Factory")
						@AAA(msg = {
						//
						"name=N5203,car=1,boro=,chn=海關監管編號",//
						})
						public String tw_CustomsControlID;

						@DSREF(den = "Bonded Factory. Identification. Identifier", uid = "TW042", cls = "Bonded Factory")
						@AAA(msg = {
						//
						"name=N5203,car=1,boro=,chn=保稅工廠統一編號",//
						})
						public String tw_ID;

						@DSREF(den = "Bonded Factory. Type. Code", uid = "TW104", cls = "Bonded Factory")
						@AAA(msg = {
						//
						"name=N5203,car=1,boro=,chn=身分識別代碼",//
						})
						public String tw_TypeCode;

					}

					public tw_BondedGoodsInvoice tw_BondedGoodsInvoice = new tw_BondedGoodsInvoice();

					@DSREF(cls = "Bonded Goods Invoice")
					@AAA(msg = {
							//
							"name=N5203,car=0..999,boro=",//
							"name=NX5105,car=0..999,boro=",//
					})
					public class tw_BondedGoodsInvoice {

						public tw_BondedGoodsInvoice() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Bonded Goods Invoice. Identification. Identifier", uid = "D016", cls = "Bonded Goods Invoice")
						@AAA(msg = {
								//
								"name=N5203,car=0..1,boro=*,chn=統一發票號碼",//
								"name=NX5105,car=0..1,boro=*,chn=統一發票號碼",//
						})
						public String tw_ID;

						@DSREF(den = "Bonded Goods Invoice. Value. Amount", uid = "306", cls = "Bonded Goods Invoice")
						@AAA(msg = {
								//
								"name=N5203,car=0..1,boro=*,chn=交易金額",//
								"name=NX5105,car=0..1,boro=*,chn=交易金額",//
						})
						public String tw_ValueAmount;

					}

					public tw_BondedGoodsMonthlyReport tw_BondedGoodsMonthlyReport = new tw_BondedGoodsMonthlyReport();

					@DSREF(cls = "Bonded Goods Monthly Report")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=",//
							"name=NX5105,car=0..1,boro=",//
					})
					public class tw_BondedGoodsMonthlyReport {

						public tw_BondedGoodsMonthlyReport() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Bonded Goods Monthly Report. Month. Numeric", uid = "TW034", cls = "Bonded Goods Monthly Report")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=,chn=月份",//
								"name=NX5105,car=0..1,boro=,chn=月份",//
						})
						public String tw_MonthNumeric;

						@DSREF(den = "Bonded Goods Monthly Report. Trader Reference. Identifier", uid = "TW036", cls = "Bonded Goods Monthly Report")
						@AAA(msg = {
								//
								"name=N5203,car=0..1,boro=,chn=交易對方參考編號",//
								"name=NX5105,car=0..1,boro=,chn=交易對方參考編號",//
						})
						public String tw_TraderReferenceID;

					}

					public tw_InBondedParty tw_InBondedParty = new tw_InBondedParty();

					@DSREF(cls = "In Bonded Party")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=",//
							"name=NX5105,car=0..1,boro=",//
					})
					public class tw_InBondedParty {

						public tw_InBondedParty() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "In Bonded Party. Bonded. Identifier", uid = "TW032", cls = "In Bonded Party")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=,chn=進倉保稅倉庫業者統一編號",//
								"name=NX5105,car=1,boro=,chn=進倉保稅倉庫業者統一編號",//
						})
						public String tw_BondedID;

						@DSREF(den = "In Bonded Party. Identification. Identifier", uid = "L019", cls = "In Bonded Party")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=*,chn=進倉保稅倉庫代碼",//
								"name=NX5105,car=1,boro=*,chn=進倉保稅倉庫代碼",//
						})
						public String tw_ID;

						@DSREF(den = "In Bonded Party. Type. Code", uid = "TW104", cls = "In Bonded Party")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=,chn=身分識別代碼",//
								"name=NX5105,car=1,boro=,chn=身分識別代碼",//
						})
						public String tw_TypeCode;

						public Warehouse Warehouse = new Warehouse();

						@DSREF(cls = "Warehouse")
						public class Warehouse {

							public Warehouse() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Warehouse. Arrival. Date Time", uid = "221", cls = "Warehouse")
							public String ArrivalDateTime;

							@DSREF(den = "Warehouse. Identification. Identifier", uid = "L019", cls = "Warehouse")
							public String ID;

							@DSREF(den = "Warehouse. Name. Text", uid = "L018", cls = "Warehouse")
							public String Name;

							@DSREF(den = "Warehouse. Storage Area. Code", uid = "TW063", cls = "Warehouse")
							public String tw_StorageAreaCode;

							@DSREF(den = "Warehouse. Storage Location. Text", uid = "TW065", cls = "Warehouse")
							public String tw_StorageLocation;

						}

					}

					public tw_OutBondedParty tw_OutBondedParty = new tw_OutBondedParty();

					@DSREF(cls = "Out Bonded Party")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=",//
							"name=NX5105,car=0..1,boro=",//
					})
					public class tw_OutBondedParty {

						public tw_OutBondedParty() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Out Bonded Party. Bonded. Identifier", uid = "TW059", cls = "Out Bonded Party")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=,chn=出倉保稅倉庫業者統一編號",//
								"name=NX5105,car=1,boro=,chn=出倉保稅倉庫業者統一編號",//
						})
						public String tw_BondedID;

						@DSREF(den = "Out Bonded Party. Identification. Identifier", uid = "L019", cls = "Out Bonded Party")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=*,chn=出倉保稅倉庫代碼",//
								"name=NX5105,car=1,boro=*,chn=出倉保稅倉庫代碼",//
						})
						public String tw_ID;

						@DSREF(den = "Out Bonded Party. Type. Code", uid = "TW104", cls = "Out Bonded Party")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=,chn=身分識別代碼",//
								"name=NX5105,car=1,boro=,chn=身分識別代碼",//
						})
						public String tw_TypeCode;

						public Warehouse Warehouse = new Warehouse();

						@DSREF(cls = "Warehouse")
						public class Warehouse {

							public Warehouse() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Warehouse. Arrival. Date Time", uid = "221", cls = "Warehouse")
							public String ArrivalDateTime;

							@DSREF(den = "Warehouse. Identification. Identifier", uid = "L019", cls = "Warehouse")
							public String ID;

							@DSREF(den = "Warehouse. Name. Text", uid = "L018", cls = "Warehouse")
							public String Name;

							@DSREF(den = "Warehouse. Storage Area. Code", uid = "TW063", cls = "Warehouse")
							public String tw_StorageAreaCode;

							@DSREF(den = "Warehouse. Storage Location. Text", uid = "TW065", cls = "Warehouse")
							public String tw_StorageLocation;

						}

					}

					public tw_PreBondedParty tw_PreBondedParty = new tw_PreBondedParty();

					@DSREF(cls = "PreBonded Party")
					@AAA(msg = {
					//
					"name=NX5105,car=0..9,boro=",//
					})
					public class tw_PreBondedParty {

						public tw_PreBondedParty() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "PreBonded Party. Customs Control. Identifier", uid = "TW003", cls = "PreBonded Party")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=海關監管編號",//
						})
						public String tw_CustomsControlID;

						@DSREF(den = "PreBonded Party. Identification. Identifier", uid = "TW031", cls = "PreBonded Party")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=原出口保稅廠商統一編號",//
						})
						public String tw_ID;

						@DSREF(den = "PreBonded Party. Type. Code", uid = "TW104", cls = "PreBonded Party")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=身分識別代碼",//
						})
						public String tw_TypeCode;

					}

				}

				public UltimateConsignee UltimateConsignee = new UltimateConsignee();

				@DSREF(cls = "Ultimate Consignee")
				public class UltimateConsignee {

					public UltimateConsignee() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Ultimate Consignee. Identification. Identifier", uid = "R061", cls = "Ultimate Consignee")
					public String ID;
					@DSREF(den = "Ultimate Consignee. Name. Text", uid = "R060", cls = "Ultimate Consignee")
					public String Name;
					public Address Address = new Address();

					@DSREF(cls = "Address")
					public class Address {

						public Address() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
						public String CityName;
						@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
						public String CountryCode;
						@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
						public String CountrySubDivisionID;
						@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
						public String CountrySubDivisionName;
						@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
						public String Line;
						@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
						public String PostcodeID;
					}

					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}

					public Contact Contact = new Contact();

					@DSREF(cls = "Contact")
					public class Contact {

						public Contact() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
						public String Name;
						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}
					}
				}

				public UnloadingLocation UnloadingLocation = new UnloadingLocation();

				@DSREF(cls = "Unloading Location")
				@AAA(msg = {
						//
						"name=N5201,car=0..1,boro=",//
						"name=N5202,car=0..1,boro=#",//
						"name=N5203,car=1,boro=",//
						"name=N5205,car=1,boro=",//
						"name=NX201_01,car=0..1,boro=",//
						"name=NX201_07,car=0..1,boro=",//
						"name=NX202,car=0..1,boro=",//
						"name=NX801,car=0..1,boro=",//
				})
				public class UnloadingLocation {

					public UnloadingLocation() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Unloading Location. Arrival. Date Time", uid = "173", cls = "Unloading Location")
					public String ArrivalDateTime;

					@DSREF(den = "Unloading Location. Identification. Identifier", uid = "L013", cls = "Unloading Location")
					@AAA(msg = {
							//
							"name=N5202,car=1,boro=,chn=國外卸貨港代碼",//
							"name=N5203,car=1,boro=,chn=目的地代碼",//
							"name=N5205,car=1,boro=,chn=目的地代碼",//
							"name=NX201_01,car=1,boro=,chn=目的地代碼",//
							"name=NX801,car=1,boro=,chn=目的地代碼",//
					})
					public String ID;

				}
			}

			public Consignor Consignor = new Consignor();

			@DSREF(cls = "Consignor")
			@AAA(msg = {
					//
					"name=N5203,car=0..1,boro=",//
					"name=NX5105,car=0..1,boro=",//
			})
			public class Consignor {

				public Consignor() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Consignor. Identification. Identifier", uid = "R021", cls = "Consignor")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=,chn=發貨人代碼",//
						"name=NX5105,car=0..1,boro=,chn=發貨人代碼",//
				})
				public String ID;

				@DSREF(den = "Consignor. Name. Text", uid = "R020", cls = "Consignor")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=,chn=發貨人英文名稱",//
						"name=NX5105,car=0..1,boro=,chn=發貨人英文名稱",//
				})
				public String Name;

				@DSREF(den = "Consignor. Chinese Name. Text", uid = "TW009", cls = "Consignor")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=,chn=發貨人中文名稱",//
						"name=NX5105,car=0..1,boro=,chn=發貨人中文名稱",//
				})
				public String tw_ChineseName;

				@DSREF(den = "Consignor. Type. Code", uid = "TW104", cls = "Consignor")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=,chn=身分識別代碼",//
						"name=NX5105,car=0..1,boro=,chn=身分識別代碼",//
				})
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=",//
						"name=NX5105,car=0..1,boro=",//
				})
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;

					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=,chn=發貨人英文地址",//
							"name=NX5105,car=0..1,boro=,chn=發貨人英文地址",//
					})
					public String Line;

					@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=,chn=發貨人中文地址",//
							"name=NX5105,car=0..1,boro=,chn=發貨人中文地址",//
					})
					public String tw_ChineseLine;

					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public Control2 Control2 = new Control2();

			@DSREF(cls = "Control")
			public class Control2 {

				public Control2() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Control. Inspection End. Date Time", uid = "356", cls = "Control")
				public String InspectionEndDateTime;
				@DSREF(den = "Control. Inspection Start. Date Time", uid = "355", cls = "Control")
				public String InspectionStartDateTime;
				@DSREF(den = "Control. Time-Limit. Date Time", uid = "264", cls = "Control")
				public String LimitDateTime;
				@DSREF(den = "Control. Review Place. Identifier", uid = "289", cls = "Control")
				public String ReviewPlaceID;

			}

			public CurrencyExchange_Added CurrencyExchange = new CurrencyExchange_Added();

			@DSREF(cls = "Currency Exchange")
			@AAA(msg = {
			//
			"name=N5135,car=0..1,boro=+",//
			})
			public class CurrencyExchange_Added {

				public CurrencyExchange_Added() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Currency Exchange. Currency Type. Code", uid = "135", cls = "Currency Exchange")
				@AAA(msg = {
				//
				"name=N5135,car=1,boro=,chn=幣別代碼",//
				})
				public String CurrencyTypeCode;

				@DSREF(den = "Currency Exchange. Rate. Numeric", uid = "118", cls = "Currency Exchange")
				public String RateRate;

			}

			public CustomsValuation CustomsValuation = new CustomsValuation();

			@DSREF(cls = "Customs Valuation")
			@AAA(msg = {
					//
					"name=N5110,car=1,boro=",//
					"name=N5135,car=0..1,boro=",//
					"name=N5203,car=0..1,boro=",//
					"name=NX5105,car=1,boro=",//
			})
			public class CustomsValuation {

				public CustomsValuation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Customs Valuation. Charges Type. Code", uid = "371", cls = "Customs Valuation")
				public String ChargesTypeCode;

				@DSREF(den = "Customs Valuation. Exit To Entry Charge. Amount", uid = "121", cls = "Customs Valuation")
				@AAA(msg = {
						//
						"name=N5135,car=0..1,boro=,chn=保險費",//
						"name=N5203,car=0..1,boro=#,chn=保險費",//
						"name=NX5105,car=0..1,boro=,chn=保險費",//
				})
				public String ExitToEntryChargeAmount;

				@DSREF(den = "Customs Valuation. Freight Charge. Amount", uid = "117", cls = "Customs Valuation")
				@AAA(msg = {
						//
						"name=N5135,car=0..1,boro=,chn=運費",//
						"name=N5203,car=0..1,boro=,chn=運費",//
						"name=NX5105,car=0..1,boro=,chn=運費",//
				})
				public String FreightChargeAmount;

				@DSREF(den = "Customs Valuation. Other Charge Deduction. Amount", uid = "181", cls = "Customs Valuation")
				@AAA(msg = {
						//
						"name=N5110,car=1,boro=,chn=營業稅稅基",//
						"name=N5135,car=0..1,boro=,chn=營業稅稅基",//
						"name=NX5105,car=1,boro=,chn=營業稅稅基",//
				})
				public String OtherChargeDeductionAmount;

				@DSREF(den = "Customs Valuation. Party Relationship. Code", uid = "163", cls = "Customs Valuation")
				@AAA(msg = {
				//
				"name=NX5105,car=1,boro=,chn=特殊關係",//
				})
				public String PartyRelationshipCode;

				@DSREF(den = "Customs Valuation. Other Charge. Amount", uid = "TW081", cls = "Customs Valuation")
				@AAA(msg = {
						//
						"name=N5135,car=0..1,boro=,chn=應加費用",//
						"name=N5203,car=0..1,boro=,chn=應加費用",//
						"name=NX5105,car=0..1,boro=,chn=應加費用",//
				})
				public String tw_OtherChargeAmount;

				@DSREF(den = "Customs Valuation. Other Charge. Amount", uid = "TW081", cls = "Customs Valuation")
				public String tw_OtherAddChargeDeductionAmount;

				@DSREF(den = "Customs Valuation. Other Deduction. Amount", uid = "TW082", cls = "Customs Valuation")
				@AAA(msg = {
						//
						"name=N5135,car=0..1,boro=,chn=應減費用",//
						"name=N5203,car=0..1,boro=,chn=應減費用",//
						"name=NX5105,car=0..1,boro=,chn=應減費用",//
				})
				public String tw_OtherDeductionAmount;

				@DSREF(den = "Customs Valuation. Other Deduction. Amount", uid = "TW082", cls = "Customs Valuation")
				public String tw_OtherChargeDeductionAmount;

				@DSREF(den = "Customs Valuation. Freight Charge Apportionment. Code", uid = "124", cls = "Customs Valuation")
				public String FreightChargeApportionmentCode;
				@DSREF(den = "Customs Valuation. Method. Code", uid = "122", cls = "Customs Valuation")
				public String MethodCode;

				@DSREF(den = "Customs Valuation. Total Duty Tax Fee. Amount", uid = "TW029", cls = "Customs Valuation")
				@AAA(msg = {
				//
				"name=N5135,car=0..1,boro=,chn=稅費合計",//
				})
				public String tw_TotalDutyTaxFeeAmount;

				@DSREF(den = "Customs Valuation. Payment Terms. Code", uid = "301", cls = "Customs Valuation")
				public String PaymentTermsCode;
			}

			public DeliveryDestinationParty DeliveryDestinationParty = new DeliveryDestinationParty();

			@DSREF(cls = "Delivery Destination")
			@AAA(msg = {
					//
					"name=N5203,car=0..1,boro=",//
					"name=NX5105,car=0..1,boro=",//
			})
			public class DeliveryDestinationParty {

				public DeliveryDestinationParty() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Delivery Destination. Identification. Identifier", uid = "R028", cls = "Delivery Destination")
				public String ID;

				@DSREF(den = "Delivery Destination. Name. Text", uid = "R027", cls = "Delivery Destination")
				@AAA(msg = {
						//
						"name=N5203,car=1,boro=,chn=運送抵達地",//
						"name=NX5105,car=1,boro=,chn=運送抵達地",//
				})
				public String Name;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;
					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;
					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public Distributor Distributor = new Distributor();

			@DSREF(cls = "Distributor")
			public class Distributor {

				public Distributor() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Distributor. Identification. Identifier", uid = "R030", cls = "Distributor")
				public String ID;
				@DSREF(den = "Distributor. Name. Text", uid = "R029", cls = "Distributor")
				public String Name;
				public Address Address = new Address();

				@DSREF(cls = "Address")
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;
					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;
					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public DutyTaxFee DutyTaxFee = new DutyTaxFee();

			@DSREF(cls = "Duty Tax Fee")
			@AAA(msg = {
					//
					"name=N5110,car=1..9,boro=#",//
					"name=N5135,car=0..9,boro=#",//
					"name=NX5105,car=1..9,boro=#",//
			})
			public class DutyTaxFee {

				public DutyTaxFee() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Duty Tax Fee. AdValorem Tax Base. Amount", uid = "116", cls = "Duty Tax Fee")
				@AAA(msg = {
						//
						"name=N5110,car=1,boro=,chn=稅費金額",//
						"name=N5135,car=1,boro=,chn=稅費金額",//
						"name=NX5105,car=1,boro=,chn=稅費金額",//
				})
				public String AdValoremTaxBaseAmount;

				@DSREF(den = "Duty Tax Fee. Deduct. Amount", uid = "111", cls = "Duty Tax Fee")
				public String DeductAmount;

				@DSREF(den = "Duty Tax Fee. Deduction. Quantity", uid = "127", cls = "Duty Tax Fee")
				public String DeductionQuantity;

				@DSREF(den = "Duty Tax Fee. Duty Regime. Code", uid = "164", cls = "Duty Tax Fee")
				public String DutyRegimeCode;

				@DSREF(den = "Duty Tax Fee. Elected Entry. Date Time", uid = "272", cls = "Duty Tax Fee")
				public String ElectedEntryDateTime;

				@DSREF(den = "Duty Tax Fee. Specific Tax Base. Quantity", uid = "129", cls = "Duty Tax Fee")
				public String SpecificTaxBaseQuantity;

				@DSREF(den = "Duty Tax Fee. Taxation. Date Time", uid = "382", cls = "Duty Tax Fee")
				public String TaxationDateTime;

				@DSREF(den = "Duty Tax Fee. Tax Rate. Numeric", uid = "115", cls = "Duty Tax Fee")
				public String TaxRate;

				@DSREF(den = "Duty Tax Fee. Type. Code", uid = "113", cls = "Duty Tax Fee")
				@AAA(msg = {
						//
						"name=N5110,car=1,boro=,chn=稅費代號",//
						"name=N5135,car=1,boro=,chn=稅費代號",//
						"name=NX5105,car=1,boro=,chn=稅費代號",//
				})
				public String TypeCode;

				public Payment Payment = new Payment();

				@DSREF(cls = "Payment")
				public class Payment {

					public Payment() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Payment. Method. Code", uid = "107", cls = "Payment")
					public String MethodCode;

					@DSREF(den = "Payment. Payment. Amount", uid = "378", cls = "Payment")
					public String PaymentAmount;

					@DSREF(den = "Payment. Due. Date Time", uid = "376", cls = "Payment")
					public String DueDateTime;

					@DSREF(den = "Payment. Reference. Identifier", uid = "014", cls = "Payment")
					public String ReferenceID;

					@DSREF(den = "Payment. Tax Assessed. Amount", uid = "120", cls = "Payment")
					public String TaxAssessedAmount;
				}
			}

			public EntryOffice EntryOffice = new EntryOffice();

			@DSREF(cls = "Entry Office")
			@AAA(msg = {
					//
					"name=N5101,car=1,boro=#",//
					"name=N5102,car=1,boro=#",//
					"name=N5103,car=1,boro=#",//
					"name=N5162,car=1,boro=#",//
					"name=N5202,car=1,boro=#",//
					"name=N5251,car=1,boro=#",//
					"name=N5252,car=1,boro=#",//
			})
			public class EntryOffice {

				public EntryOffice() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Entry Office. Identification. Identifier", uid = "G004", cls = "Entry Office")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=,chn=受理艙單關別代碼",//
						"name=N5102,car=1,boro=,chn=受理艙單關別代碼",//
						"name=N5162,car=1,boro=,chn=受理艙單關別代碼",//
						"name=N5202,car=1,boro=,chn=受理艙單關別代碼",//
						"name=N5251,car=1,boro=,chn=受理艙單關別代碼",//
						"name=N5252,car=1,boro=,chn=受理艙單關別代碼",//
				})
				public String ID;
			}

			public ExitOffice ExitOffice = new ExitOffice();

			@DSREF(cls = "Exit Office")
			public class ExitOffice {

				public ExitOffice() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Exit Office. Identification. Identifier", uid = "G005", cls = "Exit Office")
				public String ID;
			}

			public Exporter Exporter = new Exporter();

			@DSREF(cls = "Exporter")
			@AAA(msg = {
					//
					"name=N5109,car=0..1,boro=",//
					"name=N5203,car=1,boro=",//
					"name=N5204,car=1,boro=",//
					"name=N5205,car=1,boro=",//
					"name=NX801,car=0..1,boro=",//
			})
			public class Exporter {

				public Exporter() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Exporter. Identification. Identifier", uid = "R032", cls = "Exporter")
				@AAA(msg = {
						//
						"name=N5109,car=0..1,boro=,chn=出口人(貨物輸出人)統一編號",//
						"name=N5203,car=1,boro=,chn=出口人(貨物輸出人)統一編號",//
						"name=N5204,car=1,boro=,chn=出口人(貨物輸出人)統一編號",//
						"name=N5205,car=1,boro=,chn=出口人(貨物輸出人)統一編號",//
						"name=NX801,car=0..1,boro=,chn=出口人(貨物輸出人)統一編號",//
				})
				public String ID;

				@DSREF(den = "Exporter. Name. Text", uid = "R031", cls = "Exporter")
				@AAA(msg = {
						//
						"name=N5109,car=0..1,boro=,chn=出口人(貨物輸出人)英文名稱",//
						"name=N5203,car=1,boro=,chn=出口人(貨物輸出人)英文名稱",//
						"name=N5204,car=1,boro=,chn=出口人(貨物輸出人)英文名稱",//
						"name=N5205,car=0..1,boro=,chn=出口人(貨物輸出人)英文名稱",//
						"name=NX801,car=1,boro=,chn=出口人(貨物輸出人)英文名稱",//
				})
				public String Name;

				@DSREF(den = "Exporter. Chinese Name. Text", uid = "TW039", cls = "Exporter")
				@AAA(msg = {
						//
						"name=N5109,car=0..1,boro=,chn=出口人(貨物輸出人)中文名稱",//
						"name=N5205,car=0..1,boro=,chn=出口人(貨物輸出人)中文名稱",//
						"name=NX801,car=0..1,boro=,chn=出口人(貨物輸出人)中文名稱",//
				})
				public String tw_ChineseName;

				@DSREF(den = "Exporter. Customs Control. Identifier", uid = "TW003", cls = "Exporter")
				@AAA(msg = {
				//
				"name=N5203,car=0..1,boro=,chn=海關監管編號",//
				})
				public String tw_CustomsControlID;

				@DSREF(den = "Exporter. Payment On Account Business. Identifier", uid = "TW142", cls = "Exporter")
				@AAA(msg = {
				//
				"name=N5203,car=0..1,boro=,chn=營業稅記帳廠商編號",//
				})
				public String tw_PaymentOnAccountBusinessID;

				@DSREF(den = "Exporter. Type. Code", uid = "TW104", cls = "Exporter")
				@AAA(msg = {
						//
						"name=N5109,car=0..1,boro=,chn=身分識別代碼",//
						"name=N5203,car=1,boro=,chn=身分識別代碼",//
						"name=N5204,car=1,boro=,chn=身分識別代碼",//
						"name=N5205,car=1,boro=,chn=身分識別代碼",//
						"name=NX801,car=0..1,boro=,chn=身分識別代碼",//
				})
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=",//
						"name=N5205,car=0..1,boro=",//
						"name=NX801,car=0..1,boro=",//
				})
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;

					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;

					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=出口人(貨物輸出人)英文地址",//
							"name=N5205,car=1,boro=,chn=出口人(貨物輸出人)英文地址",//
							"name=NX801,car=1,boro=,chn=出口人(貨物輸出人)英文地址",//
					})
					public String Line;

					@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
					@AAA(msg = {
							//
							"name=N5205,car=0..1,boro=,chn=出口人(貨物輸出人)中文地址",//
							"name=NX801,car=0..1,boro=,chn=出口人(貨物輸出人)中文地址",//
					})
					public String tw_ChineseLine;

				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;

				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public FreeTradeZone FreeTradeZone = new FreeTradeZone();

			@DSREF(cls = "Free Trade Zone")
			@AAA(msg = {
					//
					"name=N5401,car=0..1,boro=",//
					"name=N5402,car=0..1,boro=",//
			})
			public class FreeTradeZone {

				public FreeTradeZone() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Free Trade Zone. Identification. Identifier", uid = "L066", cls = "Free Trade Zone")
				public String ID;
				@DSREF(den = "Free Trade Zone. Name. Text", uid = "L065", cls = "Free Trade Zone")
				public String Name;

				@DSREF(den = "Free Trade Zone. Operation Type. Code", uid = "TW073", cls = "Free Trade Zone")
				@AAA(msg = {
						//
						"name=N5401,car=1,boro=,chn=貨物出入區作業類別代碼",//
						"name=N5402,car=1,boro=,chn=貨物出入區作業類別代碼",//
				})
				public String tw_OperationTypeCode;
			}

			public GovernmentAgencyGoodsItem GovernmentAgencyGoodsItem = new GovernmentAgencyGoodsItem();

			@DSREF(cls = "Government Agency Goods Item")
			@AAA(msg = {
					//
					"name=N5101,car=1,boro=",//
					"name=N5102,car=1,boro=",//
					"name=N5107,car=0..99,boro=",//
					"name=N5108,car=1,boro=",//
					"name=N5109,car=1,boro=",//
					"name=N5110,car=1,boro=",//
					"name=N5111,car=1,boro=",//
					"name=N5116,car=1,boro=",//
					"name=N5117,car=1,boro=",//
					"name=N5135,car=1..9999,boro=",//
					"name=N5151,car=1,boro=",//
					"name=N5158,car=1,boro=",//
					"name=N5162,car=1,boro=",//
					"name=N5165,car=1,boro=#",//
					"name=N5166,car=1,boro=",//
					"name=N5167,car=1..9,boro=",//
					"name=N5168,car=1,boro=",//
					"name=N5201,car=1,boro=",//
					"name=N5202,car=1,boro=",//
					"name=N5203,car=1..9999,boro=",//
					"name=N5204,car=0..1,boro=",//
					"name=N5205,car=1..9999,boro=",//
					"name=N5251,car=1,boro=",//
					"name=N5252,car=1,boro=",//
					"name=N5262,car=1,boro=",//
					"name=N5301,car=1,boro=",//
					"name=N5302,car=1,boro=",//
					"name=N5401,car=1..9999,boro=",//
					"name=N5402,car=1..9999,boro=",//
					"name=N5403,car=1..50,boro=",//
					"name=N5404,car=1..9999,boro=",//
					"name=NX201_01,car=1..999,boro=",//
					"name=NX201_07,car=0..1,boro=",//
					"name=NX202,car=0..1,boro=",//
					"name=NX301,car=1..9999,boro=",//
					"name=NX301_DN,car=1..9999,boro=",//
					"name=NX302,car=0..9999,boro=",//
					"name=NX302_DN,car=0..9999,boro=",//
					"name=NX401,car=1..9999,boro=",//
					"name=NX402,car=0..9999,boro=",//
					"name=NX5105,car=1..9999,boro=",//
					"name=NX5106,car=0..9999,boro=",//
					"name=NX601,car=1..9999,boro=",//
					"name=NX602,car=0..9999,boro=",//
					"name=NX603,car=1..9999,boro=",//
					"name=NX801,car=0..9999,boro=",//
					"name=NX802,car=0..9999,boro=",//
					"name=NX901,car=0..9999,boro=",//
					"name=NX902,car=1,boro=",//
					"name=NX903,car=1,boro=",//
			})
			public class GovernmentAgencyGoodsItem {

				public GovernmentAgencyGoodsItem() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Government Agency Goods Item. Customs Value. Amount", uid = "108", cls = "Government Agency Goods Item")
				public String CustomsValueAmount;

				@DSREF(den = "Government Agency Goods Item. Sequence. Numeric", uid = "006", cls = "Government Agency Goods Item")
				@AAA(msg = {
						//
						"name=N5107,car=1,boro=,chn=項次",//
						"name=N5135,car=1,boro=,chn=項次",//
						"name=N5203,car=1,boro=,chn=項次",//
						"name=N5205,car=1,boro=,chn=項次",//
						"name=N5401,car=1,boro=,chn=項次",//
						"name=N5402,car=1,boro=,chn=項次",//
						"name=N5403,car=1,boro=,chn=項次",//
						"name=NX201_01,car=0..1,boro=,chn=項次",//
						"name=NX301,car=1,boro=,chn=項次",//
						"name=NX301_DN,car=1,boro=,chn=項次",//
						"name=NX302,car=1,boro=,chn=項次",//
						"name=NX302_DN,car=1,boro=,chn=項次",//
						"name=NX401,car=1,boro=,chn=項次",//
						"name=NX402,car=1,boro=,chn=項次",//
						"name=NX5105,car=1,boro=,chn=項次",//
						"name=NX5106,car=1,boro=,chn=項次",//
						"name=NX601,car=1,boro=,chn=項次",//
						"name=NX602,car=1,boro=,chn=項次",//
						"name=NX603,car=1,boro=,chn=項次",//
						"name=NX801,car=1,boro=,chn=項次",//
						"name=NX802,car=1,boro=,chn=項次",//
						"name=NX901,car=0..1,boro=,chn=項次",//
				})
				public String SequenceNumeric;

				@DSREF(den = "Government Agency Goods Item. Statistical Value. Amount", uid = "114", cls = "Government Agency Goods Item")
				public String StatisticalValueAmount;

				@DSREF(den = "Government Procedure. Goods Status. Code", uid = "094", cls = "Government Procedure")
				public String tw_GoodsStatusCode;

				@DSREF(den = "Government Agency Goods Item. Item Group. Identifier", uid = "TW_101", cls = "Government Agency Goods Item")
				public String tw_ItemGroupID;

				public AdditionalDocument AdditionalDocument = new AdditionalDocument();

				@DSREF(cls = "Additional Document")
				@AAA(msg = {
						//
						"name=N5101,car=1,boro=",//
						"name=N5102,car=1,boro=",//
						"name=N5107,car=1..9,boro=",//
						"name=N5108,car=1,boro=",//
						"name=N5109,car=1,boro=",//
						"name=N5110,car=1,boro=",//
						"name=N5111,car=1,boro=",//
						"name=N5116,car=1,boro=",//
						"name=N5117,car=1,boro=",//
						"name=N5135,car=1,boro=",//
						"name=N5151,car=1,boro=",//
						"name=N5158,car=1,boro=",//
						"name=N5162,car=1,boro=",//
						"name=N5165,car=1..999,boro=#",//
						"name=N5166,car=1,boro=",//
						"name=N5167,car=1,boro=",//
						"name=N5168,car=1,boro=",//
						"name=N5201,car=1,boro=",//
						"name=N5202,car=1,boro=",//
						"name=N5203,car=0..10,boro=",//
						"name=N5204,car=0..5,boro=",//
						"name=N5205,car=1,boro=",//
						"name=N5251,car=1,boro=",//
						"name=N5252,car=1,boro=",//
						"name=N5262,car=1,boro=",//
						"name=N5301,car=1,boro=",//
						"name=N5302,car=1,boro=",//
						"name=N5401,car=1,boro=",//
						"name=N5402,car=1,boro=",//
						"name=N5403,car=1,boro=",//
						"name=N5404,car=1,boro=",//
						"name=NX201_01,car=1,boro=",//
						"name=NX201_07,car=0..1,boro=",//
						"name=NX202,car=0..1,boro=",//
						"name=NX301,car=1..5,boro=",//
						"name=NX301_DN,car=1..5,boro=",//
						"name=NX401,car=1,boro=",//
						"name=NX402,car=1,boro=",//
						"name=NX5105,car=0..5,boro=",//
						"name=NX601,car=1..5,boro=",//
						"name=NX603,car=1..5,boro=",//
						"name=NX801,car=0..5,boro=",//
						"name=NX802,car=0..5,boro=",//
						"name=NX901,car=0..1,boro=",//
				})
				public class AdditionalDocument {

					public AdditionalDocument() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Additional Document. Authentication Location Name. Text", uid = "D017", cls = "Additional Document")
					public String AuthenticationLocationName;

					@DSREF(den = "Additional Document. Identification. Identifier", uid = "D005", cls = "Additional Document")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=主管機關指定代號",//
							"name=NX5105,car=0..1,boro=,chn=輸出入許可文件號碼",//
							"name=NX801,car=1,boro=,chn=輸出入許可文件號碼",//
							"name=NX802,car=1,boro=,chn=輸出入許可文件號碼",//
					})
					public String ID;

					@DSREF(den = "Additional Document. Sequence. Numeric", uid = "006", cls = "Additional Document")
					@AAA(msg = {
							//
							"name=NX201_01,car=1,boro=*,chn=輸出入許可文件項次",//
							"name=NX401,car=1,boro=*,chn=輸出入許可文件項次",//
							"name=NX5105,car=0..1,boro=*,chn=輸出入許可文件項次",//
							"name=NX801,car=0..1,boro=*,chn=輸出入許可文件項次",//
							"name=NX802,car=0..1,boro=*,chn=輸出入許可文件項次",//
							"name=NX901,car=1,boro=*,chn=輸出入許可文件項次",//
					})
					public String tw_SequenceNumeric;

					@DSREF(den = "Additional Document. Issue. Date Time", uid = "D002", cls = "Additional Document")
					public String IssueDateTime;
					@DSREF(den = "Additional Document. Issue Location. Text", uid = "D003", cls = "Additional Document")
					public String IssueLocation;
					@DSREF(den = "Additional Document. LPCO Effective. Date Time", uid = "276", cls = "Additional Document")
					public String LPCOEffectiveDateTime;
					@DSREF(den = "Additional Document. LPCO Exemption. Code", uid = "360", cls = "Additional Document")
					public String LPCOExemptionCode;
					@DSREF(den = "Additional Document. LPCO Expiration. Date Time", uid = "275", cls = "Additional Document")
					public String LPCOExpirationDateTime;
					@DSREF(den = "Additional Document. Quantity. Quantity", uid = "313", cls = "Additional Document")
					public String QuantityQuantity;

					@DSREF(den = "Additional Document. Statement Description. Text", uid = "225", cls = "Additional Document")
					@AAA(msg = {
					//
					"name=NX802,car=0..1,boro=*,chn=輸出入許可文件項次會辦結果說明",//
					})
					public String tw_StatementDescription;

					@DSREF(den = "Additional Document. Type. Text", uid = "185", cls = "Additional Document")
					public String Type;

					@DSREF(den = "Additional Document. Type. Code", uid = "D006", cls = "Additional Document")
					public String TypeCode;

					public Authenticator Authenticator = new Authenticator();

					@DSREF(cls = "Authenticator")
					public class Authenticator {

						public Authenticator() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Authenticator. Identification. Identifier", uid = "R008", cls = "Authenticator")
						public String ID;
						@DSREF(den = "Authenticator. Name. Text", uid = "R007", cls = "Authenticator")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public GovernmentProcedure GovernmentProcedure = new GovernmentProcedure();

					@DSREF(cls = "Government Procedure")
					public class GovernmentProcedure {

						public GovernmentProcedure() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Government Procedure. Current. Code", uid = "166", cls = "Government Procedure")
						public String CurrentCode;

					}

					public LPCOAuthorizedParty LPCOAuthorizedParty = new LPCOAuthorizedParty();

					@DSREF(cls = "LPCO Authorized Party")
					public class LPCOAuthorizedParty {

						public LPCOAuthorizedParty() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "LPCO Authorized Party. Identification. Identifier", uid = "R086", cls = "LPCO Authorized Party")
						public String ID;
						@DSREF(den = "LPCO Authorized Party. Name. Text", uid = "R087", cls = "LPCO Authorized Party")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public Submitter Submitter = new Submitter();

					@DSREF(cls = "Submitter")
					public class Submitter {

						public Submitter() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Submitter. Identification. Identifier", uid = "R059", cls = "Submitter")
						public String ID;
						@DSREF(den = "Submitter. Name. Text", uid = "R058", cls = "Submitter")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public tw_LicensingItemCheck tw_LicensingItemCheck = new tw_LicensingItemCheck();

					@DSREF(cls = "Licensing Item Check")
					@AAA(msg = {
					//
					"name=NX802,car=0..99,boro=",//
					})
					public class tw_LicensingItemCheck {

						public tw_LicensingItemCheck() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Licensing Item Check. Criteria Conformance. Text", uid = "304", cls = "Licensing Item Check")
						@AAA(msg = {
						//
						"name=NX802,car=0..1,boro=*,chn=報單欄位申報資料",//
						})
						public String tw_CriteriaConformance;

						@DSREF(den = "Licensing Item Check. Statement Description. Text", uid = "225", cls = "Licensing Item Check")
						@AAA(msg = {
						//
						"name=NX802,car=0..1,boro=*,chn=簽審文件資料",//
						})
						public String tw_StatementDescription;

						@DSREF(den = "Licensing Item Check. Validation. Code", uid = "377", cls = "Licensing Item Check")
						@AAA(msg = {
						//
						"name=NX802,car=1,boro=*,chn=項次會辦結果代碼",//
						})
						public String tw_ValidationCode;
					}

				}

				public AdditionalInformation AdditionalInformation = new AdditionalInformation();

				@DSREF(cls = "Additional Information")
				@AAA(msg = {
						//
						"name=N5107,car=0..9,boro=",//
						"name=N5203,car=0..10,boro=",//
						"name=NX301,car=0..10,boro=",//
						"name=NX301_DN,car=0..10,boro=",//
						"name=NX302,car=0..1,boro=",//
						"name=NX302_DN,car=0..1,boro=",//
						"name=NX401,car=0..10,boro=",//
						"name=NX402,car=0..99,boro=",//
						"name=NX5105,car=0..10,boro=",//
						"name=NX601,car=0..10,boro=",//
						"name=NX602,car=0..1,boro=",//
						"name=NX603,car=0..10,boro=",//
						"name=NX901,car=0..1,boro=",//
				})
				public class AdditionalInformation {

					public AdditionalInformation() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Additional Information. Content. Text", uid = "105", cls = "Additional Information")
					@AAA(msg = {
							//
							"name=NX302,car=1,boro=,chn=說明",//
							"name=NX302_DN,car=1,boro=,chn=說明",//
							"name=NX602,car=1,boro=,chn=說明",//
							"name=NX901,car=1,boro=,chn=說明",//
					})
					public String Content;

					@DSREF(den = "Additional Information. Limit. Date Time", uid = "264", cls = "Additional Information")
					public String LimitDateTime;
					@DSREF(den = "Additional Information. Reconciliation Reason. Code", uid = "300", cls = "Additional Information")
					public String ReconciliationReasonCode;
					@DSREF(den = "Additional Information. Request Override. Code", uid = "095", cls = "Additional Information")
					public String RequestOverrideCode;
					@DSREF(den = "Additional Information. Requested Inspection. Date Time", uid = "220", cls = "Additional Information")
					public String RequestedInspectionDateTime;

					@DSREF(den = "Additional Information. Statement. Code", uid = "226", cls = "Additional Information")
					@AAA(msg = {
							//
							"name=N5107,car=1,boro=,chn=輸出入規定",//
							"name=N5203,car=1,boro=,chn=*備註類別代碼",//
							"name=NX301,car=1,boro=,chn=*備註類別代碼",//
							"name=NX301_DN,car=1,boro=,chn=*備註類別代碼",//
							"name=NX401,car=1,boro=,chn=*備註類別代碼",//
							"name=NX5105,car=1,boro=,chn=*備註類別代碼",//
							"name=NX601,car=1,boro=,chn=*備註類別代碼",//
							"name=NX603,car=1,boro=,chn=*備註類別代碼",//
					})
					public String StatementCode;

					@DSREF(den = "Additional Information. Statement Description. Text", uid = "225", cls = "Additional Information")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=備用欄位",//
							"name=NX301,car=1,boro=,chn=備用欄位",//
							"name=NX301_DN,car=1,boro=,chn=備用欄位",//
							"name=NX401,car=1,boro=,chn=備用欄位",//
							"name=NX5105,car=1,boro=,chn=備用欄位",//
							"name=NX601,car=1,boro=,chn=備用欄位",//
							"name=NX603,car=1,boro=,chn=備用欄位",//
					})
					public String StatementDescription;

					@DSREF(den = "Additional Information. Statement Type. Code", uid = "369", cls = "Additional Information")
					public String StatementTypeCode;
				}

				public ApprovedEstablishmentPlace ApprovedEstablishmentPlace = new ApprovedEstablishmentPlace();

				@DSREF(cls = "Approved Establishment Place")
				public class ApprovedEstablishmentPlace {

					public ApprovedEstablishmentPlace() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Approved Establishment Place. Identification. Identifier", uid = "L058", cls = "Approved Establishment Place")
					public String ID;
					@DSREF(den = "Approved Establishment Place. Name. Text", uid = "L057", cls = "Approved Establishment Place")
					public String Name;
				}

				public Commodity Commodity = new Commodity();

				@DSREF(cls = "Commodity")
				@AAA(msg = {
						//
						"name=N5109,car=0..1,boro=",//
						"name=N5110,car=1,boro=",//
						"name=N5116,car=1,boro=",//
						"name=N5135,car=1,boro=",//
						"name=N5203,car=1,boro=",//
						"name=N5204,car=0..1,boro=",//
						"name=N5205,car=1,boro=",//
						"name=N5401,car=1,boro=",//
						"name=N5402,car=1,boro=",//
						"name=NX201_01,car=1,boro=",//
						"name=NX201_07,car=0..1,boro=",//
						"name=NX202,car=0..1,boro=",//
						"name=NX301,car=1,boro=",//
						"name=NX301_DN,car=1,boro=",//
						"name=NX401,car=1,boro=",//
						"name=NX5105,car=1,boro=",//
						"name=NX601,car=1,boro=",//
						"name=NX603,car=1,boro=",//
						"name=NX801,car=1,boro=",//
						"name=NX802,car=0..1,boro=",//
				})
				public class Commodity {

					public Commodity() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Commodity. Category. Code", uid = "328", cls = "Commodity")
					public String CategoryCode;
					@DSREF(den = "Commodity. Category Qualifier. Code", uid = "329", cls = "Commodity")
					public String CategoryQualifierCode;
					@DSREF(den = "Commodity. Characteristic. Text", uid = "229", cls = "Commodity")
					public String Characteristic;
					@DSREF(den = "Commodity. Characteristic. Code", uid = "260", cls = "Commodity")
					public String CharacteristicCode;
					@DSREF(den = "Commodity. Characterisitc Qualifier. Code", uid = "334", cls = "Commodity")
					public String CharacterisitcQualifierCode;
					@DSREF(den = "Commodity. public classification Name. Code", uid = "346", cls = "Commodity")
					public String classificationNameCode;

					@DSREF(den = "Commodity. Commercial Categorization. Identifier", uid = "257", cls = "Commodity")
					@AAA(msg = {
							//
							"name=N5135,car=0..1,boro=,chn=型號",//
							"name=N5203,car=0..1,boro=,chn=型號",//
							"name=N5205,car=0..1,boro=,chn=型號",//
							"name=N5401,car=1,boro=,chn=型號",//
							"name=N5402,car=1,boro=,chn=型號",//
							"name=NX201_01,car=0..1,boro=,chn=型號",//
							"name=NX301,car=0..1,boro=,chn=型號",//
							"name=NX5105,car=0..1,boro=,chn=型號",//
							"name=NX601,car=0..1,boro=,chn=型號",//
							"name=NX603,car=0..1,boro=,chn=型號",//
							"name=NX801,car=0..1,boro=,chn=型號",//
					})
					public String CommercialCategorizationID;

					@DSREF(den = "Commodity. Commercial Description. Text", uid = "326", cls = "Commodity")
					public String CommercialDescription;
					@DSREF(den = "Commodity. Count. Quantity", uid = "315", cls = "Commodity")
					public String CountQuantity;
					@DSREF(den = "Commodity. Criteria Conformance. Text", uid = "304", cls = "Commodity")
					public String CriteriaConformance;
					@DSREF(den = "Commodity. Criteria Conformance. Code", uid = "305", cls = "Commodity")
					public String CriteriaConformanceCode;

					@DSREF(den = "Commodity. Description. Text", uid = "137", cls = "Commodity")
					@AAA(msg = {
							//
							"name=N5135,car=1,boro=,chn=貨物名稱",//
							"name=N5203,car=1,boro=,chn=貨物名稱",//
							"name=N5205,car=1,boro=,chn=貨物名稱",//
							"name=N5401,car=1,boro=,chn=貨物名稱",//
							"name=N5402,car=1,boro=,chn=貨物名稱",//
							"name=NX201_01,car=1,boro=,chn=貨物名稱",//
							"name=NX301,car=1,boro=,chn=貨物名稱",//
							"name=NX401,car=1,boro=,chn=貨物名稱",//
							"name=NX5105,car=1,boro=,chn=貨物名稱",//
							"name=NX601,car=1,boro=,chn=貨物名稱",//
							"name=NX603,car=1,boro=,chn=貨物名稱",//
							"name=NX801,car=1,boro=,chn=貨物名稱",//
					})
					public String Description;

					@DSREF(den = "Commodity. Goods Group Name. Text", uid = "331", cls = "Commodity")
					public String GoodsGroupName;

					@DSREF(den = "Commodity. Goods Group Name. Code", uid = "332", cls = "Commodity")
					@AAA(msg = {
							//
							"name=NX5105,car=0..1,boro=,chn=產品種類",//
							"name=NX601,car=1,boro=,chn=產品種類",//
					})
					public String GoodsGroupNameCode;

					@DSREF(den = "Commodity. Identification. Identifier", uid = "147", cls = "Commodity")
					@AAA(msg = {
							//
							"name=N5401,car=1,boro=,chn=料號",//
							"name=N5402,car=1,boro=,chn=料號",//
					})
					public String ID;

					@DSREF(den = "Commodity. Identifier Type. Code", uid = "338", cls = "Commodity")
					public String IDTypeCode;
					@DSREF(den = "Commodity. Identity Qualifier. Code", uid = "347", cls = "Commodity")
					public String IdentityQualifierCode;
					@DSREF(den = "Commodity. Intended Use. Text", uid = "327", cls = "Commodity")
					public String IntendedUse;
					@DSREF(den = "Commodity. Intended Use. Code", uid = "330", cls = "Commodity")
					public String IntendedUseCode;
					@DSREF(den = "Commodity. Jurisdiction. Date Time", uid = "274", cls = "Commodity")
					public String JurisdictionDateTime;

					@DSREF(den = "Commodity. Lot Number. Identifier", uid = "265", cls = "Commodity")
					public String LotNumberID;

					@DSREF(den = "Commodity. Name. Text", uid = "258", cls = "Commodity")
					@AAA(msg = {
							//
							"name=N5135,car=0..1,boro=,chn=商標(牌名)",//
							"name=N5203,car=1,boro=,chn=商標(牌名)",//
							"name=N5205,car=1,boro=,chn=商標(牌名)",//
							"name=NX201_01,car=0..1,boro=,chn=商標(牌名)",//
							"name=NX301,car=1,boro=,chn=商標(牌名)",//
							"name=NX5105,car=0..1,boro=,chn=商標(牌名)",//
							"name=NX603,car=1,boro=,chn=商標(牌名)",//
							"name=NX801,car=0..1,boro=,chn=商標(牌名)",//
					})
					public String Name;

					@DSREF(den = "Commodity. Name Qualifier. Code", uid = "335", cls = "Commodity")
					public String NameQualifierCode;
					@DSREF(den = "Commodity. Physical State. Code", uid = "325", cls = "Commodity")
					public String PhysicalStateCode;
					@DSREF(den = "Commodity. Process Duration. Date Time", uid = "269", cls = "Commodity")
					public String ProcessDurationDateTime;
					@DSREF(den = "Commodity. Process Type Description. Text", uid = "339", cls = "Commodity")
					public String ProcessTypeDescription;
					@DSREF(den = "Commodity. Process Type Identification. Code", uid = "340", cls = "Commodity")
					public String ProcessTypeIdentificationCode;
					@DSREF(den = "Commodity. Product Best Before. Date Time", uid = "266", cls = "Commodity")
					public String ProductBestBeforeDateTime;
					@DSREF(den = "Commodity. Product Expiry. Date Time", uid = "354", cls = "Commodity")
					public String ProductExpiryDateTime;
					@DSREF(den = "Commodity. Sequence. Numeric", uid = "006", cls = "Commodity")
					public String SequenceNumeric;
					@DSREF(den = "Commodity. Size. Measure", uid = "322", cls = "Commodity")
					public String SizeMeasure;
					@DSREF(den = "Commodity. Value. Amount", uid = "306", cls = "Commodity")
					public String ValueAmount;

					@DSREF(den = "Commodity. Bar Code. Text", uid = "TW079", cls = "Commodity")
					@AAA(msg = {
							//
							"name=NX5105,car=0..1,boro=,chn=商品條碼",//
							"name=NX601,car=0..1,boro=,chn=商品條碼",//
					})
					public String tw_BarCode;

					@DSREF(den = "Commodity. Bonded Note. Code", uid = "TW040", cls = "Commodity")
					@AAA(msg = {
					//
					"name=N5203,car=0..1,boro=,chn=保稅貨物註記",//
					})
					public String tw_BondedNoteCode;

					@DSREF(den = "Commodity. Chinese Description. Text", uid = "TW024", cls = "Commodity")
					@AAA(msg = {
							//
							"name=NX301,car=1,boro=,chn=貨物中文名稱(品名)",//
							"name=NX301_DN,car=0..1,boro=,chn=貨物中文名稱(品名)",//
							"name=NX401,car=0..1,boro=,chn=貨物中文名稱(品名)",//
							"name=NX5105,car=0..1,boro=,chn=貨物中文名稱(品名)",//
							"name=NX601,car=1,boro=,chn=貨物中文名稱(品名)",//
							"name=NX603,car=1,boro=,chn=貨物中文名稱(品名)",//
							"name=NX801,car=0..1,boro=,chn=貨物中文名稱(品名)",//
					})
					public String tw_ChineseDescription;

					@DSREF(den = "Commodity. CITES Import Permit. Identifier", uid = "TW113", cls = "Commodity")
					@AAA(msg = {
					//
					"name=NX5105,car=0..1,boro=,chn=華盛頓公約進口許可證號碼",//
					})
					public String tw_CITESPermit;

					@DSREF(den = "Commodity. FTA Tariff. Code", uid = "TW114", cls = "Commodity")
					@AAA(msg = {
					//
					"name=NX5105,car=0..1,boro=,chn=自由貿易協定優惠關稅註記",//
					})
					public String tw_FTANote;

					@DSREF(den = "Commodity. Level. Identifier", uid = "TW139", cls = "Commodity")
					public String tw_LevelID;

					@DSREF(den = "Commodity. Packaging Specification. Text", uid = "TW110", cls = "Commodity")
					public String tw_PackagingSpecification;

					@DSREF(den = "Commodity. Packaging Material. Code", uid = "TW112", cls = "Commodity")
					public String tw_PackagingMaterialCode;

					@DSREF(den = "Commodity. Product Manufactured. Date", uid = "TW057", cls = "Commodity")
					public String tw_ProductManufacturedDate;

					@DSREF(den = "Commodity. SHTC Import Permit. Identifier", uid = "TW118", cls = "Commodity")
					@AAA(msg = {
					//
					"name=NX5105,car=0..1,boro=,chn=戰略性高科技貨品國際進口證明號碼",//
					})
					public String tw_SHTCImportPermitID;

					@DSREF(den = "Commodity. Tariff Code Extension. Code", uid = "TW117", cls = "Commodity")
					@AAA(msg = {
							//
							"name=NX301,car=0..1,boro=,chn=貨品分類號列序號",//
							"name=NX5105,car=0..1,boro=,chn=貨品分類號列序號",//
							"name=NX601,car=0..1,boro=,chn=貨品分類號列序號",//
							"name=NX603,car=0..1,boro=,chn=貨品分類號列序號",//
					})
					public String tw_TariffCodeExtensions;

					@DSREF(den = "Commodity. Thickness. Text", uid = "TW140", cls = "Commodity")
					public String tw_Thickness;

					public AdditionalDocument AdditionalDocument = new AdditionalDocument();

					@DSREF(cls = "Additional Document")
					@AAA(msg = {
							//
							"name=N5203,car=0..5,boro=",//
							"name=N5204,car=0..5,boro=",//
							"name=NX201_01,car=0..1,boro=",//
							"name=NX201_07,car=0..1,boro=",//
							"name=NX202,car=0..1,boro=",//
							"name=NX301,car=0..5,boro=",//
							"name=NX301_DN,car=1..5,boro=",//
							"name=NX401,car=0..5,boro=",//
							"name=NX5105,car=0..10,boro=",//
							"name=NX601,car=0..5,boro=",//
							"name=NX603,car=0..5,boro=",//
							"name=NX802,car=0..5,boro=",//
					})
					public class AdditionalDocument {

						public AdditionalDocument() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Additional Document. Authentication Location Name. Text", uid = "D017", cls = "Additional Document")
						public String AuthenticationLocationName;

						@DSREF(den = "Additional Document. Identification. Identifier", uid = "D005", cls = "Additional Document")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=,chn=輸出入許可文件號碼",//
								"name=NX5105,car=1,boro=,chn=主管機關指定代號",//
						})
						public String ID;

						@DSREF(den = "Additional Document. Sequence. Numeric", uid = "006", cls = "Additional Document")
						@AAA(msg = {
								//
								"name=N5203,car=0..1,boro=*,chn=輸出入許可文件項次",//
								"name=NX201_01,car=1,boro=*,chn=對應專案函項次",//
						})
						public String tw_SequenceNumeric;

						@DSREF(den = "Additional Document. Statement Description. Text", uid = "225", cls = "Additional Information")
						public String tw_StatementDescription;

						@DSREF(den = "Additional Document. Issue. Date Time", uid = "D002", cls = "Additional Document")
						public String IssueDateTime;
						@DSREF(den = "Additional Document. Issue Location. Text", uid = "D003", cls = "Additional Document")
						public String IssueLocation;
						@DSREF(den = "Additional Document. LPCO Effective. Date Time", uid = "276", cls = "Additional Document")
						public String LPCOEffectiveDateTime;
						@DSREF(den = "Additional Document. LPCO Exemption. Code", uid = "360", cls = "Additional Document")
						public String LPCOExemptionCode;
						@DSREF(den = "Additional Document. LPCO Expiration. Date Time", uid = "275", cls = "Additional Document")
						public String LPCOExpirationDateTime;
						@DSREF(den = "Additional Document. Type. Text", uid = "185", cls = "Additional Document")
						public String Type;

						@DSREF(den = "Additional Document. Type. Code", uid = "D006", cls = "Additional Document")
						public String TypeCode;

						public Authenticator Authenticator = new Authenticator();

						@DSREF(cls = "Authenticator")
						public class Authenticator {

							public Authenticator() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Authenticator. Identification. Identifier", uid = "R008", cls = "Authenticator")
							public String ID;
							@DSREF(den = "Authenticator. Name. Text", uid = "R007", cls = "Authenticator")
							public String Name;
							public Address Address = new Address();

							@DSREF(cls = "Address")
							public class Address {

								public Address() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
								public String CityName;
								@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
								public String CountryCode;
								@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
								public String CountrySubDivisionID;
								@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
								public String CountrySubDivisionName;
								@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
								public String Line;
								@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
								public String PostcodeID;
							}

							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}

							public Contact Contact = new Contact();

							@DSREF(cls = "Contact")
							public class Contact {

								public Contact() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
								public String Name;
								public Communication Communication = new Communication();

								@DSREF(cls = "Communication")
								public class Communication {

									public Communication() {

									}

									public boolean hasMachedProps() {
										return new Worker(msgName).hasMachedProps(this);
									}

									public String getSchema() {
										return new Worker(msgName).getSchema(this);
									}

									@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
									public String ID;
									@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
									public String TypeID;
								}
							}
						}

						public LPCOAuthorizedParty LPCOAuthorizedParty = new LPCOAuthorizedParty();

						@DSREF(cls = "LPCO Authorized Party")
						public class LPCOAuthorizedParty {

							public LPCOAuthorizedParty() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "LPCO Authorized Party. Identification. Identifier", uid = "R086", cls = "LPCO Authorized Party")
							public String ID;
							@DSREF(den = "LPCO Authorized Party. Name. Text", uid = "R087", cls = "LPCO Authorized Party")
							public String Name;
							public Address Address = new Address();

							@DSREF(cls = "Address")
							public class Address {

								public Address() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
								public String CityName;
								@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
								public String CountryCode;
								@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
								public String CountrySubDivisionID;
								@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
								public String CountrySubDivisionName;
								@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
								public String Line;
								@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
								public String PostcodeID;
							}

							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}

							public Contact Contact = new Contact();

							@DSREF(cls = "Contact")
							public class Contact {

								public Contact() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
								public String Name;
								public Communication Communication = new Communication();

								@DSREF(cls = "Communication")
								public class Communication {

									public Communication() {

									}

									public boolean hasMachedProps() {
										return new Worker(msgName).hasMachedProps(this);
									}

									public String getSchema() {
										return new Worker(msgName).getSchema(this);
									}

									@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
									public String ID;
									@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
									public String TypeID;
								}
							}
						}

						public Submitter Submitter = new Submitter();

						@DSREF(cls = "Submitter")
						public class Submitter {

							public Submitter() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Submitter. Identification. Identifier", uid = "R059", cls = "Submitter")
							public String ID;
							@DSREF(den = "Submitter. Name. Text", uid = "R058", cls = "Submitter")
							public String Name;
							public Address Address = new Address();

							@DSREF(cls = "Address")
							public class Address {

								public Address() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
								public String CityName;
								@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
								public String CountryCode;
								@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
								public String CountrySubDivisionID;
								@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
								public String CountrySubDivisionName;
								@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
								public String Line;
								@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
								public String PostcodeID;
							}

							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}

							public Contact Contact = new Contact();

							@DSREF(cls = "Contact")
							public class Contact {

								public Contact() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
								public String Name;
								public Communication Communication = new Communication();

								@DSREF(cls = "Communication")
								public class Communication {

									public Communication() {

									}

									public boolean hasMachedProps() {
										return new Worker(msgName).hasMachedProps(this);
									}

									public String getSchema() {
										return new Worker(msgName).getSchema(this);
									}

									@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
									public String ID;
									@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
									public String TypeID;
								}
							}
						}

					}

					public AdditionalInformation AdditionalInformation = new AdditionalInformation();

					@DSREF(cls = "Additional Information")
					public class AdditionalInformation {

						public AdditionalInformation() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Additional Information. Content. Text", uid = "105", cls = "Additional Information")
						public String Content;
						@DSREF(den = "Additional Information. Limit. Date Time", uid = "264", cls = "Additional Information")
						public String LimitDateTime;
						@DSREF(den = "Additional Information. Reconciliation Reason. Code", uid = "300", cls = "Additional Information")
						public String ReconciliationReasonCode;
						@DSREF(den = "Additional Information. Request Override. Code", uid = "095", cls = "Additional Information")
						public String RequestOverrideCode;
						@DSREF(den = "Additional Information. Requested Inspection. Date Time", uid = "220", cls = "Additional Information")
						public String RequestedInspectionDateTime;
						@DSREF(den = "Additional Information. Statement. Code", uid = "226", cls = "Additional Information")
						public String StatementCode;
						@DSREF(den = "Additional Information. Statement Description. Text", uid = "225", cls = "Additional Information")
						public String StatementDescription;
						@DSREF(den = "Additional Information. Statement Type. Code", uid = "369", cls = "Additional Information")
						public String StatementTypeCode;
					}

					public ApprovedEstablishmentPlace ApprovedEstablishmentPlace = new ApprovedEstablishmentPlace();

					@DSREF(cls = "Approved Establishment Place")
					public class ApprovedEstablishmentPlace {

						public ApprovedEstablishmentPlace() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Approved Establishment Place. Identification. Identifier", uid = "L058", cls = "Approved Establishment Place")
						public String ID;
						@DSREF(den = "Approved Establishment Place. Name. Text", uid = "L057", cls = "Approved Establishment Place")
						public String Name;
					}

					public AuthorisedPerson AuthorisedPerson = new AuthorisedPerson();

					@DSREF(cls = "Authorised Person")
					public class AuthorisedPerson {

						public AuthorisedPerson() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Authorised Person. Identification. Identifier", uid = "R068", cls = "Authorised Person")
						public String ID;
						@DSREF(den = "Authorised Person. Name. Text", uid = "R067", cls = "Authorised Person")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public Classification Classification = new Classification();

					@DSREF(cls = "Classification")
					@AAA(msg = {
							//
							"name=N5110,car=1,boro=",//
							"name=N5116,car=1,boro=",//
							"name=N5135,car=0..1,boro=",//
							"name=N5203,car=1..2,boro=",//
							"name=N5204,car=0..1,boro=",//
							"name=N5205,car=0..1,boro=",//
							"name=N5401,car=1,boro=",//
							"name=N5402,car=1,boro=",//
							"name=NX201_01,car=1,boro=",//
							"name=NX201_07,car=0..1,boro=",//
							"name=NX202,car=0..1,boro=",//
							"name=NX301,car=1,boro=",//
							"name=NX301_DN,car=1,boro=",//
							"name=NX401,car=1,boro=",//
							"name=NX5105,car=1..2,boro=",//
							"name=NX601,car=1,boro=",//
							"name=NX603,car=1,boro=",//
							"name=NX801,car=1,boro=",//
					})
					public class Classification {

						public Classification() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Classification. Identification. Identifier", uid = "145", cls = "Classification")
						@AAA(msg = {
								//
								"name=N5110,car=1,boro=,chn=貨品分類號列",//
								"name=N5116,car=1,boro=,chn=貨品分類號列",//
								"name=N5135,car=1,boro=,chn=貨品分類號列",//
								"name=N5203,car=1,boro=,chn=貨品分類號列;危險貨物代碼",//
								"name=N5204,car=1,boro=,chn=貨品分類號列",//
								"name=N5205,car=1,boro=,chn=貨品分類號列",//
								"name=N5401,car=1,boro=,chn=貨品分類號列",//
								"name=N5402,car=1,boro=,chn=貨品分類號列",//
								"name=NX201_01,car=1,boro=,chn=貨品分類號列",//
								"name=NX301,car=1,boro=,chn=貨品分類號列",//
								"name=NX301_DN,car=1,boro=,chn=貨品分類號列",//
								"name=NX401,car=1,boro=,chn=貨品分類號列",//
								"name=NX5105,car=1,boro=,chn=貨品分類號列;危險貨物代碼",//
								"name=NX601,car=1,boro=,chn=貨品分類號列",//
								"name=NX603,car=1,boro=,chn=貨品分類號列",//
								"name=NX801,car=1,boro=,chn=貨品分類號列",//
						})
						public String ID;

						@DSREF(den = "Classification. Identification Type. Code", uid = "337", cls = "Classification")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=,chn=*貨品分類號類別代碼",//
								"name=NX5105,car=1,boro=,chn=*貨品分類號類別代碼",//
						})
						public String IdentificationTypeCode;
					}

					public CommodityRelatedPackaging CommodityRelatedPackaging = new CommodityRelatedPackaging();

					@DSREF(cls = "Commodity Related Packaging")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=#",//
							"name=N5205,car=1,boro=#",//
							"name=NX301_DN,car=0..1,boro=",//
							"name=NX5105,car=0..1,boro=",//
							"name=NX601,car=1,boro=",//
					})
					public class CommodityRelatedPackaging {

						public CommodityRelatedPackaging() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Commodity Related Packaging. Certification. Indicator", uid = "342", cls = "Commodity Related Packaging")
						public String CertificationIndicator;
						@DSREF(den = "Commodity Related Packaging. Filler Description. Text", uid = "362", cls = "Commodity Related Packaging")
						public String FillerDescription;
						@DSREF(den = "Commodity Related Packaging. Hierarchic. Code", uid = "333", cls = "Commodity Related Packaging")
						public String HierarchicCode;
						@DSREF(den = "Commodity Related Packaging. Innermost Unit. Quantity", uid = "316", cls = "Commodity Related Packaging")
						public String InnermostUnitQuantity;
						@DSREF(den = "Commodity Related Packaging. Level. Indicator", uid = "366", cls = "Commodity Related Packaging")
						public String LevelIndicator;

						@DSREF(den = "Commodity Related Packaging. Marking. Text", uid = "345", cls = "Commodity Related Packaging")
						public String Marking;

						@DSREF(den = "Commodity Related Packaging. Packing Method Description. Text", uid = "343", cls = "Commodity Related Packaging")
						@AAA(msg = {
								//
								"name=NX5105,car=0..1,boro=,chn=包裝方式代碼",//
								"name=NX601,car=1,boro=,chn=包裝方式代碼",//
						})
						public String PackingMethodDescription;

						@DSREF(den = "Commodity Related Packaging. Material. Code", uid = "TW112", cls = "Commodity Related Packaging")
						@AAA(msg = {
								//
								"name=NX5105,car=0..1,boro=,chn=包裝材料代碼",//
								"name=NX601,car=1,boro=,chn=包裝材料代碼",//
						})
						public String tw_MaterialCode;

						@DSREF(den = "Commodity Related Packaging. Specification. Text", uid = "TW110", cls = "Commodity Related Packaging")
						@AAA(msg = {
								//
								"name=NX301_DN,car=1,boro=,chn=包裝規格說明",//
								"name=NX5105,car=0..1,boro=,chn=包裝規格說明",//
								"name=NX601,car=0..1,boro=,chn=包裝規格說明",//
						})
						public String tw_Specification;

					}

					public Constituent Constituent = new Constituent();

					@DSREF(cls = "Constituent")
					@AAA(msg = {
							//
							"name=N5135,car=0..1,boro=",//
							"name=N5203,car=0..1,boro=",//
							"name=N5205,car=0..1,boro=",//
							"name=N5401,car=1,boro=",//
							"name=N5402,car=1,boro=",//
							"name=NX201_01,car=0..1,boro=",//
							"name=NX201_07,car=0..1,boro=",//
							"name=NX202,car=0..1,boro=",//
							"name=NX301,car=0..1,boro=",//
							"name=NX5105,car=0..1,boro=",//
							"name=NX601,car=0..1,boro=",//
							"name=NX603,car=0..1,boro=",//
							"name=NX801,car=0..1,boro=",//
					})
					public class Constituent {

						public Constituent() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Constituent. Element Active Ingredient. Indicator", uid = "363", cls = "Constituent")
						public String ElementActiveIngredientIndicator;

						@DSREF(den = "Constituent. Element. Code", uid = "349", cls = "Constituent")
						public String ElementCode;

						@DSREF(den = "Constituent. Element Name. Text", uid = "348", cls = "Constituent")
						public String ElementName;

						@DSREF(den = "Constituent. Element Description. Text", uid = "259", cls = "Constituent")
						@AAA(msg = {
								//
								"name=N5135,car=1,boro=,chn=成分及規格",//
								"name=N5203,car=1,boro=,chn=成分及規格",//
								"name=N5205,car=1,boro=,chn=成分及規格",//
								"name=N5401,car=1,boro=,chn=成分及規格",//
								"name=N5402,car=1,boro=,chn=成分及規格",//
								"name=NX201_01,car=1,boro=,chn=成分及規格",//
								"name=NX301,car=0..1,boro=,chn=成分及規格",//
								"name=NX5105,car=0..1,boro=,chn=成分及規格",//
								"name=NX601,car=1,boro=,chn=成分及規格",//
								"name=NX603,car=0..1,boro=,chn=成分及規格",//
								"name=NX801,car=1,boro=,chn=成分及規格",//
						})
						public String ElementDescription;

						@DSREF(den = "Obligation Guarantee. LPCO Expiration. Date Time", uid = "275", cls = "Obligation Guarantee")
						public String LPCOExpirationDateTime;

						@DSREF(den = "Constituent. Element Percent. Numeric", uid = "311", cls = "Constituent")
						public String ElementPercent;

						@DSREF(den = "Constituent. Level. Identifier", uid = "TW139", cls = "Constituent")
						@AAA(msg = {
								//
								"name=NX301,car=0..1,boro=,chn=等級",//
								"name=NX5105,car=0..1,boro=,chn=等級",//
								"name=NX603,car=0..1,boro=,chn=等級",//
						})
						public String tw_LevelID;

						@DSREF(den = "Constituent. Thickness. Text", uid = "TW140", cls = "Constituent")
						@AAA(msg = {
								//
								"name=NX301,car=0..1,boro=,chn=厚度",//
								"name=NX5105,car=0..1,boro=,chn=厚度",//
								"name=NX603,car=0..1,boro=,chn=厚度",//
						})
						public String tw_Thickness;

						@DSREF(den = "Constituent. Element. Quantity", uid = "317", cls = "Constituent")
						public String ElementQuantity;
						@DSREF(den = "Constituent. Element Yield. Amount", uid = "370", cls = "Constituent")
						public String ElementYieldAmount;
					}

					public Control Control = new Control();

					@DSREF(cls = "Control")
					public class Control {

						public Control() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Control. Inspection End. Date Time", uid = "356", cls = "Control")
						public String InspectionEndDateTime;

						@DSREF(den = "Control. Inspection Start. Date Time", uid = "355", cls = "Control")
						public String InspectionStartDateTime;

						@DSREF(den = "Control. Time-Limit. Date Time", uid = "264", cls = "Control")
						public String LimitDateTime;

						@DSREF(den = "Control. Review Place. Identifier", uid = "289", cls = "Control")
						public String ReviewPlaceID;

					}

					public DutyTaxFee DutyTaxFee = new DutyTaxFee();

					@DSREF(cls = "Duty Tax Fee")
					@AAA(msg = {
							//
							"name=N5135,car=0..1,boro=",//
							"name=NX301,car=1,boro=",//
							"name=NX301_DN,car=1,boro=",//
							"name=NX401,car=1,boro=",//
							"name=NX5105,car=1,boro=",//
							"name=NX601,car=0..1,boro=",//
							"name=NX603,car=1,boro=",//
							"name=NX801,car=0..1,boro=",//
					})
					public class DutyTaxFee {

						public DutyTaxFee() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Duty Tax Fee. AdValorem Tax Base. Amount", uid = "116", cls = "Duty Tax Fee")
						@AAA(msg = {
								//
								"name=N5135,car=1,boro=,chn=完稅價格",//
								"name=NX301,car=1,boro=,chn=完稅價格",//
								"name=NX301_DN,car=1,boro=,chn=完稅價格",//
								"name=NX401,car=1,boro=,chn=完稅價格",//
								"name=NX5105,car=1,boro=,chn=完稅價格",//
								"name=NX601,car=1,boro=,chn=完稅價格",//
								"name=NX603,car=1,boro=,chn=完稅價格",//
								"name=NX801,car=1,boro=,chn=完稅價格",//
						})
						public String AdValoremTaxBaseAmount;

						@DSREF(den = "Duty Tax Fee. Deduct. Amount", uid = "111", cls = "Duty Tax Fee")
						public String DeductAmount;
						@DSREF(den = "Duty Tax Fee. Deduction. Quantity", uid = "127", cls = "Duty Tax Fee")
						public String DeductionQuantity;

						@DSREF(den = "Duty Tax Fee. Duty Regime. Code", uid = "164", cls = "Duty Tax Fee")
						@AAA(msg = {
								//
								"name=NX5105,car=0..1,boro=,chn=稅則增註",//
								"name=NX801,car=0..1,boro=,chn=稅則增註",//
						})
						public String DutyRegimeCode;

						@DSREF(den = "Duty Tax Fee. Elected Entry. Date Time", uid = "272", cls = "Duty Tax Fee")
						public String ElectedEntryDateTime;

						@DSREF(den = "Duty Tax Fee. Specific Tax Base. Quantity", uid = "129", cls = "Duty Tax Fee")
						@AAA(msg = {
								//
								"name=N5135,car=0..1,boro=,chn=完稅數量",//
								"name=NX5105,car=0..1,boro=,chn=完稅數量",//
						})
						public String SpecificTaxBaseQuantity;

						@DSREF(den = "Duty Tax Fee. Tax Rate. Numeric", uid = "115", cls = "Duty Tax Fee")
						public String TaxRate;
						@DSREF(den = "Duty Tax Fee. Type. Code", uid = "113", cls = "Duty Tax Fee")
						public String TypeCode;

						@DSREF(den = "Duty Tax Fee. Percentage. Numeric", uid = "123", cls = "Duty Tax Fee")
						@AAA(msg = {
								//
								"name=N5135,car=0..1,boro=*,chn=折算率",//
								"name=NX5105,car=0..1,boro=*,chn=折算率",//
						})
						public String tw_PercentageNumeric;

						public Payment Payment = new Payment();

						@DSREF(cls = "Payment")
						public class Payment {

							public Payment() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Payment. Method. Code", uid = "107", cls = "Payment")
							public String MethodCode;
							@DSREF(den = "Payment. Reference. Identifier", uid = "014", cls = "Payment")
							public String ReferenceID;
							@DSREF(den = "Payment. Tax Assessed. Amount", uid = "120", cls = "Payment")
							public String TaxAssessedAmount;
							public ObligationGuarantee ObligationGuarantee = new ObligationGuarantee();

							@DSREF(cls = "Obligation Guarantee")
							public class ObligationGuarantee {

								public ObligationGuarantee() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Obligation Guarantee. LPCO Expiration. Date Time", uid = "275", cls = "Obligation Guarantee")
								public String LPCOExpirationDateTime;
								@DSREF(den = "Obligation Guarantee. Security Details. Code", uid = "101", cls = "Obligation Guarantee")
								public String SecurityDetailsCode;
								public Surety Surety = new Surety();

								@DSREF(cls = "Surety")
								public class Surety {

									public Surety() {

									}

									public boolean hasMachedProps() {
										return new Worker(msgName).hasMachedProps(this);
									}

									public String getSchema() {
										return new Worker(msgName).getSchema(this);
									}

									@DSREF(den = "Surety. Identification. Identifier", uid = "R055", cls = "Surety")
									public String ID;
									@DSREF(den = "Surety. Name. Text", uid = "R054", cls = "Surety")
									public String Name;
									public Address Address = new Address();

									@DSREF(cls = "Address")
									public class Address {

										public Address() {

										}

										public boolean hasMachedProps() {
											return new Worker(msgName).hasMachedProps(this);
										}

										public String getSchema() {
											return new Worker(msgName).getSchema(this);
										}

										@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
										public String CityName;
										@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
										public String CountryCode;
										@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
										public String CountrySubDivisionID;
										@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
										public String CountrySubDivisionName;
										@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
										public String Line;
										@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
										public String PostcodeID;
									}

									public Communication Communication = new Communication();

									@DSREF(cls = "Communication")
									public class Communication {

										public Communication() {

										}

										public boolean hasMachedProps() {
											return new Worker(msgName).hasMachedProps(this);
										}

										public String getSchema() {
											return new Worker(msgName).getSchema(this);
										}

										@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
										public String ID;
										@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
										public String TypeID;
									}

									public Contact Contact = new Contact();

									@DSREF(cls = "Contact")
									public class Contact {

										public Contact() {

										}

										public boolean hasMachedProps() {
											return new Worker(msgName).hasMachedProps(this);
										}

										public String getSchema() {
											return new Worker(msgName).getSchema(this);
										}

										@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
										public String Name;
										public Communication Communication = new Communication();

										@DSREF(cls = "Communication")
										public class Communication {

											public Communication() {

											}

											public boolean hasMachedProps() {
												return new Worker(msgName).hasMachedProps(this);
											}

											public String getSchema() {
												return new Worker(msgName).getSchema(this);
											}

											@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
											public String ID;
											@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
											public String TypeID;
										}
									}
								}
							}
						}
					}

					public ExaminationPlace ExaminationPlace = new ExaminationPlace();

					@DSREF(cls = "Examination Place")
					@AAA(msg = {
					//
					"name=N5109,car=0..1,boro=#",//
					})
					public class ExaminationPlace {

						public ExaminationPlace() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Examination Place. Identification. Identifier", uid = "L029", cls = "Examination Place")
						@AAA(msg = {
						//
						"name=N5109,car=1,boro=,chn=儀檢站代碼",//
						})
						public String ID;

						@DSREF(den = "Examination Place. Name. Text", uid = "L069", cls = "Examination Place")
						public String Name;
					}

					public Exhibitor Exhibitor = new Exhibitor();

					@DSREF(cls = "Exhibitor")
					public class Exhibitor {

						public Exhibitor() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Exhibitor. Identification. Identifier", uid = "R076", cls = "Exhibitor")
						public String ID;
						@DSREF(den = "Exhibitor. Name. Text", uid = "R075", cls = "Exhibitor")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public FacilityPlace FacilityPlace = new FacilityPlace();

					@DSREF(cls = "Facility Place")
					public class FacilityPlace {

						public FacilityPlace() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Facility Place. Identification. Identifier", uid = "L051", cls = "Facility Place")
						public String ID;
						@DSREF(den = "Facility Place. Name. Text", uid = "L050", cls = "Facility Place")
						public String Name;
						@DSREF(den = "Facility Place. Type. Code", uid = "L047", cls = "Facility Place")
						public String TypeCode;
					}

					public Feedlot Feedlot = new Feedlot();

					@DSREF(cls = "Feedlot")
					public class Feedlot {

						public Feedlot() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Feedlot. Identification. Identifier", uid = "R078", cls = "Feedlot")
						public String ID;
						@DSREF(den = "Feedlot. Name. Text", uid = "R077", cls = "Feedlot")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public FreeTradeZone FreeTradeZone = new FreeTradeZone();

					@DSREF(cls = "Free Trade Zone")
					public class FreeTradeZone {

						public FreeTradeZone() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Free Trade Zone. Identification. Identifier", uid = "L066", cls = "Free Trade Zone")
						public String ID;
						@DSREF(den = "Free Trade Zone. Name. Text", uid = "L065", cls = "Free Trade Zone")
						public String Name;
					}

					public GovernmentProcedure GovernmentProcedure = new GovernmentProcedure();

					@DSREF(cls = "Government Procedure")
					@AAA(msg = {
							//
							"name=N5135,car=1,boro=",//
							"name=NX401,car=0..1,boro=",//
							"name=NX5105,car=1,boro=",//
							"name=NX801,car=0..1,boro=",//
					})
					public class GovernmentProcedure {

						public GovernmentProcedure() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Government Procedure. Current. Code", uid = "166", cls = "Government Procedure")
						@AAA(msg = {
								//
								"name=N5135,car=1,boro=,chn=納稅辦法代碼",//
								"name=NX401,car=1,boro=,chn=納稅辦法代碼",//
								"name=NX5105,car=1,boro=,chn=納稅辦法代碼",//
								"name=NX801,car=1,boro=,chn=納稅辦法代碼",//
						})
						public String CurrentCode;

						@DSREF(den = "Government Procedure. Description. Text", uid = "353", cls = "Government Procedure")
						public String Description;

						@DSREF(den = "Government Procedure. Previous. Code", uid = "161", cls = "Government Procedure")
						public String PreviousCode;
					}

					public GovernmentServiceRequestor GovernmentServiceRequestor = new GovernmentServiceRequestor();

					@DSREF(cls = "Government Service Requestor")
					public class GovernmentServiceRequestor {

						public GovernmentServiceRequestor() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Government Service Requestor. Identification. Identifier", uid = "R081", cls = "Government Service Requestor")
						public String ID;
						@DSREF(den = "Government Service Requestor. Name. Text", uid = "R082", cls = "Government Service Requestor")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public Grower Grower = new Grower();

					@DSREF(cls = "Grower")
					public class Grower {

						public Grower() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Grower. Identification. Identifier", uid = "R084", cls = "Grower")
						public String ID;
						@DSREF(den = "Grower. Name. Text", uid = "R083", cls = "Grower")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public InvoiceLine InvoiceLine = new InvoiceLine();

					@DSREF(cls = "Invoice Line")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=",//
							"name=N5205,car=1,boro=",//
							"name=NX201_01,car=1,boro=",//
							"name=NX201_07,car=0..1,boro=",//
							"name=NX202,car=0..1,boro=",//
							"name=NX5105,car=1,boro=",//
					})
					public class InvoiceLine {

						public InvoiceLine() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Invoice Line. Item Charge. Amount", uid = "112", cls = "Invoice Line")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=,chn=離岸價格(新台幣)",//
								"name=N5205,car=1,boro=,chn=離岸價格(新台幣)",//
						})
						public String ItemChargeAmount;

						@DSREF(den = "Invoice Line. Sequence. Numeric", uid = "006", cls = "Invoice Line")
						public String SequenceNumeric;

						@DSREF(den = "Invoice Line. Charges Type. Code", uid = "371", cls = "Invoice Line")
						@AAA(msg = {
								//
								"name=NX201_01,car=1,boro=*,chn=單價條件",//
								"name=NX5105,car=1,boro=*,chn=單價條件",//
						})
						public String tw_ChargesTypeCode;

						@DSREF(den = "Invoice Line. Currency Type. Code", uid = "135", cls = "Invoice Line")
						@AAA(msg = {
								//
								"name=NX201_01,car=1,boro=*,chn=幣別代碼",//
								"name=NX5105,car=1,boro=*,chn=單價幣別代碼",//
						})
						public String tw_CurrencyTypeCode;

						@DSREF(den = "Invoice Line. Unit Price. Amount", uid = "TW025", cls = "Invoice Line")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=,chn=單價金額",//
								"name=NX201_01,car=0..1,boro=,chn=單價金額",//
								"name=NX5105,car=1,boro=,chn=單價金額",//
						})
						public String tw_UnitPriceAmount;

						@DSREF(den = "Invoice Line. Sub Total. Amount", uid = "TW134", cls = "Invoice Line")
						@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=,chn=金額小計",//
						})
						public String tw_SubTotalAmount;
					}

					public Itinerary Itinerary = new Itinerary();

					@DSREF(cls = "Itinerary")
					public class Itinerary {

						public Itinerary() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Itinerary. Routing Country. Code", uid = "064", cls = "Itinerary")
						public String RoutingCountryCode;
						@DSREF(den = "Itinerary. Routing Region. Identifer", uid = "393", cls = "Itinerary")
						public String RoutingRegionID;
					}

					public PreviousDocument PreviousDocument = new PreviousDocument();

					@DSREF(cls = "Previous Document")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=",//
							"name=NX301,car=0..1,boro=+",//
							"name=NX301_DN,car=0..1,boro=+",//
							"name=NX302,car=0..1,boro=",//
							"name=NX302_DN,car=1,boro=",//
							"name=NX401,car=0..1,boro=+",//
							"name=NX402,car=1,boro=",//
							"name=NX5105,car=0..1,boro=+",//
							"name=NX601,car=0..1,boro=+",//
							"name=NX602,car=1,boro=",//
							"name=NX603,car=0..1,boro=+",//
							"name=NX901,car=1,boro=",//
							"name=NX902,car=1,boro=",//
							"name=NX903,car=1,boro=",//
					})
					public class PreviousDocument {

						public PreviousDocument() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Previous Document. Identification. Identifier", uid = "D018", cls = "Previous Document")
						@AAA(msg = {
								//
								"name=NX301,car=1,boro=,chn=原輸出入許可文件號碼",//
								"name=NX5105,car=1,boro=,chn=原輸出入許可文件號碼",//
								"name=NX603,car=1,boro=,chn=原輸出入許可文件號碼",//
						})
						public String ID;

						@DSREF(den = "Previous Document. Issue. Date Time", uid = "D010", cls = "Previous Document")
						public String IssueDateTime;

						@DSREF(den = "Previous Document. Line. Numeric", uid = "171", cls = "Previous Document")
						public String SequenceNumeric;

						@DSREF(den = "Previous Document. Functional Reference. Identifier", uid = "D026", cls = "")
						public String tw_FunctionalReferenceID;

						@DSREF(den = "Previous Document. Import Export Permit. Identifier", uid = "TW_094", cls = "Previous Document")
						public String tw_ImportExportPermitID;

						@DSREF(den = "Previous Document. Universally Unique. Identifier", uid = "TW130", cls = "")
						public String tw_UniversallyUniqueID;

						@DSREF(den = "Previous Document. Type. Code", uid = "D019", cls = "Previous Document")
						public String TypeCode;

					}

					public Producer Producer = new Producer();

					@DSREF(cls = "Producer")
					public class Producer {

						public Producer() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Producer. Identification. Identifier", uid = "R035", cls = "Producer")
						public String ID;
						@DSREF(den = "Producer. Name. Text", uid = "R034", cls = "Producer")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public PropertyOperator PropertyOperator = new PropertyOperator();

					@DSREF(cls = "Property Operator")
					public class PropertyOperator {

						public PropertyOperator() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Property Operator. Identification. Identifier", uid = "R088", cls = "Property Operator")
						public String ID;
						@DSREF(den = "Property Operator. Name. Text", uid = "R057", cls = "Property Operator")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public PropertyOwner PropertyOwner = new PropertyOwner();

					@DSREF(cls = "Property Owner")
					public class PropertyOwner {

						public PropertyOwner() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Property Owner. Identification. Identifier", uid = "R098", cls = "Property Owner")
						public String ID;
						@DSREF(den = "Property Owner. Name. Text", uid = "R095", cls = "Property Owner")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public ResponsibleGovernmentAgency ResponsibleGovernmentAgency = new ResponsibleGovernmentAgency();

					@DSREF(cls = "Responsible Government Agency")
					public class ResponsibleGovernmentAgency {

						public ResponsibleGovernmentAgency() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Responsible Government Agency. Identification. Identifier", uid = "R062", cls = "Responsible Government Agency")
						public String ID;

						@DSREF(den = "Responsible Government Agency. Designation. Code", uid = "TW_102", cls = "Responsible Government Agency")
						public String tw_DesignationCode;

						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}

						public GovernmentOfficer GovernmentOfficer = new GovernmentOfficer();

						@DSREF(cls = "Government Officer")
						public class GovernmentOfficer {

							public GovernmentOfficer() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Government Officer. Identification. Identifier", uid = "R080", cls = "Government Officer")
							public String ID;
							@DSREF(den = "Government Officer. Name. Text", uid = "R079", cls = "Government Officer")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public Source Source = new Source();

					@DSREF(cls = "Source")
					@AAA(msg = {
							//
							"name=N5401,car=0..1,boro=",//
							"name=N5402,car=0..1,boro=",//
					})
					public class Source {

						public Source() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Source. Country. Code", uid = "396", cls = "Source")
						public String CountryCode;
						@DSREF(den = "Source. Geographic Region. Text", uid = "286", cls = "Source")
						public String GeographicRegion;
						@DSREF(den = "Source. Political Region. Code", uid = "292", cls = "Source")
						public String PoliticalRegionCode;
						@DSREF(den = "Source. Type. Code", uid = "397", cls = "Source")
						public String TypeCode;

						@DSREF(den = "Source. Ineligible Goods Note. Text", uid = "TW125", cls = "Source")
						@AAA(msg = {
								//
								"name=N5401,car=1,boro=,chn=使用進儲未開放大陸物品註記",//
								"name=N5402,car=1,boro=,chn=使用進儲未開放大陸物品註記",//
						})
						public String tw_IneligibleGoodsNote;
					}

					public Status Status = new Status();

					@DSREF(cls = "Status")
					public class Status {

						public Status() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Status. Requested Assignment. Date Time", uid = "273", cls = "Status")
						public String RequestedAssignmentDateTime;
					}

					public tw_CommodityNumber tw_CommodityNumber = new tw_CommodityNumber();

					@DSREF(cls = "Commodity Number")
					@AAA(msg = {
							//
							"name=N5203,car=0..2,boro=",//
							"name=N5401,car=1..2,boro=",//
							"name=N5402,car=1..2,boro=",//
							"name=NX5105,car=0..2,boro=",//
							"name=NX601,car=0..1,boro=",//
					})
					public class tw_CommodityNumber {

						public tw_CommodityNumber() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Commodity Number. Identification. Identifier", uid = "147", cls = "Commodity Number")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=*,chn=買方料號;賣方料號",//
								"name=NX5105,car=1,boro=*,chn=買方料號;賣方料號",//
						})
						public String tw_ID;

						@DSREF(den = "Commodity Number. Identifier Type. Code", uid = "338", cls = "Commodity Number")
						@AAA(msg = {
								//
								"name=N5203,car=1,boro=*,chn=*料號類別代碼",//
								"name=NX5105,car=1,boro=*,chn=*料號類別代碼",//
						})
						public String tw_IDTypeCode;

					}

					public tw_DutyOtherTaxFee tw_DutyOtherTaxFee = new tw_DutyOtherTaxFee();

					@DSREF(cls = "Duty Other Tax Fee")
					@AAA(msg = {
							//
							"name=N5135,car=0..9,boro=",//
							"name=N5203,car=0..9,boro=",//
							"name=NX5105,car=0..9,boro=",//
					})
					public class tw_DutyOtherTaxFee {

						public tw_DutyOtherTaxFee() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Duty Other Tax Fee. Method. Code", uid = "122", cls = "Duty Other Tax Fee")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=*,chn=從價或從量註記",//
						})
						public String tw_MethodCode;

						@DSREF(den = "Duty Other Tax Fee. Percentage. Numeric", uid = "123", cls = "Duty Other Tax Fee")
						@AAA(msg = {
								//
								"name=N5135,car=0..1,boro=*,chn=折算率",//
								"name=NX5105,car=0..1,boro=*,chn=折算率",//
						})
						public String tw_PercentageNumeric;

						@DSREF(den = "Duty Other Tax Fee. Tax Rate. Numeric", uid = "115", cls = "Duty Other Tax Fee")
						@AAA(msg = {
								//
								"name=N5135,car=1,boro=*,chn=其他稅費率",//
								"name=N5203,car=1,boro=*,chn=其他稅費率",//
								"name=NX5105,car=1,boro=*,chn=其他稅費率",//
						})
						public String tw_TaxRateNumeric;

						@DSREF(den = "Duty Other Tax Fee. Type. Code", uid = "113", cls = "Duty Other Tax Fee")
						@AAA(msg = {
								//
								"name=N5135,car=1,boro=*,chn=其他稅費代碼",//
								"name=N5203,car=1,boro=*,chn=其他稅費代碼",//
								"name=NX5105,car=1,boro=*,chn=其他稅費代碼",//
						})
						public String tw_TypeCode;

					}

					public tw_DutyTaxFeeAmount tw_DutyTaxFeeAmount = new tw_DutyTaxFeeAmount();

					@DSREF(cls = "Duty Tax Fee Amount")
					@AAA(msg = {
							//
							"name=N5135,car=0..1,boro=",//
							"name=NX5105,car=0..1,boro=",//
					})
					public class tw_DutyTaxFeeAmount {

						public tw_DutyTaxFeeAmount() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Duty Tax Fee Amount. Percentage. Numeric", uid = "123", cls = "Duty Tax Fee Amount")
						@AAA(msg = {
								//
								"name=N5135,car=0..1,boro=*,chn=折算率",//
								"name=NX5105,car=0..1,boro=*,chn=折算率",//
						})
						public String tw_PercentageNumeric;

						@DSREF(den = "Duty Tax Fee Amount. Tax Rate. Numeric", uid = "115", cls = "Duty Tax Fee Amount")
						@AAA(msg = {
								//
								"name=N5135,car=1,boro=*,chn=進口稅率",//
								"name=NX5105,car=1,boro=*,chn=進口稅率",//
						})
						public String tw_TaxRateNumeric;

					}

					public tw_DutyTaxFeeQuantity tw_DutyTaxFeeQuantity = new tw_DutyTaxFeeQuantity();

					@DSREF(cls = "Duty Tax Fee Quantity")
					@AAA(msg = {
							//
							"name=N5135,car=0..1,boro=",//
							"name=NX5105,car=0..1,boro=",//
					})
					public class tw_DutyTaxFeeQuantity {

						public tw_DutyTaxFeeQuantity() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Duty Tax Fee Quantity. Duty Unit. Code", uid = "TW010", cls = "Duty Tax Fee Quantity")
						@AAA(msg = {
								//
								"name=N5135,car=1,boro=,chn=稅額單位",//
								"name=NX5105,car=1,boro=,chn=稅額單位",//
						})
						public String tw_DutyUnitCode;

						@DSREF(den = "Duty Tax Fee Quantity. Percentage. Numeric", uid = "123", cls = "Duty Tax Fee Quantity")
						@AAA(msg = {
								//
								"name=N5135,car=0..1,boro=*,chn=折算率",//
								"name=NX5105,car=0..1,boro=*,chn=折算率",//
						})
						public String tw_PercentageNumeric;

						@DSREF(den = "Duty Tax Fee Quantity. Tax Rate. Numeric", uid = "115", cls = "Duty Tax Fee Quantity")
						@AAA(msg = {
								//
								"name=N5135,car=1,boro=*,chn=單位稅額",//
								"name=NX5105,car=1,boro=*,chn=單位稅額",//
						})
						public String tw_TaxRateNumeric;

					}

					public tw_Food tw_Food = new tw_Food();

					@DSREF(cls = "Food")
					@AAA(msg = {
							//
							"name=NX5105,car=0..1,boro=",//
							"name=NX601,car=0..1,boro=",//
					})
					public class tw_Food {

						public tw_Food() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Food. Product Best Before. Date Time", uid = "266", cls = "Food")
						public String tw_ProductBestBeforeDateTime;

						@DSREF(den = "Food. PH Value. Numeric", uid = "TW098", cls = "Food")
						@AAA(msg = {
								//
								"name=NX5105,car=0..1,boro=,chn=最終產品pH值",//
								"name=NX601,car=0..1,boro=,chn=最終產品pH值",//
						})
						public String tw_PHValueNumeric;

						@DSREF(den = "Food. Sterilization Value. Numeric", uid = "TW099", cls = "Food")
						@AAA(msg = {
								//
								"name=NX5105,car=0..1,boro=,chn=產品殺菌值",//
								"name=NX601,car=0..1,boro=,chn=產品殺菌值",//
						})
						public String tw_SterilizationValueNumeric;

						public Constituent Constituent = new Constituent();

						@DSREF(cls = "Constituent")
						@AAA(msg = {
								//
								"name=NX5105,car=0..99,boro=+",//
								"name=NX601,car=0..99,boro=+",//
						})
						public class Constituent {

							public Constituent() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Constituent. Element. Code", uid = "349", cls = "Constituent")
							public String ElementCode;

							@DSREF(den = "Constituent. Element Name. Text", uid = "348", cls = "Constituent")
							@AAA(msg = {
									//
									"name=NX5105,car=1,boro=,chn=成分名稱",//
									"name=NX601,car=1,boro=,chn=成分名稱",//
							})
							public String ElementName;

							@DSREF(den = "Constituent. Element Percent. Numeric", uid = "311", cls = "Constituent")
							@AAA(msg = {
									//
									"name=NX5105,car=0..1,boro=,chn=含量",//
									"name=NX601,car=0..1,boro=,chn=含量",//
							})
							public String ElementPercentNumeric;

						}

					}

					public tw_Quarantine tw_Quarantine = new tw_Quarantine();

					@DSREF(cls = "Quarantine")
					@AAA(msg = {
							//
							"name=NX401,car=0..1,boro=",//
							"name=NX5105,car=0..1,boro=",//
					})
					public class tw_Quarantine {

						public tw_Quarantine() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Quarantine. Object Feature. Text", uid = "TW108", cls = "Quarantine")
						@AAA(msg = {
								//
								"name=NX401,car=0..1,boro=,chn=毛色及特徵(或植物學名)",//
								"name=NX5105,car=0..1,boro=,chn=毛色及特徵(或植物學名)",//
						})
						public String tw_ObjectFeature;

						@DSREF(den = "Quarantine. Treatment. Text", uid = "TW093", cls = "Quarantine")
						@AAA(msg = {
								//
								"name=NX401,car=0..1,boro=,chn=檢疫處理",//
								"name=NX5105,car=0..1,boro=,chn=檢疫處理",//
						})
						public String tw_Treatment;

						public tw_Animal tw_Animal = new tw_Animal();

						@DSREF(cls = "Animal")
						@AAA(msg = {
								//
								"name=NX401,car=0..1,boro=",//
								"name=NX5105,car=0..1,boro=",//
						})
						public class tw_Animal {

							public tw_Animal() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Animal. Age Month. Numeric", uid = "TW121", cls = "Animal")
							@AAA(msg = {
									//
									"name=NX401,car=0..1,boro=,chn=年齡-月",//
									"name=NX5105,car=0..1,boro=,chn=年齡-月",//
							})
							public String tw_AgeMonthNumeric;

							@DSREF(den = "Animal. Age Year. Numeric", uid = "TW123", cls = "Animal")
							@AAA(msg = {
									//
									"name=NX401,car=0..1,boro=,chn=年齡-年",//
									"name=NX5105,car=0..1,boro=,chn=年齡-年",//
							})
							public String tw_AgeYearNumeric;

							@DSREF(den = "Animal. Female. Quantity", uid = "TW116", cls = "Animal")
							@AAA(msg = {
									//
									"name=NX401,car=0..1,boro=,chn=雌隻數量",//
									"name=NX5105,car=0..1,boro=,chn=雌隻數量",//
							})
							public String tw_FemaleQuantity;

							@DSREF(den = "Animal. Male. Quantity", uid = "TW120", cls = "Animal")
							@AAA(msg = {
									//
									"name=NX401,car=0..1,boro=,chn=雄隻數量",//
									"name=NX5105,car=0..1,boro=,chn=雄隻數量",//
							})
							public String tw_MaleQuantity;

							@DSREF(den = "Animal. Microchip. Identifier", uid = "TW115", cls = "Animal")
							@AAA(msg = {
									//
									"name=NX401,car=0..1,boro=,chn=晶片號碼",//
									"name=NX5105,car=0..1,boro=,chn=晶片號碼",//
							})
							public String tw_MicrochipID;

							@DSREF(den = "Animal. Vaccination. Text", uid = "TW109", cls = "Animal")
							@AAA(msg = {
									//
									"name=NX401,car=0..1,boro=,chn=預防注射種類/日期",//
									"name=NX5105,car=0..1,boro=,chn=預防注射種類/日期",//
							})
							public String tw_Vaccination;

						}
					}

					public tw_Vehicle tw_Vehicle = new tw_Vehicle();

					@DSREF(cls = "Vehicle")
					@AAA(msg = {
					//
					"name=NX5105,car=0..1,boro=",//
					})
					public class tw_Vehicle {

						public tw_Vehicle() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Vehicle. Catalyst. Text", uid = "TW020", cls = "Vehicle")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=觸媒轉換器",//
						})
						public String tw_Catalyst;

						@DSREF(den = "Vehicle. Classification. Code", uid = "TW013", cls = "Vehicle")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=車型",//
						})
						public String tw_ClassificationCode;

						@DSREF(den = "Vehicle. Cylinder. Quantity", uid = "TW016", cls = "Vehicle")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=汽缸數",//
						})
						public String tw_CylinderQuantity;

						@DSREF(den = "Vehicle. Displace. Quantity", uid = "TW015", cls = "Vehicle")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=排氣量",//
						})
						public String tw_DisplaceQuantity;

						@DSREF(den = "Vehicle. Door. Quantity", uid = "TW014", cls = "Vehicle")
						@AAA(msg = {
						//
						"name=NX5105,car=0..1,boro=,chn=車門數",//
						})
						public String tw_DoorQuantity;

						@DSREF(den = "Vehicle. Driving Side. Text", uid = "TW021", cls = "Vehicle")
						@AAA(msg = {
						//
						"name=NX5105,car=0..1,boro=,chn=左駕駛",//
						})
						public String tw_DrivingSide;

						@DSREF(den = "Vehicle. Fuel Type. Code", uid = "TW019", cls = "Vehicle")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=燃油引擎種類",//
						})
						public String tw_FuelTypeCode;

						@DSREF(den = "Vehicle. Model Year. Numeric", uid = "TW012", cls = "Vehicle")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=型式年份",//
						})
						public String tw_ModelYearNumeric;

						@DSREF(den = "Vehicle. Seat. Quantity", uid = "TW017", cls = "Vehicle")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=座位數",//
						})
						public String tw_SeatQuantity;

						@DSREF(den = "Vehicle. Status. Code", uid = "TW023", cls = "Vehicle")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=車況",//
						})
						public String tw_StatusCode;

						@DSREF(den = "Vehicle. Transmission Type. Code", uid = "TW018", cls = "Vehicle")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=排檔",//
						})
						public String tw_TransmissionTypeCode;

						public tw_VehicleID tw_VehicleID = new tw_VehicleID();

						@DSREF(cls = "VehicleID")
						@AAA(msg = {
						//
						"name=NX5105,car=1..999,boro=",//
						})
						public class tw_VehicleID {

							public tw_VehicleID() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "VehicleID. VIN. Identifier", uid = "TW022", cls = "VehicleID")
							@AAA(msg = {
							//
							"name=NX5105,car=1,boro=,chn=車身號碼",//
							})
							public String tw_VINID;

						}

					}

					public tw_Wine tw_Wine = new tw_Wine();

					@DSREF(cls = "Wine")
					@AAA(msg = {
							//
							"name=NX301_DN,car=1,boro=",//
							"name=NX5105,car=0..1,boro=",//
					})
					public class tw_Wine {

						public tw_Wine() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Wine. Previous Application. Identifier", uid = "D018", cls = "Wine")
						public String tw_WinePreviousApplicationID;

						@DSREF(den = "Wine. Previous Inspection Result. Text", uid = "TW257", cls = "Wine")
						public String tw_WinePreviousInspectionResult;

						@DSREF(den = "Wine. Age. Numeric", uid = "TW124", cls = "Wine")
						@AAA(msg = {
								//
								"name=NX301_DN,car=0..1,boro=,chn=酒齡",//
								"name=NX5105,car=0..1,boro=,chn=酒齡",//
						})
						public String tw_AgeNumeric;

						@DSREF(den = "Wine. Alcohol Content. Numeric", uid = "TW136", cls = "Wine")
						@AAA(msg = {
								//
								"name=NX301_DN,car=1,boro=,chn=酒精成分",//
								"name=NX5105,car=1,boro=,chn=酒精成分",//
						})
						public String tw_AlcoholContentNumeric;

						@DSREF(den = "Wine. Bottled. Date", uid = "TW131", cls = "Wine")
						@AAA(msg = {
								//
								"name=NX301_DN,car=0..1,boro=,chn=裝瓶日期",//
								"name=NX5105,car=0..1,boro=,chn=裝瓶日期",//
						})
						public String tw_BottledDate;

						@DSREF(den = "Wine. Category. Code", uid = "TW222", cls = "Wine")
						public String tw_CategoryCode;

						@DSREF(den = "Wine. Geographic Region. Text", uid = "286", cls = "Wine")
						@AAA(msg = {
								//
								"name=NX301_DN,car=0..1,boro=*,chn=地理標示",//
								"name=NX5105,car=0..1,boro=*,chn=地理標示",//
						})
						public String tw_GeographicRegion;

						@DSREF(den = "Wine. Packaging Method Description. Text", uid = "TW047", cls = "Wine")
						public String tw_PackagingMethodDescription;

						@DSREF(den = "Wine. Product Best Before. Date Time", uid = "266", cls = "Wine")
						@AAA(msg = {
								//
								"name=NX301_DN,car=0..1,boro=*,chn=有效日期",//
								"name=NX5105,car=0..1,boro=*,chn=有效日期",//
						})
						public String tw_ProductBestBeforeDateTime;

						@DSREF(den = "Wine. Product Expiry. Date Time", uid = "354", cls = "Wine")
						@AAA(msg = {
								//
								"name=NX301_DN,car=0..1,boro=*,chn=保存期限",//
								"name=NX5105,car=0..1,boro=*,chn=保存期限",//
						})
						public String tw_ProductExpiryDateTime;

						@DSREF(den = "Wine. Year. Numeric", uid = "TW127", cls = "Wine")
						@AAA(msg = {
								//
								"name=NX301_DN,car=0..1,boro=,chn=年份",//
								"name=NX5105,car=0..1,boro=,chn=年份",//
						})
						public String tw_YearNumeric;

						public GovernmentProcedure GovernmentProcedure = new GovernmentProcedure();

						@DSREF(cls = "Government Procedure")
						public class GovernmentProcedure {

							public GovernmentProcedure() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Government Procedure. Current. Code", uid = "166", cls = "Government Procedure")
							public String CurrentCode;

							@DSREF(den = "Government Procedure. Description. Text", uid = "353", cls = "Government Procedure")
							public String Description;

							@DSREF(den = "Government Procedure. Previous. Code", uid = "161", cls = "Government Procedure")
							public String PreviousCode;
						}

						public PreviousDocument PreviousDocument = new PreviousDocument();

						@DSREF(cls = "Previous Document")
						public class PreviousDocument {

							public PreviousDocument() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Previous Document. Identification. Identifier", uid = "D018", cls = "Previous Document")
							public String ID;

							@DSREF(den = "Previous Document. Issue. Date Time", uid = "D010", cls = "Previous Document")
							public String IssueDateTime;

							@DSREF(den = "Previous Document. Line. Numeric", uid = "171", cls = "Previous Document")
							public String SequenceNumeric;

						}
					}

					public tw_VehicleID tw_VehicleID = new tw_VehicleID();

					@DSREF(cls = "VehicleID")
					@AAA(msg = {
					//
					"name=N5203,car=0..999,boro=",//
					})
					public class tw_VehicleID {

						public tw_VehicleID() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "VehicleID. VIN. Identifier", uid = "TW022", cls = "VehicleID")
						@AAA(msg = {
						//
						"name=N5203,car=1,boro=,chn=車身號碼",//
						})
						public String tw_VINID;

					}

					public Temperature Temperature = new Temperature();

					@DSREF(cls = "Temperature")
					public class Temperature {

						public Temperature() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Temperature. Actual. Measure", uid = "320", cls = "Temperature")
						public String ActualMeasure;
						@DSREF(den = "Temperature. Category. Code", uid = "319", cls = "Temperature")
						public String CategoryCode;
						@DSREF(den = "Temperature. Storage Requirement. Measure", uid = "321", cls = "Temperature")
						public String StorageRequirementMeasure;
					}

					public VehicleOwner VehicleOwner = new VehicleOwner();

					@DSREF(cls = "Vehicle Owner")
					public class VehicleOwner {

						public VehicleOwner() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Vehicle Owner. Identification. Identifier", uid = "R100", cls = "Vehicle Owner")
						public String ID;
						@DSREF(den = "Vehicle Owner. Name. Text", uid = "R099", cls = "Vehicle Owner")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public Verifier Verifier = new Verifier();

					@DSREF(cls = "Verifier")
					public class Verifier {

						public Verifier() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Verifier. Identification. Identifier", uid = "R066", cls = "Verifier")
						public String ID;
						@DSREF(den = "Verifier. Name. Text", uid = "R065", cls = "Verifier")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public Veterinarian Veterinarian = new Veterinarian();

					@DSREF(cls = "Veterinarian")
					public class Veterinarian {

						public Veterinarian() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Veterinarian. Identification. Identifier", uid = "R104", cls = "Veterinarian")
						public String ID;
						@DSREF(den = "Veterinarian. Name. Text", uid = "R103", cls = "Veterinarian")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}
				}

				public Control Control = new Control();

				@DSREF(cls = "Control")
				@AAA(msg = {
				//
				"name=N5167,car=1,boro=",//
				})
				public class Control {

					public Control() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Control. Inspection End. Date Time", uid = "356", cls = "Control")
					public String InspectionEndDateTime;

					@DSREF(den = "Control. Inspection Start. Date Time", uid = "355", cls = "Control")
					@AAA(msg = {
					//
					"name=N5167,car=1,boro=,chn=申請派驗日期與時間",//
					})
					public String InspectionStartDateTime;

					@DSREF(den = "Control. Time-Limit. Date Time", uid = "264", cls = "Control")
					public String LimitDateTime;
					@DSREF(den = "Control. Review Place. Identifier", uid = "289", cls = "Control")
					public String ReviewPlaceID;
					public Certifier Certifier = new Certifier();

					@DSREF(cls = "Certifier")
					public class Certifier {

						public Certifier() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Certifier. Identification. Identifier", uid = "R049", cls = "Certifier")
						public String ID;
						@DSREF(den = "Certifier. Name. Text", uid = "R048", cls = "Certifier")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}
				}

				public ExaminationPlace ExaminationPlace = new ExaminationPlace();

				@DSREF(cls = "Examination Place")
				@AAA(msg = {
						//
						"name=N5109,car=0..1,boro=",//
						"name=N5167,car=1,boro=",//
				})
				public class ExaminationPlace {

					public ExaminationPlace() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Examination Place. Identification. Identifier", uid = "L029", cls = "Examination Place")
					@AAA(msg = {
							//
							"name=N5109,car=1,boro=,chn=查驗區代碼",//
							"name=N5167,car=1,boro=,chn=查驗區代碼",//
					})
					public String ID;

					@DSREF(den = "Examination Place. Name. Text", uid = "L069", cls = "Examination Place")
					public String Name;
				}

				public GoodsLocation GoodsLocation = new GoodsLocation();

				@DSREF(cls = "Goods Location")
				public class GoodsLocation {

					public GoodsLocation() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Goods Location. Identification. Identifier", uid = "L017", cls = "Goods Location")
					public String ID;

					@DSREF(den = "Goods Location. Name. Text", uid = "L016", cls = "Goods Location")
					public String Name;
				}

				public GoodsMeasure GoodsMeasure = new GoodsMeasure();

				@DSREF(cls = "Goods Measure")
				@AAA(msg = {
						//
						"name=N5135,car=1,boro=",//
						"name=N5203,car=1,boro=",//
						"name=N5205,car=1,boro=",//
						"name=N5401,car=1,boro=",//
						"name=N5402,car=1,boro=",//
						"name=NX201_01,car=1,boro=",//
						"name=NX201_07,car=0..1,boro=",//
						"name=NX202,car=0..1,boro=",//
						"name=NX301,car=1,boro=",//
						"name=NX301_DN,car=1,boro=",//
						"name=NX401,car=1,boro=",//
						"name=NX5105,car=1,boro=",//
						"name=NX601,car=1,boro=",//
						"name=NX603,car=1,boro=",//
						"name=NX801,car=1,boro=",//
						"name=NX802,car=0..1,boro=",//
				})
				public class GoodsMeasure {

					public GoodsMeasure() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Goods Measure. Gross Mass. Measure", uid = "126", cls = "Goods Measure")
					public String GrossMassMeasure;
					@DSREF(den = "Goods Measure. Net Weight. Measure", uid = "128", cls = "Goods Measure")
					@AAA(msg = {
							//
							"name=N5135,car=1,boro=,chn=淨重",//
							"name=N5203,car=1,boro=,chn=淨重",//
							"name=N5205,car=1,boro=,chn=淨重",//
							"name=NX301,car=1,boro=,chn=淨重",//
							"name=NX401,car=1,boro=,chn=淨重",//
							"name=NX5105,car=1,boro=,chn=淨重",//
							"name=NX601,car=1,boro=,chn=淨重",//
							"name=NX603,car=1,boro=,chn=淨重",//
							"name=NX801,car=0..1,boro=,chn=淨重",//
					})
					public String NetNetWeightMeasure;

					@DSREF(den = "Goods Measure. Tariff. Quantity", uid = "130", cls = "Goods Measure")
					@AAA(msg = {
							//
							"name=N5135,car=1,boro=,chn=數量",//
							"name=N5203,car=1,boro=,chn=數量",//
							"name=N5205,car=1,boro=,chn=數量",//
							"name=NX201_01,car=1,boro=,chn=數量",//
							"name=NX301,car=1,boro=,chn=數量",//
							"name=NX301_DN,car=1,boro=,chn=數量",//
							"name=NX401,car=1,boro=,chn=數量",//
							"name=NX5105,car=1,boro=,chn=數量",//
							"name=NX603,car=1,boro=,chn=數量",//
							"name=NX801,car=1,boro=,chn=數量",//
							"name=NX802,car=1,boro=,chn=核銷數量",//
					})
					public String TariffQuantity;

					@DSREF(den = "Goods Measure. Tariff Quantity. Amount", uid = "324", cls = "Goods Measure")
					public String TariffQuantityAmount;

					@DSREF(den = "Goods Measure. Unit. Code", uid = "TW026", cls = "Goods Measure")
					@AAA(msg = {
							//
							"name=N5135,car=1,boro=,chn=數量單位",//
							"name=N5203,car=1,boro=,chn=數量單位",//
							"name=N5205,car=1,boro=,chn=數量單位",//
							"name=N5401,car=1,boro=,chn=數量單位",//
							"name=N5402,car=1,boro=,chn=數量單位",//
							"name=NX201_01,car=1,boro=,chn=數量單位",//
							"name=NX301,car=1,boro=,chn=數量單位",//
							"name=NX301_DN,car=1,boro=,chn=數量單位",//
							"name=NX401,car=1,boro=,chn=數量單位",//
							"name=NX5105,car=1,boro=,chn=數量單位",//
							"name=NX603,car=1,boro=,chn=數量單位",//
							"name=NX801,car=1,boro=,chn=數量單位",//
					})
					public String tw_UnitCode;
				}

				public GovernmentProcedure GovernmentProcedure = new GovernmentProcedure();

				@DSREF(cls = "Government Procedure")
				@AAA(msg = {
						//
						"name=N5167,car=1,boro=",//
						"name=N5203,car=1,boro=",//
						"name=N5205,car=1,boro=",//
						"name=N5401,car=0..1,boro=",//
						"name=N5402,car=0..1,boro=",//
						"name=NX5105,car=0..1,boro=",//
						"name=NX601,car=1,boro=",//
						"name=NX802,car=0..1,boro=",//
				})
				public class GovernmentProcedure {

					public GovernmentProcedure() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Government Procedure. Current. Code", uid = "166", cls = "Government Procedure")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=統計方式代碼",//
							"name=N5205,car=1,boro=,chn=統計方式代碼",//
					})
					public String CurrentCode;

					@DSREF(den = "Government Procedure. Description. Text", uid = "353", cls = "Government Procedure")
					public String Description;

					@DSREF(den = "Government Procedure. Previous. Code", uid = "161", cls = "Government Procedure")
					public String PreviousCode;

					@DSREF(den = "Government Procedure. Goods Status. Code", uid = "094", cls = "Government Procedure")
					public String tw_GoodsStatusCode;

					@DSREF(den = "Government Procedure. Advanced Release. Text", uid = "TW077", cls = "Government Procedure")
					@AAA(msg = {
					//
					"name=NX802,car=1,boro=,chn=臨時通關/先行放行",//
					})
					public String tw_AdvancedRelease;

					@DSREF(den = "Government Procedure. Transport Type. Code", uid = "TW051", cls = "Government Procedure")
					public String tw_TransportTypeCode;
				}

				public Manufacturer Manufacturer = new Manufacturer();

				@DSREF(cls = "Manufacturer")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=#",//
						"name=NX301,car=1,boro=",//
						"name=NX301_DN,car=1,boro=",//
						"name=NX5105,car=0..1,boro=",//
						"name=NX601,car=1,boro=",//
						"name=NX603,car=1,boro=",//
				})
				public class Manufacturer {

					public Manufacturer() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Manufacturer. Identification. Identifier", uid = "R043", cls = "Manufacturer")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=,chn=製造廠商統一編號",//
							"name=NX5105,car=0..1,boro=,chn=國外製造廠代碼",//
							"name=NX603,car=0..1,boro=,chn=國外製造廠代碼",//
					})
					public String ID;

					@DSREF(den = "Manufacturer. Name. Text", uid = "R042", cls = "Manufacturer")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=製造廠商名稱",//
							"name=NX301,car=1,boro=,chn=國外製造廠名稱",//
							"name=NX301_DN,car=1,boro=,chn=國外製造廠名稱",//
							"name=NX5105,car=1,boro=,chn=國外製造廠名稱",//
							"name=NX603,car=1,boro=,chn=國外製造廠名稱",//
					})
					public String Name;

					@DSREF(den = "Manufacturer. State. Identifier", uid = "TW_089", cls = "Manufacturer")
					public String tw_StateID;

					@DSREF(den = "Manufacturer. State Name. Text", uid = "TW093", cls = "Manufacturer")
					public String tw_StateName;

					@DSREF(den = "Manufacturer. Type. Code", uid = "TW104", cls = "Manufacturer")
					@AAA(msg = {
					//
					"name=N5203,car=0..1,boro=,chn=身分識別代碼",//
					})
					public String tw_TypeCode;

					public Address Address = new Address();

					@DSREF(cls = "Address")
					@AAA(msg = {
							//
							"name=NX301,car=0..1,boro=",//
							"name=NX301_DN,car=1,boro=",//
							"name=NX5105,car=0..1,boro=",//
							"name=NX601,car=1,boro=",//
							"name=NX603,car=0..1,boro=",//
					})
					public class Address {

						public Address() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
						public String CityName;
						@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
						public String CountryCode;

						@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
						@AAA(msg = {
						//
						"name=NX5105,car=0..1,boro=,chn=國外製造廠州別代碼",//
						})
						public String CountrySubDivisionID;

						@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
						@AAA(msg = {
						//
						"name=NX5105,car=0..1,boro=,chn=國外製造廠州別名稱",//
						})
						public String CountrySubDivisionName;

						@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
						@AAA(msg = {
								//
								"name=NX301,car=1,boro=,chn=國外製造廠地址",//
								"name=NX301_DN,car=1,boro=,chn=國外製造廠地址",//
								"name=NX5105,car=0..1,boro=,chn=國外製造廠地址",//
								"name=NX603,car=1,boro=,chn=國外製造廠地址",//
						})
						public String Line;

						@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
						public String PostcodeID;
					}

					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}

					public Contact Contact = new Contact();

					@DSREF(cls = "Contact")
					public class Contact {

						public Contact() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
						public String Name;
						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}
					}
				}

				public Origin Origin = new Origin();

				@DSREF(cls = "Origin")
				@AAA(msg = {
						//
						"name=N5135,car=0..1,boro=",//
						"name=N5203,car=0..1,boro=",//
						"name=N5401,car=1,boro=",//
						"name=N5402,car=1,boro=",//
						"name=NX201_01,car=0..1,boro=",//
						"name=NX201_07,car=0..1,boro=",//
						"name=NX202,car=0..1,boro=",//
						"name=NX301,car=1,boro=",//
						"name=NX301_DN,car=1,boro=",//
						"name=NX401,car=1,boro=",//
						"name=NX5105,car=1,boro=",//
						"name=NX601,car=1,boro=",//
						"name=NX603,car=1,boro=",//
						"name=NX801,car=0..1,boro=",//
				})
				public class Origin {

					public Origin() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Origin. Country. Code", uid = "063", cls = "Origin")
					@AAA(msg = {
							//
							"name=N5135,car=1,boro=,chn=生產國別代碼",//
							"name=N5203,car=1,boro=,chn=生產國別代碼",//
							"name=N5401,car=1,boro=,chn=生產國別代碼",//
							"name=N5402,car=1,boro=,chn=生產國別代碼",//
							"name=NX301,car=1,boro=,chn=生產國別代碼",//
							"name=NX401,car=1,boro=,chn=生產國別代碼",//
							"name=NX5105,car=1,boro=,chn=生產國別代碼",//
							"name=NX603,car=1,boro=,chn=生產國別代碼",//
							"name=NX801,car=1,boro=,chn=生產國別代碼",//
					})
					public String CountryCode;

					@DSREF(den = "Origin. Region. Identifier", uid = "066", cls = "Origin")
					public String RegionID;

					public AdditionalDocument AdditionalDocument = new AdditionalDocument();

					@DSREF(cls = "Additional Document")
					@AAA(msg = {
					//
					"name=NX5105,car=0..1,boro=+",//
					})
					public class AdditionalDocument {

						public AdditionalDocument() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Additional Document. Authentication Location Name. Text", uid = "D017", cls = "Additional Document")
						public String AuthenticationLocationName;

						@DSREF(den = "Additional Document. Identification. Identifier", uid = "D005", cls = "Additional Document")
						@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=產地證明書號碼",//
						})
						public String ID;

						@DSREF(den = "Additional Document. Sequence. Numeric", uid = "006", cls = "Additional Document")
						@AAA(msg = {
						//
						"name=NX5105,car=0..1,boro=*,chn=產地證明書項次",//
						})
						public String tw_SequenceNumeric;

					}

				}

				public Packaging Packaging = new Packaging();

				@DSREF(cls = "Packaging")
				@AAA(msg = {
						//
						"name=N5201,car=1,boro=",//
						"name=N5203,car=0..1,boro=",//
						"name=NX301,car=0..1,boro=",//
						"name=NX301_DN,car=1,boro=",//
						"name=NX401,car=1,boro=",//
						"name=NX5105,car=0..1,boro=",//
						"name=NX601,car=1,boro=",//
						"name=NX603,car=1,boro=",//
				})
				public class Packaging {

					public Packaging() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Packaging. Marks Numbers. Text", uid = "142", cls = "Packaging")
					public String MarksNumbers;

					@DSREF(den = "Packaging. Packaging Material Description. Text", uid = "344", cls = "Packaging")
					// @N5201(car = "0..1", chn = "包裝說明")
					public String PackagingMaterialDescription;

					@DSREF(den = "Packaging. Quantity. Quantity", uid = "144", cls = "Packaging")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=件數",//
							"name=NX301,car=1,boro=,chn=件數",//
							"name=NX301_DN,car=1,boro=,chn=件數",//
							"name=NX401,car=1,boro=,chn=件數",//
							"name=NX5105,car=1,boro=,chn=件數",//
							"name=NX601,car=1,boro=,chn=件數",//
							"name=NX603,car=1,boro=,chn=件數",//
					})
					public String QuantityQuantity;

					@DSREF(den = "Packaging. Size Description. Text", uid = "367", cls = "Packaging")
					public String SizeDescription;

					@DSREF(den = "Packaging. Volume. Measure", uid = "395", cls = "Packaging")
					public String VolumeMeasure;

					@DSREF(den = "Packaging. Material. Code", uid = "TW112", cls = "Packaging")
					public String tw_MaterialCode;

					@DSREF(den = "Packaging. Specification. Text", uid = "TW110", cls = "Packaging")
					public String tw_Specification;

					@DSREF(den = "Packaging. Type. Code", uid = "141", cls = "Packaging")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=件數單位",//
							"name=NX301,car=1,boro=,chn=件數單位",//
							"name=NX301_DN,car=1,boro=,chn=件數單位",//
							"name=NX401,car=1,boro=,chn=件數單位",//
							"name=NX5105,car=1,boro=,chn=件數單位",//
							"name=NX601,car=1,boro=,chn=件數單位",//
							"name=NX603,car=1,boro=,chn=件數單位",//
					})
					public String TypeCode;

				}

				public PreviousDocument PreviousDocument = new PreviousDocument();

				@DSREF(cls = "Previous Document")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=",//
						"name=NX301,car=0..1,boro=",//
						"name=NX301_DN,car=0..1,boro=",//
						"name=NX302,car=0..1,boro=",//
						"name=NX302_DN,car=1,boro=",//
						"name=NX401,car=0..1,boro=",//
						"name=NX402,car=1,boro=",//
						"name=NX5105,car=0..1,boro=",//
						"name=NX601,car=0..1,boro=",//
						"name=NX602,car=1,boro=",//
						"name=NX603,car=0..1,boro=",//
						"name=NX901,car=1,boro=",//
						"name=NX902,car=1,boro=",//
						"name=NX903,car=1,boro=",//
				})
				public class PreviousDocument {

					public PreviousDocument() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Previous Document. Identification. Identifier", uid = "D018", cls = "Previous Document")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=原進口報單號碼",//
							"name=NX5105,car=1,boro=,chn=原出口報單號碼",//
					})
					public String ID;

					@DSREF(den = "Previous Document. Issue. Date Time", uid = "D010", cls = "Previous Document")
					public String IssueDateTime;

					@DSREF(den = "Previous Document. Line. Numeric", uid = "171", cls = "Previous Document")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=#,chn=原進口報單項次",//
							"name=NX5105,car=1,boro=,chn=原出口報單項次",//
					})
					public String SequenceNumeric;

					@DSREF(den = "Previous Document. Functional Reference. Identifier", uid = "D026", cls = "Previous Document")
					@AAA(msg = {
					//
					"name=NX903,car=0..1,boro=*,chn=原訊息編號",//
					})
					public String tw_FunctionalReferenceID;

					@DSREF(den = "Previous Document. Import Export Permit. Identifier", uid = "TW_094", cls = "Previous Document")
					public String tw_ImportExportPermitID;

					@DSREF(den = "Previous Document. Universally Unique. Identifier", uid = "TW130", cls = "Previous Document")
					@AAA(msg = {
					//
					"name=NX903,car=1,boro=,chn=原訊息UUID",//
					})
					public String tw_UniversallyUniqueID;

					@DSREF(den = "Previous Document. Type. Code", uid = "D019", cls = "Previous Document")
					@AAA(msg = {
					//
					"name=NX903,car=1,boro=,chn=原訊息類別",//
					})
					public String TypeCode;

					public Submitter Submitter = new Submitter();

					@DSREF(cls = "Submitter")
					public class Submitter {

						public Submitter() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Submitter. Identification. Identifier", uid = "R059", cls = "Submitter")
						public String ID;
						@DSREF(den = "Submitter. Name. Text", uid = "R058", cls = "Submitter")
						public String Name;

					}
				}

				public RegisteredFacility RegisteredFacility = new RegisteredFacility();

				@DSREF(cls = "Registered Facility")
				public class RegisteredFacility {

					public RegisteredFacility() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Registered Facility. Identification. Identifier", uid = "L086", cls = "Registered Facility")
					public String ID;
					@DSREF(den = "Registered Facility. Name. Text", uid = "L085", cls = "Registered Facility")
					public String Name;
				}

				public Status_Moved Status = new Status_Moved();

				@DSREF(cls = "Status")
				@AAA(msg = {
						//
						"name=NX5106,car=1..9,boro=+",//
						"name=NX901,car=1..99,boro=+",//
				})
				public class Status_Moved {

					public Status_Moved() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Status. Effective. Date Time", uid = "380", cls = "Status")
					public String EffectiveDateTime;
					@DSREF(den = "Status. Release. Date Time", uid = "277", cls = "Status")
					public String ReleaseDateTime;

					@DSREF(den = "Status. Name. Code", uid = "379", cls = "Status")
					@AAA(msg = {
							//
							"name=NX5106,car=1,boro=,chn=回應狀況代碼",//
							"name=NX901,car=1,boro=,chn=回應狀況代碼",//
					})
					public String NameCode;

					@DSREF(den = "Status. Content. Text", uid = "105", cls = "Status")
					public String tw_Content;
				}

				public TransportEquipment TransportEquipment = new TransportEquipment();

				@DSREF(cls = "Transport Equipment")
				@AAA(msg = {
				//
				"name=N5167,car=0..9999,boro=+",//
				})
				public class TransportEquipment {

					public TransportEquipment() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Transport Equipment. Characteristic. Code", uid = "152", cls = "Transport Equipment")
					@AAA(msg = {
					//
					"name=N5167,car=1,boro=#,chn=貨櫃種類",//
					})
					public String CharacteristicCode;

					@DSREF(den = "Transport Equipment. Identification. Identifier", uid = "159", cls = "Transport Equipment")
					@AAA(msg = {
					//
					"name=N5167,car=1,boro=,chn=貨櫃號碼",//
					})
					public String ID;

					@DSREF(den = "Transport Equipment. Current. Code", uid = "166", cls = "Transport Equipment")
					public String tw_CurrentCode;

					@DSREF(den = "Transport Equipment. Used Capacity. Code", uid = "TW030", cls = "Transport Equipment")
					@AAA(msg = {
					//
					"name=N5167,car=1,boro=,chn=貨櫃裝運方式",//
					})
					public String tw_UsedCapacityCode;

					@DSREF(den = "Transport Equipment. License Plate Issuing Country. Code", uid = "279", cls = "Transport Equipment")
					public String LicensePlateIssuingCountryCode;
					@DSREF(den = "Transport Equipment. Registration Country Subdivision. Code", uid = "293", cls = "Transport Equipment")
					public String RegistrationCountrySubdivisionCode;
					@DSREF(den = "Transport Equipment. Sequence. Numeric", uid = "006", cls = "Transport Equipment")
					public String SequenceNumeric;

					public tw_Seal tw_Seal = new tw_Seal();

					@DSREF(cls = "Seal")
					@AAA(msg = {
					//
					"name=N5167,car=0..10,boro=",//
					})
					public class tw_Seal {

						public tw_Seal() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Seal. Seal. Identifier", uid = "165", cls = "Seal")
						@AAA(msg = {
						//
						"name=N5167,car=1,boro=*,chn=封條號碼",//
						})
						public String tw_SealID;

					}

				}

				public TravelDocument TravelDocument = new TravelDocument();

				@DSREF(cls = "Travel Document")
				public class TravelDocument {

					public TravelDocument() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Travel Document. Issue Location. Text", uid = "D027", cls = "Travel Document")
					public String IssueLocation;
					public Authenticator Authenticator = new Authenticator();

					@DSREF(cls = "Authenticator")
					public class Authenticator {

						public Authenticator() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Authenticator. Identification. Identifier", uid = "R008", cls = "Authenticator")
						public String ID;
						@DSREF(den = "Authenticator. Name. Text", uid = "R007", cls = "Authenticator")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}

					public Submitter Submitter = new Submitter();

					@DSREF(cls = "Submitter")
					public class Submitter {

						public Submitter() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Submitter. Identification. Identifier", uid = "R059", cls = "Submitter")
						public String ID;
						@DSREF(den = "Submitter. Name. Text", uid = "R058", cls = "Submitter")
						public String Name;
						public Address Address = new Address();

						@DSREF(cls = "Address")
						public class Address {

							public Address() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
							public String CityName;
							@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
							public String CountryCode;
							@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
							public String CountrySubDivisionID;
							@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
							public String CountrySubDivisionName;
							@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
							public String Line;
							@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
							public String PostcodeID;
						}

						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;
							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;
								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}
						}
					}
				}

				public tw_AdditionalDeclaration tw_AdditionalDeclaration = new tw_AdditionalDeclaration();

				@DSREF(cls = "Additional Declaration")
				@AAA(msg = {
				//
				"name=N5167,car=1,boro=",//
				})
				public class tw_AdditionalDeclaration {

					public tw_AdditionalDeclaration() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Additional Declaration. Identification. Identifier", uid = "D014", cls = "Additional Declaration")
					@AAA(msg = {
					//
					"name=N5167,car=1,boro=*,chn=報單號碼",//
					})
					public String tw_ID;

				}

				public tw_Application tw_Application = new tw_Application();

				@DSREF(cls = "Application")
				@AAA(msg = {
						//
						"name=NX301,car=0..1,boro=",//
						"name=NX301_DN,car=0..1,boro=",//
						"name=NX401,car=0..1,boro=",//
						"name=NX402,car=1,boro=",//
						"name=NX5105,car=0..4,boro=",//
						"name=NX601,car=0..1,boro=",//
						"name=NX603,car=0..1,boro=",//
						"name=NX801,car=0..1,boro=",//
				})
				public class tw_Application {

					public tw_Application() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Application. Declaration Office. Identifier", uid = "065", cls = "Application")
					public String tw_DeclarationOfficeID;

					@DSREF(den = "Application. Type. Code", uid = "TW106", cls = "Application")
					public String TypeCode;

					public ContactOffice ContactOffice = new ContactOffice();

					@DSREF(cls = "Contact Office")
					public class ContactOffice {

						public ContactOffice() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Contact Office. Identification. Identifier", uid = "G002", cls = "Contact Office")
						public String ID;

					}

					public PreviousDocument PreviousDocument = new PreviousDocument();

					@DSREF(cls = "Previous Document")
					public class PreviousDocument {

						public PreviousDocument() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Previous Document. Identification. Identifier", uid = "D018", cls = "Previous Document")
						public String ID;

						@DSREF(den = "Previous Document. Issue. Date Time", uid = "D010", cls = "Previous Document")
						public String IssueDateTime;

						@DSREF(den = "Previous Document. Line. Numeric", uid = "171", cls = "Previous Document")
						public String SequenceNumeric;

					}

					public ResponsibleGovernmentAgency ResponsibleGovernmentAgency = new ResponsibleGovernmentAgency();

					@DSREF(cls = "Responsible Government Agency")
					public class ResponsibleGovernmentAgency {

						public ResponsibleGovernmentAgency() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Responsible Government Agency. Identification. Identifier", uid = "R062", cls = "Responsible Government Agency")
						public String ID;
					}

					public Payment Payment = new Payment();

					@DSREF(cls = "Payment")
					public class Payment {

						public Payment() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Payment. Method. Code", uid = "107", cls = "Payment")
						public String MethodCode;

					}

				}

				public tw_ApprovalDocument tw_ApprovalDocument = new tw_ApprovalDocument();

				@DSREF(cls = "Approval Document")
				@AAA(msg = {
						//
						"name=NX301,car=0..1,boro=",//
						"name=NX5105,car=0..1,boro=",//
				})
				public class tw_ApprovalDocument {

					public tw_ApprovalDocument() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Approval Document. Identification. Identifier", uid = "TW_094", cls = "Approval Document")
					public String tw_ID;

					@DSREF(den = "Approval Document. LPCO Exemption. Code", uid = "360", cls = "Approval Document")
					@AAA(msg = {
							//
							"name=NX301,car=0..1,boro=*,chn=免經型式認可原因",//
							"name=NX5105,car=0..1,boro=*,chn=免經型式認可原因",//
					})
					public String tw_LPCOExemptionCode;

					@DSREF(den = "Approval Document. LPCO. Identifier", uid = "TW096", cls = "Approval Document")
					@AAA(msg = {
							//
							"name=NX301,car=0..1,boro=,chn=型式認可證號",//
							"name=NX5105,car=0..1,boro=,chn=型式認可證號",//
					})
					public String tw_LPCOID;

					public LPCOAuthorizedParty LPCOAuthorizedParty = new LPCOAuthorizedParty();

					@DSREF(cls = "LPCO Authorized Party")
					@AAA(msg = {
							//
							"name=NX301,car=0..1,boro=+",//
							"name=NX5105,car=0..1,boro=+",//
					})
					public class LPCOAuthorizedParty {

						public LPCOAuthorizedParty() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "LPCO Authorized Party. Identification. Identifier", uid = "R086", cls = "LPCO Authorized Party")
						@AAA(msg = {
								//
								"name=NX301,car=1,boro=,chn=型式認可證號授權人統一編號",//
								"name=NX5105,car=1,boro=,chn=型式認可證號授權人統一編號",//
						})
						public String ID;

						@DSREF(den = "LPCO Authorized Party. Type. Code", uid = "TW104", cls = "LPCO Authorized Party")
						@AAA(msg = {
								//
								"name=NX301,car=1,boro=,chn=身分識別代碼",//
								"name=NX5105,car=1,boro=,chn=身分識別代碼",//
						})
						public String tw_TypeCode;

					}

				}

				public tw_CommoditySpecification tw_CommoditySpecification = new tw_CommoditySpecification();

				@DSREF(cls = "Commodity Specification")
				@AAA(msg = {
						//
						"name=NX301,car=0..1,boro=",//
						"name=NX5105,car=0..1,boro=",//
						"name=NX603,car=0..1,boro=",//
				})
				public class tw_CommoditySpecification {

					public tw_CommoditySpecification() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Commodity Specification. Characteristic Qualifier. Code", uid = "334", cls = "Commodity Specification")
					@AAA(msg = {
							//
							"name=NX301,car=0..1,boro=*,chn=貨品規格代碼",//
							"name=NX5105,car=0..1,boro=*,chn=貨品規格代碼",//
							"name=NX603,car=0..1,boro=*,chn=貨品規格代碼",//
					})
					public String tw_CharacteristicQualifierCode;

					@DSREF(den = "Commodity Specification. Element Description. Text", uid = "259", cls = "Commodity Specification")
					@AAA(msg = {
							//
							"name=NX301,car=0..1,boro=*,chn=貨品規格內容",//
							"name=NX5105,car=0..1,boro=*,chn=貨品規格內容",//
							"name=NX603,car=0..1,boro=*,chn=貨品規格內容",//
					})
					public String tw_ElementDescription;

				}

				public tw_Error tw_Error = new tw_Error();

				@DSREF(cls = "Error")
				@AAA(msg = {
						//
						"name=N5107,car=1..9,boro=+",//
						"name=N5403,car=1..9,boro=+",//
						"name=NX302,car=0..99,boro=+",//
						"name=NX302_DN,car=0..99,boro=+",//
						"name=NX402,car=0..99,boro=+",//
						"name=NX5106,car=1..9,boro=+",//
						"name=NX602,car=1..99,boro=+",//
				})
				public class tw_Error {

					public tw_Error() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Error. Validation. Code", uid = "377", cls = "Error")
					@AAA(msg = {
							//
							"name=N5107,car=1,boro=,chn=應補辦事項代碼",//
							"name=N5403,car=1,boro=,chn=不符原因代碼",//
							"name=NX302,car=1,boro=,chn=不合格原因代碼",//
							"name=NX302_DN,car=1,boro=,chn=不合格原因代碼",//
							"name=NX402,car=0..1,boro=,chn=不合格原因代碼",//
							"name=NX602,car=1,boro=,chn=不合格原因代碼",//
					})
					public String ValidationCode;

					public AdditionalInformation AdditionalInformation = new AdditionalInformation();

					@DSREF(cls = "Additional Information")
					@AAA(msg = {
					//
					"name=NX402,car=0..1,boro=+",//
					})
					public class AdditionalInformation {

						public AdditionalInformation() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Additional Information. Content. Text", uid = "105", cls = "Additional Information")
						@AAA(msg = {
						//
						"name=NX402,car=1,boro=,chn=說明",//
						})
						public String Content;
					}
				}

				public tw_GoodsStatisticalMeasure tw_GoodsStatisticalMeasure = new tw_GoodsStatisticalMeasure();

				@DSREF(cls = "Goods Statistical Measure")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=",//
						"name=NX301,car=0..1,boro=",//
						"name=NX301_DN,car=1,boro=",//
						"name=NX401,car=1,boro=",//
						"name=NX5105,car=0..1,boro=",//
						"name=NX601,car=0..1,boro=",//
						"name=NX603,car=1,boro=",//
				})
				public class tw_GoodsStatisticalMeasure {

					public tw_GoodsStatisticalMeasure() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Goods Statistical Measure. Statistical Unit. Code", uid = "TW027", cls = "Goods Statistical Measure")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=統計數量單位",//
							"name=NX301,car=1,boro=,chn=統計數量單位",//
							"name=NX301_DN,car=1,boro=,chn=統計數量單位",//
							"name=NX401,car=1,boro=,chn=統計數量單位",//
							"name=NX5105,car=1,boro=,chn=統計數量單位",//
							"name=NX603,car=1,boro=,chn=統計數量單位",//
					})
					public String tw_StatisticalUnitCode;

					@DSREF(den = "Goods Statistical Measure. Tariff. Quantity", uid = "130", cls = "Goods Statistical Measure")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=*,chn=統計數量",//
							"name=NX301,car=1,boro=*,chn=統計數量",//
							"name=NX301_DN,car=1,boro=*,chn=統計數量",//
							"name=NX401,car=1,boro=*,chn=統計數量",//
							"name=NX5105,car=1,boro=*,chn=統計數量",//
							"name=NX603,car=1,boro=*,chn=統計數量",//
					})
					public String tw_TariffQuantity;

				}

				public tw_MedicalInstrument tw_MedicalInstrument = new tw_MedicalInstrument();

				@DSREF(cls = "Medical Instrument")
				@AAA(msg = {
						//
						"name=NX5105,car=0..1,boro=",//
						"name=NX603,car=0..1,boro=",//
				})
				public class tw_MedicalInstrument {

					public tw_MedicalInstrument() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Medical Instrument. LPCO. Identifier", uid = "TW152", cls = "Medical Instrument")
					@AAA(msg = {
							//
							"name=NX5105,car=1,boro=,chn=醫療器材許可證簽審文件編號",//
							"name=NX603,car=1,boro=,chn=醫療器材許可證簽審文件編號",//
					})
					public String tw_LPCOID;

					public LPCOAuthorizedParty LPCOAuthorizedParty = new LPCOAuthorizedParty();

					@DSREF(cls = "LPCO Authorized Party")
					@AAA(msg = {
							//
							"name=NX5105,car=0..1,boro=+",//
							"name=NX603,car=0..1,boro=+",//
					})
					public class LPCOAuthorizedParty {

						public LPCOAuthorizedParty() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "LPCO Authorized Party. Identification. Identifier", uid = "R086", cls = "LPCO Authorized Party")
						@AAA(msg = {
								//
								"name=NX5105,car=1,boro=,chn=醫療器材許可證授權人統一編號",//
								"name=NX603,car=1,boro=,chn=醫療器材許可證授權人統一編號",//
						})
						public String ID;

						@DSREF(den = "LPCO Authorized Party. Type. Code", uid = "TW104", cls = "LPCO Authorized Party")
						@AAA(msg = {
								//
								"name=NX5105,car=1,boro=,chn=身分識別代碼",//
								"name=NX603,car=1,boro=,chn=身分識別代碼",//
						})
						public String tw_TypeCode;

					}

				}

				//
				public tw_PreBondedDocument tw_PreBondedDocument = new tw_PreBondedDocument();

				@DSREF(cls = "PreBonded Document")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=",//
						"name=NX5105,car=0..1,boro=",//
						"name=NX801,car=0..1,boro=",//
				})
				public class tw_PreBondedDocument {

					public tw_PreBondedDocument() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "PreBonded Document. Identification. Identifier", uid = "TW086", cls = "PreBonded Document")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=,chn=原進倉報單號碼",//
							"name=NX5105,car=1,boro=,chn=原進倉報單號碼",//
							"name=NX801,car=1,boro=,chn=原進倉報單號碼",//
					})
					public String tw_ID;

					@DSREF(den = "PreBonded Document. Line. Numeric", uid = "171", cls = "PreBonded Document")
					@AAA(msg = {
							//
							"name=N5203,car=1,boro=*,chn=原進倉報單項次",//
							"name=NX5105,car=1,boro=*,chn=原進倉報單項次",//
							"name=NX801,car=1,boro=*,chn=原進倉報單項次",//
					})
					public String tw_LineNumeric;

				}

				public tw_ShippingIdentification tw_ShippingIdentification = new tw_ShippingIdentification();

				@DSREF(cls = "Shipping Identification")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=",//
						"name=NX301,car=0..1,boro=",//
						"name=NX301_DN,car=1,boro=",//
						"name=NX401,car=1,boro=",//
						"name=NX5105,car=0..99,boro=",//
						"name=NX601,car=0..99,boro=",//
						"name=NX603,car=0..1,boro=",//
				})
				public class tw_ShippingIdentification {

					public tw_ShippingIdentification() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Shipping Identification. Lot Number. Identifier", uid = "265", cls = "Shipping Identification")
					@AAA(msg = {
							//
							"name=NX301,car=0..1,boro=*,chn=製造批號",//
							"name=NX5105,car=0..1,boro=*,chn=製造批號",//
							"name=NX601,car=0..1,boro=*,chn=製造批號",//
							"name=NX603,car=0..1,boro=*,chn=製造批號",//
					})
					public String tw_LotNumberID;

					@DSREF(den = "Shipping Identification. Product Best Before. Date Time", uid = "266", cls = "Shipping Identification")
					@AAA(msg = {
							//
							"name=NX5105,car=0..1,boro=*,chn=有效日期",//
							"name=NX601,car=1,boro=*,chn=有效日期",//
					})
					public String tw_ProductBestBeforeDateTime;

					@DSREF(den = "Shipping Identification. Product Manufactured. Date", uid = "TW057", cls = "Shipping Identification")
					@AAA(msg = {
							//
							"name=NX301,car=0..1,boro=,chn=製造日期",//
							"name=NX5105,car=0..1,boro=,chn=製造日期",//
							"name=NX601,car=0..1,boro=,chn=製造日期",//
							"name=NX603,car=0..1,boro=,chn=製造日期",//
					})
					public String tw_ProductManufacturedDate;

				}

				public ValuationAdjustment ValuationAdjustment = new ValuationAdjustment();

				@DSREF(cls = "Valuation Adjustment")
				public class ValuationAdjustment {

					public ValuationAdjustment() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Valuation Adjustment. Addition. Code", uid = "188", cls = "Valuation Adjustment")
					public String AdditionCode;
					@DSREF(den = "Valuation Adjustment. Amount. Amount", uid = "125", cls = "Valuation Adjustment")
					public String AmountAmount;
					@DSREF(den = "Valuation Adjustment. Percentage. Percent", uid = "123", cls = "Valuation Adjustment")
					public String PercentagePercent;
				}
			}

			public Invoice Invoice = new Invoice();

			@DSREF(cls = "Invoice")
			public class Invoice {

				public Invoice() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Invoice. Identification. Identifier", uid = "D016", cls = "Invoice")
				public String ID;
				@DSREF(den = "Invoice. Issue. Date Time", uid = "D015", cls = "Invoice")
				public String IssueDateTime;
				@DSREF(den = "Invoice. Sequence. Numeric", uid = "006", cls = "Invoice")
				public String SequenceNumeric;
				@DSREF(den = "Invoice. Type. Code", uid = "D025", cls = "Invoice")
				public String TypeCode;
				public Authenticator Authenticator = new Authenticator();

				@DSREF(cls = "Authenticator")
				public class Authenticator {

					public Authenticator() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Authenticator. Identification. Identifier", uid = "R008", cls = "Authenticator")
					public String ID;
					@DSREF(den = "Authenticator. Name. Text", uid = "R007", cls = "Authenticator")
					public String Name;
					public Address Address = new Address();

					@DSREF(cls = "Address")
					public class Address {

						public Address() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
						public String CityName;
						@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
						public String CountryCode;
						@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
						public String CountrySubDivisionID;
						@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
						public String CountrySubDivisionName;
						@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
						public String Line;
						@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
						public String PostcodeID;
					}

					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}

					public Contact Contact = new Contact();

					@DSREF(cls = "Contact")
					public class Contact {

						public Contact() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
						public String Name;
						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}
					}
				}

				public Submitter Submitter = new Submitter();

				@DSREF(cls = "Submitter")
				public class Submitter {

					public Submitter() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Submitter. Identification. Identifier", uid = "R059", cls = "Submitter")
					public String ID;
					@DSREF(den = "Submitter. Name. Text", uid = "R058", cls = "Submitter")
					public String Name;
					public Address Address = new Address();

					@DSREF(cls = "Address")
					public class Address {

						public Address() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
						public String CityName;
						@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
						public String CountryCode;
						@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
						public String CountrySubDivisionID;
						@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
						public String CountrySubDivisionName;
						@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
						public String Line;
						@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
						public String PostcodeID;
					}

					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}

					public Contact Contact = new Contact();

					@DSREF(cls = "Contact")
					public class Contact {

						public Contact() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
						public String Name;
						public Communication Communication = new Communication();

						@DSREF(cls = "Communication")
						public class Communication {

							public Communication() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
							public String ID;
							@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
							public String TypeID;
						}
					}
				}
			}

			public NotifyParty NotifyParty = new NotifyParty();

			@DSREF(cls = "Notify Party")
			@AAA(msg = {
					//
					"name=N5203,car=0..1,boro=",//
					"name=NX5105,car=0..1,boro=",//
					"name=NX801,car=0..1,boro=",//
					"name=NX802,car=0..1,boro=",//
			})
			public class NotifyParty {

				public NotifyParty() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Notify Party. Identification. Identifier", uid = "R046", cls = "Notify Party")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=,chn=被通知人代碼",//
						"name=NX5105,car=0..1,boro=,chn=被通知人代碼",//
						"name=NX801,car=1,boro=,chn=副本通知人辨識碼",//
						"name=NX802,car=1,boro=,chn=副本通知人辨識碼",//
				})
				public String ID;

				@DSREF(den = "Notify Party. Name. Text", uid = "R045", cls = "Notify Party")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=,chn=被通知人英文名稱",//
						"name=NX5105,car=0..1,boro=,chn=被通知人英文名稱",//
				})
				public String Name;

				@DSREF(den = "Notify Party. Chinese Name. Text", uid = "TW005", cls = "Notify Party")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=,chn=被通知人中文名稱",//
						"name=NX5105,car=0..1,boro=,chn=被通知人中文名稱",//
				})
				public String tw_ChineseName;

				@DSREF(den = "Notify Party. Type. Code", uid = "TW104", cls = "Notify Party")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=,chn=身分識別代碼",//
						"name=NX5105,car=0..1,boro=,chn=身分識別代碼",//
				})
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				@AAA(msg = {
						//
						"name=N5203,car=0..1,boro=",//
						"name=NX5105,car=0..1,boro=",//
				})
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;

					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=,chn=被通知人英文地址",//
							"name=NX5105,car=0..1,boro=,chn=被通知人英文地址",//
					})
					public String Line;

					@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
					@AAA(msg = {
							//
							"name=N5203,car=0..1,boro=,chn=被通知人中文地址",//
							"name=NX5105,car=0..1,boro=,chn=被通知人中文地址",//
					})
					public String tw_ChineseLine;

					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public Origin Origin = new Origin();

			@DSREF(cls = "Origin")
			public class Origin {

				public Origin() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Origin. Country. Code", uid = "063", cls = "Origin")
				public String CountryCode;

			}

			public PermittedPort PermittedPort = new PermittedPort();

			@DSREF(cls = "Permitted Port")
			public class PermittedPort {

				public PermittedPort() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Permitted Port. Identification. Identifier", uid = "L073", cls = "Permitted Port")
				public String ID;
			}

			public PropertyOperator PropertyOperator = new PropertyOperator();

			@DSREF(cls = "Property Operator")
			public class PropertyOperator {

				public PropertyOperator() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Property Operator. Identification. Identifier", uid = "R088", cls = "Property Operator")
				public String ID;
				@DSREF(den = "Property Operator. Name. Text", uid = "R057", cls = "Property Operator")
				public String Name;
				public Address Address = new Address();

				@DSREF(cls = "Address")
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;
					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;
					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public PropertyOwner PropertyOwner = new PropertyOwner();

			@DSREF(cls = "Property Owner")
			public class PropertyOwner {

				public PropertyOwner() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Property Owner. Identification. Identifier", uid = "R098", cls = "Property Owner")
				public String ID;
				@DSREF(den = "Property Owner. Name. Text", uid = "R095", cls = "Property Owner")
				public String Name;
				public Address Address = new Address();

				@DSREF(cls = "Address")
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;
					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;
					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public RegisteredFacility RegisteredFacility = new RegisteredFacility();

			@DSREF(cls = "Registered Facility")
			public class RegisteredFacility {

				public RegisteredFacility() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Registered Facility. Identification. Identifier", uid = "L086", cls = "Registered Facility")
				public String ID;
				@DSREF(den = "Registered Facility. Name. Text", uid = "L085", cls = "Registered Facility")
				public String Name;
			}

			public Seller Seller = new Seller();

			@DSREF(cls = "Seller")
			@AAA(msg = {
					//
					"name=N5401,car=1,boro=",//
					"name=N5402,car=1,boro=",//
					"name=NX201_01,car=0..1,boro=",//
					"name=NX201_07,car=0..1,boro=",//
					"name=NX202,car=0..1,boro=",//
					"name=NX301,car=0..1,boro=",//
					"name=NX301_DN,car=1,boro=",//
					"name=NX401,car=0..1,boro=",//
					"name=NX5105,car=1,boro=",//
					"name=NX601,car=1,boro=",//
					"name=NX603,car=0..1,boro=",//
					"name=NX801,car=0..1,boro=",//
			})
			public class Seller {

				public Seller() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Seller. Identification. Identifier", uid = "R051", cls = "Seller")
				@AAA(msg = {
						//
						"name=N5401,car=1,boro=,chn=出口人(或賣方)統一編號或國外廠商英文名稱縮寫",//
						"name=N5402,car=1,boro=,chn=出口人(或賣方)統一編號或國外廠商英文名稱縮寫",//
						"name=NX301,car=0..1,boro=,chn=出口人(或賣方)統一編號或國外廠商英文名稱縮寫",//
						"name=NX5105,car=0..1,boro=,chn=出口人(或賣方)統一編號或國外廠商英文名稱縮寫",//
						"name=NX601,car=0..1,boro=,chn=出口人(或賣方)統一編號或國外廠商英文名稱縮寫",//
						"name=NX603,car=0..1,boro=,chn=出口人(或賣方)統一編號或國外廠商英文名稱縮寫",//
				})
				public String ID;

				@DSREF(den = "Seller. Name. Text", uid = "R050", cls = "Seller")
				@AAA(msg = {
						//
						"name=N5401,car=1,boro=,chn=出口人(或賣方)英文名稱",//
						"name=N5402,car=1,boro=,chn=出口人(或賣方)英文名稱",//
						"name=NX201_01,car=1,boro=,chn=出口人(或賣方)英文名稱",//
						"name=NX401,car=1,boro=,chn=出口人(或賣方)英文名稱",//
						"name=NX5105,car=1,boro=,chn=出口人(或賣方)英文名稱",//
						"name=NX601,car=1,boro=,chn=出口人(或賣方)英文名稱",//
				})
				public String Name;

				@DSREF(den = "Seller. Chinese Name. Text", uid = "TW008", cls = "Seller")
				@AAA(msg = {
						//
						"name=N5401,car=0..1,boro=,chn=出口人(或賣方)中文名稱",//
						"name=N5402,car=0..1,boro=,chn=出口人(或賣方)中文名稱",//
						"name=NX301,car=0..1,boro=,chn=出口人(或賣方)中文名稱",//
						"name=NX401,car=0..1,boro=,chn=出口人(或賣方)中文名稱",//
						"name=NX5105,car=0..1,boro=,chn=出口人(或賣方)中文名稱",//
						"name=NX601,car=0..1,boro=,chn=出口人(或賣方)中文名稱",//
						"name=NX603,car=0..1,boro=,chn=出口人(或賣方)中文名稱",//
				})
				public String tw_ChineseName;

				@DSREF(den = "Seller. Customs Control. Identifier", uid = "TW003", cls = "Seller")
				@AAA(msg = {
						//
						"name=N5401,car=0..1,boro=,chn=海關監管編號",//
						"name=N5402,car=0..1,boro=,chn=海關監管編號",//
						"name=NX5105,car=0..1,boro=,chn=海關監管編號",//
				})
				public String tw_CustomsControlID;

				@DSREF(den = "Seller. Type. Code", uid = "TW104", cls = "Seller")
				@AAA(msg = {
						//
						"name=N5401,car=1,boro=,chn=身分識別代碼",//
						"name=N5402,car=1,boro=,chn=身分識別代碼",//
						"name=NX301,car=0..1,boro=,chn=身分識別代碼",//
						"name=NX5105,car=0..1,boro=,chn=身分識別代碼",//
						"name=NX601,car=0..1,boro=,chn=身分識別代碼",//
						"name=NX603,car=0..1,boro=,chn=身分識別代碼",//
				})
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				@AAA(msg = {
						//
						"name=N5401,car=1,boro=",//
						"name=N5402,car=1,boro=",//
						"name=NX201_01,car=1,boro=",//
						"name=NX301,car=1,boro=",//
						"name=NX301_DN,car=1,boro=",//
						"name=NX401,car=1,boro=",//
						"name=NX5105,car=1,boro=",//
						"name=NX601,car=1,boro=",//
						"name=NX603,car=1,boro=",//
						"name=NX801,car=0..1,boro=",//
				})
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;

					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					@AAA(msg = {
							//
							"name=NX201_01,car=1,boro=,chn=出口人(或賣方)國家代碼",//
							"name=NX301,car=1,boro=,chn=出口人(或賣方)國家代碼",//
							"name=NX401,car=0..1,boro=,chn=出口人(或賣方)國家代碼",//
							"name=NX5105,car=1,boro=,chn=出口人(或賣方)國家代碼",//
							"name=NX601,car=1,boro=,chn=出口人(或賣方)國家代碼",//
							"name=NX603,car=1,boro=,chn=出口人(或賣方)國家代碼",//
							"name=NX801,car=1,boro=,chn=出口人(或賣方)國家代碼",//
					})
					public String CountryCode;

					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;

					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					@AAA(msg = {
							//
							"name=N5401,car=1,boro=,chn=出口人(或賣方)英文地址",//
							"name=N5402,car=1,boro=,chn=出口人(或賣方)英文地址",//
							"name=NX201_01,car=0..1,boro=,chn=出口人(或賣方)英文地址",//
							"name=NX401,car=1,boro=,chn=出口人(或賣方)英文地址",//
							"name=NX5105,car=1,boro=,chn=出口人(或賣方)英文地址",//
							"name=NX601,car=1,boro=,chn=出口人(或賣方)英文地址",//
					})
					public String Line;

					@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
					@AAA(msg = {
							//
							"name=N5401,car=0..1,boro=,chn=出口人(或賣方)中文地址",//
							"name=N5402,car=0..1,boro=,chn=出口人(或賣方)中文地址",//
							"name=NX401,car=0..1,boro=,chn=出口人(或賣方)中文地址",//
							"name=NX5105,car=0..1,boro=,chn=出口人(或賣方)中文地址",//
							"name=NX601,car=0..1,boro=,chn=出口人(或賣方)中文地址",//
					})
					public String tw_ChineseLine;

					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public Status Status = new Status();

			@DSREF(cls = "Status")
			public class Status {

				public Status() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Status. Requested Assignment. Date Time", uid = "273", cls = "Status")
				public String RequestedAssignmentDateTime;

				@DSREF(den = "Status. Release. Date Time", uid = "277", cls = "Status")
				public String ReleaseTime;
			}

			public StuffingEstablishment StuffingEstablishment = new StuffingEstablishment();

			@DSREF(cls = "Stuffing Establishment")
			public class StuffingEstablishment {

				public StuffingEstablishment() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Stuffing Establishment. Name. Text", uid = "R024", cls = "Stuffing Establishment")
				public String Name;
				public Address Address = new Address();

				@DSREF(cls = "Address")
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;
					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;
					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public Supplier Supplier = new Supplier();

			@DSREF(cls = "Supplier")
			@AAA(msg = {
			//
			"name=N5135,car=0..1,boro=",//
			})
			public class Supplier {

				public Supplier() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Supplier. Identification. Identifier", uid = "R053", cls = "Supplier")
				public String ID;

				@DSREF(den = "Supplier. Name. Text", uid = "R052", cls = "Supplier")
				@AAA(msg = {
				//
				"name=N5135,car=1,boro=,chn=寄件人英文名稱",//
				})
				public String Name;

				@DSREF(den = "Supplier. Chinese Name. Text", uid = "TW062", cls = "Supplier")
				@AAA(msg = {
				//
				"name=N5135,car=0..1,boro=,chn=寄件人中文名稱",//
				})
				public String tw_ChineseName;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;
					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;
					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public Temperature Temperature = new Temperature();

			@DSREF(cls = "Temperature")
			public class Temperature {

				public Temperature() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Temperature. Actual. Measure", uid = "320", cls = "Temperature")
				public String ActualMeasure;
				@DSREF(den = "Temperature. Category. Code", uid = "319", cls = "Temperature")
				public String CategoryCode;
				@DSREF(den = "Temperature. Storage Requirement. Measure", uid = "321", cls = "Temperature")
				public String StorageRequirementMeasure;
			}

			public TradeTerms TradeTerms = new TradeTerms();

			@DSREF(cls = "Trade Terms")
			@AAA(msg = {
					//
					"name=N5135,car=1,boro=",//
					"name=N5203,car=1,boro=",//
					"name=NX5105,car=1,boro=",//
			})
			public class TradeTerms {

				public TradeTerms() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Trade Terms. Condition. Code", uid = "090", cls = "Trade Terms")
				@AAA(msg = {
						//
						"name=N5135,car=1,boro=,chn=交易條件代碼",//
						"name=N5203,car=1,boro=,chn=交易條件代碼",//
						"name=NX5105,car=1,boro=,chn=交易條件代碼",//
				})
				public String ConditionCode;

				@DSREF(den = "Trade Terms. Country Relationship. Code", uid = "106", cls = "Trade Terms")
				public String CountryRelationshipCode;
				@DSREF(den = "Trade Terms. Description. Text", uid = "089", cls = "Trade Terms")
				public String Description;
				@DSREF(den = "Trade Terms. Location. Identifier", uid = "L002", cls = "Trade Terms")
				public String LocationID;
				@DSREF(den = "Trade Terms. Location Name. Text", uid = "L001", cls = "Trade Terms")
				public String LocationName;
			}

			public UCR UCR = new UCR();

			@DSREF(cls = "UCR")
			@AAA(msg = {
					//
					"name=N5203,car=0..1,boro=",//
					"name=NX5105,car=0..1,boro=",//
			})
			public class UCR {

				public UCR() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "UCR. Identification. Identifier", uid = "016", cls = "UCR")
				@AAA(msg = {
						//
						"name=N5203,car=1,boro=,chn=貨物唯一追蹤號碼",//
						"name=NX5105,car=1,boro=,chn=貨物唯一追蹤號碼",//
				})
				public String ID;

				@DSREF(den = "UCR. Trader Assigned Reference. Identifier", uid = "009", cls = "UCR")
				public String TraderAssignedReferenceID;
			}

			public UltimateConsignee UltimateConsignee = new UltimateConsignee();

			@DSREF(cls = "Ultimate Consignee")
			public class UltimateConsignee {

				public UltimateConsignee() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Ultimate Consignee. Identification. Identifier", uid = "R061", cls = "Ultimate Consignee")
				public String ID;
				@DSREF(den = "Ultimate Consignee. Name. Text", uid = "R060", cls = "Ultimate Consignee")
				public String Name;
				public Address Address = new Address();

				@DSREF(cls = "Address")
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;
					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;
					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public Warehouse Warehouse = new Warehouse();

			@DSREF(cls = "Warehouse")
			@AAA(msg = {
					//
					"name=N5116,car=0..1,boro=",//
					"name=N5201,car=1,boro=",//
			})
			public class Warehouse {

				public Warehouse() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Warehouse. Arrival. Date Time", uid = "221", cls = "Warehouse")
				public String ArrivalDateTime;

				@DSREF(den = "Warehouse. Identification. Identifier", uid = "L019", cls = "Warehouse")
				@AAA(msg = {
				//
				"name=N5116,car=1,boro=,chn=進倉保稅倉庫代碼",//
				})
				public String ID;

				@DSREF(den = "Warehouse. Name. Text", uid = "L018", cls = "Warehouse")
				public String Name;

				@DSREF(den = "Warehouse. Storage Area. Code", uid = "TW063", cls = "Warehouse")
				public String tw_StorageAreaCode;

				@DSREF(den = "Warehouse. Storage Location. Text", uid = "TW065", cls = "Warehouse")
				public String tw_StorageLocation;

				@DSREF(den = "Warehouse. Storage Type. Code", uid = "TW064", cls = "Warehouse")
				public String tw_StorageTypeCode;

			}
		}

		public GovernmentProcedure GovernmentProcedure = new GovernmentProcedure();

		@DSREF(cls = "Government Procedure")
		@AAA(msg = {
				//
				"name=N5101,car=1,boro=",//
				"name=N5102,car=1,boro=",//
				"name=N5107,car=1,boro=",//
				"name=N5108,car=1,boro=",//
				"name=N5109,car=1,boro=",//
				"name=N5110,car=1,boro=",//
				"name=N5111,car=1,boro=",//
				"name=N5116,car=1,boro=",//
				"name=N5117,car=1,boro=",//
				"name=N5135,car=1,boro=",//
				"name=N5151,car=1,boro=",//
				"name=N5158,car=1,boro=",//
				"name=N5162,car=1,boro=",//
				"name=N5165,car=1,boro=",//
				"name=N5166,car=1,boro=",//
				"name=N5167,car=1,boro=",//
				"name=N5168,car=1,boro=",//
				"name=N5201,car=1,boro=",//
				"name=N5202,car=1,boro=",//
				"name=N5203,car=0..2,boro=",//
				"name=N5204,car=1,boro=",//
				"name=N5205,car=1,boro=",//
				"name=N5251,car=1,boro=",//
				"name=N5252,car=1,boro=",//
				"name=N5262,car=1,boro=",//
				"name=N5301,car=1,boro=",//
				"name=N5302,car=1,boro=",//
				"name=N5401,car=1,boro=",//
				"name=N5402,car=1,boro=",//
				"name=N5403,car=1,boro=",//
				"name=N5404,car=1,boro=",//
				"name=NX401,car=0..1,boro=",//
				"name=NX5105,car=0..2,boro=",//
				"name=NX5106,car=0..1,boro=",//
				"name=NX801,car=1,boro=",//
				"name=NX802,car=1,boro=",//
				"name=NX901,car=0..1,boro=",//
				"name=NX902,car=0..1,boro=",//
		})
		public class GovernmentProcedure {

			public GovernmentProcedure() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Government Procedure. Current. Code", uid = "166", cls = "Government Procedure")
			@AAA(msg = {
					//
					"name=N5165,car=1,boro=,chn=作業別",//
					"name=NX902,car=0..1,boro=,chn=申辦現況代碼",//
			})
			public String CurrentCode;

			@DSREF(den = "Government Procedure. Description. Text", uid = "353", cls = "Government Procedure")
			@AAA(msg = {
					//
					"name=N5203,car=1,boro=,chn=其他申報事項",//
					"name=NX5105,car=1,boro=,chn=其他申報事項",//
			})
			public String Description;

			@DSREF(den = "Government Procedure. Previous. Code", uid = "161", cls = "Government Procedure")
			public String PreviousCode;

			@DSREF(den = "Government Procedure. Operation Type. Code", uid = "TW050", cls = "Government Procedure")
			public String tw_OperationTypeCode;

			@DSREF(den = "Government Procedure. Transport Type. Code", uid = "TW051", cls = "Government Procedure")
			@AAA(msg = {
					//
					"name=N5107,car=1,boro=,chn=進出口別代碼",//
					"name=N5108,car=1,boro=,chn=進出口別代碼",//
					"name=N5109,car=1,boro=,chn=進出口別代碼",//
					"name=N5162,car=1,boro=,chn=進出口別代碼",//
					"name=N5168,car=1,boro=,chn=進出口別代碼",//
					"name=NX5106,car=1,boro=,chn=進出口別代碼",//
					"name=NX801,car=1,boro=,chn=進出口別代碼",//
					"name=NX802,car=1,boro=,chn=進出口別代碼",//
			})
			public String tw_TransportTypeCode;

			@DSREF(den = "Government Procedure. Transport Status. Code", uid = "TW_054", cls = "Government Procedure")
			public String tw_TransportStatusCode;

		}

		public Importer Importer = new Importer();

		@DSREF(cls = "Importer")
		@AAA(msg = {
				//
				"name=N5109,car=0..1,boro=",//
				"name=N5110,car=1,boro=",//
				"name=N5116,car=1,boro=",//
				"name=N5135,car=1,boro=",//
				"name=N5168,car=0..1,boro=#",//
				"name=NX301,car=1,boro=",//
				"name=NX301_DN,car=1,boro=",//
				"name=NX401,car=1,boro=",//
				"name=NX5105,car=1,boro=",//
				"name=NX601,car=1,boro=",//
				"name=NX603,car=1,boro=",//
				"name=NX801,car=0..1,boro=",//
		})
		public class Importer {

			public Importer() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Importer. Identification. Identifier", uid = "R038", cls = "Importer")
			@AAA(msg = {
					//
					"name=N5109,car=0..1,boro=,chn=進口人(納稅義務人)統一編號",//
					"name=N5110,car=1,boro=,chn=進口人(納稅義務人)統一編號",//
					"name=N5116,car=1,boro=,chn=進口人(納稅義務人)統一編號",//
					"name=N5135,car=1,boro=,chn=進口人(納稅義務人)統一編號",//
					"name=NX301,car=1,boro=,chn=進口人(納稅義務人)統一編號",//
					"name=NX301_DN,car=1,boro=,chn=進口人(納稅義務人)統一編號",//
					"name=NX401,car=1,boro=,chn=進口人(納稅義務人)統一編號",//
					"name=NX5105,car=1,boro=,chn=進口人(納稅義務人)統一編號",//
					"name=NX601,car=1,boro=,chn=進口人(納稅義務人)統一編號",//
					"name=NX603,car=1,boro=,chn=進口人(納稅義務人)統一編號",//
					"name=NX801,car=0..1,boro=,chn=進口人(納稅義務人)統一編號",//
			})
			public String ID;

			@DSREF(den = "Importer. Name. Text", uid = "R037", cls = "Importer")
			@AAA(msg = {
					//
					"name=N5109,car=0..1,boro=,chn=進口人(納稅義務人)英文名稱",//
					"name=N5110,car=0..1,boro=,chn=進口人(納稅義務人)英文名稱",//
					"name=N5116,car=1,boro=,chn=進口人(納稅義務人)英文名稱",//
					"name=N5135,car=1,boro=,chn=進口人(納稅義務人)英文名稱",//
					"name=NX301,car=1,boro=,chn=進口人(納稅義務人)英文名稱",//
					"name=NX401,car=1,boro=,chn=進口人(納稅義務人)英文名稱",//
					"name=NX5105,car=1,boro=,chn=進口人(納稅義務人)英文名稱",//
					"name=NX601,car=1,boro=,chn=進口人(納稅義務人)英文名稱",//
					"name=NX603,car=1,boro=,chn=進口人(納稅義務人)英文名稱",//
					"name=NX801,car=1,boro=,chn=進口人(納稅義務人)英文名稱",//
			})
			public String Name;

			@DSREF(den = "Importer. Chinese Name. Text", uid = "TW001", cls = "Importer")
			@AAA(msg = {
					//
					"name=N5109,car=0..1,boro=,chn=進口人(納稅義務人)中文名稱",//
					"name=N5110,car=0..1,boro=,chn=進口人(納稅義務人)中文名稱",//
					"name=N5116,car=0..1,boro=,chn=進口人(納稅義務人)中文名稱",//
					"name=N5135,car=0..1,boro=,chn=進口人(納稅義務人)中文名稱",//
					"name=NX301,car=1,boro=,chn=進口人(納稅義務人)中文名稱",//
					"name=NX301_DN,car=1,boro=,chn=進口人(納稅義務人)中文名稱",//
					"name=NX401,car=1,boro=,chn=進口人(納稅義務人)中文名稱",//
					"name=NX5105,car=0..1,boro=,chn=進口人(納稅義務人)中文名稱",//
					"name=NX601,car=1,boro=,chn=進口人(納稅義務人)中文名稱",//
					"name=NX603,car=1,boro=,chn=進口人(納稅義務人)中文名稱",//
					"name=NX801,car=0..1,boro=,chn=進口人(納稅義務人)中文名稱",//
			})
			public String tw_ChineseName;

			@DSREF(den = "Importer. Customs Control. Identifier", uid = "TW003", cls = "Importer")
			@AAA(msg = {
					//
					"name=N5116,car=0..1,boro=,chn=海關監管編號",//
					"name=NX5105,car=0..1,boro=,chn=海關監管編號",//
			})
			public String tw_CustomsControlID;

			@DSREF(den = "Importer. Payment On Account Business. Identifier", uid = "TW142", cls = "Importer")
			@AAA(msg = {
			//
			"name=NX5105,car=0..1,boro=,chn=營業稅記帳廠商編號",//
			})
			public String tw_PaymentOnAccountBusinessID;

			@DSREF(den = "Importer. Type. Code", uid = "TW104", cls = "Importer")
			@AAA(msg = {
					//
					"name=N5109,car=0..1,boro=,chn=身分識別代碼",//
					"name=N5110,car=1,boro=,chn=身分識別代碼",//
					"name=N5116,car=1,boro=,chn=身分識別代碼",//
					"name=N5135,car=1,boro=,chn=身分識別代碼",//
					"name=NX301,car=1,boro=,chn=身分識別代碼",//
					"name=NX301_DN,car=1,boro=,chn=身分識別代碼",//
					"name=NX401,car=1,boro=,chn=身分識別代碼",//
					"name=NX5105,car=1,boro=,chn=身分識別代碼",//
					"name=NX601,car=1,boro=,chn=身分識別代碼",//
					"name=NX603,car=1,boro=,chn=身分識別代碼",//
					"name=NX801,car=0..1,boro=,chn=身分識別代碼",//
			})
			public String tw_TypeCode;

			public Address Address = new Address();

			@DSREF(cls = "Address")
			@AAA(msg = {
					//
					"name=N5135,car=1,boro=",//
					"name=NX301,car=1,boro=",//
					"name=NX301_DN,car=1,boro=",//
					"name=NX401,car=1,boro=",//
					"name=NX5105,car=0..1,boro=",//
					"name=NX601,car=1,boro=",//
					"name=NX603,car=1,boro=",//
					"name=NX801,car=0..1,boro=",//
			})
			public class Address {

				public Address() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
				public String CityName;
				@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
				public String CountryCode;
				@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
				public String CountrySubDivisionID;
				@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
				public String CountrySubDivisionName;

				@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
				@AAA(msg = {
						//
						"name=N5135,car=1,boro=,chn=進口人(納稅義務人)英文地址",//
						"name=NX401,car=1,boro=,chn=進口人(納稅義務人)英文地址",//
						"name=NX5105,car=0..1,boro=,chn=進口人(納稅義務人)英文地址",//
						"name=NX601,car=1,boro=,chn=進口人(納稅義務人)英文地址",//
						"name=NX801,car=1,boro=,chn=進口人(納稅義務人)英文地址",//
				})
				public String Line;

				@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
				public String PostcodeID;

				@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
				@AAA(msg = {
						//
						"name=N5135,car=0..1,boro=,chn=進口人(納稅義務人)中文地址",//
						"name=NX301,car=1,boro=,chn=進口人(納稅義務人)中文地址",//
						"name=NX301_DN,car=1,boro=,chn=進口人(納稅義務人)中文地址",//
						"name=NX401,car=0..1,boro=,chn=進口人(納稅義務人)中文地址",//
						"name=NX5105,car=0..1,boro=,chn=進口人(納稅義務人)中文地址",//
						"name=NX601,car=1,boro=,chn=進口人(納稅義務人)中文地址",//
						"name=NX603,car=1,boro=,chn=進口人(納稅義務人)中文地址",//
						"name=NX801,car=0..1,boro=,chn=進口人(納稅義務人)中文地址",//
				})
				public String tw_ChineseLine;
			}

			public Communication Communication = new Communication();

			@DSREF(cls = "Communication")
			@AAA(msg = {
					//
					"name=NX301_DN,car=1..2,boro=",//
					"name=NX401,car=0..2,boro=",//
					"name=NX5105,car=0..2,boro=",//
					"name=NX601,car=1..2,boro=",//
			})
			public class Communication {

				public Communication() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
				@AAA(msg = {
						//
						"name=NX301_DN,car=1,boro=,chn=進口人(納稅義務人)電話;進口人(納稅義務人)電子郵件",//
						"name=NX401,car=1,boro=,chn=進口人(納稅義務人)電話;進口人(納稅義務人)電子郵件",//
						"name=NX5105,car=1,boro=,chn=進口人(納稅義務人)電話;進口人(納稅義務人)電子郵件",//
						"name=NX601,car=1,boro=,chn=進口人(納稅義務人)電話;進口人(納稅義務人)電子郵件",//
				})
				public String ID;

				@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
				@AAA(msg = {
						//
						"name=NX301_DN,car=1,boro=,chn=*聯絡資料類別代碼",//
						"name=NX401,car=1,boro=,chn=*聯絡資料類別代碼",//
						"name=NX5105,car=1,boro=,chn=*聯絡資料類別代碼",//
						"name=NX601,car=1,boro=,chn=*聯絡資料類別代碼",//
				})
				public String TypeID;
			}

			public Contact Contact = new Contact();

			@DSREF(cls = "Contact")
			public class Contact {

				public Contact() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
				public String Name;
				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}
			}
		}

		public LandingLocation LandingLocation = new LandingLocation();

		@DSREF(cls = "Landing Location")
		@AAA(msg = {
				//
				"name=N5101,car=0..1,boro=#",//
				"name=N5166,car=1,boro=#",//
				"name=N5202,car=0..1,boro=#",//
				"name=N5251,car=0..1,boro=",//
		})
		public class LandingLocation {

			public LandingLocation() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Landing Location. Identification. Identifier", uid = "L075", cls = "Landing Location")
			@AAA(msg = {
					//
					"name=N5101,car=1,boro=,chn=停泊碼頭（含浮筒）代碼",//
					"name=N5166,car=1,boro=,chn=停泊碼頭（含浮筒）代碼",//
					"name=N5202,car=1,boro=,chn=停泊碼頭（含浮筒）代碼",//
					"name=N5251,car=1,boro=,chn=停泊碼頭（含浮筒）代碼",//
			})
			public String ID;

			@DSREF(den = "Landing Location. Name. Text", uid = "L074", cls = "Landing Location")
			public String Name;
		}

		public LoadingLocation LoadingLocation = new LoadingLocation();

		@DSREF(cls = "Loading Location")
		@AAA(msg = {
				//
				"name=N5165,car=1,boro=",//
				"name=N5170,car=1,boro=#",//
				"name=N5262,car=1,boro=#",//
				"name=N5301,car=1,boro=#",//
				"name=N5302,car=1,boro=#",//
		})
		public class LoadingLocation {

			public LoadingLocation() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Loading Location. Departure. Date Time", uid = "169", cls = "Loading Location")
			public String DepartureDateTime;

			@DSREF(den = "Loading Location. Identification. Identifier", uid = "L010", cls = "Loading Location")
			@AAA(msg = {
					//
					"name=N5165,car=1,boro=,chn=起運地點代碼",//
					"name=N5170,car=1,boro=,chn=起運地點代碼",//
					"name=N5301,car=1,boro=,chn=起運地點代碼",//
					"name=N5302,car=1,boro=,chn=起運地點代碼",//
			})
			public String ID;

			@DSREF(den = "Loading Location. Loading. Date Time", uid = "031", cls = "Loading Location")
			@AAA(msg = {
			//
			"name=N5262,car=1,boro=,chn=裝船日期與時間",//
			})
			public String LoadingDateTime;
		}

		public ObligationGuarantee ObligationGuarantee = new ObligationGuarantee();

		@DSREF(cls = "Obligation Guarantee")
		@AAA(msg = {
				//
				"name=N5111,car=1,boro=",//
				"name=N5401,car=0..1,boro=",//
				"name=N5402,car=0..1,boro=",//
		})
		public class ObligationGuarantee {

			public ObligationGuarantee() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Obligation Guarantee. LPCO Expiration. Date Time", uid = "275", cls = "Obligation Guarantee")
			public String LPCOExpirationDateTime;

			@DSREF(den = "Obligation Guarantee. Reference. Identifier", uid = "100", cls = "Obligation Guarantee")
			@AAA(msg = {
			//
			"name=N5111,car=0..1,boro=#,chn=案號",//
			})
			public String ReferenceID;

			@DSREF(den = "Obligation Guarantee. Security Details. Code", uid = "101", cls = "Obligation Guarantee")
			@AAA(msg = {
			//
			"name=N5111,car=0..1,boro=,chn=押款原因",//
			})
			public String SecurityDetailsCode;

			public Surety Surety = new Surety();

			@DSREF(cls = "Surety")
			@AAA(msg = {
			//
			"name=N5111,car=1,boro=",//
			})
			public class Surety {

				public Surety() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Surety. Identification. Identifier", uid = "R055", cls = "Surety")
				@AAA(msg = {
				//
				"name=N5111,car=1,boro=,chn=繳款人統一編號",//
				})
				public String ID;

				@DSREF(den = "Surety. Name. Text", uid = "R054", cls = "Surety")
				@AAA(msg = {
				//
				"name=N5111,car=1,boro=,chn=繳款人名稱",//
				})
				public String Name;

				@DSREF(den = "Surety. Type. Code", uid = "TW104", cls = "Surety")
				@AAA(msg = {
				//
				"name=N5111,car=1,boro=,chn=身分識別代碼",//
				})
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;
					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;
					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}
		}

		public Packaging Packaging = new Packaging();

		@DSREF(cls = "Packaging")
		@AAA(msg = {
				//
				"name=N5101,car=1,boro=",//
				"name=N5102,car=1,boro=",//
				"name=N5107,car=0..1,boro=",//
				"name=N5108,car=1,boro=",//
				"name=N5109,car=1,boro=",//
				"name=N5110,car=1,boro=",//
				"name=N5111,car=1,boro=",//
				"name=N5116,car=1,boro=",//
				"name=N5117,car=1,boro=",//
				"name=N5135,car=1,boro=",//
				"name=N5151,car=1,boro=",//
				"name=N5158,car=1,boro=",//
				"name=N5162,car=1,boro=#",//
				"name=N5165,car=1,boro=",//
				"name=N5166,car=1,boro=",//
				"name=N5167,car=1,boro=",//
				"name=N5168,car=1,boro=",//
				"name=N5201,car=1,boro=",//
				"name=N5202,car=1,boro=",//
				"name=N5203,car=1,boro=",//
				"name=N5204,car=1,boro=",//
				"name=N5205,car=1,boro=",//
				"name=N5251,car=1,boro=",//
				"name=N5252,car=1,boro=",//
				"name=N5262,car=1,boro=",//
				"name=N5301,car=1,boro=",//
				"name=N5302,car=1,boro=",//
				"name=N5401,car=1,boro=",//
				"name=N5402,car=1,boro=",//
				"name=N5403,car=1,boro=",//
				"name=N5404,car=1,boro=",//
				"name=NX401,car=0..1,boro=",//
				"name=NX5105,car=1,boro=",//
				"name=NX801,car=0..1,boro=",//
		})
		public class Packaging {

			public Packaging() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Packaging. Marks Numbers. Text", uid = "142", cls = "Packaging")
			@AAA(msg = {
					//
					"name=N5116,car=0..1,boro=,chn=標記",//
					"name=N5203,car=1,boro=,chn=標記",//
					"name=N5204,car=0..1,boro=,chn=標記",//
					"name=NX401,car=1,boro=,chn=標記",//
					"name=NX5105,car=1,boro=,chn=標記",//
					"name=NX801,car=1,boro=,chn=標記",//
			})
			public String MarksNumbers;

			@DSREF(den = "Packaging. Packaging Material Description. Text", uid = "344", cls = "Packaging")
			@AAA(msg = {
					//
					"name=N5162,car=0..1,boro=,chn=包裝說明",//
					"name=N5203,car=0..1,boro=#,chn=包裝說明",//
					"name=NX5105,car=0..1,boro=,chn=包裝說明",//
			})
			public String PackagingMaterialDescription;

			@DSREF(den = "Packaging. Combination. Text", uid = "TW011", cls = "Packaging")
			@AAA(msg = {
					//
					"name=N5116,car=0..1,boro=,chn=合成註記",//
					"name=N5203,car=0..1,boro=,chn=合成註記",//
					"name=NX5105,car=0..1,boro=,chn=合成註記",//
			})
			public String tw_Combination;

			@DSREF(den = "Packaging. Quantity. Quantity", uid = "144", cls = "Packaging")
			public String QuantityQuantity;

			@DSREF(den = "Packaging. Size Description. Text", uid = "367", cls = "Packaging")
			public String SizeDescription;

			@DSREF(den = "Packaging. Type. Code", uid = "141", cls = "Packaging")
			@AAA(msg = {
					//
					"name=N5107,car=1,boro=,chn=件數單位",//
					"name=N5110,car=1,boro=,chn=件數單位",//
					"name=N5116,car=1,boro=,chn=件數單位",//
					"name=N5162,car=1,boro=,chn=件數單位",//
					"name=N5203,car=1,boro=,chn=件數單位",//
					"name=N5204,car=1,boro=,chn=件數單位",//
					"name=NX5105,car=1,boro=,chn=件數單位",//
			})
			public String TypeCode;

			@DSREF(den = "Packaging. Volume. Measure", uid = "395", cls = "Packaging")
			public String VolumeMeasure;
		}

		public PortFacilitySecurityOfficer PortFacilitySecurityOfficer = new PortFacilitySecurityOfficer();

		@DSREF(cls = "Port Facility Security Officer")
		public class PortFacilitySecurityOfficer {

			public PortFacilitySecurityOfficer() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Port Facility Security Officer. Name. Text", uid = "R097", cls = "Port Facility Security Officer")
			public String Name;
		}

		public PreviousDocument_Moved PreviousDocument = new PreviousDocument_Moved();

		@DSREF(cls = "Previous Document")
		@AAA(msg = {
				//
				"name=N5158,car=1,boro=#",//
				"name=N5165,car=0..999,boro=",//
				"name=N5170,car=0..1,boro=",//
				"name=NX202,car=1,boro=#",//
				"name=NX302,car=1,boro=#",//
				"name=NX302_DN,car=1,boro=#",//
				"name=NX402,car=1,boro=#",//
				"name=NX602,car=1,boro=#",//
				"name=NX901,car=1,boro=#",//
				"name=NX902,car=1,boro=#",//
		})
		public class PreviousDocument_Moved {

			public PreviousDocument_Moved() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Previous Document. Identification. Identifier", uid = "D018", cls = "Previous Document")
			public String ID;

			@DSREF(den = "Previous Document. Issue. Date Time", uid = "D010", cls = "Previous Document")
			public String IssueDateTime;

			@DSREF(den = "Previous Document. Line. Numeric", uid = "171", cls = "Previous Document")
			public String LineNumeric;

			@DSREF(den = "Previous Document. Reference. Identifier", uid = "TW_106", cls = "Previous Document")
			public String tw_ReferenceID;

			@DSREF(den = "Previous Document. Functional Reference. Identifier", uid = "D026", cls = "Previous Document")
			@AAA(msg = {
					//
					"name=N5158,car=1,boro=*,chn=原訊息編號",//
					"name=N5170,car=1,boro=*,chn=原訊息編號",//
					"name=NX202,car=1,boro=*,chn=原訊息編號",//
					"name=NX302,car=1,boro=*,chn=原訊息編號",//
					"name=NX302_DN,car=1,boro=*,chn=原訊息編號",//
					"name=NX402,car=1,boro=*,chn=原訊息編號",//
					"name=NX602,car=1,boro=*,chn=原訊息編號",//
					"name=NX901,car=1,boro=*,chn=原訊息編號",//
					"name=NX902,car=1,boro=*,chn=原訊息編號",//
			})
			public String tw_FunctionalReferenceID;

			@DSREF(den = "Previous Document. Function. Code", uid = "017", cls = "")
			public String tw_FunctionCode;

			@DSREF(den = "Previous Document. Type. Code", uid = "D019", cls = "Previous Document")
			@AAA(msg = {
			//
			"name=N5170,car=1,boro=,chn=原訊息類別",//
			})
			public String TypeCode;

			public Submitter Submitter = new Submitter();

			@DSREF(cls = "Submitter")
			@AAA(msg = {
			//
			"name=N5170,car=1,boro=",//
			})
			public class Submitter {

				public Submitter() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Submitter. Identification. Identifier", uid = "R059", cls = "Submitter")
				@AAA(msg = {
				//
				"name=N5170,car=1,boro=,chn=原訊息傳送者代碼",//
				})
				public String ID;

				@DSREF(den = "Submitter. Name. Text", uid = "R058", cls = "Submitter")
				public String Name;

			}
		}

		public PropertyOperator PropertyOperator = new PropertyOperator();

		@DSREF(cls = "Property Operator")
		public class PropertyOperator {

			public PropertyOperator() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Property Operator. Identification. Identifier", uid = "R088", cls = "Property Operator")
			public String ID;

			@DSREF(den = "Property Operator. Name. Text", uid = "R057", cls = "Property Operator")
			public String Name;

			public Address Address = new Address();

			@DSREF(cls = "Address")
			public class Address {

				public Address() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
				public String CityName;
				@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
				public String CountryCode;
				@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
				public String CountrySubDivisionID;
				@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
				public String CountrySubDivisionName;
				@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
				public String Line;
				@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
				public String PostcodeID;
			}

			public Communication Communication = new Communication();

			@DSREF(cls = "Communication")
			public class Communication {

				public Communication() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
				public String ID;
				@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
				public String TypeID;
			}

			public Contact Contact = new Contact();

			@DSREF(cls = "Contact")
			public class Contact {

				public Contact() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
				public String Name;
				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}
			}
		}

		public PropertyOwner PropertyOwner = new PropertyOwner();

		@DSREF(cls = "Property Owner")
		public class PropertyOwner {

			public PropertyOwner() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Property Owner. Identification. Identifier", uid = "R098", cls = "Property Owner")
			public String ID;

			@DSREF(den = "Property Owner. Name. Text", uid = "R095", cls = "Property Owner")
			public String Name;

			public Address Address = new Address();

			@DSREF(cls = "Address")
			public class Address {

				public Address() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
				public String CityName;
				@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
				public String CountryCode;
				@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
				public String CountrySubDivisionID;
				@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
				public String CountrySubDivisionName;
				@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
				public String Line;
				@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
				public String PostcodeID;
			}

			public Communication Communication = new Communication();

			@DSREF(cls = "Communication")
			public class Communication {

				public Communication() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
				public String ID;
				@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
				public String TypeID;
			}

			public Contact Contact = new Contact();

			@DSREF(cls = "Contact")
			public class Contact {

				public Contact() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
				public String Name;
				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}
			}
		}

		public RepresentativePerson RepresentativePerson = new RepresentativePerson();

		@DSREF(cls = "Representative Person")
		@AAA(msg = {
				//
				"name=N5135,car=1,boro=",//
				"name=N5203,car=1,boro=",//
				"name=N5205,car=1,boro=",//
				"name=N5301,car=1,boro=",//
				"name=N5302,car=0..1,boro=",//
				"name=NX5105,car=1,boro=",//
		})
		public class RepresentativePerson {

			public RepresentativePerson() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Representative Person. Contact Function. Text", uid = "248", cls = "Representative Person")
			public String ContactFunction;

			@DSREF(den = "Representative Person. Name. Text", uid = "R006", cls = "Representative Person")
			@AAA(msg = {
					//
					"name=N5135,car=1,boro=,chn=專責報關人員代號",//
					"name=N5203,car=1,boro=,chn=專責報關人員代號",//
					"name=N5205,car=1,boro=,chn=專責報關人員代號",//
					"name=N5301,car=1,boro=,chn=專責報關人員代號",//
					"name=NX5105,car=1,boro=,chn=專責報關人員代號",//
			})
			public String Name;

			public Address Address = new Address();

			@DSREF(cls = "Address")
			public class Address {

				public Address() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
				public String CityName;
				@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
				public String CountryCode;
				@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
				public String CountrySubDivisionID;
				@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
				public String CountrySubDivisionName;
				@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
				public String Line;
				@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
				public String PostcodeID;
			}

			public Communication Communication = new Communication();

			@DSREF(cls = "Communication")
			public class Communication {

				public Communication() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
				public String ID;
				@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
				public String TypeID;
			}

			public Contact Contact = new Contact();

			@DSREF(cls = "Contact")
			public class Contact {

				public Contact() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
				public String Name;
				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}
			}
		}

		public ResponsibleGovernmentAgency ResponsibleGovernmentAgency = new ResponsibleGovernmentAgency();

		@DSREF(cls = "Responsible Government Agency")
		@AAA(msg = {
				//
				"name=N5109,car=0..1,boro=",//
				"name=NX302_DN,car=0..1,boro=",//
				"name=NX901,car=1,boro=",//
				"name=NX902,car=1,boro=",//
		})
		public class ResponsibleGovernmentAgency {

			public ResponsibleGovernmentAgency() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Responsible Government Agency. Identification. Identifier", uid = "R062", cls = "Responsible Government Agency")
			@AAA(msg = {
					//
					"name=NX901,car=1,boro=,chn=機關別代碼",//
					"name=NX902,car=1,boro=,chn=機關別代碼",//
			})
			public String ID;

			public Address Address = new Address();

			@DSREF(cls = "Address")
			public class Address {

				public Address() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
				public String CityName;
				@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
				public String CountryCode;
				@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
				public String CountrySubDivisionID;
				@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
				public String CountrySubDivisionName;
				@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
				public String Line;
				@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
				public String PostcodeID;
			}

			public Communication Communication = new Communication();

			@DSREF(cls = "Communication")
			public class Communication {

				public Communication() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
				public String ID;
				@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
				public String TypeID;
			}

			public Contact Contact = new Contact();

			@DSREF(cls = "Contact")
			public class Contact {

				public Contact() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
				public String Name;
				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}
			}

			public GovernmentOfficer GovernmentOfficer = new GovernmentOfficer();

			@DSREF(cls = "Government Officer")
			@AAA(msg = {
			//
			"name=N5109,car=0..1,boro=",//
			})
			public class GovernmentOfficer {

				public GovernmentOfficer() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Government Officer. Identification. Identifier", uid = "R080", cls = "Government Officer")
				@AAA(msg = {
				//
				"name=N5109,car=1,boro=,chn=驗貨關員代號",//
				})
				public String ID;

				@DSREF(den = "Government Officer. Name. Text", uid = "R079", cls = "Government Officer")
				public String Name;
				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}
			}
		}

		public Status Status = new Status();

		@DSREF(cls = "Status")
		@AAA(msg = {
		//
		"name=N5165,car=0..1,boro=#",//
		})
		public class Status {

			public Status() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Status. Name. Code", uid = "379", cls = "Status")
			@AAA(msg = {
			//
			"name=N5165,car=1,boro=,chn=通關方式",//
			})
			public String NameCode;

		}

		public Submitter Submitter = new Submitter();

		@DSREF(cls = "Submitter")
		public class Submitter {

			public Submitter() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Submitter. Identification. Identifier", uid = "R059", cls = "Submitter")
			public String ID;
			@DSREF(den = "Submitter. Name. Text", uid = "R058", cls = "Submitter")
			public String Name;
			public Address Address = new Address();

			@DSREF(cls = "Address")
			public class Address {

				public Address() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
				public String CityName;
				@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
				public String CountryCode;
				@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
				public String CountrySubDivisionID;
				@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
				public String CountrySubDivisionName;
				@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
				public String Line;
				@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
				public String PostcodeID;
			}

			public Communication Communication = new Communication();

			@DSREF(cls = "Communication")
			public class Communication {

				public Communication() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
				public String ID;
				@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
				public String TypeID;
			}

			public Contact Contact = new Contact();

			@DSREF(cls = "Contact")
			public class Contact {

				public Contact() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
				public String Name;
				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}
			}
		}

		public TransportEquipment2 TransportEquipment_Added2Declaration = new TransportEquipment2();

		@DSREF(cls = "Transport Equipment")
		@AAA(msg = {
				//
				"name=N5101,car=0..1,boro=+",//
				"name=N5103,car=1,boro=+",//
				"name=N5108,car=0..1,boro=+",//
				"name=N5117,car=0..1,boro=+",//
				"name=N5165,car=1,boro=+",//
				"name=N5202,car=0..1,boro=+",//
				"name=N5262,car=0..1,boro=+",//
		})
		public class TransportEquipment2 {

			public TransportEquipment2() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Transport Equipment. Empty Container. Quantity", uid = "TW105", cls = "Transport Equipment")
			@AAA(msg = {
					//
					"name=N5101,car=0..1,boro=,chn=空櫃總數",//
					"name=N5103,car=1,boro=,chn=空櫃總數",//
					"name=N5108,car=0..1,boro=,chn=空櫃總數",//
					"name=N5202,car=0..1,boro=,chn=空櫃總數",//
					"name=N5262,car=0..1,boro=,chn=空櫃總數",//
			})
			public String tw_EmptyContainerQuantity;

			@DSREF(den = "Transport Equipment. Full Container. Quantity", uid = "TW047", cls = "Transport Equipment")
			@AAA(msg = {
					//
					"name=N5101,car=1,boro=,chn=實櫃總數",//
					"name=N5103,car=1,boro=,chn=實櫃總數",//
					"name=N5108,car=0..1,boro=,chn=實櫃總數",//
					"name=N5202,car=0..1,boro=,chn=實櫃總數",//
					"name=N5262,car=0..1,boro=,chn=實櫃總數",//
			})
			public String tw_FullContainerQuantity;

			@DSREF(den = "Transport Equipment. Goods Loading Type. Code", uid = "TW048", cls = "Transport Equipment")
			@AAA(msg = {
			//
			"name=N5165,car=1,boro=,chn=貨櫃（物）裝貨型態",//
			})
			public String tw_GoodsLoadingTypeCode;

		}

		public TravelDocument TravelDocument = new TravelDocument();

		@DSREF(cls = "Travel Document")
		public class TravelDocument {

			public TravelDocument() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Travel Document. Issue Location. Text", uid = "D027", cls = "Travel Document")
			public String IssueLocation;
			public Authenticator Authenticator = new Authenticator();

			@DSREF(cls = "Authenticator")
			public class Authenticator {

				public Authenticator() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Authenticator. Identification. Identifier", uid = "R008", cls = "Authenticator")
				public String ID;
				@DSREF(den = "Authenticator. Name. Text", uid = "R007", cls = "Authenticator")
				public String Name;
				public Address Address = new Address();

				@DSREF(cls = "Address")
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;
					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;
					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}

			public Submitter Submitter = new Submitter();

			@DSREF(cls = "Submitter")
			public class Submitter {

				public Submitter() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Submitter. Identification. Identifier", uid = "R059", cls = "Submitter")
				public String ID;
				@DSREF(den = "Submitter. Name. Text", uid = "R058", cls = "Submitter")
				public String Name;
				public Address Address = new Address();

				@DSREF(cls = "Address")
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;
					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;
					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					public String ID;
					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;
					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}
			}
		}

		public tw_AdditionalDeclaration tw_AdditionalDeclaration = new tw_AdditionalDeclaration();

		@DSREF(cls = "Additional Declaration")
		@AAA(msg = {
				//
				"name=NX201_01,car=0..1,boro=",//
				"name=NX201_07,car=0..1,boro=",//
				"name=NX202,car=0..1,boro=",//
				"name=NX801,car=1,boro=",//
				"name=NX802,car=1,boro=",//
		})
		public class tw_AdditionalDeclaration {

			public tw_AdditionalDeclaration() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Additional Declaration. Identification. Identifier", uid = "D014", cls = "Additional Declaration")
			@AAA(msg = {
					//
					"name=NX201_01,car=1,boro=*,chn=會辦識別碼",//
					"name=NX202,car=1,boro=*,chn=會辦識別碼",//
					"name=NX801,car=1,boro=*,chn=會辦識別碼",//
					"name=NX802,car=1,boro=*,chn=會辦識別碼",//
			})
			public String tw_ID;

		}

		public tw_Application tw_Application = new tw_Application();

		@DSREF(cls = "Application")
		@AAA(msg = {
				//
				"name=NX201_01,car=1,boro=",//
				"name=NX201_07,car=1,boro=",//
				"name=NX202,car=1,boro=",//
				"name=NX301,car=1,boro=",//
				"name=NX301_DN,car=1,boro=",//
				"name=NX302_DN,car=1,boro=",//
				"name=NX401,car=1,boro=",//
				"name=NX402,car=1,boro=",//
				"name=NX5105,car=0..9999,boro=",//
				"name=NX601,car=1,boro=",//
				"name=NX602,car=0..1,boro=",//
				"name=NX603,car=1,boro=",//
				"name=NX901,car=0..1,boro=",//
				"name=NX902,car=0..1,boro=",//
		})
		public class tw_Application {

			public tw_Application() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Application. Bulk Goods. Code", uid = "TW247", cls = "Application")
			public String tw_BulkGoodsCode;

			@DSREF(den = "Application. Declaration Office. Identifier", uid = "065", cls = "Application")
			public String tw_DeclarationOfficeID;

			@DSREF(den = "Application. Deduction Sample. Text", uid = "TW054", cls = "Application")
			public String tw_DeductionSample;

			@DSREF(den = "Application. Electronic Receipt. Text", uid = "TW083", cls = "Application")
			public String tw_ElectronicReceipt;

			@DSREF(den = "Application. Functional Reference. Identifier", uid = "D026", cls = "Application")
			@AAA(msg = {
			//
			"name=NX5105,car=1,boro=*,chn=訊息編號",//
			})
			public String tw_FunctionalReferenceID;

			@DSREF(den = "Application. Identification. Identifier", uid = "D005", cls = "Application")
			@AAA(msg = {
			//
			"name=NX5105,car=0..1,boro=*,chn=輸出入許可文件號碼",//
			})
			public String tw_ID;

			@DSREF(den = "Application. Item Group. Identifier", uid = "TW_101", cls = "Application")
			public String tw_ItemGroupID;

			@DSREF(den = "Application. Proved Paper. Text", uid = "TW103", cls = "Application")
			public String tw_ProvedPaper;

			@DSREF(den = "Application. Purpose. Code", uid = "TW075", cls = "Application")
			@AAA(msg = {
					//
					"name=NX301_DN,car=1,boro=,chn=用途別代碼",//
					"name=NX5105,car=0..1,boro=,chn=用途別代碼",//
			})
			public String tw_PurposeCode;

			@DSREF(den = "Application. Return Sample. Text", uid = "TW102", cls = "Application")
			public String tw_ReturnSample;

			@DSREF(den = "Application. Special Request. Text", uid = "TW_054", cls = "Application")
			public String tw_SpecialRequest;

			@DSREF(den = "Application. Type. Code", uid = "TW106", cls = "Application")
			@AAA(msg = {
					//
					"name=NX201_01,car=1,boro=,chn=申請業務別",//
					"name=NX201_07,car=1,boro=,chn=申請業務別",//
					"name=NX202,car=1,boro=,chn=申請業務別",//
					"name=NX301_DN,car=1,boro=,chn=申請業務別",//
					"name=NX302_DN,car=1,boro=,chn=申請業務別",//
					"name=NX401,car=1,boro=,chn=申請業務別",//
					"name=NX402,car=1,boro=,chn=申請業務別",//
					"name=NX602,car=1,boro=,chn=申請業務別",//
					"name=NX603,car=1,boro=,chn=申請業務別",//
					"name=NX5105,car=0..1,boro=,chn=申請業務別",//
					"name=NX901,car=0..1,boro=,chn=申請業務別",//
					"name=NX902,car=0..1,boro=,chn=申請業務別",//
			})
			public String tw_TypeCode;

			public AdditionalDocument AdditionalDocument = new AdditionalDocument();

			@DSREF(cls = "Additional Document")
			@AAA(msg = {
					//
					"name=NX201_01,car=0..5,boro=+",//
					"name=NX201_07,car=0..5,boro=+",//
					"name=NX301,car=0..99,boro=+",//
					"name=NX301_DN,car=0..99,boro=+",//
					"name=NX401,car=0..99,boro=+",//
					"name=NX5105,car=0..99,boro=+",//
					"name=NX601,car=0..99,boro=+",//
					"name=NX603,car=0..99,boro=+",//
			})
			public class AdditionalDocument {

				public AdditionalDocument() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Additional Document. Identification. Identifier", uid = "D005", cls = "Additional Document")
				@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=,chn=檢附文件號碼",//
						"name=NX201_07,car=0..1,boro=,chn=檢附文件號碼",//
						"name=NX301,car=0..1,boro=,chn=檢核文件字號",//
						"name=NX401,car=0..1,boro=,chn=檢核文件字號",//
						"name=NX5105,car=0..1,boro=,chn=檢核文件字號",//
						"name=NX601,car=0..1,boro=,chn=檢核文件字號",//
						"name=NX603,car=0..1,boro=,chn=檢核文件字號",//
				})
				public String ID;

				@DSREF(den = "Additional Document. Content. Text", uid = "105", cls = "Additional Document")
				@AAA(msg = {
						//
						"name=NX401,car=1,boro=*,chn=檢附文件說明",//
						"name=NX5105,car=0..1,boro=*,chn=檢附文件說明",//
				})
				public String tw_Content;

				@DSREF(den = "Additional Document. Declaration Office. Identifier", uid = "065", cls = "Additional Document")
				public String tw_DeclarationOfficeID;

				@DSREF(den = "Additional Document. Image File Format Code. Text", uid = "TW101", cls = "Additional Document")
				@AAA(msg = {
						//
						"name=NX301,car=0..1,boro=,chn=檢附影像文件格式",//
						"name=NX401,car=0..1,boro=,chn=檢附影像文件格式",//
						"name=NX5105,car=0..1,boro=,chn=檢附影像文件格式",//
						"name=NX601,car=0..1,boro=,chn=檢附影像文件格式",//
						"name=NX603,car=0..1,boro=,chn=檢附影像文件格式",//
				})
				public String tw_ImageFileFormatCode;

				@DSREF(den = "Additional Document. Image File Name. Text", uid = "TW097", cls = "Additional Document")
				@AAA(msg = {
						//
						"name=NX301,car=0..1,boro=,chn=檢附影像文件名稱",//
						"name=NX401,car=0..1,boro=,chn=檢附影像文件名稱",//
						"name=NX5105,car=0..1,boro=,chn=檢附影像文件名稱",//
						"name=NX601,car=0..1,boro=,chn=檢附影像文件名稱",//
						"name=NX603,car=0..1,boro=,chn=檢附影像文件名稱",//
				})
				public String tw_ImageFileName;

				@DSREF(den = "Additional Document. Type. Code", uid = "D006", cls = "Additional Document")
				@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=,chn=檢附文件種類",//
						"name=NX201_07,car=1,boro=,chn=檢附文件種類",//
						"name=NX301,car=1,boro=,chn=檢附文件種類",//
						"name=NX301_DN,car=1,boro=,chn=檢附文件種類",//
						"name=NX5105,car=0..1,boro=,chn=檢附文件種類",//
						"name=NX601,car=0..1,boro=,chn=檢附文件種類",//
						"name=NX603,car=1,boro=,chn=檢附文件種類",//
				})
				public String TypeCode;

				public ContactOffice ContactOffice = new ContactOffice();

				@DSREF(cls = "Contact Office")
				public class ContactOffice {

					public ContactOffice() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact Office. Identification. Identifier", uid = "G002", cls = "Contact Office")
					public String ID;

				}

				public ResponsibleGovernmentAgency ResponsibleGovernmentAgency = new ResponsibleGovernmentAgency();

				@DSREF(cls = "Responsible Government Agency")
				@AAA(msg = {
						//
						"name=NX301,car=0..1,boro=+",//
						"name=NX301_DN,car=0..1,boro=+",//
						"name=NX401,car=0..1,boro=+",//
						"name=NX5105,car=0..1,boro=+",//
						"name=NX601,car=0..1,boro=+",//
						"name=NX603,car=0..1,boro=+",//
				})
				public class ResponsibleGovernmentAgency {

					public ResponsibleGovernmentAgency() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Responsible Government Agency. Identification. Identifier", uid = "R062", cls = "Responsible Government Agency")
					@AAA(msg = {
							//
							"name=NX301,car=1,boro=,chn=核發機關代碼",//
							"name=NX301_DN,car=1,boro=,chn=核發機關代碼",//
							"name=NX401,car=1,boro=,chn=核發機關代碼",//
							"name=NX5105,car=1,boro=,chn=核發機關代碼",//
							"name=NX601,car=1,boro=,chn=核發機關代碼",//
							"name=NX603,car=1,boro=,chn=核發機關代碼",//
					})
					public String ID;
				}
			}

			public AdditionalInformation AdditionalInformation = new AdditionalInformation();

			@DSREF(cls = "Additional Information")
			@AAA(msg = {
					//
					"name=NX301,car=1,boro=+",//
					"name=NX301_DN,car=0..1,boro=+",//
					"name=NX401,car=0..1,boro=+",//
					"name=NX5105,car=0..1,boro=+",//
					"name=NX601,car=0..1,boro=+",//
					"name=NX603,car=0..1,boro=+",//
			})
			public class AdditionalInformation {

				public AdditionalInformation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Additional Information. Statement Description. Text", uid = "225", cls = "Additional Information")
				@AAA(msg = {
						//
						"name=NX301,car=0..1,boro=,chn=申請人特別要求",//
						"name=NX301_DN,car=1,boro=,chn=申請人特別要求",//
						"name=NX401,car=0..1,boro=,chn=申請人特別要求",//
						"name=NX5105,car=0..1,boro=,chn=申請人特別要求",//
						"name=NX601,car=0..1,boro=,chn=申請人特別要求",//
						"name=NX603,car=0..1,boro=,chn=申請人特別要求",//
				})
				public String StatementDescription;

				@DSREF(den = "Additional Information. Bulk Goods. Code", uid = "TW247", cls = "Application")
				public String tw_BulkGoodsCode;

				@DSREF(den = "Additional Information. Deduction Sample. Text", uid = "TW054", cls = "Additional Information")
				@AAA(msg = {
						//
						"name=NX5105,car=0..1,boro=,chn=申請減量取樣原因",//
						"name=NX601,car=0..1,boro=,chn=申請減量取樣原因",//
				})
				public String tw_DeductionSample;

				@DSREF(den = "Additional Information. Electronic Receipt. Text", uid = "TW083", cls = "Additional Information")
				@AAA(msg = {
						//
						"name=NX301,car=1,boro=,chn=申請電子收據",//
						"name=NX5105,car=0..1,boro=,chn=申請電子收據",//
						"name=NX603,car=0..1,boro=,chn=申請電子收據",//
				})
				public String tw_ElectronicReceipt;

				@DSREF(den = "Additional Information. Proved Paper. Text", uid = "TW103", cls = "Additional Information")
				@AAA(msg = {
						//
						"name=NX401,car=0..1,boro=,chn=申請核發紙本證明",//
						"name=NX5105,car=0..1,boro=,chn=申請核發紙本證明",//
						"name=NX601,car=0..1,boro=,chn=申請核發紙本證明",//
						"name=NX603,car=0..1,boro=,chn=申請核發紙本證明",//
				})
				public String tw_ProvedPaper;

				@DSREF(den = "Additional Information. Return Sample. Text", uid = "TW102", cls = "Additional Information")
				@AAA(msg = {
						//
						"name=NX5105,car=0..1,boro=,chn=申請退樣",//
						"name=NX601,car=0..1,boro=,chn=申請退樣",//
				})
				public String tw_ReturnSample;

			}

			public Agent Agent = new Agent();

			@DSREF(cls = "Agent")
			@AAA(msg = {
					//
					"name=NX201_01,car=0..1,boro=+",//
					"name=NX201_07,car=0..1,boro=+",//
					"name=NX202,car=0..1,boro=+",//
					"name=NX301,car=0..1,boro=+",//
					"name=NX301_DN,car=0..1,boro=+",//
					"name=NX401,car=0..1,boro=+",//
					"name=NX5105,car=0..1,boro=+",//
					"name=NX601,car=0..1,boro=+",//
					"name=NX603,car=0..1,boro=+",//
					"name=NX901,car=0..1,boro=+",//
					"name=NX902,car=0..1,boro=+",//
			})
			public class Agent {

				public Agent() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Agent. Function. Code", uid = "102", cls = "Agent")
				public String FunctionCode;

				@DSREF(den = "Agent. Identification. Identifier", uid = "R004", cls = "Agent")
				@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=,chn=報驗/申辦代理人統一編號",//
						"name=NX201_07,car=1,boro=,chn=報驗/申辦代理人統一編號",//
						"name=NX202,car=1,boro=,chn=報驗/申辦代理人統一編號",//
						"name=NX301,car=1,boro=,chn=報驗/申辦代理人統一編號",//
						"name=NX301_DN,car=1,boro=,chn=報驗/申辦代理人統一編號",//
						"name=NX401,car=1,boro=,chn=報驗/申辦代理人統一編號",//
						"name=NX5105,car=1,boro=,chn=報驗/申辦代理人統一編號",//
						"name=NX601,car=1,boro=,chn=報驗/申辦代理人統一編號",//
						"name=NX603,car=1,boro=,chn=報驗/申辦代理人統一編號",//
						"name=NX901,car=1,boro=,chn=報驗/申辦代理人統一編號",//
						"name=NX902,car=1,boro=,chn=報驗/申辦代理人統一編號",//
				})
				public String ID;

				@DSREF(den = "Agent. Name. Text", uid = "R003", cls = "Agent")
				@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=,chn=報驗/申辦代理人中文名稱",//
						"name=NX201_07,car=1,boro=,chn=報驗/申辦代理人中文名稱",//
						"name=NX301_DN,car=1,boro=,chn=報驗/申辦代理人中文名稱",//
						"name=NX401,car=1,boro=,chn=報驗/申辦代理人中文名稱",//
						"name=NX5105,car=0..1,boro=,chn=報驗/申辦代理人中文名稱",//
						"name=NX601,car=0..1,boro=,chn=報驗/申辦代理人中文名稱",//
				})
				public String Name;

				@DSREF(den = "Agent. Quality Assurance. Indicator", uid = "249", cls = "Agent")
				public String QualityAssuranceIndicator;

				@DSREF(den = "Agent. Role. Code", uid = "R005", cls = "Agent")
				public String RoleCode;

				@DSREF(den = "Agent. Type. Code", uid = "TW104", cls = "Agent")
				@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=,chn=身分識別代碼",//
						"name=NX201_07,car=1,boro=,chn=身分識別代碼",//
						"name=NX301,car=1,boro=,chn=身分識別代碼",//
						"name=NX301_DN,car=1,boro=,chn=身分識別代碼",//
						"name=NX401,car=1,boro=,chn=身分識別代碼",//
						"name=NX5105,car=1,boro=,chn=身分識別代碼",//
						"name=NX601,car=1,boro=,chn=身分識別代碼",//
						"name=NX603,car=1,boro=,chn=身分識別代碼",//
				})
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=+",//
						"name=NX201_07,car=1,boro=+",//
						"name=NX202,car=0..1,boro=+",//
						"name=NX301_DN,car=1,boro=+",//
						"name=NX401,car=0..1,boro=+",//
						"name=NX5105,car=0..1,boro=+",//
						"name=NX601,car=0..1,boro=+",//
				})
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;
					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;

					@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
					@AAA(msg = {
							//
							"name=NX201_01,car=1,boro=,chn=報驗/申辦代理人中文地址",//
							"name=NX201_07,car=1,boro=,chn=報驗/申辦代理人中文地址",//
							"name=NX301_DN,car=1,boro=,chn=報驗/申辦代理人中文地址",//
							"name=NX401,car=1,boro=,chn=報驗/申辦代理人中文地址",//
							"name=NX5105,car=1,boro=,chn=報驗/申辦代理人中文地址",//
							"name=NX601,car=1,boro=,chn=報驗/申辦代理人中文地址",//
					})
					public String tw_ChineseLine;

					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=+",//
						"name=NX201_07,car=0..1,boro=+",//
						"name=NX202,car=0..1,boro=+",//
						"name=NX301_DN,car=1..2,boro=+",//
						"name=NX401,car=0..2,boro=+",//
						"name=NX5105,car=0..2,boro=+",//
						"name=NX601,car=0..2,boro=+",//
				})
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					@AAA(msg = {
							//
							"name=NX201_01,car=1,boro=,chn=報驗/申辦代理人電話 ",//
							"name=NX301_DN,car=1,boro=,chn=報驗/申辦代理人電話;報驗/申辦代理人電子郵件",//
							"name=NX401,car=1,boro=,chn=報驗/申辦代理人電話;報驗/申辦代理人電子郵件",//
							"name=NX5105,car=1,boro=,chn=報驗/申辦代理人電話;報驗/申辦代理人電子郵件",//
							"name=NX601,car=1,boro=,chn=報驗/申辦代理人電話;報驗/申辦代理人電子郵件",//
					})
					public String ID;

					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					@AAA(msg = {
							//
							"name=NX201_01,car=1,boro=,chn=*聯絡資料類別代碼",//
							"name=NX301_DN,car=1,boro=,chn=*聯絡資料類別代碼",//
							"name=NX401,car=1,boro=,chn=*聯絡資料類別代碼",//
							"name=NX5105,car=1,boro=,chn=*聯絡資料類別代碼",//
							"name=NX601,car=1,boro=,chn=*聯絡資料類別代碼",//
					})
					public String TypeID;
				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=+",//
						"name=NX201_07,car=0..1,boro=+",//
						"name=NX202,car=0..1,boro=+",//
				})
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					@AAA(msg = {
					//
					"name=NX201_01,car=1,boro=,chn=報驗/申辦代理人聯絡人姓名",//
					})
					public String Name;

					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;
						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;
					}
				}

				public ContactOffice ContactOffice = new ContactOffice();

				@DSREF(cls = "Contact Office")
				public class ContactOffice {

					public ContactOffice() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact Office. Identification. Identifier", uid = "G002", cls = "Contact Office")
					public String ID;

				}

				public ResponsibleGovernmentAgency ResponsibleGovernmentAgency = new ResponsibleGovernmentAgency();

				@DSREF(cls = "Responsible Government Agency")
				public class ResponsibleGovernmentAgency {

					public ResponsibleGovernmentAgency() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Responsible Government Agency. Identification. Identifier", uid = "R062", cls = "Responsible Government Agency")
					public String ID;
				}

				public GovernmentProcedure GovernmentProcedure = new GovernmentProcedure();

				@DSREF(cls = "Government Procedure")
				public class GovernmentProcedure {

					public GovernmentProcedure() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Government Procedure. Current. Code", uid = "166", cls = "Government Procedure")
					public String CurrentCode;
					@DSREF(den = "Government Procedure. Description. Text", uid = "353", cls = "Government Procedure")
					public String Description;
					@DSREF(den = "Government Procedure. Previous. Code", uid = "161", cls = "Government Procedure")
					public String PreviousCode;
				}
			}

			public BankAccount BankAccount = new BankAccount();

			@DSREF(cls = "Bank Account")
			@AAA(msg = {
					//
					"name=NX301_DN,car=0..1,boro=+",//
					"name=NX5105,car=0..1,boro=+",//
			})
			public class BankAccount {

				public BankAccount() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Bank Account. Identification. Identifier", uid = "372", cls = "Bank Account")
				@AAA(msg = {
						//
						"name=NX301_DN,car=1,boro=,chn=扣款帳號",//
						"name=NX5105,car=1,boro=,chn=扣款帳號",//
				})
				public String ID;
				@DSREF(den = "Bank Account. Reference. Identifier", uid = "R069", cls = "Bank Account")
				public String ReferenceID;
			}

			public ContactOffice ContactOffice = new ContactOffice();

			@DSREF(cls = "Contact Office")
			@AAA(msg = {
					//
					"name=NX201_01,car=1,boro=+",//
					"name=NX201_07,car=1,boro=+",//
					"name=NX202,car=0..1,boro=+",//
					"name=NX301,car=1,boro=+",//
					"name=NX401,car=1,boro=+",//
					"name=NX5105,car=0..1,boro=+",//
					"name=NX601,car=1,boro=+",//
					"name=NX603,car=1,boro=+",//
			})
			public class ContactOffice {

				public ContactOffice() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Contact Office. Identification. Identifier", uid = "G002", cls = "Contact Office")
				@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=,chn=受理單位",//
						"name=NX201_07,car=1,boro=,chn=受理單位",//
						"name=NX301,car=1,boro=,chn=受理單位",//
						"name=NX401,car=1,boro=,chn=受理單位",//
						"name=NX5105,car=1,boro=,chn=受理單位",//
						"name=NX601,car=1,boro=,chn=受理單位",//
						"name=NX603,car=1,boro=,chn=受理單位",//
				})
				public String ID;

			}

			public Payment Payment = new Payment();

			@DSREF(cls = "Payment")
			@AAA(msg = {
					//
					"name=NX301,car=1,boro=+",//
					"name=NX301_DN,car=1,boro=+",//
					"name=NX401,car=1,boro=+",//
					"name=NX5105,car=1,boro=+",//
					"name=NX601,car=1,boro=+",//
					"name=NX603,car=1,boro=+",//
			})
			public class Payment {

				public Payment() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Payment. Method. Code", uid = "107", cls = "Payment")
				@AAA(msg = {
						//
						"name=NX301,car=1,boro=,chn=繳款方式代碼",//
						"name=NX301_DN,car=1,boro=,chn=繳款方式代碼",//
						"name=NX401,car=1,boro=,chn=繳款方式代碼",//
						"name=NX5105,car=1,boro=,chn=繳款方式代碼",//
						"name=NX601,car=1,boro=,chn=繳款方式代碼",//
						"name=NX603,car=1,boro=,chn=繳款方式代碼",//
				})
				public String MethodCode;

			}

			public ResponsibleGovernmentAgency ResponsibleGovernmentAgency = new ResponsibleGovernmentAgency();

			@DSREF(cls = "Responsible Government Agency")
			@AAA(msg = {
					//
					"name=NX301,car=1,boro=",//
					"name=NX301_DN,car=1,boro=+",//
					"name=NX5105,car=1,boro=+",//
					"name=NX601,car=0..1,boro=+",//
					"name=NX603,car=1,boro=",//
			})
			public class ResponsibleGovernmentAgency {

				public ResponsibleGovernmentAgency() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Responsible Government Agency. Identification. Identifier", uid = "R062", cls = "Responsible Government Agency")
				@AAA(msg = {
				//
				"name=NX5105,car=1,boro=,chn=機關別代碼",//
				})
				public String ID;
			}

			public tw_Applicant tw_Applicant = new tw_Applicant();

			@DSREF(cls = "Applicant")
			@AAA(msg = {
					//
					"name=NX201_01,car=1,boro=",//
					"name=NX201_07,car=1,boro=",//
					"name=NX202,car=1,boro=",//
					"name=NX901,car=0..1,boro=",//
					"name=NX902,car=0..1,boro=",//
			})
			public class tw_Applicant {

				public tw_Applicant() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Applicant. Chinese Name. Text", uid = "TW069", cls = "Applicant")
				@AAA(msg = {
				//
				"name=NX201_01,car=1,boro=,chn=申請人中文名稱",//
				})
				public String tw_ChineseName;

				@DSREF(den = "Applicant. Function. Code", uid = "102", cls = "Applicant")
				public String FunctionCode;

				@DSREF(den = "Applicant. Identification. Identifier", uid = "TW050", cls = "Applicant")
				@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=,chn=申請人統一編號",//
						"name=NX201_07,car=1,boro=,chn=申請人統一編號",//
						"name=NX202,car=1,boro=,chn=申請人統一編號",//
						"name=NX901,car=1,boro=,chn=申請人統一編號",//
						"name=NX902,car=1,boro=,chn=申請人統一編號",//
				})
				public String ID;

				@DSREF(den = "Applicant. Name. Text", uid = "TW066", cls = "Applicant")
				@AAA(msg = {
				//
				"name=NX201_01,car=1,boro=,chn=申請人英文名稱",//
				})
				public String Name;

				@DSREF(den = "Applicant. Quality Assurance. Indicator", uid = "249", cls = "Applicant")
				public String QualityAssuranceIndicator;

				@DSREF(den = "Applicant. Type. Code", uid = "TW104", cls = "Applicant")
				@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=,chn=身分識別代碼",//
						"name=NX201_07,car=1,boro=,chn=身分識別代碼",//
				})
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=+",//
						"name=NX201_07,car=0..1,boro=+",//
						"name=NX202,car=0..1,boro=+",//
						"name=NX301,car=1,boro=+",//
						"name=NX5105,car=1,boro=+",//
						"name=NX603,car=1,boro=+",//
				})
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;

					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					@AAA(msg = {
					//
					"name=NX201_01,car=1,boro=,chn=申請人英文地址",//
					})
					public String Line;

					@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
					@AAA(msg = {
					//
					"name=NX201_01,car=1,boro=,chn=申請人中文地址",//
					})
					public String tw_ChineseLine;

					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				@AAA(msg = {
						//
						"name=NX201_01,car=1,boro=+",//
						"name=NX201_07,car=0..1,boro=+",//
						"name=NX202,car=0..1,boro=+",//
						"name=NX301,car=1..2,boro=+",//
						"name=NX5105,car=1..2,boro=+",//
						"name=NX603,car=1..2,boro=+",//
				})
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					@AAA(msg = {
					//
					"name=NX201_01,car=1,boro=,chn=申請人電話",//
					})
					public String ID;

					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					@AAA(msg = {
					//
					"name=NX201_01,car=1,boro=,chn=*聯絡資料類別代碼",//
					})
					public String TypeID;
				}
			}

			public tw_Appointment tw_Appointment = new tw_Appointment();

			@DSREF(cls = "Appointment")
			@AAA(msg = {
					//
					"name=NX301,car=0..1,boro=",//
					"name=NX301_DN,car=0..1,boro=",//
					"name=NX401,car=0..1,boro=",//
					"name=NX5105,car=0..1,boro=",//
					"name=NX601,car=0..1,boro=",//
					"name=NX603,car=0..1,boro=",//
			})
			public class tw_Appointment {

				public tw_Appointment() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Appointment. Reservation. Date", uid = "TW111", cls = "Appointment")
				@AAA(msg = {
						//
						"name=NX301,car=1,boro=,chn=預約日期",//
						"name=NX301_DN,car=0..1,boro=,chn=預約日期",//
						"name=NX401,car=0..1,boro=,chn=預約日期",//
						"name=NX5105,car=0..1,boro=,chn=預約日期",//
						"name=NX601,car=0..1,boro=,chn=預約日期",//
						"name=NX603,car=1,boro=,chn=預約日期",//
				})
				public String tw_ReservedDate;

				@DSREF(den = "Appointment. Reservation Period. Code", uid = "TW107", cls = "Appointment")
				@AAA(msg = {
						//
						"name=NX301,car=1,boro=,chn=預約時段",//
						"name=NX301_DN,car=0..1,boro=,chn=預約時段",//
						"name=NX401,car=0..1,boro=,chn=預約時段",//
						"name=NX5105,car=0..1,boro=,chn=預約時段",//
						"name=NX601,car=0..1,boro=,chn=預約時段",//
						"name=NX603,car=1,boro=,chn=預約時段",//
				})
				public String tw_ReservationPeriodCode;
			}

			public tw_ApprovalAuthenticationInformation tw_ApprovalAuthenticationInformation = new tw_ApprovalAuthenticationInformation();

			@DSREF(cls = "Approval Authentication Information")
			@AAA(msg = {
					//
					"name=NX301,car=0..1,boro=",//
					"name=NX5105,car=0..1,boro=",//
					"name=NX603,car=0..1,boro=",//
			})
			public class tw_ApprovalAuthenticationInformation {

				public tw_ApprovalAuthenticationInformation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Approval Authentication Information. Identification. Identifier", uid = "D005", cls = "Approval Authentication Information")
				@AAA(msg = {
						//
						"name=NX301,car=1,boro=*,chn=檢驗登記號碼",//
						"name=NX5105,car=1,boro=*,chn=檢驗登記號碼",//
				// "name=NX603,car=1,boro=*,chn=藥商登記證(醫事機構代碼)",//
				})
				public String tw_ID;

			}

			public tw_AuthorizedInformation tw_AuthorizedInformation = new tw_AuthorizedInformation();

			@DSREF(cls = "Authorized Information")
			@AAA(msg = {
					//
					"name=NX301_DN,car=1,boro=",//
					"name=NX401,car=0..1,boro=",//
					"name=NX5105,car=0..1,boro=",//
			})
			public class tw_AuthorizedInformation {

				public tw_AuthorizedInformation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Authorized Information. Authorized Type. Code", uid = "TW068", cls = "Authorized Information")
				@AAA(msg = {
						//
						"name=NX301_DN,car=1,boro=,chn=委任方式代碼",//
						"name=NX5105,car=0..1,boro=,chn=委任方式代碼",//
				})
				public String tw_AuthorizedTypeCode;

				public AdditionalDocument AdditionalDocument = new AdditionalDocument();

				@DSREF(cls = "Additional Document")
				@AAA(msg = {
						//
						"name=NX301_DN,car=0..1,boro=+",//
						"name=NX401,car=0..1,boro=+",//
						"name=NX5105,car=0..1,boro=+",//
				})
				public class AdditionalDocument {

					public AdditionalDocument() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Additional Document. Identification. Identifier", uid = "D005", cls = "Additional Document")
					@AAA(msg = {
							//
							"name=NX301_DN,car=1,boro=,chn=核准文號或委任書編號",//
							"name=NX401,car=1,boro=,chn=核准文號或委任書編號",//
							"name=NX5105,car=1,boro=,chn=核准文號或委任書編號",//
					})
					public String ID;

				}

			}

			public tw_Declarer tw_Declarer = new tw_Declarer();

			@DSREF(cls = "Declarer")
			@AAA(msg = {
					//
					"name=NX301,car=1,boro=",//
					"name=NX5105,car=0..1,boro=",//
					"name=NX603,car=1,boro=",//
			})
			public class tw_Declarer {

				public tw_Declarer() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Declarer. Chinese Name. Text", uid = "TW076", cls = "Declarer")
				@AAA(msg = {
						//
						"name=NX301,car=1,boro=,chn=報驗義務人中文名稱",//
						"name=NX5105,car=1,boro=,chn=報驗義務人中文名稱",//
						"name=NX603,car=1,boro=,chn=報驗義務人中文名稱",//
				})
				public String tw_ChineseName;

				@DSREF(den = "Declarer. Function. Code", uid = "102", cls = "Declarer")
				public String FunctionCode;

				@DSREF(den = "Declarer. Identification. Identifier", uid = "TW088", cls = "Declarer")
				@AAA(msg = {
						//
						"name=NX301,car=1,boro=,chn=報驗義務人統一編號",//
						"name=NX5105,car=1,boro=,chn=報驗義務人統一編號",//
						"name=NX603,car=1,boro=,chn=報驗義務人統一編號",//
				})
				public String ID;

				@DSREF(den = "Declarer. Name. Text", uid = "TW085", cls = "Declarer")
				@AAA(msg = {
						//
						"name=NX301,car=1,boro=,chn=報驗義務人英文名稱",//
						"name=NX5105,car=1,boro=,chn=報驗義務人英文名稱",//
						"name=NX603,car=1,boro=,chn=報驗義務人英文名稱",//
				})
				public String Name;

				@DSREF(den = "Declarer. Quality Assurance. Indicator", uid = "249", cls = "Declarer")
				public String QualityAssuranceIndicator;

				@DSREF(den = "Declarer. Type. Code", uid = "TW104", cls = "Declarer")
				@AAA(msg = {
						//
						"name=NX301,car=1,boro=,chn=身分識別代碼",//
						"name=NX5105,car=1,boro=,chn=身分識別代碼",//
						"name=NX603,car=1,boro=,chn=身分識別代碼",//
				})
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				@AAA(msg = {
						//
						"name=NX301,car=1,boro=+",//
						"name=NX5105,car=1,boro=+",//
						"name=NX603,car=1,boro=+",//
				})
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;

					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;

					@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
					@AAA(msg = {
							//
							"name=NX301,car=1,boro=,chn=報驗義務人中文地址",//
							"name=NX5105,car=1,boro=,chn=報驗義務人中文地址",//
							"name=NX603,car=1,boro=,chn=報驗義務人中文地址",//
					})
					public String tw_ChineseLine;

					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				@AAA(msg = {
						//
						"name=NX301,car=1..2,boro=+",//
						"name=NX5105,car=1..2,boro=+",//
						"name=NX603,car=1..2,boro=+",//
				})
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					@AAA(msg = {
							//
							"name=NX301,car=1,boro=,chn=報驗義務人電話;報驗義務人電子郵件",//
							"name=NX5105,car=1,boro=,chn=報驗義務人電話;報驗義務人電子郵件",//
							"name=NX603,car=1,boro=,chn=報驗義務人電話;報驗義務人電子郵件",//
					})
					public String ID;

					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					@AAA(msg = {
							//
							"name=NX301,car=1,boro=,chn=*聯絡資料類別代碼",//
							"name=NX5105,car=1,boro=,chn=*聯絡資料類別代碼",//
							"name=NX603,car=1,boro=,chn=*聯絡資料類別代碼",//
					})
					public String TypeID;
				}
			}

			public tw_ItemGroupReference tw_ItemGroupReference = new tw_ItemGroupReference();

			@DSREF(cls = "Item Group Reference")
			@AAA(msg = {
			//
			"name=NX5105,car=1..9999,boro=",//
			})
			public class tw_ItemGroupReference {

				public tw_ItemGroupReference() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Item Group Reference. Functional Reference. Identifier", uid = "D026", cls = "")
				public String tw_FunctionalReferenceID;

				@DSREF(den = "Item Group Reference. Sequence. Numeric", uid = "006", cls = "Item Group Reference")
				@AAA(msg = {
				//
				"name=NX5105,car=1,boro=*,chn=項次",//
				})
				public String tw_SequenceNumeric;

			}

			public tw_Label tw_Label = new tw_Label();

			@DSREF(cls = "Label")
			@AAA(msg = {
					//
					"name=NX301,car=1..99,boro=",//
					"name=NX5105,car=0..99,boro=",//
					"name=NX603,car=1..99,boro=",//
			})
			public class tw_Label {

				public tw_Label() {

				}

				public Status Status = new Status();

				@DSREF(cls = "Status")
				@AAA(msg = {
						//
						"name=NX301,car=1,boro=+",//
						"name=NX5105,car=1,boro=+",//
						"name=NX603,car=1,boro=+",//
				})
				public class Status {

					public Status() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Status. Name. Code", uid = "379", cls = "Status")
					@AAA(msg = {
							//
							"name=NX301,car=1,boro=,chn=登錄狀態",//
							"name=NX5105,car=1,boro=,chn=登錄狀態",//
					// "name=NX603,car=1,boro=,chn=登錄狀態",//
					})
					public String NameCode;

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				public tw_LabelDetail tw_LabelDetail = new tw_LabelDetail();

				@DSREF(cls = "Label Detail")
				@AAA(msg = {
						//
						"name=NX301,car=0..99,boro=",//
						"name=NX5105,car=0..99,boro=",//
				// "name=NX603,car=0..99,boro=",//
				})
				public class tw_LabelDetail {

					public tw_LabelDetail() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Label Detail. End Number. Text", uid = "TW087", cls = "Label Detail")
					@AAA(msg = {
							//
							"name=NX301,car=0..1,boro=,chn=標識迄號",//
							"name=NX5105,car=0..1,boro=,chn=標識迄號",//
					// "name=NX603,car=0..1,boro=,chn=標識迄號",//
					})
					public String tw_EndNumber;

					@DSREF(den = "Label Detail. Start Number. Text", uid = "TW089", cls = "Label Detail")
					@AAA(msg = {
							//
							"name=NX301,car=0..1,boro=,chn=標識起號",//
							"name=NX5105,car=0..1,boro=,chn=標識起號",//
					// "name=NX603,car=0..1,boro=,chn=標識起號",//
					})
					public String tw_StartNumber;

					@DSREF(den = "Label Detail. Track. Text", uid = "TW094", cls = "Label Detail")
					@AAA(msg = {
							//
							"name=NX301,car=0..1,boro=,chn=標識字軌",//
							"name=NX5105,car=0..1,boro=,chn=標識字軌",//
					// "name=NX603,car=0..1,boro=,chn=標識字軌",//
					})
					public String tw_Track;

					@DSREF(den = "Label Detail. Year. Numeric", uid = "TW095", cls = "Label Detail")
					@AAA(msg = {
							//
							"name=NX301,car=0..1,boro=,chn=標識年度",//
							"name=NX5105,car=0..1,boro=,chn=標識年度",//
					// "name=NX603,car=0..1,boro=,chn=標識年度",//
					})
					public String tw_YearNumeric;

				}

			}

			public tw_LocalManufacturer tw_LocalManufacturer = new tw_LocalManufacturer();

			@DSREF(cls = "Local Manufacturer")
			@AAA(msg = {
					//
					"name=NX5105,car=0..1,boro=",//
					"name=NX601,car=1,boro=",//
			})
			public class tw_LocalManufacturer {

				public tw_LocalManufacturer() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Local Manufacturer. Function. Code", uid = "102", cls = "Local Manufacturer")
				public String FunctionCode;

				@DSREF(den = "Local Manufacturer. Identification. Identifier", uid = "R004", cls = "Local Manufacturer")
				public String ID;

				@DSREF(den = "Local Manufacturer. Name. Text", uid = "R003", cls = "Local Manufacturer")
				public String Name;

				@DSREF(den = "Local Manufacturer. Chinese Name. Text", uid = "TW084", cls = "Local Manufacturer")
				@AAA(msg = {
						//
						"name=NX5105,car=1,boro=,chn=國內負責廠商中文名稱",//
						"name=NX601,car=1,boro=,chn=國內負責廠商中文名稱",//
				})
				public String tw_ChineseName;

				@DSREF(den = "Local Manufacturer. Quality Assurance. Indicator", uid = "249", cls = "Local Manufacturer")
				public String QualityAssuranceIndicator;

				@DSREF(den = "Local Manufacturer. Type. Code", uid = "TW106", cls = "Local Manufacturer")
				public String tw_TypeCode;

				public Address Address = new Address();

				@DSREF(cls = "Address")
				@AAA(msg = {
						//
						"name=NX5105,car=1,boro=+",//
						"name=NX601,car=1,boro=+",//
				})
				public class Address {

					public Address() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
					public String CityName;
					@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
					public String CountryCode;
					@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
					public String CountrySubDivisionID;
					@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
					public String CountrySubDivisionName;
					@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
					public String Line;

					@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
					@AAA(msg = {
							//
							"name=NX5105,car=1,boro=,chn=國內負責廠商中文地址",//
							"name=NX601,car=1,boro=,chn=國內負責廠商中文地址",//
					})
					public String tw_ChineseLine;

					@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
					public String PostcodeID;
				}

				public Communication Communication = new Communication();

				@DSREF(cls = "Communication")
				@AAA(msg = {
						//
						"name=NX5105,car=1,boro=+",//
						"name=NX601,car=1,boro=+",//
				})
				public class Communication {

					public Communication() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
					@AAA(msg = {
							//
							"name=NX5105,car=1,boro=,chn=國內負責廠商電話",//
							"name=NX601,car=1,boro=,chn=國內負責廠商電話",//
					})
					public String ID;

					@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
					public String TypeID;
				}
			}

			public tw_PreRelease tw_PreRelease = new tw_PreRelease();

			@DSREF(cls = "PreRelease")
			public class tw_PreRelease {

				public tw_PreRelease() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "PreRelease. Application. Code", uid = "TW_101", cls = "Additional Information")
				public String tw_ApplicationCode;

				@DSREF(den = "PreRelease. Application Description. Text", uid = "TW_102", cls = "Additional Information")
				public String tw_ApplicationDescription;

				@DSREF(den = "PreRelease. Pick Up. Date", uid = "TW204", cls = "PreRelease")
				public String tw_PickUpDate;

				public AdditionalInformation AdditionalInformation = new AdditionalInformation();

				@DSREF(cls = "Additional Information")
				public class AdditionalInformation {

					public AdditionalInformation() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Additional Information. Statement. Code", uid = "226", cls = "Additional Information")
					public String StatementCode;

					@DSREF(den = "Additional Information. Statement Description. Text", uid = "225", cls = "Additional Information")
					public String StatementDescription;

				}

				public Contact Contact = new Contact();

				@DSREF(cls = "Contact")
				public class Contact {

					public Contact() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
					public String Name;

					public Communication Communication = new Communication();

					@DSREF(cls = "Communication")
					public class Communication {

						public Communication() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
						public String ID;

						@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
						public String TypeID;

					}
				}

				public ContactOffice ContactOffice = new ContactOffice();

				@DSREF(cls = "Contact Office")
				public class ContactOffice {

					public ContactOffice() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Contact Office. Identification. Identifier", uid = "G002", cls = "Contact Office")
					public String ID;

				}

				public tw_PreReleaseDetail tw_PreReleaseDetail = new tw_PreReleaseDetail();

				@DSREF(cls = "PreRelease Detail")
				public class tw_PreReleaseDetail {

					public tw_PreReleaseDetail() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "PreRelease Detail. Quantity. Quantity", uid = "144", cls = "PreRelease Detail")
					public String tw_Quantity;

					@DSREF(den = "PreRelease Detail. Scheduled Inspection. Date", uid = "TW270", cls = "PreRelease Detail")
					public String tw_ScheduledInspectionDate;

					@DSREF(den = "PreRelease Detail. Scheduled Sampling. Date", uid = "TW269", cls = "PreRelease Detail")
					public String tw_ScheduleSamplingDate;

					@DSREF(den = "PreRelease Detail. Unit. Code", uid = "TW_068", cls = "PreRelease Detail")
					public String tw_UnitCode;

					public TransitDestination TransitDestination = new TransitDestination();

					@DSREF(cls = "Transit Destination")
					public class TransitDestination {

						public TransitDestination() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Transit Destination. Identification. Identifier", uid = "L008", cls = "Transit Destination")
						public String ID;

						@DSREF(den = "Transit Destination. Name. Text", uid = "L007", cls = "Transit Destination")
						public String Name;

						public Contact Contact = new Contact();

						@DSREF(cls = "Contact")
						public class Contact {

							public Contact() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Contact. Name. Text", uid = "246", cls = "Contact")
							public String Name;

							public Communication Communication = new Communication();

							@DSREF(cls = "Communication")
							public class Communication {

								public Communication() {

								}

								public boolean hasMachedProps() {
									return new Worker(msgName).hasMachedProps(this);
								}

								public String getSchema() {
									return new Worker(msgName).getSchema(this);
								}

								@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
								public String ID;

								@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
								public String TypeID;
							}

						}

					}

				}

			}

			public tw_Wine tw_Wine = new tw_Wine();

			@DSREF(cls = "Wine")
			@AAA(msg = {
					//
					"name=NX301_DN,car=1,boro=",//
					"name=NX5105,car=0..1,boro=",//
			})
			public class tw_Wine {

				public tw_Wine() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				public GovernmentProcedure GovernmentProcedure = new GovernmentProcedure();

				@DSREF(cls = "Government Procedure")
				@AAA(msg = {
						//
						"name=NX301_DN,car=1,boro=+",//
						"name=NX5105,car=1,boro=+",//
				})
				public class GovernmentProcedure {

					public GovernmentProcedure() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Government Procedure. Current. Code", uid = "166", cls = "Government Procedure")
					public String CurrentCode;

					@DSREF(den = "Government Procedure. Description. Text", uid = "353", cls = "Government Procedure")
					public String Description;

					@DSREF(den = "Government Procedure. Previous. Code", uid = "161", cls = "Government Procedure")
					@AAA(msg = {
							//
							"name=NX301_DN,car=1,boro=,chn=以往進口查驗情形",//
							"name=NX5105,car=1,boro=,chn=以往進口查驗情形",//
					})
					public String PreviousCode;
				}

				public PreviousDocument PreviousDocument = new PreviousDocument();

				@DSREF(cls = "Previous Document")
				@AAA(msg = {
						//
						"name=NX301_DN,car=0..1,boro=+",//
						"name=NX5105,car=0..1,boro=+",//
				})
				public class PreviousDocument {

					public PreviousDocument() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Previous Document. Identification. Identifier", uid = "D018", cls = "Previous Document")
					@AAA(msg = {
							//
							"name=NX301_DN,car=1,boro=,chn=原輸出入許可文件號碼",//
							"name=NX5105,car=1,boro=,chn=原輸出入許可文件號碼",//
					})
					public String ID;

					@DSREF(den = "Previous Document. Issue. Date Time", uid = "D010", cls = "Previous Document")
					public String IssueDateTime;

					@DSREF(den = "Previous Document. Line. Numeric", uid = "171", cls = "Previous Document")
					public String SequenceNumeric;

				}
			}
		}

		public tw_ApplicationResponse tw_ApplicationResponse = new tw_ApplicationResponse();

		@DSREF(cls = "Application Response")
		@AAA(msg = {
		//
		"name=NX5106,car=0..9999,boro=",//
		})
		public class tw_ApplicationResponse {

			public tw_ApplicationResponse() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Application Response. Issue. Date Time", uid = "D029", cls = "Application Response")
			@AAA(msg = {
			//
			"name=NX5106,car=0..1,boro=*,chn=通知日期與時間",//
			})
			public String tw_IssueDateTime;

			public AdditionalInformation AdditionalInformation = new AdditionalInformation();

			@DSREF(cls = "Additional Information")
			@AAA(msg = {
			//
			"name=NX5106,car=0..1,boro=+",//
			})
			public class AdditionalInformation {

				public AdditionalInformation() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Additional Information. Content. Text", uid = "105", cls = "Additional Information")
				@AAA(msg = {
				//
				"name=NX5106,car=1,boro=,chn=說明",//
				})
				public String tw_Content;
			}

			public ContactOffice ContactOffice = new ContactOffice();

			@DSREF(cls = "Contact Office")
			@AAA(msg = {
			//
			"name=NX5106,car=0..1,boro=+",//
			})
			public class ContactOffice {

				public ContactOffice() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Contact Office. Identification. Identifier", uid = "G002", cls = "Contact Office")
				@AAA(msg = {
				//
				"name=NX5106,car=1,boro=,chn=受理單位",//
				})
				public String IdentificationCode;
			}

			public Status Status = new Status();

			@DSREF(cls = "Status")
			@AAA(msg = {
			//
			"name=NX5106,car=1..99,boro=+",//
			})
			public class Status {

				public Status() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Status. Name. Code", uid = "379", cls = "Status")
				@AAA(msg = {
				//
				"name=NX5106,car=1,boro=,chn=回應狀況代碼",//
				})
				public String NameCode;
			}

			public tw_Application tw_Application = new tw_Application();

			@DSREF(cls = "Application")
			@AAA(msg = {
			//
			"name=NX5106,car=1,boro=",//
			})
			public class tw_Application {

				public tw_Application() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Application. Acceptance. Date Time", uid = "023", cls = "Application")
				@AAA(msg = {
				//
				"name=NX5106,car=0..1,boro=*,chn=收件日期與時間",//
				})
				public String tw_AcceptanceDateTime;

				@DSREF(den = "Application. Function. Code", uid = "017", cls = "Application")
				@AAA(msg = {
				//
				"name=NX5106,car=1,boro=*,chn=訊息功能代碼",//
				})
				public String tw_FunctionCode;

				@DSREF(den = "Application. Type. Code", uid = "TW106", cls = "Application")
				@AAA(msg = {
				//
				"name=NX5106,car=0..1,boro=,chn=申請業務別",//
				})
				public String tw_TypeCode;

				public Agent Agent = new Agent();

				@DSREF(cls = "Agent")
				@AAA(msg = {
				//
				"name=NX5106,car=0..1,boro=+",//
				})
				public class Agent {

					public Agent() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Agent. Function. Code", uid = "102", cls = "Agent")
					public String FunctionCode;

					@DSREF(den = "Agent. Identification. Identifier", uid = "R004", cls = "Agent")
					@AAA(msg = {
					//
					"name=NX5106,car=1,boro=,chn=報驗/申辦代理人統一編號",//
					})
					public String ID;
				}

				public AdditionalInformation AdditionalInformation = new AdditionalInformation();

				@DSREF(cls = "Additional Information")
				@AAA(msg = {
				//
				"name=NX5106,car=0..1,boro=+",//
				})
				public class AdditionalInformation {

					public AdditionalInformation() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Additional Information. Process Number. Text", uid = "TW128", cls = "Additional Information")
					@AAA(msg = {
					//
					"name=NX5106,car=1,boro=,chn=收件編號",//
					})
					public String tw_ProcessNumber;
				}

				public GoodsShipment GoodsShipment = new GoodsShipment();

				@DSREF(cls = "Goods Shipment")
				@AAA(msg = {
				//
				"name=NX5106,car=0..1,boro=+",//
				})
				public class GoodsShipment {

					public GoodsShipment() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					public AdditionalDocument AdditionalDocument = new AdditionalDocument();

					@DSREF(cls = "Additional Document")
					@AAA(msg = {
					//
					"name=NX5106,car=0..1,boro=+",//
					})
					public class AdditionalDocument {

						public AdditionalDocument() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Additional Document. Identification. Identifier", uid = "D005", cls = "Additional Document")
						@AAA(msg = {
						//
						"name=NX5106,car=1,boro=,chn=輸出入許可文件號碼",//
						})
						public String ID;
					}

					public AdditionalInformation AdditionalInformation = new AdditionalInformation();

					@DSREF(cls = "Additional Information")
					@AAA(msg = {
					//
					"name=NX5106,car=0..1,boro=+",//
					})
					public class AdditionalInformation {

						public AdditionalInformation() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Additional Information. Statement Description. Text", uid = "225", cls = "Additional Information")
						@AAA(msg = {
						//
						"name=NX5106,car=1,boro=,chn=備註",//
						})
						public String StatementDescription;
					}

					public GovernmentAgencyGoodsItem GovernmentAgencyGoodsItem = new GovernmentAgencyGoodsItem();

					@DSREF(cls = "Government Agency Goods Item")
					@AAA(msg = {
					//
					"name=NX5106,car=0..9999,boro=+",//
					})
					public class GovernmentAgencyGoodsItem {

						public GovernmentAgencyGoodsItem() {

						}

						public boolean hasMachedProps() {
							return new Worker(msgName).hasMachedProps(this);
						}

						public String getSchema() {
							return new Worker(msgName).getSchema(this);
						}

						@DSREF(den = "Government Agency Goods Item. Sequence. Numeric", uid = "006", cls = "Government Agency Goods Item")
						@AAA(msg = {
						//
						"name=NX5106,car=0..1,boro=,chn=項次",//
						})
						public String SequenceNumeric;

						public AdditionalDocument AdditionalDocument = new AdditionalDocument();

						@DSREF(cls = "Additional Document")
						@AAA(msg = {
						//
						"name=NX5106,car=0..1,boro=+",//
						})
						public class AdditionalDocument {

							public AdditionalDocument() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Additional Document. Sequence. Numeric", uid = "006", cls = "Additional Document")
							@AAA(msg = {
							//
							"name=NX5106,car=1,boro=*,chn=輸出入許可文件項次",//
							})
							public String tw_SequenceNumeric;
						}

						public AdditionalInformation AdditionalInformation = new AdditionalInformation();

						@DSREF(cls = "Additional Information")
						@AAA(msg = {
						//
						"name=NX5106,car=0..1,boro=+",//
						})
						public class AdditionalInformation {

							public AdditionalInformation() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Additional Information. Content. Text", uid = "105", cls = "Additional Information")
							@AAA(msg = {
							//
							"name=NX5106,car=1,boro=,chn=說明",//
							})
							public String tw_Content;
						}

						public Status Status = new Status();

						@DSREF(cls = "Status")
						@AAA(msg = {
						//
						"name=NX5106,car=1..99,boro=+",//
						})
						public class Status {

							public Status() {

							}

							public boolean hasMachedProps() {
								return new Worker(msgName).hasMachedProps(this);
							}

							public String getSchema() {
								return new Worker(msgName).getSchema(this);
							}

							@DSREF(den = "Status. Name. Code", uid = "379", cls = "Status")
							@AAA(msg = {
							//
							"name=NX5106,car=1,boro=,chn=回應狀況代碼",//
							})
							public String NameCode;
						}
					}

				}

				public PreviousDocument_Moved PreviousDocument = new PreviousDocument_Moved();

				@DSREF(cls = "Previous Document")
				@AAA(msg = {
				//
				"name=NX5106,car=1,boro=+",//
				})
				public class PreviousDocument_Moved {

					public PreviousDocument_Moved() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Previous Document. Functional Reference. Identifier", uid = "D026", cls = "Previous Document")
					@AAA(msg = {
					//
					"name=NX5106,car=1,boro=*,chn=原訊息編號",//
					})
					public String tw_FunctionalReferenceID;

					@DSREF(den = "Previous Document. Function. Code", uid = "017", cls = "")
					public String tw_FunctionCode;
				}

				public ResponsibleGovernmentAgency ResponsibleGovernmentAgency = new ResponsibleGovernmentAgency();

				@DSREF(cls = "Responsible Government Agency")
				@AAA(msg = {
				//
				"name=NX5106,car=1,boro=+",//
				})
				public class ResponsibleGovernmentAgency {

					public ResponsibleGovernmentAgency() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Responsible Government Agency. Identification. Identifier", uid = "R062", cls = "Responsible Government Agency")
					@AAA(msg = {
					//
					"name=NX5106,car=1,boro=,chn=機關別代碼",//
					})
					public String ID;
				}

				public tw_Applicant tw_Applicant = new tw_Applicant();

				@DSREF(cls = "Applicant")
				@AAA(msg = {
				//
				"name=NX5106,car=0..1,boro=",//
				})
				public class tw_Applicant {

					public tw_Applicant() {

					}

					public boolean hasMachedProps() {
						return new Worker(msgName).hasMachedProps(this);
					}

					public String getSchema() {
						return new Worker(msgName).getSchema(this);
					}

					@DSREF(den = "Applicant. Identification. Identifier", uid = "TW050", cls = "Applicant")
					@AAA(msg = {
					//
					"name=NX5106,car=1,boro=,chn=申請人統一編號",//
					})
					public String tw_ID;

				}
			}
		}

		public tw_Appointment tw_Appointment = new tw_Appointment();

		@DSREF(cls = "Appointment")
		public class tw_Appointment {

			public tw_Appointment() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Appointment. Reservation. Date Time", uid = "TW111", cls = "Appointment")
			public String tw_ReservedDateTime;

			@DSREF(den = "Appointment. Reservation Period. Code", uid = "TW107", cls = "Appointment")
			public String tw_ReservationPeriodCode;

		}

		public tw_ApprovalAuthenticationInformation tw_ApprovalAuthenticationInformation = new tw_ApprovalAuthenticationInformation();

		@DSREF(cls = "Approval Authentication Information")
		public class tw_ApprovalAuthenticationInformation {

			public tw_ApprovalAuthenticationInformation() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Approval Authentication Information. Identification. Identifier", uid = "D005", cls = "Application")
			public String tw_ID;

		}

		public tw_AuthorizedInformation tw_AuthorizedInformation = new tw_AuthorizedInformation();

		@DSREF(cls = "Authorized Information")
		public class tw_AuthorizedInformation {

			public tw_AuthorizedInformation() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Authorized Information. Authorized Type. Code", uid = "TW068", cls = "Authorized Information")
			public String tw_AuthorizedTypeCode;

			public AdditionalDocument AdditionalDocument = new AdditionalDocument();

			@DSREF(cls = "Additional Document")
			public class AdditionalDocument {

				public AdditionalDocument() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Additional Document. Identification. Identifier", uid = "D005", cls = "Additional Document")
				public String ID;

			}

		}

		public tw_ContainerProcessData tw_ContainerProcessData = new tw_ContainerProcessData();

		@DSREF(cls = "Container Process Data")
		@AAA(msg = {
		//
		"name=N5165,car=0..1,boro=",//
		})
		public class tw_ContainerProcessData {

			public tw_ContainerProcessData() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Container Process Data. Process Event. Date Time", uid = "TW137", cls = "Container Process Data")
			@AAA(msg = {
			//
			"name=N5165,car=1,boro=,chn=貨櫃（物）處理日期與時間",//
			})
			public String tw_ProcessEventDateTime;

			@DSREF(den = "Container Process Data. Process Status. Code", uid = "TW138", cls = "Container Process Data")
			@AAA(msg = {
			//
			"name=N5165,car=1,boro=,chn=貨櫃（物）處理狀態",//
			})
			public String tw_ProcessStatusCode;
		}

		public tw_Declarer tw_Declarer = new tw_Declarer();

		@DSREF(cls = "Declarer")
		public class tw_Declarer {

			public tw_Declarer() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Declarer. Chinese Name. Text", uid = "TW076", cls = "Declarer")
			public String tw_ChineseName;

			@DSREF(den = "Declarer. Function. Code", uid = "102", cls = "Declarer")
			public String FunctionCode;

			@DSREF(den = "Declarer. Identification. Identifier", uid = "TW088", cls = "Declarer")
			public String ID;

			@DSREF(den = "Declarer. Name. Text", uid = "TW085", cls = "Declarer")
			public String Name;

			@DSREF(den = "Declarer. Quality Assurance. Indicator", uid = "249", cls = "Declarer")
			public String QualityAssuranceIndicator;

			@DSREF(den = "Declarer. Type. Code", uid = "TW104", cls = "Declarer")
			public String tw_TypeCode;

			public Address Address = new Address();

			@DSREF(cls = "Address")
			public class Address {

				public Address() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
				public String CityName;
				@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
				public String CountryCode;
				@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
				public String CountrySubDivisionID;
				@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
				public String CountrySubDivisionName;

				@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
				public String Line;

				@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
				public String tw_ChineseLine;

				@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
				public String PostcodeID;
			}

			public Communication Communication = new Communication();

			@DSREF(cls = "Communication")
			public class Communication {

				public Communication() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
				public String ID;

				@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
				public String TypeID;
			}
		}

		public tw_ExpressCarrier tw_ExpressCarrier = new tw_ExpressCarrier();

		@DSREF(cls = "Express Carrier")
		@AAA(msg = {
				//
				"name=N5135,car=1,boro=",//
				"name=N5205,car=1,boro=",//
		})
		public class tw_ExpressCarrier {

			public tw_ExpressCarrier() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Express Carrier. Chinese Name. Text", uid = "TW033", cls = "Express Carrier")
			@AAA(msg = {
					//
					"name=N5135,car=0..1,boro=,chn=快遞業者中文名稱",//
					"name=N5205,car=0..1,boro=,chn=快遞業者中文名稱",//
			})
			public String tw_ChineseName;

			@DSREF(den = "Express Carrier. Identification. Identifier", uid = "R023", cls = "Express Carrier")
			@AAA(msg = {
					//
					"name=N5135,car=1,boro=*,chn=快遞業者統一編號",//
					"name=N5205,car=1,boro=*,chn=快遞業者統一編號",//
			})
			public String tw_ID;

			@DSREF(den = "Express Carrier. Name. Text", uid = "R022", cls = "Express Carrier")
			@AAA(msg = {
					//
					"name=N5135,car=1,boro=*,chn=快遞業者英文名稱",//
					"name=N5205,car=1,boro=*,chn=快遞業者英文名稱",//
			})
			public String tw_Name;

			@DSREF(den = "Express Carrier. Type. Code", uid = "TW104", cls = "Express Carrier")
			@AAA(msg = {
					//
					"name=N5135,car=1,boro=,chn=身分識別代碼",//
					"name=N5205,car=1,boro=,chn=身分識別代碼",//
			})
			public String tw_TypeCode;

		}

		public tw_Forwarder tw_Forwarder = new tw_Forwarder();

		@DSREF(cls = "Forwarder")
		public class tw_Forwarder {

			public tw_Forwarder() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Forwarder. Identification. Identifier", uid = "TW144", cls = "tw_Forwarder")
			public String tw_ID;

		}

		public tw_InlandTransportMeans tw_InlandTransportMeans = new tw_InlandTransportMeans();

		@DSREF(cls = "Inland Transport Means")
		@AAA(msg = {
		//
		"name=N5165,car=0..1,boro=",//
		})
		public class tw_InlandTransportMeans {

			public tw_InlandTransportMeans() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Inland Transport Means. Identification. Identifier", uid = "TW055", cls = "Inland Transport Means")
			@AAA(msg = {
			//
			"name=N5165,car=0..1,boro=,chn=車牌號碼",//
			})
			public String tw_ID;

			public Terminal Terminal = new Terminal();

			@DSREF(cls = "Terminal")
			public class Terminal {

				public Terminal() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Terminal. Identification. Identifier", uid = "L049", cls = "Terminal")
				public String ID;

				@DSREF(den = "Terminal. Name. Text", uid = "WCOIDL048", cls = "Terminal")
				public String Name;

				@DSREF(den = "Terminal. Type. Code", uid = "TW568", cls = "Terminal")
				public String tw_TypeCode;
			}

			public Master Master = new Master();

			@DSREF(cls = "Master")
			@AAA(msg = {
			//
			"name=N5165,car=0..1,boro=+",//
			})
			public class Master {

				public Master() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Master. Identification. Identifier", uid = "R017", cls = "Master")
				@AAA(msg = {
				//
				"name=N5165,car=0..1,boro=,chn=駕照號碼",//
				})
				public String ID;

				@DSREF(den = "Master. Name. Text", uid = "R016", cls = "Master")
				@AAA(msg = {
				//
				"name=N5165,car=0..1,boro=,chn=司機姓名",//
				})
				public String Name;
			}

			public TransportMeansOperator TransportMeansOperator = new TransportMeansOperator();

			@DSREF(cls = "Transport Means Operator")
			public class TransportMeansOperator {

				public TransportMeansOperator() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Transport Means Operator. Identification. Identifier", uid = "R056", cls = "Transport Means Operator")
				public String ID;

				@DSREF(den = "Transport Means Operator. Name. Text", uid = "R016", cls = "Transport Means Operator")
				public String tw_Name;

			}

			public TransportMeansOwner TransportMeansOwner = new TransportMeansOwner();

			@DSREF(cls = "Transport Means Owner")
			@AAA(msg = {
			//
			"name=N5165,car=0..1,boro=+",//
			})
			public class TransportMeansOwner {

				public TransportMeansOwner() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Transport Means Owner. Identification. Identifier", uid = "R090", cls = "Transport Means Owner")
				public String ID;

				@DSREF(den = "Transport Means Owner. Name. Text", uid = "TW056", cls = "Transport Means Owner")
				@AAA(msg = {
				//
				"name=N5165,car=1,boro=,chn=車行名稱",//
				})
				public String tw_Name;
			}
		}

		public tw_Label tw_Label = new tw_Label();

		@DSREF(cls = "Label")
		public class tw_Label {

			public tw_Label() {

			}

			public Status Status = new Status();

			@DSREF(cls = "Status")
			public class Status {

				public Status() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Status. Name. Code", uid = "379", cls = "Status")
				public String NameCode;

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			public tw_LabelDetail tw_LabelDetail = new tw_LabelDetail();

			@DSREF(cls = "Label Detail")
			public class tw_LabelDetail {

				public tw_LabelDetail() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

			}

		}

		public tw_LocalManufacturer tw_LocalManufacturer = new tw_LocalManufacturer();

		@DSREF(cls = "Local Manufacturer")
		public class tw_LocalManufacturer {

			public tw_LocalManufacturer() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Local Manufacturer. Function. Code", uid = "102", cls = "Local Manufacturer")
			public String FunctionCode;

			@DSREF(den = "Local Manufacturer. Identification. Identifier", uid = "R004", cls = "Local Manufacturer")
			public String ID;

			@DSREF(den = "Local Manufacturer. Name. Text", uid = "R003", cls = "Local Manufacturer")
			public String Name;

			@DSREF(den = "Local Manufacturer. Chinese Name. Text", uid = "TW084", cls = "Importer")
			public String tw_ChineseName;

			@DSREF(den = "Local Manufacturer. Quality Assurance. Indicator", uid = "249", cls = "Local Manufacturer")
			public String QualityAssuranceIndicator;

			@DSREF(den = "Local Manufacturer. Type. Code", uid = "TW106", cls = "Local Manufacturer")
			public String tw_TypeCode;

			public Address Address = new Address();

			@DSREF(cls = "Address")
			public class Address {

				public Address() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Address. City. Text", uid = "241", cls = "Address")
				public String CityName;
				@DSREF(den = "Address. Country. Code", uid = "242", cls = "Address")
				public String CountryCode;
				@DSREF(den = "Address. Country Sub Division. Identifier", uid = "244", cls = "Address")
				public String CountrySubDivisionID;
				@DSREF(den = "Address. Country Sub Division Name. Text", uid = "243", cls = "Address")
				public String CountrySubDivisionName;
				@DSREF(den = "Address. Line. Text", uid = "239", cls = "Address")
				public String Line;

				@DSREF(den = "Address. Chinese Line. Text", uid = "TW002", cls = "Address")
				public String tw_ChineseLine;

				@DSREF(den = "Address. Postcode. Identifier", uid = "245", cls = "Address")
				public String PostcodeID;
			}

			public Communication Communication = new Communication();

			@DSREF(cls = "Communication")
			public class Communication {

				public Communication() {

				}

				public boolean hasMachedProps() {
					return new Worker(msgName).hasMachedProps(this);
				}

				public String getSchema() {
					return new Worker(msgName).getSchema(this);
				}

				@DSREF(den = "Communication. Identification. Identifier", uid = "240", cls = "Communication")
				public String ID;

				@DSREF(den = "Communication. Type. Identifier", uid = "253", cls = "Communication")
				public String TypeID;
			}
		}

		public tw_OnBoardCourier tw_OnBoardCourier = new tw_OnBoardCourier();

		@DSREF(cls = "On Board Courier")
		@AAA(msg = {
				//
				"name=N5135,car=0..1,boro=",//
				"name=N5205,car=0..1,boro=",//
		})
		public class tw_OnBoardCourier {

			public tw_OnBoardCourier() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "On Board Courier. Chinese Name. Text", uid = "TW049", cls = "On Board Courier")
			@AAA(msg = {
					//
					"name=N5135,car=0..1,boro=,chn=快遞專差中文名稱",//
					"name=N5205,car=0..1,boro=,chn=快遞專差中文名稱",//
			})
			public String tw_ChineseName;

			@DSREF(den = "On Board Courier. Identification. Identifier", uid = "R023", cls = "On Board Courier")
			@AAA(msg = {
					//
					"name=N5135,car=1,boro=*,chn=快遞專差統一編號",//
					"name=N5205,car=1,boro=*,chn=快遞專差統一編號",//
			})
			public String tw_ID;

			@DSREF(den = "On Board Courier. Name. Text", uid = "R022", cls = "On Board Courier")
			@AAA(msg = {
					//
					"name=N5135,car=1,boro=*,chn=快遞專差英文名稱",//
					"name=N5205,car=1,boro=*,chn=快遞專差英文名稱",//
			})
			public String tw_Name;

			@DSREF(den = "On Board Courier. Type. Code", uid = "TW104", cls = "On Board Courier")
			@AAA(msg = {
					//
					"name=N5135,car=1,boro=,chn=身分識別代碼",//
					"name=N5205,car=1,boro=,chn=身分識別代碼",//
			})
			public String tw_TypeCode;

		}

		public tw_PreIssuedDocument tw_PreIssuedDocument = new tw_PreIssuedDocument();

		@DSREF(cls = "Pre Issued Document")
		public class tw_PreIssuedDocument {

			public tw_PreIssuedDocument() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Pre Issued Document. Identification. Identifier", uid = "D005", cls = "Pre Issued Document")
			public String tw_ID;
		}

		public tw_SpecialPermit tw_SpecialPermit = new tw_SpecialPermit();

		@DSREF(cls = "Special Permit")
		@AAA(msg = {
		//
		"name=N5166,car=0..1,boro=",//
		})
		public class tw_SpecialPermit {

			public tw_SpecialPermit() {

			}

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Special Permit. Identification. Identifier", uid = "D005", cls = "Special Permit")
			@AAA(msg = {
			//
			"name=N5166,car=1,boro=*,chn=特別准單號碼",//
			})
			public String tw_ID;

			@DSREF(den = "Special Permit. Statement Type. Code", uid = "369", cls = "Special Permit")
			public String tw_StatementTypeCode;
		}

	public UnloadingLocation UnloadingLocation = new UnloadingLocation();

		@DSREF(cls = "Unloading Location")
		@AAA(msg = {
				//
				"name=N5101,car=0..1,boro=#",//
				"name=N5165,car=1,boro=",//
				"name=N5170,car=1,boro=#",//
				"name=N5201,car=0..1,boro=#",//
				"name=N5262,car=1,boro=#",//
				"name=N5301,car=1,boro=#",//
				"name=N5302,car=1,boro=#",//
		})
		public class UnloadingLocation {

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Unloading Location. Arrival. Date Time", uid = "173", cls = "Unloading Location")
			@AAA(msg = {
			//
			"name=N5101,car=1,boro=,chn=（預定）到達日期",//
			})
			public String ArrivalDateTime;

			@DSREF(den = "Unloading Location. Identification. Identifier", uid = "L013", cls = "Unloading Location")
			@AAA(msg = {
					//
					"name=N5165,car=1,boro=,chn=運往地點代碼",//
					"name=N5170,car=1,boro=,chn=運往地點代碼",//
					"name=N5201,car=1,boro=,chn=目的地代碼",//
					"name=N5262,car=1,boro=,chn=運往地點代碼",//
					"name=N5301,car=1,boro=,chn=運往地點代碼",//
					"name=N5302,car=1,boro=,chn=運往地點代碼",//
			})
			public String ID;

			@DSREF(den = "Unloading Location. Name. Text", uid = "L012", cls = "Unloading Location")
			public String Name;
		}

		public Warehouse_Added Warehouse = new Warehouse_Added();

		@DSREF(cls = "Warehouse")
		@AAA(msg = {
		//
		"name=N5117,car=1,boro=+",//
		})
		public class Warehouse_Added {

			public boolean hasMachedProps() {
				return new Worker(msgName).hasMachedProps(this);
			}

			public String getSchema() {
				return new Worker(msgName).getSchema(this);
			}

			@DSREF(den = "Warehouse. Arrival. Date Time", uid = "221", cls = "Warehouse")
			public String ArrivalDateTime;

			@DSREF(den = "Warehouse. Storage Area. Code", uid = "TW063", cls = "Warehouse")
			public String tw_StorageAreaCode;

			@DSREF(den = "Warehouse. Storage Location. Text", uid = "TW065", cls = "Warehouse")
			public String tw_StorageLocation;

			@DSREF(den = "Warehouse. Exit. Date Time", uid = "TW074", cls = "Warehouse")
			@AAA(msg = {
			//
			"name=N5117,car=1,boro=,chn=出倉日期與時間",//
			})
			public String tw_ExitDateTime;

			@DSREF(den = "Warehouse. Identification. Identifier", uid = "L019", cls = "Warehouse")
			public String ID;
			@DSREF(den = "Warehouse. Name. Text", uid = "L018", cls = "Warehouse")
			public String Name;
		}

	}
}
