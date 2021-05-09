<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:if test="${empty produto}">
            <link rel="stylesheet" href="../css/main.css">
            <title>Cadastro de Produto</title>
        </c:if>
        <c:if test="${not empty produto}">
            <link rel="stylesheet" href="css/main.css">
            <title>Atualização de Produto</title>
        </c:if>
    </head>
    
    <body>
        <header>
            <ul id="menu-h">
                <a href="home.html" class="logo">
                <c:if test="${empty produto}"><img src="../img/Xgeek_branco.png" class="logo-img"></c:if>
                <c:if test="${not empty produto}"><img src="img/Xgeek_branco.png" class="logo-img"></c:if>
                </a>
                <li><a href="index.html">Entrar</a></li>
                <li><a href="#">Sobre</a></li>
                <li><a href="#">Contato</a></li>
            </ul>
        </header>
        
        <c:if test="${empty produto}">
        <form action="../CadastrarProduto" method="POST"ubunto class="CadaEst">
            <h3>Cadastro de Produto</h3>
            <div class="textsbox">
                <input type="text" name="Nome" placeholder="Nome" required="true">
                <input type="text" name="Marca" placeholder="Marca" required="true">
                <input type="text" name="Categoria" placeholder="Categoria" required="true">
                <input type="text" name="Quatidade" placeholder="Quatidade" required="true">
                <input type="text" name="Valor_compra" placeholder="Valor de compra" required="true">
                <input type="text" name="Valor_venda" placeholder="Valor de venda" required="true">
                <input type="text" name="Filial" placeholder="Filial" required="true">
            </div>
            <button type="submit" class="btn_exe btnEstoques">Cadastro</button>
        </form>
        </c:if>
        <c:if test="${not empty produto}">
        <form action="AtualizarProduto" method="POST"ubunto class="CadaEst">
            <h3>Atualização do Produto</h3>
            <div class="textsbox">
                <input type="text" name="Nome" placeholder="Nome" required="true" value="${produto.nome}">
                <input type="text" name="Marca" placeholder="Marca" required="true" value="${produto.marca}">
                <input type="text" name="Categoria" placeholder="Categoria" required="true" value="${produto.categoria}">
                <input type="text" name="Quatidade" placeholder="Quatidade" required="true" value="${produto.QTD}">
                <input type="text" name="Valor_compra" placeholder="Valor de compra" required="true" value="${produto.v_compra}">
                <input type="text" name="Valor_venda" placeholder="Valor de venda" required="true" value="${produto.v_venda}">
                <input type="text" name="Filial" placeholder="Filial" required="true" value="${produto.filiaID}">
                <input type="text" name="ID_Produto" value="${produto.ID}" readonly>
            </div>
            <button type="submit" class="btn_exe btnEstoques">Atualizar</button>
        </form>
        </c:if>
    </body>
</html>
