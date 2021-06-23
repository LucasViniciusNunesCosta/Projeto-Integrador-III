<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <c:import url="header.jsp"/>
        <form action="LoginServlet" method="POST" class="login">
            <h3>Login</h3>
            <div class="textsbox">
                <input class="txtlol text-MB" type="email" name="email" placeholder="E-mail" required="true">
                <input class="txtlol text-MB" type="password" autocomplete="off" name="senha" placeholder="Senha" required="true">
            </div>
            <button type="submit">Entra</button>
            <a class="redirect redirect-M" href="suporte/RecuperarSenha.jsp">sequeci a senha</a>
        </form>
    </body>
</html>
