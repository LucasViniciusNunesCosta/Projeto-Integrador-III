<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista do Estoque</title>
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
            <h3>Lista do Estoque</h3>
            <div class="BoxLista">
                <table class="ListaESTO">
                    <th>ID</th>
                    <th>Filial</th>
                    <th>Nome</th>
                    <th>Marca</th>
                    <th>Categoria</th>
                    <th>Quantidade</th>
                    <th>valor de compra</th>
                    <th>valor de venda</th>

                    <c:forEach items="${listaEstoque}" var="estoque">
                    <tr>
                        <td>${estoque.ID}</td>
                        <td>${estoque.filiaID}</td>
                        <td>${estoque.nome}</td>
                        <td>${estoque.marca}</td>
                        <td>${estoque.categoria}</td>
                        <td>${estoque.QTD}</td>
                        <td>${estoque.v_compra}</td>
                        <td>${estoque.v_venda}</td>
                        <c:if test="${acao.atua == true}">
                        <td><a href="AtualizarProduto?ID=${estoque.ID}">Atualizar</a></td>
                        </c:if>
                        <c:if test="${acao.excl == true}">
                        <td><a href="ExcluirProduto?ID=${estoque.ID}" class="btn_Excluir">Excluir</a></td>
                        </c:if>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
        
        <script>
            $("#simpleConfirm").confirm();
            $("#complexConfirm").confirm({
                title:"Delete confirmation",
                text: "This is very dangerous, you shouldn't do it! Are you really really sure?",
                confirm: function(button) {
                    button.fadeOut(2000).fadeIn(2000);
                    alert("You just confirmed.");
                },
                cancel: function(button) {
                    button.fadeOut(2000).fadeIn(2000);
                    alert("You aborted the operation.");
                },
                confirmButton: "Yes I am",
                cancelButton: "No"
            });
            $("#dataConfirm").confirm();
            $("#manualTrigger").click(function() {
                $.confirm({
                    text: "This is a confirmation dialog manually triggered! Please confirm:",
                    confirm: function() {
                        alert("You just confirmed.");
                    },
                    cancel: function() {
                        alert("You cancelled.");
                    }
                });
            });
            $("#noCancelButton").confirm({
                text: "This is a confirmation dialog manually triggered! Please confirm:",
                cancelButton: false,
                confirm: function() {
                    alert("You just confirmed.");
                }
            });
            $("#modalOptions").confirm({
                text: "You can't escape! You are forced to choose!",
                modalOptionsBackdrop: 'static',
                modalOptionsKeyboard: false,
                confirm: function() {
                    alert("You just confirmed.");
                },
                cancel: function() {
                    alert("You cancelled.");
                }
            });
        </script>

        <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
        <script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
        
    </body>
</html>