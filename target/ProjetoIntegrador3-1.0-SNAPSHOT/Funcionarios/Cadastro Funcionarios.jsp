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
            
            
            <!--<div class="botoes">
            //<button id = "btnFuncAlt" href="home.html" type="submit" name="Alterar">Alterar</button>
            <button id = "btnFuncCad" href="home.html" type="submit" name="cadastrar">Cadastrar</button>
            </div> -->
        </form>
    </body>
</html>