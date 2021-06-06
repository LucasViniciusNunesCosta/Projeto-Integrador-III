<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:if test="${empty funcionario}">
            <script src="../../js/jquery-3.6.0.min.js" type="text/javascript"></script>
            <link href="../../css/bootstrap.min.css" rel="stylesheet">
            <link rel="stylesheet" href="../../css/main.css">
            <link rel="shortcut icon" href="../../img/Xgeek-Icone.ico" type="image/x-icon">
            <title>Cadastro de Filial</title>
        </c:if>
        <c:if test="${not empty funcionario}">
            <link rel="stylesheet" href="css/main.css">
            <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
            <title>Atualização de Filial</title>
        </c:if>
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        <form action="../../FilialServlet" method="POST" class="CadaEst" onsubmit="return Confirmacao()">
                <h3>Cadastro de Filiais</h3>
                <input type="hidden" name="filialID" value="${sessionScope.usuario.filialId}"/>
                <div class="textsbox inputs">
                    <div>
                        <label>Cidade</label>
                        <input class="textsize" autocomplete="off" type="text" name="Cidade" placeholder="Cidade" required="true"/>
                    </div><div>
                        <label>Estado</label>
                        <input class="textsize" autocomplete="off" type="text" name="Estado" placeholder="Estado" required="true"/>
                    </div><div>
                        <label>CEP</label>
                        <input class="textsize" autocomplete="off" type="number" name="CEP" placeholder="CEP" required="true"/>
                    </div><div>
                        <label>Endereco</label>
                        <input class="textsize" autocomplete="off" type="text" name="Endereco" placeholder="Endereco" required="true"/>
                    </div><div>
                        <label>Numero</label>
                        <input class="textsize" autocomplete="off" type="number" name="Numero" placeholder="Numero" required="true"/>
                    </div><div>
                        <label>Complemento</label>
                        <input class="textsize" autocomplete="off" type="text" name="Complemento" placeholder="Complemento" required="true"/> 
                    </div>
                </div>
                <button class="btn_exe btnG1" type="submit">Cadastrar</button>
            </form>
    </body>
</html>
