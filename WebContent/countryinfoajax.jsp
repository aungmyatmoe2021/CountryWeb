<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Country Info</title>
<script type="text/javascript" src="http://localhost:8181/countryweb/js/country.js"></script>
</head>
<body onload="initialize();">
	<FORM name='frm'>
		<TABLE>
			<!-- 
				<TR>
					<TD>COUNTRY ID</TD>
					<TD><INPUT id="txtCountryID" name="txtCountryID" type="text" /></TD>
				</TR>
			 -->
			<TR>
				<TD>COUNTRY Code</TD>
				<TD><INPUT id="txtCountryCode" name="txtCountryCode" type="text" /></TD>
			</TR>
			<TR>
				<TD>SHORT NAME</TD>
				<TD><INPUT id="txtShortName" name="txtShortName" type="text" /></TD>
			</TR>
			<TR>
				<TD>FULL NAME</TD>
				<TD><INPUT id="txtFullName" name="txtFullName" type="text" /></TD>
			</TR>
			<TR>
				<TD colspan="2">
					<INPUT id="butSave" name="butSave" type="button" value="Save" onclick="return saveAction();" />
					<INPUT name="butCancel" type="button" value="Cancel" onclick="clearAction();" />
				</TD>
			</TR>
		</TABLE>
		<HR />
		<table id="tblObject">
			<tr>
				<th>SR NO</th>
				<!-- <th>COUNTRY ID</th> -->
				<th>COUNTRY CODE</th>
				<th>SHORT NAME</th>
				<th>FULL NAME</th>
				<th>ACTIONS</th>
			</tr>
		</table>
	</FORM>
</body>
</html>