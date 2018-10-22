/**
 * Created by Luciano on 16/10/2018.
 */
STORE.namespace('STORE.Error');
(function(g){

    'use strict';

    var error = $("alertaError");

    STORE.Error = {

        on  : function(){
            error.style.display = "";
        },

        off  : function(){
            error.style.display = "none";
        },

        set_message : function(message){
            error.innerHTML = message;
        },

        get_colorError : function(){

            return STORE.Color.colorError;
        }
    }

})(window)

