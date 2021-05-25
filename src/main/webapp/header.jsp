<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <header>
            <ul id="menu-h">
                <a href="/ProjetoIntegrador3-1.0-SNAPSHOT/protegido/home.jsp" class="logo">
                    <img src="img/Xgeek_branco.png" class="logo-img">
                </a>
                <c:if test="${not empty sessionScope.usuario}">
                    <li><a>${sessionScope.usuario.nome}</a>
                        <ul class="munu-use">
                            <li><a href="/Projeto-Integrador-III/LoginServlet">logoff</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${not empty sessionScope.carrinho}">
                    <li><a>carrinho</a>
                        <ul class="munu-carrio">
                            <li><a href="/ProjetoIntegrador3-1.0-SNAPSHOT/CarrinhoV">Items no carrinho</a></li>
                            <li><a href="/ProjetoIntegrador3-1.0-SNAPSHOT/protegido/Vendas/cadastrar.jsp">finalizar pedido</a></li>
                            <li><a href="/ProjetoIntegrador3-1.0-SNAPSHOT/CarrinhoV?canpedido=1">Cancelar pedido</a></li>
                        </ul>
                    </li>
                </c:if>
                <li><a href="/ProjetoIntegrador3-1.0-SNAPSHOT/Sobre.jsp">Sobre</a></li>
            </ul>
        </header>
    </body>
</html>
