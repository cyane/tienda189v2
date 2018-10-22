<%--
  Created by IntelliJ IDEA.
  User: Luciano
  Date: 21/10/2018
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form id="client_register" method="get" action="/valida">
      <input class="etiqueta s8"  name="clientFirstName" type="text" data-functioncallback="ValidacionExpresionRegular.validarLetrasSinEspacio" size="24" minlength="3" maxlength="80" required placeholder="input your FirstName" title="3 to 50 characters">
      <input type="submit" value="Submit">
    </form>
  </body>
</html>
