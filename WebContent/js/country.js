/**
 * 
 */
var xmlHttp = null;
var ACTION = 'N';
var UPDATE_ID = 0;
var CURRENT_IDX = 0;
function initialize(){
	try{
		xmlHttp = new XMLHttpRequest();
	}catch (e) {
		// TODO: handle exception
		window.alert("Your browser doesn't support ajax");
	}
	
	xmlHttp.onreadystatechange = function() {
		if(xmlHttp.readyState == 4  && xmlHttp.status == 200){
			viewTable();
		}
	};
	
	// open http connection
	if(xmlHttp) {
		// xmlHttp.open("POST", "http://localhost:8080/helloweb/data.xml");
		// xmlHttpObject.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		xmlHttp.open("GET", "http://localhost:8181/countryweb/countryxml");
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send("");
	}
}

function viewTable(){
	var data = xmlHttp.responseXML;
	var tblObject = document.getElementById("tblObject");
	var rowsLength = tblObject.rows.length;
	var recordsTag = data.getElementsByTagName("country")[0].getElementsByTagName("record");
	
	for(var i=0;i<recordsTag.length;i++){
		var id = recordsTag[i].getElementsByTagName("countryID")[0].firstChild.nodeValue;
		var code = recordsTag[i].getElementsByTagName("countryCode")[0].firstChild.nodeValue;
		var sname = recordsTag[i].getElementsByTagName("countryShortName")[0].firstChild.nodeValue;
		var fname = recordsTag[i].getElementsByTagName("countryFullName")[0].firstChild.nodeValue;
		
		var row = tblObject.insertRow(Number(i+1));
		
		var colSrNo = row.insertCell(0);
		colSrNo.innerHTML = "<td><input type='text' id='celID"+(i+1)+"' value='"+(i+1)+"' readonly /></td>";
		colSrNo.innerHTML += "<td><input type='hidden' id='celID"+(i+1)+"' value='"+id+"' readonly /></td>";
		
//		var colCountryID = row.insertCell(1);
//		colCountryID.innerHTML = "<td><input type='text' id='celID"+(i+1)+"' value='"+id+"' readonly /></td>";
		
		var colCountryCode = row.insertCell(1);
		colCountryCode.innerHTML = "<td><input type='text' id='celCode"+(i+1)+"' value='"+code+"' readonly /></td>";
		
		var colCShortName = row.insertCell(2);
		colCShortName.innerHTML = "<td><input type='text' id='celSName"+(i+1)+"' value='"+sname+"' readonly /></td>";
		
		var colCFullName = row.insertCell(3);
		colCFullName.innerHTML = "<td><input type='text' id='celFName"+(i+1)+"' value='"+fname+"' readonly /></td>";
		
		var colUpdate = row.insertCell(4);
		colUpdate.innerHTML = "<td><input type='button' id='butEdit' value='Edit' onclick='editAction("+(i+1)+");' /></td>";
		colUpdate.innerHTML += "<td><input type='button' id='butDelete' value='Delete' onclick='deleteAction(this);' /></td>";
	}
}

