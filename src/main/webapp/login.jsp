<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>login</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <c:import url="header.jsp"/>
        
        <form action="LoginServlet" method="POST" class="login">
            <h3>Login</h3>
            <div class="textsbox">
                <input class="txtlol" type="email" name="email" placeholder="E-mail" required="true">
                <input class="txtlol" type="password" autocomplete="off" name="senha" placeholder="Senha" required="true">
            </div>
            <button type="submit">Entra</button>
            <a class="redirect redirect-M" href="suporte/RecuperarSenha.jsp">sequeci a senha</a>
        </form>
        
    </body>
</html>
