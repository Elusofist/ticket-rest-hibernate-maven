package servlet.validation.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "FlightNoFilter")
public class FlightNoFilter extends Filter implements javax.servlet.Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        String flightNoStr = req.getParameter("flightNo");
        if (flightNoStr != null && getValidator().isValid(Integer.parseInt(flightNoStr))) {
            chain.doFilter(req, resp);
        } else {
            resp.getWriter().println("Invalid Flight No. " + flightNoStr);
            req.getRequestDispatcher("buy.html").include(req, resp);

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
