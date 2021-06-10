<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suporte Resposta</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/main.css">
        <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        <section class="lista S-tela">
            <div>
                <div>
                    <p class="S-text"><b>Funcionário:</b> ${Requisicao.email}</p>
                    <p class="S-text"><b>Topico:</b> ${Requisicao.topico}<br><b>Assunto:</b> ${Requisicao.assunto}</p><br>
                    <p class="S-text"><b>Descrição</b><br>${Requisicao.descricao}</p>
                    <c:if test="${!Requisicao.isResposta()}">
                        <button id="btnS" class="S-btn">Responder</button>
                    </c:if>
                </div>
                <div id="Menu" class="S-responde">
                    <form action="SuporteDevolutiva" method="POST" class="S-form">
                        <input type="hidden" name="funcionarioID" value="${sessionScope.usuario.ID}"/>
                        <input type="hidden" name="referencia" value="${Requisicao.ID_Requisicao}"/>
                        <label>Status da requisição</label><br>
                        <select class="textsize S-select" name="Status" placeholder="Assunto" required="true">
                            <option value="Progresso">em Progresso</option>
                            <option value="Finalizar">Finalizar</option>
                        </select>
                        <br>
                        <label>Responder</label><br>
                        <textarea id="id" class="Suporte-textarea" name="descricao" rows="5" cols="10"></textarea>
                        <button type="submit" class="S-btn">Enviar</button>
                    </form>
                </div>
            </div>
        </section>
        <script src="js/Suporte.js" type="text/javascript"></script>
    </body>
</html>
