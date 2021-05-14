<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
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
            <div class="textsbox inputs">
                <div>
                    <label>Nome</label>
                    <input type="text" name="Nome" placeholder="Nome" required="true">
                </div><div>
                    <label>Marca</label>
                    <input type="text" name="Marca" placeholder="Marca" required="true">
                </div><div>
                    <label>Categoria</label>
                    <input type="text" name="Categoria" placeholder="Categoria" required="true">
                </div><div>
                    <label>Quatidade</label>
                    <input type="number" name="Quatidade" placeholder="Quatidade" required="true">
                </div><div>
                    <label>Valor de compra</label>
                    <input type="number" step="0.01" name="Valor_compra" placeholder="Valor de compra" required="true">
                </div><div>
                    <label>Valor de venda</label>
                    <input type="number" step="0.01" name="Valor_venda" placeholder="Valor de venda" required="true">
                </div><div>
                    <label>Filial</label>
                    <input type="number" name="Filial" placeholder="Filial" required="true">
                </div>
            </div>
            <button type="submit" class="btn_exe btnEstoques">Cadastro</button>
        </form>
        </c:if>
        <c:if test="${not empty produto}">
        <form action="AtualizarProduto" method="POST"ubunto class="CadaEst">
            <h3>Atualização do Produto</h3>
            <div class="textsbox inputs">
                <div>
                    <label>Nome</label>
                    <input type="text" name="Nome" placeholder="Nome" required="true" value="${produto.nome}">
                </div><div>
                    <label>Marca</label>
                    <input type="text" name="Marca" placeholder="Marca" required="true" value="${produto.marca}">
                </div><div>
                    <label>Categoria</label>
                    <input type="text" name="Categoria" placeholder="Categoria" required="true" value="${produto.categoria}">
                </div><div>
                    <label>Quatidade</label>
                    <input type="text" name="Quatidade" placeholder="Quatidade" required="true" value="${produto.QTD}">
                </div><div>
                    <label>Valor de compra</label>
                    <input type="text" name="Valor_compra" placeholder="Valor de compra" required="true" value="${produto.v_compra}">
                </div><div>
                    <label>Valor de venda</label>
                    <input type="text" name="Valor_venda" placeholder="Valor de venda" required="true" value="${produto.v_venda}">
                </div><div>
                    <label>Filial</label>
                    <input type="text" name="Filial" placeholder="Filial" required="true" value="${produto.filiaID}">
                </div><div>
                    <label>ID_Produto</label>
                    <input type="text" name="ID_Produto" value="${produto.ID}" readonly>
                </div>
            </div>
            <button type="submit" class="btn_exe btnEstoques">Atualizar</button>
        </form>
        </c:if>
    </body>
</html>
