package prueba;

/**
 * Created by Luciano on 06/11/2017.
 */

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class TestServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performTask(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        performTask(request, response); //vete a get
    }

    private void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("TestServlet says hi<br/>");

        String action = request.getParameter("action");

        if (action != null) {
            RequestDispatcher rd = request.getRequestDispatcher("prueba.jsp");
            if ("include".equalsIgnoreCase(action)) {
                request.setAttribute("error", "Usuario y password no pueden ir vacíos");
                rd.include(request, response);
            } else if ("forward".equalsIgnoreCase(action)) {
                request.setAttribute("error", "Usuario y password no pueden ir vacíos");
                rd.forward(request, response);
            }
        }

    }

}