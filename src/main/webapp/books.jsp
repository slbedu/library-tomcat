<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Library</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
</head>
<body>
	<div align="center">
		<h1>Library Application</h1>
	</div>
	<div>
		<table id="books_table" class="table">
			<tr>
				<th>Title</th>
				<th>Author</th>
				<th>ISBN</th>
				<th>Amount</th>
			</tr>
            <c:forEach items="${allBooks}" var="book">
                <tr>
                    <td><c:out value="${book.title}"/></td>
                    <td><c:out value="${book.author}"/></td>
                    <td><c:out value="${book.isbn}"/></td>
                    <td><c:out value="${book.amount}"/></td>
                </tr>
            </c:forEach>
		</table>
	</div>
</body>
</html>