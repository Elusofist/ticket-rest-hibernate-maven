package servlet.action;

import orm.hibernate.facade.TicketFacade;
import orm.hibernate.repository.adaptor.TicketDtoAdaptor;
import orm.hibernate.repository.entity.Ticket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static orm.hibernate.repository.dto.TicketDto.TicketDtoBuilder.aTicketDto;
import static orm.hibernate.repository.entity.Ticket.TicketBuilder.aTicket;

public class FinalBuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Ticket ticket = TicketFacade.getInstance().buy(aTicketDto()
                .withOwner(request.getParameter("name"))
                .withFlightNo(Integer.parseInt(request.getParameter("flightNo")))
                .build());
        HttpSession session = request.getSession();
        session.setAttribute("ticket", ticket);
        writer.println("Ticket Bought Successfully: " + ticket.getTicketID());
    }
}