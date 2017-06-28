<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Sup Commerce</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}"/>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href=""><img src="" alt=""></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="<%= request.getContextPath()+"/auth/listProduct" %>">List Product</a></li>
                <%
                    String sessionParam = (String) request.getSession().getAttribute("User");
                    if (sessionParam != null) {
                %>
                <li class="<c:if test = "${fn:contains(uri, 'addProduct')}">active</c:if>"><a href="<%= request.getContextPath()+"/auth/addProduct" %>">Add Product</a></li>
                <li><a href="<%= request.getContextPath()+"/auth/addCategory" %>">Add Category</a></li>

                <% } %>
                <%--<li class="dropdown {{ 'rendezvous' in app.request.attributes.get('_route') ? 'active' }}">--%>
                <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"--%>
                <%--aria-expanded="false">Rendez-vous <span class="caret"></span></a>--%>
                <%--<ul class="dropdown-menu">--%>
                <%--<li><a href="{{ path('rendezvous_index') }}">Index</a></li>--%>
                <%--<li><a href="{{ path('rendezvous_new') }}">New</a></li>--%>
                <%--</ul>--%>
                <%--</li>--%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <% if (sessionParam != null) {%>
                <li><a href="<%= request.getContextPath()+"/logout" %>">Logout</a></li>
                <%} else {%>
                <li><a href="<%= request.getContextPath()+"/login.jsp" %>">Login</a></li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>
<div class="container">