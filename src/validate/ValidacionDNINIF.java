package validate;

public class ValidacionDNINIF implements IValidacion{
    private String dni;
    private  String mensajeError = "DNI Incorrecto";

    public ValidacionDNINIF(String dni) {
        this.dni = dni;
    }
    @Override
    public boolean validar() {

        String letraMayuscula = (this.dni.substring(8)).toUpperCase();

        String losNumeros = this.dni.substring(0,8);

        if(dni.length() != 9 || Character.isLetter(this.dni.charAt(8)) == false ) {

            this.mensajeError = "Cadena distinta a 9 caracteres y  el último caracter no es una letra";

            return false;
        }

        if(soloNumeros(losNumeros) == true && getLetraDNI().equals(letraMayuscula)) {

            return true;
        }
        this.mensajeError = "8 dígitos entre los 8 primeros caracteres y una la letra al final que corresponde para esos digitos";

        return false;
    }

    @Override
    public String getError() {
        return mensajeError;
    }

    private boolean soloNumeros(String cadena) {

        int i, j = 0;

        int cuenta = 0;

        String unNumero = "";

        String[] numeros = {"0","1","2","3","4","5","6","7","8","9"};

        for(i = 0; i < cadena.length(); i++) {

            unNumero = cadena.substring(i, i+1);

            for(j = 0; j < numeros.length; j++) {
                if(unNumero.equals(numeros[j])) {
                    cuenta++;
                }
            }
        }
        if(cuenta != cadena.length()) {
            return false;
        }
        return true;
    }

    private String getLetraDNI() {

        int miDNI = Integer.parseInt(this.dni.substring(0,8));

        int resto = 0;

        String letra = "";

        String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        resto = miDNI % 23;

        letra = letras[resto];

        return letra;
    }
}
