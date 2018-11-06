package validate;

public class ValidacionEmail extends ValidacionRegularExpression implements IValidacion {

    private static final String patron = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";

    private static final String mensajeError = "Email Incorrecto";

    private String value;

    public ValidacionEmail(String value){

        this.value = value;

    }
    @Override
    public boolean validar(){
        return super.validar(value,patron);
    }

    @Override
    public String getError() {
        return mensajeError;
    }
}
