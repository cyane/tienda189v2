package validate;

public class ValidacionCadenaSinEspacio extends  ValidacionExpresionRegular{

        private String patron = "w.*";
        private String value;

        public ValidacionCadenaSinEspacio(String value) {

            this.value = value;

        }

    public String getPatron() {
        return patron;
    }

    public String getValue() {
        return value;
    }
}

