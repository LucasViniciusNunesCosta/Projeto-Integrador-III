<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Funcionários</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #563d7c;">
            <div class="container">
                <a class="navbar-brand h1 text-while" href="#">Xgeek</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                      <a class="nav-link" href="#">Contato</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="#">Sobre</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link active" href="#">Entrar</a>
                    </li>
                </div>
            </div>
        </nav>
        <section class="container">
            <div class="card mt-4">
                <div class="card-header">
                  Lista de Funcionários
                </div>
                <div class="card-body">
                    <table class="table table-striped">
                        <thead>
                          <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nome</th>
                            <th scope="col">CPF</th>
                            <th scope="col">Email</th>
                            <th scope="col">Atuação</th>
                            <th scope="col">Salário</th>
                          </tr>
                        </thead>
                        
                        <tbody>
                            <c:forEach items="${listaFuncionarios}" var="funcionario">
                            <tr>
                              <th scope="row">${funcionario.id}</th>
                              <td>${funcionario.nome}</td>
                              <td>${funcionario.cpf}</td>
                              <td>${funcionario.email}</td>
                              <td>${funcionario.atuacao}</td>
                              <td>R$ - ${funcionario.salario}</td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        
    </body>
</html>
