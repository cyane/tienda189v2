package prueba;

import validate.*;

public class ValidarPrueba {

    public static void main(String[] args){

        ValidacionNIFCIF obj = new ValidacionNIFCIF("A62565312");


        if(!obj.validar()){
            System.out.println( obj.getError());
        }
        else {
            System.out.println(true);
        }


    }
}




