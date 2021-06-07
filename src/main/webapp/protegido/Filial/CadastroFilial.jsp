<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:if test="${empty filial}">
            <script src="../../js/jquery-3.6.0.min.js" type="text/javascript"></script>
            <link href="../../css/bootstrap.min.css" rel="stylesheet">
            <link rel="stylesheet" href="../../css/main.css">
            <link rel="shortcut icon" href="../../img/Xgeek-Icone.ico" type="image/x-icon">
            <title>Cadastro de Filial</title>
        </c:if>
        <c:if test="${not empty filial}">
            <link rel="stylesheet" href="css/main.css">
            <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
            <title>Atualização de Filial</title>
        </c:if>
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        <c:if test="${empty filial}">
            <form action="../../FilialServlet" method="POST" class="CadaEst" >
                <h3>Cadastro de Filiais</h3>
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
                        <input class="textsize" autocomplete="off" type="text" name="Complemento" placeholder="Complemento"/> 
                    </div>
                </div>
                <button class="btn_exe btnG1" type="submit">Cadastrar</button>
            </form>
        </c:if>
             <c:if test="${not empty filial}">
            <form action="AtualizarFilial" method="POST" class="CadaEst">
                <h3>Alteração de filial</h3>
                <input type="hidden" name="filialID" value="${filial.ID_filial}"/>
                <div class="textsbox inputs">
                    <div>
                        <label>Cidade</label>
                        <input class="textsize text-MB" type="text" name="Cidade" placeholder="Cidade" required="true" value="${filial.cidade}"/>
                    </div><div>
                        <label>Estado</label>
                        <input class="textsize text-MB" type="text" name="Estado" placeholder="Estado" required="true" value="${filial.estado}"/>
                    </div><div>
                        <label>CEP</label>
                        <input class="textsize text-MB" type="number" name="CEP" placeholder="CEP" required="true" value="${filial.CEP}"/>
                    </div><div>
                        <label>Endereco</label>
                        <input class="textsize text-MB" type="text" name="Endereco" placeholder="Endereco" required="true" value="${filial.endereco}"/> 
                    </div><div>
                        <label>Numero</label>
                        <input class="textsize text-MB" type="text" name="Numero" placeholder="Numero" required="true" value="${filial.numero}"/>
                    </div><div>
                        <label>Complemento</label>
                        <input class="textsize text-MB" type="text" name="Complemento" placeholder="Complemento" required="true" value="${filial.complemento}"/>
                    </div>
                </div>
                <button class="btn_exe btnG2" type="submit">Atualizar</button>
            </form>
        </c:if>
    </body>
</html>
