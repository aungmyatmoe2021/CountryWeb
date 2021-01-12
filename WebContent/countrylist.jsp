<%@page import="com.countryweb.model.Country"%>
<%@page import="java.util.List"%>
<%@page import="com.countryweb.dao.CountryImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="http://localhost:8181/countryweb/js/country.js"></script>
<title>Country List</title>
</head>
<body>
	<%
		String strID = "";
		String strStatus = "";
		CountryImp cImp = new CountryImp();
		List<Country> results = cImp.getAllRecords();
	%>
	<div>Total Records : <%= results.size() %></div>
	<div>
		<input type="button" name="butAdd" value="Add" onclick="location.href='/countryweb/countryentry.jsp'" />
	</div>
	<form name="frmCountryList" method="get">
		<table>
			<tr>
				<th>Country ID</th>
				<th>Country Code</th>
				<th>Short Name</th>
				<th>Full Name</th>
				<th colspan="2">Actions</th>
			</tr>
			<% for(int i=0;i<results.size();i++){ 
					Country country= results.get(i);
			%>
			<tr>
				<td><%= country.getCountryID()%></td>
				<td><%= country.getCountryCode() %></td>
				<td><%= country.getCountryShortName() %></td>
				<td><%= country.getCountryFullName() %></td>
				<td colspan="2">
					<input type="button" name="butUpdate" value="Update" onclick="location.href='/countryweb/countryentry.jsp?hidID=<%= country.getCountryID()%>&hidStatus=U'" />
					<input type="button" name="butDelete" value="Delete" onclick="deleteCountry(<%= country.getCountryID() %>)" />
				</td>
			</tr>
			<% } %>
			<input type="hidden" name="hidID" value="" />
			<input type="hidden" name="hidStatus" value="" />
		</table>
	</form>
</body>
</html>