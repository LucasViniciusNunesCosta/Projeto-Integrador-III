<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <header>
            <nav class="nav">
                <a href="/protegido/home.jsp" class="logo">
                    <img src="/img/Xgeek_branco.png" class="logo-img">
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
                                <li><a href="/AtualizarFuncionarioDados?ID=${sessionScope.usuario.ID}">Seu Dados</a></li>
                                <li><a href="/protegido/Funcionarios/FuncionarioSenha.jsp">Alterar Senha</a></li>
                                <li><a href="/LoginServlet">Logoff</a></li>
                            </ul>
                        </li>
                        <c:if test="${not empty sessionScope.carrinho}">
                            <li class="LiCar"><a>Carrinho</a>
                                <ul class="munu-carrio">
                                    <li><a href="/CarrinhoV">Items no carrinho</a></li>
                                    <li><a href="/protegido/Vendas/cadastrar.jsp">Finalizar pedido</a></li>
                                    <li><a href="/CarrinhoV">Cancelar pedido</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <li><a href="/protegido/suporte/CentralAtendimentoTI.jsp">Suporte</a></li>
                    </c:if>
                    <li><a href="/Sobre.jsp">Sobre</a></li>
                </ul>
                <script src="/js/mobile-navbar.js" type="text/javascript"></script>
            </nav>
        </header>
    </body>
</html>