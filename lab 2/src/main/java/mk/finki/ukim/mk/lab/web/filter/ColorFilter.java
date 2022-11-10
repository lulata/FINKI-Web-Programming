package mk.finki.ukim.mk.lab.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter
public class ColorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String balloonColor = (String) request.getSession().getAttribute("balloonColor");

        String path = request.getServletPath();


        if ((balloonColor == null || balloonColor.isEmpty()) && !path.equals("")) {
            if (path.contains("/balloons") || path.contains("/orders") ) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.sendRedirect("/balloons?error=NoColorSelected");
            }

//            response.sendRedirect("/");
        } else {
            filterChain.doFilter(request, response);
        }


    }


}
