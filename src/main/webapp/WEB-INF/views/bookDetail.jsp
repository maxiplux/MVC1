<%@ taglib
		prefix="c" uri="http://java.sun.com/jsp/jstl/core"

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Add a Car</title>

</head>
<body>

<c:choose>
	<c:when test="${book.id > 0}">
		<form action="../books/${book.id}" method="post">
		<br />
	</c:when>
	<c:otherwise>
	<form action="../books/" method="post">
		<br />
	</c:otherwise>
</c:choose>




	<table>
		<tr>
			<td>title:</td>
			<td><input type="text" name="title" value="${book.title}" /> </td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><input type="text" name="ISBN" value="${car.ISBN}" /> </td>
		</tr>

		<tr>
			<td>author:</td>
			<td><input type="text" name="author" value="${car.author}" /> </td>
		</tr>

		<tr>
			<td>price:</td>
			<td><input type="text" name="price" value="${car.price}" /> </td>
		</tr>

	</table>


		<c:choose>
			<c:when test="${book.id > 0}">
				<input type="submit" value="update"/>
				<br />
			</c:when>
			<c:otherwise>
				<input type="submit" value="new"/>
				<br />
			</c:otherwise>
		</c:choose>

	</form>


	<c:if test = "${book.id > 0}">
		<form action="delete?carId=${book.id}" method="post">
			<button type="submit">Delete</button>
		</form>
	</c:if>

</body>
</html>