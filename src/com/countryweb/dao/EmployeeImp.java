package com.countryweb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.countryweb.model.Employee;
import com.countryweb.until.DatabaseUtil;

public class EmployeeImp implements EmployeeDAO<Employee> {

	@Override
	public List<Employee> getAllRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getRecordByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertRecord(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRecord(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRecord(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int totalRecords(String keyFilter, String keyValue, int startPageIndex, int endPageIndex) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String selectQuery = "select count(*) as count from employees ";
		int recordCount = 0;
		
		try {
			con = DatabaseUtil.getDBConnection();
			stmt = con.createStatement();
			if(keyFilter.equals("first_name") || keyFilter.equals("last_name")) {
				selectQuery += "where `first_name` like '%"+keyValue+"%' or `last_name` like '%"+keyValue+"%'";
			}
			if(keyFilter.equals("gender")) {
				selectQuery += "where `gender`='"+keyValue+"'";
			}
			if(keyFilter.equals("birth_date")) {
				selectQuery += "where year(`birth_date`) = YEAR('"+keyValue+"-01-01')";
			}
			if(keyFilter.equals("hire_date")) {
				selectQuery += "where year(`hire_date`) = YEAR('"+keyValue+"-01-01')";
			}
			if(keyFilter.equals("all")) {
				selectQuery += "";
			}
			if(startPageIndex == 0 && endPageIndex == 0) {
				rset = stmt.executeQuery(selectQuery);
			}
			
			while(rset.next()) {
				recordCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeSqlResource(con, stmt, rset);
		}
		return recordCount;
	}

	@Override
	public List<Employee> advancedSearch(String keyFilter, String keyValue,  int startPageIndex, int endPageIndex) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String selectQuery = "Select `emp_no`,`birth_date`,`first_name`,`last_name`,`gender`,`hire_date` from employees ";
		List<Employee> records = new ArrayList<Employee>();
		
		try {
			con = DatabaseUtil.getDBConnection();
			stmt = con.createStatement();
			if(keyFilter.equals("first_name") || keyFilter.equals("last_name")) {
				selectQuery += "where `first_name` like '%"+keyValue+"%' or `last_name` like '%"+keyValue+"%'";
			}
			if(keyFilter.equals("gender")) {
				selectQuery += "where `gender`='"+keyValue+"'";
			}
			if(keyFilter.equals("birth_date")) {
				selectQuery += "where year(`birth_date`) = YEAR('"+keyValue+"-01-01')";
			}
			if(keyFilter.equals("hire_date")) {
				selectQuery += "where year(`hire_date`) = YEAR('"+keyValue+"-01-01')";
			}
			if(keyFilter.equals("all")) {
				selectQuery += "";
			}
			if(startPageIndex == 0 && endPageIndex == 0) {
				rset = stmt.executeQuery(selectQuery + " limit 50");
			}else {
				rset = stmt.executeQuery(selectQuery + " limit "+startPageIndex+","+endPageIndex);
			}
			
			System.out.println(selectQuery + " limit "+startPageIndex+","+endPageIndex);
			
			while(rset.next()) {
				Employee e = new Employee();
				e.setEmpNo(rset.getInt("emp_no"));
				e.setBirthDate(rset.getString("birth_date"));
				e.setFirstName(rset.getString("first_name"));
				e.setLastName(rset.getString("last_name"));
				e.setGender(rset.getString("gender").charAt(0));
				e.setHireDate(rset.getString("hire_date"));
				records.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeSqlResource(con, stmt, rset);
		}
		return records;
	}

}
