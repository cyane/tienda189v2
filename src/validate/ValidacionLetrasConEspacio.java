package validate;

public class ValidacionLetrasConEspacio extends ValidacionRegularExpression implements IValidacion {

    private static final String patron = "^([a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]*)$";

    private static final String mensajeError = "Solo letras y espacio";

    private String value;

    public ValidacionLetrasConEspacio(String value) {
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

