package com.example.demo.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.demo.XmaDB;

/*
 * 已無用
 */
public class AddDefinitionDot {
	ArrayList ar = new ArrayList();

	public ArrayList getDS() {

		String sql = "SELECT * from TWDS";

		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = XmaDB.conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				X x = new X();
				x.key = rs.getString("CHNAME");
				x.def = rs.getString("ENDEF");
				ar.add(x);
			}
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
		return ar;
	}

	public ArrayList getDENs() {

		String sql = "SELECT * from TWDENS";

		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = XmaDB.conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				X x = new X();
				x.key = rs.getString("DEN");
				x.src = rs.getString("SRC");
				x.def = rs.getString("ENDEF");
				ar.add(x);
			}
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
		return ar;
	}

	public ArrayList getTWIDs() {

		String sql = "SELECT * from TWIDS";

		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = XmaDB.conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				X x = new X();
				x.key = rs.getString("TWID");
				x.src = rs.getString("SRC");
				x.def = rs.getString("ENDEF");
				ar.add(x);
			}
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
		return ar;
	}

	public ArrayList getTWCLS() {

		String sql = "SELECT * from TWCLS";

		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = XmaDB.conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				X x = new X();
				x.key = rs.getString("OBJECTCLASS");
				// x.src = rs.getString("SRC");
				x.def = rs.getString("ENDEF");
				ar.add(x);
			}
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
		return ar;
	}

	public void updateDENsDef(X x) {
		PreparedStatement stmt = null;
		// Statement stmt = null;
		try {
			String sql = "update TWDENS set ENDEF=? where DEN=?";
			// stmt = XmaDB.conn.createStatement();
			// stmt.executeUpdate(sql);

			stmt = XmaDB.conn.prepareStatement(sql);

			stmt.setString(1, x.def);
			stmt.setString(2, x.key);

			stmt.executeUpdate();
			stmt.clearParameters();

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

	public void updateTWIDsDef(X x) {
		PreparedStatement stmt = null;
		// Statement stmt = null;
		try {
			String sql = "update TWIDS set ENDEF=? where TWID=?";
			// stmt = XmaDB.conn.createStatement();
			// stmt.executeUpdate(sql);

			stmt = XmaDB.conn.prepareStatement(sql);

			stmt.setString(1, x.def);
			stmt.setString(2, x.key);

			stmt.executeUpdate();
			stmt.clearParameters();

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

	public void updateTWCLS(X x) {
		PreparedStatement stmt = null;
		// Statement stmt = null;
		try {
			String sql = "update TWCLS set ENDEF=? where OBJECTCLASS=?";
			// stmt = XmaDB.conn.createStatement();
			// stmt.executeUpdate(sql);

			stmt = XmaDB.conn.prepareStatement(sql);

			stmt.setString(1, x.def);
			stmt.setString(2, x.key);

			stmt.executeUpdate();
			stmt.clearParameters();

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

	class X {
		public String key = "";
		public String src = "";
		public String def = "";
	}

	public static void main(String[] args) {
		XmaDB db = new XmaDB();
		db.openConnection();

		AddDefinitionDot o = new AddDefinitionDot();

		// ArrayList ar = o.getDS();
		// ArrayList ar = o.getDENs();
		// ArrayList ar = o.getTWIDs();
		ArrayList ar = o.getTWCLS();

		for (int i = 0; i < ar.size(); i++) {
			X x = (X) ar.get(i);
			String s = x.def;
			if (s == null)
				continue;

			s = s.trim();

			if (!s.endsWith(".")) {// no dot
				System.err.println(x.key + "(" + x.src + ")" + "-->" + s);

				x.def = x.def + ".";
				o.updateTWCLS(x);

			} else {// has dot
				if (s.endsWith("No.") //
						|| s.endsWith("c.c.") //
						|| s.endsWith("etc.")) {

					System.out.println(x.key + "(" + x.src + ")" + "-->" + s);

				} else {
					System.out.println(x.key + "(" + x.src + ")" + "-->" + s);

				}
			}
		}

		System.out.println("done!\n");

		db.closeConnection();

	}
}
