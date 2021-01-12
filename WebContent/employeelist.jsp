<%@page import="java.lang.reflect.Array"%>
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
	<form name="frmEmplyee" method="post">
		<div>
			<select name="keyFilter" onchange="">
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
			Integer index=0,previousIndex = 0;
			double pgIndex=0;
			if(request.getParameter("keyFilter") != null){
				keyFilter = request.getParameter("keyFilter");
			}
			if(request.getParameter("txtKeyValue") != null){
				keyValue = request.getParameter("txtKeyValue");
			}
			
			EmployeeImp employeeImp = new EmployeeImp(); 
			int recordCount = employeeImp.totalRecords(keyFilter, keyValue,0,0);
			
			
		%>
		<div>
			<label>Total Records : <%= recordCount %></label>
			<%

			pgIndex = recordCount / 20.0;
			index = request.getParameter("hidIndex") == null ? 0 : Integer.parseInt(request.getParameter("hidIndex"));
			previousIndex = request.getParameter("hidPreviousIndex") == null ? 0 : Integer.parseInt(request.getParameter("hidPreviousIndex"));
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
				EmployeeImp employeeImp2 = new EmployeeImp(); 
				List<Employee> records2 = new ArrayList<Employee>();
				if(request.getParameter("butPrevious") != null){
					records2 = employeeImp2.advancedSearch(keyFilter, keyValue,(previousIndex * 20), 20);
				}else if(request.getParameter("butLast") != null){
					records2 = employeeImp2.advancedSearch(keyFilter, keyValue,(recordCount - 20), 20);
				}else if(request.getParameter("butFirst") != null){
					records2 = employeeImp2.advancedSearch(keyFilter, keyValue,0, 20);
				}else{
					records2 = employeeImp2.advancedSearch(keyFilter, keyValue,(index * 20), 20);
				}
			
				for(int i=0;i<records2.size();i++){ 
					Employee emp = records2.get(i);
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
		<div>
			<%-- <% 
				if(request.getParameter("butPrevious") != null){
			%>
				<input type="submit" name="butPrevious" value="&lt;"  />
				<input type="hidden" name="hidPreviousIndex" value="<%= index-1 %>"/>
			<%
				}
			%> --%>
		
			<% 
				if(index < pgIndex-1 && request.getParameter("butLast") == null){
			%>
				<input type="submit" name="butNext" value="&gt;"  />
				<input type="submit" name="butLast" value="&gt;&gt;"  />
				<input type="hidden" name="hidIndex" value="<%= index+1 %>"/>
			<%
				}
			%>
			
			<% 
				if(request.getParameter("butLast") != null){
			%>
				<!-- <input type="submit" name="butNext" value="&gt;"  /> -->
				<input type="submit" name="butFirst" value="&lt;&lt;"  />
				<input type="hidden" name="hidIndex" value="<%= index+1 %>"/>
			<%
				}
			%>
		</div>
	</form>
</body>
</html>