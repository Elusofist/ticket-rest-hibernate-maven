package servlet.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String action = request.getParameter("action");
        switch (action) {
            case "Buy": forwardToBuyServlet(request, response);
            case "Show": forwardToShowServlet(request, response);
            case "Change": forwardToChangeServlet(request, response);
            case "Cancel": forwardToCancelServlet(request, response);
            default: throw new IllegalStateException("Unexpected value: " + action);
        }
    }


    private void forwardToBuyServlet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("buy").forward(request, response);
        } catch (ServletException | IOException e) {
            try {
                response.getWriter().println(e.getMessage());
            } catch (IOException ioException) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void forwardToChangeServlet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("change").forward(request, response);
        } catch (ServletException | IOException e) {
            try {
                response.getWriter().println(e.getMessage());
            } catch (IOException ioException) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void forwardToCancelServlet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("cancel").forward(request, response);
        } catch (ServletException | IOException e) {
            try {
                response.getWriter().println(e.getMessage());
            } catch (IOException ioException) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void forwardToShowServlet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("show").forward(request, response);
        } catch (ServletException | IOException e) {
            try {
                response.getWriter().println(e.getMessage());
            } catch (IOException ioException) {
                System.out.println(e.getMessage());
            }
        }
    }
}