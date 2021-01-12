package com.countryweb.dao;

import java.util.List;

public interface CountryDAO<E> {
	public List<E> getAllRecords();
	public List<E> getRecordByID(int ID);
	public boolean insertRecord(E e); 
	public boolean updateRecord(E e);
	public boolean deleteRecord(E e);
}
