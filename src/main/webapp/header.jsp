<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <header>
            <nav class="nav">
                <a href="/Projeto-Integrador-III/protegido/home.jsp" class="logo">
                    <img src="/Projeto-Integrador-III/img/Xgeek_branco.png" class="logo-img">
                </a>
                <div class="mobile-menu">
                    <div class="line1"></div>
                    <div class="line2"></div>
                    <div class="line3"></div>
                </div>
                <ul class="menu-h">
                    <c:if test="${not empty sessionScope.usuario}">
                        <li class="LiUsu"><a>${sessionScope.usuario.nome}</a>
                            <ul class="munu-use">
                                <li><a href="/Projeto-Integrador-III/protegido/suporte/CentralAtendimentoTI.jsp">Suporte</a></li>
                                <li><a href="/Projeto-Integrador-III/LoginServlet">Logoff</a></li>
                            </ul>
                        </li>
                        <c:if test="${not empty sessionScope.carrinho}">
                            <li class="LiCar"><a>carrinho</a>
                                <ul class="munu-carrio">
                                    <li><a href="/Projeto-Integrador-III/CarrinhoV">Items no carrinho</a></li>
                                    <li><a href="/Projeto-Integrador-III/protegido/Vendas/cadastrar.jsp">Finalizar pedido</a></li>
                                    <li><a href="/Projeto-Integrador-III/CarrinhoV">Cancelar pedido</a></li>
                                </ul>
                            </li>
                        </c:if>
                    </c:if>
                    <li><a href="/Projeto-Integrador-III/Sobre.jsp">Sobre</a></li>
                </ul>
                
                <script src="/Projeto-Integrador-III/js/mobile-navbar.js" type="text/javascript"></script>
            </nav>
        </header>
    </body>
</html>
