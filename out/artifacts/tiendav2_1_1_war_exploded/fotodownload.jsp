<%--
  Created by IntelliJ IDEA.
  User: Luciano
  Date: 29/10/2018
  Time: 19:31
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
    <h5 class="titulo">Subir Foto</h5>
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
    <form enctype="multipart/form-data" id="client_register" method="POST" action="/foto" >
        <div class="menu s3 caja03">
            <h4>New Foto</h4>
            <div id="div_dniCliente">
                <label for="dniCliente">dni:</label>
                <input class="etiqueta s8" id="dniCliente" name = "dniCliente" type="text" data-functioncallback="ValidacionExpresionRegular.validarDni" required placeholder="input your dni" title="dni">
            </div>
            <div class="fileinputs etiqueta s8" id="div_clientImage">
                <input class="etiqueta s8 file" id="clientImage" type="file" name="clientImage" data-functioncallback="ValidarFicheroName.validarImagenName" required accept="image/png, image/jpeg" placeholder="input your Avatar" title="3 to 120 characters">
                <div class="fakefile">
                    <label class="labelInput" for="idFile">Elije tu foto</label>
                    <input id="idFile" name="myFile">
                </div>
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

<script src="../js/jsStore/color.js"></script>
<script src="../js/jsStore/lista.js"></script>
<script src="../js/jsStore/file.js"></script>
<script src="../js/jsStore/error.js"></script>
<script src="../js/jsStore/submit.js"></script>
<script src="../js/jsStore/validate.js"></script>
<script src="../js/jsStore/init.js"></script>