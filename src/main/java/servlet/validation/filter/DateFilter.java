package servlet.validation.filter;

import orm.hibernate.business.exception.BusinessException;
import orm.hibernate.repository.adaptor.TicketDtoAdaptor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static orm.hibernate.repository.dto.TicketDto.TicketDtoBuilder.aTicketDto;


@WebFilter(filterName = "DateFilter")
public class DateFilter extends Filter implements javax.servlet.Filter {

    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        if (getValidator().isValid(TicketDtoAdaptor.getInstance()
                .toTicket(aTicketDto()
                .withOwner(req.getParameter("name"))
                .withFlightNo(Integer.parseInt(req.getParameter("flightNo")))
                .build()).getFlight().getFlightDate())) {
            chain.doFilter(req, resp);
        } else {
            try {
                throw new BusinessException("Invalid Date.");
            } catch (BusinessException e) {
                System.out.println(e.getMessage());
                req.getRequestDispatcher("buy.html").include(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
