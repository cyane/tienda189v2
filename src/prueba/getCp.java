package prueba;

import dao.clienteDAO.ClienteDAO;
import dao.cp.CPDAO;
import entity.CodigoPostalEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class getCp {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ClienteDAO cpdao = new ClienteDAO();
        //ArrayList<String> listaCP = cpdao.get_lista_cp();

       /* Iterator<String> nombreIterator = listaCP.iterator();
        int i=0;
        System.out.println("Total cp:" + listaCP.size());
       /* while(nombreIterator.hasNext()){
            i++;
            nombreIterator.next();
           // CodigoPostalEntity elemento = nombreIterator.next();
          //  System.out.print(elemento.getCodigoPostal()+" / ");
        }
        System.out.println("Total cp:" + i);*/
        String cp ="06200";
        System.out.println("Existe cp:" + cpdao.getProvincias());

    }

}
