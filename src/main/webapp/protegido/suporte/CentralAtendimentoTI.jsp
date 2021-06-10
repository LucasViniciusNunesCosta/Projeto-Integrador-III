<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/main.css">
        <link rel="shortcut icon" href="../../img/Xgeek-Icone.ico" type="image/x-icon">
        <title>Central de atendimento TI</title>
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        
        <section class="container ti">
            <article>
                <a href="../../Suporte?send=Apps">
                    <div>
                        <h3>Aplicativos e Software</h3><br>
                        <p>Tudo o que você precisa para trabalhar!<br>
                            Instalação e suporte de Word, Excel, navegadores e outros.
                        </p>
                        <br>
                    </div>
                </a>
            </article>
            <article>
                <a href="../../Suporte?send=Hardware">
                    <div>
                        <h3>Equipamentos e Periféricos</h3><br>
                        <p>A máquina não está ajudando?<br>
                            Computadores, impressoras, monitores e outros equipamentos que deveriam funcionar.
                        </p>
                        <br>
                    </div>
                </a>
            </article>
            <article>
                <a href="../../Suporte?send=WebApp">
                    <div>
                        <h3>Sistema Institucional</h3><br>
                        <p>Todos os sistemas que você acessa pelo Xgeek.<br>
                            Indisponibilidade, erros ou configurações nos sistemas.
                        </p>
                        <br>
                    </div>
                </a>
            </article>
            <article>
                <a href="../../Suporte?send=Atualizar">
                    <div>
                        <h3>Seus dados</h3><br>
                        <p>Problemas com a sua conta?<br>
                            Dúvidas, Problemas com login, Atualizar os seus dados e Mudar A senha
                        </p>
                    </div>
                </a>
            </article>
        </section>
    </body>
</html>
