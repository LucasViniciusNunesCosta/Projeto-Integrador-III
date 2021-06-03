<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="../img/Xgeek-Icone.ico" type="image/x-icon">
        <link rel="stylesheet" href="../css/main.css">
    </head>
    
    <body>
        
        <c:import url="../header.jsp"/>

        <section class="container">
            <c:if test="${sessionScope.usuario.isRH()}">
                <article>
                    <h3>Funcionarios</h3>
                    <div class="elemento">
                        <a class="btnG1" href="Funcionarios/CadastroFuncionarios.jsp">Cadastro</a>
                        <a class="btnG1" href="../FuncionarioServlet">Lista</a>
                        <a class="btnG1" href="../FuncionarioServlet?send=Atualizar">Atualizar</a>
                        <a class="btnG1" href="../FuncionarioServlet?send=Excluir">Excluir</a>
                    </div>
                </article>
            </c:if>
            <c:if test="${sessionScope.usuario.isADM()}">
                <article>
                    <h3>Filials</h3>
                    <p style="text-align: center; font-size: 30px; color: white;">🚧 Em construção 🚧</p>
                    <div class="elemento">
                    </div>
                </article>
            </c:if>
            <c:if test="${sessionScope.usuario.isGerente()}">
                <article>
                    <h3>Estoques</h3>
                    <div class="elemento">
                        <a class="btnG3" href="estoque/Cadastro.jsp">Cadastro</a>
                        <a class="btnG3" href="../listaEstoque">Lista</a>
                        <a class="btnG3" href="../listaEstoque?send=Atualizar">Atualizar</a>
                        <a class="btnG3" href="../listaEstoque?send=Excluir">Excluir</a>
                    </div>
                </article>
            </c:if>
            <c:if test="${sessionScope.usuario.isVendedor()}">
                <article>
                    <h3>Vendas</h3>
                    <div class="elemento">
                        <c:if test="${not empty sessionScope.carrinho}">
                        <a class="btnG4" href="Vendas/cadastrar.jsp">Cadastro</a>
                        </c:if>
                        <a class="btnG4" href="../listaEstoque?ID=${sessionScope.usuario.filialId}">Adicionar ao carrinho</a>
                    </div>
                </article>
            </c:if>
            <c:if test="${sessionScope.usuario.isVendedor()}">
                <article>
                    <h3>Cliente</h3>
                    <div class="elemento">
                        <a class="btnG5" href="clientes/cadastro.jsp">Cadastro</a>
                        <a class="btnG5" href="../listaClientes">Lista</a>
                        <a class="btnG5" href="../listaClientes?send=Atualizar">Atualizar</a>
                        <a class="btnG5" href="../listaClientes?send=Excluir">Excluir</a>
                    </div>
                </article>
            </c:if>
            <c:if test="${sessionScope.usuario.isGerente()}">
                <article>
                    <h3>Ralatorios</h3>
                    <div class="elemento">
                        <a class="btnG6" href="Relatorio/Cliente/Clientes.jsp">Por Cliente</a>
                        <a class="btnG6" href="Relatorio/produto/Produto.jsp">Por Produto</a>
                        <a class="btnG6" href="Relatorio/Filial/filial.jsp">Por Filial</a>
                    </div>
                </article>
            </c:if>
        </section>

    </body>
</html>