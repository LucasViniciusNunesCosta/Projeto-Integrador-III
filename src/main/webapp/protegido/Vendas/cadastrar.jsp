<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../../css/main.css">
        <link rel="shortcut icon" href="../../img/Xgeek-Icone.ico" type="image/x-icon">
        <title>Finalizar pedido</title>

    </head>
    
    <body>
        <c:import url="../../header.jsp"/>
        
        <form action="../../CadastrarVendaServlet" method="POST" class="CadaCli">
            <h3>Finalizar pedido</h3>
            <input type="hidden" name="Filial" value="${sessionScope.usuario.filialId}">
            <div class="textsbox inputs">
                <div>
                    <label>CPF do Cliente</label>
                    <input class="textsize text-MB" type="text" name="CPF" placeholder="CPF" required="true">
                </div><div>
                    <label>Total final</label>
                    <input class="textsize text-MB" type="text" placeholder="${sessionScope.carrinho.vendaTotal}" readonly >
                </div>
            </div>
            <button type="submit" class="btn_exe btnG4">Finalizar</button>
        </form>
        
    </body>
</html>