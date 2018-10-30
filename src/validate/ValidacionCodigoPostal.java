package validate;

public class ValidacionCodigoPostal  extends ValidacionRegularExpression implements IValidacion {
    private static final String patron ="^(?:0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3})$";

    private static final String mensajeError = "Codigo Postal Incorrecto";

    private String value;
    public ValidacionCodigoPostal(String value){

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
