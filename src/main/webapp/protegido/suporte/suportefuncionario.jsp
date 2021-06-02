<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/main.css">
        <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
        <title>Suporte ao funcionário</title>
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        <form method="POST" class="Suporte">
            <h3>Central de atendimento ao TI</h3>
            <input type="hidden" name="funcionarioID" value="${sessionScope.usuario.ID}"/>
            <input type="hidden" name="topico" value="${acao.getAcao()}"/>
            <div>
                <div>
                    <label>Assunto</label>
                    <select class="textsize" name="Assunto" placeholder="Assunto" required="true">
                        <c:if test="${acao.isApps()}">
                            <option value="Instalação">Instalação</option>
                            <option value="Suporte">Suporte</option>
                            <option value="Erro">Erro</option>
                        </c:if>
                        <c:if test="${acao.isHardware()}">
                            <option value="Instalação">Instalação</option>
                            <option value="Solicitação">Solicitação novo equipamento</option>
                            <option value="Suporte">Suporte</option>
                            <option value="Erro">Erro</option>
                        </c:if>
                        <c:if test="${acao.isWebApp()}">
                            <option value="Suporte">Suporte</option>
                            <option value="Erro">Erro</option>
                        </c:if>
                    </select>
                </div><div> 
                    <label>Descrição</label><br>
                    <textarea id="id" name="name" rows="5" cols="10"></textarea>
                </div>
            </div>
            <button class="btn_exe" type="submit">Cadastrar</button>
        </form>
    </body>
</html>