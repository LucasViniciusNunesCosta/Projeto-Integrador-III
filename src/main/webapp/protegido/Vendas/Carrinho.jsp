<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
        
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        <form class="lista">
            <h3>Adicionar ao carrinho</h3>
            <div class="BoxLista">
                <table class="ListaESTO">
                    <th>Nome</th>
                    <th>Marca</th>
                    <th>Categoria</th>
                    <th>Quantidade</th>
                    <th>valor</th>

                    <c:forEach items="${listaEtoqueFilial}" var="estoque">
                    <tr>
                        <td>${estoque.nome}</td>
                        <td>${estoque.marca}</td>
                        <td>${estoque.categoria}</td>
                        <td>${estoque.QTD}</td>
                        <td>${estoque.v_venda}</td>
                        <td><a onclick="Confirmacao(`${estoque.ID}`,`${estoque.QTD}`,`${estoque.nome}`)" class="redirect">Adicionar</a></td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
        
        <script type="text/javascript">
            function Confirmacao(ID, QTD, nome){
                $("#ObjNome").html(nome);
                $("#ObjQTD").val(QTD);
                $("#ObjID").val(ID);
                $("#ModalConfirmacao").show();
            }
            function Cancelar(){
                $("#ModalConfirmacao").hide();
            }
            function Confirmado(){
                var ID = $("#ObjID").val();
                var QTD = $("#ObjQTD").val();
                var QTDAdd = $("#ObjQTDAdd").val();
                if (QTD >= QTDAdd){
                    $.ajax("CarrinhoV?Item="+ID+","+QTDAdd).done(function(){
                        location.reload();
                    });
                }else{
                    alert("ERRO. quantidade solicitada maior que estoque");
                }
            }
        </script>
        
        <!-- Modal -->
        <div class="modal fade show" id="ModalConfirmacao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content contentCustom">
              <div class="modal-header headerCustom">
                <h5 class="modal-title" id="exampleModalLabel">Confirmação Adicionar</h5>
              </div>
              <div class="modal-body">
                  <p class="modeal-text">Nome do produto: <b><label id="ObjNome"></label></b><br>
                  Quantidade</p>
                  <input type="number" id="ObjQTDAdd" value="1"/>
                  <input type="hidden" id="ObjID"/>
                  <input type="hidden" id="ObjQTD"/>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btnConfirmarAdd" onclick="Confirmado()">Adicionar</button>
                <button type="button" class="btn btnCancelar" data-bs-dismiss="modal" onclick="Cancelar()">Cancelar</button>
              </div>
            </div>
          </div>
        </div>
        
    </body>
</html>
