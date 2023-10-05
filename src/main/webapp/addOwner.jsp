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
<form action="GetOwnerServlet" method="post">
	Enter owner: <br>
	owner name: <input type="text" name="userEntry" size="10"><br>
		
	Available Items:<br />
			<select name = "allItemsToAdd" multiple size = "6" style="width: 300px;">
				<c:forEach items = "${requestScope.allItems}" var="currentitem">
					<option value = "${currentitem.id}"> ${currentitem.name} | ${currentitem.animal}</option>
				</c:forEach>
			</select>
	<br/>
	<input type="submit" value="Create list and Add Items">
</form>
<form method = "post" action = "NavServlet" >
<input type = "submit" value = "home" name="doThisToItem" class="btn">
</form>

</body>
</html>