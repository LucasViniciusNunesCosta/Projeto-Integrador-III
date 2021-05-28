<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>sucesso</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <c:import url="header.jsp"/>
        <div class="messagebox">
            <h1>Operação realizada com sucesso</h1>
            <a class="redirect redirect-R" href="protegido/home.jsp">Voltar</a>
        </div>
    </body>
</html>