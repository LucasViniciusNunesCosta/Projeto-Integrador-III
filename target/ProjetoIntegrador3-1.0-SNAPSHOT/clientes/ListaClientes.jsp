<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <header>
            <ul id="menu-h">
                <a href="home.html" class="logo">
                    <img src="img/Xgeek_branco.png" class="logo-img">
                </a>
                <li><a href="index.html">Entrar</a></li>
                <li><a href="#">Sobre</a></li>
                <li><a href="#">Contato</a></li>
            </ul>
        </header>
        
        
        <form class="lista">
            <h3>Lista de Clientes</h3>
            <table>
                <th>ID</th>
                <th>Nome</th>
                <th>CPF</th>
                <c:forEach items="${listaClientes}" var="cliente">
                <tr>
                    <td>${cliente.ID}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.CPF}</td>
                    <td><a href="AtualizarCliente?ID=${cliente.ID}">Atualizar</a></td>
                    <td><a href="ExcluirCliente?ID=${cliente.ID}" class="btn_Excluir">Excluir</a></td>
                </tr>
                </c:forEach>
            </table>
        </form>
        
    </body>
</html>
