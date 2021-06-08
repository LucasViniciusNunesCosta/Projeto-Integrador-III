<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/main.css">
        <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
        <title>Dados do Funcionario</title>
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        <form action="../../AtualizarFuncionarioDados" method="POST" class="CadaEst">
            <h3>Cadastro de funcionario</h3>
            <input type="hidden" name="funcionarioID" value="${sessionScope.usuario.ID}"/>
            <input type="hidden" name="Acao" value="Dados"/>
            <div class="textsbox inputs">
                <div>
                    <label>Nome</label>
                    <input class="textsize text-MB" type="text" name="Nome" placeholder="Nome" required="true" value="${sessionScope.usuario.nome}"/>
                </div><div>
                    <label>Sobrenome</label>
                    <input class="textsize text-MB" type="text" name="Sobrenome" placeholder="Sobrenome" required="true" value="${funcionario.sobrenome}"/>
                </div><div>
                    <label>Email</label>
                    <input class="textsize text-MB" type="email" name="Email" placeholder="Email" required="true" value="${sessionScope.usuario.email}"/>
                </div><div>
                    <label>CPF</label>
                    <input class="textsize text-MB" type="number" name="CPF" placeholder="CPF" required="true" value="${funcionario.CPF}"/> 
                </div>
            </div>
            <button class="btn_exe" type="submit">Atualizar</button>
        </form>
    </body>
</html>
