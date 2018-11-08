<%--
  Created by IntelliJ IDEA.
  User: Luciano
  Date: 06/11/2018
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form enctype="multipart/form-data" id="client_register" method="POST" action="#">
        <div class="menu s3 caja03">
            <h4>New Client</h4>
        </div>
       <div id="div_dniCliente">
            <label for="dniCliente">dni:</label>
            <input class="etiqueta s8" id="dniCliente" name = "dniCliente" value="<%= session.getAttribute("dniCliente") %>" type="text" data-functioncallback="ValidacionExpresionRegular.validarDniNieCif" required placeholder="input your dni" title="dni">
       </div>

     <button id="submit" type="submit">Enviar</button>
</form>

</body>
</html>
<script>

   if(document.getElementById("dniCliente").value == "null")
           alert("es NULO");
    else alert("<> NULO");
</script>
