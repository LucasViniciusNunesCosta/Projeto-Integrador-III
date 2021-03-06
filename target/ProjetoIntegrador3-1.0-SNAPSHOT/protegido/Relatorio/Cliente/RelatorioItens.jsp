<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ralatorio Cliente</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/main.css">
        <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
    </head>
    <body>
        
        <c:import url="../../../header.jsp"/>
        
        <c:if test="${empty listaPedido}">
        <section class="lista">
            <h3>Ralatorio do Cliente de ${periodo.data_inicio} a ${periodo.data_fim}</h3>
            <div class="BoxLista">
                <table>
                    <th>ID Pedido</th>
                    <th>Data da compra</th>
                    <th>valor do pedido</th>
                    <th>endereço</th>
                    <c:forEach items="${listaPedidos}" var="relatorio">
                    <tr>
                        <td>${relatorio.ID_PED}</td>
                        <td>${relatorio.data_cri}</td>
                        <td>R$${relatorio.v_tatal}</td>
                        <td>${relatorio.endreco}</td>
                        <td><a class="redirect" href="RelatorioClientes?Pedido=${relatorio.ID_PED},${periodo.data_inicio},${periodo.data_fim}">Detalhes</a></td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
        </c:if>
        <c:if test="${not empty listaPedido}">
        <section class="lista">
            <h3>Ralatorio do Pedido de ${periodo.data_inicio} a ${periodo.data_fim}</h3>
            <div class="BoxLista">
                <table>
                    <th>Nome do produto</th>
                    <th>Marca</th>
                    <th>Categoria</th>
                    <th>Quantidade</th>
                    <th>valor de venda</th>
                    <th>Desconto</th>
                    <c:forEach items="${listaPedido}" var="relatorio">
                    <tr>
                        <td>${relatorio.nome}</td>
                        <td>${relatorio.marca}</td>
                        <td>${relatorio.categoria}</td>
                        <td>${relatorio.QTD}</td>
                        <td>R$${relatorio.v_tatal}</td>
                        <td>%${relatorio.desconto}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
        </c:if>
        
    </body>
</html>
