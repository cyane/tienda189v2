package validate;

public class ValidacionSexo extends  ValidacionListOfValues implements IValidacion {
    private static final String [] valores  = {"m" , "f"};

    private static final String error = "El  valor no esta en la lista";

    private String value;

    public ValidacionSexo(String value) {
        this.value = value;
    }

    @Override
    public boolean validar(){
        return super.validar(value,valores);
    }

    @Override
    public String getError(){
        return this.error;
    }

}
