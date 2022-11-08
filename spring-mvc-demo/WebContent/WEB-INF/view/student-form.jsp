<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form Page</title>
</head>
<body>

	<form:form action="processForm" method="GET" modelAttribute="student">
	First Name: <form:input path="firstName" />
	<br><br>
	Last Name: <form:input path="lastName" />
	<br><br>
	Country: <form:select path="country">
				<form:option value="India">India</form:option>
				<form:option value="Brazil">Brazil</form:option>
				<form:option value="Russia">Russia</form:option>
				<form:option value="U.S.">U.S.</form:option>
			</form:select>
			
			
	<br><br>
	Favorite Language:<br> 
	Java<form:radiobutton path="favLang" value="Java"/>
	PHP<form:radiobutton path="favLang" value="PHP"/>
	C#<form:radiobutton path="favLang" value="C#"/>
	Python<form:radiobutton path="favLang" value="Python"/>
	<br><br>
	Operating Systems: 
	<br><br>
	Linux<form:checkbox path="operationSystems" value="Linux"/>
	Windows<form:checkbox path="operationSystems" value="Windows"/>
	Mac<form:checkbox path="operationSystems" value="Mac"/>
	<br><br>
	
	<input type="submit"/> 
	</form:form>


</body>
</html>