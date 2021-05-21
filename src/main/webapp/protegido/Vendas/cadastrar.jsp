<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:if test="${empty produto}">
            <link rel="stylesheet" href="../css/main.css">
            <title>Cadastro de Venda</title>
        </c:if>
    </head>
    
    <body>
        <header>
            <ul id="menu-h">
                <a href="home.html" class="logo">
                <c:if test="${empty produto}"><img src="../img/Xgeek_branco.png" class="logo-img"></c:if>
                </a>
                <li><a href="index.html">Entrar</a></li>
                <li><a href="#">Sobre</a></li>
                <li><a href="#">Contato</a></li>
            </ul>
        </header>
        
        <c:if test="${empty venda}">
            <form action="../CadastrarVendaServlet" method="POST"ubunto class="CadaEst">
                <h3>Cadastro de Vendas</h3>
                <div class="textsbox inputs">
                    <div>
                        <label>Nome do Produto</label>
                        <input class="textsize" type="text" name="NomeProduto" placeholder="Nome do Produto" required="true">
                    </div><div>
                        <label>Marca</label>
                        <input class="textsize" type="text" name="Marca" placeholder="Marca" required="true">
                    </div><div>
                        <label>Categoria</label>
                        <input class="textsize" type="text" name="Categoria" placeholder="Categoria" required="true">
                    </div><div>
                        <label>Quatidade</label>
                        <input class="textsize" type="text" name="Quatidade" placeholder="Quatidade" required="true">
                    </div><div>
                        <label>Valor de venda</label>
                        <input class="textsize" type="text" name="Valor_venda" placeholder="Valor de venda" required="true">
                    </div><div>
                        <label>Id do Cliente</label>
                        <input class="textsize" type="text" name="Cliente" placeholder="Id do Cliente" required="true">
                    </div><div>
                        <label>Id do Vendedor</label>
                        <input class="textsize" type="text" name="Vendedor" placeholder="Id do Vendedor" required="true">
                    </div>
                    <div>
                        <label>Id da Filial</label>
                        <input type="text" name="Filial" placeholder="Id da Filial" required="true">
                    </div>
                </div>
                <button type="submit" class="btn_exe btnCompras">Cadastrar</button>
            </form>
        </c:if>
    </body>
</html>