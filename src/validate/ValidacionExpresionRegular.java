package validate;

public class ValidacionExpresionRegular extends Validacion{

        public Boolean validar(String patron, String value){

            return value.matches(patron);

        }

}
