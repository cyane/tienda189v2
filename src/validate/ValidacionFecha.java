package validate;

public class ValidacionFecha extends ValidacionRegularExpression implements IValidacion {

    private static final String patron = "^(\\d{4})(\\-)(0[1-9]|1[012])(\\-)(0[1-9]|[1-2]\\d|3[01])$";

    private static final String mensajeError = "Fecha Incorrecta";

    private String value;

    public ValidacionFecha(String value){

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

