// Lista de expresiones regulares.
const NUMERO_SPAIN_MOVIL = /^[6|7][0-9]{8}$/;
const NUMERO_US_MOVIL = /^[0-9]{10}$/;

// Objeto prefijo con todos los refijos soportados.
const PREFIJOS = [
    {"prefijo": "ES", "value": "+34", "maximo": "9", "flag": "spain.png", "expresionRegularMovil": NUMERO_SPAIN_MOVIL},
    {"prefijo": "US", "value": "+1", "maximo": "10", "flag" : "us.png", "expresionRegularMovil": NUMERO_US_MOVIL, "default" : "true"}
];