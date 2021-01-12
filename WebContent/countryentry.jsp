<%@page import="com.countryweb.dao.CountryImp"%>
<%@page import="com.countryweb.model.Country"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Country</title>
</head>
<body>
	<%
		String strHidID = "0";
		String strHidStatus = "New";
		CountryImp countryImp = new CountryImp();
		List<Country> country = null;
		
		if(request.getParameter("hidID") != null)
			strHidID = request.getParameter("hidID");
		if(request.getParameter("hidStatus") != null)
			strHidStatus = request.getParameter("hidStatus");
		
		if(strHidStatus.equals("U")){
			country = countryImp.getRecordByID(Integer.parseInt(strHidID));
			strHidStatus = "Update";
		}
	%>
	<form method="get" name="frmCountry" action="/countryweb/country">
		<input type="text" name="txtCCode" value="<%= country.get(0).getCountryCode() %>" required />
		<input type="text" name="txtCSName" value="<%= country.get(0).getCountryShortName() %>" required />
		<input type="text" name="txtCFName" value="<%= country.get(0).getCountryFullName() %>" required />
		<input type="submit" name="butAdd" value="<%= strHidStatus %>" />
		<input type="reset" name="butCancel" value="Cancel" />
		<input type="hidden" name="hidID" value="<%= strHidID %>" />
		<input type="hidden" name="hidStatus" value="<%= strHidStatus %>" />
	</form>
</body>
</html>