package dao;


import java.sql.*;

public class AccesoDB {
    private static AccesoDB miConexion = null;
    private Connection conexion = null;
    private String driver = null;
    private String dbName= null;
    private String user = null;
    private String password= null;

//https://www.fdi.ucm.es/profesor/jpavon/web/48-jdbc.pdf

    synchronized public static AccesoDB getMiConexion(){

        if (miConexion == null) miConexion = new AccesoDB();
        return miConexion;

    }

    synchronized public void conectar(String driver, String dbName,String user,String password )
            throws SQLException, ClassNotFoundException{
        if(conexion != null) {
            if (!this.driver.equals(driver) ||
                    !this.dbName.equals(dbName) ||
                    (this.user != null && !this.user.equals(user)) ||
                    (this.password != null && !this.password.equals(password))

            ) {
                conexion.close();
            } else return;
        }
            //Cargar el driver reflexión
        Class.forName(driver); // Ya no es neesario por la version

        if(user == null || password == null) conexion = (Connection) DriverManager.getConnection(dbName);
            else conexion = (Connection) DriverManager.getConnection(dbName,user,password);
        System.out.println("Conectado a BD " + dbName);
        this.driver = driver;
        this.dbName = dbName;
        this.user = user;
        this.password = password;
    }
    synchronized public void cerrar() throws SQLException {
        if (conexion != null) conexion.close();
    }
    // Para ejecutar sentencias Select
    synchronized public ResultSet executeQuery(String sqlSentence) throws SQLException{
        if(conexion == null) return null;
        Statement sentence = (Statement) conexion.createStatement();
        return sentence.executeQuery(sqlSentence);
    }

    // Para ejecutar sentencias update, delete e insert
    synchronized public int executeUpdate(String sqlSentence) throws SQLException{
        if(conexion == null) return -1;
        Statement sentence = (Statement) conexion.createStatement();
        return sentence.executeUpdate(sqlSentence);
    }
    public Connection getConexion(){
        return this.conexion;

    }
}

   /*

    Al cargarse la clase, se registra como driver JDBC: Java Database Connectivity (en español: Conectividad a bases de datos de Java), más conocida por sus siglas JDBC,​​ es una API que permite la ejecución de operaciones sobre bases de datos desde el lenguaje de programación Java, independientemente del sistema operativo donde se ejecute o de la base de datos a la cual se ...

    Invocas DriverManager.getConnection() : Método que nos permite establecer una conexión con la base de datos.
         No hay cast a DriverManager, llamas a un método estático. Y el cast a Connection sobra, porque getConnection() ya devuelve una referencia a Connection.

    En función de la URL que le has pasado, DriverManager localiza, entre los drivers de BD que tiene registrados, el que se usa para acceder a la base de datos indicada. Java delega en este driver toda la comunicación con la base de datos.
            Así, tú siempre haces DriverManager.getConnection(), pero la instancia de Connection recuperada será de una subclase distinta para conectarte a MySQL que para Oracle. De todas formas, como todas las instancias tienen que cumplir con la especificación de Connection, a tí realmente te da igual.

    En sistemas antiguos, para que DriverManager tuviera "registrados" los drivers, era necesario cargar la clase en la máquina virtual. Para eso es el Class.forName(), simplemente carga la clase con el nombre indicado.

    A partir de JDK 6, los drivers JDBC 4 ya se registran automáticamente y no es necesario el Class.forName(), sólo que estén en el classpath de la JVM.

   */

