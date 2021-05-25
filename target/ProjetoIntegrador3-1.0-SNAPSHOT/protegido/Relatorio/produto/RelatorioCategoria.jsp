<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio Produto</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        
        <c:import url="../../../header.jsp"/>
        <section class="lista">
            <h3>Ralatorio pro Categoria de ${periodo.data_inicio} a ${periodo.data_fim}</h3>
            <div class="BoxLista">
                <table>
                    <th>Categoria</th>
                    <th>Quantidade</th>
                    <th>Valor total vendido</th>
                    <c:forEach items="${listaProdutos}" var="relatorio">
                    <tr>
                        <td>${relatorio.categoria}</td>
                        <td>${relatorio.QTD}</td>
                        <td>R$${relatorio.v_tatal}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
    </body>
</html>