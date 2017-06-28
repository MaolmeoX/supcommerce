<%@ page import="fr.imie.supcommerce.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: MaolmeoX
  Date: 16/05/2017
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter produit</title>
</head>
<body>
<%--<% if (product) {

}%>--%>
<form action="addProduct.jsp" method="post">
    <input type="text" placeholder="Saisir nom produit" name="nameProduct">
    <input type="text" placeholder="Saisir description produit" name="descriptionProduct">
    <input type="number" placeholder="Saisir prix produit" name="priceProduct">
    <input type="submit">
</form>
</body>
</html>
