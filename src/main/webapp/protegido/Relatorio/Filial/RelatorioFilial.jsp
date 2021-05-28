<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ralatorio por Filial</title>
        
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/main.css">
        <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
    </head>
    <body>
        <c:import url="../../../header.jsp"/>
        
        <c:if test="${empty listaPorFilialID}">
        <section class="lista">
            <h3>Ralatorio por Filial de ${periodo.data_inicio} a ${periodo.data_fim}</h3>
            <div class="BoxLista">
                <table>
                    <th>ID Filial</th>
                    <th>Cidadel</th>
                    <th>Estado</th>
                    <th>Endereco</th>
                    <th>Valor total vendido</th>
                    <c:forEach items="${listaPorFilial}" var="Filial">
                    <tr>
                        <td>${Filial.ID_FIL}</td>
                        <td>${Filial.cidade}</td>
                        <td>${Filial.estado}</td>
                        <td>${Filial.endereco}</td>
                        <td>R$${Filial.v_tatal}</td>
                        <td><a class="redirect" href="RelatorioFilial?Filial=${Filial.ID_FIL},${periodo.data_inicio},${periodo.data_fim}">Detalhes</a></td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
        </c:if>
        <c:if test="${not empty listaPorFilialID}">
        <section class="lista">
            <h3>Ralatorio da Filial de ${periodo.data_inicio} a ${periodo.data_fim}</h3>
            <div class="BoxLista">
                <table>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>data de compra</th>
                    <th>Valor total vendido</th>
                    <c:forEach items="${listaPorFilialID}" var="Filial">
                    <tr>
                        <td>${Filial.nome}</td>
                        <td>${Filial.CPF}</td>
                        <td>${Filial.data_cri}</td>
                        <td>R$${Filial.v_tatal}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
        </c:if>
    </body>
</html>
