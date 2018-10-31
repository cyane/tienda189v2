package prueba;

import validate.*;

public class ValidarPrueba {

    public static void main(String[] args){
       // ValidacionImagenNombre  validacionImagenNombre = new  ValidacionImagenNombre("luciano.p");
        ValidacionDNINIECIF validacionDNINIECIF = new ValidacionDNINIECIF("X1234567L");
        if (!validacionDNINIECIF.validar()){
            System.out.println(validacionDNINIECIF.getError());
        }
        else {
            System.out.println(true);
        }
    }
}




