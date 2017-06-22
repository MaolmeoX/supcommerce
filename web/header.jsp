<header>
    <ul>
        <li>
            <a href="<%= request.getContextPath()+"/listProduct.jsp" %>">List Product</a>
        </li>
        <%
            String sessionParam = (String) request.getSession().getAttribute("User");
            if (sessionParam != null) {
        %>
        <li>
            <a href="<%= request.getContextPath()+"/auth/addProduct.jsp" %>">Add Product</a>
        </li>

        <li>
            <a href="<%= request.getContextPath()+"/auth/addCategory" %>">Add Category</a>
        </li>
        <li>
            <a href="<%= request.getContextPath()+"/logout" %>">Logout</a>
        </li>
        <%} else {%>
        <li>
            <a href="<%= request.getContextPath()+"/login.jsp" %>">Login</a>
        </li>
        <% } %>
    </ul>
</header>