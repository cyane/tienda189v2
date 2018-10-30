package validate;



import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidacionImagenNombre extends  ValidacionFileName implements IValidacion{

    private String value;
    private String [] lista = {"jpg" , "png"};

    public ValidacionImagenNombre(String value) {
        this.value = value;
    }

    public boolean validar(){

       assertTrue(value.contains("."));

        String nombreImagen = new String(value.substring(0 , value.lastIndexOf('.')));

        System.out.println(nombreImagen);

        String extension = new String(value.substring(value.lastIndexOf('.') + 1));

        IValidacion [] validadores = {new ValidacionExtensionFile(extension,this.lista) ,new ValidacionCadenaSinEspacio(nombreImagen)};

        System.out.println(extension);

        return super.validar(validadores);

    }
}
