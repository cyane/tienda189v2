package prueba;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;


import java.io.IOException;
import java.nio.file.*;
import java.sql.SQLException;
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
        return "fotoSin.jpg";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
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



/*
        String fileName;
        String clientImage;
        String dniCliente = request.getParameter("dniCliente");
        System.out.println("dniCliente: " + dniCliente);

        //clientImage = request.getParameter("clientImage");
        // null Problem: Retrieves <input type="file" name="file"> request.getPart
        //System.out.println("clientImage: " + clientImage);

        Part filePart = request.getPart("clientImage");
        // Retrieves <input type="file" name="file">

        System.out.println("request.getContextPath() " + request.getContextPath());

        System.out.println("filePart: " + filePart);

        String myFile = request.getParameter("myFile");
        System.out.println("myFile: " + myFile);

        File fileOrigen = new File(filePart.getName());

        System.out.println("myFile.length(): " + myFile.length());

        clientImage = getFileName(filePart);

        System.out.println("clientImage filePart: " + clientImage);

        if (myFile.length() > 2) {

            fileName = dniCliente + ".png";


            Path path = Paths.get("img/fotoClient/");
            Path pathOrigen = fileOrigen.toPath();

            if(!Files.exists(path)) {
                try {
                    Files.createDirectories(path);
                    System.out.println("img/fotoClient: Create ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Files.copy(pathOrigen,path, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("FileOutputStream: "+ path + fileName);
            /*FileOutputStream fs = new FileOutputStream(new File(path + fileName));
            BufferedOutputStream buf = new BufferedOutputStream(fs);

            InputStream fileContent = filePart.getInputStream();
            BufferedInputStream bufIN = new BufferedInputStream(fileContent);

            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = bufIN.read(buffer)) != -1) {
                buf.write(buffer, 0, bytesRead);
                System.out.println("Subiendo Imagen");
            }

            buf.close();
            bufIN.close();
*/
            response.setHeader("Refresh", "0; URL=http://localhost:8080/index.jsp");
        }

}
