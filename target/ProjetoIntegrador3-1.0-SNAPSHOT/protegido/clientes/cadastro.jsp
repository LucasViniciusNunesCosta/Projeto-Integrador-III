<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:if test="${empty cliente}">
            <link rel="stylesheet" href="../../css/main.css">
            <link rel="shortcut icon" href="../../img/Xgeek-Icone.ico" type="image/x-icon">
            <title>Cadastro de Cliente</title>
        </c:if>
        <c:if test="${not empty cliente}">
            <link rel="stylesheet" href="css/main.css">
            <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
            <title>Atualização do Cliente</title>
        </c:if>
    </head>
    
    <body>
        <c:import url="../../header.jsp"/>
        
        <c:if test="${empty cliente}">
            <form action="../../CadastrarCliente" method="POST" class="CadaCli">
                <h3>Cadastro de Cliente</h3>
                <div class="textsbox inputs">
                    <div>
                        <label>Nome</label>
                        <input class="textsize" type="text" name="Nome" placeholder="Nome">
                    </div><div>
                        <label>CPF</label>
                        <input class="textsize" type="text" name="CPF" placeholder="CPF" required="true">
                    </div>
                </div>
                <button type="submit" class="btn_exe btnG5">Cadastro</button>
            </form>
        </c:if>
        
        <c:if test="${not empty cliente}">
            <form action="AtualizarCliente" method="POST" class="CadaCli">
                <h3>Atualização do Cliente</h3>
                <input type="hidden" name="ID" value="${cliente.ID_Cliente}">
                <div class="textsbox">
                    <label>Nome</label>
                    <input class="textsize" type="text" name="Nome" placeholder="Nome" value="${cliente.nome}">
                    <label>CPF</label>
                    <input class="textsize" type="text" name="CPF" placeholder="CPF" value="${cliente.CPF}" required="true">
                </div>
                <button type="submit" class="btn_exe btnG5">Atualizar</button>
            </form>
        </c:if>
        
    </body>
</html>
