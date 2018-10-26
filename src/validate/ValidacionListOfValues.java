package validate;

public class ValidacionListOfValues {

    public boolean validar(String [] valores , String value){

        for (int i = 0; i < valores.length ; i++) {
            if(valores[i].toLowerCase().equals(value.toLowerCase())){
                return true;
            }
        }
        return false;
    }
}
