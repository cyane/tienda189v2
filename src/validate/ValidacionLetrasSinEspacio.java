package validate;

public class ValidacionLetrasSinEspacio extends ValidacionRegularExpression implements IValidacion {

    private String patron =  "^([a-zA-ZñÑáéíóúÁÉÍÓÚ\\S]*)$";

    private static final String mensajeError = "La cadena contiene espacios";

    private String value;

    public ValidacionLetrasSinEspacio(String value) {
        this.value = value;
    }

    @Override
    public boolean validar() {
        return super.validar(value, patron);
    }

    @Override
    public String getError() {
        return mensajeError;
    }

}