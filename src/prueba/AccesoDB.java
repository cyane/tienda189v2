package prueba;

import java.sql.SQLException;

public class AccesoDB {

    public static void main(String [] args){

         dao.AccesoDB acceso = null;
         acceso = dao.AccesoDB.getMiConexion();

        try {
                acceso.conectar("com.mysql.jdbc.Driver",
                        "jdbc:mysql://localhost/pagina2018vista?useInformationSchema=true",
                        "root","");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
