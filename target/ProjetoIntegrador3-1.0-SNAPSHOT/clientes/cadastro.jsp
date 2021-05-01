<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Cadastro de Cliente</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:if test="${empty cliente}"><link rel="stylesheet" href="../css/main.css"></c:if>
        <c:if test="${not empty cliente}"><link rel="stylesheet" href="css/main.css"></c:if>
        
    </head>
    <body>
        <header>
            <ul id="menu-h">
                <a href="home.html" class="logo">
                <c:if test="${empty cliente}"><img src="../img/Xgeek_branco.png" class="logo-img"></c:if>
                <c:if test="${not empty cliente}"><img src="img/Xgeek_branco.png" class="logo-img"></c:if>
                </a>
                <li><a href="index.html">Entrar</a></li>
                <li><a href="#">Sobre</a></li>
                <li><a href="#">Contato</a></li>
            </ul>
        </header>
        
        <c:if test="${empty cliente}">
            <form action="../CadastrarCliente" method="POST"ubunto class="CadaCli">
            <h3>Cadastro de Cliente</h3>
            <input type="text" name="CPF" placeholder="CPF" required="true">
            <input type="text" name="Nome" placeholder="Nome">
            <button type="submit" class="btn_exe">Cadastro</button>
            </form>
        </c:if>
        
        <c:if test="${not empty cliente}">
            <form action="AtualizarCliente" method="POST"ubunto class="CadaCli">
            <h3>Atualização de Cliente</h3>
            <input type="text" name="ID" placeholder="ID" value="${cliente.ID}" disabled="">
            <input type="text" name="CPF" placeholder="CPF" value="${cliente.CPF}" required="true">
            <input type="text" name="Nome" placeholder="Nome" value="${cliente.nome}">
            <button type="submit" class="btn_exe">Atualizar</button>
            </form>
        </c:if>
        
    </body>
</html>
