<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Cadastro de funcionarios</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/main.css">
    </head>
    <body> 
       <header>
            <ul id="menu-h">
                <a href="index.html" class="logo"><img src="../img/Xgeek0.png" class="logo-img"></a>
                <li><a href="index.html">Entrar</a></li>
                <li><a href="#">Sobre</a></li>
                <li><a href="#">Contato</a></li>
            </ul>
        </header>
    <c: if test="${empty funcionario}">
        <form action="../FuncionarioServlet" method="POST" class="formularioFuncionario">
            <h3>Cadastro de funcionario</h3>
            <input type="text" name="filialID" placeholder="ID Filial" required/>
            <input type="text" name="funcionarioID" placeholder="ID Funcionario" required/>
            <input type="text" name="atuacao" placeholder="Atuacao" required/>
            <input type="text" name="salario" placeholder="Salario" required/>
            <input type="password" name="senha" placeholder="Senha" required/>
            <input type="text" name="login" placeholder="Login" required/>
            <input type="text" name="nome" placeholder="Nome" required/>
            <input type="text" name="cpf" placeholder="CPF" required/>
            <input type="text" name="email" placeholder="Email" required/>
            <button id = "btnFuncCad" type="submit" name="cadastrar!!!">Cadastrar</button>
    </c:>   
    <c:if test="${not empty funcionario}">
            <form action="../AtualizarFuncionarioServlet" method="POST" class="formularioFuncionario">
            <h3>Alterar funcionario</h3>
            <input type="text" name="filialID" placeholder="ID Filial" required value="${funcionario.filialID}"/>
            <input type="text" name="funcionarioID" placeholder="ID Funcionario" required value="${funcionario.id}/>
            <input type="text" name="atuacao" placeholder="Atuacao" required value="${funcionario.atuacao}/>
            <input type="text" name="salario" placeholder="Salario" required value="${funcionario.salario}/>
            <input type="password" name="senha" placeholder="Senha" required value="${funcionario.senha}/>
            <input type="text" name="login" placeholder="Login" required value="${funcionario.login}/>
            <input type="text" name="nome" placeholder="Nome" required value="${funcionario.nome}/>
            <input type="text" name="cpf" placeholder="CPF" required value="${funcionario.cpf}/>
            <input type="text" name="email" placeholder="Email" required value="${funcionario.email}/>
            <button id = "btnFuncCad" type="submit" name="Atualizar!!!">Atualizar</button>
    </c:if>
            
            <!--<div class="botoes">
            //<button id = "btnFuncAlt" href="home.html" type="submit" name="Alterar">Alterar</button>
            <button id = "btnFuncCad" href="home.html" type="submit" name="cadastrar">Cadastrar</button>
            </div> -->
        </form>
    </body>
</html>