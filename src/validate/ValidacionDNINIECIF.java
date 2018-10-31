package validate;

/**
 * Clase que calcula o valida un documento de identificación del reino de España. (DNI,NIE,CIF).
 * @author yo
 * El antecedente del NIF es el CIF, utilizado en personas jurídicas
 */
public class ValidacionDNINIECIF implements IValidacion{

    private String documento;

    private static final  String mensajeError = "Documento Incorrecto";


    public ValidacionDNINIECIF(String documento){
        this.documento = documento;
    }

    @Override
    public boolean validar() {
        ValidacionDNINIF validacionDNINIF = new ValidacionDNINIF(documento);
        if (!validacionDNINIF.validar()){
            ValidacionNIE validacionNIE = new ValidacionNIE(documento);
            if(!validacionNIE.validar()){
                ValidacionNIFCIF validacionNIFCIF = new ValidacionNIFCIF(documento);
                if(!validacionNIFCIF.validar()){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getError() {
        return mensajeError;
    }

}
