<%--
  Created by IntelliJ IDEA.
  User: MaolmeoX
  Date: 22/06/2017
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add category</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<form action="/auth/addCategory" method="post">
    <input type="text" placeholder="Saisir nom category" name="nameCategory">
    <input type="submit">
</form>
</body>
</html>
