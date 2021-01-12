package com.countryweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.countryweb.model.Country;
import com.countryweb.until.DatabaseUtil;

public class CountryImp implements CountryDAO<Country> {

	@Override
	public List<Country> getAllRecords() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<Country> result = new ArrayList<Country>();
		
		try {
			con = DatabaseUtil.getDBConnection();
			stmt = con.createStatement();
			
			rset = stmt.executeQuery("SELECT c.`country_id`, c.`country_code`, c.`country_short_name`, c.`country_full_name` FROM country_tb c");
			
			while(rset.next()) {
				Country record = new Country();
				record.setCountryID(rset.getInt("country_id"));
				record.setCountryCode(rset.getInt("country_code"));
				record.setCountryShortName(rset.getString("country_short_name"));
				record.setCountryFullName(rset.getString("country_full_name"));
				
				result.add(record);
			}
			System.out.println("Count is "+result.size());
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DatabaseUtil.closeSqlResource(con, stmt, rset);
		}
		
		return result;
	}

	@Override
	public List<Country> getRecordByID(int ID) {
		// TODO Auto-generated method stub
				Connection con = null;
				Statement stmt = null;
				ResultSet rset = null;
				List<Country> result = new ArrayList<Country>();
				
				try {
					con = DatabaseUtil.getDBConnection();
					stmt = con.createStatement();
					
					rset = stmt.executeQuery("SELECT c.`country_id`, c.`country_code`, c.`country_short_name`, c.`country_full_name` FROM country_tb c where c.`country_id`='"+ID+"'");
					
					while(rset.next()) {
						Country record = new Country();
						record.setCountryID(rset.getInt("country_id"));
						record.setCountryCode(rset.getInt("country_code"));
						record.setCountryShortName(rset.getString("country_short_name"));
						record.setCountryFullName(rset.getString("country_full_name"));
						
						result.add(record);
					}
					System.out.println("Count is "+result.size());
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					DatabaseUtil.closeSqlResource(con, stmt, rset);
				}
				
				return result;
	}

	@Override
	public boolean insertRecord(Country country) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		boolean flag = false;
		
		try {
			con = DatabaseUtil.getDBConnection();
			pstm = con.prepareStatement("Insert into country_tb(`country_code`,`country_short_name`, `country_full_name`) values(?,?,?)");
			
			pstm.setInt(1, country.getCountryCode());
			pstm.setString(2, country.getCountryShortName());
			pstm.setString(3, country.getCountryFullName());
			
			int rowSet = pstm.executeUpdate();
			
			flag = (rowSet == 1);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DatabaseUtil.closeSqlResource(con, pstm, rset);
		}
		
		return flag;
	}

	@Override
	public boolean updateRecord(Country country) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		boolean flag = false;
		
		try {
			con = DatabaseUtil.getDBConnection();
			pstm = con.prepareStatement("update country_tb set `country_code`=?,`country_short_name`=?, `country_full_name`=? where `country_id`=?");
			
			pstm.setInt(1, country.getCountryCode());
			pstm.setString(2, country.getCountryShortName());
			pstm.setString(3, country.getCountryFullName());
			pstm.setInt(4, country.getCountryID());
			
			int rowSet = pstm.executeUpdate();
			
			flag = (rowSet == 1);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DatabaseUtil.closeSqlResource(con, pstm, rset);
		}
		
		return flag;
	}

	@Override
	public boolean deleteRecord(Country country) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		boolean flag = false;
		
		try {
			con = DatabaseUtil.getDBConnection();
			pstm = con.prepareStatement("delete from country_tb where `country_id`=?");
			
			pstm.setInt(1, country.getCountryID());
			
			int rowSet = pstm.executeUpdate();
			
			flag = (rowSet == 1);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DatabaseUtil.closeSqlResource(con, pstm, rset);
		}
		
		return flag;
	}
	
}
