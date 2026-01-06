package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class XmaDB {

	public static String driver = "org.apache.derby.jdbc.ClientDriver";
	// public static String driver = "oracle.jdbc.driver.OracleDriver";
	public static String protocol = "jdbc:derby://localhost:1527/custom";
	// public static String protocol = "jdbc:oracle:thin:@10.4.212.167:1533:TINT1";
	
	public static Connection conn = null;

	public static void openConnection() {
		if (conn != null)
			return;
		try { // load the driver
			Class.forName(driver).newInstance();
			// System.out.println("Load the driver");

			Properties props = new Properties();
			// derby password 
			props.put("user", "mu");
			props.put("password", "mu");
            
			
			// props.put("user", "pwomgr");
			// props.put("password", "tvpwomgr");
			// create and connect the database named helloDB
			conn = DriverManager.getConnection(protocol, props);
			// System.out.println("create and connect to custom db");
			// conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			if (conn == null)
				return;
			if (conn.isClosed())
				return;

			conn.close();
			conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public TWDENS_DAO getGroupInfo(String chName) {
	//
	// TWDENS_DAO o = null;
	// Statement stmt = null;
	// ResultSet rs = null;
	//
	// // -------------------------------------------------------
	// if (!chName.trim().equals("")) {
	// // Get Data Set data
	// {
	// String sql = "SELECT *  FROM  TWGRP  WHERE " + //
	// " CHNAME = '" + chName + "'";
	// try {
	// stmt = conn.createStatement();
	// rs = stmt.executeQuery(sql);
	// while (rs.next()) {
	// o = new TWDENS_DAO();
	// o.sn = rs.getString("SN");
	// // o.twid = rs.getString("TWID");
	// o.chName = rs.getString("CHNAME");
	// o.enName = rs.getString("ENNAME");
	//
	// // o.sample = rs.getString("SAMPLE") != null ? rs.getString("SAMPLE") : "";
	// }
	// if (o == null)
	// System.out.println(sql);
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// if (rs != null)
	// rs.close();
	// rs = null;
	// if (stmt != null)
	// stmt.close();
	// stmt = null;
	// } catch (Exception e) {
	// System.err.println(chName + "- exception -" + e.getMessage());
	// e.printStackTrace();
	// }
	// }
	// // System.out.println("NAMEDCOMPLEXTYPE=="+o.namedComplexType);
	// }
	//
	// // -------------------------------------------------------
	// if (o == null) {
	// System.out.println("rrrrr group == null --->" + chName);
	// return o;
	// }
	// }
	// return o;
	// }

	public TWDENS_DAO getDsResult(String chName, String den, String uid) {

		TWDENS_DAO o = null;
		Statement stmt = null;
		ResultSet rs = null;

		// -------------------------------------------------------
		if (!chName.trim().equals("")) {
			// Get Data Set data
			{
				String sql = "SELECT *  FROM  TWDS  WHERE " + //
						" CHNAME = '" + chName + "'";
				try {
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						o = new TWDENS_DAO();
						o.sn = rs.getString("SN");
						// o.twid = rs.getString("TWID");
						o.chName = rs.getString("CHNAME");
						o.enName = rs.getString("ENNAME");
						o.chDef = rs.getString("CHDEF");
						o.enDef = rs.getString("ENDEF");
						o.format = rs.getString("FORMAT");
						o.codeList = rs.getString("CODELIST") != null ? rs.getString("CODELIST") : "";
						o.sample = rs.getString("SAMPLE") != null ? rs.getString("SAMPLE") : "";
					}
					if (o == null)
						System.out.println(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						rs.close();
						rs = null;
						stmt.close();
						stmt = null;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				// System.out.println("NAMEDCOMPLEXTYPE=="+o.namedComplexType);
			}

			// -------------------------------------------------------
			if (o == null) {
				System.out.println("XmaDB getDsResult rrrrr == null --->" + chName + "," + den);
				return o;
			}
		}
		// -------------------------------------------------------
		// Get DEN & CLASS data
		{
			boolean foundDEN = false;

			String sql = "SELECT " + //
					"a.DEN, " + //
					"a.SRC, " + //

					"a.OBJECTCLASS, " + //
					"a.PROPERTYTERM, " + //
					"a.REPTERM, " + //
					"a.NAMEDCOMPLEXTYPE," + //
					"a.XMLTAGNAME, " + //

					// "a.ENDEF ," + //

					// "b.ENNAME, " + //
					// "b.CHNAME," + //
					// "b.CHDEF," + //

					// "b.PROPLENGTH," + //
					// "b.CODELIST, " + //

					"c.CLASSID," + //
					"c.CLASSNAME," + //
					"c.CHDEF c_chdef," + //
					"c.ENDEF c_endef," + //
					"c.CHNAME c_chname," + //
					"c.ENNAME c_enname" + //

					" FROM TWDENS a,  TWCLS c " + // //////////////////////

					" WHERE " + //
					" a.DEN = '" + den + "'" + //
					" AND " + //
					" a.OBJECTCLASS=c.OBJECTCLASS";

			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {

					foundDEN = true;

					o.den = rs.getString("DEN");
					o.src = rs.getString("SRC");

					// o.enName = rs.getString("ENNAME");
					// o.enDef = rs.getString("a_endef");
					// o.ds_enDef = rs.getString("b_endef");
					// o.chDef = rs.getString("CHDEF");

					o.objclass = rs.getString("OBJECTCLASS");
					o.propertyTerm = rs.getString("PROPERTYTERM");
					o.representationTerm = rs.getString("REPTERM");
					o.namedComplexType = rs.getString("NAMEDCOMPLEXTYPE");
					o.xmlTagName = rs.getString("XMLTAGNAME");

					o.classid = rs.getString("CLASSID");
					o.classname = rs.getString("CLASSNAME");
					o.cls_chDef = rs.getString("c_chdef");
					o.cls_enDef = rs.getString("c_endef");
					o.cls_chName = rs.getString("c_chname");
					o.cls_enName = rs.getString("c_enname");
				}

				if (!foundDEN) {
					System.out.println("DEN not FOUND !!! >>>>>>\n" + sql);
					// System.out.println("xxx-->>"+densds.objclass);
				}

				// if(o==null)System.out.println(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					rs = null;
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// System.out.println("NAMEDCOMPLEXTYPE=="+o.namedComplexType);
		}

		// -------------------------------------------------------
		// Get TWID data
		{
			boolean found = false;

			if (uid.startsWith("WCOID"))
				uid = uid.substring(5);

			String sql = "SELECT * from TWIDS " + //
					" WHERE " + //
					" TWID = '" + uid + "'" //
					// " AND " + //
			// " a.OBJECTCLASS=c.OBJECTCLASS"//
			;

			// if(uid.endsWith("*")){
			// System.out.println(sql);
			//
			// }

			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {

					found = true;
					o.twid = rs.getString("TWID");
					// o.xmlTagName = rs.getString("XMLTAGNAME");
					// o.uid_src = rs.getString("SRC");
					o.uid_enName = rs.getString("ENNAME");
					o.uid_enDef = rs.getString("ENDEF");
					// o.uid_twuse = rs.getString("TWUSE");
				}

				if (!found) {
					System.out.println("TWID not FOUND !!! >>>>>>\n" + sql);
				}

				// if(o==null)System.out.println(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					rs = null;
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// System.out.println("NAMEDCOMPLEXTYPE=="+o.namedComplexType);
		}

		return o;
	}

	// public TWDENS_DAO getDsResult(String den) {
	// String sql = "SELECT " + //
	// "a.DEN, " + //
	// "a.SRC, " + //
	//
	// "a.TWID, " + //
	//
	// "a.OBJECTCLASS, " + //
	// "a.PROPERTYTERM, " + //
	// "a.REPTERM, " + //
	//
	// "a.XMLTAGNAME, " + //
	//
	// "a.ENDEF a_endef," + //
	// "b.ENDEF b_endef," + //
	//
	// "a.NAMEDCOMPLEXTYPE," + //
	//
	// "b.ENNAME, " + //
	// "b.CHNAME," + //
	// "b.CHDEF," + //
	//
	// "b.PROPLENGTH," + //
	// "b.CODELIST, " + //
	//
	// "c.CLASSID," + //
	// "c.CLASSNAME," + //
	// "c.CHDEF c_chdef," + //
	// "c.ENDEF c_endef," + //
	// "c.CHNAME c_chname," + //
	// "c.ENNAME c_enname" + //
	//
	// " FROM TWDENS a, TWDS b, TWCLS c " + // //////////////////////
	//
	// " WHERE " + //
	// " a.DEN = '" + den + "'" + //
	// " AND " + //
	// " a.TWID=b.TWID" + " AND " + //
	// " a.OBJECTCLASS=c.OBJECTCLASS";
	//
	// TWDENS_DAO o = null;
	// Statement stmt = null;
	// ResultSet rs = null;
	// try {
	// stmt = conn.createStatement();
	// rs = stmt.executeQuery(sql);
	// while (rs.next()) {
	// o = new TWDENS_DAO();
	// o.den = rs.getString("DEN");
	// o.src = rs.getString("SRC");
	//
	// o.twid = rs.getString("TWID");
	// o.enName = rs.getString("ENNAME");
	// o.enDef = rs.getString("a_endef");
	// o.ds_enDef = rs.getString("b_endef");
	// o.chDef = rs.getString("CHDEF");
	//
	// o.objclass = rs.getString("OBJECTCLASS");
	// o.propertyTerm = rs.getString("PROPERTYTERM");
	//
	// o.namedComplexType = rs.getString("NAMEDCOMPLEXTYPE");
	// o.representationTerm = rs.getString("REPTERM");
	//
	// o.xmlTagName = rs.getString("XMLTAGNAME");
	//
	// o.format = rs.getString("FORMAT");
	// o.chName = rs.getString("CHNAME");
	// o.codeList = rs.getString("CODELIST") != null ? rs.getString("CODELIST") : "";
	//
	// o.classid = rs.getString("CLASSID");
	// o.classname = rs.getString("CLASSNAME");
	//
	// o.cls_chDef = rs.getString("c_chdef");
	// o.cls_enDef = rs.getString("c_endef");
	// o.cls_chName = rs.getString("c_chname");
	// o.cls_enName = rs.getString("c_enname");
	//
	// }
	//
	// // if(o==null)System.out.println(sql);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// rs.close();
	// rs = null;
	// stmt.close();
	// stmt = null;
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// // System.out.println("NAMEDCOMPLEXTYPE=="+o.namedComplexType);
	// return o;
	// }

public TWDENS_DAO getDsResult2(String chineseName) {
    chineseName = chineseName.trim();
    
    String sql = "SELECT * FROM TWDS WHERE CHNAME LIKE ?";
    
    TWDENS_DAO o = null;
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, chineseName + "%");
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                o = new TWDENS_DAO();
                o.sn = rs.getString("SN");
                o.format = rs.getString("FORMAT");
                o.chName = rs.getString("CHNAME");
                o.enName = rs.getString("ENNAME");
                o.chDef = rs.getString("CHDEF");
                o.enDef = rs.getString("ENDEF");
                o.codeList = rs.getString("CODELIST");
                
            } else {
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
     
    return o;
}

public static void testConnection() {
    openConnection();
    try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as cnt FROM TWDS");
        if (rs.next()) {
            // System.out.println("Total records in TWDS: " + rs.getInt("cnt"));
        }
        rs.close();
        stmt.close();
    } catch (SQLException e) {
        System.err.println("Connection test failed: " + e.getMessage());
    }
}

	public TWDENS_DAO getClsResult(String objCls) {
		String sql = "SELECT * " + //
				" FROM TWCLS  " + //
				" WHERE OBJECTCLASS = '" + objCls + "'";

		// System.out.println(sql);

		TWDENS_DAO o = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				o = new TWDENS_DAO();
				// o.twid = rs.getString("CLASSID");
				o.twid = "";

				o.classname = rs.getString("classname");
				o.xmlTagName = rs.getString("classname");

				o.classid = rs.getString("CLASSID");
				o.enDef = rs.getString("ENDEF");
				o.chDef = rs.getString("CHDEF");

				o.chName = rs.getString("CHNAME");
				o.enName = rs.getString("ENNAME");

				o.objclass = rs.getString("OBJECTCLASS");

				// o.xmlTagName= rs.getString("CHDEF");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return o;
	}

	// public ArrayList getIssues() {
	//
	// ArrayList ar = new ArrayList();
	// Issue o = null;
	// Statement stmt = null;
	// ResultSet rs = null;
	//
	// // -------------------------------------------------------
	//
	// String sql = "SELECT *  FROM  ISSUES where remark!='N' order by CreateDate,Issue";
	// try {
	// stmt = conn.createStatement();
	// rs = stmt.executeQuery(sql);
	// while (rs.next()) {
	// o = new Issue();
	// o.seq = rs.getString("SEQ");
	// o.createDate = rs.getString("CreateDate");
	// o.msgs = rs.getString("MSG");
	// o.theIssue = rs.getString("Issue");
	// o.myNote = rs.getString("MyNote");
	// o.answer = rs.getString("Answser");
	// ar.add(o);
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// if (rs != null)
	// rs.close();
	// rs = null;
	// if (stmt != null)
	// stmt.close();
	// stmt = null;
	// } catch (Exception e) {
	// System.out.println(sql);
	// e.printStackTrace();
	// }
	// }
	// // System.out.println("NAMEDCOMPLEXTYPE=="+o.namedComplexType);
	//
	// return ar;
	// }

	public void updateTDLsn(String sn, String name) {
		Statement stmt = null;
		try {
			String sql = "update TWDS set sn='" + sn + "' where chname='" + name + "'";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				stmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void clearCodeList() {
		Statement stmt = null;
		try {
			String sql = "update TWDS set codelist=''";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				stmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	

	public void updateCodeList(String chnname, String code) {
		Statement stmt = null;
		try {
			String sql = "update TWDS set codelist='" + code + "' where chname='" + chnname + "'";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				stmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// public void updateClassData(String classid, String classname, String classchnname, String clsChnDef,
	// String objclass, String chnname) {
	// Statement stmt = null;
	// try {
	// String sql = "update TWCLS set" + //
	// // " ENNAME=" + "'" + classname + "'" + //
	// // "," + //
	// " CHNAME=" + "'" + classchnname + "'" + //
	// "," + //
	// " CHDEF=" + "'" + clsChnDef + "'" + //
	// // "," + //
	// // " classname=" + "'" + classname + "'" + //
	// " where" + //
	// " classid='" + classid + "'" + //
	// " AND " + //
	// " OBJECTCLASS='" + objclass + "'";
	//
	// stmt = conn.createStatement();
	// int n = stmt.executeUpdate(sql);
	// if (n != 1)
	// System.err.println(n + "-->" + sql);
	// else
	// System.out.println(n + "-->" + sql);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// if (stmt != null) {
	// stmt.close();
	// stmt = null;
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// }
	//
	// public void updateDSEnglishDefinition(String chnname, String engdef) {
	// PreparedStatement stmt = null;
	// try {
	// String sql = "update TWDS set" + //
	// // " ENNAME=" + "'" + classname + "'" + //
	// // "," + //
	// // " CHNAME=" + "'" + classchnname + "'" + //
	// // "," + //
	// " ENDEF=" + "?" + //
	// // "," + //
	// // " classname=" + "'" + classname + "'" + //
	// " where" + //
	// // " classid='" + classid + "'" + //
	// // " AND " + //
	// " chname=" + "?";
	//
	// // System.out.println( sql);
	//
	// stmt = conn.prepareStatement(sql);
	//
	// stmt.setString(1, engdef);
	// stmt.setString(2, chnname);
	//
	// int n = stmt.executeUpdate();
	//
	// // stmt = conn.createStatement();
	// // int n = stmt.executeUpdate(sql);
	// if (n != 1)
	// System.err.println(n + "-->" + sql);
	// else {
	// // System.out.println(n + "-->" + sql);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// if (stmt != null) {
	// stmt.close();
	// stmt = null;
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// }

}

