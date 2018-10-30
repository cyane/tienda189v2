package validate;

public class ValidacionExtensionFile extends ValidacionListOfValues implements IValidacion {


    private String value;
    private String [] lista_extension;
    private final String error = "Extension no valida";

    public ValidacionExtensionFile(String value,String [] listaExtension) {
        this.value = value;
        this.lista_extension =  listaExtension;
    }

    @Override
    public boolean validar() {
        return super.validar(value, lista_extension);
    }

    @Override
    public String getError() {
        return error;
    }
}
