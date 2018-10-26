package validate;

public class ValidacionFileName {
    private String error;

    protected boolean validar(IValidacion validadores []){

        for (int i = 0; i < validadores.length ; i++) {

            if( ! validadores[i].validar()){

                error = validadores[i].getError();

                return false;
            }

        }

        return true;
    }

    public String getError() {
        return error;
    }

    public static interface IValidacion {

       public abstract boolean validar();

       public abstract String getError();
    }
}


