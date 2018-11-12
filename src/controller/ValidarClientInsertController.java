package controller;

import dao.clienteDAO.ClienteDAO;
import dao.clienteDAO.ClienteRoll;
import dao.cp.CPDAO;
import entity.ClientEntity;
import validate.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/valiCliIn")
@MultipartConfig
public class ValidarClientInsertController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    HttpSession session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();

        ClientEntity cliente = new ClientEntity();

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html");

        String error = "";

        List<IValidacion> validador = new ArrayList<IValidacion>();

        RequestDispatcher rd = request.getRequestDispatcher("clientInsert.jsp");


        cliente.setNifCliente(request.getParameter("dniCliente"));
        session.setAttribute("dniCliente", cliente.getNifCliente());
        validador.add(new ValidacionDNINIECIF(cliente.getNifCliente()));
        error +=  ValidacionMultiValidation.validar(validador);

        if(!(error.length() > 0)){
            validador.clear();
            cliente.setNombreCliente(request.getParameter("clientFirstName"));
            session.setAttribute("clientFirstName", cliente.getNombreCliente());
            validador.add(new ValidacionLetrasConEspacio(cliente.getNombreCliente()));
            validador.add(new ValidacionLongitud(cliente.getNombreCliente(),3,50));
            error +=  ValidacionMultiValidation.validar(validador);

            if(!(error.length() > 0)){
                validador.clear();
                cliente.setApellidosCliente(request.getParameter("clientLastName"));
                session.setAttribute("clientLastName", cliente.getApellidosCliente());
                validador.add(new ValidacionLetrasConEspacio(cliente.getApellidosCliente()));
                validador.add(new ValidacionLongitud(cliente.getApellidosCliente(),3,100));
                error +=  ValidacionMultiValidation.validar(validador);
                if(!(error.length() > 0)){
                    validador.clear();
                    cliente.setCodigoPostalClient(request.getParameter("clientCP"));
                    session.setAttribute("clientCP", cliente.getCodigoPostalClient());
                    validador.add(new ValidacionCodigoPostal(cliente.getCodigoPostalClient()));
                    error +=  ValidacionMultiValidation.validar(validador);
                    if(!(error.length() > 0)){
                        validador.clear();
                        cliente.setDomicilioCliente(request.getParameter("DomicilioCliente"));
                        session.setAttribute("DomicilioCliente", cliente.getDomicilioCliente());
                        validador.add(new ValidarDomicilio(cliente.getDomicilioCliente()));
                        validador.add(new ValidacionLongitud(cliente.getDomicilioCliente(),2,100));
                        error +=  ValidacionMultiValidation.validar(validador);
                        if(!(error.length() > 0)){
                            validador.clear();
                            cliente.setTelefonoCliente(request.getParameter("TelefonoFijo"));
                            session.setAttribute("TelefonoFijo",cliente.getTelefonoCliente());
                            validador.add(new ValidacionTelefonoSpain(cliente.getTelefonoCliente()));
                            error +=  ValidacionMultiValidation.validar(validador);
                            if(!(error.length() > 0)){
                                validador.clear();
                                cliente.setMovilCliente(request.getParameter("numeroMovil"));
                                session.setAttribute("numeroMovil",cliente.getMovilCliente());
                                validador.add(new ValidacionTelefonoSpain(cliente.getMovilCliente()));
                                error +=  ValidacionMultiValidation.validar(validador);
                                if(!(error.length() > 0)){
                                    validador.clear();
                                    cliente.setFechaNacimiento(request.getParameter("FechaNacimiento"));
                                    session.setAttribute("FechaNacimiento",cliente.getFechaNacimiento());
                                    validador.add(new ValidacionFecha(cliente.getFechaNacimiento()));
                                    error +=  ValidacionMultiValidation.validar(validador);
                                    if(!(error.length() > 0)){
                                        validador.clear();
                                        cliente.setSexoCliente(request.getParameter("clientSexo"));
                                        session.setAttribute("clientSexo",cliente.getSexoCliente());

                                        validador.add(new ValidacionSexo(cliente.getSexoCliente()));
                                        error +=  ValidacionMultiValidation.validar(validador);
                                        if(!(error.length() > 0)){
                                            validador.clear();
                                            cliente.setEmailCliente(request.getParameter("emailCliente"));
                                            session.setAttribute("emailCliente",cliente.getEmailCliente());
                                            validador.add(new ValidacionEmail(cliente.getEmailCliente()));
                                            error +=  ValidacionMultiValidation.validar(validador);
                                        }
                                        if(!(error.length() > 0)){
                                            validador.clear();
                                            cliente.setUsuarioCliente(request.getParameter("clientUsuario"));
                                            session.setAttribute("clientUsuario",cliente.getUsuarioCliente());
                                            validador.add(new ValidacionUsuario(cliente.getUsuarioCliente()));
                                            error +=  ValidacionMultiValidation.validar(validador);
                                            if(!(error.length() > 0)){
                                                validador.clear();
                                                cliente.setPasswordCliente(request.getParameter("password"));
                                                session.setAttribute("password",cliente.getPasswordCliente());
                                                validador.add(new ValidacionPassword(cliente.getPasswordCliente()));
                                                error +=  ValidacionMultiValidation.validar(validador);
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        ClienteRoll clienteRoll = new ClienteRoll();
        CPDAO cpdao = new CPDAO(clienteRoll.getUsuario(),clienteRoll.getPass());

        try {
            if(!cpdao.check_cp(cliente.getCodigoPostalClient())){

                error = "Codigo Postal Inexistente";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (error.length() > 0){
            request.setAttribute("error", error);
        }else {
            request.setAttribute("error", "Todo Correcto");
            clientFotoLoad(request,response);
            cliente.setImagenCliente(cliente.getNifCliente() + ".png");
            System.out.println(cliente.toString());
            rd = request.getRequestDispatcher("index.jsp");

            /*
          //    cliente para BD sin procedure
            ClienteDAO clienteDAO = new ClienteDAO();
           if (clienteDAO.add_cliente(cliente)>0){
               request.setAttribute("mensaje", "Cliente add");
           }
           else request.setAttribute("mensaje", "Cliente NO add");
           */

            //    cliente para BD CON procedure
            ClienteDAO clienteDAO = new ClienteDAO();
            if (clienteDAO.add_cliente_procedure(cliente)){
                request.setAttribute("mensaje", "Cliente add");
            }
            else request.setAttribute("mensaje", "Cliente NO add");

        }

        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    private String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return "fotoSin.jpg";
    }

    private void clientFotoLoad(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {

        Part filePart = request.getPart("clientImage");
        String fileName = getFileName(filePart);
        String dniCliente = request.getParameter("dniCliente");

        if (fileName.length() > 2) {

            fileName = dniCliente + ".png";

            String path = getServletContext().getRealPath("img/fotoClient/");

            File folder = new File(path);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            FileOutputStream fs = new FileOutputStream(new File(path + fileName));
            BufferedOutputStream buf = new BufferedOutputStream(fs);

            InputStream fileContent = filePart.getInputStream();
            BufferedInputStream bufIN = new BufferedInputStream(fileContent);

            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = bufIN.read(buffer)) != -1) {
                buf.write(buffer, 0, bytesRead);
            }

            buf.close();
            bufIN.close();
        }
    }


    private void listParam(HttpServletRequest request, HttpServletResponse response ) throws IOException {

        Enumeration<String> parameterNames = request.getParameterNames();


        PrintWriter out = response.getWriter();  //out.println("TestServlet says hi<br/>");

        while (parameterNames.hasMoreElements()) {

            String paramName = parameterNames.nextElement();

            out.write(paramName);

            out.write("=");

            String[] paramValues = request.getParameterValues(paramName);

            for (int i = 0; i < paramValues.length; i++) {

                String paramValue = paramValues[i];

                out.write("\t" + paramValue);

                out.write("\n");

            }

        }
        out.close();

    }
}

