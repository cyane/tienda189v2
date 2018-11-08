package prueba;

import dao.clienteDAO.ClienteDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccesoDB {

    public static void main(String [] args) throws SQLException, ClassNotFoundException {

        ClienteDAO clienteDAO  =  new ClienteDAO();
        System.out.println("INSERT:"+clienteDAO.add_cliente_procedure());

/*
        ArrayList<String> provincias = new ArrayList<String>();

        for (String s : provincias = clienteDAO.getProvincias()) {
            System.out.println(s + "\n");
        }

*/



    }
}
