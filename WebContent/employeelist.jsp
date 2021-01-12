<%@page import="java.util.ArrayList"%>
<%@page import="com.countryweb.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.countryweb.dao.EmployeeImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Info List</title>
</head>
<body>
	<form name="frmEmplyee" method="get">
		<div>
			<select name="keyFilter">
				<option selected="selected" value="all">Filter By</option>
				<option value="birth_date">Birth Date</option>
				<option value="first_name">First Name</option>
				<option value="last_name">Last Name</option>
				<option value="gender">Gender</option>
				<option value="hire_date">Hire Date</option>
			</select>
			<input type="text" name="txtKeyValue"/>
			<input type="submit" name="butSearch" value="Search" />
		</div><hr>
		<% 
			String keyFilter = "all" , keyValue="";
			int index=1;
			double pgIndex=0;
			if(request.getParameter("keyFilter") != null){
				keyFilter = request.getParameter("keyFilter");
			}
			if(request.getParameter("txtKeyValue") != null){
				keyValue = request.getParameter("txtKeyValue");
			}
			
			EmployeeImp employeeImp = new EmployeeImp(); 
			List<Employee> records = employeeImp.advancedSearch(keyFilter, keyValue,0);
			
			
		%>
		<div>
			<label>Total Records : <%= records.size() %></label>
			<% 
				pgIndex = records.size() / 20.0;
				System.out.println("Page Index : "+pgIndex);
				if(index < pgIndex){
			%>
				<input type="hidden" name="hidIndex" value="<%= index %>"/>
				<input type="submit" name="butNext" value=">>" onclick="" />
			<%
				}
			%>
		</div><hr>
		<table>
			<tr>
				<th>Employee No</th>
				<th>Birth Date</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Hire Date</th>
			</tr>
			<% 
				for(int i=0;i<records.size();i++){ 
					Employee emp = records.get(i);
			%>
				<tr>
					<td><%= emp.getEmpNo() %></td>
					<td><%= emp.getBirthDate() %></td>
					<td><%= emp.getFirstName() %></td>
					<td><%= emp.getLastName() %></td>
					<td><%= emp.getGender() %></td>
					<td><%= emp.getHireDate() %></td>
				</tr>
			<% } %>
		</table>
	</form>
</body>
</html>