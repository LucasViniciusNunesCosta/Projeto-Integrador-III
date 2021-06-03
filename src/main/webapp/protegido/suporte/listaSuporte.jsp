<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista do Suporte</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/main.css">
        <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        <section class="lista">
            <h3>Lista do Suporte</h3>
            <div class="BoxLista">
                <table class="ListaESTO">
                    <th>ID suporte</th>
                    <th>Topico</th>
                    <th>Assunto</th>
                    <c:forEach items="${listaSuporte}" var="Suporte">
                    <tr>
                        <td>${Suporte.ID_Requisicao}</td>
                        <td>${Suporte.topico}</td>
                        <td>${Suporte.assunto}</td>
                        <td><a class="redirect" href="Suporte?Corrente=${Suporte.ID_Requisicao}"><b>Corrente</b></a></td>
                        <c:if test="${acao.isResponder()}">
                            <td><a class="redirect" href="Suporte?ID=${Suporte.ID_Requisicao}"><b>Responder</b></a></td>
                        </c:if>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
    </body>
</html>