function saveAction(){
	alert(UPDATE_ID+","+ACTION);
	var tblObject = document.getElementById("tblObject");
	var rowsLength = tblObject.rows.length;
	var code = document.getElementById("txtCountryCode").value;
	var sname = document.getElementById("txtShortName").value;
	var fname = document.getElementById("txtFullName").value;
	
	if(ACTION == "N"){
		var queryString = "txtCCode="+code+"&txtCSName="+sname+"&txtCFName="+fname+"&hidID=0&hidStatus=N";
		var row = tblObject.insertRow(Number(rowsLength));
		
		var colSrNo = row.insertCell(0);
		colSrNo.innerHTML = "<td><input type='text' id='celID"+rowsLength+"' value='"+rowsLength+"' readonly /></td>";
		colSrNo.innerHTML += "<td><input type='hidden' id='celID"+rowsLength+"' value='"+UPDATE_ID+"' readonly /></td>";
		
//		var colCountryID = row.insertCell(1);
//		colCountryID.innerHTML = "<td><input type='text' id='celID"+(i+1)+"' value='"+id+"' readonly /></td>";
		
		var colCountryCode = row.insertCell(1);
		colCountryCode.innerHTML = "<td><input type='text' id='celCode"+rowsLength+"' value='"+code+"' readonly /></td>";
		
		var colCShortName = row.insertCell(2);
		colCShortName.innerHTML = "<td><input type='text' id='celSName"+rowsLength+"' value='"+sname+"' readonly /></td>";
		
		var colCFullName = row.insertCell(3);
		colCFullName.innerHTML = "<td><input type='text' id='celFName"+rowsLength+"' value='"+fname+"' readonly /></td>";
		
		var colUpdate = row.insertCell(4);
		colUpdate.innerHTML = "<td><input type='button' id='butEdit' value='Edit' onclick='editAction("+rowsLength+");' /></td>";
		colUpdate.innerHTML += "<td><input type='button' id='butDelete' value='Delete' onclick='' /></td>";
	
		xmlHttp.onreadystatechange = function() {
			if(xmlHttp.readyState == 4  && xmlHttp.status == 200){
			}
		};
		
		// open http connection
		if(xmlHttp) {
			xmlHttp.open("POST", "http://localhost:8181/countryweb/country");
			xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//			xmlHttp.open("GET", "http://localhost:8181/countryweb/countryxml");
//			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(queryString);
		}
	}
	if(ACTION == "U"){
		document.getElementById('celCode'+CURRENT_IDX).value = code ;
		document.getElementById('celSName'+CURRENT_IDX).value = sname;
		document.getElementById('celFName'+CURRENT_IDX).value = fname;
		
		var queryString = "txtCCode="+code+"&txtCSName="+sname+"&txtCFName="+fname+"&hidID="+UPDATE_ID+"&hidStatus=U";
		
		xmlHttp.onreadystatechange = function() {
			if(xmlHttp.readyState == 4  && xmlHttp.status == 200){
			}
		};
		
		// open http connection
		if(xmlHttp) {
			xmlHttp.open("POST", "http://localhost:8181/countryweb/country");
			xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//			xmlHttp.open("GET", "http://localhost:8181/countryweb/countryxml");
//			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(queryString);
		}
//		
		document.getElementById('butSave').value = 'Save';
		ACTION = 'N';
	}
	
	clearAction();
}

function editAction(id){
//	document.getElementById('txtCountryID').value = document.getElementById('celID'+id).value;
	document.getElementById('txtCountryCode').value = document.getElementById('celCode'+id).value;
	document.getElementById('txtShortName').value = document.getElementById('celSName'+id).value;
	document.getElementById('txtFullName').value = document.getElementById('celFName'+id).value;
	ACTION = 'U';
	UPDATE_ID = document.getElementById('celID'+id).value;
	CURRENT_IDX = id;
	document.getElementById('butSave').value = 'Update';
}

function deleteAction(obj){
	var rowIndex = obj.parentNode.parentNode.rowIndex;
	// Delete Record
	UPDATE_ID = document.getElementById('celID'+rowIndex).value;
	var tblObject = document.getElementById("tblObject");
	tblObject.deleteRow(rowIndex);
	
	var queryString = "txtCCode=0&txtCSName=a&txtCFName=a&hidID="+UPDATE_ID+"&hidStatus=D";
	
	xmlHttp.onreadystatechange = function() {
		if(xmlHttp.readyState == 4  && xmlHttp.status == 200){
		}
	};
	
	// open http connection
	if(xmlHttp) {
		xmlHttp.open("POST", "http://localhost:8181/countryweb/country");
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//		xmlHttp.open("GET", "http://localhost:8181/countryweb/countryxml");
//		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(queryString);
	}
}

function clearAction(){
//	frm.txtCountryID.value = "";
	frm.txtCountryCode.focus();
	frm.txtCountryCode.value = "";
	frm.txtShortName.value = "";
	frm.txtFullName.value = "";
	frm.butSave.value = "Save";
}


function deleteCountry(id){
	if(window.confirm("Are you sure delete this record?")){
		frmCountryList.hidID.value=id;
		frmCountryList.hidStatus.value='D';
		
		frmCountryList.method='get';
		frmCountryList.action='/countryweb/country';
		frmCountryList.submit();
		
	}
}