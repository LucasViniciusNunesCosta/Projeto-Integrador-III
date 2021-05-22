<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Funcionários</title>
        
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        
        <form class="lista">
            <h3>Lista de Funcionários</h3>
            <div class="BoxLista">
                <table>
                    <th>ID</th>
                    <th>ID Flial</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>CPF</th>
                    <th>Email</th>
                    <th>Atuação</th>
                    <th>Salário</th>
                    <c:forEach items="${listaFuncionarios}" var="funcionario">
                    <tr>
                        <td>${funcionario.id}</td>
                        <td>${funcionario.filialId}</td>
                        <td>${funcionario.nome}</td>
                        <td>${funcionario.sobrenome}</td>
                        <td>${funcionario.cpf}</td>
                        <td>${funcionario.email}</td>
                        <td>${funcionario.atuacao}</td>
                        <td>${funcionario.salario}</td>
                        <c:if test="${acao.atua == true}">
                        <td><a class="redirect" href="AtualizarFuncionarioServlet?ID=${funcionario.id}">Atualizar</a></td>
                        </c:if>
                        <c:if test="${acao.excl == true}">
                        <td><a onclick="Confirmacao(`${funcionario.nome}`,`${funcionario.id}`)" class="btn_Excluir">Excluir</a></td>
                        </c:if>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
        
        <script type="text/javascript">
            function Confirmacao(nome, ID){
                $("#ObjNome").html(nome);
                $("#ObjID").val(ID);
                var MC = $("#ModalConfirmacao").show();
            }
            function Cancelar(){
                $("#ModalConfirmacao").hide();
            }
            function Confirmado(){
                var ID = $("#ObjID").val();
                Cancelar();
                $.ajax("ExcluirFuncionario?ID="+ID).done(function(){
                    location.reload();
                });
            }
        </script>
        
        <!-- Modal -->
        <div class="modal fade show" id="ModalConfirmacao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content contentCustom">
              <div class="modal-header headerCustom">
                <h5 class="modal-title" id="exampleModalLabel">Confirmação de exclusão</h5>
              </div>
              <div class="modal-body">
                  <p class="modeal-text">Tem certeza que deseja excluir o Funcionários <b><label id="ObjNome"></label></b> ?</p>
                  <input type="hidden" id="ObjID"/>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btnConfirmarExclusao" onclick="Confirmado()">Sim tenho</button>
                <button type="button" class="btn btnCancelar" data-bs-dismiss="modal" onclick="Cancelar()">Cancelar</button>
              </div>
            </div>
          </div>
        </div>
        
    </body>
</html>
