<%--
  Created by IntelliJ IDEA.
  User: Luciano
  Date: 06/11/2017
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <title>Login usuarios</title>
</head>
<body>
<div class="container">
    <div class="col-md-offset-3 col-md-6">
        <h1>Formularios con Java Servlets</h1>
        <hr />

        <c:if test="${not empty error}">
        <div class="alert alert-danger">
                ${error}
        </div>
    </c:if>

        <form role="form" method="post" action="/test">
            <div class="form-group">
                <label for="action">Action</label>
                <input type="text" class="form-control" name="action"
                       placeholder="Introduce tu include/forward">
            </div>

            <button type="submit" class="btn btn-success btn-block">Login</button>
        </form>
    </div>
</div>
</body>
</html>
</html>
