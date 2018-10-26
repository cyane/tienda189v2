package validate;

public class ValidacionCadenaSinEspacio extends ValidacionRegularExpression implements ValidacionFileName.IValidacion {

    private String patron = "[^\\\\s\\\"']+|\\\"([^\\\"]*)\\\"|'([^']*)'";
    private static final String mensajeError = "La cadena contiene espacios";

    private String value;

    public ValidacionCadenaSinEspacio(String value) {
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