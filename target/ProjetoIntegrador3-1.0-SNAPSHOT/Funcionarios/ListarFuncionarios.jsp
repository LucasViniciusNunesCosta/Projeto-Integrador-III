<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Funcionários</title>
        <link rel="stylesheet" href="css/main.css">

        <link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script src="js/jquery.confirm.js"></script>
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
            <h3>Lista de Funcionários</h3>
            <div class="BoxLista">
                <table>
                    <th>#</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Email</th>
                    <th>Atuação</th>
                    <th>Salário</th>
                    <c:forEach items="${listaFuncionarios}" var="funcionario">
                    <tr>
                        <td>${funcionario.id}</td>
                        <td>${funcionario.nome}</td>
                        <td>${funcionario.cpf}</td>
                        <td>${funcionario.email}</td>
                        <td>${funcionario.atuacao}</td>
                        <td>R$ - ${funcionario.salario}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
        
    </body>
</html>
