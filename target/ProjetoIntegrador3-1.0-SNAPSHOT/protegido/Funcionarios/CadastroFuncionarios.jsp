<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:if test="${empty funcionario}">
            <link rel="stylesheet" href="../../css/main.css">
            <title>Cadastro de funcionario</title>
        </c:if>
        <c:if test="${not empty funcionario}">
            <link rel="stylesheet" href="css/main.css">
            <title>Atualização de funcionario</title>
        </c:if>
    </head>
    <body> 
        <c:import url="../../header.jsp"/>
        
        <c:if test="${empty funcionario}">
        <form action="../FuncionarioServlet" method="POST" class="CadaEst">
            <h3>Cadastro de funcionario</h3>
            <input type="hidden" name="filialID" value="${sessionScope.usuario.filialId}"/>
            <div class="textsbox inputs">
                <div>
                    <label>Nome</label>
                    <input class="textsize" type="text" name="nome" placeholder="Nome" required="true"/>
                </div><div>
                    <label>Sobrenome</label>
                    <input class="textsize" type="text" name="sobrenome" placeholder="Sobrenome" required="true"/>
                </div><div>
                    <label>Email</label>
                    <input class="textsize" type="email" name="email" placeholder="Email" required="true"/>
                </div><div>
                    <label>CPF</label>
                    <input class="textsize" type="number" name="cpf" placeholder="CPF" required="true"/> 
                </div><div>
                    <label>Atuacao</label>
                    <input class="textsize" type="text" name="atuacao" placeholder="Atuacao" required="true"/>
                </div><div>
                    <label>Salario</label>
                    <input class="textsize" type="number" step="0.01" name="salario" placeholder="Salario" required="true"/>
                </div>
            </div>
            <button class="btn_exe btnFuncionarios" type="submit">Cadastrar</button>
        </form>
        </c:if>   
        <c:if test="${not empty funcionario}">
        <form action="AtualizarFuncionarioServlet" method="POST" class="CadaEst">
            <h3>Alterar de funcionario</h3>
            <input type="hidden" name="funcionarioID" value="${funcionario.id}"/>
            <div class="textsbox inputs">
                <div>
                    <label>ID Filial</label>
                    <input class="textsize" type="number" name="filialID" placeholder="ID Filial" required="true" value="${funcionario.filialId}"/>
                </div><div>
                    <label>Nome</label>
                    <input class="textsize" type="text" name="nome" placeholder="Nome" required="true" value="${funcionario.nome}"/>
                </div><div>
                    <label>Sobrenome</label>
                    <input class="textsize" type="text" name="sobrenome" placeholder="Sobrenome" required="true" value="${funcionario.sobrenome}"/>
                </div><div>
                    <label>Email</label>
                    <input class="textsize" type="email" name="email" placeholder="Email" required="true" value="${funcionario.email}"/>
                </div><div>
                    <label>CPF</label>
                    <input class="textsize" type="number" name="cpf" placeholder="CPF" required="true" value="${funcionario.cpf}"/> 
                </div><div>
                    <label>Atuacao</label>
                    <input class="textsize" type="text" name="atuacao" placeholder="Atuacao" required="true" value="${funcionario.atuacao}"/>
                </div><div>
                    <label>Salario</label>
                    <input class="textsize" type="number" step="0.01" name="salario" placeholder="Salario" required="true" value="${funcionario.salario}"/>
                </div>
            </div>
            <button class="btn_exe btnFuncionarios" type="submit">Atualizar</button>
        </form>
        </c:if>
    </body>
</html>