package validate;

import java.util.List;

public class ValidacionMultiValidation {
    private String error;

    protected boolean validar(IValidacion validadores[]) {

        for (int i = 0; i < validadores.length; i++) {

            if (!validadores[i].validar()) {

                error = validadores[i].getError();

                return false;
            }
        }
        return true;
    }

    public static String validar(List<IValidacion> validador ) {

        for(IValidacion vali:validador){

            if (!vali.validar()) {
                return vali.getError();
            }
        }
        return "";
    }

    public String getError() {
        return error;
    }

}




