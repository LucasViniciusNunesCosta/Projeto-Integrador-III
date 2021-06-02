<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">
        <c:if test="${empty produto}">
            <link rel="stylesheet" href="../../css/main.css">
            <link rel="shortcut icon" href="../../img/Xgeek-Icone.ico" type="image/x-icon">
            <title>Cadastro de Produto</title>
        </c:if>
        <c:if test="${not empty produto}">
            <link rel="stylesheet" href="css/main.css">
            <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
            <title>Atualização de Produto</title>
        </c:if>
    </head>
    
    <body>
        <c:import url="../../header.jsp"/>
        
        <c:if test="${empty produto}">
        <form action="../../CadastrarProduto" method="POST" class="CadaEst">
            <h3>Cadastro de Produto</h3>
            <div class="textsbox inputs">
                <div>
                    <label>Nome</label>
                    <input class="textsize" type="text" name="Nome" placeholder="Nome" required="true">
                </div><div>
                    <label>Marca</label>
                    <input class="textsize" type="text" name="Marca" placeholder="Marca" required="true">
                </div><div>
                    <label>Categoria</label>
                    <input class="textsize" type="text" name="Categoria" placeholder="Categoria" required="true">
                </div><div>
                    <label>Quatidade</label>
                    <input class="textsize" type="number" name="Quatidade" placeholder="Quatidade" required="true">
                </div><div>
                    <label>Valor de compra</label>
                    <input class="textsize" type="number" step="0.01" name="Valor_compra" placeholder="Valor de compra" required="true">
                </div><div>
                    <label>Valor de venda</label>
                    <input class="textsize" type="number" step="0.01" name="Valor_venda" placeholder="Valor de venda" required="true">
                </div><div>
                    <label>Filial</label>
                    <input class="textsize" type="number" name="Filial" placeholder="Filial" required="true" value="${sessionScope.usuario.filialId}">
                </div>
            </div>
            <button type="submit" class="btn_exe btnG3">Cadastro</button>
        </form>
        </c:if>
        <c:if test="${not empty produto}">
        <form action="AtualizarProduto" method="POST"ubunto class="CadaEst">
            <h3>Atualização do Produto</h3>
            <input type="hidden" name="ID_Produto" value="${produto.ID}">
            <div class="textsbox inputs">
                <div>
                    <label>Nome</label>
                    <input class="textsize" type="text" name="Nome" placeholder="Nome" required="true" value="${produto.nome}">
                </div><div>
                    <label>Marca</label>
                    <input class="textsize" type="text" name="Marca" placeholder="Marca" required="true" value="${produto.marca}">
                </div><div>
                    <label>Categoria</label>
                    <input class="textsize" type="text" name="Categoria" placeholder="Categoria" required="true" value="${produto.categoria}">
                </div><div>
                    <label>Quatidade</label>
                    <input class="textsize" type="text" name="Quatidade" placeholder="Quatidade" required="true" value="${produto.QTD}">
                </div><div>
                    <label>Valor de compra</label>
                    <input class="textsize" type="text" name="Valor_compra" placeholder="Valor de compra" required="true" value="${produto.v_compra}">
                </div><div>
                    <label>Valor de venda</label>
                    <input class="textsize" type="text" name="Valor_venda" placeholder="Valor de venda" required="true" value="${produto.v_venda}">
                </div><div>
                    <label>Filial</label>
                    <input class="textsize" type="text" name="Filial" placeholder="Filial" required="true" value="${produto.filiaID}">
                </div>
            </div>
            <button type="submit" class="btn_exe btnG3">Atualizar</button>
        </form>
        </c:if>
    </body>
</html>
