<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/main.css">
        <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        <section class="lista">
            <h3>Adicionar ao carrinho</h3>
            <div class="BoxLista">
                <table class="ListaESTO">
                    <th>ID</th>
                    <th>CPF</th>
                    <th>Data</th>
                    <th>Funcionário</th>
                    <th>Valor total</th>
                    <c:forEach items="${vendas}" var="vendas">
                    <tr>
                        <td>${vendas.ID_Compra}</td>
                        <td>${vendas.CPF}</td>
                        <td>${vendas.data}</td>
                        <td>${vendas.nome}</td>
                        <td>R$${vendas.vendaTotal}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
    </body>
</html>
