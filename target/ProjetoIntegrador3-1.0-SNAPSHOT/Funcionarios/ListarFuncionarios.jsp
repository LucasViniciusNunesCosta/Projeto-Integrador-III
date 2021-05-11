<%-- 
    Document   : ListarFuncionarios
    Created on : 9 de mai de 2021, 19:21:31
    Author     : gianm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Funcionários</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js" integrity="sha384-lpyLfhYuitXl2zRZ5Bn2fqnhNAKOAaM/0Kr9laMspuaMiZfGmfwRNFh8HlMy49eQ" crossorigin="anonymous"></script>
    </head>
    <body class="container">
        <c:import url="header.jsp"/>
        <div class="card">
            <div class="card-header">
              Lista de Funcionários
            </div>
            <ul class="list-group list-group-flush">
                <table class="table table-striped">
                    <thead class="thead-dark">
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nome</th>
                        <th scope="col">CPF</th>
                        <th scope="col">Email</th>
                      </tr>
                    </thead>
                    
                    <c:forEach items="${listaFuncionarios}" var="funcionario">
                        <tbody>
                            <tr>
                              <th scope="row">${funcionario.id}</th>
                              <td>${funcionario.nome}</td>
                              <td>${funcionario.cpf}</td>
                              <td>${funcionario.email}</td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </ul>
        </div>
    </body>
</html>
