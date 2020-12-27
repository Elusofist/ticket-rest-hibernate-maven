package servlet.action;


import orm.hibernate.business.exception.BusinessException;
import orm.hibernate.facade.TicketFacade;
import orm.hibernate.repository.entity.Ticket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CancelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        if (session != null) {
            try {
                TicketFacade.getInstance()
                        .cancel((Ticket) session.getAttribute("ticket"));
            } catch (BusinessException e) {
                writer.println(e.getMessage() + "<br>");
                request.getRequestDispatcher("buy").include(request, response);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            session.removeAttribute("ticket");
        }
    }
}
