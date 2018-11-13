package prueba;

import dao.clienteDAO.ClienteDAO;
import entity.ClientEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccesoDB {

    public static void main(String [] args) throws SQLException, ClassNotFoundException {

        ClienteDAO clienteDAO  =  new ClienteDAO();
        ClientEntity ClientEntity = new ClientEntity("33","33","33","06810","33","1961-02-13","33","33","m","33","33","33","33");
        System.out.println(ClientEntity.toString());
        System.out.println("INSERT:"+clienteDAO.add_cliente_procedure(ClientEntity));

/*
        ArrayList<String> provincias = new ArrayList<String>();

        for (String s : provincias = clienteDAO.getProvincias()) {
            System.out.println(s + "\n");
        }

*/



    }
}
