package mk.finki.ukim.mk.lab.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "conformation_info", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("clientName", req.getSession().getAttribute("clientName"));
        webContext.setVariable("clientAddress", req.getSession().getAttribute("clientAddress"));
        webContext.setVariable("clientIPAddress", req.getRemoteAddr());
        webContext.setVariable("clientBrowser", req.getHeader("User-Agent"));
        webContext.setVariable("balloonColor", req.getSession().getAttribute("balloonColor"));
        webContext.setVariable("balloonSize", req.getSession().getAttribute("balloonSize"));
        springTemplateEngine.process("confirmationInfo.html", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/");
    }
}