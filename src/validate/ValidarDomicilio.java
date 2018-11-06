package validate;

public class ValidarDomicilio extends ValidacionRegularExpression implements IValidacion {

    private static final String patron = "^([0-9ºª.:,/a-zA-ZñÑáéíóúÜüÁÉÍÓÚ\\s]*)$";

    private static final String mensajeError = "Domicilio: solo letras, números y espacio";

    private String value;

    public ValidarDomicilio(String value){
        this.value = value;
    }

    @Override
    public boolean validar() {
        return super.validar(value,patron);
    }

    @Override
    public String getError() {
        return mensajeError;
    }
}
