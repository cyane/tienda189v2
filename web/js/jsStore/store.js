/**
 * Created by Luciano on 27/09/2018.
 */

function $(id) { return document.getElementById(id); };

var STORE = STORE || {};

STORE.namespace = function(ns_string){
    var parts = ns_string.split('.');
    var parent = STORE;
    var i;
    if (parts[0] === "STORE") {
        parts = parts.slice(1);
    }
    for (i = 0; i < parts.length; i += 1) {

        if (typeof parent[parts[i]] === "undefined") {

            parent[parts[i]] = {};
        }
        parent = parent[parts[i]];
    }

    return parent;

};

STORE.getLimite = function(nodo){

    var limite = {};

    if(nodo.minLength){

        var limiteInferior = nodo.minLength;

        var limiteSuperior = nodo.maxLength;

        limite.limiteInferior = limiteInferior;

        limite.limiteSuperior = limiteSuperior;
    }

    return limite;

};



STORE.assert = function(condition, message) {
    if (!condition) {
        message = message || "Assertion failed";
        if (typeof Error !== "undefined") {
            throw new Error(message);
        }
        throw message; // Fallback
    }
}