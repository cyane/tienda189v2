<%--
  Created by IntelliJ IDEA.
  User: Luciano
  Date: 27/10/2018
  Time: 7:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Tienda Harnina</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1, user-scalable=no">
    <link type="text/css" rel="stylesheet" href="../css/catalogoEstilo.css">
    <link type="text/css" rel="stylesheet" href="../css/miscontenedores.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
</head>
<body>
<header class="cabecera"><a class="subtitulo" href="catalogo.html">DAM: ACCESO A DATOS</a>
    <h5 class="titulo">Tienda Harnina</h5>
</header>
<div class="contenido01">
    <div class="medio dadoCatalogo">
        <div class="dado d1 informatica"></div>
    </div>
    <div class="medio dadoCatalogo">
        <div class="dado d3 harnina"></div>
    </div>
</div>
<c:if test="${not empty error}">
    <div class="etiqueta s8">
            ${error}
    </div>
</c:if>
<div class="contenido01">
    <form id="client_register" method="POST" action="/vali">
        <div class="menu s3 caja03">
            <h4>New Client</h4>
            <div id="div_clientFirstName">
                <label class="labelInput" for="clientFirstName">First name:</label>
                <input class="etiqueta s8" id="clientFirstName" type="text" data-functioncallback="ValidacionExpresionRegular.validarLetrasSinEspacio" size="24" minlength="3" maxlength="80" required placeholder="input your FirstName" title="3 to 50 characters">
            </div>
            <div id="div_clientLastName">
                <label class="labelInput" for="clientLastName">Last name:</label>
                <input class="etiqueta s8" id="clientLastName" type="text" data-functioncallback="ValidacionExpresionRegular.validarLetrasConEspacio" minlength="5" maxlength="100" required placeholder="input your LastName" title="3 to 70 characters">
            </div>
            <div class="etiqueta errorColor" id="alertaError">Error:</div>
            <button id="submit" type="submit">Enviar</button>
        </div>
    </form>
</div>
</body>
</html>
<script src="../js/jscss/dado.js"></script>
<script src="../js/jsStore/store.js"></script>
<script src="../js/jsStore/prefijos.js"></script>
<script src="../js/jsStore/color.js"></script>
<script src="../js/jsStore/lista.js"></script>
<script src="../js/jsStore/file.js"></script>
<script src="../js/jsStore/error.js"></script>
<script src="../js/jsStore/submit.js"></script>
<script src="../js/jsStore/validate.js"></script>
<script src="../js/jsStore/init.js"></script>