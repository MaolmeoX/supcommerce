package fr.imie.supcommerce.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by MaolmeoX on 15/05/2017.
 */
@WebFilter(filterName = "AuthenticateFilter", servletNames = "basicInsert")
public class AuthenticateFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        if (null == session || null == session.getAttribute("utilisateur")) {
            response.sendRedirect("/login");
        } else if (null != session.getAttribute("utilisateur")) {
            filterChain.doFilter(request, response);
        }
    }
}
