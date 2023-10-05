<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
			<table>
				<c:forEach items="${requestScope.allOwners }" var="currentitem">
	                <tr>
	                    <td><input type="radio" name="id" value="${currentitem.id}"></td>
	                    <td><h2>${currentitem.owner}</h2></td>
	                </tr>
	          
	                <c:forEach var="list" items="${currentitem.petClass}">
	                    <tr>
	                        <td></td>
	                        <td colspan="3">
	                            ${list.name}, ${list.animal}
	                        </td>
	                    </tr>
	                </c:forEach>
	            </c:forEach>
			</table>

	<br />
</form>
<form method = "post" action = "NavServlet" >
<input type = "submit" value = "home" name="doThisToItem" class="btn">
</form>
</body>
</html>