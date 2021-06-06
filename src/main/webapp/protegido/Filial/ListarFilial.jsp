<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de filial</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/main.css">
        <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        
        <section class="lista">
            <h3>Lista de Filiais</h3>
            <div>
                <form class="Buscarbox" action="listeFilial" method="POST">
                    <input class="textsize Buscar-text" type="text" name="Endereco" placeholder="Endereco">
                    <input type="hidden" name="send" value="${acao.getAcaoList()}">
                    <button class="Buscar-btn btnG2">Buscar</button>
                </form>
            </div>
            <div class="BoxLista">
                <table>
                    <th>ID Filial</th>
                    <th>Cidade</th>
                    <th>Estado</th>
                    <th>CEP</th>
                    <th>Endereco</th>
                    <th>Numero</th>
                    <th>Complemento</th>
                    <c:forEach items="${listaFiliais}" var="filial">
                    <tr>
                        <td>${filial.ID_filial}</td>
                        <td>${filial.cidade}</td>
                        <td>${filial.estado}</td>
                        <td>${filial.CEP}</td>
                        <td>${filial.endereco}</td>
                        <td>${filial.numero}</td>
                        <td>${filial.complemento}</td>
                        <c:if test="${acao.atua == true}">
                        <td><a class="redirect" href="AtualizarFilialServlet?ID=${filial.ID_filial}">Atualizar</a></td>
                        </c:if>
                        <c:if test="${acao.excl == true}">
                        <td><a class="redirect btn_Excluir" onclick="Confirmacao(`${filial.endereco}`,`${filial.ID_filial}`)">Excluir</a></td>
                        </c:if>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
        
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
                $.ajax("ExcluirFilial?ID="+ID).done(function(){
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
                  <p class="modeal-text">Tem certeza que deseja excluir a filial? <b><label id="ObjNome"></label></b> ?</p>
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
