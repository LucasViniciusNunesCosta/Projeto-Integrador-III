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
                        <a class="btnG1" href="../listeFuncionario">Lista</a>
                        <a class="btnG1" href="../listeFuncionario?send=Atualizar">Atualizar</a>
                        <a class="btnG1" href="../listeFuncionario?send=Excluir">Excluir</a>
                    </div>
                </article>
            </c:if>
            <c:if test="${sessionScope.usuario.isADM()}">
                <article>
                    <h3>Filiais</h3>
                    <div class="elemento">
                        <a class="btnG2" href="Filial/CadastroFilial.jsp">Cadastro</a>
                        <a class="btnG2" href="../listeFilial">Lista</a>
                        <a class="btnG2" href="../listeFilial?send=Atualizar">Atualizar</a>
                        <a class="btnG2" href="../listeFilial?send=Excluir">Excluir</a>
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
                        <c:if test="${sessionScope.usuario.isADM()}">
                            <a class="btnG3" href="../listaEstoque?send=Excluir">Excluir</a>
                        </c:if>
                    </div>
                </article>
            </c:if>
            <c:if test="${sessionScope.usuario.isVendedor()}">
                <article>
                    <h3>Vendas</h3>
                    <div class="elemento">
                        <c:if test="${not empty sessionScope.carrinho}">
                        <a class="btnG4" href="Vendas/cadastrar.jsp">Finalizar pedido</a>
                        </c:if>
                        <a class="btnG4" href="../listaEstoque?ID=${sessionScope.usuario.ID_Filial}">Adicionar ao carrinho</a>
                        <a class="btnG4" href="../listaVendas">Vendas</a>
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
                        <c:if test="${sessionScope.usuario.isADM()}">
                            <a class="btnG5" href="../listaClientes?send=Excluir">Excluir</a>
                        </c:if>
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
            <article>
                <h3>Suporte</h3>
                <div class="elemento">
                    <a class="btnG7" href="suporte/CentralAtendimentoTI.jsp">Central de atendimento</a>
                    <a class="btnG7" href="../Suporte?minha=${sessionScope.usuario.ID}">Minhas solicitações</a>
                    <c:if test="${sessionScope.usuario.isSuporte()}">
                        <a class="btnG7" href="../Suporte?send=Responder">Solicitações</a>
                    </c:if>
                </div>
            </article>
        </section>
    </body>
</html>