<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Library</title>
    <link rel="stylesheet" type="text/css" href="styles/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="styles/library.css"/>
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
        <jsp:useBean id="allBooks" scope="request" type="java.util.List"/>
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

<div class="login_register">
    <c:choose>
        <c:when test="${empty sessionScope.currentUser}">
            <a href="login" class="login_form">Log in</a>
            <a href="register" class="register_form">Register</a>
        </c:when>
        <c:otherwise>
            <div class="login_form"><c:out value="Hello, ${sessionScope.currentUser}"/></div>
            <a href="logout" class="register_form">Logout</a>
        </c:otherwise>
    </c:choose>
</div>


</body>
</html>