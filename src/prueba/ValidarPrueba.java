package prueba;

import validate.ValidacionCadenaSinEspacio;
import validate.ValidacionCodigoPostal;
import validate.ValidacionImagenNombre;

public class ValidarPrueba {

    public static void main(String[] args){
        ValidacionImagenNombre  validacionImagenNombre = new  ValidacionImagenNombre("luciano.png");
        System.out.println( validacionImagenNombre.validar());
        System.out.println( validacionImagenNombre.getError());
    }
}




