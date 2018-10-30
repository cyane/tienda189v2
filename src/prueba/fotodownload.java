package prueba;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;

@WebServlet("/foto")
@MultipartConfig
public class fotodownload extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return "foto.jpg";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String fileName;

        String dniCliente = request.getParameter("dniCliente");
        System.out.println("dniCliente antes: " + dniCliente);

        String clientImage = request.getParameter("clientImage");
        System.out.println("clientImage: " + clientImage);

        String myFile = request.getParameter("myFile");
        System.out.println("myFile: " + myFile);

        Part filePart = request.getPart("myFile");
        System.out.println("myFile.length(): " + myFile.length());

        if (myFile.length() > 2) {

            fileName = dniCliente + ".png";

            Path path = Paths.get("img/fotos");

            if(!Files.exists(path)) {
                try {
                    Files.createDirectories(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


          //FileOutputStream fs = new FileOutputStream(new File(path + fileName));
          //BufferedOutputStream buf = new BufferedOutputStream(fs);

            //InputStream fileContent = filePart.getInputStream();
            // BufferedInputStream bufIN = new BufferedInputStream(fileContent);

        }
    }
}
