<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Confirmation Page</title>
</head>
<body>

The Student is confirmed : ${student.firstName} ${student.lastName} 
<br><br> Country: ${student.country}  
<br><br> Favorite Language: ${student.favLang}

<br><br> Operating Systems : 

<ul>
<c:forEach var="temp" items="${student.operationSystems}">
<li>${temp}</li>
</c:forEach>
</ul>

</body>
</html>