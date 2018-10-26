STORE.namespace('STORE.list_input');

(function(g){
    'use strict';

    var form = $("client_register");

    STORE.list_input = form.querySelectorAll("[data-functioncallback]");

    eval("div_" + STORE.list_input[0].id).style.display = '';

    for (var i = 1; i < STORE.list_input.length; i++) {

       eval("div_" + STORE.list_input[i].id).style.display = 'none';

    }

    STORE.prefix_input = document.getElementById("prefijo");
    var prefijo = STORE.prefix_input;
    for(var index in PREFIJOS) {
        prefijo.options[prefijo.options.length] = new Option(PREFIJOS[index].value, index, PREFIJOS[index].default, PREFIJOS[index].default);
        if (PREFIJOS[index].default) {
            STORE.prefix_input.regExp = PREFIJOS[index].expresionRegularMovil;
            STORE.Utiles.limitarCamposDeTexto("numeroMovil", PREFIJOS[index].maximo);
            console.log("El valor por defecto es: " + PREFIJOS[index].prefijo);
        }
        console.log("Añadida opcion");
    }

   STORE.Error.off();

   STORE.Submit.off();

    var valida = STORE.Valida;

    for (var i = 0; i < STORE.list_input.length; i++) {

        STORE.list_input[i].addEventListener("input",eval("STORE." + STORE.list_input[i].dataset.functioncallback),false);
        STORE.list_input[i].style.backgroundColor = STORE.Error.get_colorError();
        //STORE.list_input[i].style.color = "black";
    }

    // Action Listener para cambios de prefijo.
    prefijo.addEventListener("change", cambiarExpRegular);

    function cambiarExpRegular() {
        var selectedValue = prefijo.options[prefijo.selectedIndex].valueOf().innerText;
        console.log(selectedValue);
        for (var index in PREFIJOS) {
            if (PREFIJOS[index].value === selectedValue) {
                STORE.prefix_input.regExp = PREFIJOS[index].expresionRegularMovil;
                STORE.prefix_input.minimo = PREFIJOS[index].minimo;
                STORE.prefix_input.maximo = PREFIJOS[index].maximo;
                STORE.Utiles.limitarCamposDeTexto("numeroMovil", PREFIJOS[index].maximo);
            }
        }
    }

}) (window,undefined);