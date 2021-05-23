<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:if test="${empty produto}">
            <link rel="stylesheet" href="../../css/main.css">
            <title>Finalizar pedido</title>
        </c:if>
    </head>
    
    <body>
        <c:import url="../../header.jsp"/>
        
        <c:if test="${empty venda}">
            <form action="../../CadastrarVendaServlet" method="POST"ubunto class="CadaEst">
                <h3>Finalizar pedido</h3>
                <input type="hidden" name="Filial" value="${sessionScope.usuario.filialId}">
                <div class="textsbox inputs">
                    <div>
                        <label>CPF do Cliente</label>
                        <input class="textsize" type="text" name="CPF" placeholder="CPF" required="true">
                    </div><div>
                        <label>Total final</label>
                        <input class="textsize" type="text" placeholder="${sessionScope.carrinho.vendaTotal}" readonly >
                    </div>
                </div>
                <button type="submit" class="btn_exe btnCompras">Finalizar</button>
            </form>
        </c:if>
        
    </body>
</html>