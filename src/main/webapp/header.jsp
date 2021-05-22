<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <header>
            <ul id="menu-h">
                <a href="http://localhost:8080/Projeto-Integrador-III/protegido/home.jsp" class="logo">
                    <img src="http://localhost:8080/Projeto-Integrador-III/img/Xgeek_branco.png" class="logo-img">
                </a>
                <c:if test="${not empty sessionScope.usuario}">
                    <li><a href="index.html">${sessionScope.usuario.nome}</a></li>
                </c:if>
                <c:if test="${not empty sessionScope.carrinho}">
                    <li><a href="http://localhost:8080/Projeto-Integrador-III/CarrinhoV">carrinho</a></li>
                </c:if>
                <li><a href="#">Sobre</a></li>
                <li><a href="#">Contato</a></li>
            </ul>
        </header>
    </body>
</html>
