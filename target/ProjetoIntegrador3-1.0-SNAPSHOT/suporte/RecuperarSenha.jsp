<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Recuperar de Senha</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/main.css">
    <body>
        <c:import url="../header.jsp"/>
        <form action="" class="login">
            <h3>Recuperação de senha</h3>
            <input type="email" name="email" placeholder="E-mail">
            <button type="submit" name="entra">Recupeira</button>
        </form>
    </body>
</html>
