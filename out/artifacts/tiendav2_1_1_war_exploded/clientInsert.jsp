<%--
  Created by IntelliJ IDEA.
  User: Luciano
  Date: 27/10/2018
  Time: 7:58
  <%@page contentType="text/html" pageEncoding="UTF-8"%>
  To change this template use File | Settings | File Templates.
--%>



<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Tienda Harnina</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <form enctype="multipart/form-data" id="client_register" method="POST" action="/valiCliIn">
        <div class="menu s3 caja03">
            <h4>New Client</h4>

            <div id="div_dniCliente">
                <label for="dniCliente">dni:</label>
                <input class="etiqueta s8" id="dniCliente" name = "dniCliente" value="<%= session.getAttribute("dniCliente") %>" type="text" data-functioncallback="ValidacionExpresionRegular.validarDniNieCif" required placeholder="input your dni" title="dni">
            </div>

            <div id="div_clientFirstName">
                <label class="labelInput" for="clientFirstName">Nombre:</label>
                <input class="etiqueta s8" id="clientFirstName" name ="clientFirstName" value="<%= (session.getAttribute("clientFirstName")!= "null")? session.getAttribute("clientFirstName"): "" %>" type="text" data-functioncallback="ValidacionExpresionRegular.validarLetrasConEspacio" size="24" minlength="3" maxlength="80" required placeholder="input your FirstName" title="3 to 50 characters">
            </div>

            <div id="div_clientLastName">
                <label class="labelInput" for="clientLastName">Apellidos:</label>
                <input class="etiqueta s8" id="clientLastName" name="clientLastName" value="<%= session.getAttribute("clientLastName") %>" type="text" data-functioncallback="ValidacionExpresionRegular.validarLetrasConEspacio" minlength="5" maxlength="100" required placeholder="input your LastName" title="3 to 70 characters">
            </div>

            <div id="div_clientCP">
                <label class="labelInput" for="clientCP">C P:</label>
                <input class="etiqueta s8" id="clientCP" name="clientCP" value="<%= session.getAttribute("clientCP") %>" type="text" data-functioncallback="ValidacionExpresionRegular.validarCodigoPostal" required placeholder="input your cp" title="5 characters">
            </div>

            <div id="div_DomicilioCliente">
                <label class="labelInput" for="DomicilioCliente">Domicilio:</label>
                <input class="etiqueta s8" id="DomicilioCliente" name="DomicilioCliente" value="<%= session.getAttribute("DomicilioCliente") %>" type="text" data-functioncallback="ValidacionExpresionRegular.validarDomicilio" minlength="2" maxlength="100" required placeholder="Adress" title="5 characters">
            </div>

            <div id="div_FechaNacimiento">
                <label class="labelInput" for="FechaNacimiento">Fecha Nacimiento:</label>
                <input class="etiqueta s8" id="FechaNacimiento" name="FechaNacimiento" value="<%= session.getAttribute("FechaNacimiento") %>" type="date" data-functioncallback="ValidacionExpresionRegular.validarFecha"  required placeholder="Adress" title="5 characters">
            </div>

            <div id="div_TelefonoFijo">
                <label for="TelefonoFijo">tlf. fijo:</label>
                <select id="prefijoFijo"></select>
                <input class="etiqueta s8" id="TelefonoFijo" name="TelefonoFijo" value="<%= session.getAttribute("TelefonoFijo") %>" type="tel" data-functioncallback="ValidacionExpresionRegular.validarTelefonoFijo" size="20" required placeholder="Tlf Fijo" title="Tlf Fijo">
            </div>

            <div id="div_numeroMovil">
                <label for="numeroMovil">tlf. móvil:</label>
                <select id="prefijo"></select>
                <input class="etiqueta s8" id="numeroMovil" name="numeroMovil" value="<%= session.getAttribute("numeroMovil") %>" type="tel" data-functioncallback="ValidacionExpresionRegular.validarNumeroMovil" size="20" required placeholder="longitud" title="">
            </div>

            <div id="div_clientSexo">
                <label class="labelInput" for="clientSexo">Sexo:</label>
                <select class="etiqueta s8 file" id="clientSexo" name="clientSexo" value="<%= session.getAttribute("clientSexo") %>" data-functioncallback="ValidarListaValores.validarSexo">
                    <option value="">-- Select Sexo --</option>
                    <option value="m">Hombre</option>
                    <option value="f">Mujer</option>
                </select>
            </div>

            <div id="div_emailCliente">
                <label for="emailCliente">Email:</label>
                <input class="etiqueta s8" id="emailCliente" name="emailCliente"  value="<%= session.getAttribute("emailCliente") %>"  type="email" data-functioncallback="ValidacionExpresionRegular.validarEmail" required placeholder="input your Email" title="Email">
            </div>

            <div id="div_clientUsuario">
                <label class="labelInput" for="clientUsuario">Usuario:</label>
                <input class="etiqueta s8" id="clientUsuario" name ="clientUsuario" value="<%= session.getAttribute("clientUsuario") %>" type="text" data-functioncallback="ValidacionExpresionRegular.validarUsuario" size="24" minlength="7" maxlength="7" required placeholder="input your User" title="3 to 50 characters">
            </div>

            <div id="div_password">
                <label for="password">Password:</label>
                <input class="etiqueta s8" id="password" name ="password" value="<%= session.getAttribute("password") %>" type="password" placeholder="Contraseña" data-functioncallback="ValidacionExpresionRegular.validarPassword">
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
<script src="../js/jsStore/prefijos.js"></script>
<script src="../js/jsStore/color.js"></script>
<script src="../js/jsStore/lista.js"></script>
<script src="../js/jsStore/file.js"></script>
<script src="../js/jsStore/error.js"></script>
<script src="../js/jsStore/submit.js"></script>
<script src="../js/jsStore/validate.js"></script>
<script src="../js/jsStore/init.js"></script>