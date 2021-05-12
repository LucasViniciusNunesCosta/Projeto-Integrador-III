<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/main.css">
    </head>
    <body>
        <header>
            <ul id="menu-h">
                <a href="home.html" class="logo">
                    <img src="../img/Xgeek_branco.png" class="logo-img">
                </a>
                <li><a href="index.html">Entrar</a></li>
                <li><a href="#">Sobre</a></li>
                <li><a href="#">Contato</a></li>
            </ul>
        </header>
                
        <form action="../RelatorioClientes" method="POST"ubunto class="CadaCli">
            <h3>Cadastro de Cliente</h3>
            <div class="textsbox">
                <input type="date" name="inicio" required="true">
                <input type="date" name="fim" required="true">
                <input type="text" name="ID" placeholder="ID do Cliente">
            </div>
            <button type="submit" class="btn_exe">Cadastro</button>
        </form>
    </body>
</html>
