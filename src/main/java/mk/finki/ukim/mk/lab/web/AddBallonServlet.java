
package mk.finki.ukim.mk.lab.web;


import mk.finki.ukim.mk.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "balloon_add", urlPatterns = "/add")
public class AddBallonServlet extends HttpServlet {
    private final BalloonService balloonService;
    private final SpringTemplateEngine springTemplateEngine;

    public AddBallonServlet(BalloonService balloonService, SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.springTemplateEngine = springTemplateEngine;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("balloons", balloonService.listAll());
        springTemplateEngine.process("listBalloons.html", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String balloonName = req.getParameter("balloonName");
        String balloonDesc = req.getParameter("balloonDesc");

        balloonService.saveBalloon(balloonName, balloonDesc);
        System.out.println(balloonService.listAll());
        resp.sendRedirect("/");


    }
}
