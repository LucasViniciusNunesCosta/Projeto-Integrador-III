<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ralatorio Cliente</title>
        
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        
        <c:import url="../../header.jsp"/>
        
        <form class="lista">
            <h3>Ralatorio do Cliente de ${periodo.data_inicio} a ${periodo.data_fim}</h3>
            <div class="BoxLista">
                <table>
                    <th>ID Pedido</th>
                    <th>Data da compra</th>
                    <th>produto</th>
                    <th>Categoria</th>
                    <th>quantidade</th>
                    <th>valor do pedido</th>
                    <th>endereço</th>
                    <c:forEach items="${listaPedidos}" var="relatorio">
                    <tr>
                        <td>${relatorio.ID_PED}</td>
                        <td>${relatorio.Data_cri}</td>
                        <td>${relatorio.Nome_Pro}</td>
                        <td>${relatorio.Categoria}</td>
                        <td>${relatorio.QTD}</td>
                        <td>${relatorio.V_tatal}</td>
                        <td>${relatorio.Endreco}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
        
    </body>
</html>
