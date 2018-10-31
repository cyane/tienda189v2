package controller;



import validate.ValidacionCadenaSinEspacio;
import validate.ValidacionDNINIECIF;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/valiCliIn")
public class ValidarClientInsertController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        //out.println("TestServlet says hi<br/>");
        RequestDispatcher rd = request.getRequestDispatcher("clientInsert.jsp");

        String clientFirstName = request.getParameter("clientFirstName");

        ValidacionCadenaSinEspacio validacionCadenaSinEspacio = new ValidacionCadenaSinEspacio(clientFirstName);

        if (!validacionCadenaSinEspacio.validar()) {
            request.setAttribute("error", validacionCadenaSinEspacio.getError());
        }

        String dniCliente = request.getParameter("dniCliente");

        ValidacionDNINIECIF validacionDNINIECIF = new ValidacionDNINIECIF(dniCliente);

        if(!validacionDNINIECIF.validar()){
            request.setAttribute("error", validacionDNINIECIF.getError());
        }

        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
