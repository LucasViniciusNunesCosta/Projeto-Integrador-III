<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Home</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/main.css">
    </head>
    
    <body>
        
        <c:import url="../header.jsp"/>

        <section class="container">
            <c:if test="${sessionScope.usuario.isRH()}">
                <article>
                    <h3>Funcionarios</h3>
                    <div class="elemento">
                        <a class="btnFuncionarios" href="Funcionarios/CadastroFuncionarios.jsp">Cadastro</a>
                        <a class="btnFuncionarios" href="../FuncionarioServlet">Lista</a>
                        <a class="btnFuncionarios" href="../FuncionarioServlet?send=Atualizar">Atualizar</a>
                        <a class="btnFuncionarios" href="../FuncionarioServlet?send=Excluir">Excluir</a>
                    </div>
                </article>
            </c:if>
            <c:if test="${sessionScope.usuario.isADM()}">
                <article>
                    <h3>Filials</h3>
                    <div class="elemento">
                        <button class="btnFilials">Cadastro</button>
                        <button class="btnFilials">Atualização</button>
                        <button class="btnFilials">Lista</button>
                        <button class="btnFilials">Salário</button>
                    </div>
                </article>
            </c:if>
            <c:if test="${sessionScope.usuario.isGerente()}">
                <article>
                    <h3>Estoques</h3>
                    <div class="elemento">
                        <a class="btnEstoques" href="estoque/Cadastro.jsp">Cadastro</a>
                        <a class="btnEstoques" href="../listaEstoque">Lista</a>
                        <a class="btnEstoques" href="../listaEstoque?send=Atualizar">Atualizar</a>
                        <a class="btnEstoques" href="../listaEstoque?send=Excluir">Excluir</a>
                    </div>
                </article>
            </c:if>
            <c:if test="${sessionScope.usuario.isVendedor()}">
                <article>
                    <h3>Vendas</h3>
                    <div class="elemento">
                        <c:if test="${not empty sessionScope.carrinho}">
                        <a class="btnCompras" href="Vendas/cadastrar.jsp">Cadastro</a>
                        </c:if>
                        <a class="btnCompras" href="../listaEstoque?ID=${sessionScope.usuario.filialId}">Adicionar ao carrinho</a>
                    </div>
                </article>
            </c:if>
            <c:if test="${sessionScope.usuario.isVendedor()}">
                <article>
                    <h3>Cliente</h3>
                    <div class="elemento">
                        <a class="btnCliente" href="clientes/cadastro.jsp">Cadastro</a>
                        <a class="btnCliente" href="../listaClientes">Lista</a>
                        <a class="btnCliente" href="../listaClientes?send=Atualizar">Atualizar</a>
                        <a class="btnCliente" href="../listaClientes?send=Excluir">Excluir</a>
                    </div>
                </article>
            </c:if>
            <c:if test="${sessionScope.usuario.isGerente()}">
                <article>
                    <h3>Ralatorios</h3>
                    <div class="elemento">
                        <a class="btnCliente" href="Relatorio/Cliente/Clientes.jsp">Por Cliente</a>
                        <a class="btnCliente" href="Relatorio/Filial/filial.jsp">Por Filial</a>
                    </div>
                </article>
            </c:if>
        </section>

    </body>
</html>