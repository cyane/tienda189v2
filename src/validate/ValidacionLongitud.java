package validate;

public class ValidacionLongitud implements IValidacion{

    private String cadena;

    private  String mensajeError = "Longitud Incorrecta";

    private int minimo;

    private int maximo;

   public ValidacionLongitud(String cadena,int minimo,int maximo ){

        assert maximo >= minimo;

        this.cadena = cadena;

        this.minimo = minimo;

        this.maximo = maximo;
    }


    @Override
    public boolean validar() {

       if (this.minimo <= this.cadena.length() && this.cadena.length()<= this.maximo){

           return true;
       }
        return false;
    }

    @Override
    public String getError() {
        return mensajeError;
    }
}
