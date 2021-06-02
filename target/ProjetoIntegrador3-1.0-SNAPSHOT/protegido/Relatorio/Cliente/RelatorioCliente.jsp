<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ralatorio Cliente</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/main.css">
        <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
    </head>
    <body>
        
        <c:import url="../../../header.jsp"/>
        
        <section class="lista">
            <h3>Ralatorio pro Cliente de ${periodo.data_inicio} a ${periodo.data_fim}</h3>
            <div class="BoxLista">
                <table>
                    <th>ID Cliente</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>valor total nesse período</th>
                    <c:forEach items="${listaClientes}" var="venda">
                    <tr>
                        <td>${venda.ID_Cliente}</td>
                        <td>${venda.nome}</td>
                        <td>${venda.CPF}</td>
                        <td>R$${venda.vendaTotal}</td>
                        <td><a class="redirect" href="RelatorioClientes?Cliente=${venda.ID_Cliente},${periodo.data_inicio},${periodo.data_fim}">Detalhes</a></td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
        
    </body>
</html>
