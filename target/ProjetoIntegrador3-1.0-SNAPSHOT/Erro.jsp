<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Error</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <c:import url="header.jsp"/>
        <div class="messagebox">
            <h1 style="color: red;">Ops, algo due errado!</h1><br>
            <p>${msgErro}</p>
        </div>
    </body>
</html>
