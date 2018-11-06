package validate;

public class ValidacionTelefonoSpain extends ValidacionRegularExpression implements IValidacion {
    private static final String patron = "^(\\+34|0034|34)?[6789]\\d{8}$";//"^(\+34|0034|34)?[6789]\d{8}$";

    private static final String mensajeError = "Telefono Español Incorrecto";

    private String value;
    public ValidacionTelefonoSpain(String value){

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
