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
                    <li><a>${sessionScope.usuario.nome}</a>
                        <ul class="munu-use">
                            <li><a href="http://localhost:8080/Projeto-Integrador-III/LoginServlet">logoff</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${not empty sessionScope.carrinho}">
                    <li><a href="http://localhost:8080/Projeto-Integrador-III/LoginServlet">carrinho</a>
                        <ul class="munu-carrio">
                            <li><a>finalizar pedido</a></li>
                            <li><a href="http://localhost:8080/Projeto-Integrador-III/CarrinhoV?canpedido=1">Cancelar pedido</a></li>
                        </ul>
                    </li>
                </c:if>
                <li><a href="#">Sobre</a></li>
                <li><a href="#">Contato</a></li>
            </ul>
        </header>
    </body>
</html>
