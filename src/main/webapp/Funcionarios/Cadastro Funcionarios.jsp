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
        
        <c:if test="${empty funcionario}">
        <form action="../FuncionarioServlet" method="POST" class="CadaEst">
            <h3>Cadastro de funcionario</h3>
            <div class="textsbox inputs">
                <div>
                    <label>ID Filial</label>
                    <input type="number" name="filialID" placeholder="ID Filial" required/>
                </div><div>
                    <label>ID Funcionario</label>
                    <input type="number" name="funcionarioID" placeholder="ID Funcionario" required/>
                </div><div>
                    <label>Atuacao</label>
                    <input type="text" name="atuacao" placeholder="Atuacao" required/>
                </div><div>
                    <label>Salario</label>
                    <input type="number" step="0.01" name="salario" placeholder="Salario" required/>
                </div><div>
                    <label>Senha</label>
                    <input type="password" name="senha" placeholder="Senha" required/>
                </div><div>
                    <label>Login</label>
                    <input type="text" name="login" placeholder="Login" required/>
                </div><div>
                    <label>Nome</label>
                    <input type="text" name="nome" placeholder="Nome" required/>
                </div><div>
                    <label>CPF</label>
                    <input type="number" name="cpf" placeholder="CPF" required/>
                </div><div>
                    <label>Email</label>
                    <input type="email" name="email" placeholder="Email" required/>
                </div>
            </div>
            <button class="btn_exe btnFuncionarios" type="submit" name="cadastrar!!!">Cadastrar</button>
        </form>
        </c:if>   
        <c:if test="${not empty funcionario}">
        <form action="../AtualizarFuncionarioServlet" method="POST" class="CadaEst">
            <h3>Alterar de funcionario</h3>
            <div class="textsbox inputs">
                <div>
                    <label>ID Filial</label>
                    <input type="number" name="filialID" placeholder="ID Filial" required value="${funcionario.filialID}"/>
                </div><div>
                    <label>ID Funcionario</label>
                    <input type="number" name="funcionarioID" placeholder="ID Funcionario" required value="${funcionario.id}"/>
                </div><div>
                    <label>Atuacao</label>
                    <input type="text" name="atuacao" placeholder="Atuacao" required value="${funcionario.atuacao}"/>
                </div><div>
                    <label>Salario</label>
                    <input type="number" step="0.01" name="salario" placeholder="Salario" required value="${funcionario.salario}"/>
                </div><div>
                    <label>Senha</label>
                    <input type="password" name="senha" placeholder="Senha" required value="${funcionario.senha}"/>
                </div><div>
                    <label>Login</label>
                    <input type="text" name="login" placeholder="Login" required value="${funcionario.login}"/>
                </div><div>
                    <label>Nome</label>
                    <input type="text" name="nome" placeholder="Nome" required value="${funcionario.nome}"/>
                </div><div>
                    <label>CPF</label>
                    <input type="number" name="cpf" placeholder="CPF" required value="${funcionario.cpf}"/>
                </div><div>
                    <label>Email</label>
                    <input type="email" name="email" placeholder="Email" required value="${funcionario.email}"/>
                </div>
            </div>
            <button class="btn_exe btnFuncionarios" type="submit" name="Atualizar!!!">Atualizar</button>
        </form>
        </c:if>
    </body>
</html>