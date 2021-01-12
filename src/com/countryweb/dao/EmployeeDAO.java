package com.countryweb.dao;

import java.util.List;

public interface EmployeeDAO<E> {
	public List<E> getAllRecords();
	public E getRecordByID(int ID);
	public boolean insertRecord(E e); 
	public boolean updateRecord(E e);
	public boolean deleteRecord(E e);
	public int totalRecords(String keyFilter, String keyValue, int startPageIndex, int endPageIndex);
	public List<E> advancedSearch(String keyFilter, String keyValue, int startPageIndex, int endPageIndex);
}
