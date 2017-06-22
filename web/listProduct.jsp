<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.IOException"%>
<%@ page import="javax.servlet.annotation.WebServlet"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="fr.imie.supcommerce.dao.ProductDao"%>
<%@ page import="fr.imie.supcommerce.entity.Product"%>
<%@ page import="java.util.List" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="header.jsp"></jsp:include>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>List Product</title>
		</head>
		<body>
        <%
            List<Product> pList = ProductDao.getAllProducts();
            request.setAttribute("products", pList);
        %>
		<%--<jsp:useBean id="product" class="fr.imie.supcommerce.entity.Product" scope="session" />--%>

		<table>
			<c:forEach items="${products}" var="p">
				<tr>
					<td><c:out value="${p.id}" /></td>
					<td><c:out value="${p.name}" /></td>
					<td><c:out value="${p.description}" /></td>
					<td><c:out value="${p.price}" /></td>
                    <td>
                        <form action="auth/removeProduct" method="post">
                            <input type="submit" value="Delete">
                            <input type="hidden" name="remove" value="<c:out value="${p.id}" />">
                        </form>
                    </td>
				</tr>
			</c:forEach>
		</table>

			<%--<%--%>
				<%--for(Product p : ProductDao.getAllProducts()) {--%>
					<%--out.println("<p>" + p.toString() + "</p>");--%>
			<%--%>--%>
			<%--<form action="auth/removeProduct" method="post">--%>
				 <%--<input type="submit" value="Delete">--%>
				 <%--<input type="hidden" name="remove" value="<%= p.getId() %>">--%>
			<%--</form>--%>
			<%--<% } %>--%>
		</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>