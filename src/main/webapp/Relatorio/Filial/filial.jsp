<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório por Filial</title>
        <link rel="stylesheet" href="../../css/main.css">
        <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    </head>
    <body>
        <header>
            <ul id="menu-h">
                <a href="home.html" class="logo">
                    <img src="../../img/Xgeek_branco.png" class="logo-img">
                </a>
                <li><a href="index.html">Entrar</a></li>
                <li><a href="#">Sobre</a></li>
                <li><a href="#">Contato</a></li>
            </ul>
        </header>
                
        <form action="../../RelatorioFilial" method="POST"ubunto class="CadaCli">
            <h3>Relatório por Filial</h3>
            <div class="textsbox">
                <input type="date" name="inicio" required="true">
                <input type="date" name="fim" required="true">
                <input type="text" name="id" placeholder="ID da filial">
            </div>
            <button type="submit" class="btn_exe">Buscar</button>
        </form>
    </body>
</html>
