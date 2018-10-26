package validate;

public class ValidacionSexo extends  ValidacionListOfValues implements ValidacionFileName.IValidacion {
    private static final String [] valores  = {"Hombre" , "Mujer"};

    private static final String error = "El  valor no esta en la lista";

    private String value;

    public ValidacionSexo(String value) {
        this.value = value;
    }

    @Override
    public boolean validar(){
        return super.validar(valores,value);
    }

    @Override
    public String getError(){
        return this.error;
    }

}
