package entity;


public class LoginClienteEntity {

    private String dni;
    private String usuario;
    private String password;

    public LoginClienteEntity() {

    }
    public LoginClienteEntity(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}

