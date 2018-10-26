package validate;

public class ValidacionExtensionFile extends ValidacionListOfValues implements ValidacionFileName.IValidacion {


    private String value;
    private String [] lista_extension;
    private final String error = "Extension no valida";

    public ValidacionExtensionFile(String value,String [] listaExtension) {
        this.value = value;
        this.lista_extension =  listaExtension;

    }

    @Override
    public boolean validar() {
        return super.validar(lista_extension,value);
    }

    @Override
    public String getError() {
        return null;
    }
}
