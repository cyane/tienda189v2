package dao.clienteDAO;

import dao.AccesoDB;
import entity.CodigoPostalEntity;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class ClienteRoll {

    private AccesoDB acceso = null;

    private String usuario = "cliente";

    private String pass = "cliente";

    public String getUsuario() {
        return usuario;
    }

    public String getPass() {
        return pass;
    }



    private void conectar() {
        acceso = AccesoDB.getMiConexion();
        try {
            acceso.conectar("com.mysql.cj.jdbc.Driver", //com.mysql.cj.jdbc.Driver",
                    "jdbc:mysql://localhost/tienda_harnina20189vistas?useInformationSchema=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    this.usuario,
                    this.pass);
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
    public boolean  add_cliente(String dni, String apellidos, String nombre, String cp, String domicilio, String fechaNacimiento, String telefonofijo, String telefonomovil, String  sexo, String email, String imagen , String usuario, String password) throws SQLException {
        this.conectar();
        CallableStatement cstmt = (CallableStatement) acceso.getConexion().prepareCall("{call add_cliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
        cstmt.setString(1,dni);
        cstmt.setString(2,apellidos);
        cstmt.setString(3,nombre);
        cstmt.setString(4,cp);
        cstmt.setString(5,domicilio);
        cstmt.setString(6,fechaNacimiento);
        cstmt.setString(7,telefonofijo);
        cstmt.setString(8,telefonomovil);
        cstmt.setString(9,sexo);
        cstmt.setString(10,email);
        cstmt.setString(11,imagen);
        cstmt.setString(12,usuario);
        cstmt.setString(13,password);
        cstmt.registerOutParameter(14, Types.BOOLEAN);
        cstmt.execute();
        return  cstmt.getBoolean(14);
    }

    public String get_nif_login(String user, String password){
        this.conectar();
        try{
            CallableStatement cstmt = (CallableStatement) acceso.getConexion().prepareCall("{call get_nif_login(?, ?, ?)}");
           try{
                cstmt.setString(1,user);
                cstmt.setString(2,password);
                cstmt.registerOutParameter(3, Types.VARCHAR);
                cstmt.execute();
                return  cstmt.getString(3);
           }
           finally {
               if (cstmt != null) {
                   cstmt.close();
               }
           }
        }
        catch (Exception ignore) {
        }

        return "null";
    }



}
