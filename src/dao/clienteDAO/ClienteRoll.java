package dao.clienteDAO;

import dao.AccesoDB;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ClienteRoll {

    private AccesoDB acceso = null;

    private void conectar() {
        acceso = AccesoDB.getMiConexion();
        try {
            acceso.conectar("com.mysql.cj.jdbc.Driver", //com.mysql.cj.jdbc.Driver",
                    "jdbc:mysql://localhost/tienda_harnina20189vistas?useInformationSchema=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //Un objeto ResultSet mantiene un cursor que apunta a su fila actual de datos. Inicialmente el cursor se coloca antes de la primera fila.
    public ResultSet getCursor(String sql) throws SQLException {
        this.conectar();
        ResultSet cursor = acceso.executeQuery(sql);
        return cursor;
    }

    public int insertUpdateDelete(String sql) throws SQLException {
        this.conectar();
        return acceso.executeUpdate(sql);
    }

    // Uso de procedures

    public boolean  add_cliente(String dni, String apellidos, String nombre, String cp ) throws SQLException {
        this.conectar();
        CallableStatement cstmt = (CallableStatement) acceso.getConexion().prepareCall("{call add_cliente(?, ?, ?, ?, ?)}");
        cstmt.setString(1,dni);
        cstmt.setString(2,apellidos);
        cstmt.setString(3,nombre);
        cstmt.setString(4,cp);
        cstmt.registerOutParameter(5, Types.BOOLEAN);
        cstmt.execute();
        return  cstmt.getBoolean(5);
    }

}
