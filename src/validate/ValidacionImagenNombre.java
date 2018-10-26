package validate;

public class ValidacionImagenNombre extends  ValidacionFileName{

    private String value;
    private String [] lista = {"jpg" , "png"};

    public ValidacionImagenNombre(String value) {
        this.value = value;
    }

    public boolean validar(){

        String nombreImagen = new String(value.substring(0 , value.lastIndexOf('.')));

        String extension = new String(value.substring(value.lastIndexOf('.')));

        IValidacion [] validadores = {new ValidacionExtensionFile(this.value,this.lista) ,new ValidacionCadenaConEspacio(nombreImagen)};

        return super.validar(validadores);

    }
}
