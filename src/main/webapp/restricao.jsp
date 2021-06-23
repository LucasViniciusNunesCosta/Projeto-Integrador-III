<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Área Restrita</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <c:import url="header.jsp"/>
        <div class="messagebox">
            <h1>Área Restrita</h1><br>
            <p>${msgRestrita}</p>
            <a class="redirect redirect-R" href="protegido/home.jsp">Voltar</a>
        </div>
    </body>
</html>
