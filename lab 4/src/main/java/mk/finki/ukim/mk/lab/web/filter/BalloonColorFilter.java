package mk.finki.ukim.mk.lab.web.filter;

import mk.finki.ukim.mk.lab.model.User;
import org.springframework.context.annotation.Profile;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
@Profile("servlet")
public class BalloonColorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        String path = request.getServletPath();


        String balloonColor = (String) request.getSession().getAttribute("balloonColor");


        if (balloonColor != null || path.contains("/balloons") || path.contains("/list") || path.contains("/orders"))
            filterChain.doFilter(servletRequest, servletResponse);
        else
            response.sendRedirect("/balloons?error=NoColorSelected");
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
