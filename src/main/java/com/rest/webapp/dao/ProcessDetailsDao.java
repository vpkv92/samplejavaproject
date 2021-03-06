package com.rest.webapp.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.sql.DataSource;

import com.rest.webapp.util.DBUtils;

/*
 * Dao class to fetch the data and update the data to the DB
 * 
 */
public class ProcessDetailsDao {

	public void insertProcessStatus(Map<String, String> insertProcessMap) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			DBUtils dbUtils = new DBUtils();
			DataSource ds = dbUtils.getDBConnection();
			conn = ds.getConnection();
			stmt = conn.prepareStatement("insert into process_status(custId,msisdn,cmreqid,cmstatus) values(?,?,?,?)");
			//int custId = insertProcessMap.get("custId").toString());
			stmt.setString(1, insertProcessMap.get("custId").toString());
			stmt.setString(2, insertProcessMap.get("msisdn").toString());
			stmt.setString(3, insertProcessMap.get("cmreqid")==null?null: insertProcessMap.get("cmreqid").toString());
			stmt.setString(4, insertProcessMap.get("cmstatus").toString());
			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");

		} catch (NamingException ex) {
			throw new RuntimeException(ex);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {

			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}

		}
	}

	public List<Map<String, String>> FetchProcessStatus() throws SQLException {

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		Map<String, String> processStatMap = null;
		List<Map<String, String>> processTaskList = new ArrayList<Map<String, String>>();
		try {
			DBUtils dbUtils = new DBUtils();
			DataSource ds = dbUtils.getDBConnection();
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select custId,msisdn,cmreqid,cmstatus from process_status");
			
			while(rs.next())
			{	
				processStatMap = new HashMap<String, String>();
				processStatMap.put("custId", rs.getString("custId"));
				processStatMap.put("msisdn", rs.getString("msisdn"));
				processStatMap.put("cmreqid", rs.getString("cmreqid"));
				processStatMap.put("cmstatus", rs.getString("cmstatus"));
				processTaskList.add(processStatMap);
			}

		} catch (NamingException ex) {
			throw new RuntimeException(ex);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}

		}

		return processTaskList;
	}

	
	
	public boolean verifyMsisdn(String msisdn) throws SQLException {
		System.out.println("verifyMsisdn Start-->");
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			DBUtils dbUtils = new DBUtils();
			DataSource ds = dbUtils.getDBConnection();
			conn = ds.getConnection();
			stmt = conn.prepareStatement("select count(msisdn) from msisdn where msisdn = ? and status='ASSIGNED' union"
										+ " select count(msisdn) from process_status where msisdn = ? and cmstatus='Process Started in Camunda'");
			stmt.setString(1, msisdn);
			stmt.setString(2, msisdn);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1) + "is the status");
				if(rs.getInt(1)>0) {
					return true;
				}
			}

		} catch (NamingException ex) {
			throw new RuntimeException(ex);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}

		}

		return false;
	}

	/*
	 * public void UpdateProcessStatus() { try {
	 * 
	 * DBUtils dbUtils = new DBUtils(); DataSource ds = dbUtils.getDBConnection();
	 * Connection conn = ds.getConnection();
	 * 
	 * 
	 * } catch (NamingException ex) { System.err.println(ex); } catch (SQLException
	 * ex) { System.err.println(ex); } }
	 */

}
