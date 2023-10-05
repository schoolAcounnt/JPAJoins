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
	<form action="GetInfoServlet" method="post">
		Enter pet: <br>
		animal: <input type="text" name="userEntryOne" size="10"><br>
		name: <input type="text" name="userEntryTwo" size="10">
		<input type="submit" value="input" />
		<br>
		
		
	</form>
	<button type="button" class="btn" onclick="location.href='ShowAll';">View all pets</button>
<a href = "ShowAll"></a>
<form method = "post" action = "NavServlet" >
	<table class="table table-striped table-hover">
		<c:forEach items="${requestScope.allItems}" var="currentitem">
			<tr>
				   <td><input type="radio" name="id" value="${currentitem.id}" ></td>
				   <td>${currentitem.name}</td>
				   <td>${currentitem.animal}</td>
			</tr>
		</c:forEach>
	</table>
<br />
<input type = "submit" value = "edit" name="doThisToItem" class="btn">
<input type = "submit" value = "delete" name="doThisToItem" class="btn">
<input type = "submit" value = "addOwner" name="doThisToItem" class="btn">
</form>
<form method = "post" action = "NavServlet" >
	<input type = "submit" value = "view all owners" name="doThisToItem" class="btn">
</form>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>