STORE.namespace('STORE.Utiles');
(function(g){

    'use strict';

    STORE.Utiles = {

        limitarCamposDeTexto : function (campo, limite) {
            document.getElementById(campo).setAttribute("maxlength", limite);
        }

    }

})(window)