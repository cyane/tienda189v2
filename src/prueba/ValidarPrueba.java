package prueba;

import validate.ValidacionCadenaSinEspacio;

public class ValidarPrueba {

    public static void main(String[] args){
       ValidacionCadenaSinEspacio validacionCadenaSinEspacio = new ValidacionCadenaSinEspacio("Luciano");
        System.out.println(validacionCadenaSinEspacio.validar(validacionCadenaSinEspacio.getPatron(),validacionCadenaSinEspacio.getValue()));
    }
}




