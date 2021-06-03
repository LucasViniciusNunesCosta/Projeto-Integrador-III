<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Corrente</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/main.css">
        <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        <section class="lista S-tela">
            <c:forEach items="${listaSuporte}" var="Suporte">
                <div class="S-Correntebox">
                    <p class="S-text"><b>Funcionário:</b> ${Suporte.email}</p>
                    <p class="S-text"><b>Topico:</b> ${Suporte.topico}<br><b>Assunto:</b> ${Suporte.assunto}</p><br>
                    <p class="S-text"><b>Descrição</b><br>${Suporte.descricao}</p>
                </div><br>
            </c:forEach>
        </section>
    </body>
</html>
